package com.metris.metris.Authorization;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.metris.metris.R;

public class RegisterActivity extends AppCompatActivity {

    ViewPager registerViewPager;
    FragmentPagerAdapter fragmentPagerAdapter;
    private LinearLayout registerDotLayout;
    private TextView[] dots;

    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerDotLayout = (LinearLayout) findViewById(R.id.register_dot);
        registerButton = (Button) findViewById(R.id.register_button_register);
        registerViewPager = (ViewPager) findViewById(R.id.register_pager);
        fragmentPagerAdapter = new RegisterAdapter(getSupportFragmentManager());
        registerViewPager.setAdapter(fragmentPagerAdapter);

        addDotsIndicators(0);

        registerViewPager.addOnPageChangeListener(viewListener);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registerButton.getText().toString().equalsIgnoreCase("lanjutkan")) {
                    registerButton.setText(getResources().getString(R.string.register_button_register));
                    registerViewPager.setCurrentItem(1);
                } else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(RegisterActivity.this);
                    builder1.setMessage("We need API!!!!");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent welcomeIntent = new Intent(RegisterActivity.this, RegisteredActivity.class);
                                    startActivity(welcomeIntent);
                                    finish();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent welcomeIntent = new Intent(RegisterActivity.this, RegisteredActivity.class);
                                    startActivity(welcomeIntent);
                                    finish();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                }
            }
        });

    }

    public void addDotsIndicators(int position) {
        dots = new TextView[2];
        registerDotLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.transparantwhite));

            registerDotLayout.addView(dots[i]);

        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.blueText));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(final int position) {
            addDotsIndicators(position);
            if(position == 0)
                registerButton.setText(getResources().getString(R.string.register_button_next));
            else
                registerButton.setText(getResources().getString(R.string.register_button_register));
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public static class RegisterAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public RegisterAdapter(FragmentManager fragmentManager) {
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
                    RegisterFragment_1 fragment_1 = new RegisterFragment_1();
                    return fragment_1;
                case 1:
                    RegisterFragment_2 fragment_2 = new RegisterFragment_2();
                    return fragment_2;
                default:
                    return null;
            }
        }
    }
}