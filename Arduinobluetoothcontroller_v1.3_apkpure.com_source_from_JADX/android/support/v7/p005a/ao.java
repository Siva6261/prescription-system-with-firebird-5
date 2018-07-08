package android.support.v7.p005a;

import android.support.v4.view.bv;
import android.support.v4.view.eq;
import android.view.View;

class ao extends eq {
    final /* synthetic */ an f1210a;

    ao(an anVar) {
        this.f1210a = anVar;
    }

    public void mo113b(View view) {
        this.f1210a.f1208a.f1179n.setVisibility(8);
        if (this.f1210a.f1208a.f1180o != null) {
            this.f1210a.f1208a.f1180o.dismiss();
        } else if (this.f1210a.f1208a.f1179n.getParent() instanceof View) {
            bv.m2042s((View) this.f1210a.f1208a.f1179n.getParent());
        }
        this.f1210a.f1208a.f1179n.removeAllViews();
        this.f1210a.f1208a.f1182q.m2386a(null);
        this.f1210a.f1208a.f1182q = null;
    }
}
