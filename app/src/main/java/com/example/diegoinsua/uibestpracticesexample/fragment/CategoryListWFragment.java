package com.example.diegoinsua.uibestpracticesexample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CategoryListWFragment extends Fragment {

    public static final String LOG_TAG = "CategoryListWFragment";

    public interface CategoryWFragmentListener {
        void onCategoryClick(int categoryId);
    }

    @InjectView(R.id.category_list)
    ListView categoryList;

    private CategoryWFragmentListener listener;

    public CategoryListWFragment() {
        listener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list_w, container, false);

        ButterKnife.inject(this, view);

        categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null)
                    listener.onCategoryClick(position);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CategoryWFragmentListener) {
            listener = (CategoryWFragmentListener) context;
        } else {
            Log.e(LOG_TAG, "The activity must implement the listener to handle callback messages");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
