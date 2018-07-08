package android.support.v4.p010d.p011a;

import android.graphics.drawable.Drawable;

class C0123m {
    public static void m1430a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m1431b(Drawable drawable) {
        return !(drawable instanceof C0109w) ? new C0109w(drawable) : drawable;
    }
}
