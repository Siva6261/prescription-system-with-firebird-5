package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0022c;

class ch {
    private static final int[] f425a = new int[]{C0022c.colorPrimary};

    static void m705a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f425a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
