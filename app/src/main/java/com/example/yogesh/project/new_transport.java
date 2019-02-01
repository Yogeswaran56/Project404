package com.example.yogesh.project;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class new_transport extends AppCompatActivity implements View.OnClickListener {

    Button button_cancel, button_register;
    EditText editText_Cal, editText_startTime, editText_endTime, editText_src, editText_dest;
    private int day, month, year, hours, mins, ampm;
    private int en_hours, en_mins, st_hours, st_mins;

    private String st_ap, en_ap;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transport);

        button_cancel = findViewById(R.id.btn_cancel);
        editText_src = findViewById(R.id.edt_srcPlace);
        editText_dest = findViewById(R.id.edt_destPlace);
        editText_Cal = findViewById(R.id.edt_date_transport);
        editText_startTime = findViewById(R.id.edt_startTime_transport);
        editText_endTime = findViewById(R.id.edt_reachTime_transport);
        button_register = findViewById(R.id.btn_schedule);

        firebaseAuth = FirebaseAuth.getInstance();
        id = firebaseAuth.getCurrentUser().getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference("vendors").child(id).child("transport");

        button_cancel.setOnClickListener(this);
        button_register.setOnClickListener(this);

        editText_startTime.setOnClickListener(this);
        editText_endTime.setOnClickListener(this);
        editText_Cal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == button_cancel) {
            finish();
            startActivity(new Intent(this, transport.class));
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        }

        if(v == editText_Cal) {
            final Calendar c = Calendar.getInstance();

            day = c.get(Calendar.DAY_OF_MONTH);
            month = c.get(Calendar.MONTH);
            year = c.get(Calendar.YEAR);

            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    editText_Cal.setText(dayOfMonth + "-" + (month+1) + "-" + year);
                }
            },year,month,day);
            dpd.show();
        }

        if(v == editText_startTime) {
            final Calendar c = Calendar.getInstance();
            st_hours = c.get(Calendar.HOUR_OF_DAY);
            st_mins = c.get(Calendar.MINUTE);
            ampm = c.get(Calendar.AM_PM);

            TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(ampm==1 && hourOfDay>12){
                        hourOfDay-=12;
                        st_ap = "PM";
                    }
                    else
                        st_ap = "AM";
                    st_hours = hourOfDay;
                    st_mins = minute;
                    String hourOfDayString = String.format("%02d",hourOfDay);
                    String minuteString = String.format("%02d",minute);
                    editText_startTime.setText(hourOfDayString + ":" + minuteString + st_ap);
                }
            },st_hours,st_mins,false);
            tpd.show();
        }

        if(v == editText_endTime) {
            final Calendar c = Calendar.getInstance();
            en_hours = c.get(Calendar.HOUR_OF_DAY);
            en_mins = c.get(Calendar.MINUTE);
            ampm = c.get(Calendar.AM_PM);

            TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(ampm==1 && hourOfDay>12){
                        hourOfDay-=12;
                        en_ap = "PM";
                    }
                    else
                        en_ap = "AM";
                    en_hours = hourOfDay;
                    en_mins = minute;
                    String hourOfDayString = String.format("%02d",hourOfDay);
                    String minuteString = String.format("%02d",minute);
                    editText_endTime.setText(hourOfDayString + ":" + minuteString + en_ap);
                }
            },en_hours,en_mins,false);
            tpd.show();
        }

        if(v == button_register) {
            timeClass transportStTime = new timeClass(st_hours, st_mins, st_ap);
            timeClass transportEnTime = new timeClass(en_hours, en_mins, en_ap);
            dateClass transportDate = new dateClass(day, month, year);

            String src = editText_src.getText().toString();
            String dest = editText_dest.getText().toString();

            String data_id = databaseReference.push().getKey();

            transportData data = new transportData(transportDate, transportStTime, transportEnTime, src, dest, data_id, id);

            databaseReference.child(data_id).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Registered...", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            finish();
            startActivity(new Intent(new_transport.this, transport.class));

        }
    }
}
