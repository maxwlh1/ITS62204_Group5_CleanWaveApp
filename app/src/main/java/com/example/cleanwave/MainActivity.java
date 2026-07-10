package com.example.cleanwave;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Retrieve the role passed from LoginActivity
            Intent intent = getIntent();
            String role = intent.getStringExtra("ROLE");

            Fragment selectedFragment;

            // Decide which dashboard to load
            if ("Organization".equals(role)) {
                selectedFragment = new OrgHomeFragment();
            } else {
                // Default to UserHomeFragment
                selectedFragment = new UserHomeFragment();
            }

            // Load the chosen fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
        }
    }
}