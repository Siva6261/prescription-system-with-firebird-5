package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p012e.p013a.C0134b;
import android.support.v4.p012e.p013a.C0135c;
import android.support.v4.p015h.C0166a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class C0328e extends C0327f {
    final Context f1544a;
    private Map f1545c;
    private Map f1546d;

    C0328e(Context context, Object obj) {
        super(obj);
        this.f1544a = context;
    }

    final MenuItem m3327a(MenuItem menuItem) {
        if (!(menuItem instanceof C0134b)) {
            return menuItem;
        }
        C0134b c0134b = (C0134b) menuItem;
        if (this.f1545c == null) {
            this.f1545c = new C0166a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1545c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = ab.m3325a(this.f1544a, c0134b);
        this.f1545c.put(c0134b, menuItem2);
        return menuItem2;
    }

    final SubMenu m3328a(SubMenu subMenu) {
        if (!(subMenu instanceof C0135c)) {
            return subMenu;
        }
        C0135c c0135c = (C0135c) subMenu;
        if (this.f1546d == null) {
            this.f1546d = new C0166a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1546d.get(c0135c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = ab.m3326a(this.f1544a, c0135c);
        this.f1546d.put(c0135c, subMenu2);
        return subMenu2;
    }

    final void m3329a() {
        if (this.f1545c != null) {
            this.f1545c.clear();
        }
        if (this.f1546d != null) {
            this.f1546d.clear();
        }
    }

    final void m3330a(int i) {
        if (this.f1545c != null) {
            Iterator it = this.f1545c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m3331b(int i) {
        if (this.f1545c != null) {
            Iterator it = this.f1545c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
