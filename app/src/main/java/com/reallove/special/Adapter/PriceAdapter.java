package com.reallove.special.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reallove.special.Mobile_image_Activity;
import com.reallove.special.PriceActivity2;
import com.reallove.special.R;

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.PriceVH> {

    String textprice[];
    Context context;

    public PriceAdapter(String[] textprice, Context context) {
        this.textprice = textprice;
        this.context = context;
    }

    @NonNull
    @Override
    public PriceVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.price_layout,parent,false);
        return new PriceVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PriceVH holder, int position) {

        holder.textprice.setText(textprice[position]);
        holder.textprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PriceActivity2.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return textprice.length;
    }

    class PriceVH extends RecyclerView.ViewHolder{

        TextView textprice;

        public PriceVH(@NonNull View itemView) {
            super(itemView);

            textprice = itemView.findViewById(R.id.textprice);
        }
    }

}
