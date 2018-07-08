package android.support.v4.view;

import android.support.v4.view.p016a.C0190g;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0218c implements C0217j {
    final /* synthetic */ C0209a f984a;
    final /* synthetic */ C0216b f985b;

    C0218c(C0216b c0216b, C0209a c0209a) {
        this.f985b = c0216b;
        this.f984a = c0209a;
    }

    public void mo382a(View view, int i) {
        this.f984a.m1835a(view, i);
    }

    public void mo383a(View view, Object obj) {
        this.f984a.mo393a(view, new C0190g(obj));
    }

    public boolean mo384a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f984a.m1840b(view, accessibilityEvent);
    }

    public boolean mo385a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f984a.m1839a(viewGroup, view, accessibilityEvent);
    }

    public void mo386b(View view, AccessibilityEvent accessibilityEvent) {
        this.f984a.mo395d(view, accessibilityEvent);
    }

    public void mo387c(View view, AccessibilityEvent accessibilityEvent) {
        this.f984a.m1841c(view, accessibilityEvent);
    }

    public void mo388d(View view, AccessibilityEvent accessibilityEvent) {
        this.f984a.m1837a(view, accessibilityEvent);
    }
}
