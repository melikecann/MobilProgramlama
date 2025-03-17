package com.example.plakadorulama;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.plakadorulama.R;

public class MainActivity2 extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text1 = findViewById(R.id.text1);

        String city = getIntent().getStringExtra("city");
        int assignedNumber = getIntent().getIntExtra("number", -1);
        int realPlate = getIntent().getIntExtra("real_plate", -1);

        text1.setText(city + " için atanan numara: " + assignedNumber);

        if (assignedNumber == realPlate) {
            Toast.makeText(this, "Doğru! " + city + " plakası: " + realPlate, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Yanlış! " + city + " plakası: " + realPlate + " ama verilen numara " + assignedNumber, Toast.LENGTH_LONG).show();
        }
    }
}
