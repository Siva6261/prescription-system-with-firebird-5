package android.support.v7.view.menu;

import android.support.v7.widget.cx;
import android.support.v7.widget.dc;

class C0330b extends dc {
    final /* synthetic */ ActionMenuItemView f1584a;

    public C0330b(ActionMenuItemView actionMenuItemView) {
        this.f1584a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public cx mo606a() {
        return this.f1584a.f1506f != null ? this.f1584a.f1506f.mo814a() : null;
    }

    protected boolean mo607b() {
        if (this.f1584a.f1504d == null || !this.f1584a.f1504d.mo585a(this.f1584a.f1501a)) {
            return false;
        }
        cx a = mo606a();
        return a != null && a.m4162k();
    }
}
