package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class cr extends MarginLayoutParams {
    public float f2138g;
    public int f2139h;

    public cr(int i, int i2) {
        super(i, i2);
        this.f2139h = -1;
        this.f2138g = 0.0f;
    }

    public cr(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2139h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0308l.LinearLayoutCompat_Layout);
        this.f2138g = obtainStyledAttributes.getFloat(C0308l.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
        this.f2139h = obtainStyledAttributes.getInt(C0308l.LinearLayoutCompat_Layout_android_layout_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    public cr(LayoutParams layoutParams) {
        super(layoutParams);
        this.f2139h = -1;
    }
}
