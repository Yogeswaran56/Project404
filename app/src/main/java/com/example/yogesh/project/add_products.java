package com.example.yogesh.project;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_products extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText editText_quantity, editText_price;
    private Button button_submit;
    private String quantity, price, id, itemName;
    private Spinner spinner_itemName;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReferenceVendorsProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);

        firebaseAuth = FirebaseAuth.getInstance();
        id = firebaseAuth.getCurrentUser().getUid();

        databaseReferenceVendorsProducts = FirebaseDatabase.getInstance().getReference("vendors").child(id).child("products");

        spinner_itemName = findViewById(R.id.sp_itemName);
        editText_price = findViewById(R.id.edt_price);
        editText_quantity = findViewById(R.id.edt_quantity);
        button_submit = findViewById(R.id.btn_convey);


        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.products, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_itemName.setAdapter(arrayAdapter);
        spinner_itemName.setSelection(0);

        button_submit.setOnClickListener(this);
        spinner_itemName.setOnItemSelectedListener(this);
   }

    @Override
    public void onClick(View v) {
        if(v == button_submit) {
            quantity = editText_quantity.getText().toString();
            price = editText_price.getText().toString();

            String push_key = databaseReferenceVendorsProducts.push().getKey();

            productClass newProduct = new productClass(itemName, quantity, price, push_key);
            databaseReferenceVendorsProducts.child(push_key).setValue(newProduct).addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),"Item added successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            });
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        itemName = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
