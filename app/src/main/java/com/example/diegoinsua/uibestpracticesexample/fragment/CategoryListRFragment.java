package com.example.diegoinsua.uibestpracticesexample.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.adapter.CategoryAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created on 6/7/16.
 * @author INNUY
 */
public class CategoryListRFragment extends Fragment {

    public static final String LOG_TAG = "CategoryListWFragment";

    @InjectView(R.id.category_list)
    RecyclerView categoryList;

    public CategoryListRFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list_r, container, false);

        ButterKnife.inject(this, view);

        categoryList.setAdapter(new CategoryAdapter(getActivity()));
        categoryList.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
