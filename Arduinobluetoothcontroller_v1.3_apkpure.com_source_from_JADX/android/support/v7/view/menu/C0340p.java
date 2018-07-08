package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.C0227n;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class C0340p extends C0227n {
    final ActionProvider f1638a;
    final /* synthetic */ C0339o f1639b;

    public C0340p(C0339o c0339o, Context context, ActionProvider actionProvider) {
        this.f1639b = c0339o;
        super(context);
        this.f1638a = actionProvider;
    }

    public View mo616a() {
        return this.f1638a.onCreateActionView();
    }

    public void mo617a(SubMenu subMenu) {
        this.f1638a.onPrepareSubMenu(this.f1639b.m3328a(subMenu));
    }

    public boolean mo618d() {
        return this.f1638a.onPerformDefaultAction();
    }

    public boolean mo619e() {
        return this.f1638a.hasSubMenu();
    }
}
