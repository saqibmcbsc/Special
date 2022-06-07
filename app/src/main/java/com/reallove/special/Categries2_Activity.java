package com.reallove.special;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.reallove.special.Adapter.Categories2Adapter;

public class Categries2_Activity extends AppCompatActivity {

    ImageView backarr;
    RecyclerView recyclercategories2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categries2);
        getSupportActionBar().hide();

        backarr = findViewById(R.id.backarr);
        recyclercategories2 = findViewById(R.id.recyclercategries2);

        recyclercategories2.setLayoutManager(new GridLayoutManager(this,2));

        String []textcategoriesname = {"Court Pant","Formals Dress","Formal Pants","Shirt's","Jacket's","Jeans Pants","Kurta Pajama",
                                       "T-Shirt's"};

        int []imagecategories2 = {R.drawable.categories1,R.drawable.categories2,R.drawable.categories3,R.drawable.categories4,
                                 R.drawable.categories5,R.drawable.categories6,R.drawable.categories7,R.drawable.categories8};

        recyclercategories2.setAdapter(new Categories2Adapter(textcategoriesname,imagecategories2,Categries2_Activity.this));

        backarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(Categries2_Activity.this,TopBrandes_Activity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });


    }
}