package com.example.daegufoodprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.daegufoodprice.adapter.FoodPriceListAdapter;
import com.example.daegufoodprice.model.PriceData;
import com.example.daegufoodprice.model.Row;
import com.example.daegufoodprice.model.Utils;
import com.example.daegufoodprice.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    List<Row> rows;
    FoodPriceListAdapter foodPriceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        Log.d("getIntent", intent.getStringExtra("calender"));

        listView = (ListView)findViewById(R.id.mainListView);
        int category = intent.getIntExtra("category", 0);
        final String calender = intent.getStringExtra("calender");

        Call<PriceData> call = RetrofitClient.getApiService().getListRepos(Utils.SERVICE_KEY, calender, Utils.AREA_CD, category);
        call.enqueue(new Callback<PriceData>() {
            @Override
            public void onResponse(Call<PriceData> call, Response<PriceData> response) {
                Log.d("call", "success");
                if(response.isSuccessful()){
                    rows = response.body().getGrid201412250000000001631().getRow();
                    if(rows.size()==0){
                        Intent intent2 = new Intent(ListActivity.this, NoDataActivity.class);
                        startActivity(intent2);
                    }else{
                        foodPriceListAdapter = new FoodPriceListAdapter(ListActivity.this, rows, calender);
                        listView.setAdapter(foodPriceListAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PriceData> call, Throwable t) {
                Log.d("call", "fail");
            }
        });

    }
}
