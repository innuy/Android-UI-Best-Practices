package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created on 5/7/16.
 * @author INNUY
 */
public class NoteItemViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.item_title)
    TextView title;

    @InjectView(R.id.item_edit)
    ImageView edit;

    public NoteItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
