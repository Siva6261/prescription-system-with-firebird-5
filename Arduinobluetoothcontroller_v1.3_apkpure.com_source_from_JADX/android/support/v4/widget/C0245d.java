package android.support.v4.widget;

import android.support.v4.view.bv;

class C0245d implements Runnable {
    final /* synthetic */ C0240a f1142a;

    private C0245d(C0240a c0240a) {
        this.f1142a = c0240a;
    }

    public void run() {
        if (this.f1142a.f1084o) {
            if (this.f1142a.f1082m) {
                this.f1142a.f1082m = false;
                this.f1142a.f1070a.m2754a();
            }
            C0244c c = this.f1142a.f1070a;
            if (c.m2759c() || !this.f1142a.m2564a()) {
                this.f1142a.f1084o = false;
                return;
            }
            if (this.f1142a.f1083n) {
                this.f1142a.f1083n = false;
                this.f1142a.m2575d();
            }
            c.m2760d();
            this.f1142a.mo471a(c.m2763g(), c.m2764h());
            bv.m2010a(this.f1142a.f1072c, (Runnable) this);
        }
    }
}
