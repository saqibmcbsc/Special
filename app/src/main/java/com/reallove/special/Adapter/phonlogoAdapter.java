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

import com.reallove.special.Mobile_image_Activity;
import com.reallove.special.R;

public class phonlogoAdapter extends RecyclerView.Adapter<phonlogoAdapter.PhonelogoVH> {

    String textphone[];
    int imgphonelogo[];
    Context context;

    public phonlogoAdapter(String[] textphone, int[] imgphonelogo, Context context) {
        this.textphone = textphone;
        this.imgphonelogo = imgphonelogo;
        this.context = context;
    }

    @NonNull
    @Override
    public PhonelogoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.recycler_phonelogo_layout,parent,false);

        return new PhonelogoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhonelogoVH holder, int position) {

        holder.textphone.setText(textphone[position]);
        holder.imgphonelogo.setImageResource(imgphonelogo[position]);

        holder.imgphonelogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Mobile_image_Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imgphonelogo.length;
    }

    class PhonelogoVH extends RecyclerView.ViewHolder{

        ImageView imgphonelogo;
        TextView textphone;

        public PhonelogoVH(@NonNull View itemView) {
            super(itemView);

            imgphonelogo = itemView.findViewById(R.id.imgphonelogo);
            textphone = itemView.findViewById(R.id.textphone);
        }
    }
}
