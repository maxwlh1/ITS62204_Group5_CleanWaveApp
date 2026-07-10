package com.example.cleanwave;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        MaterialButton btnSignUpDone = findViewById(R.id.btnSignUpDone);
        MaterialButtonToggleGroup toggleGroup = findViewById(R.id.toggleRoleSignup); // Matches ID in XML

        btnSignUpDone.setOnClickListener(v -> {
            // Determine which role they selected for account creation
            int selectedId = toggleGroup.getCheckedButtonId();
            String role = (selectedId == R.id.btnToggleOrg) ? "Organization" : "User";

            Toast.makeText(this, role + " Account Created! Please Log In.", Toast.LENGTH_LONG).show();
            finish(); // Sends user back to the Login screen
        });
    }
}