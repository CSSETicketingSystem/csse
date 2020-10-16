package com.example.ticketingsystem;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class financeTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_table);

        ListView listView = (ListView) findViewById(R.id.listView);

        Income i1 = new Income("45000.00","12000.00","32000.00","10000.00");
        Income i2 = new Income("56000.00","14000.00","23000.00","11000.00");

        ArrayList<Income> arrayList = new ArrayList<>();
        arrayList.add(i1);
        arrayList.add(i2);

        FinanceListAdopter financeListAdopter = new FinanceListAdopter(this,R.layout.adopter_time_view_layout,arrayList);
        listView.setAdapter(financeListAdopter);
    }
}