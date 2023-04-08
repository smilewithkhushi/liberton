package com.example.studentportalloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDashboard(View v){
        Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }

    public void openSignup(View v){
        Toast.makeText(this, "Moving to SignUp page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }

}