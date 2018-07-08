package android.support.v7.p005a;

import android.support.v7.view.C0271n;
import android.support.v7.view.menu.C0329i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class C0272y extends C0271n {
    final /* synthetic */ C0268x f1197a;

    C0272y(C0268x c0268x, Callback callback) {
        this.f1197a = c0268x;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1197a.mo491a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.f1197a.mo489a(keyEvent.getKeyCode(), keyEvent);
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return (i != 0 || (menu instanceof C0329i)) ? super.onCreatePanelMenu(i, menu) : false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.f1197a.mo496b(i, menu);
        return true;
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        this.f1197a.mo482a(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        C0329i c0329i = menu instanceof C0329i ? (C0329i) menu : null;
        if (i == 0 && c0329i == null) {
            return false;
        }
        if (c0329i != null) {
            c0329i.m3366c(true);
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (c0329i == null) {
            return onPreparePanel;
        }
        c0329i.m3366c(false);
        return onPreparePanel;
    }
}
