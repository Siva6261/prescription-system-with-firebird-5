package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.cu;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0299c;
import android.support.v7.p018b.C0301e;
import android.support.v7.p018b.C0304h;
import android.support.v7.p018b.C0308l;
import android.view.ViewConfiguration;

public class C0313a {
    private Context f1437a;

    private C0313a(Context context) {
        this.f1437a = context;
    }

    public static C0313a m3230a(Context context) {
        return new C0313a(context);
    }

    public int m3231a() {
        return this.f1437a.getResources().getInteger(C0304h.abc_max_action_buttons);
    }

    public boolean m3232b() {
        return VERSION.SDK_INT >= 19 || !cu.m2316b(ViewConfiguration.get(this.f1437a));
    }

    public int m3233c() {
        return this.f1437a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m3234d() {
        return this.f1437a.getApplicationInfo().targetSdkVersion >= 16 ? this.f1437a.getResources().getBoolean(C0299c.abc_action_bar_embed_tabs) : this.f1437a.getResources().getBoolean(C0299c.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m3235e() {
        TypedArray obtainStyledAttributes = this.f1437a.obtainStyledAttributes(null, C0308l.ActionBar, C0298b.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0308l.ActionBar_height, 0);
        Resources resources = this.f1437a.getResources();
        if (!m3234d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0301e.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m3236f() {
        return this.f1437a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m3237g() {
        return this.f1437a.getResources().getDimensionPixelSize(C0301e.abc_action_bar_stacked_tab_max_width);
    }
}
