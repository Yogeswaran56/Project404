package com.example.yogesh.project;

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

public class dashboard extends AppCompatActivity {

    private ListView listView_dashboardList;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReferenceProducts;

    List<productClass> dashboardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        listView_dashboardList = findViewById(R.id.lv_dashboardList);

        firebaseAuth = FirebaseAuth.getInstance();
        String id = firebaseAuth.getCurrentUser().getUid();

        databaseReferenceProducts = FirebaseDatabase.getInstance().getReference("vendors").child(id).child("products");
    }


    @Override
    protected void onStart() {
        super.onStart();

        databaseReferenceProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dashboardList.clear();

                for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    productClass eachData = userSnapshot.getValue(productClass.class);
                    dashboardList.add(eachData);
                }

                AADashboardList dashboardAdapter = new AADashboardList(dashboard.this, dashboardList);
                listView_dashboardList.setAdapter(dashboardAdapter);
                dashboardAdapter.setNotifyOnChange(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
