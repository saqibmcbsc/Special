package com.reallove.special.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reallove.special.BuyNow_Activity;
import com.reallove.special.R;

public class ShowPhone_Adabter extends RecyclerView.Adapter<ShowPhone_Adabter.ShowPhoneVH> {

    int imgshowphone[];
    Context context;

    public ShowPhone_Adabter(int[] imgshowphone,Context context) {
        this.imgshowphone = imgshowphone;
        this.context = context;
    }



    @NonNull
    @Override
    public ShowPhoneVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_showphone_layout,parent,false);

        return new ShowPhoneVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowPhoneVH holder, int position) {

        holder.imgshowphone.setImageResource(imgshowphone[position]);
        holder.imgshowphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BuyNow_Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imgshowphone.length;
    }

    class ShowPhoneVH extends RecyclerView.ViewHolder{

        ImageView imgshowphone;

        public ShowPhoneVH(@NonNull View itemView) {
            super(itemView);

            imgshowphone = itemView.findViewById(R.id.imgshowphone);
        }
    }
}
