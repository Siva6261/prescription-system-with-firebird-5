package android.support.v7.p005a;

import android.support.v7.view.menu.C0269j;
import android.support.v7.view.menu.C0329i;
import android.view.MenuItem;

final class ba implements C0269j {
    final /* synthetic */ aw f1263a;

    private ba(aw awVar) {
        this.f1263a = awVar;
    }

    public void mo485a(C0329i c0329i) {
        if (this.f1263a.f1251c == null) {
            return;
        }
        if (this.f1263a.f1249a.mo797i()) {
            this.f1263a.f1251c.onPanelClosed(108, c0329i);
        } else if (this.f1263a.f1251c.onPreparePanel(0, null, c0329i)) {
            this.f1263a.f1251c.onMenuOpened(108, c0329i);
        }
    }

    public boolean mo490a(C0329i c0329i, MenuItem menuItem) {
        return false;
    }
}
