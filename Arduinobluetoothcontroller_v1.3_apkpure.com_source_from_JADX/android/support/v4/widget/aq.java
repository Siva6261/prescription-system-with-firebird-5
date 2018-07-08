package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class aq {
    private static Method f1090a;
    private static boolean f1091b;

    static void m2620a(PopupWindow popupWindow, int i) {
        if (!f1091b) {
            try {
                f1090a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1090a.setAccessible(true);
            } catch (Exception e) {
            }
            f1091b = true;
        }
        if (f1090a != null) {
            try {
                f1090a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
