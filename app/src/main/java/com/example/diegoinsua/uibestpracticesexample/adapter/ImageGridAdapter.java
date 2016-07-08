package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.activity.ImagePagerActivity;
import com.example.diegoinsua.uibestpracticesexample.view.ImageSquareView;

/**
 * Created on 6/7/16.
 * @author INNUY
 */
public class ImageGridAdapter extends BaseAdapter {

    private static final int IMAGE_QUANTITY = 10;

    Activity activity;

    public ImageGridAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return IMAGE_QUANTITY;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageSquareView imageView;

        if (convertView == null) {
            imageView = new ImageSquareView(activity);
        } else {
            imageView = (ImageSquareView) convertView;
        }

        // Set the image resource
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
                break;
        }
        imageView.setImageResource(imageResource);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageIntent = new Intent(activity, ImagePagerActivity.class);

                Bundle arguments = new Bundle();
                arguments.putInt(ImagePagerActivity.IMG_POS_KEY, position);
                imageIntent.putExtras(arguments);

                activity.startActivity(imageIntent);
            }
        });

        return imageView;
    }
}
