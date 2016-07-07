package com.example.diegoinsua.uibestpracticesexample.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegoinsua.uibestpracticesexample.R;

/**
 * Created on 6/7/16.
 * @author INNUY
 */
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface CategoryAdapterListener {
        void onCategoryClick(int position);
    }

    private static final String LOG_TAG = "Category Adapter";
    private static final int CAT_QUANTITY = 5;

    private int selectedItem;
    private Activity activity;
    private CategoryAdapterListener listener;

    public CategoryAdapter(Activity activity) {
        listener = null;
        if (activity instanceof  CategoryAdapterListener)
            listener = (CategoryAdapterListener) activity;
        else
            Log.e(LOG_TAG, "The listener must be implemented to receive the callback messages");
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_category_item_r, parent, false);
        return new CategoryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        CategoryItemViewHolder viewHolder = (CategoryItemViewHolder) holder;

        viewHolder.name.setText(activity.getText(R.string.category_list_r_name));
        viewHolder.name.append(" " + (position + 1));

        int bgResource = (selectedItem == position)
                ? R.color.colorPrimaryLight : R.color.colorPrimary;
        viewHolder.background.setBackgroundResource(bgResource);

        viewHolder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onCategoryClick(position);

                int lastSelectedItem = selectedItem;
                selectedItem = position;

                notifyItemChanged(lastSelectedItem);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return CAT_QUANTITY;
    }
}
