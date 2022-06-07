package com.reallove.special;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.reallove.special.Adapter.PhoneAdapter;
import com.reallove.special.Adapter.PriceAdapter;

import java.util.ArrayList;

public class Mobile_image_Activity extends AppCompatActivity {

    ImageView backarroww,imgmiccc;
    LinearLayout lineardeliveryy;
    RecyclerView recyclerprice,recyclerphones;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==200 && requestCode == RESULT_OK){
            ArrayList<String> arrayList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String voice = arrayList.get(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_image);
        getSupportActionBar().hide();

        backarroww = findViewById(R.id.backarroww);
        lineardeliveryy = findViewById(R.id.lineardeliveryy);
        imgmiccc = findViewById(R.id.imgmiccc);
        recyclerprice = findViewById(R.id.recyclerprice);
        recyclerphones = findViewById(R.id.recyclerphones);

        recyclerphones.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        int imgoneplus [] = {R.drawable.oneplus1,R.drawable.oneplus2,R.drawable.oneplus3,R.drawable.oneplus4,
                            R.drawable.oneplus5,R.drawable.oneplus6,R.drawable.oneplus7};

        String phoeprice [] = {"29,999","34,999","42,499","52,900","24,390","68,999","74,589"};

        recyclerphones.setAdapter(new PhoneAdapter(imgoneplus,phoeprice,Mobile_image_Activity.this));

        recyclerprice.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        String textprice[] = {"10,000","15,000","20,000","30,000","40,000","50,000","80,000","2-lakh"};

        recyclerprice.setAdapter(new PriceAdapter(textprice,Mobile_image_Activity.this));

        imgmiccc.setOnClickListener(new View.OnClickListener() {
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

        lineardeliveryy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(),bottomSheetFragment.getTag());
            }
        });



        backarroww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(Mobile_image_Activity.this,Categries_Activity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });


    }
}