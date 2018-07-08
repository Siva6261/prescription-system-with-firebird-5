package android.support.v7.widget;

import android.support.v7.view.menu.C0269j;
import android.support.v7.view.menu.C0329i;
import android.view.MenuItem;

class C0371x implements C0269j {
    final /* synthetic */ ActionMenuView f2459a;

    private C0371x(ActionMenuView actionMenuView) {
        this.f2459a = actionMenuView;
    }

    public void mo485a(C0329i c0329i) {
        if (this.f2459a.f1729g != null) {
            this.f2459a.f1729g.mo485a(c0329i);
        }
    }

    public boolean mo490a(C0329i c0329i, MenuItem menuItem) {
        return this.f2459a.f1734l != null && this.f2459a.f1734l.mo774a(menuItem);
    }
}
