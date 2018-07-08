package android.support.v7.p005a;

import android.view.ActionMode;
import android.view.Window.Callback;

class ad extends ab {
    final /* synthetic */ ac f1199c;

    ad(ac acVar, Callback callback) {
        this.f1199c = acVar;
        super(acVar, callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (this.f1199c.mo505m()) {
            switch (i) {
                case 0:
                    return m2978a(callback);
            }
        }
        return super.onWindowStartingActionMode(callback, i);
    }
}
