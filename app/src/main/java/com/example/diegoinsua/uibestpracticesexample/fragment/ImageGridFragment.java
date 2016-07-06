package com.example.diegoinsua.uibestpracticesexample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.adapter.ImageGridAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created on 6/7/16.
 * @author INNUY
 */
public class ImageGridFragment extends Fragment {

    @InjectView(R.id.image_grid)
    GridView grid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_grid, container, false);

        ButterKnife.inject(this, view);

        grid.setAdapter(new ImageGridAdapter(getActivity()));

        return view;
    }
}
