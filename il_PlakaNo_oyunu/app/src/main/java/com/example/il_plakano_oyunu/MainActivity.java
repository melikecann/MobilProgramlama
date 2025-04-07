package com.example.il_plakano_oyunu;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

        private Button btnBasla, btnOnayla;
        private SeekBar seekBarPlaka;
        private TextView plaintext, seekBarValue;
        private Map<Integer, String> plakaMap;
        private long startTime;
        private long selectedTime;
        private boolean answeredCorrectly = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btnBasla = findViewById(R.id.btn_basla);
            btnOnayla = findViewById(R.id.btn_onayla);
            seekBarPlaka = findViewById(R.id.seekBar_plaka);
            plaintext = findViewById(R.id.plaintext);
            seekBarValue = findViewById(R.id.seekBarValue);

            // Plaka numaraları ve şehirler
            plakaMap = new HashMap<>();
            plakaMap.put(1, "Adana");
            plakaMap.put(2, "Adıyaman");
            plakaMap.put(3, "Afyonkarahisar");
            plakaMap.put(4, "Ağrı");
            plakaMap.put(5, "Amasya");
            plakaMap.put(6, "Ankara");
            plakaMap.put(7, "Antalya");
            plakaMap.put(8, "Artvin");
            plakaMap.put(9, "Aydın");
            plakaMap.put(10, "Balıkesir");
            plakaMap.put(11, "Bilecik");
            plakaMap.put(12, "Bingöl");
            plakaMap.put(13, "Bitlis");
            plakaMap.put(14, "Bolu");
            plakaMap.put(15, "Burdur");
            plakaMap.put(16, "Bursa");
            plakaMap.put(17, "Çanakkale");
            plakaMap.put(18, "Çankırı");
            plakaMap.put(19, "Çorum");
            plakaMap.put(20, "Denizli");
            plakaMap.put(21, "Diyarbakır");
            plakaMap.put(22, "Edirne");
            plakaMap.put(23, "Elazığ");
            plakaMap.put(24, "Erzincan");
            plakaMap.put(25, "Erzurum");
            plakaMap.put(26, "Eskişehir");
            plakaMap.put(27, "Gaziantep");
            plakaMap.put(28, "Giresun");
            plakaMap.put(29, "Gümüşhane");
            plakaMap.put(30, "Hakkâri");
            plakaMap.put(31, "Hatay");
            plakaMap.put(32, "Isparta");
            plakaMap.put(33, "Mersin");
            plakaMap.put(34, "İstanbul");
            plakaMap.put(35, "İzmir");
            plakaMap.put(36, "Kars");
            plakaMap.put(37, "Kastamonu");
            plakaMap.put(38, "Kayseri");
            plakaMap.put(39, "Kırklareli");
            plakaMap.put(40, "Kırşehir");
            plakaMap.put(41, "Kocaeli");
            plakaMap.put(42, "Konya");
            plakaMap.put(43, "Kütahya");
            plakaMap.put(44, "Malatya");
            plakaMap.put(45, "Manisa");
            plakaMap.put(46, "Kahramanmaraş");
            plakaMap.put(47, "Mardin");
            plakaMap.put(48, "Muğla");
            plakaMap.put(49, "Muş");
            plakaMap.put(50, "Nevşehir");
            plakaMap.put(51, "Niğde");
            plakaMap.put(52, "Ordu");
            plakaMap.put(53, "Rize");
            plakaMap.put(54, "Sakarya");
            plakaMap.put(55, "Samsun");
            plakaMap.put(56, "Siirt");
            plakaMap.put(57, "Sinop");
            plakaMap.put(58, "Sivas");
            plakaMap.put(59, "Tekirdağ");
            plakaMap.put(60, "Tokat");
            plakaMap.put(61, "Trabzon");
            plakaMap.put(62, "Tunceli");
            plakaMap.put(63, "Şanlıurfa");
            plakaMap.put(64, "Uşak");
            plakaMap.put(65, "Van");
            plakaMap.put(66, "Yozgat");
            plakaMap.put(67, "Zonguldak");
            plakaMap.put(68, "Aksaray");
            plakaMap.put(69, "Bayburt");
            plakaMap.put(70, "Karaman");
            plakaMap.put(71, "Kırıkkale");
            plakaMap.put(72, "Batman");
            plakaMap.put(73, "Şırnak");
            plakaMap.put(74, "Bartın");
            plakaMap.put(75, "Ardahan");
            plakaMap.put(76, "Iğdır");
            plakaMap.put(77, "Yalova");
            plakaMap.put(78, "Karabük");
            plakaMap.put(79, "Kilis");
            plakaMap.put(80, "Osmaniye");
            plakaMap.put(81, "Düzce");

            // SeekBar değeri değiştiğinde kullanıcıya göster
            seekBarPlaka.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // SeekBar'daki değeri TextView'e yansıt
                    seekBarValue.setText("Seçilen Plaka: " + (progress + 1));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // Bir şey yapmaya gerek yok
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // Bir şey yapmaya gerek yok
                }
            });

            // Başla butonuna tıklama olayı
            btnBasla.setOnClickListener(v -> startTimer());

            // Onayla butonuna tıklama olayı
            btnOnayla.setOnClickListener(v -> {
                int selectedPlaka = seekBarPlaka.getProgress() + 1;
                String cityName = plakaMap.get(selectedPlaka);

                if (cityName != null) {
                    plaintext.setText(cityName);
                    selectedTime = System.currentTimeMillis() - startTime;
                    if (answeredCorrectly) {
                        // İkinci ekrana geçiş
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("cityName", cityName);
                        intent.putExtra("timeTaken", selectedTime / 1000); // saniye cinsinden
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Yanlış cevap!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void startTimer() {
            startTime = System.currentTimeMillis();
            new CountDownTimer(60000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // Timer her saniyede bir çalışır
                }

                @Override
                public void onFinish() {
                    // Zaman dolduğunda
                    Toast.makeText(MainActivity.this, "Zaman doldu! Cevabınızı girin.", Toast.LENGTH_SHORT).show();
                }
            }.start();
        }
    }
