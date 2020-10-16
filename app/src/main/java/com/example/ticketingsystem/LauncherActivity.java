package com.example.ticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LauncherActivity extends AppCompatActivity {
    Button letsgo;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        image=findViewById(R.id.image);

        letsgo=findViewById(R.id.letsgo);
        letsgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
