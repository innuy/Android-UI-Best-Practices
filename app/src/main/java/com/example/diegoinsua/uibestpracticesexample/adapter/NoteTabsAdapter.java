package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.fragment.ImageGridFragment;
import com.example.diegoinsua.uibestpracticesexample.fragment.NoteListFragment;

/**
 * Created on 6/7/16.
 * @author INNUY
 */
public class NoteTabsAdapter extends FragmentPagerAdapter {

    public static final int TABS_QUANTITY = 2;

    public NoteTabsAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        this.activity = activity;
    }

    private Activity activity;

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        if (position == 0) {
            fragment = new NoteListFragment();
        } else {
            fragment = new ImageGridFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return TABS_QUANTITY;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title;

        if (position == 0) {
            title = activity.getString(R.string.note_list_title);
        } else {
            title = activity.getString(R.string.image_list_title);
        }

        return title;
    }
}
