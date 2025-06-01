package com.example.flagquizapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class GeneralKnowledgeActivity extends AppCompatActivity {

    private QuizDatabaseHelper dbHelper;
    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knowledge);

        dbHelper = new QuizDatabaseHelper(this);
        questionList = dbHelper.getQuestionsByCategory("general_knowledge");

        if (questionList == null || questionList.isEmpty()) {
            Toast.makeText(this, "Veri bulunamadı!", Toast.LENGTH_SHORT).show();
            return;
        }

        for (Question q : questionList) {
            Log.d("QUIZ", "Soru: " + q.getQuestion());
        }

        Toast.makeText(this, "Soru sayısı: " + questionList.size(), Toast.LENGTH_SHORT).show();
    }
}
