package com.example.studentportalloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    EditText username;
    public static final String EXTRA_NAME="androidx.appcompat.app.AppCompatActivity.username";


    //OPENS THE USER DASHBOARD AND DISPLAYS THE USER NAME WITH A MESSAGE FOR USER
    public void openDashboard(View v){
        Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show();
        username=findViewById(R.id.inputUsername);
        String nameText=username.getText().toString();

        Intent intent = new Intent(this, dashboard.class);
        intent.putExtra(EXTRA_NAME, nameText);
        startActivity(intent);
    }

    //OPENS THE SIGNUP PAGE
    public void openSignup(View v){
        Toast.makeText(this, "Moving to SignUp page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }

}