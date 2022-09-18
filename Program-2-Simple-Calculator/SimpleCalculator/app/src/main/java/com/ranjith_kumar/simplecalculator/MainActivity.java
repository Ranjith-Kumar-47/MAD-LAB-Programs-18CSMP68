package com.ranjith_kumar.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);

        textViewOutput = findViewById(R.id.textViewOutput);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = editTextNumber1.getText().toString();
                String number2 = editTextNumber2.getText().toString();

                if (!number1.equals("") && !number2.equals("")) {
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    int total = num1 + num2;
                    textViewOutput.setText("Result: "+total);
                } else {
                    Toast.makeText(getApplicationContext(), "enter the numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = editTextNumber1.getText().toString();
                String number2 = editTextNumber2.getText().toString();

                if (!number1.equals("") && !number2.equals("")) {
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    int total = num1 - num2;
                    textViewOutput.setText("Result: "+total);
                } else {
                    Toast.makeText(getApplicationContext(), "enter the numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = editTextNumber1.getText().toString();
                String number2 = editTextNumber2.getText().toString();

                if (!number1.equals("") && !number2.equals("")) {
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    int total = num1 * num2;
                    textViewOutput.setText("Result: "+total);
                } else {
                    Toast.makeText(getApplicationContext(), "enter the numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = editTextNumber1.getText().toString();
                String number2 = editTextNumber2.getText().toString();

                if (!number1.equals("") && !number2.equals("")) {
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    if (num2==0)
                    {
                        Toast.makeText(getApplicationContext(),"Second number is zero",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int total = num1 / num2;
                        textViewOutput.setText("Result: " + total);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "enter the numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}