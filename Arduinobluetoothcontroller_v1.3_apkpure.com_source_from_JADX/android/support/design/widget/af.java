package android.support.design.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

class af implements OnPreDrawListener {
    final /* synthetic */ CoordinatorLayout f322a;

    af(CoordinatorLayout coordinatorLayout) {
        this.f322a = coordinatorLayout;
    }

    public boolean onPreDraw() {
        this.f322a.m413a(false);
        return true;
    }
}
