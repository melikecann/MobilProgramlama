package com.example.background_colorchange

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color;

class MainActivity : AppCompatActivity() {

        private var oran1 = 0
        private var oran2 = 0
        private var oran3 = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val sb1: SeekBar = findViewById(R.id.seekBar1)
            val sb2: SeekBar = findViewById(R.id.seekBar2)
            val sb3: SeekBar = findViewById(R.id.seekBar3)

            val txt1: TextView = findViewById(R.id.textView1)
            val txt2: TextView = findViewById(R.id.textView2)
            val txt3: TextView = findViewById(R.id.textView3)

            val arkarenk: ConstraintLayout = findViewById(R.id.arkaPlan)

            sb1.max = 255
            sb2.max = 255
            sb3.max = 255

            sb1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    oran1 = progress
                    val renk = Color.rgb(oran1, oran2, oran3)
                    arkarenk.setBackgroundColor(renk)
                    txt1.text = progress.toString()
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            sb2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    oran2 = progress
                    val renk = Color.rgb(oran1, oran2, oran3)
                    arkarenk.setBackgroundColor(renk)
                    txt2.text = progress.toString()
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            sb3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    oran3 = progress
                    val renk = Color.rgb(oran1, oran2, oran3)
                    arkarenk.setBackgroundColor(renk)
                    txt3.text = progress.toString()
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })
        }
    }
