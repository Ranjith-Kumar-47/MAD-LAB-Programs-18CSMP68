package com.ranjith_kumar.sign_insign_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button buttonSignUp;
    EditText editTextGmail , editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignUp = findViewById(R.id.buttonSignUp);
        editTextGmail = findViewById(R.id.editTextGmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextGmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if(!name.equals("") && !password.equals("")){
                    if(!ValidatePassword(password))
                    {
                        Toast.makeText(getApplicationContext(),"Password does not match the requirement",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this,SignIn_Activity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("password", password);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"enter the gmail and password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean ValidatePassword(String password) {
        Pattern lowerCase = Pattern.compile("^.*[a-z].*$");
        Pattern upperCase = Pattern.compile("^.*[A-Z].*$");
        Pattern number = Pattern.compile("^.*[0-9].*$");
        Pattern specialCase = Pattern.compile("^.*[^a-zA-Z0-9].*$");

        if(password.length()<8)
            return false;

        if (!lowerCase.matcher(password).matches())
            return  false;

        if(!upperCase.matcher(password).matches())
            return false;

        if (!number.matcher(password).matches())
            return false;

        if (!specialCase.matcher(password).matches())
            return false;

        return true;

    }
}