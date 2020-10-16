package com.example.ticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AssignBus extends AppCompatActivity {

    public Button btn;
    public EditText from,to,date,root,busno;

    public String sbusno;
    public String sfrom;
    public String sto;
    public String sroot;
    public String sdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_bus);



        btn = findViewById(R.id.button);
        from = findViewById(R.id.editTextTime);
        to = findViewById(R.id.editTextTime2);
        date = findViewById(R.id.editTextDate);
        busno = findViewById(R.id.editTextNumber2);
        root = findViewById(R.id.editTextNumber);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfrom = from.getText().toString();
                sto = to.getText().toString();
                sroot = root.getText().toString();
                sdate = date.getText().toString();
                sbusno = busno.getText().toString();

                if(sfrom.equals("")||sto.equals("")||sroot.equals("")||sdate.equals("")||sbusno.equals("")){
                    Toast.makeText(AssignBus.this,"Fields are empty!",Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent = new Intent(AssignBus.this,AssignIspector.class);
                    startActivity(intent);
                }
            }
        });
    }
}