package com.example.sensorler;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAccelerometer, btnCompass, btnGyroscope, btnHumidity, btnLight,
            btnMagnetometer, btnPressure, btnProximity, btnThermometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAccelerometer = findViewById(R.id.btnAccelerometer);
        btnCompass = findViewById(R.id.btnCompass);
        btnGyroscope = findViewById(R.id.btnGyroscope);
        btnHumidity = findViewById(R.id.btnHumidity);
        btnLight = findViewById(R.id.btnLight);
        btnMagnetometer = findViewById(R.id.btnMagnetometer);
        btnPressure = findViewById(R.id.btnPressure);
        btnProximity = findViewById(R.id.btnProximity);
        btnThermometer = findViewById(R.id.btnThermometer);

        btnAccelerometer.setOnClickListener(v -> startActivity(new Intent(this, AccelerometerActivity.class)));
        btnCompass.setOnClickListener(v -> startActivity(new Intent(this, CompassActivity.class)));
        btnGyroscope.setOnClickListener(v -> startActivity(new Intent(this, GyroscopeActivity.class)));
        btnHumidity.setOnClickListener(v -> startActivity(new Intent(this, HumidityActivity.class)));
        btnLight.setOnClickListener(v -> startActivity(new Intent(this, LightActivity.class)));
        btnMagnetometer.setOnClickListener(v -> startActivity(new Intent(this, MagnetometerActivity.class)));
        btnPressure.setOnClickListener(v -> startActivity(new Intent(this, PressureActivity.class)));
        btnProximity.setOnClickListener(v -> startActivity(new Intent(this, ProximityActivity.class)));
        btnThermometer.setOnClickListener(v -> startActivity(new Intent(this, ThermometerActivity.class)));
    }
}
