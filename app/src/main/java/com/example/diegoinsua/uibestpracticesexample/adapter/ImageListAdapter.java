package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.activities.ImageFullscreenActivity;

/**
 * Created on 5/7/16.
 * @author INNUY
 */
public class ImageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int IMAGE_QUANTITY = 10;

    private Activity activity;

    public ImageListAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create the item view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_image_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageViewHolder viewHolder = (ImageViewHolder) holder;

        int imageResource = 0;
        switch (position % 4) {
            case 0:
                imageResource = R.mipmap.sample_image_1_thumbnail;
                break;
            case 1:
                imageResource = R.mipmap.sample_image_2_thumbnail;
                break;
            case 2:
                imageResource = R.mipmap.sample_image_3_thumbnail;
                break;
            case 3:
                imageResource = R.mipmap.sample_image_4_thumbnail;
        }
        viewHolder.image.setImageResource(imageResource);

        final Intent intent = new Intent(activity, ImageFullscreenActivity.class);

        // It adds the arguments to the activity intent
        Bundle arguments = new Bundle();
        arguments.putInt(ImageFullscreenActivity.IMAGE_KEY, position % 4);
        intent.putExtras(arguments);

        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return IMAGE_QUANTITY;
    }
}
