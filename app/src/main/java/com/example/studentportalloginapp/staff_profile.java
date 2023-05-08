package com.example.studentportalloginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class staff_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_profile);
    }

    private void logoutUser() {
        FirebaseAuth.getInstance().signOut(); // Sign out the user from Firebase
        // TODO: Add any additional logic to clear user data or reset the UI
    }

}