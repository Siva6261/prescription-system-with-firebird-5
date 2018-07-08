package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p008c.C0066a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ad extends C0329i implements SubMenu {
    private C0329i f1572d;
    private C0337m f1573e;

    public ad(Context context, C0329i c0329i, C0337m c0337m) {
        super(context);
        this.f1572d = c0329i;
        this.f1573e = c0337m;
    }

    public String mo597a() {
        int itemId = this.f1573e != null ? this.f1573e.getItemId() : 0;
        return itemId == 0 ? null : super.mo597a() + ":" + itemId;
    }

    public void mo598a(C0269j c0269j) {
        this.f1572d.mo598a(c0269j);
    }

    boolean mo599a(C0329i c0329i, MenuItem menuItem) {
        return super.mo599a(c0329i, menuItem) || this.f1572d.mo599a(c0329i, menuItem);
    }

    public boolean mo600b() {
        return this.f1572d.mo600b();
    }

    public boolean mo601c() {
        return this.f1572d.mo601c();
    }

    public boolean mo602c(C0337m c0337m) {
        return this.f1572d.mo602c(c0337m);
    }

    public boolean mo603d(C0337m c0337m) {
        return this.f1572d.mo603d(c0337m);
    }

    public MenuItem getItem() {
        return this.f1573e;
    }

    public C0329i mo604p() {
        return this.f1572d;
    }

    public Menu m3393s() {
        return this.f1572d;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m3342a(C0066a.m958a(m3371e(), i));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m3342a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m3344a(m3371e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m3344a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m3343a(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1573e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1573e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f1572d.setQwertyMode(z);
    }
}
