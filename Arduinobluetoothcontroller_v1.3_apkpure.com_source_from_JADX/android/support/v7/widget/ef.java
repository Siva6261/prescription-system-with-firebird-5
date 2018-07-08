package android.support.v7.widget;

class ef implements ed {
    final /* synthetic */ RecyclerView f2204a;

    private ef(RecyclerView recyclerView) {
        this.f2204a = recyclerView;
    }

    public void mo766a(ey eyVar) {
        eyVar.m4642a(true);
        if (eyVar.f2262g != null && eyVar.f2263h == null) {
            eyVar.f2262g = null;
        }
        eyVar.f2263h = null;
        if (!eyVar.m4624B() && !this.f2204a.m153h(eyVar.f2256a) && eyVar.m4661r()) {
            this.f2204a.removeDetachedView(eyVar.f2256a, false);
        }
    }
}
