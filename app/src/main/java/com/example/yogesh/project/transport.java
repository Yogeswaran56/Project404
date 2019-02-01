package com.example.yogesh.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class transport extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab_newTransport;

    ListView listView_transportList;
    List<transportData> transport_List = new ArrayList<>();
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReferenceTransport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        fab_newTransport = findViewById(R.id.fab_add_transport);
        listView_transportList = findViewById(R.id.lv_transport);

        fab_newTransport.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        String id = firebaseAuth.getCurrentUser().getUid();
        databaseReferenceTransport = FirebaseDatabase.getInstance().getReference("vendors").child(id).child("transport");

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReferenceTransport.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                transport_List.clear();
                for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    transportData eachData = userSnapshot.getValue(transportData.class);
                    transport_List.add(eachData);
                    //Toast.makeText(getApplicationContext(), eachData.getSrcLoc(), Toast.LENGTH_SHORT).show();
                }
                AATransportList transportListAdapter = new AATransportList(transport.this, transport_List);
                listView_transportList.setAdapter(transportListAdapter);
                transportListAdapter.setNotifyOnChange(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == fab_newTransport) {
            finish();
            startActivity(new Intent(this, new_transport.class));
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
    }
}
