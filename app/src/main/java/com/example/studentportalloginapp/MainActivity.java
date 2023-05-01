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

public class MainActivity extends AppCompatActivity {


    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        mEmailEditText = findViewById(R.id.inputUsernameEmail);
        mPasswordEditText = findViewById(R.id.inputPassword);
        mLoginButton = findViewById(R.id.login);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter valid details", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, task -> {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startActivity(new Intent(MainActivity.this, StaffDashboardActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
    }

    EditText username;
    public static final String EXTRA_NAME="androidx.appcompat.app.AppCompatActivity.username";


    //OPENS THE USER DASHBOARD AND DISPLAYS THE USER NAME WITH A MESSAGE FOR USER
    public void openStaffDashboard(View v){
        Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show();
        username=findViewById(R.id.inputUsername);
        String nameText=username.getText().toString();

        Intent intent = new Intent(this, StaffDashboardActivity.class);
        intent.putExtra(EXTRA_NAME, nameText);
        startActivity(intent);
    }

    //OPENS THE SIGNUP PAGE
    public void openSignup(View v){
        Toast.makeText(this, "Moving to Sign Up page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }

}