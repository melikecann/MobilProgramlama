package com.example.flagquizapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    QuizDatabaseHelper dbHelper;
    List<Question> questionList;
    int currentQuestionIndex = 0;

    TextView quizTitle, questionText;
    ImageView questionImage;
    Button option1, option2, option3, option4;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quizTitle = findViewById(R.id.quizTitle);
        questionText = findViewById(R.id.questionText);
        questionImage = findViewById(R.id.questionImage);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        dbHelper = new QuizDatabaseHelper(this);
        category = getIntent().getStringExtra("category");
        if (category == null) category = "general_knowledge";

        quizTitle.setText(getCategoryTitle(category));

        questionList = dbHelper.getQuestionsByCategory(category);
        Log.d("QuizDebug", "Soru sayısı: " + questionList.size());

        Collections.shuffle(questionList);

        if (questionList.isEmpty()) {
            Toast.makeText(this, "Veri bulunamadı!", Toast.LENGTH_LONG).show();
            return;
        }

        showNextQuestion();

        option1.setOnClickListener(v -> checkAnswer(option1.getText().toString()));
        option2.setOnClickListener(v -> checkAnswer(option2.getText().toString()));
        option3.setOnClickListener(v -> checkAnswer(option3.getText().toString()));
        option4.setOnClickListener(v -> checkAnswer(option4.getText().toString()));
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question q = questionList.get(currentQuestionIndex);
            questionText.setText(q.getQuestion());

            List<String> options = q.getOptions();
            if (options.size() >= 4) {
                option1.setText(options.get(0));
                option2.setText(options.get(1));
                option3.setText(options.get(2));
                option4.setText(options.get(3));
            }

            // Görsel varsa göster
            if (usesImage(category)) {
                if (q.getImage() != null && !q.getImage().isEmpty()) {
                    int resId = getResources().getIdentifier(q.getImage(), "drawable", getPackageName());
                    if (resId != 0) {
                        questionImage.setImageResource(resId);
                        questionImage.setVisibility(ImageView.VISIBLE);
                    } else {
                        Log.e("QuizDebug", "Görsel bulunamadı: " + q.getImage());
                        questionImage.setVisibility(ImageView.GONE);
                    }
                } else {
                    questionImage.setVisibility(ImageView.GONE);
                }
            } else {
                questionImage.setVisibility(ImageView.GONE);
            }

        } else {
            Toast.makeText(this, "Tüm sorular tamamlandı!", Toast.LENGTH_LONG).show();
            // İsteğe bağlı sonuç ekranı
        }
    }

    private void checkAnswer(String selectedOption) {
        Question current = questionList.get(currentQuestionIndex);
        if (selectedOption.equals(current.getAnswer())) {
            Toast.makeText(this, "Doğru!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Yanlış! Doğru cevap: " + current.getAnswer(), Toast.LENGTH_SHORT).show();
        }
        currentQuestionIndex++;
        showNextQuestion();
    }

    private boolean usesImage(String category) {
        return category.equalsIgnoreCase("flags_1bayrak4ulke") ||
                category.equalsIgnoreCase("map_quiz") ||
                category.equalsIgnoreCase("flags_4ulke1bayrak");
    }

    private String getCategoryTitle(String key) {
        switch (key) {
            case "flags_1bayrak4ulke":
                return "Bayrak Quiz (1 Bayrak 4 Ülke)";
            case "flags_4ulke1bayrak":
                return "Bayrak Quiz (1 Ülke 4 Bayrak)";
            case "capitals":
                return "Başkent Quiz";
            case "map_quiz":
                return "Harita Quiz";
            case "general_knowledge":
                return "Genel Kültür Quiz";
            default:
                return "Quiz";
        }
    }
}
