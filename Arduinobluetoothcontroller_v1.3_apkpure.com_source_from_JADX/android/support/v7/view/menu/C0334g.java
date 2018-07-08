package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p018b.C0305i;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public class C0334g implements C0332x, OnItemClickListener {
    Context f1595a;
    LayoutInflater f1596b;
    C0329i f1597c;
    ExpandedMenuView f1598d;
    int f1599e;
    int f1600f;
    C0335h f1601g;
    private int f1602h;
    private C0273y f1603i;

    public C0334g(int i, int i2) {
        this.f1600f = i;
        this.f1599e = i2;
    }

    public C0334g(Context context, int i) {
        this(i, 0);
        this.f1595a = context;
        this.f1596b = LayoutInflater.from(this.f1595a);
    }

    public C0030z m3435a(ViewGroup viewGroup) {
        if (this.f1598d == null) {
            this.f1598d = (ExpandedMenuView) this.f1596b.inflate(C0305i.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1601g == null) {
                this.f1601g = new C0335h(this);
            }
            this.f1598d.setAdapter(this.f1601g);
            this.f1598d.setOnItemClickListener(this);
        }
        return this.f1598d;
    }

    public ListAdapter m3436a() {
        if (this.f1601g == null) {
            this.f1601g = new C0335h(this);
        }
        return this.f1601g;
    }

    public void mo608a(Context context, C0329i c0329i) {
        if (this.f1599e != 0) {
            this.f1595a = new ContextThemeWrapper(context, this.f1599e);
            this.f1596b = LayoutInflater.from(this.f1595a);
        } else if (this.f1595a != null) {
            this.f1595a = context;
            if (this.f1596b == null) {
                this.f1596b = LayoutInflater.from(this.f1595a);
            }
        }
        this.f1597c = c0329i;
        if (this.f1601g != null) {
            this.f1601g.notifyDataSetChanged();
        }
    }

    public void mo609a(C0329i c0329i, boolean z) {
        if (this.f1603i != null) {
            this.f1603i.mo518a(c0329i, z);
        }
    }

    public void m3439a(C0273y c0273y) {
        this.f1603i = c0273y;
    }

    public boolean mo610a(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        new C0336l(adVar).m3448a(null);
        if (this.f1603i != null) {
            this.f1603i.mo519a(adVar);
        }
        return true;
    }

    public boolean mo611a(C0329i c0329i, C0337m c0337m) {
        return false;
    }

    public void mo612b(boolean z) {
        if (this.f1601g != null) {
            this.f1601g.notifyDataSetChanged();
        }
    }

    public boolean mo613b() {
        return false;
    }

    public boolean mo614b(C0329i c0329i, C0337m c0337m) {
        return false;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1597c.m3358a(this.f1601g.m3445a(i), (C0332x) this, 0);
    }
}
