package com.example.myapp21_navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nv);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       select_item(item);

        return true;
    }
    //-----------------this function is used to change the item in navigation view

    private void select_item(MenuItem menuitem) {
        Fragment fragment = null;
        Class fc;
        switch (menuitem.getItemId())
        {
            case R.id.menu_tab1:
                fc=DashboardFragment.class;
                break;
            case R.id.menu_tab2:
                fc=VideoFragment.class;
                break;
            case R.id.menu_tab3:
                fc=MusicFragment.class;
                break;
            default:
                fc=DashboardFragment.class;
        }
        try {
         fragment =(Fragment)  fc.newInstance();


        }catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fl_content,fragment).commit();
drawerLayout.closeDrawers();
    }
}