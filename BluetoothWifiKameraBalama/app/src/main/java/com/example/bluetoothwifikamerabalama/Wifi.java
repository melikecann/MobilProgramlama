package com.example.bluetoothwifikamerabalama;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Wifi extends AppCompatActivity {

    private WifiManager modem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wifi);

        modem = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        final ToggleButton btn = findViewById(R.id.tbtn_wifi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn.isChecked()) {
                    wifiAc();
                } else {
                    wifiKapat();
                }
            }
        });

        // Uygulama açıldığında mevcut duruma göre ToggleButton ayarı
        btn.setChecked(modem.isWifiEnabled());
    }

    private void wifiKapat() {
        if (modem.isWifiEnabled()) {
            modem.setWifiEnabled(false);
            Toast.makeText(Wifi.this, "WiFi kapatıldı", Toast.LENGTH_SHORT).show();
        }
    }

    private void wifiAc() {
        if (!modem.isWifiEnabled()) {
            modem.setWifiEnabled(true);
            Toast.makeText(Wifi.this, "WiFi açıldı", Toast.LENGTH_SHORT).show();
        }
    }
}
