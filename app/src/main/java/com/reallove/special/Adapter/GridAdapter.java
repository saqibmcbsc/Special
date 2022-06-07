package com.reallove.special.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reallove.special.R;
import com.reallove.special.Select_Categories_Activity;

public class GridAdapter extends BaseAdapter {
    private final String name[];
    private final int image[];
    Context context;

    public GridAdapter(String[] name, int[] image, Context context) {
        this.name = name;
        this.image = image;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return image.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.gridview_layout,null);

        ImageView imgsaree = (ImageView) view.findViewById(R.id.imgsaree);
        TextView textsaree = (TextView) view.findViewById(R.id.textsaree);

        imgsaree.setImageResource(image[position]);
        textsaree.setText(name[position]);

        imgsaree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Select_Categories_Activity.class);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
