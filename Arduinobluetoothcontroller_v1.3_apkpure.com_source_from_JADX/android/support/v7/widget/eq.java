package android.support.v7.widget;

import android.support.v4.view.bv;

class eq extends dz {
    final /* synthetic */ RecyclerView f2220a;

    private eq(RecyclerView recyclerView) {
        this.f2220a = recyclerView;
    }

    public void mo767a() {
        this.f2220a.m189a(null);
        if (this.f2220a.f156q.m4490b()) {
            this.f2220a.f148g.f2242g = true;
            this.f2220a.m108I();
        } else {
            this.f2220a.f148g.f2242g = true;
            this.f2220a.m108I();
        }
        if (!this.f2220a.f143b.m4043d()) {
            this.f2220a.requestLayout();
        }
    }

    public void mo768a(int i, int i2) {
        this.f2220a.m189a(null);
        if (this.f2220a.f143b.m4040b(i, i2)) {
            m4567b();
        }
    }

    void m4567b() {
        if (this.f2220a.f123E && this.f2220a.f162w && this.f2220a.f161v) {
            bv.m2010a(this.f2220a, this.f2220a.f154o);
            return;
        }
        this.f2220a.f122D = true;
        this.f2220a.requestLayout();
    }
}
