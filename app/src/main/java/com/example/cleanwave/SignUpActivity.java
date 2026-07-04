package com.example.cleanwave;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        MaterialButton btnSignUpDone = findViewById(R.id.btnSignUpDone);

        btnSignUpDone.setOnClickListener(v -> {
            Toast.makeText(this, "Account Created! Please Log In.", Toast.LENGTH_SHORT).show();
            finish(); // Sends user back to the Login screen
        });
    }
}