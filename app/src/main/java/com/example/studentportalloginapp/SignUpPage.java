package com.example.studentportalloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
    }

    public void openLogin(View v){
        Toast.makeText(this, "Moving to SignUp page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
    public void newSignup(View v){
        Toast.makeText(this, "Signing you in!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }

}