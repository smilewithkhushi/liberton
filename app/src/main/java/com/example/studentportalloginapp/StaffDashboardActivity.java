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

import org.w3c.dom.Text;

public class StaffDashboardActivity extends AppCompatActivity {

    TextView receiver_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_dashboard);

        receiver_msg = findViewById(R.id.welcomeMsg);
        Intent intent = getIntent();
        String str = intent.getStringExtra(MainActivity.EXTRA_NAME);
        receiver_msg.setText(" "+str);
    }

    public static final String USER_PROFILE="androidx.appcompat.app.AppCompatActivity.userprofile";
    public void openUserProfile(View v){
        Toast.makeText(this, "Opening your profile", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, UserprofileActivity.class);
        startActivity(intent);
    }

    public void logout() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(StaffDashboardActivity.this);
        alertDialog.setTitle("Logout"); // Sets title for your alertbox
        alertDialog.setMessage("Are you sure you want to Logout ?"); // Message to be displayed on alertbox
        alertDialog.setIcon(R.drawable.logout1); // Icon for your alertbox

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Toast.makeText(StaffDashboardActivity.this, "Successfully Logged Out", Toast.LENGTH_LONG).show();
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