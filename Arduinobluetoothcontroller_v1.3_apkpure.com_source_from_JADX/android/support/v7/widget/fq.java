package android.support.v7.widget;

class fq {
    int f2310a;
    int f2311b;
    boolean f2312c;
    boolean f2313d;
    final /* synthetic */ StaggeredGridLayoutManager f2314e;

    private fq(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f2314e = staggeredGridLayoutManager;
    }

    void m4706a() {
        this.f2310a = -1;
        this.f2311b = Integer.MIN_VALUE;
        this.f2312c = false;
        this.f2313d = false;
    }

    void m4707a(int i) {
        if (this.f2312c) {
            this.f2311b = this.f2314e.f1837a.mo736d() - i;
        } else {
            this.f2311b = this.f2314e.f1837a.mo734c() + i;
        }
    }

    void m4708b() {
        this.f2311b = this.f2312c ? this.f2314e.f1837a.mo736d() : this.f2314e.f1837a.mo734c();
    }
}
