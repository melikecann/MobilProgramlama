package com.example.bluetoothwifikamerabalama;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_bluetooth = (Button) findViewById(R.id.btn_bluetooth);
                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_wifi = (Button) findViewById(R.id.btn_wifi);
                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_camera = (Button) findViewById(R.id.btn_camera);

                btn_bluetooth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gecisB = new Intent(MainActivity.this, Bluetooth.class);
                        startActivity(gecisB);
                    }
                });

                btn_wifi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gecisW = new Intent(MainActivity.this, Wifi.class);
                        startActivity(gecisW);
                    }
                });

                btn_camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gecisC = new Intent(MainActivity.this, Camera.class);
                        startActivity(gecisC);
                    }
                });
            }
        }