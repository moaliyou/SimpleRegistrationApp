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
    private TextInputLayout mFullNameLayout, mEmailLayout, mPasswordLayout;
    private TextInputEditText edtFUllName, edtEmail, edtPassword;
    private Button mSubmitButton;

    // creating global String variables
    // to hold the inputted values
    private String full_name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initializeViews();

        edtFUllName.requestFocus();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatingEmptyInputs();
            }
        });

    }

    private void validatingEmptyInputs() {
        // holding inputted data into String variables
        full_name = Objects.requireNonNull(edtFUllName.getText()).toString();
        email = Objects.requireNonNull(edtEmail.getText()).toString();
        password = Objects.requireNonNull(edtPassword.getText()).toString();

        // checking if the inputted data
        // is empty to show error message
        if (full_name.isEmpty()){
            mFullNameLayout.setError("Enter your name");
            edtFUllName.requestFocus();
        } else if (email.isEmpty()){
            mEmailLayout.setError("Enter your email");
            edtEmail.requestFocus();
        } else {
            mPasswordLayout.setError("Enter strong password");
            edtPassword.requestFocus();
        }
    }

    private void showErrorMessage(View view) {
        Snackbar.make(view, "Please fill the blanks", Snackbar.LENGTH_LONG).show();
    }

    private void initializeViews() {
        mFullNameLayout = findViewById(R.id.tfFullName);
        mEmailLayout = findViewById(R.id.tfEmail);
        mPasswordLayout = findViewById(R.id.tfPassword);
        edtFUllName = findViewById(R.id.edt_full_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_pasword);
        mSubmitButton = findViewById(R.id.submit_btn);
    }
}