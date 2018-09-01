package com.metris.metris.Welcome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.metris.metris.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] sliderImage = {
            R.drawable.img_tickets,
            R.drawable.img_camping,
            R.drawable.img_indian,
            R.drawable.img_coral
    };

    public int[] sliderSubs1 = {
            R.string.intro_1_textview_subtitle_1,
            R.string.intro_2_textview_subtitle_1,
            R.string.intro_3_textview_subtitle_1,
            R.string.intro_4_textview_subtitle_1
    };

    public int[] sliderSubs2 = {
            R.string.intro_1_textview_subtitle_2,
            R.string.intro_2_textview_subtitle_2,
            R.string.intro_3_textview_subtitle_2,
            R.string.intro_4_textview_subtitle_2
    };

    public int[] sliderCons = {
            R.string.intro_1_textview_content,
            R.string.intro_2_textview_content,
            R.string.intro_3_textview_content,
            R.string.intro_4_textview_content
    };

    @Override
    public int getCount() {
        return sliderImage.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_intro, container, false);

        ImageView sliderImageView = (ImageView)view.findViewById(R.id.intro_slider_image);
        TextView sliderSubtitle1 = (TextView) view.findViewById(R.id.intro_slider_subtitle_1);
        TextView sliderSubtitle2 = (TextView) view.findViewById(R.id.intro_slider_subtitle_2);
        TextView sliderContent = (TextView) view.findViewById(R.id.intro_slider_content);

        sliderImageView.setImageResource(sliderImage[position]);
        sliderSubtitle1.setText(context.getResources().getString(sliderSubs1[position]));
        sliderSubtitle2.setText(context.getResources().getString(sliderSubs2[position]));
        sliderContent.setText(context.getResources().getString(sliderCons[position]));

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
