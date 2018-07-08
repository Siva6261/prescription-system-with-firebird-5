package android.support.design.widget;

import android.support.v4.view.bv;
import android.view.View;

class bd implements Runnable {
    final /* synthetic */ bc f367a;
    private final CoordinatorLayout f368b;
    private final View f369c;

    bd(bc bcVar, CoordinatorLayout coordinatorLayout, View view) {
        this.f367a = bcVar;
        this.f368b = coordinatorLayout;
        this.f369c = view;
    }

    public void run() {
        if (this.f369c != null && this.f367a.f170b != null) {
            if (this.f367a.f170b.m2651g()) {
                this.f367a.a_(this.f368b, this.f369c, this.f367a.f170b.m2647c());
                bv.m2010a(this.f369c, (Runnable) this);
                return;
            }
            this.f367a.mo41a(this.f368b, this.f369c);
        }
    }
}
