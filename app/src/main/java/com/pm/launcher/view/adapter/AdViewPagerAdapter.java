package com.pm.launcher.view.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by user on 2017/10/9.
 */

public class AdViewPagerAdapter extends PagerAdapter {
    private ArrayList<ImageView> mImageViews;

    public AdViewPagerAdapter(ArrayList<ImageView> mViews){
        mImageViews=mViews;
    }

    @Override
    public int getCount() {
        return mImageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mImageViews.get(position));
        return mImageViews.get(position);
    }
}
