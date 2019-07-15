package com.example.daegufoodprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    NumberPicker numberPicker_year;
    NumberPicker numberPicker_month;
    NumberPicker numberPicker_day;
    Button numberPicker_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        String today = sdf.format(calendar.getTime());
        String today_year = today.substring(0, 4);
        String today_month = today.substring(4, 6);
        String today_day = today.substring(6);
        Log.d("today", today_year);

        int year = Integer.parseInt(today_year);
        int month = Integer.parseInt(today_month);
        int day = Integer.parseInt(today_day);

        numberPicker_year = (NumberPicker)findViewById(R.id.numberPicker_year);
        numberPicker_year.setMinValue(2010);
        numberPicker_year.setMaxValue(year);
        numberPicker_year.setValue(year);
        numberPicker_year.setWrapSelectorWheel(false);

        numberPicker_month = (NumberPicker)findViewById(R.id.numberPicker_month);
        numberPicker_month.setMinValue(01);
        numberPicker_month.setMaxValue(12);
        numberPicker_month.setValue(month);

        numberPicker_day = (NumberPicker)findViewById(R.id.numberPicker_day);
        numberPicker_day.setMinValue(1);
        numberPicker_day.setMaxValue(31);
        numberPicker_day.setValue(day);

        numberPicker_button = (Button)findViewById(R.id.numberPicker_button);
        numberPicker_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getMonthStr;
                String getDayStr;
                int getYear = numberPicker_year.getValue();
                int getMonth = numberPicker_month.getValue();
                int getDay = numberPicker_day.getValue();
                if(getMonth <10){
                    getMonthStr = "" + "0" + getMonth;
                } else {
                    getMonthStr = "" + getMonth;
                }
                if(getDay <10){
                    getDayStr = "" + "0" + getDay;
                } else {
                    getDayStr = "" + getDay;
                }

                String getCalender = "" + getYear + getMonthStr + getDayStr;

                Log.d("getCalender", getCalender);

                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("calender", getCalender);
                startActivity(intent);
            }
        });
    }
}
