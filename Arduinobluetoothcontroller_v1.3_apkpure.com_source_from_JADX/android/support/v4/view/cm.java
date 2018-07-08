package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class cm {
    public static void m2274a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m2275a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean m2276a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m2277b(View view, int i) {
        return view.canScrollVertically(i);
    }
}
