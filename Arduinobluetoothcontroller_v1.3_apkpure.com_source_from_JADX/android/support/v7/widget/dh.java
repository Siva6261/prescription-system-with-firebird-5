package android.support.v7.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class dh implements OnScrollListener {
    final /* synthetic */ cx f2184a;

    private dh(cx cxVar) {
        this.f2184a = cxVar;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.f2184a.m4163l() && this.f2184a.f2019e.getContentView() != null) {
            this.f2184a.f2013C.removeCallbacks(this.f2184a.f2038x);
            this.f2184a.f2038x.run();
        }
    }
}
