package com.reallove.special;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.reallove.special.Adapter.SelectProduct_Adapter;

public class Select_Categories_Activity extends AppCompatActivity {

    ImageView imgback;
    RecyclerView recyclerproductselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_categories);
        getSupportActionBar().hide();

        imgback = findViewById(R.id.imgback);
        recyclerproductselect = findViewById(R.id.recyclerproductselect);

        recyclerproductselect.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        String []textoff = {"40% off","25% off","18% off","49% off","75% off","60% off","35% off","12% off","29% off",
                           "10% off","65% off","55% off","45% off","5% off","80% off"};

        String []textmoney = {"15,99/-","18,00/-","21,50/-","23,89/-","34,75/-","29,90/-","24,10/-","17,99/-","25,49/-",
                             "14,99/-","41,90/-","38,59/-","37,99/-","11,99/-","47,49/-"};

        int []imgkurta1 = {R.drawable.kurta1,R.drawable.kurta2,R.drawable.kurta3,R.drawable.kurta4,R.drawable.kurta5,
                          R.drawable.kurta6,R.drawable.kurta7,R.drawable.kurta8,R.drawable.kurta9,R.drawable.kurta10,
                          R.drawable.kurta11,R.drawable.kurta12,R.drawable.kurta13,R.drawable.kurta14,R.drawable.kurta15};

   int []imgkurtasmall = {R.drawable.kurta1,R.drawable.kurta2,R.drawable.kurta3,R.drawable.kurta4,R.drawable.kurta5,
                         R.drawable.kurta6,R.drawable.kurta7,R.drawable.kurta8,R.drawable.kurta9,R.drawable.kurta10,
                         R.drawable.kurta11,R.drawable.kurta12,R.drawable.kurta13,R.drawable.kurta14,R.drawable.kurta15};

           recyclerproductselect.setAdapter(new SelectProduct_Adapter(textoff,textmoney,imgkurta1,imgkurtasmall,Select_Categories_Activity.this));


        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(Select_Categories_Activity.this,Categries2_Activity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });

    }
}