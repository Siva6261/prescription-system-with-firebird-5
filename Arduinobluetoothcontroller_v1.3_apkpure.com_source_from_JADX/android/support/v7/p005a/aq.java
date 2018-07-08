package android.support.v7.p005a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0305i;
import android.support.v7.p018b.C0307k;
import android.support.v7.p018b.C0308l;
import android.support.v7.view.C0315e;
import android.support.v7.view.menu.C0030z;
import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0329i;
import android.support.v7.view.menu.C0334g;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

final class aq {
    int f1220a;
    int f1221b;
    int f1222c;
    int f1223d;
    int f1224e;
    int f1225f;
    ViewGroup f1226g;
    View f1227h;
    View f1228i;
    C0329i f1229j;
    C0334g f1230k;
    Context f1231l;
    boolean f1232m;
    boolean f1233n;
    boolean f1234o;
    public boolean f1235p;
    boolean f1236q = false;
    boolean f1237r;
    Bundle f1238s;

    aq(int i) {
        this.f1220a = i;
    }

    C0030z m3007a(C0273y c0273y) {
        if (this.f1229j == null) {
            return null;
        }
        if (this.f1230k == null) {
            this.f1230k = new C0334g(this.f1231l, C0305i.abc_list_menu_item_layout);
            this.f1230k.m3439a(c0273y);
            this.f1229j.m3351a(this.f1230k);
        }
        return this.f1230k.m3435a(this.f1226g);
    }

    void m3008a(Context context) {
        TypedValue typedValue = new TypedValue();
        Theme newTheme = context.getResources().newTheme();
        newTheme.setTo(context.getTheme());
        newTheme.resolveAttribute(C0298b.actionBarPopupTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        }
        newTheme.resolveAttribute(C0298b.panelMenuListTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        } else {
            newTheme.applyStyle(C0307k.Theme_AppCompat_CompactMenu, true);
        }
        Context c0315e = new C0315e(context, 0);
        c0315e.getTheme().setTo(newTheme);
        this.f1231l = c0315e;
        TypedArray obtainStyledAttributes = c0315e.obtainStyledAttributes(C0308l.AppCompatTheme);
        this.f1221b = obtainStyledAttributes.getResourceId(C0308l.AppCompatTheme_panelBackground, 0);
        this.f1225f = obtainStyledAttributes.getResourceId(C0308l.AppCompatTheme_android_windowAnimationStyle, 0);
        obtainStyledAttributes.recycle();
    }

    void m3009a(C0329i c0329i) {
        if (c0329i != this.f1229j) {
            if (this.f1229j != null) {
                this.f1229j.m3362b(this.f1230k);
            }
            this.f1229j = c0329i;
            if (c0329i != null && this.f1230k != null) {
                c0329i.m3351a(this.f1230k);
            }
        }
    }

    public boolean m3010a() {
        return this.f1227h == null ? false : this.f1228i != null || this.f1230k.m3436a().getCount() > 0;
    }
}
