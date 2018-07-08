package android.support.v7.widget;

class dr implements Runnable {
    final /* synthetic */ RecyclerView f2191a;

    dr(RecyclerView recyclerView) {
        this.f2191a = recyclerView;
    }

    public void run() {
        if (this.f2191a.f163x && !this.f2191a.isLayoutRequested()) {
            if (this.f2191a.f119A) {
                this.f2191a.f165z = true;
            } else {
                this.f2191a.m172t();
            }
        }
    }
}
