package com.example.ticketingsystem;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class timetableTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_table);


        ListView listView = (ListView) findViewById(R.id.listView);

        Time t1 = new Time("17","Kandy","Panadura","05:00");
        Time t2 = new Time("01","Kandy","Colombo","04:00");
        ArrayList<Time> arrayList = new ArrayList<>();
        arrayList.add(t1);
        arrayList.add(t2);

        TimeListAdopter timeListAdopter = new TimeListAdopter(this,R.layout.adopter_time_view_layout,arrayList);
        listView.setAdapter(timeListAdopter);

    }
}