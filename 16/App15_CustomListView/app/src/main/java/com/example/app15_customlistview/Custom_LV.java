package com.example.app15_customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Custom_LV extends ArrayAdapter {
    Context mycontext;
    String[] heading;
    String[] des;
    int[] social_icon;
    String[] social_owner;
    public Custom_LV(@NonNull Context context,String[] title,String[] description, int[] image,String[] owner) {
        super(context,R.layout.design_lv,R.id.lst_title,title);
        mycontext = context;
        heading= title;
        des =description;
        social_icon = image;
        social_owner = owner;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mycontext);
        View row=layoutInflater.inflate(R.layout.design_lv,parent,false);
        TextView textView_tit= row.findViewById(R.id.lst_title);
        TextView textView_des =row.findViewById(R.id.lst_des);
        ImageView imageView =row.findViewById(R.id.lst_image);
        TextView textView_owner =row.findViewById(R.id.lst_owner);
        textView_tit.setText(heading[position]);
        textView_des.setText(des[position]);
        textView_owner.setText(social_owner[position]);
        imageView.setImageResource(social_icon[position]);
        return row;
    }
}
