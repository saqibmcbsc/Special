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

public class SelectProduct_Adapter extends RecyclerView.Adapter<SelectProduct_Adapter.SelectProductVH> {

    String []textoff;
    String []textmoney;
    int []imgkurta1;
    int []imgkurtasmall;
    Context context;

    public SelectProduct_Adapter(String[] textoff, String[] textmoney, int[] imgkurta1, int[] imgkurtasmall, Context context) {
        this.textoff = textoff;
        this.textmoney = textmoney;
        this.imgkurta1 = imgkurta1;
        this.imgkurtasmall = imgkurtasmall;
        this.context = context;
    }

    @NonNull
    @Override
    public SelectProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.select_product_layout,parent,false);


        return new SelectProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectProductVH holder, int position) {

        holder.textoff.setText(textoff[position]);
        holder.textmoney.setText(textmoney[position]);
        holder.imgkurta1.setImageResource(imgkurta1[position]);
        holder.imgkurtasmall.setImageResource(imgkurtasmall[position]);

       holder.linearkurta.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, BuyNow_Activity.class);
               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return imgkurta1.length;
    }

    class SelectProductVH extends RecyclerView.ViewHolder{

        ImageView imgkurta1,imgkurtasmall;
        TextView textoff,textmoney;
        LinearLayout linearkurta;

        public SelectProductVH(@NonNull View itemView) {
            super(itemView);

            imgkurta1 = itemView.findViewById(R.id.imgkurta1);
            imgkurtasmall = itemView.findViewById(R.id.imgkurtasmall);
            textoff = itemView.findViewById(R.id.textoff);
            textmoney = itemView.findViewById(R.id.textmoney);
            linearkurta = itemView.findViewById(R.id.linearkurta);

        }
    }
}
