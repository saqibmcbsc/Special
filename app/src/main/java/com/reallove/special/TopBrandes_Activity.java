package com.reallove.special;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;

import com.reallove.special.Adapter.BrandsAdapter;
import com.reallove.special.Adapter.RecyclerrrTopBrandAdapter;

import java.util.ArrayList;

public class TopBrandes_Activity extends AppCompatActivity {

    ImageView backbutton,imagemicc;
    RecyclerView recyclerrr,recyclerbrands;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == RESULT_OK){
            ArrayList<String>arrayList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String voice = arrayList.get(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_brandes);
        getSupportActionBar().hide();

        backbutton =findViewById(R.id.backbutton);
        imagemicc = findViewById(R.id.imagemicc);
        recyclerrr = findViewById(R.id.recyelerrr);
        recyclerbrands = findViewById(R.id.recyclerbrands);


        recyclerbrands.setLayoutManager(new GridLayoutManager(this,2));

        String []textdiscount = {"Up to 76% off","Up to 54% off","Up to 30% off","Up to 59% off","Up to 33% off",
                               "Up to 18% off","Up to 12% off","Up to 21% off","Up to 49% off","Up to 40% off",
                                "Up to 10% off","Up to 15% off","Up to 35% off","Up to 45% off","Up to 50% off"};

        int []imagefashion1 = {R.drawable.fashion1,R.drawable.fashion6,R.drawable.fashion11,
                             R.drawable.fashion2,R.drawable.fashion7,R.drawable.fashion12,R.drawable.fashion3,
                             R.drawable.fashion8, R.drawable.fashion13,R.drawable.fashion4,R.drawable.fashion9,
                             R.drawable.fashion14, R.drawable.fashion5,R.drawable.fashion10,R.drawable.fashion15};

        recyclerbrands.setAdapter(new BrandsAdapter(textdiscount,imagefashion1,TopBrandes_Activity.this));


        recyclerrr.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        String []textmansfashion = {"Men's Fashion","Women's Fashion", "Kid's Fashion"};
        int []imagefashion = {R.drawable.fashionbrands,R.drawable.femalefashionbrand,R.drawable.kidsfashionbrands};

        recyclerrr.setAdapter(new RecyclerrrTopBrandAdapter(textmansfashion,imagefashion,TopBrandes_Activity.this));


        imagemicc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVoiceDialog();
            }

            private void openVoiceDialog() {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent,200);
            }
        });



        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(TopBrandes_Activity.this,MainActivity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });
    }
}