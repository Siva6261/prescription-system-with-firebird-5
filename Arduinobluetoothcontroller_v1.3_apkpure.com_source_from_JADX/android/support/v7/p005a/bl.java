package android.support.v7.p005a;

import android.content.Context;
import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.support.v7.view.C0319i;
import android.support.v7.view.menu.C0269j;
import android.support.v7.view.menu.C0329i;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class bl extends C0277b implements C0269j {
    final /* synthetic */ bh f1319a;
    private final Context f1320b;
    private final C0329i f1321c;
    private C0274c f1322d;
    private WeakReference f1323e;

    public bl(bh bhVar, Context context, C0274c c0274c) {
        this.f1319a = bhVar;
        this.f1320b = context;
        this.f1322d = c0274c;
        this.f1321c = new C0329i(context).m3341a(1);
        this.f1321c.mo598a((C0269j) this);
    }

    public MenuInflater mo554a() {
        return new C0319i(this.f1320b);
    }

    public void mo555a(int i) {
        mo561b(this.f1319a.f1299l.getResources().getString(i));
    }

    public void mo485a(C0329i c0329i) {
        if (this.f1322d != null) {
            mo563d();
            this.f1319a.f1306s.mo630a();
        }
    }

    public void mo556a(View view) {
        this.f1319a.f1306s.setCustomView(view);
        this.f1323e = new WeakReference(view);
    }

    public void mo557a(CharSequence charSequence) {
        this.f1319a.f1306s.setSubtitle(charSequence);
    }

    public void mo558a(boolean z) {
        super.mo558a(z);
        this.f1319a.f1306s.setTitleOptional(z);
    }

    public boolean mo490a(C0329i c0329i, MenuItem menuItem) {
        return this.f1322d != null ? this.f1322d.mo522a((C0277b) this, menuItem) : false;
    }

    public Menu mo559b() {
        return this.f1321c;
    }

    public void mo560b(int i) {
        mo557a(this.f1319a.f1299l.getResources().getString(i));
    }

    public void mo561b(CharSequence charSequence) {
        this.f1319a.f1306s.setTitle(charSequence);
    }

    public void mo562c() {
        if (this.f1319a.f1292a == this) {
            if (bh.m3075b(this.f1319a.f1286D, this.f1319a.f1287E, false)) {
                this.f1322d.mo520a(this);
            } else {
                this.f1319a.f1293b = this;
                this.f1319a.f1294c = this.f1322d;
            }
            this.f1322d = null;
            this.f1319a.m3112j(false);
            this.f1319a.f1306s.m3532b();
            this.f1319a.f1305r.mo776a().sendAccessibilityEvent(32);
            this.f1319a.f1303p.setHideOnContentScrollEnabled(this.f1319a.f1295d);
            this.f1319a.f1292a = null;
        }
    }

    public void mo563d() {
        if (this.f1319a.f1292a == this) {
            this.f1321c.m3373g();
            try {
                this.f1322d.mo523b(this, this.f1321c);
            } finally {
                this.f1321c.m3374h();
            }
        }
    }

    public boolean m3150e() {
        this.f1321c.m3373g();
        try {
            boolean a = this.f1322d.mo521a((C0277b) this, this.f1321c);
            return a;
        } finally {
            this.f1321c.m3374h();
        }
    }

    public CharSequence mo564f() {
        return this.f1319a.f1306s.getTitle();
    }

    public CharSequence mo565g() {
        return this.f1319a.f1306s.getSubtitle();
    }

    public boolean mo566h() {
        return this.f1319a.f1306s.m3534d();
    }

    public View mo567i() {
        return this.f1323e != null ? (View) this.f1323e.get() : null;
    }
}
