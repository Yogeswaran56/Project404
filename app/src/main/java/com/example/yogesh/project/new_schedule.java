package com.example.yogesh.project;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
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

import java.util.Calendar;

public class new_schedule extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    
    private EditText editText_Cal, editText_startTime, editText_endTime, editText_District, editText_Place;
    private Button button_schedule, button_cancel;
    private int day, month, year, hours, mins, ampm;
    private String ap;
    private Spinner district_select;
    
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


        district_select.setOnItemSelectedListener(this);
        editText_Cal.setOnClickListener(this);
        editText_startTime.setOnClickListener(this);
        editText_endTime.setOnClickListener(this);
        button_cancel.setOnClickListener(this);

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
            hours = c.get(Calendar.HOUR_OF_DAY);
            mins = c.get(Calendar.MINUTE);
            ampm = c.get(Calendar.AM_PM);

            TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(ampm==1 && hourOfDay>12){
                        hourOfDay-=12;
                        ap = "PM";
                    }
                    else
                        ap = "AM";
                    String hourOfDayString = String.format("%02d",hourOfDay);
                    String minuteString = String.format("%02d",minute);
                    editText_startTime.setText(hourOfDayString + ":" + minuteString + ap);
                }
            },hours,mins,false);
            tpd.show();
        }

        if(v == editText_endTime) {
            final Calendar c = Calendar.getInstance();
            hours = c.get(Calendar.HOUR_OF_DAY);
            mins = c.get(Calendar.MINUTE);
            ampm = c.get(Calendar.AM_PM);

            TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(ampm==1 && hourOfDay>12){
                        hourOfDay-=12;
                        ap = "PM";
                    }
                    else
                        ap = "AM";
                    String hourOfDayString = String.format("%02d",hourOfDay);
                    String minuteString = String.format("%02d",minute);
                    editText_endTime.setText(hourOfDayString + ":" + minuteString + ap);
                }
            },hours,mins,false);
            tpd.show();
        }

        if(v == button_cancel) {
            finish();
            startActivity(new Intent(this, schedule.class));
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected_item = parent.getItemAtPosition(position).toString();
        if(!selected_item.equals("Choose town:")) {
            Toast.makeText(getApplicationContext(), selected_item, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
