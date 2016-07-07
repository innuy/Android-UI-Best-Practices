package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created on 6/7/16.
 * @author INNUY
 */
public class CategoryItemViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.name)
    TextView name;

    @InjectView(R.id.background)
    LinearLayout background;

    public CategoryItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
