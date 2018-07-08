package android.support.v7.widget;

import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0329i;
import android.support.v7.view.menu.ad;

class C0367s implements C0273y {
    final /* synthetic */ C0359k f2451a;

    private C0367s(C0359k c0359k) {
        this.f2451a = c0359k;
    }

    public void mo518a(C0329i c0329i, boolean z) {
        if (c0329i instanceof ad) {
            ((ad) c0329i).mo604p().m3355a(false);
        }
        C0273y a = this.f2451a.m3417a();
        if (a != null) {
            a.mo518a(c0329i, z);
        }
    }

    public boolean mo519a(C0329i c0329i) {
        if (c0329i == null) {
            return false;
        }
        this.f2451a.f2422h = ((ad) c0329i).getItem().getItemId();
        C0273y a = this.f2451a.m3417a();
        return a != null ? a.mo519a(c0329i) : false;
    }
}
