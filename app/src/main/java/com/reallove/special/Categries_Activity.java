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

import com.reallove.special.Adapter.ShowPhone_Adabter;
import com.reallove.special.Adapter.phonlogoAdapter;

import java.util.ArrayList;

public class Categries_Activity extends AppCompatActivity {

    ImageView backarrow,imgmicc;
    RecyclerView recyclerphonelogo,recyclershowphone;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==200 && resultCode == RESULT_OK){
            ArrayList<String> arrayList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String voice = arrayList.get(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categries);
        getSupportActionBar().hide();

        backarrow = findViewById(R.id.backarrow);
        imgmicc = findViewById(R.id.imgmicc);
        recyclerphonelogo = findViewById(R.id.recyclerphonelogo);
        recyclershowphone = findViewById(R.id.recyclershowphone);

        recyclershowphone.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        int imgshowphone[] = {R.drawable.oppoo,R.drawable.motoimage,R.drawable.oneplusimage,R.drawable.samsunggg,
                             R.drawable.appleee,R.drawable.lgimage,R.drawable.vivoimages,R.drawable.redmiphone};

        recyclershowphone.setAdapter(new ShowPhone_Adabter(imgshowphone,Categries_Activity.this));


        recyclerphonelogo.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        String textphone[] = {"Redmi","Vivo","iPhone","OnePlus","Motorola","LG","Samsung","Oppo"};
        int imgphonelogo[] = {R.drawable.mi,R.drawable.vivo,R.drawable.apple,R.drawable.oneplus
                             ,R.drawable.motorola,R.drawable.lg,R.drawable.samsung,R.drawable.oppo};

        recyclerphonelogo.setAdapter(new phonlogoAdapter(textphone,imgphonelogo,Categries_Activity.this));


        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(Categries_Activity.this,MainActivity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });

        imgmicc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVoiceDialouge();
            }

            private void openVoiceDialouge() {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

                startActivityForResult(intent, 200);

            }
        });
    }
}