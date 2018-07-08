package android.support.v7.widget;

import android.support.v4.view.bv;
import android.support.v4.view.dy;
import android.view.View;

class cf extends ci {
    final /* synthetic */ cg f2104a;
    final /* synthetic */ dy f2105b;
    final /* synthetic */ View f2106c;
    final /* synthetic */ bx f2107d;

    cf(bx bxVar, cg cgVar, dy dyVar, View view) {
        this.f2107d = bxVar;
        this.f2104a = cgVar;
        this.f2105b = dyVar;
        this.f2106c = view;
        super();
    }

    public void mo112a(View view) {
        this.f2107d.m4282b(this.f2104a.f2109b, false);
    }

    public void mo113b(View view) {
        this.f2105b.m2386a(null);
        bv.m2019c(this.f2106c, 1.0f);
        bv.m2002a(this.f2106c, 0.0f);
        bv.m2015b(this.f2106c, 0.0f);
        this.f2107d.m4276a(this.f2104a.f2109b, false);
        this.f2107d.f2082l.remove(this.f2104a.f2109b);
        this.f2107d.m4317j();
    }
}
