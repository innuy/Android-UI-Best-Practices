package com.example.diegoinsua.uibestpracticesexample.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.adapter.ImagePagerAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ImagePagerActivity extends AppCompatActivity {

    public static final String IMG_POS_KEY = "imagePositionKey";

    @InjectView(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pager);

        ButterKnife.inject(this);

        Bundle bundle = getIntent().getExtras();
        int imagePosition = bundle.getInt(IMG_POS_KEY, 0);

        pager.setAdapter(new ImagePagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(imagePosition);
    }
}
