package com.example.yogesh.project;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class daily_update extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView textView_ItemName, textView_priceTag;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReferenceProducts;
    private ListView listView_dailyUpdate;

    private List<productClass> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_update);

        textView_ItemName = findViewById(R.id.tv_itemName_orders);
        textView_priceTag = findViewById(R.id.tv_price);

        listView_dailyUpdate = findViewById(R.id.lv_dailyUpdateList);

        firebaseAuth = FirebaseAuth.getInstance();
        String id = firebaseAuth.getCurrentUser().getUid();

        databaseReferenceProducts = FirebaseDatabase.getInstance().getReference("vendors").child(id).child("products");

        listView_dailyUpdate.setOnItemClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReferenceProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productList.clear();

                for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    productClass eachItem = userSnapshot.getValue(productClass.class);
                    productList.add(eachItem);
                }

                AADailyUpdate vendorDailyUpdateAdapter = new AADailyUpdate(daily_update.this, productList);
                listView_dailyUpdate.setAdapter(vendorDailyUpdateAdapter);
                vendorDailyUpdateAdapter.setNotifyOnChange(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateData(String newPrice, String quantity, String itemName, String nodeKEY) {
        productClass temp = new productClass(itemName, quantity, newPrice, nodeKEY);
        databaseReferenceProducts.child(nodeKEY).setValue(temp).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(),"Successfully updated the product details", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final productClass clickedData = productList.get(position);

        AlertDialog.Builder mbuilder = new AlertDialog.Builder(daily_update.this);

        View mView = getLayoutInflater().inflate(R.layout.custom_daiilyupdateedit_alert,null);
        final EditText editText_editedPrice = mView.findViewById(R.id.edt_editedPrice);
        //final EditText editText_editedQuantity = mView.findViewById(R.id.edt_editedQuantity);
        Button btn_changeValues = mView.findViewById(R.id.btn_changeValues);

        editText_editedPrice.setText(clickedData.getPrice());
        //editText_editedQuantity.setText(clickedData.getQuantity());
        final String nodeKey = clickedData.getKey();
        final String itemName = clickedData.getItemName();
        final String quantity = clickedData.getQuantity();

        mbuilder.setView(mView);
        final AlertDialog dialog = mbuilder.create();
        dialog.show();

        btn_changeValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editedPrice = editText_editedPrice.getText().toString();
                //String editedQuantity = editText_editedQuantity.getText().toString();
                updateData(editedPrice,quantity,itemName,nodeKey);
                dialog.dismiss();
            }
        });

    }
}
