package com.example.simpleregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.*;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {

    // creating global view objects
    private TextInputEditText edtFUllName, edtEmail, edtPassword;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initializeViews();

        edtFUllName.requestFocus();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String full_name, email, password;
                full_name = Objects.requireNonNull(edtFUllName.getText()).toString();
                email = Objects.requireNonNull(edtEmail.getText()).toString();
                password = Objects.requireNonNull(edtPassword.getText()).toString();
                if (full_name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    showErrorMessage(v);
                }
            }
        });

    }

    private void showErrorMessage(View view) {
        Snackbar.make(view, "Please fill the blanks", Snackbar.LENGTH_LONG).show();
    }

    private void initializeViews() {
        edtFUllName = findViewById(R.id.edt_full_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_pasword);
        mSubmitButton = findViewById(R.id.submit_btn);
    }
}