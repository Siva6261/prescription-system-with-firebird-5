package android.support.v7.view;

import android.support.v4.view.eq;
import android.view.View;

class C0323m extends eq {
    final /* synthetic */ C0322l f1495a;
    private boolean f1496b = false;
    private int f1497c = 0;

    C0323m(C0322l c0322l) {
        this.f1495a = c0322l;
    }

    void m3295a() {
        this.f1497c = 0;
        this.f1496b = false;
        this.f1495a.m3287c();
    }

    public void mo112a(View view) {
        if (!this.f1496b) {
            this.f1496b = true;
            if (this.f1495a.f1492d != null) {
                this.f1495a.f1492d.mo112a(null);
            }
        }
    }

    public void mo113b(View view) {
        int i = this.f1497c + 1;
        this.f1497c = i;
        if (i == this.f1495a.f1489a.size()) {
            if (this.f1495a.f1492d != null) {
                this.f1495a.f1492d.mo113b(null);
            }
            m3295a();
        }
    }
}
