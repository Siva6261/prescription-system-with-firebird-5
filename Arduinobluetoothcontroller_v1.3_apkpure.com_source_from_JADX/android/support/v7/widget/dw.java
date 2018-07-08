package android.support.v7.widget;

class dw implements aj {
    final /* synthetic */ RecyclerView f2195a;

    dw(RecyclerView recyclerView) {
        this.f2195a = recyclerView;
    }

    public ey mo758a(int i) {
        ey a = this.f2195a.m182a(i, true);
        return (a == null || this.f2195a.f144c.m4198c(a.f2256a)) ? null : a;
    }

    public void mo759a(int i, int i2) {
        this.f2195a.m188a(i, i2, true);
        this.f2195a.f149h = true;
        ev.m4589a(this.f2195a.f148g, i2);
    }

    public void mo760a(int i, int i2, Object obj) {
        this.f2195a.m187a(i, i2, obj);
        this.f2195a.f150i = true;
    }

    public void mo761a(ak akVar) {
        m4475c(akVar);
    }

    public void mo762b(int i, int i2) {
        this.f2195a.m188a(i, i2, false);
        this.f2195a.f149h = true;
    }

    public void mo763b(ak akVar) {
        m4475c(akVar);
    }

    public void mo764c(int i, int i2) {
        this.f2195a.m208f(i, i2);
        this.f2195a.f149h = true;
    }

    void m4475c(ak akVar) {
        switch (akVar.f1926a) {
            case 1:
                this.f2195a.f146e.mo685a(this.f2195a, akVar.f1927b, akVar.f1929d);
                return;
            case 2:
                this.f2195a.f146e.mo694b(this.f2195a, akVar.f1927b, akVar.f1929d);
                return;
            case 4:
                this.f2195a.f146e.mo687a(this.f2195a, akVar.f1927b, akVar.f1929d, akVar.f1928c);
                return;
            case 8:
                this.f2195a.f146e.mo686a(this.f2195a, akVar.f1927b, akVar.f1929d, 1);
                return;
            default:
                return;
        }
    }

    public void mo765d(int i, int i2) {
        this.f2195a.m205e(i, i2);
        this.f2195a.f149h = true;
    }
}
