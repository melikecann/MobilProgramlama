package com.example.flagquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CapitalQuizSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capital_quiz_selection)
        val btnOneCapitalFourCountries = findViewById<Button>(R.id.btnOneCapitalFourCountries)
        val btnOneCountryFourCapitals = findViewById<Button>(R.id.btnOneCountryFourCapitals)

        btnOneCapitalFourCountries.setOnClickListener {
            startActivity(Intent(this, CapitalQuizSelectionActivity::class.java).putExtra("quizType", "oneCapitalFourCountries"))
        }

        btnOneCountryFourCapitals.setOnClickListener {
            startActivity(Intent(this, CapitalQuizSelectionActivity::class.java).putExtra("quizType", "oneCountryFourCapitals"))
        }
    }
}