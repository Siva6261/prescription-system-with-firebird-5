package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p012e.p013a.C0133a;
import android.support.v4.p012e.p013a.C0134b;
import android.support.v4.p012e.p013a.C0135c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class ab {
    public static Menu m3324a(Context context, C0133a c0133a) {
        if (VERSION.SDK_INT >= 14) {
            return new ac(context, c0133a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m3325a(Context context, C0134b c0134b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0344t(context, c0134b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0339o(context, c0134b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m3326a(Context context, C0135c c0135c) {
        if (VERSION.SDK_INT >= 14) {
            return new ae(context, c0135c);
        }
        throw new UnsupportedOperationException();
    }
}
