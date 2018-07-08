package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class C0343s extends C0327f implements OnMenuItemClickListener {
    final /* synthetic */ C0339o f1642a;

    C0343s(C0339o c0339o, OnMenuItemClickListener onMenuItemClickListener) {
        this.f1642a = c0339o;
        super(onMenuItemClickListener);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f1642a.m3327a(menuItem));
    }
}
