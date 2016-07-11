package com.example.diegoinsua.uibestpracticesexample.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.adapter.CategoryAdapter;
import com.example.diegoinsua.uibestpracticesexample.adapter.NoteTabsAdapter;
import com.example.diegoinsua.uibestpracticesexample.fragment.InfoDialogFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CategoryListRActivity extends AppCompatActivity
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
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int dialogResource = pager.getCurrentItem() == 0
                            ? R.string.info_note_list_r : R.string.info_image_grid_r;
                    InfoDialogFragment infoDialogFragment =
                            InfoDialogFragment.newInstance(dialogResource);
                    infoDialogFragment.show(getFragmentManager(), "Info dialog");
                }
            }
        });

        // Category list is null only when the screen size is large.
        // So it only hides the categories when it is on a mobile phone.
        if (categoryList != null) {
            categoryList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    slideOut(v);
                }
            });
            categoryList.setVisibility(View.GONE);

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        int dialogResource = pager.getCurrentItem() == 0
                ? R.string.info_note_list_r : R.string.info_image_grid_r;
        InfoDialogFragment infoDialogFragment =
                InfoDialogFragment.newInstance(dialogResource);
        infoDialogFragment.show(getFragmentManager(), "Info dialog");
    }

    @Override
    public void onCategoryClick(int categoryId) {
        if (categoryList != null) {
            slideOut(categoryList);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                int dialogResource = pager.getCurrentItem() == 0
                        ? R.string.info_note_list_r : R.string.info_image_grid_r;
                InfoDialogFragment infoDialogFragment =
                        InfoDialogFragment.newInstance(dialogResource);
                infoDialogFragment.show(getFragmentManager(), "Info dialog");
                return true;
            case android.R.id.home:
                if (categoryList.getVisibility() == View.GONE)
                    slideIn(categoryList);
                else
                    slideOut(categoryList);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void slideIn(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_right));
        view.setVisibility(View.VISIBLE);
        view.animate();
    }

    private void slideOut(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_left));
        view.animate();
        view.setVisibility(View.GONE);
    }
}
