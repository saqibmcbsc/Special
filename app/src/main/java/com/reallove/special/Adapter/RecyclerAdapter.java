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

import com.reallove.special.Categries_Activity;
import com.reallove.special.MainActivity;
import com.reallove.special.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    int imgfashion[];
    String textfashion[];
    Context context;



    public RecyclerAdapter(int[] imgfashion, String[] textfashion,Context context) {
        this.imgfashion = imgfashion;
        this.textfashion = textfashion;
        this.context = context;
    }



    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_layout,parent,false);



        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        holder.imgfashion.setImageResource(imgfashion[position]);
        holder.textfashion.setText(textfashion[position]);

        holder.imgfashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Categries_Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class RecyclerHolder extends RecyclerView.ViewHolder{

        ImageView imgfashion;
        TextView textfashion;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            imgfashion = itemView.findViewById(R.id.imgfashion);
            textfashion = itemView.findViewById(R.id.textfashion);
        }
    }

}
