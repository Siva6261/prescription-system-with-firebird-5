package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0209a;
import android.support.v4.view.p016a.C0190g;
import android.view.View;

class fa extends C0209a {
    final /* synthetic */ ez f2275b;

    fa(ez ezVar) {
        this.f2275b = ezVar;
    }

    public void mo393a(View view, C0190g c0190g) {
        super.mo393a(view, c0190g);
        if (!this.f2275b.m4669c() && this.f2275b.f2272b.getLayoutManager() != null) {
            this.f2275b.f2272b.getLayoutManager().m3654a(view, c0190g);
        }
    }

    public boolean mo394a(View view, int i, Bundle bundle) {
        return super.mo394a(view, i, bundle) ? true : (this.f2275b.m4669c() || this.f2275b.f2272b.getLayoutManager() == null) ? false : this.f2275b.f2272b.getLayoutManager().m3667a(view, i, bundle);
    }
}
