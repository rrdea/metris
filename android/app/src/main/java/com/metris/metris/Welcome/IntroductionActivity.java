package com.metris.metris.Welcome;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.metris.metris.Authorization.LoginActivity;
import com.metris.metris.R;

public class IntroductionActivity extends AppCompatActivity {

    private ViewPager introViewPager;
    private LinearLayout introDotLayout;
    private TextView introTitle;
    private SliderAdapter sliderAdapter;
    private TextView introTextViewLogin;

    private TextView[] dots;

    public int[] sliderTitle = {
            R.string.intro_1_textview_title,
            R.string.intro_2_textview_title,
            R.string.intro_3_textview_title,
            R.string.intro_4_textview_title
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        //instant
        introViewPager = (ViewPager) findViewById(R.id.intro_viewpager);
        introDotLayout = (LinearLayout) findViewById(R.id.intro_dot);
        introTitle = (TextView) findViewById(R.id.intro_title);
        introTextViewLogin = (TextView) findViewById(R.id.intro_textview_login);

        //action
        introTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeIntent = new Intent(IntroductionActivity.this, LoginActivity.class);
                startActivity(welcomeIntent);
            }
        });

        sliderAdapter = new SliderAdapter(this);
        introViewPager.setAdapter(sliderAdapter);

        addDotsIndicators(0);

        introViewPager.addOnPageChangeListener(viewListener);

    }

    public void addDotsIndicators(int position){
        dots = new TextView[4];
        introDotLayout.removeAllViews();

        for(int i=0; i<dots.length; i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.transparantwhite));

            introDotLayout.addView(dots[i]);

        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.blueText));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicators(position);
            introTitle.setText(getResources().getString(sliderTitle[position]));

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
