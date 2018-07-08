package android.support.v7.widget;

import android.view.View;

class fe implements Runnable {
    final /* synthetic */ View f2294a;
    final /* synthetic */ fd f2295b;

    fe(fd fdVar, View view) {
        this.f2295b = fdVar;
        this.f2294a = view;
    }

    public void run() {
        this.f2295b.smoothScrollTo(this.f2294a.getLeft() - ((this.f2295b.getWidth() - this.f2294a.getWidth()) / 2), 0);
        this.f2295b.f2285a = null;
    }
}
