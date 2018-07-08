package android.support.v7.widget;

import android.view.View;

public abstract class fo extends eb {
    boolean f2071a = true;

    public final void m4276a(ey eyVar, boolean z) {
        m4287d(eyVar, z);
        m4269e(eyVar);
    }

    public abstract boolean mo716a(ey eyVar);

    public abstract boolean mo717a(ey eyVar, int i, int i2, int i3, int i4);

    public boolean mo710a(ey eyVar, ee eeVar, ee eeVar2) {
        int i = eeVar.f2200a;
        int i2 = eeVar.f2201b;
        View view = eyVar.f2256a;
        int left = eeVar2 == null ? view.getLeft() : eeVar2.f2200a;
        int top = eeVar2 == null ? view.getTop() : eeVar2.f2201b;
        if (eyVar.m4660q() || (i == left && i2 == top)) {
            return mo716a(eyVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo717a(eyVar, i, i2, left, top);
    }

    public abstract boolean mo718a(ey eyVar, ey eyVar2, int i, int i2, int i3, int i4);

    public boolean mo711a(ey eyVar, ey eyVar2, ee eeVar, ee eeVar2) {
        int i;
        int i2;
        int i3 = eeVar.f2200a;
        int i4 = eeVar.f2201b;
        if (eyVar2.m4646c()) {
            i = eeVar.f2200a;
            i2 = eeVar.f2201b;
        } else {
            i = eeVar2.f2200a;
            i2 = eeVar2.f2201b;
        }
        return mo718a(eyVar, eyVar2, i3, i4, i, i2);
    }

    public final void m4282b(ey eyVar, boolean z) {
        m4285c(eyVar, z);
    }

    public abstract boolean mo721b(ey eyVar);

    public boolean mo712b(ey eyVar, ee eeVar, ee eeVar2) {
        if (eeVar == null || (eeVar.f2200a == eeVar2.f2200a && eeVar.f2201b == eeVar2.f2201b)) {
            return mo721b(eyVar);
        }
        return mo717a(eyVar, eeVar.f2200a, eeVar.f2201b, eeVar2.f2200a, eeVar2.f2201b);
    }

    public void m4285c(ey eyVar, boolean z) {
    }

    public boolean mo713c(ey eyVar, ee eeVar, ee eeVar2) {
        if (eeVar.f2200a == eeVar2.f2200a && eeVar.f2201b == eeVar2.f2201b) {
            m4290i(eyVar);
            return false;
        }
        return mo717a(eyVar, eeVar.f2200a, eeVar.f2201b, eeVar2.f2200a, eeVar2.f2201b);
    }

    public void m4287d(ey eyVar, boolean z) {
    }

    public boolean mo714g(ey eyVar) {
        return !this.f2071a || eyVar.m4657n();
    }

    public final void m4289h(ey eyVar) {
        m4296o(eyVar);
        m4269e(eyVar);
    }

    public final void m4290i(ey eyVar) {
        m4300s(eyVar);
        m4269e(eyVar);
    }

    public final void m4291j(ey eyVar) {
        m4298q(eyVar);
        m4269e(eyVar);
    }

    public final void m4292k(ey eyVar) {
        m4295n(eyVar);
    }

    public final void m4293l(ey eyVar) {
        m4299r(eyVar);
    }

    public final void m4294m(ey eyVar) {
        m4297p(eyVar);
    }

    public void m4295n(ey eyVar) {
    }

    public void m4296o(ey eyVar) {
    }

    public void m4297p(ey eyVar) {
    }

    public void m4298q(ey eyVar) {
    }

    public void m4299r(ey eyVar) {
    }

    public void m4300s(ey eyVar) {
    }
}
