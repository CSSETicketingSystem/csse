package com.example.ticketingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DistanceCalcTwo extends AppCompatActivity {


    EditText etSource , etDestination ,Showdis;
    TextView textView ;
    String sType;
    double lat1 = 0, long1 = 0, lat2 = 0, long2 = 0;
    int flag = 0;

    Button tck , home ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_distance_calc_two );


        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        textView = findViewById(R.id.text_view);


        home = (Button) findViewById(R.id.home1);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHome();
            }
        });

        tck = (Button) findViewById(R.id.getticket);
        tck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openTicket();
            }
        });


        //initialize places
        Places.initialize(getApplicationContext(),"AIzaSyBbyAzHYFNYbj6M_kz9OLgEIrWJdxV-IxY");
        //AIzaSyBsbVDKxi6Aej7A_sLE0XxzTDjZ5l6sDBM
        //AIzaSyCYd9DNtP8fAnic_H5XwgCef7dmqj_7vB0

        //set edit text
        etSource.setFocusable(false);
        etSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //define the type
                sType = "source";

                //initialize place field list
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG);

                //create intent
                Intent intent = new Autocomplete.IntentBuilder(
                        AutocompleteActivityMode.OVERLAY,fields
                ).build( DistanceCalcTwo.this);

                //start result
                startActivityForResult(intent, 100);
            }
        });

        //set edit text
        etDestination.setFocusable(false);
        etDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //define type
                sType = "destination";

                //initialize place field list
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG);

                //create intent
                Intent intent = new Autocomplete.IntentBuilder(
                        AutocompleteActivityMode.OVERLAY,fields
                ).build(DistanceCalcTwo.this);

                //start result
                startActivityForResult(intent, 100);
            }
        });

        //set test on textview
        textView.setText("0.0 Kilometers");
    }

    @Override
    protected  void onActivityResult(int requestCode , int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        //check conditions
        if( requestCode == 100 && resultCode == RESULT_OK ){

            //SUCCESS
            //Initialize place
            Place place = Autocomplete.getPlaceFromIntent(data);

            //check condition
            if (sType.equals("source")){

                //when the type is source
                flag++ ;

                etSource.setText(place.getAddress());

                String sSource = String.valueOf(place.getLatLng());
                sSource = sSource.replaceAll("lat/lng: ", "");
                sSource = sSource.replace("(", "");
                sSource = sSource.replace(")", "");
                String[] split = sSource.split(",");
                lat1 = Double.parseDouble(split[0]);
                long1 = Double.parseDouble(split[1]);

            }else{

                //when type is destination
                flag++ ;

                etDestination.setText(place.getAddress());

                String sDestination = String.valueOf(place.getLatLng());
                sDestination = sDestination.replaceAll("lat/lng: ", "");
                sDestination = sDestination.replace("(","");
                sDestination = sDestination.replace(")","");
                String[] split = sDestination.split(",");
                lat2 = Double.parseDouble(split[0]);
                long2 = Double.parseDouble(split[1]);

            }

            //Check conditions
            if (flag >= 2 ){
                //calculate distance
                distance(lat1,long1,lat2,long2);
            }else if(requestCode == AutocompleteActivity.RESULT_ERROR){
                Status status = Autocomplete.getStatusFromIntent(data);

                Toast.makeText(getApplicationContext(),status.getStatusMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void distance( double lat1 , double long1, double lat2, double long2){

        double longDiff = long1 - long2 ;
        double distance = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(longDiff));
        distance = Math.acos(distance);

        distance = deg2rad(distance);

        distance = distance * 60 * 1.1515 ;

        distance = distance * 1.609344;

        //set distance on text view
        textView.setText(String.format( Locale.US, "%2f kilometers", distance));
    }

    //convert degree to radian
    private double deg2rad(double lat1){
        return (lat1*Math.PI/180.0);
    }

    public void openTicket(){
        Intent intent = new Intent(DistanceCalcTwo.this, Ticket.class);
        startActivity(intent);
    }

    public void openHome(){
        Intent intent = new Intent(DistanceCalcTwo.this, Homepage.class);
        startActivity(intent);
    }

}