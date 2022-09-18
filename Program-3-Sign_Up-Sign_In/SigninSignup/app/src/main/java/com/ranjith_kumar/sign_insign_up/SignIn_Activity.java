package com.ranjith_kumar.sign_insign_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn_Activity extends AppCompatActivity {

    Button buttonSignIn;
    EditText editTextGmail , editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        buttonSignIn = findViewById(R.id.buttonSignIn);
        editTextGmail = findViewById(R.id.editTextGmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        Intent intent = getIntent();
        String InputName = intent.getStringExtra("name");
        String InputPassword = intent.getStringExtra("password");

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editTextGmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (password.equals(InputPassword) && name.equals(InputName))
                    startActivity(new Intent(SignIn_Activity.this , Successful_Page.class));
                else
                    Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_SHORT).show();

            }
        });
    }
}