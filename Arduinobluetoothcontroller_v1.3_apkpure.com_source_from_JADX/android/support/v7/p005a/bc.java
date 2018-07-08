package android.support.v7.p005a;

import android.support.v7.view.C0271n;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class bc extends C0271n {
    final /* synthetic */ aw f1265a;

    public bc(aw awVar, Callback callback) {
        this.f1265a = awVar;
        super(callback);
    }

    public View onCreatePanelView(int i) {
        switch (i) {
            case 0:
                Menu r = this.f1265a.f1249a.mo806r();
                if (onPreparePanel(i, null, r) && onMenuOpened(i, r)) {
                    return this.f1265a.m3020a(r);
                }
        }
        return super.onCreatePanelView(i);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (onPreparePanel && !this.f1265a.f1250b) {
            this.f1265a.f1249a.mo801m();
            this.f1265a.f1250b = true;
        }
        return onPreparePanel;
    }
}
