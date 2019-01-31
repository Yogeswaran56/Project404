package com.example.yogesh.project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AADashboardList extends ArrayAdapter {
    Activity mcontext;
    List<productClass> dashboardList;

    public AADashboardList(Activity mcontext, List<productClass> dashboardList) {
        super(mcontext, R.layout.custom_update_list_view, dashboardList);
        this.mcontext = mcontext;
        this.dashboardList = dashboardList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = mcontext.getLayoutInflater();

        View listItems = layoutInflater.inflate(R.layout.custom_dashboardlist_layout, null, true);

        TextView textView_ItemName = listItems.findViewById(R.id.tv_itemName_dashboard);
        TextView textView_price = listItems.findViewById(R.id.tv_dashboard_price);
        TextView textView_Quantity = listItems.findViewById(R.id.tv_dashboard_quantity);

        productClass Data = dashboardList.get(position);

        textView_ItemName.setText(Data.getItemName());
        textView_price.setText(Data.getPrice());
        textView_Quantity.setText(Data.getQuantity());

        return listItems;
    }
}
