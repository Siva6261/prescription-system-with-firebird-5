package android.support.v7.widget;

import android.view.View;

class C0363o implements Runnable {
    final /* synthetic */ C0359k f2444a;
    private C0366r f2445b;

    public C0363o(C0359k c0359k, C0366r c0366r) {
        this.f2444a = c0359k;
        this.f2445b = c0366r;
    }

    public void run() {
        this.f2444a.c.m3372f();
        View view = (View) this.f2444a.f;
        if (!(view == null || view.getWindowToken() == null || !this.f2445b.m3513d())) {
            this.f2444a.f2438x = this.f2445b;
        }
        this.f2444a.f2440z = null;
    }
}
