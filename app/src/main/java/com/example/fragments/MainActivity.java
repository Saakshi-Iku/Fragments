package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout th;
    ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        th=(TabLayout)findViewById(R.id.tabhead);
        vp=(ViewPager)findViewById(R.id.viewPager1);
        vp.setAdapter(new MyfragmentAdapter(getSupportFragmentManager()));
        th.setupWithViewPager(vp);
        th.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



     class MyfragmentAdapter extends FragmentPagerAdapter {
        public MyfragmentAdapter( FragmentManager fm) {
            super(fm);
        }

        String names[]={"Frag1","Frag2","Frag3"};
         @NonNull
         @Override
         public Fragment getItem(int position) {
            if(position==0)return new frag1();
            else if(position==1)return new frag2();
            else if(position==2)return new frag3();
             return null;
         }

         @Override
         public int getCount() {
             return names.length;
         }

         @Nullable
         @Override
         public CharSequence getPageTitle(int position) {
             return names[position];
         }
     }
}