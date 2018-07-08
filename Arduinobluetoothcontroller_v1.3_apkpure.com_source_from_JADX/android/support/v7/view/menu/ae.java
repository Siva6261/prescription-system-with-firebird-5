package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p012e.p013a.C0135c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class ae extends ac implements SubMenu {
    ae(Context context, C0135c c0135c) {
        super(context, c0135c);
    }

    public C0135c m3394b() {
        return (C0135c) this.b;
    }

    public void clearHeader() {
        m3394b().clearHeader();
    }

    public MenuItem getItem() {
        return m3327a(m3394b().getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        m3394b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m3394b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        m3394b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m3394b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m3394b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        m3394b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m3394b().setIcon(drawable);
        return this;
    }
}
