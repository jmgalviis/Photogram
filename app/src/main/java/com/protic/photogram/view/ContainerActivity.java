package com.protic.photogram.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.protic.photogram.R;
import com.protic.photogram.view.fragment.HomeFragment;
import com.protic.photogram.view.fragment.ProfileFragment;
import com.protic.photogram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        final HomeFragment homeFragment = new HomeFragment();
        final ProfileFragment profileFragment  = new ProfileFragment();
        final SearchFragment searchFragment = new SearchFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, homeFragment)
                    .commit();
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottombar);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                    addFragment(homeFragment);
                    break;
                    case R.id.profile:
                    addFragment(profileFragment);
                    break;
                    case R.id.search:
                    addFragment(searchFragment);
                    break;
                }
                return true;
            }
            //Set fragment
            private void addFragment(Fragment fragment) {
                if (null != fragment) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null)
                            .commit();
                }
            }

        });
    }
}
