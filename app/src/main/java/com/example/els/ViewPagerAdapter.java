package com.example.els;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;

    int images[] = {
            R.drawable.ic_on_boarding_1,
            R.drawable.ic_on_boarding_2,
            R.drawable.ic_on_boarding_3,
    };

    int headings[] = {
            R.string.heading_on_boarding_1,
            R.string.heading_on_boarding_2,
            R.string.heading_on_boarding_3,
    };

    int description[] = {
            R.string.heading_on_boarding_1,
            R.string.heading_on_boarding_2,
            R.string.heading_on_boarding_3,
    };

    public ViewPagerAdapter(Context context){

        this.context = context;

    }

    @Override
    public int getCount() {
        return  headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.on_boarding_view_pager,container,false);

        ImageView slide_title_image = (ImageView) view.findViewById(R.id.titleImage);
        TextView slide_description = (TextView) view.findViewById(R.id.text_description);

        slide_title_image.setImageResource(images[position]);
        slide_description.setText(description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
