package com.example.daegufoodprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    public void onClkCategory(View view){
        Intent intent = getIntent();
        String calender = intent.getStringExtra("calender");
        Intent intent1 = new Intent(CategoryActivity.this, ListActivity.class);

        int getId = view.getId();
        int category = 0;
        switch (getId){
            case R.id.category_100:
                category = 100;
                break;
            case R.id.category_200:
                category = 200;
                break;
            case R.id.category_300:
                category = 300;
                break;
            case R.id.category_400:
                category = 400;
                break;
            case R.id.category_500:
                category = 500;
                break;
            case R.id.category_600:
                category = 600;
                break;
        }

        intent1.putExtra("category", category);
        intent1.putExtra("calender", calender);
        startActivity(intent1);
    }
}
