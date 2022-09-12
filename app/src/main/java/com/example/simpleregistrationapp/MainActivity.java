package com.example.simpleregistrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView fullNameTextView, emailTextView;
    private ImageView backArrowImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        viewData();

        backArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegistrationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }

    private void initializeViews() {
        fullNameTextView = findViewById(R.id.full_name_text_view);
        emailTextView = findViewById(R.id.email_text_view);
        backArrowImageView = findViewById(R.id.back_arrow);

    }

    private void viewData() {
        Intent intent = getIntent();

        fullNameTextView.setText(intent.getStringExtra(RegistrationActivity.FULL_NAME));
        emailTextView.setText(intent.getStringExtra(RegistrationActivity.EMAIL));
    }
}