package com.example.ticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView txtsignup;
    EditText txtname,txtpassword;
    Button button;

    Button log ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtsignup=findViewById(R.id.signup);
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = txtname.getText().toString().trim();
                String Password = txtpassword.getText().toString().trim();
                boolean isValid=true;
                if(Name.isEmpty()){
                    txtname.setError("Enter the User Name");
                    txtname.requestFocus();
                    isValid=false;
                }
                if(Password.isEmpty()){
                    txtpassword.setError("Enter the Password");
                    txtpassword.requestFocus();
                    isValid=false;
                }

            }
        });

        log=findViewById(R.id.button);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });


    }

    public void openLogin(){
        Intent intent = new Intent(LoginActivity.this, Homepage.class);
        startActivity(intent);
    }

}
