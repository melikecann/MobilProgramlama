package com.example.flagquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MapQuizSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_map_quiz_selection)
        val btnTurkeyMapQuiz = findViewById<Button>(R.id.btnTurkeyMapQuiz)
        val btnWorldMapQuiz = findViewById<Button>(R.id.btnWorldMapQuiz)

        btnTurkeyMapQuiz.setOnClickListener {
            startActivity(Intent(this, MapQuizSelectionActivity::class.java).putExtra("quizType", "turkey"))
        }

        btnWorldMapQuiz.setOnClickListener {
            startActivity(Intent(this, MapQuizSelectionActivity::class.java).putExtra("quizType", "world"))
        }
    }
}