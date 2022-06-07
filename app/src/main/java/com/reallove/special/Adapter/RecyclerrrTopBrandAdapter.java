package com.reallove.special.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.reallove.special.Categries2_Activity;
import com.reallove.special.R;

public class RecyclerrrTopBrandAdapter extends RecyclerView.Adapter<RecyclerrrTopBrandAdapter.TopBrandsVH> {

    String []textmensfashion;
    int []imagefashion;
    Context context;

    public RecyclerrrTopBrandAdapter(String[] textmensfashion, int[] imagefashion, Context context) {
        this.textmensfashion = textmensfashion;
        this.imagefashion = imagefashion;
        this.context = context;
    }

    @NonNull
    @Override
    public TopBrandsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerrr_layout,parent,false);
        return new TopBrandsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopBrandsVH holder, int position) {

        holder.textmenfashion.setText(textmensfashion[position]);
        holder.imagefashion.setImageResource(imagefashion[position]);

        holder.imagefashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Categries2_Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imagefashion.length;
    }

    class TopBrandsVH extends RecyclerView.ViewHolder{

        ImageView imagefashion;
        TextView textmenfashion;

        public TopBrandsVH(@NonNull View itemView) {
            super(itemView);

            imagefashion = itemView.findViewById(R.id.imagefashion);
            textmenfashion = itemView.findViewById(R.id.textmenfashion);
        }
    }
}
