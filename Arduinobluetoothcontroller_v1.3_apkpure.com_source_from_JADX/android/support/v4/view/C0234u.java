package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

class C0234u {
    public static int m2517a(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    public static void m2518a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }
}
