package com.example.daegufoodprice;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.daegufoodprice.adapter.PricePrdlstListAdapter;
import com.example.daegufoodprice.model.PriceData;
import com.example.daegufoodprice.model.Row;
import com.example.daegufoodprice.model.Utils;
import com.example.daegufoodprice.retrofit.RetrofitClient;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    List<Row> rows;
    TextView textView;
    ListView listView;
    PricePrdlstListAdapter pricePrdlstListAdapter;
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        String fRMPRDCATGORYCD = intent.getStringExtra("FRMPRD_CATGORY_CD");
        String pRDLSTCD = intent.getStringExtra("PRDLST_CD");
        String pRDLSTNM = intent.getStringExtra("PRDLST_NM");
        String calender = intent.getStringExtra("calender");

        textView = (TextView) findViewById(R.id.detail_pRDLSTNM);
        textView.setText(pRDLSTNM);
        listView = (ListView) findViewById(R.id.detailListView);

        Call<PriceData> call = RetrofitClient.getApiService().getListData(Utils.SERVICE_KEY, calender, fRMPRDCATGORYCD, pRDLSTCD, Utils.AREA_CD);
        call.enqueue(new Callback<PriceData>() {
            @Override
            public void onResponse(Call<PriceData> call, Response<PriceData> response) {
                Log.d("call", "success");
                if (response.isSuccessful()) {
                    rows = response.body().getGrid201412250000000001631().getRow();
                    if (rows.size() == 0) {
                        Intent intent2 = new Intent(DetailActivity.this, NoDataActivity.class);
                        startActivity(intent2);
                    } else {
                        setLineChart(lineChart, rows, R.id.detail_lineChart);
                        pricePrdlstListAdapter = new PricePrdlstListAdapter(DetailActivity.this, rows);
                        listView.setAdapter(pricePrdlstListAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PriceData> call, Throwable t) {
                Log.d("call", "fail");
            }
        });
    }

    public void setLineChart(LineChart lineChart, List<Row> rows, int id){
        lineChart = (LineChart) findViewById(id);

        ArrayList<Entry> entries = new ArrayList<>();
        for(int i = 0; i < rows.size(); i++){
            entries.add(new Entry((i+1), rows.get(i).getAMT()));
        }

        LineDataSet lineDataSet = new LineDataSet(entries, "마켓별 가격");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.enableGridDashedLine(8, 24, 0);

        YAxis yLAxis = lineChart.getAxisLeft();
        yLAxis.setTextColor(Color.BLACK);

        YAxis yRAxis = lineChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);

        Description description = new Description();
        description.setText("");

        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDescription(description);
        lineChart.invalidate();
    }
}
