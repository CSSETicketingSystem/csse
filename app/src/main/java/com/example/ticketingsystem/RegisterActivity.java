package com.example.ticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button button;
    EditText editText2,editText,editText3;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editText2=findViewById(R.id.editText2);
        editText=findViewById(R.id.editText);
        editText3=findViewById(R.id.editText3);
        textView2=findViewById(R.id.textView2);
        button=findViewById(R.id.button);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String Name = editText2.getText().toString().trim();
                String Email = editText.getText().toString().trim();
                String Password = editText3.getText().toString().trim();
                boolean isValid=true;
                if(Name.isEmpty()){
                    editText2.setError("Enter the User Name");
                    editText2.requestFocus();
                    isValid=false;
                }
                if(Email.isEmpty()){
                    editText.setError("Enter the Email");
                    editText.requestFocus();
                    isValid=false;
                }else if(!Email.matches(emailPattern)) {
                    editText.setError("Invalid  EmailAddress");
                    editText.requestFocus();
                    isValid=false;
                }
                if(Password.isEmpty()){
                    editText3.setError("Enter the Password");
                    editText3.requestFocus();
                    isValid=false;
                }if(isValid){
                    Intent intent = new Intent(RegisterActivity.this, Homepage.class);
                    Toast.makeText(RegisterActivity.this, "Registered In Successfully!!!", Toast.LENGTH_LONG).show();
                    startActivity(intent);}


            }
        });
    }
}