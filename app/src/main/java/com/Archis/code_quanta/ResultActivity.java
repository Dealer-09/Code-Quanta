package com.Archis.code_quanta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class ResultActivity extends AppCompatActivity {
    TextView correct, wrong, total, result;
    Button home;
    CircularProgressIndicator progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        correct = findViewById(R.id.correct);
        wrong = findViewById(R.id.wrong);
        total = findViewById(R.id.total);
        home = findViewById(R.id.home);
        result = findViewById(R.id.result);
        progressBar = findViewById(R.id.circularProgressbar);

        // Get data from Intent
        Intent intent = getIntent();
        int attempted = intent.getIntExtra("attempted", 0);
        int correctAnswers = intent.getIntExtra("correct", 0);
        int wrongAnswers = intent.getIntExtra("wrong", 0);

        // Calculate percentage
        int percentage = attempted > 0 ? (correctAnswers * 100) / attempted : 0;

        // Set progress bar
        progressBar.setMax(100);
        progressBar.setProgress(percentage);

        // Set text values with proper formatting
        correct.setText(String.valueOf(correctAnswers));
        wrong.setText(String.valueOf(wrongAnswers));
        total.setText(String.valueOf(attempted));
        result.setText(percentage + "%");

        // Home button click listener
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Reset static variables
                QuestionActivity.correct = 0;

                // Go back to MainActivity
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finishAffinity();
            }
        });
    }
}