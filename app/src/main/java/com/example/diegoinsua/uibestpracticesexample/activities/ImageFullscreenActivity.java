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
        int imageNumber = arguments.getInt(IMAGE_KEY);
        int imageResource = 0;

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

        image.setImageResource(imageResource);
    }
}
