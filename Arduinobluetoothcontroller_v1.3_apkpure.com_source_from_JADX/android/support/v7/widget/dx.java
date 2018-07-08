package android.support.v7.widget;

import android.support.v4.p002f.C0142h;
import android.view.ViewGroup;
import java.util.List;

public abstract class dx {
    private final dy f2196a = new dy();
    private boolean f2197b = false;

    public abstract int mo826a();

    public int m4478a(int i) {
        return 0;
    }

    public abstract ey mo827a(ViewGroup viewGroup, int i);

    public void m4480a(RecyclerView recyclerView) {
    }

    public void m4481a(dz dzVar) {
        this.f2196a.registerObserver(dzVar);
    }

    public void m4482a(ey eyVar) {
    }

    public abstract void mo828a(ey eyVar, int i);

    public void m4484a(ey eyVar, int i, List list) {
        mo828a(eyVar, i);
    }

    public long m4485b(int i) {
        return -1;
    }

    public final ey m4486b(ViewGroup viewGroup, int i) {
        C0142h.m1462a("RV CreateView");
        ey a = mo827a(viewGroup, i);
        a.f2260e = i;
        C0142h.m1461a();
        return a;
    }

    public void m4487b(RecyclerView recyclerView) {
    }

    public void m4488b(dz dzVar) {
        this.f2196a.unregisterObserver(dzVar);
    }

    public final void m4489b(ey eyVar, int i) {
        eyVar.f2257b = i;
        if (m4490b()) {
            eyVar.f2259d = m4485b(i);
        }
        eyVar.m4637a(1, 519);
        C0142h.m1462a("RV OnBindView");
        m4484a(eyVar, i, eyVar.m4664u());
        eyVar.m4663t();
        C0142h.m1461a();
    }

    public final boolean m4490b() {
        return this.f2197b;
    }

    public boolean m4491b(ey eyVar) {
        return false;
    }

    public final void m4492c() {
        this.f2196a.m4496a();
    }

    public final void m4493c(int i) {
        this.f2196a.m4497a(i, 1);
    }

    public void m4494c(ey eyVar) {
    }

    public void m4495d(ey eyVar) {
    }
}
