package com.example.cleanwave;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
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

        // Hardcoded Login Logic
        btnDone.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.equals("user") && password.equals("123")) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                // Send user to the Main Dashboard
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Prevents user from going back to login screen using back button
            } else {
                Toast.makeText(this, "Invalid Credentials. Try user / 123", Toast.LENGTH_LONG).show();
            }
        });

        // Navigate to Sign Up
        tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}