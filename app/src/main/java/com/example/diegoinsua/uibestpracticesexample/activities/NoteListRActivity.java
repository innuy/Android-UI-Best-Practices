package com.example.diegoinsua.uibestpracticesexample.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }
}
