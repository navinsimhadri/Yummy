package com.simhadri.yummy.views;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.simhadri.yummy.R;
import com.simhadri.yummy.fragments.IngredientsFragment;
import com.simhadri.yummy.fragments.PreparationsFragment;

public class DetailsActivity extends AppCompatActivity {

    ViewPager vpHome;
    TabLayout tabLayout;
    PagerAdapter adapter;


    ImageView iv_display_images;
    TextView tv_recp_title,tv_recp_total_time,tv_recp_cook_time;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(getColor(R.color.detailscreen_bar));
        }

        setContentView(R.layout.food_respies_details);


        iv_display_images = (ImageView) findViewById(R.id.iv_display_images);

        tv_recp_title = (TextView) findViewById(R.id.tv_recp_title);
        tv_recp_total_time = (TextView) findViewById(R.id.tv_recp_total_time);
        tv_recp_cook_time = (TextView) findViewById(R.id.tv_recp_cook_time);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_notification);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setTitle(" ");
            getSupportActionBar().setWindowTitle(" ");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Ingredients"));
        //tabLayout.addTab(tabLayout.newTab().setText("Bookmarks"));
        tabLayout.addTab(tabLayout.newTab().setText("Preparations"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabLayout.setTabTextColors(Color.LTGRAY,Color.WHITE);

        vpHome = (ViewPager) findViewById(R.id.vpHome);

        adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        vpHome.setAdapter(adapter);

        vpHome.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpHome.setCurrentItem(tab.getPosition());

                if(tab.getPosition() == 1){

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }


    private class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;


        PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:

                    // set Fragmentclass Arguments
                    IngredientsFragment upcoming = new IngredientsFragment("");
                    return upcoming;
                case 1:
                    PreparationsFragment past = new PreparationsFragment("");
                    return past;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }

        @Override
        public int getItemPosition(Object object) {
            if (object instanceof IngredientsFragment) {
                // ((HgUpcomingAppointments) object).update();
            }
            return super.getItemPosition(object);
        }
    }


}