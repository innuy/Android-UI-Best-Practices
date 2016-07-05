package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created on 5/7/16.
 * @author INNUY
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.image)
    ImageView image;

    public ImageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
