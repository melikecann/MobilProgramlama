package com.example.a10_032;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView list1 = findViewById(R.id.list1);
        TextView text1 = findViewById(R.id.textView2);

        String[] sehirler = {"İstanbul", "Ankara", "İzmir", "Kocaeli"};

        ArrayAdapter<String> veriListesi = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, sehirler);

        list1.setAdapter(veriListesi);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, veriListesi.getItem(i), Toast.LENGTH_LONG).show();
            }
        });
    }
}

