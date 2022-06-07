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
import com.reallove.special.TopBrandes_Activity;

public class Recyler_Cardview_Adapter extends RecyclerView.Adapter<Recyler_Cardview_Adapter.RecyclerCardVH> {

    int imgclothes[];
   // String[] imgwatch;
    String[] texttopbrandes;
   // String textbestsellers[];
    Context context;




    public Recyler_Cardview_Adapter(int[] imgclothes, String[] texttopbrandes,Context context) {

        this.imgclothes = imgclothes;
        this.texttopbrandes = texttopbrandes;
        //this.imgwatch = imgwatch;
      //  this.textbestsellers = textbestsellers;
        this.context = context;
    }




    @NonNull
    @Override
    public RecyclerCardVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_card_view,parent,false);

        return new RecyclerCardVH(view);




    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCardVH holder, int position) {

        holder.imgclothes.setImageResource(imgclothes[position]);
      // holder.imgwatch.setImageResource(Integer.parseInt(imgwatch[position]));
        holder.texttopbrandes.setText(texttopbrandes[position]);
     //   holder.textbestsallers.setText(textbestsellers[position]);

        holder.imgclothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(context,TopBrandes_Activity.class);
              context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class RecyclerCardVH extends RecyclerView.ViewHolder{

        ImageView imgclothes,imgwatch;
        TextView texttopbrandes,textbestsallers;


        public RecyclerCardVH(@NonNull View itemView) {
            super(itemView);

            imgclothes = itemView.findViewById(R.id.imgclothes);
            texttopbrandes = itemView.findViewById(R.id.texttopbrandes);
         //   imgwatch = itemView.findViewById(R.id.imgwatch);
          //  textbestsallers = itemView.findViewById(R.id.textbestsellers);


        }
    }

}
