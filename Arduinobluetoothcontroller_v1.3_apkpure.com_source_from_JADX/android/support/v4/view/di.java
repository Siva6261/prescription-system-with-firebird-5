package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class di extends LayoutParams {
    public boolean f1002a;
    public int f1003b;
    float f1004c = 0.0f;
    boolean f1005d;
    int f1006e;
    int f1007f;

    public di() {
        super(-1, -1);
    }

    public di(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f896a);
        this.f1003b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
