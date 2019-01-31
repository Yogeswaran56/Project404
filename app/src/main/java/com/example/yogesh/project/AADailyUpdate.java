package com.example.yogesh.project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AADailyUpdate extends ArrayAdapter {
    Activity mcontext;
    List<productClass> updateList;

    public AADailyUpdate(Activity mcontext, List<productClass> updateList) {
        super(mcontext, R.layout.custom_update_list_view, updateList);
        this.mcontext = mcontext;
        this.updateList = updateList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = mcontext.getLayoutInflater();

        View listItems = layoutInflater.inflate(R.layout.custom_update_list_view, null, true);

        TextView textView_ItemName = listItems.findViewById(R.id.tv_itemName_orders);
        TextView textView_price = listItems.findViewById(R.id.tv_price);
        //TextView textView_Quantity = listItems.findViewById(R.id.tv_quantity);

        productClass Data = updateList.get(position);

        textView_ItemName.setText(Data.getItemName());
        textView_price.setText(Data.getPrice());
        //textView_Quantity.setText(Data.getQuantity());

        return listItems;
    }
}
