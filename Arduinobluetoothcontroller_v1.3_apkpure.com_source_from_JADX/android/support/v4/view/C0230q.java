package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;

public final class C0230q {
    static final C0231r f1040a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f1040a = new C0233t();
        } else {
            f1040a = new C0232s();
        }
    }

    public static int m2509a(int i, int i2) {
        return f1040a.mo430a(i, i2);
    }

    public static void m2510a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f1040a.mo431a(i, i2, i3, rect, rect2, i4);
    }
}
