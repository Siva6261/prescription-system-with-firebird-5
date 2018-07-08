package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

class eb implements Runnable {
    WeakReference f1020a;
    dy f1021b;
    final /* synthetic */ ea f1022c;

    private eb(ea eaVar, dy dyVar, View view) {
        this.f1022c = eaVar;
        this.f1020a = new WeakReference(view);
        this.f1021b = dyVar;
    }

    public void run() {
        View view = (View) this.f1020a.get();
        if (view != null) {
            this.f1022c.m2410d(this.f1021b, view);
        }
    }
}
