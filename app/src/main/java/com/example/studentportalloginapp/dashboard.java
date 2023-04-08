package com.example.studentportalloginapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {

    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        welcomeText = findViewById(R.id.welcomeMsg);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        welcomeText.setText("" + name);

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }
    public void logout() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(dashboard.this);
        alertDialog.setTitle("Logout"); // Sets title for your alertbox
        alertDialog.setMessage("Are you sure you want to Logout ?"); // Message to be displayed on alertbox
        alertDialog.setIcon(R.drawable.logout1); // Icon for your alertbox

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Toast.makeText(dashboard.this, "Successfully Logged Out", Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
};