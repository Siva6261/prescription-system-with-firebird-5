package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0227n;
import android.support.v4.view.C0228o;
import android.support.v7.p018b.C0304h;
import android.support.v7.p018b.C0305i;
import android.support.v7.p021f.C0312a;
import android.support.v7.view.C0313a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0030z;
import android.support.v7.view.menu.C0329i;
import android.support.v7.view.menu.C0333d;
import android.support.v7.view.menu.C0337m;
import android.support.v7.view.menu.C0346v;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.ad;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class C0359k extends C0333d implements C0228o {
    private C0362n f2420A;
    final C0367s f2421g = new C0367s();
    int f2422h;
    private C0364p f2423i;
    private Drawable f2424j;
    private boolean f2425k;
    private boolean f2426l;
    private boolean f2427m;
    private int f2428n;
    private int f2429o;
    private int f2430p;
    private boolean f2431q;
    private boolean f2432r;
    private boolean f2433s;
    private boolean f2434t;
    private int f2435u;
    private final SparseBooleanArray f2436v = new SparseBooleanArray();
    private View f2437w;
    private C0366r f2438x;
    private C0361m f2439y;
    private C0363o f2440z;

    public C0359k(Context context) {
        super(context, C0305i.abc_action_menu_layout, C0305i.abc_action_menu_item_layout);
    }

    private View m4897a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof aa) && ((aa) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public C0030z mo807a(ViewGroup viewGroup) {
        C0030z a = super.mo807a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View mo808a(C0337m c0337m, View view, ViewGroup viewGroup) {
        View actionView = c0337m.getActionView();
        if (actionView == null || c0337m.m3478n()) {
            actionView = super.mo808a(c0337m, view, viewGroup);
        }
        actionView.setVisibility(c0337m.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m3576a(layoutParams));
        }
        return actionView;
    }

    public void mo608a(Context context, C0329i c0329i) {
        super.mo608a(context, c0329i);
        Resources resources = context.getResources();
        C0313a a = C0313a.m3230a(context);
        if (!this.f2427m) {
            this.f2426l = a.m3232b();
        }
        if (!this.f2433s) {
            this.f2428n = a.m3233c();
        }
        if (!this.f2431q) {
            this.f2430p = a.m3231a();
        }
        int i = this.f2428n;
        if (this.f2426l) {
            if (this.f2423i == null) {
                this.f2423i = new C0364p(this, this.a);
                if (this.f2425k) {
                    this.f2423i.setImageDrawable(this.f2424j);
                    this.f2424j = null;
                    this.f2425k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2423i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2423i.getMeasuredWidth();
        } else {
            this.f2423i = null;
        }
        this.f2429o = i;
        this.f2435u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f2437w = null;
    }

    public void m4909a(Configuration configuration) {
        if (!this.f2431q) {
            this.f2430p = this.b.getResources().getInteger(C0304h.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.m3363b(true);
        }
    }

    public void m4910a(Drawable drawable) {
        if (this.f2423i != null) {
            this.f2423i.setImageDrawable(drawable);
            return;
        }
        this.f2425k = true;
        this.f2424j = drawable;
    }

    public void mo609a(C0329i c0329i, boolean z) {
        m4925f();
        super.mo609a(c0329i, z);
    }

    public void mo809a(C0337m c0337m, aa aaVar) {
        aaVar.mo24a(c0337m, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aaVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f2420A == null) {
            this.f2420A = new C0362n();
        }
        actionMenuItemView.setPopupCallback(this.f2420A);
    }

    public void m4913a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.mo34a(this.c);
    }

    public void mo810a(boolean z) {
        if (z) {
            super.mo610a(null);
        } else {
            this.c.m3355a(false);
        }
    }

    public boolean mo811a(int i, C0337m c0337m) {
        return c0337m.m3474j();
    }

    public boolean mo610a(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        ad adVar2 = adVar;
        while (adVar2.m3393s() != this.c) {
            adVar2 = (ad) adVar2.m3393s();
        }
        View a = m4897a(adVar2.getItem());
        if (a == null) {
            if (this.f2423i == null) {
                return false;
            }
            a = this.f2423i;
        }
        this.f2422h = adVar.getItem().getItemId();
        this.f2439y = new C0361m(this, this.b, adVar);
        this.f2439y.m3505a(a);
        this.f2439y.m3500a();
        super.mo610a(adVar);
        return true;
    }

    public boolean mo812a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.f2423i ? false : super.mo812a(viewGroup, i);
    }

    public void mo612b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            C0312a.m3229a(viewGroup);
        }
        super.mo612b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m3377k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                C0227n a = ((C0337m) k.get(i)).mo588a();
                if (a != null) {
                    a.m2498a((C0228o) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m3378l() : null;
        if (this.f2426l && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((C0337m) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f2423i == null) {
                this.f2423i = new C0364p(this, this.a);
            }
            viewGroup = (ViewGroup) this.f2423i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2423i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f2423i, actionMenuView.m3585c());
            }
        } else if (this.f2423i != null && this.f2423i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f2423i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f2426l);
    }

    public boolean mo613b() {
        int i;
        ArrayList i2 = this.c.m3375i();
        int size = i2.size();
        int i3 = this.f2430p;
        int i4 = this.f2429o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0337m c0337m = (C0337m) i2.get(i7);
            if (c0337m.m3476l()) {
                i5++;
            } else if (c0337m.m3475k()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.f2434t && c0337m.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.f2426l && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f2436v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f2432r) {
            i = i4 / this.f2435u;
            i6 = ((i4 % this.f2435u) / i) + this.f2435u;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0337m = (C0337m) i2.get(i8);
            int i10;
            if (c0337m.m3476l()) {
                View a = mo808a(c0337m, this.f2437w, viewGroup);
                if (this.f2437w == null) {
                    this.f2437w = a;
                }
                if (this.f2432r) {
                    i9 -= ActionMenuView.m3571a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0337m.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0337m.m3467d(true);
                i = i10;
                i3 = i7;
            } else if (c0337m.m3475k()) {
                boolean z;
                int groupId = c0337m.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f2432r || i9 > 0);
                if (z3) {
                    View a2 = mo808a(c0337m, this.f2437w, viewGroup);
                    if (this.f2437w == null) {
                        this.f2437w = a2;
                    }
                    boolean z4;
                    if (this.f2432r) {
                        int a3 = ActionMenuView.m3571a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f2432r) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0337m c0337m2 = (C0337m) i2.get(i7);
                        if (c0337m2.getGroupId() == groupId) {
                            if (c0337m2.m3474j()) {
                                i5++;
                            }
                            c0337m2.m3467d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0337m.m3467d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0337m.m3467d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public Drawable m4920c() {
        return this.f2423i != null ? this.f2423i.getDrawable() : this.f2425k ? this.f2424j : null;
    }

    public void m4921c(boolean z) {
        this.f2426l = z;
        this.f2427m = true;
    }

    public void m4922d(boolean z) {
        this.f2434t = z;
    }

    public boolean m4923d() {
        if (!this.f2426l || m4927h() || this.c == null || this.f == null || this.f2440z != null || this.c.m3378l().isEmpty()) {
            return false;
        }
        this.f2440z = new C0363o(this, new C0366r(this, this.b, this.c, this.f2423i, true));
        ((View) this.f).post(this.f2440z);
        super.mo610a(null);
        return true;
    }

    public boolean m4924e() {
        if (this.f2440z == null || this.f == null) {
            C0346v c0346v = this.f2438x;
            if (c0346v == null) {
                return false;
            }
            c0346v.m3514e();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f2440z);
        this.f2440z = null;
        return true;
    }

    public boolean m4925f() {
        return m4924e() | m4926g();
    }

    public boolean m4926g() {
        if (this.f2439y == null) {
            return false;
        }
        this.f2439y.m3514e();
        return true;
    }

    public boolean m4927h() {
        return this.f2438x != null && this.f2438x.m3515f();
    }

    public boolean m4928i() {
        return this.f2440z != null || m4927h();
    }
}
