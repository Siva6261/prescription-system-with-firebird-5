package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class dr {
    static final dt f1013a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1013a = new dv();
        } else if (i >= 19) {
            f1013a = new du();
        } else if (i >= 14) {
            f1013a = new ds();
        } else {
            f1013a = new dw();
        }
    }

    public static void m2342a(ViewParent viewParent, View view) {
        f1013a.mo396a(viewParent, view);
    }

    public static void m2343a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f1013a.mo397a(viewParent, view, i, i2, i3, i4);
    }

    public static void m2344a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f1013a.mo398a(viewParent, view, i, i2, iArr);
    }

    public static boolean m2345a(ViewParent viewParent, View view, float f, float f2) {
        return f1013a.mo399a(viewParent, view, f, f2);
    }

    public static boolean m2346a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1013a.mo400a(viewParent, view, f, f2, z);
    }

    public static boolean m2347a(ViewParent viewParent, View view, View view2, int i) {
        return f1013a.mo401a(viewParent, view, view2, i);
    }

    public static void m2348b(ViewParent viewParent, View view, View view2, int i) {
        f1013a.mo402b(viewParent, view, view2, i);
    }
}
