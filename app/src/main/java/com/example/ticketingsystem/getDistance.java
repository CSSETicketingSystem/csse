package com.example.ticketingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class getDistance extends AppCompatActivity {

    EditText etPlace;
    Button btSubmit , calcc;
    TextView tvAddress;
    TextView distancer ;
    Button calcu , home ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_distance);

        etPlace = findViewById(R.id.et_place);
        btSubmit = findViewById(R.id.submit);
        tvAddress = findViewById(R.id.tv_address);


        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = etPlace.getText().toString();
                GeoLocation geoLocation = new GeoLocation();
                geoLocation.getAddress( address,getApplicationContext(), new GeoHandler());
            }
        });


        calcu = (Button) findViewById(R.id.calc);
        calcu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDis();
            }
        });

        home = (Button) findViewById(R.id.home1);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHome();
            }
        });



    }

    public class GeoHandler extends Handler{

        @Override
        public void handleMessage(Message msg){
            String address;
            switch (msg.what){
                case 1:
                    Bundle bundle = msg.getData();
                    address = bundle.getString( "address" );
                    break;
                default:
                    address = null;
            }
            tvAddress.setText(address);
        }

    }


    public void openDis(){
        Intent intent = new Intent(getDistance.this, DistanceCalcTwo.class);
        startActivity(intent);
    }

    public void openHome(){
        Intent intent = new Intent(getDistance.this, Homepage.class);
        startActivity(intent);
    }


}

