package com.example.diegoinsua.uibestpracticesexample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created on 6/7/16.
 * @author INNUY
 */
public class ImageSquareView extends ImageView {
    public ImageSquareView(Context context) {
        super(context);
    }

    public ImageSquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageSquareView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
