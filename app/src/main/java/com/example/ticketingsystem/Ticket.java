package com.example.ticketingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ticket extends AppCompatActivity {

    Button home ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ticket );

        home = (Button) findViewById(R.id.home1);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHome();
            }
        });

    }

    public void openHome(){
        Intent intent = new Intent(Ticket.this, Homepage.class);
        startActivity(intent);
    }

}

