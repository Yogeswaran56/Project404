package com.example.yogesh.project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AATransportList extends ArrayAdapter<transportData> {
    Activity mcontext;
    List<transportData> tData;

    public AATransportList(Activity mcontext, List<transportData> transportList){
        super(mcontext, R.layout.custom_transport_listview, transportList);
        this.mcontext = mcontext;
        this.tData = transportList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = mcontext.getLayoutInflater();

        View mview = layoutInflater.inflate(R.layout.custom_transport_listview,null,true);

        TextView stTime = mview.findViewById(R.id.tv_st_time);
        TextView enTime = mview.findViewById(R.id.tv_reach_time);
        TextView srcPlace = mview.findViewById(R.id.tv_srcPlace);
        TextView destPlace = mview.findViewById(R.id.tv_destPlace);
        TextView date = mview.findViewById(R.id.tv_comingDate);

        transportData data = tData.get(position);

        destPlace.setText(data.getDestLoc());
        srcPlace.setText(data.getSrcLoc());
        stTime.setText(String.format("%02d",data.getStartTime().getHour()) + ":" + String.format("%02d",data.getStartTime().getMins()) + data.getStartTime().getAmpm());
        enTime.setText(String.format("%02d",data.getReachTime().getHour()) + ":" + String.format("%02d",data.getReachTime().getMins()) + data.getReachTime().getAmpm());
        date.setText(data.getScheduledDay().getDay()+":"+data.getScheduledDay().getMonth()+":"+data.getScheduledDay().getYear());

        return mview;
    }
}
