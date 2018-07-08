package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bv;
import android.support.v4.view.dy;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0302f;
import android.support.v7.p018b.C0303g;
import android.support.v7.p018b.C0306j;
import android.support.v7.p018b.C0308l;
import android.support.v7.view.menu.C0269j;
import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0329i;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class go implements bw {
    private Toolbar f2389a;
    private int f2390b;
    private View f2391c;
    private View f2392d;
    private Drawable f2393e;
    private Drawable f2394f;
    private Drawable f2395g;
    private boolean f2396h;
    private CharSequence f2397i;
    private CharSequence f2398j;
    private CharSequence f2399k;
    private Callback f2400l;
    private boolean f2401m;
    private C0359k f2402n;
    private int f2403o;
    private final aq f2404p;
    private int f2405q;
    private Drawable f2406r;

    public go(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0306j.abc_action_bar_up_description, C0302f.abc_ic_ab_back_mtrl_am_alpha);
    }

    public go(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2403o = 0;
        this.f2405q = 0;
        this.f2389a = toolbar;
        this.f2397i = toolbar.getTitle();
        this.f2398j = toolbar.getSubtitle();
        this.f2396h = this.f2397i != null;
        this.f2395g = toolbar.getNavigationIcon();
        if (z) {
            gf a = gf.m4787a(toolbar.getContext(), null, C0308l.ActionBar, C0298b.actionBarStyle, 0);
            CharSequence c = a.m4796c(C0308l.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                mo787b(c);
            }
            c = a.m4796c(C0308l.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m4843c(c);
            }
            Drawable a2 = a.m4790a(C0308l.ActionBar_logo);
            if (a2 != null) {
                m4842c(a2);
            }
            a2 = a.m4790a(C0308l.ActionBar_icon);
            if (this.f2395g == null && a2 != null) {
                mo778a(a2);
            }
            a2 = a.m4790a(C0308l.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                m4847d(a2);
            }
            mo789c(a.m4789a(C0308l.ActionBar_displayOptions, 0));
            int g = a.m4803g(C0308l.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m4832a(LayoutInflater.from(this.f2389a.getContext()).inflate(g, this.f2389a, false));
                mo789c(this.f2390b | 16);
            }
            g = a.m4801f(C0308l.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f2389a.getLayoutParams();
                layoutParams.height = g;
                this.f2389a.setLayoutParams(layoutParams);
            }
            g = a.m4797d(C0308l.ActionBar_contentInsetStart, -1);
            int d = a.m4797d(C0308l.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f2389a.m3990a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m4803g(C0308l.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f2389a.m3991a(this.f2389a.getContext(), g);
            }
            g = a.m4803g(C0308l.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f2389a.m3995b(this.f2389a.getContext(), g);
            }
            int g2 = a.m4803g(C0308l.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f2389a.setPopupTheme(g2);
            }
            a.m4791a();
        } else {
            this.f2390b = m4821s();
        }
        this.f2404p = aq.m4079a();
        m4850e(i);
        this.f2399k = this.f2389a.getNavigationContentDescription();
        m4838b(this.f2404p.m4100a(mo785b(), i2));
        this.f2389a.setNavigationOnClickListener(new gp(this));
    }

    private void m4820e(CharSequence charSequence) {
        this.f2397i = charSequence;
        if ((this.f2390b & 8) != 0) {
            this.f2389a.setTitle(charSequence);
        }
    }

    private int m4821s() {
        return this.f2389a.getNavigationIcon() != null ? 15 : 11;
    }

    private void m4822t() {
        Drawable drawable = null;
        if ((this.f2390b & 2) != 0) {
            drawable = (this.f2390b & 1) != 0 ? this.f2394f != null ? this.f2394f : this.f2393e : this.f2393e;
        }
        this.f2389a.setLogo(drawable);
    }

    private void m4823u() {
        if ((this.f2390b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2399k)) {
            this.f2389a.setNavigationContentDescription(this.f2405q);
        } else {
            this.f2389a.setNavigationContentDescription(this.f2399k);
        }
    }

    private void m4824v() {
        if ((this.f2390b & 4) != 0) {
            this.f2389a.setNavigationIcon(this.f2395g != null ? this.f2395g : this.f2406r);
        }
    }

    public dy mo775a(int i, long j) {
        return bv.m2040q(this.f2389a).m2384a(i == 0 ? 1.0f : 0.0f).m2385a(j).m2386a(new gq(this, i));
    }

    public ViewGroup mo776a() {
        return this.f2389a;
    }

    public void mo777a(int i) {
        mo778a(i != 0 ? this.f2404p.m4100a(mo785b(), i) : null);
    }

    public void mo778a(Drawable drawable) {
        this.f2393e = drawable;
        m4822t();
    }

    public void mo779a(C0273y c0273y, C0269j c0269j) {
        this.f2389a.m3993a(c0273y, c0269j);
    }

    public void mo780a(fd fdVar) {
        if (this.f2391c != null && this.f2391c.getParent() == this.f2389a) {
            this.f2389a.removeView(this.f2391c);
        }
        this.f2391c = fdVar;
        if (fdVar != null && this.f2403o == 2) {
            this.f2389a.addView(this.f2391c, 0);
            gk gkVar = (gk) this.f2391c.getLayoutParams();
            gkVar.width = -2;
            gkVar.height = -2;
            gkVar.a = 8388691;
            fdVar.setAllowCollapse(true);
        }
    }

    public void mo781a(Menu menu, C0273y c0273y) {
        if (this.f2402n == null) {
            this.f2402n = new C0359k(this.f2389a.getContext());
            this.f2402n.m3420a(C0303g.action_menu_presenter);
        }
        this.f2402n.m3424a(c0273y);
        this.f2389a.m3992a((C0329i) menu, this.f2402n);
    }

    public void m4832a(View view) {
        if (!(this.f2392d == null || (this.f2390b & 16) == 0)) {
            this.f2389a.removeView(this.f2392d);
        }
        this.f2392d = view;
        if (view != null && (this.f2390b & 16) != 0) {
            this.f2389a.addView(this.f2392d);
        }
    }

    public void mo782a(Callback callback) {
        this.f2400l = callback;
    }

    public void mo783a(CharSequence charSequence) {
        if (!this.f2396h) {
            m4820e(charSequence);
        }
    }

    public void mo784a(boolean z) {
        this.f2389a.setCollapsible(z);
    }

    public Context mo785b() {
        return this.f2389a.getContext();
    }

    public void mo786b(int i) {
        m4842c(i != 0 ? this.f2404p.m4100a(mo785b(), i) : null);
    }

    public void m4838b(Drawable drawable) {
        if (this.f2406r != drawable) {
            this.f2406r = drawable;
            m4824v();
        }
    }

    public void mo787b(CharSequence charSequence) {
        this.f2396h = true;
        m4820e(charSequence);
    }

    public void mo788b(boolean z) {
    }

    public void mo789c(int i) {
        int i2 = this.f2390b ^ i;
        this.f2390b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m4824v();
                    m4823u();
                } else {
                    this.f2389a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                m4822t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2389a.setTitle(this.f2397i);
                    this.f2389a.setSubtitle(this.f2398j);
                } else {
                    this.f2389a.setTitle(null);
                    this.f2389a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f2392d != null) {
                if ((i & 16) != 0) {
                    this.f2389a.addView(this.f2392d);
                } else {
                    this.f2389a.removeView(this.f2392d);
                }
            }
        }
    }

    public void m4842c(Drawable drawable) {
        this.f2394f = drawable;
        m4822t();
    }

    public void m4843c(CharSequence charSequence) {
        this.f2398j = charSequence;
        if ((this.f2390b & 8) != 0) {
            this.f2389a.setSubtitle(charSequence);
        }
    }

    public boolean mo790c() {
        return this.f2389a.m4001g();
    }

    public void mo791d() {
        this.f2389a.m4002h();
    }

    public void mo792d(int i) {
        m4847d(i != 0 ? aq.m4079a().m4100a(mo785b(), i) : null);
    }

    public void m4847d(Drawable drawable) {
        this.f2395g = drawable;
        m4824v();
    }

    public void m4848d(CharSequence charSequence) {
        this.f2399k = charSequence;
        m4823u();
    }

    public CharSequence mo793e() {
        return this.f2389a.getTitle();
    }

    public void m4850e(int i) {
        if (i != this.f2405q) {
            this.f2405q = i;
            if (TextUtils.isEmpty(this.f2389a.getNavigationContentDescription())) {
                m4852f(this.f2405q);
            }
        }
    }

    public void mo794f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void m4852f(int i) {
        m4848d(i == 0 ? null : mo785b().getString(i));
    }

    public void mo795g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean mo796h() {
        return this.f2389a.m3994a();
    }

    public boolean mo797i() {
        return this.f2389a.m3996b();
    }

    public boolean mo798j() {
        return this.f2389a.m3997c();
    }

    public boolean mo799k() {
        return this.f2389a.m3998d();
    }

    public boolean mo800l() {
        return this.f2389a.m3999e();
    }

    public void mo801m() {
        this.f2401m = true;
    }

    public void mo802n() {
        this.f2389a.m4000f();
    }

    public int mo803o() {
        return this.f2390b;
    }

    public int mo804p() {
        return this.f2403o;
    }

    public int mo805q() {
        return this.f2389a.getVisibility();
    }

    public Menu mo806r() {
        return this.f2389a.getMenu();
    }
}
