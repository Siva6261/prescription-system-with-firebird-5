package android.support.design.widget;

import android.support.v4.view.bv;
import android.view.View;

class cg implements Runnable {
    final /* synthetic */ SwipeDismissBehavior f422a;
    private final View f423b;
    private final boolean f424c;

    cg(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.f422a = swipeDismissBehavior;
        this.f423b = view;
        this.f424c = z;
    }

    public void run() {
        if (this.f422a.f292a != null && this.f422a.f292a.m2744a(true)) {
            bv.m2010a(this.f423b, (Runnable) this);
        } else if (this.f424c && this.f422a.f293b != null) {
            this.f422a.f293b.mo108a(this.f423b);
        }
    }
}
