package com.reallove.special;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class CreateAccount_Activity extends AppCompatActivity {

    Button btncreateaccount;
    TextInputEditText edtyourname,edtemaill,edtmobile,edtpasswordd,edtconfirmpassword;
    TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getSupportActionBar().hide();


        btncreateaccount = findViewById(R.id.btncreateaccount);
        edtyourname = findViewById(R.id.edtyourname);
        edtemaill= findViewById(R.id.edtemaill);
        edtmobile = findViewById(R.id.edtmobile);
        edtpasswordd = findViewById(R.id.edtpasswordd);
        edtconfirmpassword = findViewById(R.id.edtconfirmpassword);
        signin = findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccount_Activity.this,Login_Activity.class);
                startActivity(intent);
            }
        });


        btncreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtyourname.getText().toString().isEmpty()){
                    edtyourname.setError("Please Enter your Name");
                    edtyourname.requestFocus();
                }
                else if (edtemaill.getText().toString().isEmpty()){
                    edtemaill.setError("Please Enter Your Email");
                    edtemaill.requestFocus();

                }
                else if (edtmobile.getText().toString().isEmpty()){
                    edtmobile.setError("Please Enter Your Mobile No");
                    edtmobile.requestFocus();
                }
                else if (edtpasswordd.getText().toString().isEmpty()){
                    edtpasswordd.setError("Please Enter Your Password");
                    edtpasswordd.requestFocus();
                }
                else if (!edtconfirmpassword.getText().toString().equals(edtpasswordd.getText().toString())){
                    edtconfirmpassword.setError("Please Enter Valid Password");
                    edtconfirmpassword.requestFocus();
                }
                else {
                    Toast.makeText(CreateAccount_Activity.this, "Account Create Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateAccount_Activity.this,Login_Activity.class);
                    startActivity(intent);

                }

            }
        });

    }
}