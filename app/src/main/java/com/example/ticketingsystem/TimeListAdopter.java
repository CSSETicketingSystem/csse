package com.example.ticketingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TimeListAdopter extends ArrayAdapter<Time> {

    private Context mContext;
    int mResources;
    public TimeListAdopter(Context context, int resource, ArrayList<Time> objects){
        super(context,resource,objects);
        mContext = context;
        mResources = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String rootno = getItem(position).getRootno();
        String from = getItem(position).getFrom();
        String to = getItem(position).getTo();
        String time = getItem(position).getTime();

        Time T = new Time(rootno,from,to,time);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResources,parent,false);


        TextView trootno = (TextView) convertView.findViewById(R.id.textView3);
        TextView tfrom= (TextView) convertView.findViewById(R.id.textView4);
        TextView tto = (TextView) convertView.findViewById(R.id.textView2);
        TextView ttime = (TextView) convertView.findViewById(R.id.textView);
        trootno.setText(rootno);
        tfrom.setText(from);
        tto.setText(to);
        ttime.setText(time);
        return convertView;
    }
}

