package com.example.ticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AssignDriver extends AppCompatActivity {

    public Button btn;
    public EditText from,to,date,root;
    AutoCompleteTextView auto;
    public String sname;
    public String sfrom;
    public String sto;
    public String sroot;
    public String sdate;

    private static final String[] drivernames = new String[]{"K.Nishaan","M.S.Suraweera","Madava"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_driver);


        btn = findViewById(R.id.button);
        from = findViewById(R.id.editTextTime);
        to = findViewById(R.id.editTextTime2);
        date = findViewById(R.id.editTextDate);
        auto = findViewById(R.id.autoCompleteTextView);
        root = findViewById(R.id.editTextNumber);

        auto.setThreshold(1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(AssignDriver.this,android.R.layout.simple_dropdown_item_1line,drivernames);
        auto.setAdapter(adapter);

        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auto.showDropDown();
                sname = auto.getText().toString();

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfrom = from.getText().toString();
                sto = to.getText().toString();
                sroot = root.getText().toString();
                sdate = date.getText().toString();

                if(sfrom.equals("")||sto.equals("")||sroot.equals("")||sdate.equals("")){
                    Toast.makeText(AssignDriver.this,"Fields are empty!",Toast.LENGTH_SHORT).show();
                }else{


                    Intent intent = new Intent(AssignDriver.this,AssignBus.class);
                    startActivity(intent);
                }
            }
        });
    }
    /*
    public boolean onNavigationItemSelected(MenuItem menuitem){
        switch (menuitem.getItemId()){
            case R.id.nav_home;
            break;
            case R.id.nav_logout;
              Intent intent =  new Intent(MainActivity.this,As)
        }
     */
}

