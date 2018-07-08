package android.support.v7.p005a;

import android.support.v4.view.bv;
import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.view.Menu;
import android.view.MenuItem;

class an implements C0274c {
    final /* synthetic */ ae f1208a;
    private C0274c f1209b;

    public an(ae aeVar, C0274c c0274c) {
        this.f1208a = aeVar;
        this.f1209b = c0274c;
    }

    public void mo520a(C0277b c0277b) {
        this.f1209b.mo520a(c0277b);
        if (this.f1208a.f1180o != null) {
            this.f1208a.b.getDecorView().removeCallbacks(this.f1208a.f1181p);
        }
        if (this.f1208a.f1179n != null) {
            this.f1208a.m2933u();
            this.f1208a.f1182q = bv.m2040q(this.f1208a.f1179n).m2384a(0.0f);
            this.f1208a.f1182q.m2386a(new ao(this));
        }
        if (this.f1208a.e != null) {
            this.f1208a.e.mo141b(this.f1208a.f1178m);
        }
        this.f1208a.f1178m = null;
    }

    public boolean mo521a(C0277b c0277b, Menu menu) {
        return this.f1209b.mo521a(c0277b, menu);
    }

    public boolean mo522a(C0277b c0277b, MenuItem menuItem) {
        return this.f1209b.mo522a(c0277b, menuItem);
    }

    public boolean mo523b(C0277b c0277b, Menu menu) {
        return this.f1209b.mo523b(c0277b, menu);
    }
}
