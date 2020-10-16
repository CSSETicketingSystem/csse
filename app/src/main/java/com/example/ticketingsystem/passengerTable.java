package com.example.ticketingsystem;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class passengerTable extends AppCompatActivity {

   // RecyclerView  mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_table);

        ListView listView = (ListView) findViewById(R.id.listView);

        Person p1 = new Person("Kamal","P01","0778906754");
        Person p2 = new Person("Nimal","P02","0774532912");
        Person p3 = new Person("Jesi","P03","0774534512");
        Person p4 = new Person("David","P04","0774531112");
        Person p5 = new Person("Saman","P05","0774672912");

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);
        arrayList.add(p4);
        arrayList.add(p5);

        PersonListAdopter personListAdopter = new PersonListAdopter(this,R.layout.adaptor_view_layout,arrayList);
        listView.setAdapter(personListAdopter);

    }
}