package com.metris.metris.Home;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.metris.metris.Authorization.RegisterFragment_1;
import com.metris.metris.Authorization.RegisterFragment_2;
import com.metris.metris.Home.MyTrips.CompletedFragment;
import com.metris.metris.Home.MyTrips.ToPayFragment;
import com.metris.metris.Home.MyTrips.UpcomingFragment;
import com.metris.metris.R;

import java.util.ArrayList;
import java.util.List;

public class MyTripsFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mytrips, null);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.mytrips_tab1)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.mytrips_tab2)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.mytrips_tab3)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final TripAdapter adapter = new TripAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    public class TripAdapter extends FragmentPagerAdapter {
        private int NUM_ITEMS = 3;

        public TripAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ToPayFragment fragment_1 = new ToPayFragment();
                    return fragment_1;
                case 1:
                    UpcomingFragment fragment_2 = new UpcomingFragment();
                    return fragment_2;
                case 2:
                    CompletedFragment fragment_3 = new CompletedFragment();
                    return fragment_3;
                default:
                    return null;
            }
        }
    }


}