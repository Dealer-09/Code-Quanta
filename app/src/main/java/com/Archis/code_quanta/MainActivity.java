package com.Archis.code_quanta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar = findViewById(R.id.toolbar);
    }

    public void java(View view) {
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("language", "Java");
        startActivity(intent);
        finish();
    }

    public void kotlin(View view) {
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("language", "Kotlin");
        startActivity(intent);
        finish();
    }

    public void python(View view) {
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("language", "Python");
        startActivity(intent);
        finish();
    }

    public void javascript(View view) {
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("language", "JavaScript");
        startActivity(intent);
        finish();
    }

    public void c(View view) {
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("language", "C");
        startActivity(intent);
        finish();
    }

    public void cpp(View view) {
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("language", "C++");
        startActivity(intent);
        finish();
    }

    public void dart(View view) {
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("language", "Dart");
        startActivity(intent);
        finish();
    }

    public void rust(View view) {
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("language", "Rust");
        startActivity(intent);
        finish();
    }
}