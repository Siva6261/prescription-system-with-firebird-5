package android.support.v7.view.menu;

import android.support.v4.view.aw;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class C0342r extends C0327f implements aw {
    final /* synthetic */ C0339o f1641a;

    C0342r(C0339o c0339o, OnActionExpandListener onActionExpandListener) {
        this.f1641a = c0339o;
        super(onActionExpandListener);
    }

    public boolean mo622a(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1641a.m3327a(menuItem));
    }

    public boolean mo623b(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1641a.m3327a(menuItem));
    }
}
