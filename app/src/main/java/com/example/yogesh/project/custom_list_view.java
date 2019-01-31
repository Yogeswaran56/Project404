package com.example.yogesh.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class custom_list_view extends AppCompatActivity {


    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);


        listView=(ListView)findViewById(R.id.list);


        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Manoharan", "DeMonte Colony", "19"));
        dataModels.add(new DataModel("Vendor1", "Chrompet", "19"));
        dataModels.add(new DataModel("Vendor Two", "Okiyempet", "21"));
        dataModels.add(new DataModel("Pratt","Oragadam","24"));
        dataModels.add(new DataModel("Elephant", "Nungambakkam", "26"));
        dataModels.add(new DataModel("Vendor Five", "Saidapet", "26"));
        dataModels.add(new DataModel("Goutham", "Aavadi", "29"));
        dataModels.add(new DataModel("Manoharan","Teynampet","29"));
        dataModels.add(new DataModel("Inbam", "Besant Nagar", "30"));
        dataModels.add(new DataModel("Vendor 9", "Ambikapuram", "31"));
        dataModels.add(new DataModel("Sheero", "Raja Street", "31"));
        dataModels.add(new DataModel("Lolita","AGS Colony","32"));
        dataModels.add(new DataModel("Maari", "Kottivakkam", "33"));

        adapter= new CustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

//                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getLocation()+" API: "+dataModel.getPrice(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
                Intent i= new Intent(custom_list_view.this,BuyNow.class);
                startActivity(i);
            }
        });


    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
