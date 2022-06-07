package com.reallove.special.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reallove.special.BuyNow_Activity;
import com.reallove.special.R;

public class PriceAdapter2 extends RecyclerView.Adapter<PriceAdapter2.PriceAdapterVH2> {

   int imgoneplus[];
   String phoneprice[];
   Context context;

    public PriceAdapter2(int[] imgoneplus, String[] phoneprice, Context context) {
        this.imgoneplus = imgoneplus;
        this.phoneprice = phoneprice;
        this.context = context;
    }

    @NonNull
    @Override
    public PriceAdapterVH2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.phone_layout,parent,false);

        return new PriceAdapterVH2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PriceAdapterVH2 holder, int position) {

        holder.imgoneplus.setImageResource(imgoneplus[position]);
        holder.phoneprice.setText(phoneprice[position]);

        holder.linearphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BuyNow_Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imgoneplus.length;
    }

    class PriceAdapterVH2 extends RecyclerView.ViewHolder{

        ImageView imgoneplus;
        TextView phoneprice;
        LinearLayout linearphone;

        public PriceAdapterVH2(@NonNull View itemView) {
            super(itemView);

            imgoneplus = itemView.findViewById(R.id.imgoneplus);
            phoneprice = itemView.findViewById(R.id.phoneprice);
            linearphone = itemView.findViewById(R.id.linearphone);
        }
    }
}
