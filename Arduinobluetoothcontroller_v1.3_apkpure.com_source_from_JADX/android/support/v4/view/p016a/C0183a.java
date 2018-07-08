package android.support.v4.view.p016a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class C0183a {
    private static final C0185e f945a;

    static {
        if (VERSION.SDK_INT >= 19) {
            f945a = new C0188c();
        } else if (VERSION.SDK_INT >= 14) {
            f945a = new C0187b();
        } else {
            f945a = new C0186d();
        }
    }

    public static aj m1624a(AccessibilityEvent accessibilityEvent) {
        return new aj(accessibilityEvent);
    }

    public static void m1625a(AccessibilityEvent accessibilityEvent, int i) {
        f945a.mo265a(accessibilityEvent, i);
    }

    public static int m1626b(AccessibilityEvent accessibilityEvent) {
        return f945a.mo264a(accessibilityEvent);
    }
}
