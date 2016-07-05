package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegoinsua.uibestpracticesexample.R;

/**
 * Created on 4/7/16.
 * @author INNUY
 */
public class NotesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int NOTES_QUANTITY = 20;

    private Activity activity;

    public NotesAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create the item view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_note_item, parent, false);
        return new NoteItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NoteItemViewHolder itemViewHolder = (NoteItemViewHolder) holder;

        itemViewHolder.title.setText(activity.getString(R.string.note_item_title));
        itemViewHolder.title.append(" " + (position + 1));
    }

    @Override
    public int getItemCount() {
        return NOTES_QUANTITY;
    }
}
