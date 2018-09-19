package com.example.mathmurder.tablehitch;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class ContentTextView extends TextView {
    public ContentTextView(Context context) {
        super(context);
        setFont();
        setTextSize(14);
        setTextColor(Color.BLACK);
    }
    public ContentTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public ContentTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/GlacialIndifferenceRegular.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}
