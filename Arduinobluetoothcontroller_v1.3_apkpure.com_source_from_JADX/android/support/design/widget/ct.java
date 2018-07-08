package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class ct {
    private static final cv f444a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f444a = new cx();
        } else {
            f444a = new cw();
        }
    }

    static void m755a(ViewGroup viewGroup, View view, Rect rect) {
        f444a.mo135a(viewGroup, view, rect);
    }

    static void m756b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m755a(viewGroup, view, rect);
    }
}
