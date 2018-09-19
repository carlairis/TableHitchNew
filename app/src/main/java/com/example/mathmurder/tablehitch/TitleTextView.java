package com.example.mathmurder.tablehitch;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TitleTextView extends TextView {
    public TitleTextView(Context context) {
        super(context);
        setFont();
        setTextSize(36);
    }
    public TitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public TitleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/BreeSerifRegular.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}
