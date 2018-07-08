package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public final class ah {
    static final an f1088a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1088a = new aj();
        } else if (i >= 21) {
            f1088a = new ai();
        } else if (i >= 19) {
            f1088a = new am();
        } else if (i >= 9) {
            f1088a = new al();
        } else {
            f1088a = new ak();
        }
    }

    public static void m2603a(PopupWindow popupWindow, int i) {
        f1088a.mo435a(popupWindow, i);
    }

    public static void m2604a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1088a.mo436a(popupWindow, view, i, i2, i3);
    }

    public static void m2605a(PopupWindow popupWindow, boolean z) {
        f1088a.mo437a(popupWindow, z);
    }
}
