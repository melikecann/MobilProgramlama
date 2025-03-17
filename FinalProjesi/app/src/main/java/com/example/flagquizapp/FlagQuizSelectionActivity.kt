package com.example.flagquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlagQuizSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flag_quiz_selection)
        val btnOneFlagFourCountries = findViewById<Button>(R.id.btnOneFlagFourCountries)
        val btnOneCountryFourFlags = findViewById<Button>(R.id.btnOneCountryFourFlags)

        btnOneFlagFourCountries.setOnClickListener {
            startActivity(Intent(this, FlagQuizSelectionActivity::class.java).putExtra("quizType", "oneFlagFourCountries"))
        }

        btnOneCountryFourFlags.setOnClickListener {
            startActivity(Intent(this, FlagQuizSelectionActivity::class.java).putExtra("quizType", "oneCountryFourFlags"))
        }
    }
}