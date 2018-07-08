package android.support.v7.p005a;

import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0329i;

final class bb implements C0273y {
    final /* synthetic */ aw f1264a;

    private bb(aw awVar) {
        this.f1264a = awVar;
    }

    public void mo518a(C0329i c0329i, boolean z) {
        if (this.f1264a.f1251c != null) {
            this.f1264a.f1251c.onPanelClosed(0, c0329i);
        }
    }

    public boolean mo519a(C0329i c0329i) {
        if (c0329i == null && this.f1264a.f1251c != null) {
            this.f1264a.f1251c.onMenuOpened(0, c0329i);
        }
        return true;
    }
}
