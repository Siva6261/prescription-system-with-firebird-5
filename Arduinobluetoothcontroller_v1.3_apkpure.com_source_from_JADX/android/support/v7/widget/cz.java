package android.support.v7.widget;

import android.view.View;

class cz implements Runnable {
    final /* synthetic */ cx f2164a;

    cz(cx cxVar) {
        this.f2164a = cxVar;
    }

    public void run() {
        View e = this.f2164a.m4152e();
        if (e != null && e.getWindowToken() != null) {
            this.f2164a.mo707c();
        }
    }
}
