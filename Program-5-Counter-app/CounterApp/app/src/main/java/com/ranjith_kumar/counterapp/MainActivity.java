package com.ranjith_kumar.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonStart , buttonStop;
    TextView textViewOutput;
    long i=0;
    Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        textViewOutput = findViewById(R.id.textViewOutput);


        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Counter Started!", Toast.LENGTH_SHORT).show();
                    customHandler.postDelayed(updateTimerThread, 0);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Counter Stopped!",Toast.LENGTH_SHORT).show();
                customHandler.removeCallbacks(updateTimerThread);
                textViewOutput.setText("0");
                i = 0;
            }
        });

    }
    private final Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            textViewOutput.setText(i + "");
            customHandler.postDelayed(this, 1000);
            i++;
        }
    };

}