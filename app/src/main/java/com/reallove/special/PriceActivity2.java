package com.reallove.special;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.reallove.special.Adapter.PriceAdapter2;

public class PriceActivity2 extends AppCompatActivity {

    ImageView backk;
    RecyclerView recyclerprice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price2);
        getSupportActionBar().hide();

        backk = findViewById(R.id.backk);
        recyclerprice2 = findViewById(R.id.recyclerprice2);

        recyclerprice2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        int imgoneplus [] = {R.drawable.oneplus1,R.drawable.oneplus2,R.drawable.oneplus3,R.drawable.oneplus4,
                R.drawable.oneplus5,R.drawable.oneplus6,R.drawable.oneplus7};

        String phoeprice [] = {"29,999","34,999","42,499","52,900","24,390","68,999","74,589"};

        recyclerprice2.setAdapter(new PriceAdapter2(imgoneplus,phoeprice,PriceActivity2.this));


        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(PriceActivity2.this,Mobile_image_Activity.class);
//                startActivity(intent);
                onBackPressed();
            }
        });
    }
}