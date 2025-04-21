package com.example.sensorler;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HumidityActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor humiditySensor;
    private TextView sensorDataText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);

        sensorDataText = findViewById(R.id.sensorDataText);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        if (humiditySensor == null) {
            sensorDataText.setText("Bu cihazda nem sensörü yok.");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (humiditySensor != null)
            sensorManager.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float humidity = event.values[0];
        sensorDataText.setText("Nem: " + humidity + " %");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
