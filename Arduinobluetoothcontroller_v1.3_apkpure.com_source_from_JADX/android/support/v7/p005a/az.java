package android.support.v7.p005a;

import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0329i;

final class az implements C0273y {
    final /* synthetic */ aw f1260a;
    private boolean f1261b;

    private az(aw awVar) {
        this.f1260a = awVar;
    }

    public void mo518a(C0329i c0329i, boolean z) {
        if (!this.f1261b) {
            this.f1261b = true;
            this.f1260a.f1249a.mo802n();
            if (this.f1260a.f1251c != null) {
                this.f1260a.f1251c.onPanelClosed(108, c0329i);
            }
            this.f1261b = false;
        }
    }

    public boolean mo519a(C0329i c0329i) {
        if (this.f1260a.f1251c == null) {
            return false;
        }
        this.f1260a.f1251c.onMenuOpened(108, c0329i);
        return true;
    }
}
