package android.support.v4.p010d.p011a;

import android.graphics.drawable.Drawable;

class C0125o {
    public static void m1434a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m1435a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m1436b(Drawable drawable) {
        return !(drawable instanceof C0110y) ? new C0110y(drawable) : drawable;
    }

    public static int m1437c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
