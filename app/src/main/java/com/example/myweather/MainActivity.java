package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    EditText city_name_txt;
    Button search_btn;
    ListView data_list;
    WeatherDataService weatherDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        city_name_txt = findViewById(R.id.city_name);
        search_btn = findViewById(R.id.search_btn);
        data_list = findViewById(R.id.data_list);
        weatherDataService = new WeatherDataService(MainActivity.this);



        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                weatherDataService.getCityForecastByName(city_name_txt.getText().toString(), new WeatherDataService.ForeCastByNameResponse() {
                    @Override
                    public void OnResponse(List<WeatherReportModel> weatherReportModelList) {

                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, weatherReportModelList);
                        data_list.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }


}