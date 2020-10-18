package com.example.ticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView txtsignup;
    EditText txtname,txtpassword;
    Button button;

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
        txtname=findViewById(R.id.editText2);
        txtpassword=findViewById(R.id.editText);
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
                }if(isValid){
                    Intent intent = new Intent(LoginActivity.this, Homepage.class);
                Toast.makeText(LoginActivity.this, "Logged In Successfully!!!", Toast.LENGTH_LONG).show();
                    startActivity(intent);}
            }
        });
    }
}