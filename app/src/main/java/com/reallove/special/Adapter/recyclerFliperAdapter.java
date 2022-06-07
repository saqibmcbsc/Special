package com.reallove.special.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reallove.special.Allu_t_Shirt_click;
import com.reallove.special.R;

public class recyclerFliperAdapter extends RecyclerView.Adapter<recyclerFliperAdapter.RecylerfiperVH> {

    int imgtshirt[];
    Context context;

    public recyclerFliperAdapter(int[] imgtshirt,Context context) {
        this.imgtshirt = imgtshirt;
        this.context = context;
    }

    @NonNull
    @Override
    public RecylerfiperVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_fliper_layout,parent,false);
        return new RecylerfiperVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerfiperVH holder, int position) {

        holder.imgtshirt.setImageResource(imgtshirt[position]);
        holder.imgtshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Allu_t_Shirt_click.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return imgtshirt.length;
    }

    class RecylerfiperVH extends RecyclerView.ViewHolder{

        ImageView imgtshirt;

        public RecylerfiperVH(@NonNull View itemView) {
            super(itemView);

            imgtshirt = itemView.findViewById(R.id.imgtshirt);
        }
    }
}
