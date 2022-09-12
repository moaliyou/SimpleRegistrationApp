package com.example.simpleregistrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    static final String EMAIL = "email";
    static final String FULL_NAME = "full_name";
    static final String PASSWORD = "password";
    private final String EMPTY_ERROR_MESSAGE = "Field must be filled";
    private final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{8,}" +               //at least 8 characters
            "$");

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

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFullNameValid() | !isEmailValidate() | !isPasswordValid())
                    return;

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra(FULL_NAME, full_name);
                intent.putExtra(EMAIL, email);
                startActivity(intent);
            }
        });

    }

    private boolean isPasswordValid() {
        password = Objects.requireNonNull(passwordEditText.getText()).toString();
        if (password.isEmpty()) {
            passwordInputLayout.setError(EMPTY_ERROR_MESSAGE);
            return false;
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            passwordInputLayout.setError("Password too weak");
            return false;
        } else {
            passwordInputLayout.setError(null);
            passwordInputLayout.setErrorEnabled(false);
            return true;
        }
    }

    private boolean isFullNameValid() {
        full_name = Objects.requireNonNull(fullNameEditText.getText()).toString();
        if (full_name.isEmpty()) {
            fullNameInputLayout.setError(EMPTY_ERROR_MESSAGE);
            return false;
        } else {
            fullNameInputLayout.setError(null);
            fullNameInputLayout.setErrorEnabled(false);
            return true;
        }
    }

    private boolean isEmailValidate() {
        email = Objects.requireNonNull(emailEditText.getText()).toString();
        if (email.isEmpty()) {
            emailInputLayout.setError(EMPTY_ERROR_MESSAGE);
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInputLayout.setError("Please enter a valid email");
            return false;
        } else {
            emailInputLayout.setError(null);
            emailInputLayout.setErrorEnabled(false);
            return true;
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