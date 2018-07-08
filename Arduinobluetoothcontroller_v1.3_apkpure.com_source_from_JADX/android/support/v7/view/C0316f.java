package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.C0269j;
import android.support.v7.view.menu.C0329i;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class C0316f extends C0277b implements C0269j {
    private Context f1441a;
    private ActionBarContextView f1442b;
    private C0274c f1443c;
    private WeakReference f1444d;
    private boolean f1445e;
    private boolean f1446f;
    private C0329i f1447g;

    public C0316f(Context context, ActionBarContextView actionBarContextView, C0274c c0274c, boolean z) {
        this.f1441a = context;
        this.f1442b = actionBarContextView;
        this.f1443c = c0274c;
        this.f1447g = new C0329i(actionBarContextView.getContext()).m3341a(1);
        this.f1447g.mo598a((C0269j) this);
        this.f1446f = z;
    }

    public MenuInflater mo554a() {
        return new MenuInflater(this.f1442b.getContext());
    }

    public void mo555a(int i) {
        mo561b(this.f1441a.getString(i));
    }

    public void mo485a(C0329i c0329i) {
        mo563d();
        this.f1442b.mo630a();
    }

    public void mo556a(View view) {
        this.f1442b.setCustomView(view);
        this.f1444d = view != null ? new WeakReference(view) : null;
    }

    public void mo557a(CharSequence charSequence) {
        this.f1442b.setSubtitle(charSequence);
    }

    public void mo558a(boolean z) {
        super.mo558a(z);
        this.f1442b.setTitleOptional(z);
    }

    public boolean mo490a(C0329i c0329i, MenuItem menuItem) {
        return this.f1443c.mo522a((C0277b) this, menuItem);
    }

    public Menu mo559b() {
        return this.f1447g;
    }

    public void mo560b(int i) {
        mo557a(this.f1441a.getString(i));
    }

    public void mo561b(CharSequence charSequence) {
        this.f1442b.setTitle(charSequence);
    }

    public void mo562c() {
        if (!this.f1445e) {
            this.f1445e = true;
            this.f1442b.sendAccessibilityEvent(32);
            this.f1443c.mo520a(this);
        }
    }

    public void mo563d() {
        this.f1443c.mo523b(this, this.f1447g);
    }

    public CharSequence mo564f() {
        return this.f1442b.getTitle();
    }

    public CharSequence mo565g() {
        return this.f1442b.getSubtitle();
    }

    public boolean mo566h() {
        return this.f1442b.m3534d();
    }

    public View mo567i() {
        return this.f1444d != null ? (View) this.f1444d.get() : null;
    }
}
