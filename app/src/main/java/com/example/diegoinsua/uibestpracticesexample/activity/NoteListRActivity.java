package com.example.diegoinsua.uibestpracticesexample.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.adapter.CategoryAdapter;
import com.example.diegoinsua.uibestpracticesexample.adapter.NoteTabsAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NoteListRActivity extends AppCompatActivity
        implements CategoryAdapter.CategoryAdapterListener {

    @InjectView(R.id.pager)
    ViewPager pager;

    @InjectView(R.id.category_list)
    LinearLayout categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list_r);

        ButterKnife.inject(this);

        NoteTabsAdapter tabsAdapter = new NoteTabsAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(tabsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        categoryList.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_right));
        categoryList.animate();
    }

    @Override
    public void onCategoryClick(int categoryId) {
        categoryList.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_left));
        categoryList.animate();
        categoryList.setVisibility(View.GONE);
    }
}
