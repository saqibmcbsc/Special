package com.reallove.special.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reallove.special.R;
import com.reallove.special.Select_Categories_Activity;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.BrandsVH> {

    String textdiscount[];
    int imagefashion1[];
    Context context;

    public BrandsAdapter(String[] textdiscount, int[] imagefashion1, Context context) {
        this.textdiscount = textdiscount;
        this.imagefashion1 = imagefashion1;
        this.context = context;
    }

    @NonNull
    @Override
    public BrandsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_brands_layout,parent,false);
        return new BrandsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandsVH holder, int position) {
        holder.textdiscount.setText(textdiscount[position]);
        holder.imagefashion1.setImageResource(imagefashion1[position]);

        holder.imagefashion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Select_Categories_Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imagefashion1.length;
    }

    class BrandsVH extends RecyclerView.ViewHolder{

        ImageView imagefashion1;
        TextView textdiscount;

        public BrandsVH(@NonNull View itemView) {
            super(itemView);

            imagefashion1 = itemView.findViewById(R.id.imagefashion1);
            textdiscount = itemView.findViewById(R.id.textdiscount);
        }
    }
}
