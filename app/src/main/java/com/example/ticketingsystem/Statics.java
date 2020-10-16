package com.example.ticketingsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Statics extends AppCompatActivity {


    ViewPager v;
    TabLayout t;
    //TabItem f1,f2,f3;
    PagerAdapter pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statics);


        v = findViewById(R.id.vp);
        t = findViewById(R.id.tb);


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Passengers");
        arrayList.add("Finance");
        arrayList.add("Timetable");

        prepareViewPager(v, arrayList);

        t.setupWithViewPager(v);
    }

    private void prepareViewPager(ViewPager v, ArrayList<String> arrayList) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());

        finance fin = new finance();
        Paasengers pass = new Paasengers();
        Timetable tim = new Timetable();

        for (int i=0;i<arrayList.size();i++){
            if(i == 0){
                Bundle bundle = new Bundle();
                bundle.putString("title",arrayList.get(i));
                pass.setArguments(bundle);
                adapter.addFragment(pass,arrayList.get(i));
                pass = new Paasengers();
            }
            else if(i == 1){
                Bundle bundle = new Bundle();
                bundle.putString("title",arrayList.get(i));
                fin.setArguments(bundle);
                adapter.addFragment(fin,arrayList.get(i));
                fin = new finance();
            }
            else{
                Bundle bundle = new Bundle();
                bundle.putString("title",arrayList.get(i));
                tim.setArguments(bundle);
                adapter.addFragment(tim,arrayList.get(i));
                tim = new Timetable();
            }
        }
        v.setAdapter(adapter);
    }


    private class MainAdapter extends FragmentPagerAdapter {
        ArrayList<String> arrayList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();
        public void addFragment(Fragment fragment,String title){

            arrayList.add(title);
            fragmentList.add(fragment);

        }
        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }
    }
}