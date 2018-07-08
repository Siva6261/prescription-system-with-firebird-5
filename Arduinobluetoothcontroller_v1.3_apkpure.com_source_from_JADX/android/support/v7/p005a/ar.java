package android.support.v7.p005a;

import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0329i;
import android.view.Menu;
import android.view.Window.Callback;

final class ar implements C0273y {
    final /* synthetic */ ae f1239a;

    private ar(ae aeVar) {
        this.f1239a = aeVar;
    }

    public void mo518a(C0329i c0329i, boolean z) {
        Menu menu;
        Menu p = c0329i.mo604p();
        boolean z2 = p != c0329i;
        ae aeVar = this.f1239a;
        if (z2) {
            menu = p;
        }
        aq a = aeVar.m2901a(menu);
        if (a == null) {
            return;
        }
        if (z2) {
            this.f1239a.m2902a(a.f1220a, a, p);
            this.f1239a.m2908a(a, true);
            return;
        }
        this.f1239a.m2908a(a, z);
    }

    public boolean mo519a(C0329i c0329i) {
        if (c0329i == null && this.f1239a.h) {
            Callback o = this.f1239a.m2894o();
            if (!(o == null || this.f1239a.m2893n())) {
                o.onMenuOpened(108, c0329i);
            }
        }
        return true;
    }
}
