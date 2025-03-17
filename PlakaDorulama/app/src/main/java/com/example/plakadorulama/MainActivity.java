package com.example.plakadorulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.plakadorulama.MainActivity2;
import com.example.plakadorulama.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView list1, list2;
    Button button1;
    ArrayList<Integer> numberList;
    ArrayList<String> cityList;
    HashMap<String, Integer> cityPlates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);
        button1 = findViewById(R.id.button1);

        numberList = new ArrayList<>();
        cityList = new ArrayList<>();
        cityPlates = new HashMap<>();

        String[] cities = {
                "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
                "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa",
                "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan",
                "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta",
                "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir",
                "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla",
                "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt",
                "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak",
                "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman",
                "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye",
                "Düzce"
        };

        for (int i = 0; i < cities.length; i++) {
            cityPlates.put(cities[i], i + 1);
        }

        button1.setOnClickListener(view -> {
            fillLists(cities);
        });

        list2.setOnItemClickListener((adapterView, view, position, id) -> {
            String selectedCity = cityList.get(position);
            int assignedNumber = numberList.get(position);

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("city", selectedCity);
            intent.putExtra("number", assignedNumber);
            intent.putExtra("real_plate", cityPlates.get(selectedCity));
            startActivity(intent);
        });
    }

    private void fillLists(String[] cities) {
        numberList.clear();
        cityList.clear();


        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 81; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        for (int i = 0; i < 81; i++) {
            numberList.add(numbers.get(i));
        }

        List<String> cityNames = new ArrayList<>();
        Collections.addAll(cityNames, cities);
        Collections.shuffle(cityNames);

        cityList.addAll(cityNames);

        list1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberList));
        list2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cityList));
    }
}
