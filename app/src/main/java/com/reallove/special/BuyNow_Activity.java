package com.reallove.special;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class BuyNow_Activity extends AppCompatActivity {

    ImageView backkk,imgshare;
    Spinner spinnerqty;
    String []arr = {"Qty","1","2","3","4","5","6","7","8","9","10"};
    Button btnbuynow,btnaddcart;
    Dialog dialog;
    TextInputEditText edtname,edtmobile,edtaadharno,edtpanno,edtaddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);
        getSupportActionBar().hide();


        backkk = findViewById(R.id.backkk);
        imgshare = findViewById(R.id.imgshare);
        spinnerqty = findViewById(R.id.spinnerqty);
        btnbuynow = findViewById(R.id.btnbuynow);
        dialog = new Dialog(this);
        btnaddcart = findViewById(R.id.btnaddcart);

        btnaddcart.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Toast.makeText(BuyNow_Activity.this, "Add to cart", Toast.LENGTH_SHORT).show();
              btnaddcart.setBackgroundColor(R.color.white);
            }
        });

        btnbuynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              openDetailsDialouge();
            }

            private void openDetailsDialouge() {

                dialog.setContentView(R.layout.address_layout);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button btnsubmit = dialog.findViewById(R.id.btnsubmit);
                ImageView imgclose = dialog.findViewById(R.id.imgclose);
                edtname = dialog.findViewById(R.id.edtname);
                edtmobile =dialog.findViewById(R.id.edtmobile);
                edtaadharno = dialog.findViewById(R.id.edtaadharno);
                edtpanno = dialog.findViewById(R.id.edtpanno);
                edtaddress = dialog.findViewById(R.id.edtaddress);


                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if(edtname.getText().toString().isEmpty()){
                            edtname.setError("Please Enter Name");
                            edtname.requestFocus();
                        }
                        else if (edtmobile.getText().toString().isEmpty()){
                            edtmobile.setError("Please Enter Mobile No");
                            edtmobile.requestFocus();
                        }
                        else if (edtaadharno.getText().toString().isEmpty()){
                            edtaadharno.setError("Please Enter Aadhar No");
                            edtaadharno.requestFocus();
                        }
                        else if (edtpanno.getText().toString().isEmpty()){
                            edtpanno.setError("Please Enter Pan No");
                            edtpanno.requestFocus();
                        }
                        else if (edtaddress.getText().toString().isEmpty()){
                            edtaddress.setError("Please Enter Address");
                            edtaddress.requestFocus();
                        }
                        else {
                            Toast.makeText(BuyNow_Activity.this, "Order Done", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

                imgclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerqty.setAdapter(adapter);

        imgshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Application Link is Here");
                startActivity(Intent.createChooser(intent,"Share Via"));
            }
        });

        backkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(BuyNow_Activity.this,Mobile_image_Activity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });
    }
}