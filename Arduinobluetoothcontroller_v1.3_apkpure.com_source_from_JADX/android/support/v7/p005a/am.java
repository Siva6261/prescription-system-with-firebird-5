package android.support.v7.p005a;

import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0329i;
import android.view.Window.Callback;

final class am implements C0273y {
    final /* synthetic */ ae f1207a;

    private am(ae aeVar) {
        this.f1207a = aeVar;
    }

    public void mo518a(C0329i c0329i, boolean z) {
        this.f1207a.m2916b(c0329i);
    }

    public boolean mo519a(C0329i c0329i) {
        Callback o = this.f1207a.m2894o();
        if (o != null) {
            o.onMenuOpened(108, c0329i);
        }
        return true;
    }
}
