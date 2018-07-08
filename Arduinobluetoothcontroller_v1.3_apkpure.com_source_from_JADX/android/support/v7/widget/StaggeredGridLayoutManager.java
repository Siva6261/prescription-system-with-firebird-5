package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.p016a.C0183a;
import android.support.v4.view.p016a.C0190g;
import android.support.v4.view.p016a.C0201r;
import android.support.v4.view.p016a.aj;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.BitSet;

public class StaggeredGridLayoutManager extends eh {
    private final Runnable f1836A = new fp(this);
    C0352do f1837a;
    C0352do f1838b;
    boolean f1839c = false;
    int f1840d = -1;
    int f1841e = Integer.MIN_VALUE;
    fs f1842f = new fs();
    private int f1843g = -1;
    private fx[] f1844h;
    private int f1845i;
    private int f1846j;
    private cp f1847k;
    private boolean f1848l = false;
    private BitSet f1849m;
    private int f1850n = 2;
    private boolean f1851o;
    private boolean f1852t;
    private fv f1853u;
    private int f1854v;
    private final Rect f1855w = new Rect();
    private final fq f1856x = new fq();
    private boolean f1857y = false;
    private boolean f1858z = true;

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f1845i = i2;
        m3920a(i);
        if (this.f1850n == 0) {
            z = false;
        }
        m3691c(z);
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        ei a = eh.m3609a(context, attributeSet, i, i2);
        m3938b(a.f2205a);
        m3920a(a.f2206b);
        m3932a(a.f2207c);
        if (this.f1850n == 0) {
            z = false;
        }
        m3691c(z);
    }

    private boolean m3868H() {
        if (m3731s() == 0 || this.f1850n == 0 || !m3725n()) {
            return false;
        }
        int L;
        int M;
        if (this.f1839c) {
            L = m3872L();
            M = m3873M();
        } else {
            L = m3873M();
            M = m3872L();
        }
        if (L == 0 && m3953f() != null) {
            this.f1842f.m4716a();
            m3624F();
            m3723m();
            return true;
        } else if (!this.f1857y) {
            return false;
        } else {
            int i = this.f1839c ? -1 : 1;
            ft a = this.f1842f.m4715a(L, M + 1, i, true);
            if (a == null) {
                this.f1857y = false;
                this.f1842f.m4714a(M + 1);
                return false;
            }
            ft a2 = this.f1842f.m4715a(L, a.f2319a, i * -1, true);
            if (a2 == null) {
                this.f1842f.m4714a(a.f2319a);
            } else {
                this.f1842f.m4714a(a2.f2319a + 1);
            }
            m3624F();
            m3723m();
            return true;
        }
    }

    private void m3869I() {
        if (this.f1837a == null) {
            this.f1837a = C0352do.m4409a(this, this.f1845i);
            this.f1838b = C0352do.m4409a(this, 1 - this.f1845i);
            this.f1847k = new cp();
        }
    }

    private void m3870J() {
        boolean z = true;
        if (this.f1845i == 1 || !m3956h()) {
            this.f1839c = this.f1848l;
            return;
        }
        if (this.f1848l) {
            z = false;
        }
        this.f1839c = z;
    }

    private void m3871K() {
        if (this.f1838b.mo741h() != 1073741824) {
            float f = 0.0f;
            int s = m3731s();
            int i = 0;
            while (i < s) {
                float f2;
                View h = m3713h(i);
                float c = (float) this.f1838b.mo735c(h);
                if (c < f) {
                    f2 = f;
                } else {
                    f2 = Math.max(f, ((fr) h.getLayoutParams()).m4709a() ? (1.0f * c) / ((float) this.f1843g) : c);
                }
                i++;
                f = f2;
            }
            i = this.f1846j;
            int round = Math.round(((float) this.f1843g) * f);
            if (this.f1838b.mo741h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f1838b.mo739f());
            }
            m3950e(round);
            if (this.f1846j != i) {
                for (int i2 = 0; i2 < s; i2++) {
                    View h2 = m3713h(i2);
                    fr frVar = (fr) h2.getLayoutParams();
                    if (!frVar.f2316f) {
                        if (m3956h() && this.f1845i == 1) {
                            h2.offsetLeftAndRight(((-((this.f1843g - 1) - frVar.f2315e.f2336d)) * this.f1846j) - ((-((this.f1843g - 1) - frVar.f2315e.f2336d)) * i));
                        } else {
                            int i3 = frVar.f2315e.f2336d * this.f1846j;
                            round = frVar.f2315e.f2336d * i;
                            if (this.f1845i == 1) {
                                h2.offsetLeftAndRight(i3 - round);
                            } else {
                                h2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private int m3872L() {
        int s = m3731s();
        return s == 0 ? 0 : m3694d(m3713h(s - 1));
    }

    private int m3873M() {
        return m3731s() == 0 ? 0 : m3694d(m3713h(0));
    }

    private int m3874a(eo eoVar, cp cpVar, ev evVar) {
        int q;
        this.f1849m.set(0, this.f1843g, true);
        int i = this.f1847k.f2137i ? cpVar.f2133e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : cpVar.f2133e == 1 ? cpVar.f2135g + cpVar.f2130b : cpVar.f2134f - cpVar.f2130b;
        m3896e(cpVar.f2133e, i);
        int d = this.f1839c ? this.f1837a.mo736d() : this.f1837a.mo734c();
        Object obj = null;
        while (cpVar.m4368a(evVar) && (this.f1847k.f2137i || !this.f1849m.isEmpty())) {
            fx fxVar;
            int c;
            int c2;
            View a = cpVar.m4367a(eoVar);
            fr frVar = (fr) a.getLayoutParams();
            int e = frVar.m4360e();
            int c3 = this.f1842f.m4722c(e);
            Object obj2 = c3 == -1 ? 1 : null;
            if (obj2 != null) {
                fx a2 = frVar.f2316f ? this.f1844h[0] : m3876a(cpVar);
                this.f1842f.m4718a(e, a2);
                fxVar = a2;
            } else {
                fxVar = this.f1844h[c3];
            }
            frVar.f2315e = fxVar;
            if (cpVar.f2133e == 1) {
                m3677b(a);
            } else {
                m3678b(a, 0);
            }
            m3885a(a, frVar, false);
            if (cpVar.f2133e == 1) {
                q = frVar.f2316f ? m3905q(d) : fxVar.m4740b(d);
                c = q + this.f1837a.mo735c(a);
                if (obj2 == null || !frVar.f2316f) {
                    c3 = q;
                } else {
                    ft m = m3900m(q);
                    m.f2320b = -1;
                    m.f2319a = e;
                    this.f1842f.m4719a(m);
                    c3 = q;
                }
            } else {
                q = frVar.f2316f ? m3903p(d) : fxVar.m4734a(d);
                c3 = q - this.f1837a.mo735c(a);
                if (obj2 != null && frVar.f2316f) {
                    ft n = m3901n(q);
                    n.f2320b = 1;
                    n.f2319a = e;
                    this.f1842f.m4719a(n);
                }
                c = q;
            }
            if (frVar.f2316f && cpVar.f2132d == -1) {
                if (obj2 != null) {
                    this.f1857y = true;
                } else {
                    obj = cpVar.f2133e == 1 ? !m3961k() ? 1 : null : !m3962l() ? 1 : null;
                    if (obj != null) {
                        ft f = this.f1842f.m4725f(e);
                        if (f != null) {
                            f.f2322d = true;
                        }
                        this.f1857y = true;
                    }
                }
            }
            m3884a(a, frVar, cpVar);
            if (m3956h() && this.f1845i == 1) {
                q = frVar.f2316f ? this.f1838b.mo736d() : this.f1838b.mo736d() - (((this.f1843g - 1) - fxVar.f2336d) * this.f1846j);
                c2 = q - this.f1838b.mo735c(a);
                e = q;
            } else {
                q = frVar.f2316f ? this.f1838b.mo734c() : (fxVar.f2336d * this.f1846j) + this.f1838b.mo734c();
                e = q + this.f1838b.mo735c(a);
                c2 = q;
            }
            if (this.f1845i == 1) {
                m3891b(a, c2, c3, e, c);
            } else {
                m3891b(a, c3, c2, c, e);
            }
            if (frVar.f2316f) {
                m3896e(this.f1847k.f2133e, i);
            } else {
                m3882a(fxVar, this.f1847k.f2133e, i);
            }
            m3879a(eoVar, this.f1847k);
            if (this.f1847k.f2136h && a.isFocusable()) {
                if (frVar.f2316f) {
                    this.f1849m.clear();
                } else {
                    this.f1849m.set(fxVar.f2336d, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m3879a(eoVar, this.f1847k);
        }
        q = this.f1847k.f2133e == -1 ? this.f1837a.mo734c() - m3903p(this.f1837a.mo734c()) : m3905q(this.f1837a.mo736d()) - this.f1837a.mo736d();
        return q > 0 ? Math.min(cpVar.f2130b, q) : 0;
    }

    private int m3875a(ev evVar) {
        boolean z = false;
        if (m3731s() == 0) {
            return 0;
        }
        m3869I();
        C0352do c0352do = this.f1837a;
        View a = m3919a(!this.f1858z, true);
        if (!this.f1858z) {
            z = true;
        }
        return fc.m4686a(evVar, c0352do, a, m3937b(z, true), this, this.f1858z, this.f1839c);
    }

    private fx m3876a(cp cpVar) {
        int i;
        int i2;
        fx fxVar = null;
        int i3 = -1;
        if (m3908s(cpVar.f2133e)) {
            i = this.f1843g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f1843g;
            i3 = 1;
        }
        int c;
        int i4;
        fx fxVar2;
        int b;
        fx fxVar3;
        if (cpVar.f2133e == 1) {
            c = this.f1837a.mo734c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                fxVar2 = this.f1844h[i4];
                b = fxVar2.m4740b(c);
                if (b < i) {
                    fxVar3 = fxVar2;
                } else {
                    b = i;
                    fxVar3 = fxVar;
                }
                i4 += i3;
                fxVar = fxVar3;
                i = b;
            }
        } else {
            c = this.f1837a.mo736d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                fxVar2 = this.f1844h[i4];
                b = fxVar2.m4734a(c);
                if (b > i) {
                    fxVar3 = fxVar2;
                } else {
                    b = i;
                    fxVar3 = fxVar;
                }
                i4 += i3;
                fxVar = fxVar3;
                i = b;
            }
        }
        return fxVar;
    }

    private void m3877a(int i, ev evVar) {
        int c;
        int i2;
        cp cpVar;
        boolean z = false;
        this.f1847k.f2130b = 0;
        this.f1847k.f2131c = i;
        if (m3728p()) {
            c = evVar.m4608c();
            if (c != -1) {
                if (this.f1839c == (c < i)) {
                    c = this.f1837a.mo739f();
                    i2 = 0;
                } else {
                    i2 = this.f1837a.mo739f();
                    c = 0;
                }
                if (m3727o()) {
                    this.f1847k.f2135g = c + this.f1837a.mo738e();
                    this.f1847k.f2134f = -i2;
                } else {
                    this.f1847k.f2134f = this.f1837a.mo734c() - i2;
                    this.f1847k.f2135g = c + this.f1837a.mo736d();
                }
                this.f1847k.f2136h = false;
                this.f1847k.f2129a = true;
                cpVar = this.f1847k;
                if (this.f1837a.mo741h() == 0) {
                    z = true;
                }
                cpVar.f2137i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (m3727o()) {
            this.f1847k.f2135g = c + this.f1837a.mo738e();
            this.f1847k.f2134f = -i2;
        } else {
            this.f1847k.f2134f = this.f1837a.mo734c() - i2;
            this.f1847k.f2135g = c + this.f1837a.mo736d();
        }
        this.f1847k.f2136h = false;
        this.f1847k.f2129a = true;
        cpVar = this.f1847k;
        if (this.f1837a.mo741h() == 0) {
            z = true;
        }
        cpVar.f2137i = z;
    }

    private void m3878a(eo eoVar, int i) {
        while (m3731s() > 0) {
            View h = m3713h(0);
            if (this.f1837a.mo733b(h) <= i) {
                fr frVar = (fr) h.getLayoutParams();
                if (frVar.f2316f) {
                    int i2 = 0;
                    while (i2 < this.f1843g) {
                        if (this.f1844h[i2].f2338f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1843g; i2++) {
                        this.f1844h[i2].m4750h();
                    }
                } else if (frVar.f2315e.f2338f.size() != 1) {
                    frVar.f2315e.m4750h();
                } else {
                    return;
                }
                m3655a(h, eoVar);
            } else {
                return;
            }
        }
    }

    private void m3879a(eo eoVar, cp cpVar) {
        if (cpVar.f2129a && !cpVar.f2137i) {
            if (cpVar.f2130b == 0) {
                if (cpVar.f2133e == -1) {
                    m3889b(eoVar, cpVar.f2135g);
                } else {
                    m3878a(eoVar, cpVar.f2134f);
                }
            } else if (cpVar.f2133e == -1) {
                r0 = cpVar.f2134f - m3902o(cpVar.f2134f);
                m3889b(eoVar, r0 < 0 ? cpVar.f2135g : cpVar.f2135g - Math.min(r0, cpVar.f2130b));
            } else {
                r0 = m3907r(cpVar.f2135g) - cpVar.f2135g;
                m3878a(eoVar, r0 < 0 ? cpVar.f2134f : Math.min(r0, cpVar.f2130b) + cpVar.f2134f);
            }
        }
    }

    private void m3880a(eo eoVar, ev evVar, boolean z) {
        m3869I();
        fq fqVar = this.f1856x;
        fqVar.m4706a();
        if (!(this.f1853u == null && this.f1840d == -1) && evVar.m4610e() == 0) {
            m3687c(eoVar);
            return;
        }
        boolean z2;
        if (this.f1853u != null) {
            m3881a(fqVar);
        } else {
            m3870J();
            fqVar.f2312c = this.f1839c;
        }
        m3929a(evVar, fqVar);
        if (this.f1853u == null && !(fqVar.f2312c == this.f1851o && m3956h() == this.f1852t)) {
            this.f1842f.m4716a();
            fqVar.f2313d = true;
        }
        if (m3731s() > 0 && (this.f1853u == null || this.f1853u.f2325c < 1)) {
            int i;
            if (fqVar.f2313d) {
                for (i = 0; i < this.f1843g; i++) {
                    this.f1844h[i].m4747e();
                    if (fqVar.f2311b != Integer.MIN_VALUE) {
                        this.f1844h[i].m4744c(fqVar.f2311b);
                    }
                }
            } else {
                for (i = 0; i < this.f1843g; i++) {
                    this.f1844h[i].m4738a(this.f1839c, fqVar.f2311b);
                }
            }
        }
        m3643a(eoVar);
        this.f1847k.f2129a = false;
        this.f1857y = false;
        m3950e(this.f1838b.mo739f());
        m3877a(fqVar.f2310a, evVar);
        if (fqVar.f2312c) {
            m3899l(-1);
            m3874a(eoVar, this.f1847k, evVar);
            m3899l(1);
            this.f1847k.f2131c = fqVar.f2310a + this.f1847k.f2132d;
            m3874a(eoVar, this.f1847k, evVar);
        } else {
            m3899l(1);
            m3874a(eoVar, this.f1847k, evVar);
            m3899l(-1);
            this.f1847k.f2131c = fqVar.f2310a + this.f1847k.f2132d;
            m3874a(eoVar, this.f1847k, evVar);
        }
        m3871K();
        if (m3731s() > 0) {
            if (this.f1839c) {
                m3890b(eoVar, evVar, true);
                m3894c(eoVar, evVar, false);
            } else {
                m3894c(eoVar, evVar, true);
                m3890b(eoVar, evVar, false);
            }
        }
        if (!z || evVar.m4606a()) {
            z2 = false;
        } else {
            z2 = this.f1850n != 0 && m3731s() > 0 && (this.f1857y || m3953f() != null);
            if (z2) {
                m3668a(this.f1836A);
                if (m3868H()) {
                    z2 = true;
                    this.f1840d = -1;
                    this.f1841e = Integer.MIN_VALUE;
                }
            }
            z2 = false;
            this.f1840d = -1;
            this.f1841e = Integer.MIN_VALUE;
        }
        this.f1851o = fqVar.f2312c;
        this.f1852t = m3956h();
        this.f1853u = null;
        if (z2) {
            m3880a(eoVar, evVar, false);
        }
    }

    private void m3881a(fq fqVar) {
        if (this.f1853u.f2325c > 0) {
            if (this.f1853u.f2325c == this.f1843g) {
                for (int i = 0; i < this.f1843g; i++) {
                    this.f1844h[i].m4747e();
                    int i2 = this.f1853u.f2326d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 = this.f1853u.f2331i ? i2 + this.f1837a.mo736d() : i2 + this.f1837a.mo734c();
                    }
                    this.f1844h[i].m4744c(i2);
                }
            } else {
                this.f1853u.m4729a();
                this.f1853u.f2323a = this.f1853u.f2324b;
            }
        }
        this.f1852t = this.f1853u.f2332j;
        m3932a(this.f1853u.f2330h);
        m3870J();
        if (this.f1853u.f2323a != -1) {
            this.f1840d = this.f1853u.f2323a;
            fqVar.f2312c = this.f1853u.f2331i;
        } else {
            fqVar.f2312c = this.f1839c;
        }
        if (this.f1853u.f2327e > 1) {
            this.f1842f.f2317a = this.f1853u.f2328f;
            this.f1842f.f2318b = this.f1853u.f2329g;
        }
    }

    private void m3882a(fx fxVar, int i, int i2) {
        int i3 = fxVar.m4751i();
        if (i == -1) {
            if (i3 + fxVar.m4739b() <= i2) {
                this.f1849m.set(fxVar.f2336d, false);
            }
        } else if (fxVar.m4745d() - i3 >= i2) {
            this.f1849m.set(fxVar.f2336d, false);
        }
    }

    private void m3883a(View view, int i, int i2, boolean z) {
        m3653a(view, this.f1855w);
        fr frVar = (fr) view.getLayoutParams();
        int b = m3888b(i, frVar.leftMargin + this.f1855w.left, frVar.rightMargin + this.f1855w.right);
        int b2 = m3888b(i2, frVar.topMargin + this.f1855w.top, frVar.bottomMargin + this.f1855w.bottom);
        if (z ? m3666a(view, b, b2, (ej) frVar) : m3680b(view, b, b2, frVar)) {
            view.measure(b, b2);
        }
    }

    private void m3884a(View view, fr frVar, cp cpVar) {
        if (cpVar.f2133e == 1) {
            if (frVar.f2316f) {
                m3904p(view);
            } else {
                frVar.f2315e.m4741b(view);
            }
        } else if (frVar.f2316f) {
            m3906q(view);
        } else {
            frVar.f2315e.m4737a(view);
        }
    }

    private void m3885a(View view, fr frVar, boolean z) {
        if (frVar.f2316f) {
            if (this.f1845i == 1) {
                m3883a(view, this.f1854v, eh.m3608a(m3735w(), m3733u(), 0, frVar.height, true), z);
            } else {
                m3883a(view, eh.m3608a(m3734v(), m3732t(), 0, frVar.width, true), this.f1854v, z);
            }
        } else if (this.f1845i == 1) {
            m3883a(view, eh.m3608a(this.f1846j, m3732t(), 0, frVar.width, false), eh.m3608a(m3735w(), m3733u(), 0, frVar.height, true), z);
        } else {
            m3883a(view, eh.m3608a(m3734v(), m3732t(), 0, frVar.width, true), eh.m3608a(this.f1846j, m3733u(), 0, frVar.height, false), z);
        }
    }

    private boolean m3887a(fx fxVar) {
        boolean z = true;
        if (this.f1839c) {
            if (fxVar.m4745d() < this.f1837a.mo736d()) {
                return !fxVar.m4742c((View) fxVar.f2338f.get(fxVar.f2338f.size() + -1)).f2316f;
            }
        } else if (fxVar.m4739b() > this.f1837a.mo734c()) {
            if (fxVar.m4742c((View) fxVar.f2338f.get(0)).f2316f) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private int m3888b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private void m3889b(eo eoVar, int i) {
        int s = m3731s() - 1;
        while (s >= 0) {
            View h = m3713h(s);
            if (this.f1837a.mo731a(h) >= i) {
                fr frVar = (fr) h.getLayoutParams();
                if (frVar.f2316f) {
                    int i2 = 0;
                    while (i2 < this.f1843g) {
                        if (this.f1844h[i2].f2338f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1843g; i2++) {
                        this.f1844h[i2].m4749g();
                    }
                } else if (frVar.f2315e.f2338f.size() != 1) {
                    frVar.f2315e.m4749g();
                } else {
                    return;
                }
                m3655a(h, eoVar);
                s--;
            } else {
                return;
            }
        }
    }

    private void m3890b(eo eoVar, ev evVar, boolean z) {
        int q = m3905q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.f1837a.mo736d() - q;
            if (q > 0) {
                q -= -m3942c(-q, eoVar, evVar);
                if (z && q > 0) {
                    this.f1837a.mo732a(q);
                }
            }
        }
    }

    private void m3891b(View view, int i, int i2, int i3, int i4) {
        fr frVar = (fr) view.getLayoutParams();
        m3651a(view, i + frVar.leftMargin, i2 + frVar.topMargin, i3 - frVar.rightMargin, i4 - frVar.bottomMargin);
    }

    private void m3893c(int i, int i2, int i3) {
        int i4;
        int i5;
        int L = this.f1839c ? m3872L() : m3873M();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f1842f.m4720b(i5);
        switch (i3) {
            case 1:
                this.f1842f.m4721b(i, i2);
                break;
            case 2:
                this.f1842f.m4717a(i, i2);
                break;
            case 8:
                this.f1842f.m4717a(i, 1);
                this.f1842f.m4721b(i2, 1);
                break;
        }
        if (i4 > L) {
            if (i5 <= (this.f1839c ? m3873M() : m3872L())) {
                m3723m();
            }
        }
    }

    private void m3894c(eo eoVar, ev evVar, boolean z) {
        int p = m3903p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.f1837a.mo734c();
            if (p > 0) {
                p -= m3942c(p, eoVar, evVar);
                if (z && p > 0) {
                    this.f1837a.mo732a(-p);
                }
            }
        }
    }

    private boolean m3895c(ev evVar, fq fqVar) {
        fqVar.f2310a = this.f1851o ? m3911v(evVar.m4610e()) : m3910u(evVar.m4610e());
        fqVar.f2311b = Integer.MIN_VALUE;
        return true;
    }

    private void m3896e(int i, int i2) {
        for (int i3 = 0; i3 < this.f1843g; i3++) {
            if (!this.f1844h[i3].f2338f.isEmpty()) {
                m3882a(this.f1844h[i3], i, i2);
            }
        }
    }

    private int m3897h(ev evVar) {
        boolean z = false;
        if (m3731s() == 0) {
            return 0;
        }
        m3869I();
        C0352do c0352do = this.f1837a;
        View a = m3919a(!this.f1858z, true);
        if (!this.f1858z) {
            z = true;
        }
        return fc.m4685a(evVar, c0352do, a, m3937b(z, true), this, this.f1858z);
    }

    private int m3898i(ev evVar) {
        boolean z = false;
        if (m3731s() == 0) {
            return 0;
        }
        m3869I();
        C0352do c0352do = this.f1837a;
        View a = m3919a(!this.f1858z, true);
        if (!this.f1858z) {
            z = true;
        }
        return fc.m4687b(evVar, c0352do, a, m3937b(z, true), this, this.f1858z);
    }

    private void m3899l(int i) {
        int i2 = 1;
        this.f1847k.f2133e = i;
        cp cpVar = this.f1847k;
        if (this.f1839c != (i == -1)) {
            i2 = -1;
        }
        cpVar.f2132d = i2;
    }

    private ft m3900m(int i) {
        ft ftVar = new ft();
        ftVar.f2321c = new int[this.f1843g];
        for (int i2 = 0; i2 < this.f1843g; i2++) {
            ftVar.f2321c[i2] = i - this.f1844h[i2].m4740b(i);
        }
        return ftVar;
    }

    private ft m3901n(int i) {
        ft ftVar = new ft();
        ftVar.f2321c = new int[this.f1843g];
        for (int i2 = 0; i2 < this.f1843g; i2++) {
            ftVar.f2321c[i2] = this.f1844h[i2].m4734a(i) - i;
        }
        return ftVar;
    }

    private int m3902o(int i) {
        int a = this.f1844h[0].m4734a(i);
        for (int i2 = 1; i2 < this.f1843g; i2++) {
            int a2 = this.f1844h[i2].m4734a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m3903p(int i) {
        int a = this.f1844h[0].m4734a(i);
        for (int i2 = 1; i2 < this.f1843g; i2++) {
            int a2 = this.f1844h[i2].m4734a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void m3904p(View view) {
        for (int i = this.f1843g - 1; i >= 0; i--) {
            this.f1844h[i].m4741b(view);
        }
    }

    private int m3905q(int i) {
        int b = this.f1844h[0].m4740b(i);
        for (int i2 = 1; i2 < this.f1843g; i2++) {
            int b2 = this.f1844h[i2].m4740b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void m3906q(View view) {
        for (int i = this.f1843g - 1; i >= 0; i--) {
            this.f1844h[i].m4737a(view);
        }
    }

    private int m3907r(int i) {
        int b = this.f1844h[0].m4740b(i);
        for (int i2 = 1; i2 < this.f1843g; i2++) {
            int b2 = this.f1844h[i2].m4740b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean m3908s(int i) {
        if (this.f1845i == 0) {
            return (i == -1) != this.f1839c;
        } else {
            return ((i == -1) == this.f1839c) == m3956h();
        }
    }

    private int m3909t(int i) {
        int i2 = -1;
        if (m3731s() == 0) {
            return this.f1839c ? 1 : -1;
        } else {
            if ((i < m3873M()) == this.f1839c) {
                i2 = 1;
            }
            return i2;
        }
    }

    private int m3910u(int i) {
        int s = m3731s();
        for (int i2 = 0; i2 < s; i2++) {
            int d = m3694d(m3713h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m3911v(int i) {
        for (int s = m3731s() - 1; s >= 0; s--) {
            int d = m3694d(m3713h(s));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m3912w(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                return this.f1845i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f1845i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.f1845i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f1845i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int mo657a(int i, eo eoVar, ev evVar) {
        return m3942c(i, eoVar, evVar);
    }

    public int mo679a(eo eoVar, ev evVar) {
        return this.f1845i == 0 ? this.f1843g : super.mo679a(eoVar, evVar);
    }

    public ej mo658a() {
        return this.f1845i == 0 ? new fr(-2, -1) : new fr(-1, -2);
    }

    public ej mo680a(Context context, AttributeSet attributeSet) {
        return new fr(context, attributeSet);
    }

    public ej mo681a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new fr((MarginLayoutParams) layoutParams) : new fr(layoutParams);
    }

    public View mo659a(View view, int i, eo eoVar, ev evVar) {
        int i2 = 0;
        if (m3731s() == 0) {
            return null;
        }
        View e = m3701e(view);
        if (e == null) {
            return null;
        }
        m3869I();
        m3870J();
        int w = m3912w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        View a;
        fr frVar = (fr) e.getLayoutParams();
        boolean z = frVar.f2316f;
        fx fxVar = frVar.f2315e;
        int L = w == 1 ? m3872L() : m3873M();
        m3877a(L, evVar);
        m3899l(w);
        this.f1847k.f2131c = this.f1847k.f2132d + L;
        this.f1847k.f2130b = (int) (0.33333334f * ((float) this.f1837a.mo739f()));
        this.f1847k.f2136h = true;
        this.f1847k.f2129a = false;
        m3874a(eoVar, this.f1847k, evVar);
        this.f1851o = this.f1839c;
        if (!z) {
            a = fxVar.m4735a(L, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (m3908s(w)) {
            for (int i3 = this.f1843g - 1; i3 >= 0; i3--) {
                View a2 = this.f1844h[i3].m4735a(L, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.f1843g) {
                a = this.f1844h[i2].m4735a(L, w);
                if (a != null && a != e) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    View m3919a(boolean z, boolean z2) {
        m3869I();
        int c = this.f1837a.mo734c();
        int d = this.f1837a.mo736d();
        int s = m3731s();
        View view = null;
        for (int i = 0; i < s; i++) {
            View h = m3713h(i);
            int a = this.f1837a.mo731a(h);
            if (this.f1837a.mo733b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void m3920a(int i) {
        mo663a(null);
        if (i != this.f1843g) {
            m3955g();
            this.f1843g = i;
            this.f1849m = new BitSet(this.f1843g);
            this.f1844h = new fx[this.f1843g];
            for (int i2 = 0; i2 < this.f1843g; i2++) {
                this.f1844h[i2] = new fx(this, i2);
            }
            m3723m();
        }
    }

    public void mo683a(Rect rect, int i, int i2) {
        int z = m3738z() + m3736x();
        int y = m3737y() + m3619A();
        if (this.f1845i == 1) {
            y = eh.m3607a(i2, y + rect.height(), m3622D());
            z = eh.m3607a(i, z + (this.f1846j * this.f1843g), m3621C());
        } else {
            z = eh.m3607a(i, z + rect.width(), m3621C());
            y = eh.m3607a(i2, y + (this.f1846j * this.f1843g), m3622D());
        }
        m3697d(z, y);
    }

    public void mo660a(Parcelable parcelable) {
        if (parcelable instanceof fv) {
            this.f1853u = (fv) parcelable;
            m3723m();
        }
    }

    public void mo684a(RecyclerView recyclerView) {
        this.f1842f.m4716a();
        m3723m();
    }

    public void mo685a(RecyclerView recyclerView, int i, int i2) {
        m3893c(i, i2, 1);
    }

    public void mo686a(RecyclerView recyclerView, int i, int i2, int i3) {
        m3893c(i, i2, 8);
    }

    public void mo687a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m3893c(i, i2, 4);
    }

    public void mo661a(RecyclerView recyclerView, eo eoVar) {
        m3668a(this.f1836A);
        for (int i = 0; i < this.f1843g; i++) {
            this.f1844h[i].m4747e();
        }
    }

    public void mo690a(eo eoVar, ev evVar, View view, C0190g c0190g) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof fr) {
            fr frVar = (fr) layoutParams;
            if (this.f1845i == 0) {
                c0190g.m1701b(C0201r.m1795a(frVar.m4710b(), frVar.f2316f ? this.f1843g : 1, -1, -1, frVar.f2316f, false));
                return;
            } else {
                c0190g.m1701b(C0201r.m1795a(-1, -1, frVar.m4710b(), frVar.f2316f ? this.f1843g : 1, frVar.f2316f, false));
                return;
            }
        }
        super.m3654a(view, c0190g);
    }

    void m3929a(ev evVar, fq fqVar) {
        if (!m3941b(evVar, fqVar) && !m3895c(evVar, fqVar)) {
            fqVar.m4708b();
            fqVar.f2310a = 0;
        }
    }

    public void mo662a(AccessibilityEvent accessibilityEvent) {
        super.mo662a(accessibilityEvent);
        if (m3731s() > 0) {
            aj a = C0183a.m1624a(accessibilityEvent);
            View a2 = m3919a(false, true);
            View b = m3937b(false, true);
            if (a2 != null && b != null) {
                int d = m3694d(a2);
                int d2 = m3694d(b);
                if (d < d2) {
                    a.m1645b(d);
                    a.m1646c(d2);
                    return;
                }
                a.m1645b(d2);
                a.m1646c(d);
            }
        }
    }

    public void mo663a(String str) {
        if (this.f1853u == null) {
            super.mo663a(str);
        }
    }

    public void m3932a(boolean z) {
        mo663a(null);
        if (!(this.f1853u == null || this.f1853u.f2330h == z)) {
            this.f1853u.f2330h = z;
        }
        this.f1848l = z;
        m3723m();
    }

    public boolean mo692a(ej ejVar) {
        return ejVar instanceof fr;
    }

    public int mo664b(int i, eo eoVar, ev evVar) {
        return m3942c(i, eoVar, evVar);
    }

    public int mo693b(eo eoVar, ev evVar) {
        return this.f1845i == 1 ? this.f1843g : super.mo693b(eoVar, evVar);
    }

    public int mo665b(ev evVar) {
        return m3875a(evVar);
    }

    View m3937b(boolean z, boolean z2) {
        m3869I();
        int c = this.f1837a.mo734c();
        int d = this.f1837a.mo736d();
        View view = null;
        for (int s = m3731s() - 1; s >= 0; s--) {
            View h = m3713h(s);
            int a = this.f1837a.mo731a(h);
            int b = this.f1837a.mo733b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void m3938b(int i) {
        if (i == 0 || i == 1) {
            mo663a(null);
            if (i != this.f1845i) {
                this.f1845i = i;
                if (!(this.f1837a == null || this.f1838b == null)) {
                    C0352do c0352do = this.f1837a;
                    this.f1837a = this.f1838b;
                    this.f1838b = c0352do;
                }
                m3723m();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void mo694b(RecyclerView recyclerView, int i, int i2) {
        m3893c(i, i2, 2);
    }

    public boolean mo666b() {
        return this.f1853u == null;
    }

    boolean m3941b(ev evVar, fq fqVar) {
        boolean z = false;
        if (evVar.m4606a() || this.f1840d == -1) {
            return false;
        }
        if (this.f1840d < 0 || this.f1840d >= evVar.m4610e()) {
            this.f1840d = -1;
            this.f1841e = Integer.MIN_VALUE;
            return false;
        } else if (this.f1853u == null || this.f1853u.f2323a == -1 || this.f1853u.f2325c < 1) {
            View c = mo669c(this.f1840d);
            if (c != null) {
                fqVar.f2310a = this.f1839c ? m3872L() : m3873M();
                if (this.f1841e != Integer.MIN_VALUE) {
                    if (fqVar.f2312c) {
                        fqVar.f2311b = (this.f1837a.mo736d() - this.f1841e) - this.f1837a.mo733b(c);
                        return true;
                    }
                    fqVar.f2311b = (this.f1837a.mo734c() + this.f1841e) - this.f1837a.mo731a(c);
                    return true;
                } else if (this.f1837a.mo735c(c) > this.f1837a.mo739f()) {
                    fqVar.f2311b = fqVar.f2312c ? this.f1837a.mo736d() : this.f1837a.mo734c();
                    return true;
                } else {
                    int a = this.f1837a.mo731a(c) - this.f1837a.mo734c();
                    if (a < 0) {
                        fqVar.f2311b = -a;
                        return true;
                    }
                    a = this.f1837a.mo736d() - this.f1837a.mo733b(c);
                    if (a < 0) {
                        fqVar.f2311b = a;
                        return true;
                    }
                    fqVar.f2311b = Integer.MIN_VALUE;
                    return true;
                }
            }
            fqVar.f2310a = this.f1840d;
            if (this.f1841e == Integer.MIN_VALUE) {
                if (m3909t(fqVar.f2310a) == 1) {
                    z = true;
                }
                fqVar.f2312c = z;
                fqVar.m4708b();
            } else {
                fqVar.m4707a(this.f1841e);
            }
            fqVar.f2313d = true;
            return true;
        } else {
            fqVar.f2311b = Integer.MIN_VALUE;
            fqVar.f2310a = this.f1840d;
            return true;
        }
    }

    int m3942c(int i, eo eoVar, ev evVar) {
        int L;
        int i2;
        m3869I();
        if (i > 0) {
            L = m3872L();
            i2 = 1;
        } else {
            i2 = -1;
            L = m3873M();
        }
        this.f1847k.f2129a = true;
        m3877a(L, evVar);
        m3899l(i2);
        this.f1847k.f2131c = this.f1847k.f2132d + L;
        int abs = Math.abs(i);
        this.f1847k.f2130b = abs;
        i2 = m3874a(eoVar, this.f1847k, evVar);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.f1837a.mo732a(-i);
        this.f1851o = this.f1839c;
        return i;
    }

    public int mo667c(ev evVar) {
        return m3875a(evVar);
    }

    public Parcelable mo668c() {
        if (this.f1853u != null) {
            return new fv(this.f1853u);
        }
        fv fvVar = new fv();
        fvVar.f2330h = this.f1848l;
        fvVar.f2331i = this.f1851o;
        fvVar.f2332j = this.f1852t;
        if (this.f1842f == null || this.f1842f.f2317a == null) {
            fvVar.f2327e = 0;
        } else {
            fvVar.f2328f = this.f1842f.f2317a;
            fvVar.f2327e = fvVar.f2328f.length;
            fvVar.f2329g = this.f1842f.f2318b;
        }
        if (m3731s() > 0) {
            m3869I();
            fvVar.f2323a = this.f1851o ? m3872L() : m3873M();
            fvVar.f2324b = m3957i();
            fvVar.f2325c = this.f1843g;
            fvVar.f2326d = new int[this.f1843g];
            for (int i = 0; i < this.f1843g; i++) {
                int b;
                if (this.f1851o) {
                    b = this.f1844h[i].m4740b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f1837a.mo736d();
                    }
                } else {
                    b = this.f1844h[i].m4734a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f1837a.mo734c();
                    }
                }
                fvVar.f2326d[i] = b;
            }
        } else {
            fvVar.f2323a = -1;
            fvVar.f2324b = -1;
            fvVar.f2325c = 0;
        }
        return fvVar;
    }

    public void mo670c(eo eoVar, ev evVar) {
        m3880a(eoVar, evVar, true);
    }

    public int mo671d(ev evVar) {
        return m3897h(evVar);
    }

    public void mo672d(int i) {
        if (!(this.f1853u == null || this.f1853u.f2323a == i)) {
            this.f1853u.m4730b();
        }
        this.f1840d = i;
        this.f1841e = Integer.MIN_VALUE;
        m3723m();
    }

    public boolean mo673d() {
        return this.f1845i == 0;
    }

    public int mo674e(ev evVar) {
        return m3897h(evVar);
    }

    void m3950e(int i) {
        this.f1846j = i / this.f1843g;
        this.f1854v = MeasureSpec.makeMeasureSpec(i, this.f1838b.mo741h());
    }

    public boolean mo675e() {
        return this.f1845i == 1;
    }

    public int mo676f(ev evVar) {
        return m3898i(evVar);
    }

    View m3953f() {
        int i;
        int s = m3731s() - 1;
        BitSet bitSet = new BitSet(this.f1843g);
        bitSet.set(0, this.f1843g, true);
        boolean z = (this.f1845i == 1 && m3956h()) ? true : true;
        if (this.f1839c) {
            i = -1;
        } else {
            i = s + 1;
            s = 0;
        }
        int i2 = s < i ? 1 : -1;
        int i3 = s;
        while (i3 != i) {
            View h = m3713h(i3);
            fr frVar = (fr) h.getLayoutParams();
            if (bitSet.get(frVar.f2315e.f2336d)) {
                if (m3887a(frVar.f2315e)) {
                    return h;
                }
                bitSet.clear(frVar.f2315e.f2336d);
            }
            if (!(frVar.f2316f || i3 + i2 == i)) {
                boolean z2;
                View h2 = m3713h(i3 + i2);
                int b;
                if (this.f1839c) {
                    s = this.f1837a.mo733b(h);
                    b = this.f1837a.mo733b(h2);
                    if (s < b) {
                        return h;
                    }
                    if (s == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    s = this.f1837a.mo731a(h);
                    b = this.f1837a.mo731a(h2);
                    if (s > b) {
                        return h;
                    }
                    if (s == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if ((frVar.f2315e.f2336d - ((fr) h2.getLayoutParams()).f2315e.f2336d < 0) != (z >= false)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public int mo677g(ev evVar) {
        return m3898i(evVar);
    }

    public void m3955g() {
        this.f1842f.m4716a();
        m3723m();
    }

    boolean m3956h() {
        return m3729q() == 1;
    }

    int m3957i() {
        View b = this.f1839c ? m3937b(true, true) : m3919a(true, true);
        return b == null ? -1 : m3694d(b);
    }

    public void mo695i(int i) {
        super.mo695i(i);
        for (int i2 = 0; i2 < this.f1843g; i2++) {
            this.f1844h[i2].m4746d(i);
        }
    }

    public void mo696j(int i) {
        super.mo696j(i);
        for (int i2 = 0; i2 < this.f1843g; i2++) {
            this.f1844h[i2].m4746d(i);
        }
    }

    public void mo697k(int i) {
        if (i == 0) {
            m3868H();
        }
    }

    boolean m3961k() {
        int b = this.f1844h[0].m4740b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1843g; i++) {
            if (this.f1844h[i].m4740b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean m3962l() {
        int a = this.f1844h[0].m4734a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1843g; i++) {
            if (this.f1844h[i].m4734a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }
}
