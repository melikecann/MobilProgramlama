package com.example.il_plakano_oyunu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

        private ListView listViewResults;
        private Button btnGeri;
        private ArrayList<String> resultsList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            listViewResults = findViewById(R.id.listView_results);
            btnGeri = findViewById(R.id.btn_geri);

            // Intent'ten şehir adı ve süreyi al
            Intent intent = getIntent();
            String cityName = intent.getStringExtra("cityName");
            long timeTaken = intent.getLongExtra("timeTaken", 0);

            resultsList = new ArrayList<>();
            resultsList.add(cityName + " " + timeTaken + "sn");

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultsList);
            listViewResults.setAdapter(adapter);

            // Geri butonuna tıklama olayı
            btnGeri.setOnClickListener(v -> finish());
        }
    }

