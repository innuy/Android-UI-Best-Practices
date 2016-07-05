package com.example.diegoinsua.uibestpracticesexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.adapter.ImageListAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ImageListActivity extends AppCompatActivity {

    @InjectView(R.id.image_list)
    RecyclerView imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        ButterKnife.inject(this);

        imageList.setAdapter(new ImageListAdapter(this));
        imageList.setLayoutManager(new LinearLayoutManager(this));
    }
}
