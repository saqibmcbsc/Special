package com.reallove.special;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.reallove.special.Adapter.AlluAdapter;

import java.util.ArrayList;

public class Allu_t_Shirt_click extends AppCompatActivity {

    ImageView backbtn;
    ImageView imagemic;
    RecyclerView recyclerallu;










    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200 && resultCode == RESULT_OK);
        ArrayList<String>arrayList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

        String voice = arrayList.get(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allu_tshirt_click);
        getSupportActionBar().hide();


        backbtn = findViewById(R.id.backbtn);
        imagemic = findViewById(R.id.imagemic);
        recyclerallu = findViewById(R.id.recyclerallu);

        recyclerallu.setLayoutManager(new GridLayoutManager(this,2));

        String []names = {"Boat EarPods","JBL EarPods","Hammer HeadPhone","UBON EarPods",
                "Boat EarPods","JBL EarPods","Hammer HeadPhone","UBON EarPods",
                "Boat EarPods","JBL EarPods","Hammer HeadPhone","UBON EarPods",
                "Boat EarPods","JBL EarPods","Hammer HeadPhone"};

        String []backups = {"Use for 36 hours on a Single Charge","Use for 30 hours on a Single Charge","Use for 26 hours on a Single Charge",
                "Use for 24 hours on a Single Charge","Use for 20 hours on a Single Charge","Use for 16 hours on a Single Charge",
                "Use for 14 hours on a Single Charge","Use for 12 hours on a Single Charge","Use for 10 hours on a Single Charge",
                "Use for 8 hours on a Single Charge","Use for 5 hours on a Single Charge","Use for 48 hours on a Single Charge",
                "Use for 42 hours on a Single Charge","Use for 72 hours on a Single Charge","Use for 32 hours on a Single Charge"};

        String []prices = {"\u20b9 1,599","\u20b9 1,790","\u20b9 1,200","\u20b9 1,100","\u20b9 2,349","\u20b9 2,589",
                          "\u20b9 2,000","\u20b9 2,879","\u20b9 2,649","\u20b9 3,999","\u20b9 1,700",
                           "\u20b9 2,300","\u20b9 4,990","\u20b9 7,299","\u20b9 5,339"};

        int []images = {R.drawable.ear1,R.drawable.ear2,R.drawable.ear3,R.drawable.ear4,R.drawable.ear5,
                R.drawable.ear6,R.drawable.ear7,R.drawable.ear8,R.drawable.ear9,R.drawable.ear10,R.drawable.ear11,
                R.drawable.ear12,R.drawable.ear13,R.drawable.ear14,R.drawable.ear15};
        Log.d("length", "onCreate: "+names.length+", "+backups.length+" "+prices.length+" "+images.length);

        recyclerallu.setAdapter(new AlluAdapter(names,backups,prices,images,Allu_t_Shirt_click.this));



        imagemic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVoiceDialouge();
            }

            private void openVoiceDialouge() {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent,200);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(Allu_t_Shirt_click.this,MainActivity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });
    }
}