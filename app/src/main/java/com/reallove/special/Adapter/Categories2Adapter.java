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

import com.reallove.special.R;
import com.reallove.special.Select_Categories_Activity;

public class Categories2Adapter extends RecyclerView.Adapter<Categories2Adapter.Categories2VH> {

    String []textcategoriesname;
    int []imagecategories2;
    Context context;

    public Categories2Adapter(String[] textcategoriesname, int[] imagecategories2, Context context) {
        this.textcategoriesname = textcategoriesname;
        this.imagecategories2 = imagecategories2;
        this.context = context;
    }

    @NonNull
    @Override
    public Categories2VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.categories2_layout,parent,false);
        return new Categories2VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Categories2VH holder, int position) {

        holder.textcategoriesname.setText(textcategoriesname[position]);
        holder.imagecategories2.setImageResource(imagecategories2[position]);

        holder.imagecategories2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Select_Categories_Activity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return imagecategories2.length;
    }

    class Categories2VH extends RecyclerView.ViewHolder{
        ImageView imagecategories2;
        TextView textcategoriesname;

        public Categories2VH(@NonNull View itemView) {
            super(itemView);

            imagecategories2 = itemView.findViewById(R.id.imagecategories2);
            textcategoriesname = itemView.findViewById(R.id.textcategoriesname);
        }
    }
}
