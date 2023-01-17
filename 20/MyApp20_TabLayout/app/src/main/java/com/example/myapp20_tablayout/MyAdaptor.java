package com.example.myapp20_tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdaptor extends FragmentPagerAdapter {
    int tabcount;
    public MyAdaptor(@NonNull FragmentManager fm, int behavior,int tabs) {
        super(fm, behavior);
        tabcount = tabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeFragment hf = new HomeFragment();
                return hf;
            case 1:
                return new SportFragment();
            case 2:
                return new MusicFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return tabcount;
    }
}
