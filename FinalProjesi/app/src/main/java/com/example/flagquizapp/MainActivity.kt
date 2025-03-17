package com.example.flagquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // enableEdgeToEdge()'i kaldırabiliriz

        // Butonları tanımlayalım
        val btnFlagQuiz = findViewById<Button>(R.id.btnFlagQuiz)
        val btnGeneralKnowledge = findViewById<Button>(R.id.btnGeneralKnowledge)
        val btnMapQuiz = findViewById<Button>(R.id.btnMapQuiz)
        val btnCapitalQuiz = findViewById<Button>(R.id.btnCapitalQuiz)

        // Ülke Bayrak Eşleştirme tıklandığında yeni ekrana geçiş
        btnFlagQuiz.setOnClickListener {
            startActivity(Intent(this, FlagQuizSelectionActivity::class.java))
        }

        // Genel Kültür quizi doğrudan başlatılacak
        btnGeneralKnowledge.setOnClickListener {
            startActivity(Intent(this, GeneralKnowledgeQuizActivity::class.java))
        }

        // Harita Quiz ekranına geçiş
        btnMapQuiz.setOnClickListener {
            startActivity(Intent(this, MapQuizSelectionActivity::class.java))
        }

        // Başkent Quiz ekranına geçiş
        btnCapitalQuiz.setOnClickListener {
            startActivity(Intent(this, CapitalQuizSelectionActivity::class.java))
        }
    }
}