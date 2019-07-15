package com.example.daegufoodprice.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daegufoodprice.DetailActivity;
import com.example.daegufoodprice.R;
import com.example.daegufoodprice.model.Row;

import java.util.List;

public class FoodPriceListAdapter extends BaseAdapter {
    private List<Row> list;
    private Context context;
    private String calender;

    public FoodPriceListAdapter(Context context, List<Row> list, String calender){
        this.context = context;
        this.list = list;
        this.calender = calender;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Row priceData = list.get(position);
        String fRMPRDCATGORYNM = priceData.getFRMPRDCATGORYNM();
        final String fRMPRDCATGORYCD = priceData.getFRMPRDCATGORYCD();
        final String pRDLSTCD = priceData.getPRDLSTCD();
        final String pRDLSTNM = priceData.getPRDLSTNM();
        final String sPCIESNM = priceData.getSPCIESNM();
        final String gRADCD = priceData.getGRADCD();
        String eXAMINUNIT = priceData.getEXAMINUNIT();
        final String mRKTCD = priceData.getMRKTCD();
        String mRKTNM = priceData.getMRKTNM();
        int amtInt = priceData.getAMT();
        String amt = "" + amtInt;

        viewHolder.FRMPRD_CATGORY_NM.setText(fRMPRDCATGORYNM);
        viewHolder.PRDLST_NM.setText(pRDLSTNM);
        viewHolder.SPCIES_NM.setText(sPCIESNM);
        viewHolder.MRKT_NM.setText(mRKTNM);
        viewHolder.EXAMIN_UNIT.setText(eXAMINUNIT);
        viewHolder.AMT.setText(amt);

        viewHolder.mainListContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("FRMPRD_CATGORY_CD", fRMPRDCATGORYCD);
                intent.putExtra("PRDLST_CD", pRDLSTCD);
                intent.putExtra("PRDLST_NM", pRDLSTNM);
                intent.putExtra("SPCIES_NM", sPCIESNM);
                intent.putExtra("GRAD_CD", gRADCD);
                intent.putExtra("MRKT_CD", mRKTCD);
                intent.putExtra("calender", calender);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder {
        LinearLayout mainListContainer;
        TextView FRMPRD_CATGORY_NM, PRDLST_NM, SPCIES_NM, MRKT_NM, EXAMIN_UNIT, AMT;

        ViewHolder(View v){
            mainListContainer = v.findViewById(R.id.mainListContainer);

            FRMPRD_CATGORY_NM = v.findViewById(R.id.FRMPRD_CATGORY_NM);
            PRDLST_NM = v.findViewById(R.id.PRDLST_NM);
            SPCIES_NM = v.findViewById(R.id.SPCIES_NM);
            MRKT_NM = v.findViewById(R.id.MRKT_NM);
            EXAMIN_UNIT = v.findViewById(R.id.EXAMIN_UNIT);
            AMT = v.findViewById(R.id.AMT);
        }
    }
}
