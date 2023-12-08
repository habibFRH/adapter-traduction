package com.example.tpexo2customlistview;

/*Exo 1*/
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String[] languages = new String[]{"English", "Arabic", "French", "Spanish"};
    Map<String, String> translations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        translations = new HashMap<>();
        translations.put("English", "Hello world!");
        translations.put("Arabic", "مرحبا بالعالم!");
        translations.put("French", "Bonjour le monde!");
        translations.put("Spanish", "¡Hola Mundo!");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tv = findViewById(R.id.tv);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Spinner spinner = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, languages);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedLanguage = languages[i];
                String translatedText = translations.get(selectedLanguage);
                tv.setText(translatedText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
