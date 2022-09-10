package com.example.simpleregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.textfield.*;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {

    // creating global view objects
    private TextInputLayout fullNameInputLayout, emailInputLayout, passwordInputLayout;
    private TextInputEditText fullNameEditText, emailEditText, passwordEditText;
    private Button submitButton;

    // creating global String variables
    // to hold the inputted values
    private String full_name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initializeViews();

        fullNameEditText.requestFocus();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatingEmptyInputs();
            }
        });

    }

    private void validatingEmptyInputs() {
        // holding inputted data into String variables
        full_name = Objects.requireNonNull(fullNameEditText.getText()).toString();
        email = Objects.requireNonNull(emailEditText.getText()).toString();
        password = Objects.requireNonNull(passwordEditText.getText()).toString();

        // checking if the inputted data
        // is empty to show error message
        displayErrorMessage(full_name, fullNameInputLayout, "Enter your full name", fullNameEditText);
        displayErrorMessage(email, emailInputLayout, "Enter your email", emailEditText);
        displayErrorMessage(password, passwordInputLayout, "Enter your password", passwordEditText);
    }

    private void displayErrorMessage(String input, TextInputLayout inputLayout, String errorMessage, TextInputEditText inputEditText){
        if (input.isEmpty()){
            inputLayout.setError(errorMessage);
            inputEditText.requestFocus();
        }
    }

    private void initializeViews() {
        fullNameInputLayout = findViewById(R.id.textInput_full_name);
        emailInputLayout = findViewById(R.id.textInput_email);
        passwordInputLayout = findViewById(R.id.textInput_password);
        fullNameEditText = findViewById(R.id.editText_full_name);
        emailEditText = findViewById(R.id.editText_email);
        passwordEditText = findViewById(R.id.editText_password);
        submitButton = findViewById(R.id.submit_btn);
    }
}