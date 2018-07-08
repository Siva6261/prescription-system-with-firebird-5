package android.support.v7.p005a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class C0275b extends MarginLayoutParams {
    public int f1262a;

    public C0275b(int i, int i2) {
        super(i, i2);
        this.f1262a = 0;
        this.f1262a = 8388627;
    }

    public C0275b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1262a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0308l.ActionBarLayout);
        this.f1262a = obtainStyledAttributes.getInt(C0308l.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
    }

    public C0275b(C0275b c0275b) {
        super(c0275b);
        this.f1262a = 0;
        this.f1262a = c0275b.f1262a;
    }

    public C0275b(LayoutParams layoutParams) {
        super(layoutParams);
        this.f1262a = 0;
    }
}
