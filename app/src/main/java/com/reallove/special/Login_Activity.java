package com.reallove.special;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login_Activity extends AppCompatActivity {

    Button btnlogin,newcustomer;
    TextInputEditText edtemail,edtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        btnlogin = findViewById(R.id.btnlogin);
        edtemail = findViewById(R.id.edtemail);
        edtpassword = findViewById(R.id.edtpassword);
        newcustomer = findViewById(R.id.newcustomer);

        newcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this,CreateAccount_Activity.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtemail.getText().toString().isEmpty()){
                    edtemail.setError("Please Enter Email or Mobile No");
                    edtemail.requestFocus();
                }
                else if (edtpassword.getText().toString().isEmpty()){
                    edtpassword.setError("Please Enter Password");
                    edtpassword.requestFocus();
                }
                else {
                   Intent intent = new Intent(Login_Activity.this,MainActivity.class);
                   startActivity(intent);
                }

            }
        });
    }
}