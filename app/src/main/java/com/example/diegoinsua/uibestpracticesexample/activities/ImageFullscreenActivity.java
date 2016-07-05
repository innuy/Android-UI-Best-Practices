package com.example.diegoinsua.uibestpracticesexample.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ImageFullscreenActivity extends Activity {

    public static final String IMAGE_KEY = "image";

    @InjectView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_fullscreen);

        ButterKnife.inject(this);

        // Set the image resource gotten from the parameters
        Bundle arguments = getIntent().getExtras();
        int imageResource = arguments.getInt(IMAGE_KEY);
        image.setImageResource(imageResource);
    }
}
