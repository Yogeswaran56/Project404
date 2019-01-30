package com.example.yogesh.project;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class schedule extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton button_add;
    private ListView listView_schedules;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReferenceVendorSchedules4Customers, databaseReferenceVendorID, databaseReferenceVendorSchedules;

    private List<MergedData> schedulesList = new ArrayList<>();
    private List<scheduleData> schedules_List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        firebaseAuth = FirebaseAuth.getInstance();

        String vendorId = firebaseAuth.getCurrentUser().getUid();
        databaseReferenceVendorSchedules4Customers = FirebaseDatabase.getInstance().getReference("customers").child("vendorSchedules");
        //databaseReferenceVendorID = FirebaseDatabase.getInstance().getReference("vendors").child();
        databaseReferenceVendorSchedules = FirebaseDatabase.getInstance().getReference("vendors").child(vendorId).child("schedules");


        button_add = findViewById(R.id.fab_add);
        listView_schedules = findViewById(R.id.list_schedules);

        button_add.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        /*databaseReferenceVendorSchedules4Customers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                schedules_List.clear();

                for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    MergedData eachData = new MergedData();
                    eachData.sData = userSnapshot.getValue(scheduleData.class);
                    da
                    // = FirebaseDatabase.getInstance().getReference("customers").child(eachData.sData.vendorID);
                    schedulesList.add(eachData);
                }

                //arrayAdapter
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        databaseReferenceVendorSchedules.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                schedules_List.clear();

                try{
                    for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        scheduleData eachData = userSnapshot.getValue(scheduleData.class);
                        schedules_List.add(eachData);
                    }
                }
                catch(Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                }

                AAScheduleList vendorScheduleListAdapter = new AAScheduleList(schedule.this, schedules_List);
                listView_schedules.setAdapter(vendorScheduleListAdapter);
                vendorScheduleListAdapter.setNotifyOnChange(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == button_add) {
            finish();
            startActivity(new Intent(this, new_schedule.class));
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
    }
}
