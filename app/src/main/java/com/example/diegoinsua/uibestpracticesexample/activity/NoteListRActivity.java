package com.example.diegoinsua.uibestpracticesexample.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.adapter.NoteTabsAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NoteListRActivity extends AppCompatActivity {

    @InjectView(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list_r);

        ButterKnife.inject(this);

        NoteTabsAdapter tabsAdapter = new NoteTabsAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(tabsAdapter);

//        Animation animation = new TranslateAnimation(0, -500, 0, 0);
//        animation.setDuration(1000);
//        animation.setFillAfter(true);
//        categories.startAnimation(animation);
    }
}
