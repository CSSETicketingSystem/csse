package com.example.ticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RechargeActivity extends AppCompatActivity {
    Button confirm;
    EditText name,cardno,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        name=findViewById(R.id.name);
        cardno=findViewById(R.id.cardno);
        amount=findViewById(R.id.amount);
        confirm=findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Name = name.getText().toString().trim();
                String Cno = cardno.getText().toString().trim();
                String Amount=amount.getText().toString().trim();
                
                boolean isValid=true;

                if(Name.isEmpty()){
                    name.setError("Enter the User Name");
                    name.requestFocus();
                    isValid=false;
                }
                if(Cno.isEmpty()){
                    cardno.setError("Enter the Card No");
                    cardno.requestFocus();
                    isValid=false;
                }
                if(Amount.isEmpty()){
                    amount.setError("Enter the Amount");
                    amount.requestFocus();
                    isValid=false;
                }if(isValid){
                    Toast.makeText(RechargeActivity.this, "Recharged Successfully!!!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RechargeActivity.this, AccountBalanceActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
