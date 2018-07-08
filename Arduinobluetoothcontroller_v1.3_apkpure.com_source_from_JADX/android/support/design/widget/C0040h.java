package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0028i;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

public class C0040h extends LayoutParams {
    int f461a = 1;
    Interpolator f462b;

    public C0040h(int i, int i2) {
        super(i, i2);
    }

    public C0040h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.AppBarLayout_LayoutParams);
        this.f461a = obtainStyledAttributes.getInt(C0028i.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
        if (obtainStyledAttributes.hasValue(C0028i.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
            this.f462b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0028i.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public C0040h(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0040h(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public C0040h(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public int m781a() {
        return this.f461a;
    }

    public Interpolator m782b() {
        return this.f462b;
    }
}
