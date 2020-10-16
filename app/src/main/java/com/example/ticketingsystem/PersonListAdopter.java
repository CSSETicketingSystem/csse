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

public class PersonListAdopter extends ArrayAdapter<Person> {

    private Context mContext;
    int mResources;
    public PersonListAdopter(Context context, int resource, ArrayList<Person> objects){
        super(context,resource,objects);
        mContext = context;
        mResources = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String sname = getItem(position).getName();
        String sid = getItem(position).getId();
        String cno = getItem(position).getCno();

        Person person = new Person(sname,sid,cno);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResources,parent,false);


      TextView  tid = (TextView) convertView.findViewById(R.id.textView3);
        TextView tname = (TextView) convertView.findViewById(R.id.textView4);
        TextView tcno = (TextView) convertView.findViewById(R.id.textView2);
        tid.setText(sid);
        tname.setText(sname);
        tcno.setText(cno);
        return convertView;
    }
}

