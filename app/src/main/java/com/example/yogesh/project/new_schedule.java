package com.example.yogesh.project;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class new_schedule extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    
    private EditText editText_Cal, editText_startTime, editText_endTime, editText_District, editText_Place;
    private Button button_schedule, button_cancel;

    private int day, month, year, hours, mins, ampm;
    private int en_hours, en_mins, st_hours, st_mins;

    private String selected_place, startTime, endTime, date, selected_town, st_ap, en_ap;

    private Spinner district_select;

    private String vendorID;

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReferenceVendorID, vendorInformation, vendorSchedules, vendorOrders, databaseReferenceCustomerRef;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_schedule);

        editText_Place = findViewById(R.id.edt_place);
        editText_startTime = findViewById(R.id.edt_startTime);
        editText_endTime = findViewById(R.id.edt_endTime);
        editText_Cal = findViewById(R.id.edt_date);
        //editText_District = findViewById(R.id.edt_district);
        district_select = findViewById(R.id.spinner);

        button_schedule = findViewById(R.id.btn_schedule);
        button_cancel = findViewById(R.id.btn_cancel);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.district_names, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district_select.setAdapter(arrayAdapter);
        district_select.setSelection(0);


        firebaseAuth = FirebaseAuth.getInstance();
        vendorID = firebaseAuth.getCurrentUser().getUid();

        databaseReferenceVendorID = FirebaseDatabase.getInstance().getReference("vendors").child(vendorID);
        databaseReferenceCustomerRef = FirebaseDatabase.getInstance().getReference("customers").child("vendorSchedules");

        vendorInformation = databaseReferenceVendorID.child("information");
        vendorSchedules = databaseReferenceVendorID.child("schedules");
        vendorOrders = databaseReferenceVendorID.child("orders");


        district_select.setOnItemSelectedListener(this);
        editText_Cal.setOnClickListener(this);
        editText_startTime.setOnClickListener(this);
        editText_endTime.setOnClickListener(this);
        button_cancel.setOnClickListener(this);
        button_schedule.setOnClickListener(this);

    }

    public void scheduleIt(scheduleData new_scheduledData) {
        //Toast.makeText(this, "Schedule fn", Toast.LENGTH_SHORT).show();
        String key = new_scheduledData.getKey();
        vendorSchedules.child(key).setValue(new_scheduledData).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Scheduled the event", Toast.LENGTH_SHORT).show();
                }
                else if(task.isCanceled()) {
                    Toast.makeText(getApplicationContext(), "Can't able to schedule, Try Again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        databaseReferenceCustomerRef.child(key).setValue(new_scheduledData);

        finish();
        startActivity(new Intent(this, schedule.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {

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
                    String hourOfDayString = String.format("%02d",hourOfDay);
                    String minuteString = String.format("%02d",minute);
                    editText_endTime.setText(hourOfDayString + ":" + minuteString + en_ap);
                }
            },en_hours,en_mins,false);
            tpd.show();
        }

        if(v == button_cancel) {
            finish();
            startActivity(new Intent(this, schedule.class));
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        }

        if(v == button_schedule) {
            timeClass scheduleStTime = new timeClass(st_hours, st_mins, st_ap);
            timeClass scheduleEnTime = new timeClass(en_hours, en_mins, en_ap);
            dateClass scheduleDate = new dateClass(day, month, year);
            selected_place = editText_Place.getText().toString();

            String data_id = vendorSchedules.push().getKey();

            scheduleData new_schedule = new scheduleData(scheduleDate, scheduleStTime, scheduleEnTime, selected_place, selected_town, data_id, vendorID);

            scheduleIt(new_schedule);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selected_town = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
