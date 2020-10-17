package com.example.ticketingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {

    Button logout , history , account , statics , assign , start ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        logout=findViewById(R.id.logoutbtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        account=findViewById(R.id.accountbtn);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, AccountBalanceActivity.class);
                startActivity(intent);
            }
        });


        assign=findViewById(R.id.assignbtn);
        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, AssignDriver.class);
                startActivity(intent);
            }
        });


        statics=findViewById(R.id.staticsbtn);
        statics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Statics.class);
                startActivity(intent);
            }
        });

        start=findViewById(R.id.startbtn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, getDistance.class);
                startActivity(intent);
            }
        });

     /* history=findViewById(R.id.historybtn);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,<Activity>.class);
                startActivity(intent);
            }
        });*/


    }

}