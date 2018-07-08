package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p016a.C0190g;
import android.support.v4.view.p016a.C0206w;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class C0209a {
    private static final C0214d f960b;
    private static final Object f961c = f960b.mo306a();
    final Object f962a = f960b.mo307a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            f960b = new C0220e();
        } else if (VERSION.SDK_INT >= 14) {
            f960b = new C0216b();
        } else {
            f960b = new C0215g();
        }
    }

    public C0206w m1833a(View view) {
        return f960b.mo305a(f961c, view);
    }

    Object m1834a() {
        return this.f962a;
    }

    public void m1835a(View view, int i) {
        f960b.mo308a(f961c, view, i);
    }

    public void mo393a(View view, C0190g c0190g) {
        f960b.mo309a(f961c, view, c0190g);
    }

    public void m1837a(View view, AccessibilityEvent accessibilityEvent) {
        f960b.mo315d(f961c, view, accessibilityEvent);
    }

    public boolean mo394a(View view, int i, Bundle bundle) {
        return f960b.mo310a(f961c, view, i, bundle);
    }

    public boolean m1839a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f960b.mo312a(f961c, viewGroup, view, accessibilityEvent);
    }

    public boolean m1840b(View view, AccessibilityEvent accessibilityEvent) {
        return f960b.mo311a(f961c, view, accessibilityEvent);
    }

    public void m1841c(View view, AccessibilityEvent accessibilityEvent) {
        f960b.mo314c(f961c, view, accessibilityEvent);
    }

    public void mo395d(View view, AccessibilityEvent accessibilityEvent) {
        f960b.mo313b(f961c, view, accessibilityEvent);
    }
}
