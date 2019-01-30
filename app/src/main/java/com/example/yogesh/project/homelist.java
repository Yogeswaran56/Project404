package com.example.yogesh.project;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class homelist extends Fragment implements View.OnClickListener {

    private CardView vegcardview,fruitcardview ;

    public homelist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_customerhomepage, container, false);

    }

    @Override
    public void onClick(View view) {

    }
}
