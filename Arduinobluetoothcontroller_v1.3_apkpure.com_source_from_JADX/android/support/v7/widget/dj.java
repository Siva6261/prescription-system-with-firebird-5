package android.support.v7.widget;

import android.support.v4.view.bv;

class dj implements Runnable {
    final /* synthetic */ cx f2186a;

    private dj(cx cxVar) {
        this.f2186a = cxVar;
    }

    public void run() {
        if (this.f2186a.f2021g != null && bv.m1996C(this.f2186a.f2021g) && this.f2186a.f2021g.getCount() > this.f2186a.f2021g.getChildCount() && this.f2186a.f2021g.getChildCount() <= this.f2186a.f2017b) {
            this.f2186a.f2019e.setInputMethodMode(2);
            this.f2186a.mo707c();
        }
    }
}
