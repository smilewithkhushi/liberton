package com.example.studentportalloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpPage extends AppCompatActivity {
    private EditText mEmailEditText;
    private EditText mPhoneEditText;
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mSignupButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        mEmailEditText = findViewById(R.id.inputEmail);
        mPhoneEditText = findViewById(R.id.inputPhone);
        mUsernameEditText = findViewById(R.id.inputUsername);
        mPasswordEditText = findViewById(R.id.inputPassword);
        mSignupButton = findViewById(R.id.signup_btn);

        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEditText.getText().toString();
                String phone = mPhoneEditText.getText().toString();
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                if (email.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignUpPage.this, "Enter valid details", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUpPage.this, task -> {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(username)
                                            .build();

                                    user.updateProfile(profileUpdates)
                                            .addOnCompleteListener(task1 -> {
                                                if (task1.isSuccessful()) {
                                                    Toast.makeText(SignUpPage.this, "User account created successfully", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                } else {
                                    Toast.makeText(SignUpPage.this, "Error creating user account", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
    }

    public void openLogin(View v){
        Toast.makeText(this, "Moving to Login page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}