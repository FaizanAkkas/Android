package com.example.myapp18_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GV_Custom extends ArrayAdapter {
    Context mycontext;
    int[] item_images;
    String[] item_tile;

    public GV_Custom(@NonNull Context context, int[] images,String[] title) {
        super(context,R.layout.single_item,R.id.txt_title,title);
        mycontext = context;
        item_images= images;
        item_tile = title;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mycontext);
        View view=inflater.inflate(R.layout.single_item,parent,false);
         ImageView imageView =  view.findViewById(R.id.img_view);
        TextView textView= view.findViewById(R.id.txt_title);
        //----------------------------------------------setter operation
        imageView.setImageResource(item_images[position]);
        textView.setText(item_tile[position]);
        return view;
    }
}
