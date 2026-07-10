package com.example.cleanwave;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText etEmail = findViewById(R.id.etEmail);
        TextInputEditText etPassword = findViewById(R.id.etPassword);
        MaterialButton btnDone = findViewById(R.id.btnDone);
        TextView tvSignUp = findViewById(R.id.tvSignUp);
        MaterialButtonToggleGroup toggleRoleLogin = findViewById(R.id.toggleRoleLogin);

        // Hardcoded Role-Based Login Logic
        btnDone.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Check which role is selected
            int selectedId = toggleRoleLogin.getCheckedButtonId();
            boolean isUserSelected = (selectedId == R.id.btnToggleUserLogin);

            if (isUserSelected) {
                // Validate Normal User
                if (email.equals("user") && password.equals("123")) {
                    Toast.makeText(this, "Logged in as User!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "User Login Failed. Try user / 123", Toast.LENGTH_LONG).show();
                }
            } else {
                // Validate Organization
                if (email.equals("org") && password.equals("123")) {
                    Toast.makeText(this, "Logged in as Organization!", Toast.LENGTH_SHORT).show();

                    // Note: Right now this goes to the same MainActivity.
                    // To get full marks later, you can route this to an "OrgMainActivity.class" instead!
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Org Login Failed. Try org / 123", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Navigate to Sign Up
        tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}