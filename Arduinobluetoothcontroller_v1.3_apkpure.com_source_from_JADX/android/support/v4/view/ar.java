package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p012e.p013a.C0134b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class ar {
    static final av f968a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f968a = new au();
        } else if (i >= 11) {
            f968a = new at();
        } else {
            f968a = new as();
        }
    }

    public static MenuItem m1869a(MenuItem menuItem, C0227n c0227n) {
        if (menuItem instanceof C0134b) {
            return ((C0134b) menuItem).mo587a(c0227n);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem m1870a(MenuItem menuItem, View view) {
        return menuItem instanceof C0134b ? ((C0134b) menuItem).setActionView(view) : f968a.mo298a(menuItem, view);
    }

    public static View m1871a(MenuItem menuItem) {
        return menuItem instanceof C0134b ? ((C0134b) menuItem).getActionView() : f968a.mo299a(menuItem);
    }

    public static void m1872a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0134b) {
            ((C0134b) menuItem).setShowAsAction(i);
        } else {
            f968a.mo300a(menuItem, i);
        }
    }

    public static MenuItem m1873b(MenuItem menuItem, int i) {
        return menuItem instanceof C0134b ? ((C0134b) menuItem).setActionView(i) : f968a.mo301b(menuItem, i);
    }

    public static boolean m1874b(MenuItem menuItem) {
        return menuItem instanceof C0134b ? ((C0134b) menuItem).expandActionView() : f968a.mo302b(menuItem);
    }

    public static boolean m1875c(MenuItem menuItem) {
        return menuItem instanceof C0134b ? ((C0134b) menuItem).isActionViewExpanded() : f968a.mo303c(menuItem);
    }
}
