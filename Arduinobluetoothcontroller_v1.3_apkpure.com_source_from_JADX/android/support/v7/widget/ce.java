package android.support.v7.widget;

import android.support.v4.view.bv;
import android.support.v4.view.dy;
import android.view.View;

class ce extends ci {
    final /* synthetic */ cg f2101a;
    final /* synthetic */ dy f2102b;
    final /* synthetic */ bx f2103c;

    ce(bx bxVar, cg cgVar, dy dyVar) {
        this.f2103c = bxVar;
        this.f2101a = cgVar;
        this.f2102b = dyVar;
        super();
    }

    public void mo112a(View view) {
        this.f2103c.m4282b(this.f2101a.f2108a, true);
    }

    public void mo113b(View view) {
        this.f2102b.m2386a(null);
        bv.m2019c(view, 1.0f);
        bv.m2002a(view, 0.0f);
        bv.m2015b(view, 0.0f);
        this.f2103c.m4276a(this.f2101a.f2108a, true);
        this.f2103c.f2082l.remove(this.f2101a.f2108a);
        this.f2103c.m4317j();
    }
}
