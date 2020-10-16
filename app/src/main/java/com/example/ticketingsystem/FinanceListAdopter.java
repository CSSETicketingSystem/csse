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

public class FinanceListAdopter extends ArrayAdapter<Income> {

    private Context mContext;
    int mResources;
    public FinanceListAdopter(Context context, int resource, ArrayList<Income> objects){
        super(context,resource,objects);
        mContext = context;
        mResources = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String income = getItem(position).getIncome();
        String fuel = getItem(position).getFuel();
        String machin = getItem(position).getMachin();
        String other = getItem(position).getOther();

        Income in = new Income(income,fuel,machin,other);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResources,parent,false);


        TextView tincome= (TextView) convertView.findViewById(R.id.textView3);
        TextView tfuel= (TextView) convertView.findViewById(R.id.textView4);
        TextView tmachin = (TextView) convertView.findViewById(R.id.textView2);
        TextView tother = (TextView) convertView.findViewById(R.id.textView);

        tincome.setText(income);
        tfuel.setText(fuel);
        tmachin.setText(machin);
        tother.setText(other);

        return convertView;
    }
}

