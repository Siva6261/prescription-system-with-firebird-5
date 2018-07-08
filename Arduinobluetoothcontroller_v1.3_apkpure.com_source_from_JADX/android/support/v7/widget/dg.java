package android.support.v7.widget;

import android.database.DataSetObserver;

class dg extends DataSetObserver {
    final /* synthetic */ cx f2183a;

    private dg(cx cxVar) {
        this.f2183a = cxVar;
    }

    public void onChanged() {
        if (this.f2183a.m4162k()) {
            this.f2183a.mo707c();
        }
    }

    public void onInvalidated() {
        this.f2183a.m4160i();
    }
}
