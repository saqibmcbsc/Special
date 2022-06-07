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

import com.reallove.special.BuyNow_Activity;
import com.reallove.special.R;

public class AlluAdapter extends RecyclerView.Adapter<AlluAdapter.AlluVH> {
    String name[];
    String backup[];
    String price[];
    int imgearpods[];
    Context context;


    public AlluAdapter(String[] name, String[] backup, String[] price, int[] imgearpods, Context context) {
        this.name = name;
        this.backup = backup;
        this.price = price;
        this.imgearpods = imgearpods;
        this.context = context;
    }

    @NonNull
    @Override
    public AlluVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.allu_t_shirt_layout,parent,false);

        return new AlluVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlluVH holder, int position) {

        holder.name.setText(name[position]);
        holder.backup.setText(backup[position]);
        holder.price.setText(price[position]);
        holder.imgearpods.setImageResource(imgearpods[position]);

        holder.imgearpods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BuyNow_Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imgearpods.length;
    }

    class AlluVH extends RecyclerView.ViewHolder{

        TextView name,backup,price;
        ImageView imgearpods;

        public AlluVH(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            backup = itemView.findViewById(R.id.backup);
            price = itemView.findViewById(R.id.price);
            imgearpods = itemView.findViewById(R.id.imgearpods);
        }
    }

}
