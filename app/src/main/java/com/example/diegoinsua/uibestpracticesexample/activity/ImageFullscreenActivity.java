package com.example.diegoinsua.uibestpracticesexample.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.fragment.ImageFullscreenFragment;

public class ImageFullscreenActivity extends FragmentActivity {

    public static final String IMAGE_KEY = "image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_fullscreen);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Set the image gotten from the parameters
        if (findViewById(R.id.image_fragment) != null) {
            Bundle arguments = getIntent().getExtras();
            int imageNumber = arguments.getInt(IMAGE_KEY);

            ImageFullscreenFragment imageFragment =
                    ImageFullscreenFragment.newInstance(imageNumber);

            imageFragment.setRetainInstance(true);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.image_fragment, imageFragment).commit();
        }
    }
}
