package com.platzi.platzigram.view;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.platzi.platzigram.R;
import com.platzi.platzigram.view.fragment.HomeFragment;
import com.platzi.platzigram.view.fragment.ProfileFragment;
import com.platzi.platzigram.view.fragment.SearchFragment;

import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;


public class ContainerActivity extends AppCompatActivity {

private BottomNavigationView bottomNavigationView;
private Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        initializeComponentes();
        showFragment( new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.tabSearch:
                        fragment = new SearchFragment();
                        break;

                    case R.id.tabHome:
                        fragment = new HomeFragment();
                        break;

                    case R.id.tabProfile:
                        fragment = new ProfileFragment();
                        break;
                }
                return showFragment(fragment);
            }
        });
    }

    public void initializeComponentes(){
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
    }

    public boolean showFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null).commit();
            return true;
        }
        return false;
    }
}
