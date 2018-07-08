package android.support.v7.widget;

import android.support.v4.view.bv;
import android.support.v4.view.dy;
import android.view.View;

class cd extends ci {
    final /* synthetic */ ey f2096a;
    final /* synthetic */ int f2097b;
    final /* synthetic */ int f2098c;
    final /* synthetic */ dy f2099d;
    final /* synthetic */ bx f2100e;

    cd(bx bxVar, ey eyVar, int i, int i2, dy dyVar) {
        this.f2100e = bxVar;
        this.f2096a = eyVar;
        this.f2097b = i;
        this.f2098c = i2;
        this.f2099d = dyVar;
        super();
    }

    public void mo112a(View view) {
        this.f2100e.m4293l(this.f2096a);
    }

    public void mo113b(View view) {
        this.f2099d.m2386a(null);
        this.f2100e.m4290i(this.f2096a);
        this.f2100e.f2080j.remove(this.f2096a);
        this.f2100e.m4317j();
    }

    public void mo114c(View view) {
        if (this.f2097b != 0) {
            bv.m2002a(view, 0.0f);
        }
        if (this.f2098c != 0) {
            bv.m2015b(view, 0.0f);
        }
    }
}
