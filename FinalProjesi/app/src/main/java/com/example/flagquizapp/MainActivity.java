package com.example.flagquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flagquizapp.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button flagQuizBtn = findViewById(R.id.flagQuizButton);
        Button capitalQuizBtn = findViewById(R.id.capitalQuizButton);
        Button generalKnowledgeBtn = findViewById(R.id.generalKnowledgeButton);
        Button mapQuizBtn = findViewById(R.id.mapQuizButton);

        flagQuizBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("category", "flags_1bayrak4ulke"); // ← Veritabanındaki kategoriyle birebir aynı olmalı
            startActivity(intent);
        });

        capitalQuizBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("category", "capitals");
            startActivity(intent);
        });

        generalKnowledgeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("category", "general_knowledge");
            startActivity(intent);
        });

        mapQuizBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("category", "map_quiz");
            startActivity(intent);
        });
    }
}
