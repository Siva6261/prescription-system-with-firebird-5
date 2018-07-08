package android.support.v4.p006b;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class C0087q implements OnPreDrawListener {
    final /* synthetic */ View f767a;
    final /* synthetic */ C0089s f768b;
    final /* synthetic */ int f769c;
    final /* synthetic */ Object f770d;
    final /* synthetic */ C0084n f771e;

    C0087q(C0084n c0084n, View view, C0089s c0089s, int i, Object obj) {
        this.f771e = c0084n;
        this.f767a = view;
        this.f768b = c0089s;
        this.f769c = i;
        this.f770d = obj;
    }

    public boolean onPreDraw() {
        this.f767a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f771e.m1273a(this.f768b, this.f769c, this.f770d);
        return true;
    }
}
