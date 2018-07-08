package android.support.v7.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.p016a.C0183a;
import android.support.v4.view.p016a.aj;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends eh {
    private cu f1770a;
    private boolean f1771b;
    private boolean f1772c;
    private boolean f1773d;
    private boolean f1774e;
    private boolean f1775f;
    int f1776i;
    C0352do f1777j;
    boolean f1778k;
    int f1779l;
    int f1780m;
    cv f1781n;
    final cs f1782o;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f1772c = false;
        this.f1778k = false;
        this.f1773d = false;
        this.f1774e = true;
        this.f1779l = -1;
        this.f1780m = Integer.MIN_VALUE;
        this.f1781n = null;
        this.f1782o = new cs(this);
        m3782b(i);
        m3783b(z);
        m3691c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1772c = false;
        this.f1778k = false;
        this.f1773d = false;
        this.f1774e = true;
        this.f1779l = -1;
        this.f1780m = Integer.MIN_VALUE;
        this.f1781n = null;
        this.f1782o = new cs(this);
        ei a = eh.m3609a(context, attributeSet, i, i2);
        m3782b(a.f2205a);
        m3783b(a.f2207c);
        mo691a(a.f2208d);
        m3691c(true);
    }

    private void m3739H() {
        boolean z = true;
        if (this.f1776i == 1 || !m3799g()) {
            this.f1778k = this.f1772c;
            return;
        }
        if (this.f1772c) {
            z = false;
        }
        this.f1778k = z;
    }

    private View m3740I() {
        return m3713h(this.f1778k ? m3731s() - 1 : 0);
    }

    private View m3741J() {
        return m3713h(this.f1778k ? 0 : m3731s() - 1);
    }

    private int m3742a(int i, eo eoVar, ev evVar, boolean z) {
        int d = this.f1777j.mo736d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -m3785c(-d, eoVar, evVar);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.f1777j.mo736d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.f1777j.mo732a(i2);
        return d + i2;
    }

    private View m3743a(boolean z, boolean z2) {
        return this.f1778k ? m3770a(m3731s() - 1, -1, z, z2) : m3770a(0, m3731s(), z, z2);
    }

    private void m3744a(int i, int i2, boolean z, ev evVar) {
        int b;
        int i3 = 1;
        this.f1770a.f2159l = this.f1777j.mo741h() == 0;
        this.f1770a.f2155h = m3768a(evVar);
        this.f1770a.f2153f = i;
        View J;
        cu cuVar;
        if (i == 1) {
            cu cuVar2 = this.f1770a;
            cuVar2.f2155h += this.f1777j.mo740g();
            J = m3741J();
            cuVar = this.f1770a;
            if (this.f1778k) {
                i3 = -1;
            }
            cuVar.f2152e = i3;
            this.f1770a.f2151d = m3694d(J) + this.f1770a.f2152e;
            this.f1770a.f2149b = this.f1777j.mo733b(J);
            b = this.f1777j.mo733b(J) - this.f1777j.mo736d();
        } else {
            J = m3740I();
            cuVar = this.f1770a;
            cuVar.f2155h += this.f1777j.mo734c();
            cuVar = this.f1770a;
            if (!this.f1778k) {
                i3 = -1;
            }
            cuVar.f2152e = i3;
            this.f1770a.f2151d = m3694d(J) + this.f1770a.f2152e;
            this.f1770a.f2149b = this.f1777j.mo731a(J);
            b = (-this.f1777j.mo731a(J)) + this.f1777j.mo734c();
        }
        this.f1770a.f2150c = i2;
        if (z) {
            cu cuVar3 = this.f1770a;
            cuVar3.f2150c -= b;
        }
        this.f1770a.f2154g = b;
    }

    private void m3745a(cs csVar) {
        m3757e(csVar.f2140a, csVar.f2141b);
    }

    private void m3746a(eo eoVar, int i) {
        if (i >= 0) {
            int s = m3731s();
            int i2;
            if (this.f1778k) {
                for (i2 = s - 1; i2 >= 0; i2--) {
                    if (this.f1777j.mo733b(m3713h(i2)) > i) {
                        m3747a(eoVar, s - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < s; i2++) {
                if (this.f1777j.mo733b(m3713h(i2)) > i) {
                    m3747a(eoVar, 0, i2);
                    return;
                }
            }
        }
    }

    private void m3747a(eo eoVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    m3633a(i3, eoVar);
                }
                return;
            }
            while (i > i2) {
                m3633a(i, eoVar);
                i--;
            }
        }
    }

    private void m3748a(eo eoVar, cu cuVar) {
        if (cuVar.f2148a && !cuVar.f2159l) {
            if (cuVar.f2153f == -1) {
                m3754b(eoVar, cuVar.f2154g);
            } else {
                m3746a(eoVar, cuVar.f2154g);
            }
        }
    }

    private void m3749a(eo eoVar, ev evVar, cs csVar) {
        if (!m3750a(evVar, csVar) && !m3756b(eoVar, evVar, csVar)) {
            csVar.m4373b();
            csVar.f2140a = this.f1773d ? evVar.m4610e() - 1 : 0;
        }
    }

    private boolean m3750a(ev evVar, cs csVar) {
        boolean z = false;
        if (evVar.m4606a() || this.f1779l == -1) {
            return false;
        }
        if (this.f1779l < 0 || this.f1779l >= evVar.m4610e()) {
            this.f1779l = -1;
            this.f1780m = Integer.MIN_VALUE;
            return false;
        }
        csVar.f2140a = this.f1779l;
        if (this.f1781n != null && this.f1781n.m4382a()) {
            csVar.f2142c = this.f1781n.f2162c;
            if (csVar.f2142c) {
                csVar.f2141b = this.f1777j.mo736d() - this.f1781n.f2161b;
                return true;
            }
            csVar.f2141b = this.f1777j.mo734c() + this.f1781n.f2161b;
            return true;
        } else if (this.f1780m == Integer.MIN_VALUE) {
            View c = mo669c(this.f1779l);
            if (c == null) {
                if (m3731s() > 0) {
                    if ((this.f1779l < m3694d(m3713h(0))) == this.f1778k) {
                        z = true;
                    }
                    csVar.f2142c = z;
                }
                csVar.m4373b();
                return true;
            } else if (this.f1777j.mo735c(c) > this.f1777j.mo739f()) {
                csVar.m4373b();
                return true;
            } else if (this.f1777j.mo731a(c) - this.f1777j.mo734c() < 0) {
                csVar.f2141b = this.f1777j.mo734c();
                csVar.f2142c = false;
                return true;
            } else if (this.f1777j.mo736d() - this.f1777j.mo733b(c) < 0) {
                csVar.f2141b = this.f1777j.mo736d();
                csVar.f2142c = true;
                return true;
            } else {
                csVar.f2141b = csVar.f2142c ? this.f1777j.mo733b(c) + this.f1777j.m4414b() : this.f1777j.mo731a(c);
                return true;
            }
        } else {
            csVar.f2142c = this.f1778k;
            if (this.f1778k) {
                csVar.f2141b = this.f1777j.mo736d() - this.f1780m;
                return true;
            }
            csVar.f2141b = this.f1777j.mo734c() + this.f1780m;
            return true;
        }
    }

    private int m3751b(int i, eo eoVar, ev evVar, boolean z) {
        int c = i - this.f1777j.mo734c();
        if (c <= 0) {
            return 0;
        }
        c = -m3785c(c, eoVar, evVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.f1777j.mo734c();
        if (i2 <= 0) {
            return c;
        }
        this.f1777j.mo732a(-i2);
        return c - i2;
    }

    private View m3752b(boolean z, boolean z2) {
        return this.f1778k ? m3770a(0, m3731s(), z, z2) : m3770a(m3731s() - 1, -1, z, z2);
    }

    private void m3753b(cs csVar) {
        m3759f(csVar.f2140a, csVar.f2141b);
    }

    private void m3754b(eo eoVar, int i) {
        int s = m3731s();
        if (i >= 0) {
            int e = this.f1777j.mo738e() - i;
            int i2;
            if (this.f1778k) {
                for (i2 = 0; i2 < s; i2++) {
                    if (this.f1777j.mo731a(m3713h(i2)) < e) {
                        m3747a(eoVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = s - 1; i2 >= 0; i2--) {
                if (this.f1777j.mo731a(m3713h(i2)) < e) {
                    m3747a(eoVar, s - 1, i2);
                    return;
                }
            }
        }
    }

    private void m3755b(eo eoVar, ev evVar, int i, int i2) {
        if (evVar.m4607b() && m3731s() != 0 && !evVar.m4606a() && mo666b()) {
            int i3 = 0;
            int i4 = 0;
            List b = eoVar.m4542b();
            int size = b.size();
            int d = m3694d(m3713h(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                ey eyVar = (ey) b.get(i5);
                if (eyVar.m4660q()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((eyVar.m4647d() < d) != this.f1778k ? -1 : 1) == -1) {
                        i7 = this.f1777j.mo735c(eyVar.f2256a) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.f1777j.mo735c(eyVar.f2256a) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.f1770a.f2158k = b;
            if (i3 > 0) {
                m3759f(m3694d(m3740I()), i);
                this.f1770a.f2155h = i3;
                this.f1770a.f2150c = 0;
                this.f1770a.m4378a();
                m3767a(eoVar, this.f1770a, evVar, false);
            }
            if (i4 > 0) {
                m3757e(m3694d(m3741J()), i2);
                this.f1770a.f2155h = i4;
                this.f1770a.f2150c = 0;
                this.f1770a.m4378a();
                m3767a(eoVar, this.f1770a, evVar, false);
            }
            this.f1770a.f2158k = null;
        }
    }

    private boolean m3756b(eo eoVar, ev evVar, cs csVar) {
        boolean z = false;
        if (m3731s() == 0) {
            return false;
        }
        View B = m3620B();
        if (B != null && csVar.m4370a(B, evVar)) {
            csVar.m4372a(B);
            return true;
        } else if (this.f1771b != this.f1773d) {
            return false;
        } else {
            B = csVar.f2142c ? m3758f(eoVar, evVar) : m3760g(eoVar, evVar);
            if (B == null) {
                return false;
            }
            csVar.m4374b(B);
            if (!evVar.m4606a() && mo666b()) {
                if (this.f1777j.mo731a(B) >= this.f1777j.mo736d() || this.f1777j.mo733b(B) < this.f1777j.mo734c()) {
                    z = true;
                }
                if (z) {
                    csVar.f2141b = csVar.f2142c ? this.f1777j.mo736d() : this.f1777j.mo734c();
                }
            }
            return true;
        }
    }

    private void m3757e(int i, int i2) {
        this.f1770a.f2150c = this.f1777j.mo736d() - i2;
        this.f1770a.f2152e = this.f1778k ? -1 : 1;
        this.f1770a.f2151d = i;
        this.f1770a.f2153f = 1;
        this.f1770a.f2149b = i2;
        this.f1770a.f2154g = Integer.MIN_VALUE;
    }

    private View m3758f(eo eoVar, ev evVar) {
        return this.f1778k ? m3762h(eoVar, evVar) : m3764i(eoVar, evVar);
    }

    private void m3759f(int i, int i2) {
        this.f1770a.f2150c = i2 - this.f1777j.mo734c();
        this.f1770a.f2151d = i;
        this.f1770a.f2152e = this.f1778k ? 1 : -1;
        this.f1770a.f2153f = -1;
        this.f1770a.f2149b = i2;
        this.f1770a.f2154g = Integer.MIN_VALUE;
    }

    private View m3760g(eo eoVar, ev evVar) {
        return this.f1778k ? m3764i(eoVar, evVar) : m3762h(eoVar, evVar);
    }

    private int m3761h(ev evVar) {
        boolean z = false;
        if (m3731s() == 0) {
            return 0;
        }
        m3800h();
        C0352do c0352do = this.f1777j;
        View a = m3743a(!this.f1774e, true);
        if (!this.f1774e) {
            z = true;
        }
        return fc.m4686a(evVar, c0352do, a, m3752b(z, true), this, this.f1774e, this.f1778k);
    }

    private View m3762h(eo eoVar, ev evVar) {
        return mo682a(eoVar, evVar, 0, m3731s(), evVar.m4610e());
    }

    private int m3763i(ev evVar) {
        boolean z = false;
        if (m3731s() == 0) {
            return 0;
        }
        m3800h();
        C0352do c0352do = this.f1777j;
        View a = m3743a(!this.f1774e, true);
        if (!this.f1774e) {
            z = true;
        }
        return fc.m4685a(evVar, c0352do, a, m3752b(z, true), this, this.f1774e);
    }

    private View m3764i(eo eoVar, ev evVar) {
        return mo682a(eoVar, evVar, m3731s() - 1, -1, evVar.m4610e());
    }

    private int m3765j(ev evVar) {
        boolean z = false;
        if (m3731s() == 0) {
            return 0;
        }
        m3800h();
        C0352do c0352do = this.f1777j;
        View a = m3743a(!this.f1774e, true);
        if (!this.f1774e) {
            z = true;
        }
        return fc.m4687b(evVar, c0352do, a, m3752b(z, true), this, this.f1774e);
    }

    public int mo657a(int i, eo eoVar, ev evVar) {
        return this.f1776i == 1 ? 0 : m3785c(i, eoVar, evVar);
    }

    int m3767a(eo eoVar, cu cuVar, ev evVar, boolean z) {
        int i = cuVar.f2150c;
        if (cuVar.f2154g != Integer.MIN_VALUE) {
            if (cuVar.f2150c < 0) {
                cuVar.f2154g += cuVar.f2150c;
            }
            m3748a(eoVar, cuVar);
        }
        int i2 = cuVar.f2150c + cuVar.f2155h;
        ct ctVar = new ct();
        while (true) {
            if ((!cuVar.f2159l && i2 <= 0) || !cuVar.m4380a(evVar)) {
                break;
            }
            ctVar.m4375a();
            mo689a(eoVar, evVar, cuVar, ctVar);
            if (!ctVar.f2145b) {
                cuVar.f2149b += ctVar.f2144a * cuVar.f2153f;
                if (!(ctVar.f2146c && this.f1770a.f2158k == null && evVar.m4606a())) {
                    cuVar.f2150c -= ctVar.f2144a;
                    i2 -= ctVar.f2144a;
                }
                if (cuVar.f2154g != Integer.MIN_VALUE) {
                    cuVar.f2154g += ctVar.f2144a;
                    if (cuVar.f2150c < 0) {
                        cuVar.f2154g += cuVar.f2150c;
                    }
                    m3748a(eoVar, cuVar);
                }
                if (z && ctVar.f2147d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cuVar.f2150c;
    }

    protected int m3768a(ev evVar) {
        return evVar.m4609d() ? this.f1777j.mo739f() : 0;
    }

    public ej mo658a() {
        return new ej(-2, -2);
    }

    View m3770a(int i, int i2, boolean z, boolean z2) {
        m3800h();
        int c = this.f1777j.mo734c();
        int d = this.f1777j.mo736d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View h = m3713h(i);
            int a = this.f1777j.mo731a(h);
            int b = this.f1777j.mo733b(h);
            if (a < d && b > c) {
                if (!z) {
                    return h;
                }
                if (a >= c && b <= d) {
                    return h;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = h;
                }
            }
            h = view;
            i += i3;
            view = h;
        }
        return view;
    }

    View mo682a(eo eoVar, ev evVar, int i, int i2, int i3) {
        View view = null;
        m3800h();
        int c = this.f1777j.mo734c();
        int d = this.f1777j.mo736d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m3713h(i);
            int d2 = m3694d(h);
            if (d2 >= 0 && d2 < i3) {
                if (((ej) h.getLayoutParams()).m4358c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                } else if (this.f1777j.mo731a(h) < d && this.f1777j.mo733b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                }
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public View mo659a(View view, int i, eo eoVar, ev evVar) {
        m3739H();
        if (m3731s() == 0) {
            return null;
        }
        int e = m3793e(i);
        if (e == Integer.MIN_VALUE) {
            return null;
        }
        m3800h();
        View g = e == -1 ? m3760g(eoVar, evVar) : m3758f(eoVar, evVar);
        if (g == null) {
            return null;
        }
        m3800h();
        m3744a(e, (int) (0.33333334f * ((float) this.f1777j.mo739f())), false, evVar);
        this.f1770a.f2154g = Integer.MIN_VALUE;
        this.f1770a.f2148a = false;
        m3767a(eoVar, this.f1770a, evVar, true);
        View I = e == -1 ? m3740I() : m3741J();
        return (I == g || !I.isFocusable()) ? null : I;
    }

    public void mo660a(Parcelable parcelable) {
        if (parcelable instanceof cv) {
            this.f1781n = (cv) parcelable;
            m3723m();
        }
    }

    public void mo661a(RecyclerView recyclerView, eo eoVar) {
        super.mo661a(recyclerView, eoVar);
        if (this.f1775f) {
            m3687c(eoVar);
            eoVar.m4533a();
        }
    }

    void mo688a(eo eoVar, ev evVar, cs csVar, int i) {
    }

    void mo689a(eo eoVar, ev evVar, cu cuVar, ct ctVar) {
        View a = cuVar.m4377a(eoVar);
        if (a == null) {
            ctVar.f2145b = true;
            return;
        }
        int v;
        int d;
        int i;
        int i2;
        ej ejVar = (ej) a.getLayoutParams();
        if (cuVar.f2158k == null) {
            if (this.f1778k == (cuVar.f2153f == -1)) {
                m3677b(a);
            } else {
                m3678b(a, 0);
            }
        } else {
            if (this.f1778k == (cuVar.f2153f == -1)) {
                m3648a(a);
            } else {
                m3649a(a, 0);
            }
        }
        m3650a(a, 0, 0);
        ctVar.f2144a = this.f1777j.mo735c(a);
        if (this.f1776i == 1) {
            if (m3799g()) {
                v = m3734v() - m3738z();
                d = v - this.f1777j.mo737d(a);
            } else {
                d = m3736x();
                v = this.f1777j.mo737d(a) + d;
            }
            if (cuVar.f2153f == -1) {
                i = cuVar.f2149b - ctVar.f2144a;
                i2 = v;
                v = cuVar.f2149b;
            } else {
                i = cuVar.f2149b;
                i2 = v;
                v = cuVar.f2149b + ctVar.f2144a;
            }
        } else {
            i = m3737y();
            v = this.f1777j.mo737d(a) + i;
            if (cuVar.f2153f == -1) {
                d = cuVar.f2149b - ctVar.f2144a;
                i2 = cuVar.f2149b;
            } else {
                d = cuVar.f2149b;
                i2 = cuVar.f2149b + ctVar.f2144a;
            }
        }
        m3651a(a, d + ejVar.leftMargin, i + ejVar.topMargin, i2 - ejVar.rightMargin, v - ejVar.bottomMargin);
        if (ejVar.m4358c() || ejVar.m4359d()) {
            ctVar.f2146c = true;
        }
        ctVar.f2147d = a.isFocusable();
    }

    public void mo662a(AccessibilityEvent accessibilityEvent) {
        super.mo662a(accessibilityEvent);
        if (m3731s() > 0) {
            aj a = C0183a.m1624a(accessibilityEvent);
            a.m1645b(m3803k());
            a.m1646c(m3804l());
        }
    }

    public void mo663a(String str) {
        if (this.f1781n == null) {
            super.mo663a(str);
        }
    }

    public void mo691a(boolean z) {
        mo663a(null);
        if (this.f1773d != z) {
            this.f1773d = z;
            m3723m();
        }
    }

    public int mo664b(int i, eo eoVar, ev evVar) {
        return this.f1776i == 0 ? 0 : m3785c(i, eoVar, evVar);
    }

    public int mo665b(ev evVar) {
        return m3761h(evVar);
    }

    public void m3782b(int i) {
        if (i == 0 || i == 1) {
            mo663a(null);
            if (i != this.f1776i) {
                this.f1776i = i;
                this.f1777j = null;
                m3723m();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void m3783b(boolean z) {
        mo663a(null);
        if (z != this.f1772c) {
            this.f1772c = z;
            m3723m();
        }
    }

    public boolean mo666b() {
        return this.f1781n == null && this.f1771b == this.f1773d;
    }

    int m3785c(int i, eo eoVar, ev evVar) {
        if (m3731s() == 0 || i == 0) {
            return 0;
        }
        this.f1770a.f2148a = true;
        m3800h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m3744a(i2, abs, true, evVar);
        int a = this.f1770a.f2154g + m3767a(eoVar, this.f1770a, evVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f1777j.mo732a(-i);
        this.f1770a.f2157j = i;
        return i;
    }

    public int mo667c(ev evVar) {
        return m3761h(evVar);
    }

    public Parcelable mo668c() {
        if (this.f1781n != null) {
            return new cv(this.f1781n);
        }
        Parcelable cvVar = new cv();
        if (m3731s() > 0) {
            m3800h();
            boolean z = this.f1771b ^ this.f1778k;
            cvVar.f2162c = z;
            View J;
            if (z) {
                J = m3741J();
                cvVar.f2161b = this.f1777j.mo736d() - this.f1777j.mo733b(J);
                cvVar.f2160a = m3694d(J);
                return cvVar;
            }
            J = m3740I();
            cvVar.f2160a = m3694d(J);
            cvVar.f2161b = this.f1777j.mo731a(J) - this.f1777j.mo734c();
            return cvVar;
        }
        cvVar.m4383b();
        return cvVar;
    }

    public View mo669c(int i) {
        int s = m3731s();
        if (s == 0) {
            return null;
        }
        int d = i - m3694d(m3713h(0));
        if (d >= 0 && d < s) {
            View h = m3713h(d);
            if (m3694d(h) == i) {
                return h;
            }
        }
        return super.mo669c(i);
    }

    public void mo670c(eo eoVar, ev evVar) {
        if (!(this.f1781n == null && this.f1779l == -1) && evVar.m4610e() == 0) {
            m3687c(eoVar);
            return;
        }
        int i;
        int d;
        if (this.f1781n != null && this.f1781n.m4382a()) {
            this.f1779l = this.f1781n.f2160a;
        }
        m3800h();
        this.f1770a.f2148a = false;
        m3739H();
        this.f1782o.m4371a();
        this.f1782o.f2142c = this.f1778k ^ this.f1773d;
        m3749a(eoVar, evVar, this.f1782o);
        int a = m3768a(evVar);
        if (this.f1770a.f2157j >= 0) {
            i = 0;
        } else {
            i = a;
            a = 0;
        }
        i += this.f1777j.mo734c();
        a += this.f1777j.mo740g();
        if (!(!evVar.m4606a() || this.f1779l == -1 || this.f1780m == Integer.MIN_VALUE)) {
            View c = mo669c(this.f1779l);
            if (c != null) {
                d = this.f1778k ? (this.f1777j.mo736d() - this.f1777j.mo733b(c)) - this.f1780m : this.f1780m - (this.f1777j.mo731a(c) - this.f1777j.mo734c());
                if (d > 0) {
                    i += d;
                } else {
                    a -= d;
                }
            }
        }
        d = this.f1782o.f2142c ? this.f1778k ? 1 : -1 : this.f1778k ? -1 : 1;
        mo688a(eoVar, evVar, this.f1782o, d);
        m3643a(eoVar);
        this.f1770a.f2159l = this.f1777j.mo741h() == 0;
        this.f1770a.f2156i = evVar.m4606a();
        int i2;
        if (this.f1782o.f2142c) {
            m3753b(this.f1782o);
            this.f1770a.f2155h = i;
            m3767a(eoVar, this.f1770a, evVar, false);
            i = this.f1770a.f2149b;
            i2 = this.f1770a.f2151d;
            if (this.f1770a.f2150c > 0) {
                a += this.f1770a.f2150c;
            }
            m3745a(this.f1782o);
            this.f1770a.f2155h = a;
            cu cuVar = this.f1770a;
            cuVar.f2151d += this.f1770a.f2152e;
            m3767a(eoVar, this.f1770a, evVar, false);
            d = this.f1770a.f2149b;
            if (this.f1770a.f2150c > 0) {
                a = this.f1770a.f2150c;
                m3759f(i2, i);
                this.f1770a.f2155h = a;
                m3767a(eoVar, this.f1770a, evVar, false);
                a = this.f1770a.f2149b;
            } else {
                a = i;
            }
            i = a;
            a = d;
        } else {
            m3745a(this.f1782o);
            this.f1770a.f2155h = a;
            m3767a(eoVar, this.f1770a, evVar, false);
            a = this.f1770a.f2149b;
            d = this.f1770a.f2151d;
            if (this.f1770a.f2150c > 0) {
                i += this.f1770a.f2150c;
            }
            m3753b(this.f1782o);
            this.f1770a.f2155h = i;
            cu cuVar2 = this.f1770a;
            cuVar2.f2151d += this.f1770a.f2152e;
            m3767a(eoVar, this.f1770a, evVar, false);
            i = this.f1770a.f2149b;
            if (this.f1770a.f2150c > 0) {
                i2 = this.f1770a.f2150c;
                m3757e(d, a);
                this.f1770a.f2155h = i2;
                m3767a(eoVar, this.f1770a, evVar, false);
                a = this.f1770a.f2149b;
            }
        }
        if (m3731s() > 0) {
            int b;
            if ((this.f1778k ^ this.f1773d) != 0) {
                d = m3742a(a, eoVar, evVar, true);
                i += d;
                a += d;
                b = m3751b(i, eoVar, evVar, false);
                i += b;
                a += b;
            } else {
                d = m3751b(i, eoVar, evVar, true);
                i += d;
                a += d;
                b = m3742a(a, eoVar, evVar, false);
                i += b;
                a += b;
            }
        }
        m3755b(eoVar, evVar, i, a);
        if (!evVar.m4606a()) {
            this.f1779l = -1;
            this.f1780m = Integer.MIN_VALUE;
            this.f1777j.m4412a();
        }
        this.f1771b = this.f1773d;
        this.f1781n = null;
    }

    public int mo671d(ev evVar) {
        return m3763i(evVar);
    }

    public void mo672d(int i) {
        this.f1779l = i;
        this.f1780m = Integer.MIN_VALUE;
        if (this.f1781n != null) {
            this.f1781n.m4383b();
        }
        m3723m();
    }

    public boolean mo673d() {
        return this.f1776i == 0;
    }

    int m3793e(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                return this.f1776i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f1776i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.f1776i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f1776i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int mo674e(ev evVar) {
        return m3763i(evVar);
    }

    public boolean mo675e() {
        return this.f1776i == 1;
    }

    public int m3796f() {
        return this.f1776i;
    }

    public int mo676f(ev evVar) {
        return m3765j(evVar);
    }

    public int mo677g(ev evVar) {
        return m3765j(evVar);
    }

    protected boolean m3799g() {
        return m3729q() == 1;
    }

    void m3800h() {
        if (this.f1770a == null) {
            this.f1770a = m3801i();
        }
        if (this.f1777j == null) {
            this.f1777j = C0352do.m4409a(this, this.f1776i);
        }
    }

    cu m3801i() {
        return new cu();
    }

    boolean mo678j() {
        return (m3733u() == 1073741824 || m3732t() == 1073741824 || !m3625G()) ? false : true;
    }

    public int m3803k() {
        View a = m3770a(0, m3731s(), false, true);
        return a == null ? -1 : m3694d(a);
    }

    public int m3804l() {
        View a = m3770a(m3731s() - 1, -1, false, true);
        return a == null ? -1 : m3694d(a);
    }
}
