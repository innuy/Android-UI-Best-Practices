package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.diegoinsua.uibestpracticesexample.fragment.ImageFullscreenFragment;

/**
 * Created on 8/7/16.
 * @author INNUY
 */
public class ImagePagerAdapter extends FragmentStatePagerAdapter {

    private static final int IMG_QUANTITY = 10;

    public ImagePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFullscreenFragment.newInstance(position % 4);
    }

    @Override
    public int getCount() {
        return IMG_QUANTITY;
    }
}
