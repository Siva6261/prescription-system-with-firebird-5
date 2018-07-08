package android.support.v7.p005a;

import android.support.v4.view.bv;
import android.support.v4.view.eq;
import android.view.View;

class bi extends eq {
    final /* synthetic */ bh f1314a;

    bi(bh bhVar) {
        this.f1314a = bhVar;
    }

    public void mo113b(View view) {
        if (this.f1314a.f1285C && this.f1314a.f1307t != null) {
            bv.m2015b(this.f1314a.f1307t, 0.0f);
            bv.m2015b(this.f1314a.f1304q, 0.0f);
        }
        this.f1314a.f1304q.setVisibility(8);
        this.f1314a.f1304q.setTransitioning(false);
        this.f1314a.f1290H = null;
        this.f1314a.m3109i();
        if (this.f1314a.f1303p != null) {
            bv.m2042s(this.f1314a.f1303p);
        }
    }
}
