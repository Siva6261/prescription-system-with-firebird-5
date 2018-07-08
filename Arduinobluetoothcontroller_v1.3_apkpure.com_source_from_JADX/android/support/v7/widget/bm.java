package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bm implements OnGlobalLayoutListener {
    final /* synthetic */ bk f2047a;

    bm(bk bkVar) {
        this.f2047a = bkVar;
    }

    public void onGlobalLayout() {
        if (this.f2047a.m4168b(this.f2047a.f2041a)) {
            this.f2047a.mo706b();
            super.mo707c();
            return;
        }
        this.f2047a.m4160i();
    }
}
