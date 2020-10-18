package com.example.ticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccountBalanceActivity extends AppCompatActivity {

    Button recharge ;
    TextView textView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_balance);

        recharge=findViewById(R.id.button);
        textView9=findViewById(R.id.textView9);
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountBalanceActivity.this, RechargeActivity.class);
                startActivity(intent);
            }
        });


    }

}

