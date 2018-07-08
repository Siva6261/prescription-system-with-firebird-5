package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p016a.C0190g;
import android.support.v4.view.p016a.C0206w;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0222f implements C0221m {
    final /* synthetic */ C0209a f1033a;
    final /* synthetic */ C0220e f1034b;

    C0222f(C0220e c0220e, C0209a c0209a) {
        this.f1034b = c0220e;
        this.f1033a = c0209a;
    }

    public Object mo421a(View view) {
        C0206w a = this.f1033a.m1833a(view);
        return a != null ? a.m1825a() : null;
    }

    public void mo422a(View view, int i) {
        this.f1033a.m1835a(view, i);
    }

    public void mo423a(View view, Object obj) {
        this.f1033a.mo393a(view, new C0190g(obj));
    }

    public boolean mo424a(View view, int i, Bundle bundle) {
        return this.f1033a.mo394a(view, i, bundle);
    }

    public boolean mo425a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1033a.m1840b(view, accessibilityEvent);
    }

    public boolean mo426a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1033a.m1839a(viewGroup, view, accessibilityEvent);
    }

    public void mo427b(View view, AccessibilityEvent accessibilityEvent) {
        this.f1033a.mo395d(view, accessibilityEvent);
    }

    public void mo428c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1033a.m1841c(view, accessibilityEvent);
    }

    public void mo429d(View view, AccessibilityEvent accessibilityEvent) {
        this.f1033a.m1837a(view, accessibilityEvent);
    }
}
