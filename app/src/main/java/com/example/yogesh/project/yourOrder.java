package com.example.yogesh.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class yourOrder extends Activity
        implements OnItemClickListener {
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.sportsList);

        String[] sports = getResources().getStringArray(R.array.order_array);
        //Row layout defined by Android: android.R.layout.simple_list_item_1
        listView.setAdapter(new ArrayAdapter(this, R.layout.yourorderlist, sports));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view,
                            int position, long id) {
        Toast toast = Toast.makeText(getApplicationContext(), "Farmer:    Price:     ", Toast.LENGTH_SHORT);
        toast.show();
    }
}
