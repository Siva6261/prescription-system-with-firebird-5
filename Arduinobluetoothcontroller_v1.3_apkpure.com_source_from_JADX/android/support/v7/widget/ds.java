package android.support.v7.widget;

class ds implements Runnable {
    final /* synthetic */ RecyclerView f2192a;

    ds(RecyclerView recyclerView) {
        this.f2192a = recyclerView;
    }

    public void run() {
        if (this.f2192a.f147f != null) {
            this.f2192a.f147f.mo715a();
        }
        this.f2192a.af = false;
    }
}
