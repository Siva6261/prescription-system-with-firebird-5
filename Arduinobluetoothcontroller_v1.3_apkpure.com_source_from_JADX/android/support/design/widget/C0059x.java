package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0028i;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public class C0059x extends LayoutParams {
    int f584a = 0;
    float f585b = 0.5f;

    public C0059x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.CollapsingAppBarLayout_LayoutParams);
        this.f584a = obtainStyledAttributes.getInt(C0028i.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
        m950a(obtainStyledAttributes.getFloat(C0028i.f89xad49a364, 0.5f));
        obtainStyledAttributes.recycle();
    }

    public C0059x(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0059x(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public void m950a(float f) {
        this.f585b = f;
    }
}
