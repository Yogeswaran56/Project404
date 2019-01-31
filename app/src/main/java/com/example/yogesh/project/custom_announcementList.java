package com.example.yogesh.project;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class custom_announcementList extends AppCompatActivity {

    ListView listView_announce;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference_VendorsSchedules;

    List<scheduleData> vendorSchedules = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_announcement_list);

        firebaseAuth = FirebaseAuth.getInstance();

        listView_announce = findViewById(R.id.list_announcement);

        databaseReference_VendorsSchedules = FirebaseDatabase.getInstance().getReference("customers").child("vendorSchedules");
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference_VendorsSchedules.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                vendorSchedules.clear();
                for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                   scheduleData eachData  = userSnapshot.getValue(scheduleData.class);
                   vendorSchedules.add(eachData);
                }

                AAScheduleList vendorScheduleListAdapter = new AAScheduleList(custom_announcementList.this, vendorSchedules);
                listView_announce.setAdapter(vendorScheduleListAdapter);
                vendorScheduleListAdapter.setNotifyOnChange(true);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
