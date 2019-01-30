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
public class homelist extends Fragment{

//    private CardView vegcardview,fruitcardview ;
//
//    public homelist() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.activity_customerhomepage, container, false);
//
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_homelist,
            container, false);
    CardView cardview = (CardView) rootView.findViewById(R.id.vegecard);
    cardview.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateDetail();
        }
    });
    return rootView;
}

    public void updateDetail() {
        Intent intent = new Intent(getActivity(), vegetables.class);
        startActivity(intent);
    }
}
