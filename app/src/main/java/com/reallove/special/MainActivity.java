package com.reallove.special;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;
import com.reallove.special.Adapter.GridAdapter;
import com.reallove.special.Adapter.RecyclerAdapter;
import com.reallove.special.Adapter.Recyler_Cardview_Adapter;
import com.reallove.special.Adapter.recyclerFliperAdapter;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imgmic;
    RecyclerView recycler,recyclerfliper,recylercardview;
    ViewFlipper viewflipper,flipperbottom;
    LinearLayout lineardelivery;
    GridView gridview;
    BottomNavigationView bottomnavigation;



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==200 && resultCode==RESULT_OK){
            ArrayList<String> arraylist = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String voice = arraylist.get(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        lineardelivery = findViewById(R.id.lineardelivery);
        imgmic = findViewById(R.id.imgmic);
        recycler = findViewById(R.id.recycler);
        viewflipper = findViewById(R.id.viewflipper);
        recyclerfliper = findViewById(R.id.recylerfliper);
        recylercardview = findViewById(R.id.recyclercardview);
        gridview = findViewById(R.id.gridview);
        flipperbottom = findViewById(R.id.flipperbottom);
        bottomnavigation = findViewById(R.id.bottomnavigation);

      bottomnavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
          Fragment temp;
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {

              switch (item.getItemId()){
                  case R.id.home:
                      Intent intent = new Intent(MainActivity.this,MainActivity.class);
                      startActivity(intent);
                      onBackPressed();
                      break;
                  case R.id.profile:
                      Intent intent1 = new Intent(MainActivity.this,ProfileActivity.class);
                      startActivity(intent1);
                      break;
                  case R.id.cart:
                      Intent intent2 = new Intent(MainActivity.this,CartActivity.class);
                      startActivity(intent2);
                      break;

              }



              return true;
          }
      });


        int image[] = {R.drawable.jeans,R.drawable.sleeper,R.drawable.saree4,R.drawable.dslrimage,R.drawable.sunglasses,
                R.drawable.tshirtprinted,R.drawable.courtpent,R.drawable.frokimage,R.drawable.watchesimage};

        String name [] = {"Jeans","Sleeper","Saree","Dslr Camera","Sunglasses","t-shirt","Court_Paint","Frock","Watches"};


        gridview.setAdapter(new GridAdapter(name, image,this));


        recylercardview.setLayoutManager(new GridLayoutManager(this,2));

        int imgclothes [] = {R.drawable.clothesimage,R.drawable.bagimage,R.drawable.shoesimage,R.drawable.watchimagess};



        String texttopbrandes [] = {"Top Brandes","Latest Trends","Bestsallers" ,"Fashions"};


        recylercardview.setAdapter(new Recyler_Cardview_Adapter(imgclothes,texttopbrandes,MainActivity.this));






        lineardelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(),bottomSheetFragment.getTag());


            }
        });

        recycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        int imgfashion[] = {R.drawable.fashionimages,R.drawable.headphoneimage,R.drawable.electronicimage,R.drawable.essentialimage,
                           R.drawable.mobileimages, R.drawable.booksimages,R.drawable.pharmacyimage};

        String textfashion[] = {"  Fashion","Headphon.."," Electronic"," Essential","  Mobiles","    Books"," Pharmacy"};



           recycler.setAdapter(new RecyclerAdapter(imgfashion,textfashion,MainActivity.this));

           recyclerfliper.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

           int imgtshirt[] = {R.drawable.tshirtimage,R.drawable.iphoneimage,R.drawable.earpodsimage,
                              R.drawable.watchimage, R.drawable.speakerimage,
                               R.drawable.jacketimage,R.drawable.fridgeimage};

           recyclerfliper.setAdapter(new recyclerFliperAdapter(imgtshirt,MainActivity.this));


        imgmic.setOnClickListener(new View.OnClickListener() {
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

        int imagearray[] = {R.drawable.mobileflip,R.drawable.pharmacyflipper,R.drawable.electronicflipper,
                           R.drawable.bookflipper,R.drawable.essentialflipper,R.drawable.fashionflipper,
                            R.drawable.headphoneflipper};

        for (int i = 0; i<imagearray.length;i++)
            showimage(imagearray[i]);






        int flipperbottom[] = {R.drawable.kurtaimage,R.drawable.pendrive,R.drawable.mackup,R.drawable.lockerimage,
                               R.drawable.mopimage};

      for (int j = 0; j<flipperbottom.length;j++)
          showimagebottom(flipperbottom[j]);


        }






    public void showimage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        viewflipper.addView(imageView);
        viewflipper.setFlipInterval(3000);
        viewflipper.setAutoStart(true);


        viewflipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewflipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void showimagebottom(int imgbottom){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(imgbottom);

        flipperbottom.addView(imageView);
        flipperbottom.setFlipInterval(5000);
        flipperbottom.setAutoStart(true);

       flipperbottom.setInAnimation(this, android.R.anim.slide_in_left);
        flipperbottom.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}