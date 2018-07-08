package android.support.v7.p005a;

import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.support.v7.view.C0318h;
import android.view.ActionMode;
import android.view.Window.Callback;

class ab extends C0272y {
    final /* synthetic */ aa f1198b;

    ab(aa aaVar, Callback callback) {
        this.f1198b = aaVar;
        super(aaVar, callback);
    }

    final ActionMode m2978a(ActionMode.Callback callback) {
        Object c0318h = new C0318h(this.f1198b.a, callback);
        C0277b b = this.f1198b.m2950b((C0274c) c0318h);
        return b != null ? c0318h.m3263b(b) : null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f1198b.mo505m() ? m2978a(callback) : super.onWindowStartingActionMode(callback);
    }
}
