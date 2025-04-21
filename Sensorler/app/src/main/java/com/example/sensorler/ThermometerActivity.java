package com.example.sensorler;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sensorler.R;

public class ThermometerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor temperatureSensor;
    private TextView sensorDataText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermometer);

        sensorDataText = findViewById(R.id.sensorDataText);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        if (temperatureSensor == null) {
            sensorDataText.setText("Bu cihazda sıcaklık sensörü yok.");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (temperatureSensor != null)
            sensorManager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float temperature = event.values[0];
        sensorDataText.setText("Sıcaklık: " + temperature + " °C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
