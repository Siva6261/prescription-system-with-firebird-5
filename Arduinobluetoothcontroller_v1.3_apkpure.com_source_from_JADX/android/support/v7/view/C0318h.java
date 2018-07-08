package android.support.v7.view;

import android.content.Context;
import android.support.v4.p012e.p013a.C0133a;
import android.support.v4.p012e.p013a.C0134b;
import android.support.v4.p015h.C0165q;
import android.support.v7.view.menu.ab;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class C0318h implements C0274c {
    final Callback f1450a;
    final Context f1451b;
    final ArrayList f1452c = new ArrayList();
    final C0165q f1453d = new C0165q();

    public C0318h(Context context, Callback callback) {
        this.f1451b = context;
        this.f1450a = callback;
    }

    private Menu m3259a(Menu menu) {
        Menu menu2 = (Menu) this.f1453d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = ab.m3324a(this.f1451b, (C0133a) menu);
        this.f1453d.put(menu, menu2);
        return menu2;
    }

    public void mo520a(C0277b c0277b) {
        this.f1450a.onDestroyActionMode(m3263b(c0277b));
    }

    public boolean mo521a(C0277b c0277b, Menu menu) {
        return this.f1450a.onCreateActionMode(m3263b(c0277b), m3259a(menu));
    }

    public boolean mo522a(C0277b c0277b, MenuItem menuItem) {
        return this.f1450a.onActionItemClicked(m3263b(c0277b), ab.m3325a(this.f1451b, (C0134b) menuItem));
    }

    public ActionMode m3263b(C0277b c0277b) {
        int size = this.f1452c.size();
        for (int i = 0; i < size; i++) {
            C0317g c0317g = (C0317g) this.f1452c.get(i);
            if (c0317g != null && c0317g.f1449b == c0277b) {
                return c0317g;
            }
        }
        ActionMode c0317g2 = new C0317g(this.f1451b, c0277b);
        this.f1452c.add(c0317g2);
        return c0317g2;
    }

    public boolean mo523b(C0277b c0277b, Menu menu) {
        return this.f1450a.onPrepareActionMode(m3263b(c0277b), m3259a(menu));
    }
}
