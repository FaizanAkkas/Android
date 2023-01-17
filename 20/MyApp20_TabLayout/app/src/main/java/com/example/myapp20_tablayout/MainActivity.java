package com.example.myapp20_tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {
TabLayout tabLayout;
    MyAdaptor myAdaptor;
    TabItem firstitem,seconditem,thirditem;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        firstitem = findViewById(R.id.home_t1);
        seconditem= findViewById(R.id.sport_t2);
        thirditem= findViewById(R.id.music_t3);
        viewPager = findViewById(R.id.vp);
        myAdaptor = new MyAdaptor(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(myAdaptor);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }
        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });

    }
}