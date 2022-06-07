package com.reallove.special;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {

    ImageView imageback,imgcover,imgprofile;
   CardView cardcamera,cardcamera2;
   Button btnlogout,btneditprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();

        imageback = findViewById(R.id.imageback);
        imgcover = findViewById(R.id.imgcover);
        cardcamera = findViewById(R.id.cardcamera);
        imgprofile = findViewById(R.id.imgprofile);
        cardcamera2 = findViewById(R.id.cardcamera2);
        btnlogout = findViewById(R.id.btnlogout);
        btneditprofile = findViewById(R.id.btneditprofile);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,Login_Activity.class);
                startActivity(intent);
            }
        });

        btneditprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,CreateAccount_Activity.class);
                startActivity(intent);
            }
        });

        cardcamera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,500);
            }
        });

        cardcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1000);

            }
        });



        imageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000 && resultCode == RESULT_OK){
            imgcover.setImageURI(data.getData());

        }
        if (requestCode==500 && resultCode == RESULT_OK){
            imgprofile.setImageURI(data.getData());
        }
    }
}