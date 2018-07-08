package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p010d.C0132a;
import android.util.TypedValue;

class ga {
    static final int[] f2360a = new int[]{-16842910};
    static final int[] f2361b = new int[]{16842908};
    static final int[] f2362c = new int[]{16843518};
    static final int[] f2363d = new int[]{16842919};
    static final int[] f2364e = new int[]{16842912};
    static final int[] f2365f = new int[]{16842913};
    static final int[] f2366g = new int[]{-16842919, -16842908};
    static final int[] f2367h = new int[0];
    private static final ThreadLocal f2368i = new ThreadLocal();
    private static final int[] f2369j = new int[1];

    public static int m4775a(Context context, int i) {
        f2369j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f2369j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int m4776a(Context context, int i, float f) {
        int a = m4775a(context, i);
        return C0132a.m1452b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    private static TypedValue m4777a() {
        TypedValue typedValue = (TypedValue) f2368i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2368i.set(typedValue);
        return typedValue;
    }

    public static ColorStateList m4778b(Context context, int i) {
        f2369j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f2369j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int m4779c(Context context, int i) {
        ColorStateList b = m4778b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2360a, b.getDefaultColor());
        }
        TypedValue a = m4777a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m4776a(context, i, a.getFloat());
    }
}
