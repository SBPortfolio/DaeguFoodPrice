package com.example.daegufoodprice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daegufoodprice.R;
import com.example.daegufoodprice.model.Row;

import java.util.List;


public class PricePrdlstListAdapter extends BaseAdapter {
    List<Row> rowList;
    Context context;

    public PricePrdlstListAdapter(Context context, List<Row> rowList){
        this.context = context;
        this.rowList = rowList;
    }

    @Override
    public int getCount() {
        return rowList.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_detail_layout, parent, false);
            viewHolder = new PricePrdlstListAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PricePrdlstListAdapter.ViewHolder)convertView.getTag();
        }
        Row priceData = rowList.get(position);

        String spcies_nm = priceData.getSPCIESNM();
        String mark_nm = priceData.getMRKTNM();
        int a = priceData.getAMT();
        String amt = Integer.toString(a);
        String unit = priceData.getEXAMINUNIT();

        viewHolder.SPCIES_NM.setText(spcies_nm);
        viewHolder.MRKT_NM.setText(mark_nm);
        viewHolder.AMT.setText(amt);
        viewHolder.EXAMIN_UNIT.setText(unit);

        return convertView;
    }

    class ViewHolder {
        LinearLayout detail_layout ;
        TextView SPCIES_NM, MRKT_NM, AMT, EXAMIN_UNIT;

        ViewHolder(View v){
            detail_layout = v.findViewById(R.id.detailListView);

            SPCIES_NM = v.findViewById(R.id.detail_spcies_nm);
            MRKT_NM = v.findViewById(R.id.detail_mark_nm);
            AMT = v.findViewById(R.id.detail_amt);
            EXAMIN_UNIT = v.findViewById(R.id.detail_unit);
        }
    }
}
