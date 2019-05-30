package com.ghamari.vahab.pokemon.main.Utility;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by VahabGh on 12/29/2017.
 */
public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
        setTypeFace();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace();
    }

    private void setTypeFace() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fonts/Pokemon_Solid.ttf");
        setTypeface(tf);
    }
}
