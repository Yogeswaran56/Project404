package com.example.yogesh.project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AAScheduleList extends ArrayAdapter<scheduleData> {

    Activity mcontext;
    List<scheduleData> scheduleList;

    public AAScheduleList(Activity mcontext, List<scheduleData> scheduleList){
        super(mcontext, R.layout.custom_schedule_listview, scheduleList);
        this.mcontext = mcontext;
        this.scheduleList = scheduleList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = mcontext.getLayoutInflater();

        View listItems = layoutInflater.inflate(R.layout.custom_schedule_listview, null, true);

        TextView textView_openTime = listItems.findViewById(R.id.tv_opentime);
        TextView textView_closeTime = listItems.findViewById(R.id.tv_closetime);
        TextView textView_town = listItems.findViewById(R.id.tv_town);
        TextView textView_place = listItems.findViewById(R.id.tv_place);

        scheduleData data = scheduleList.get(position);

        textView_town.setText(data.getTown());
        textView_openTime.setText(String.format("%02d",data.getOpenTime().getHour()) + ":" + String.format("%02d",data.getOpenTime().getMins()) + data.getOpenTime().getAmpm());
        textView_closeTime.setText(String.format("%02d",data.getCloseTime().getHour()) + ":" + String.format("%02d",data.getCloseTime().getMins()) + data.getCloseTime().getAmpm());
        textView_place.setText(data.getPlaceOfLoc());

        return listItems;
    }
}
