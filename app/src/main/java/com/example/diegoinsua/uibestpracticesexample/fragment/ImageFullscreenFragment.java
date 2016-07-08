package com.example.diegoinsua.uibestpracticesexample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created on 8/7/16.
 * @author INNUY
 */
public class ImageFullscreenFragment extends Fragment {

    private static final String IMAGE_KEY = "image";

    @InjectView(R.id.image)
    ImageView image;

    private int imageResource;

    public static ImageFullscreenFragment newInstance(int imageNumber) {

        Bundle args = new Bundle();
        args.putInt(IMAGE_KEY, imageNumber);

        ImageFullscreenFragment fragment = new ImageFullscreenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getArguments();

        int imageNumber = 0;
        if (arguments != null) {
            imageNumber = arguments.getInt(IMAGE_KEY);
        }

        imageResource = 0;
        switch (imageNumber) {
            case 0:
                imageResource = R.mipmap.sample_image_1;
                break;
            case 1:
                imageResource = R.mipmap.sample_image_2;
                break;
            case 2:
                imageResource = R.mipmap.sample_image_3;
                break;
            case 3:
                imageResource = R.mipmap.sample_image_4;
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_fullscreen, container, false);

        ButterKnife.inject(this, view);

        image.setImageResource(imageResource);

        return view;
    }
}
