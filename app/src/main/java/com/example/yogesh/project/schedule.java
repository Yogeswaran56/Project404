package com.example.yogesh.project;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class schedule extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        button_add = findViewById(R.id.fab_add);

        button_add.setOnClickListener(this);
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
