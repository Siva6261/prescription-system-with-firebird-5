package android.support.v7.p005a;

import android.support.v4.view.bv;
import android.support.v4.view.eq;
import android.view.View;

class al extends eq {
    final /* synthetic */ ae f1206a;

    al(ae aeVar) {
        this.f1206a = aeVar;
    }

    public void mo112a(View view) {
        this.f1206a.f1179n.setVisibility(0);
        this.f1206a.f1179n.sendAccessibilityEvent(32);
        if (this.f1206a.f1179n.getParent() != null) {
            bv.m2042s((View) this.f1206a.f1179n.getParent());
        }
    }

    public void mo113b(View view) {
        bv.m2019c(this.f1206a.f1179n, 1.0f);
        this.f1206a.f1182q.m2386a(null);
        this.f1206a.f1182q = null;
    }
}
