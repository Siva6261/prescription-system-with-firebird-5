package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.p016a.C0190g;
import android.support.v4.view.p016a.C0201r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f1783a = false;
    int f1784b = -1;
    int[] f1785c;
    View[] f1786d;
    final SparseIntArray f1787e = new SparseIntArray();
    final SparseIntArray f1788f = new SparseIntArray();
    co f1789g = new cm();
    final Rect f1790h = new Rect();

    public GridLayoutManager(Context context, int i) {
        super(context);
        m3826a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        m3826a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m3826a(eh.m3609a(context, attributeSet, i, i2).f2206b);
    }

    private void m3805H() {
        this.f1787e.clear();
        this.f1788f.clear();
    }

    private void m3806I() {
        int s = m3731s();
        for (int i = 0; i < s; i++) {
            cn cnVar = (cn) m3713h(i).getLayoutParams();
            int e = cnVar.m4360e();
            this.f1787e.put(e, cnVar.m4366b());
            this.f1788f.put(e, cnVar.m4365a());
        }
    }

    private void m3807J() {
        m3818l(m3796f() == 1 ? (m3734v() - m3738z()) - m3736x() : (m3735w() - m3619A()) - m3737y());
    }

    private void m3808K() {
        if (this.f1786d == null || this.f1786d.length != this.f1784b) {
            this.f1786d = new View[this.f1784b];
        }
    }

    private int m3809a(eo eoVar, ev evVar, int i) {
        if (!evVar.m4606a()) {
            return this.f1789g.m4355c(i, this.f1784b);
        }
        int b = eoVar.m4541b(i);
        if (b != -1) {
            return this.f1789g.m4355c(b, this.f1784b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void m3810a(float f, int i) {
        m3818l(Math.max(Math.round(((float) this.f1784b) * f), i));
    }

    private void m3811a(eo eoVar, ev evVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.i == 1 && m3799g()) {
            i5 = this.f1784b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.f1786d[i5];
            cn cnVar = (cn) view.getLayoutParams();
            cnVar.f2128f = m3817c(eoVar, evVar, m3694d(view));
            if (i6 != -1 || cnVar.f2128f <= 1) {
                cnVar.f2127e = i7;
            } else {
                cnVar.f2127e = i7 - (cnVar.f2128f - 1);
            }
            i7 += cnVar.f2128f * i6;
        }
    }

    private void m3812a(View view, int i, int i2, boolean z, boolean z2) {
        m3653a(view, this.f1790h);
        ej ejVar = (ej) view.getLayoutParams();
        if (z || this.i == 1) {
            i = m3814b(i, ejVar.leftMargin + this.f1790h.left, ejVar.rightMargin + this.f1790h.right);
        }
        if (z || this.i == 0) {
            i2 = m3814b(i2, ejVar.topMargin + this.f1790h.top, ejVar.bottomMargin + this.f1790h.bottom);
        }
        if (z2 ? m3666a(view, i, i2, ejVar) : m3680b(view, i, i2, ejVar)) {
            view.measure(i, i2);
        }
    }

    static int[] m3813a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    private int m3814b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int m3815b(eo eoVar, ev evVar, int i) {
        if (!evVar.m4606a()) {
            return this.f1789g.m4354b(i, this.f1784b);
        }
        int i2 = this.f1788f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = eoVar.m4541b(i);
        if (i2 != -1) {
            return this.f1789g.m4354b(i2, this.f1784b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void m3816b(eo eoVar, ev evVar, cs csVar, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m3815b(eoVar, evVar, csVar.f2140a);
        if (obj != null) {
            while (b > 0 && csVar.f2140a > 0) {
                csVar.f2140a--;
                b = m3815b(eoVar, evVar, csVar.f2140a);
            }
            return;
        }
        int e = evVar.m4610e() - 1;
        int i2 = csVar.f2140a;
        int i3 = b;
        while (i2 < e) {
            b = m3815b(eoVar, evVar, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        csVar.f2140a = i2;
    }

    private int m3817c(eo eoVar, ev evVar, int i) {
        if (!evVar.m4606a()) {
            return this.f1789g.mo724a(i);
        }
        int i2 = this.f1787e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = eoVar.m4541b(i);
        if (i2 != -1) {
            return this.f1789g.mo724a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void m3818l(int i) {
        this.f1785c = m3813a(this.f1785c, this.f1784b, i);
    }

    public int mo657a(int i, eo eoVar, ev evVar) {
        m3807J();
        m3808K();
        return super.mo657a(i, eoVar, evVar);
    }

    public int mo679a(eo eoVar, ev evVar) {
        return this.i == 0 ? this.f1784b : evVar.m4610e() < 1 ? 0 : m3809a(eoVar, evVar, evVar.m4610e() - 1) + 1;
    }

    public ej mo658a() {
        return this.i == 0 ? new cn(-2, -1) : new cn(-1, -2);
    }

    public ej mo680a(Context context, AttributeSet attributeSet) {
        return new cn(context, attributeSet);
    }

    public ej mo681a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new cn((MarginLayoutParams) layoutParams) : new cn(layoutParams);
    }

    View mo682a(eo eoVar, ev evVar, int i, int i2, int i3) {
        View view = null;
        m3800h();
        int c = this.j.mo734c();
        int d = this.j.mo736d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m3713h(i);
            int d2 = m3694d(h);
            if (d2 >= 0 && d2 < i3) {
                if (m3815b(eoVar, evVar, d2) != 0) {
                    view3 = view;
                    h = view2;
                } else if (((ej) h.getLayoutParams()).m4358c()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.mo731a(h) < d && this.j.mo733b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = h;
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
        View e = m3701e(view);
        if (e == null) {
            return null;
        }
        cn cnVar = (cn) e.getLayoutParams();
        int a = cnVar.f2127e;
        int a2 = cnVar.f2127e + cnVar.f2128f;
        if (super.mo659a(view, i, eoVar, evVar) == null) {
            return null;
        }
        int s;
        int i2;
        int i3;
        if (((m3793e(i) == 1) != this.k ? 1 : null) != null) {
            s = m3731s() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            s = 0;
            i2 = 1;
            i3 = m3731s();
        }
        Object obj = (this.i == 1 && m3799g()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = s;
        while (i6 != i3) {
            View h = m3713h(i6);
            if (h == e) {
                break;
            }
            View view3;
            if (h.isFocusable()) {
                cnVar = (cn) h.getLayoutParams();
                int a3 = cnVar.f2127e;
                int a4 = cnVar.f2127e + cnVar.f2128f;
                if (a3 == a && a4 == a2) {
                    return h;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = cnVar.f2127e;
                    s = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = h;
                } else {
                    s = i5;
                    i5 = i4;
                    view3 = view2;
                }
            } else {
                s = i5;
                i5 = i4;
                view3 = view2;
            }
            i6 += i2;
            view2 = view3;
            i4 = i5;
            i5 = s;
        }
        return view2;
    }

    public void m3826a(int i) {
        if (i != this.f1784b) {
            this.f1783a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f1784b = i;
            this.f1789g.m4352a();
        }
    }

    public void mo683a(Rect rect, int i, int i2) {
        if (this.f1785c == null) {
            super.mo683a(rect, i, i2);
        }
        int z = m3738z() + m3736x();
        int y = m3737y() + m3619A();
        if (this.i == 1) {
            y = eh.m3607a(i2, y + rect.height(), m3622D());
            z = eh.m3607a(i, z + this.f1785c[this.f1785c.length - 1], m3621C());
        } else {
            z = eh.m3607a(i, z + rect.width(), m3621C());
            y = eh.m3607a(i2, y + this.f1785c[this.f1785c.length - 1], m3622D());
        }
        m3697d(z, y);
    }

    public void mo684a(RecyclerView recyclerView) {
        this.f1789g.m4352a();
    }

    public void mo685a(RecyclerView recyclerView, int i, int i2) {
        this.f1789g.m4352a();
    }

    public void mo686a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f1789g.m4352a();
    }

    public void mo687a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f1789g.m4352a();
    }

    void mo688a(eo eoVar, ev evVar, cs csVar, int i) {
        super.mo688a(eoVar, evVar, csVar, i);
        m3807J();
        if (evVar.m4610e() > 0 && !evVar.m4606a()) {
            m3816b(eoVar, evVar, csVar, i);
        }
        m3808K();
    }

    void mo689a(eo eoVar, ev evVar, cu cuVar, ct ctVar) {
        int i = this.j.mo742i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = m3731s() > 0 ? this.f1785c[this.f1784b] : 0;
        if (obj != null) {
            m3807J();
        }
        boolean z = cuVar.f2152e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1784b;
        if (!z) {
            i5 = m3815b(eoVar, evVar, cuVar.f2151d) + m3817c(eoVar, evVar, cuVar.f2151d);
        }
        while (i3 < this.f1784b && cuVar.m4380a(evVar) && i5 > 0) {
            int i6 = cuVar.f2151d;
            int c = m3817c(eoVar, evVar, i6);
            if (c <= this.f1784b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = cuVar.m4377a(eoVar);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.f1786d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.f1784b + " spans.");
        }
        if (i3 == 0) {
            ctVar.f2145b = true;
            return;
        }
        View view;
        int a2;
        int a3;
        m3811a(eoVar, evVar, i3, i4, z);
        int i7 = 0;
        float f = 0.0f;
        c = 0;
        while (i7 < i3) {
            View view2 = this.f1786d[i7];
            if (cuVar.f2158k == null) {
                if (z) {
                    m3677b(view2);
                } else {
                    m3678b(view2, 0);
                }
            } else if (z) {
                m3648a(view2);
            } else {
                m3649a(view2, 0);
            }
            cn cnVar = (cn) view2.getLayoutParams();
            int a4 = eh.m3608a(this.f1785c[cnVar.f2127e + cnVar.f2128f] - this.f1785c[cnVar.f2127e], i, 0, this.i == 0 ? cnVar.height : cnVar.width, false);
            int a5 = eh.m3608a(this.j.mo739f(), this.j.mo741h(), 0, this.i == 1 ? cnVar.height : cnVar.width, true);
            if (this.i == 1) {
                m3812a(view2, a4, a5, cnVar.height == -1, false);
            } else {
                m3812a(view2, a5, a4, cnVar.width == -1, false);
            }
            i6 = this.j.mo735c(view2);
            if (i6 <= c) {
                i6 = c;
            }
            float d = (1.0f * ((float) this.j.mo737d(view2))) / ((float) cnVar.f2128f);
            if (d <= f) {
                d = f;
            }
            i7++;
            f = d;
            c = i6;
        }
        if (obj != null) {
            m3810a(f, i2);
            c = 0;
            int i8 = 0;
            while (i8 < i3) {
                view = this.f1786d[i8];
                cnVar = (cn) view.getLayoutParams();
                a2 = eh.m3608a(this.f1785c[cnVar.f2127e + cnVar.f2128f] - this.f1785c[cnVar.f2127e], 1073741824, 0, this.i == 0 ? cnVar.height : cnVar.width, false);
                a3 = eh.m3608a(this.j.mo739f(), this.j.mo741h(), 0, this.i == 1 ? cnVar.height : cnVar.width, true);
                if (this.i == 1) {
                    m3812a(view, a2, a3, false, true);
                } else {
                    m3812a(view, a3, a2, false, true);
                }
                i5 = this.j.mo735c(view);
                if (i5 <= c) {
                    i5 = c;
                }
                i8++;
                c = i5;
            }
        }
        a3 = MeasureSpec.makeMeasureSpec(c, 1073741824);
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f1786d[i6];
            if (this.j.mo735c(view) != c) {
                cnVar = (cn) view.getLayoutParams();
                a2 = eh.m3608a(this.f1785c[cnVar.f2127e + cnVar.f2128f] - this.f1785c[cnVar.f2127e], 1073741824, 0, this.i == 0 ? cnVar.height : cnVar.width, false);
                if (this.i == 1) {
                    m3812a(view, a2, a3, true, true);
                } else {
                    m3812a(view, a3, a2, true, true);
                }
            }
        }
        ctVar.f2144a = c;
        i6 = 0;
        i5 = 0;
        if (this.i == 1) {
            if (cuVar.f2153f == -1) {
                i5 = cuVar.f2149b;
                i6 = i5 - c;
                c = 0;
                i4 = 0;
            } else {
                i6 = cuVar.f2149b;
                i5 = i6 + c;
                c = 0;
                i4 = 0;
            }
        } else if (cuVar.f2153f == -1) {
            i4 = cuVar.f2149b;
            int i9 = i4;
            i4 -= c;
            c = i9;
        } else {
            i4 = cuVar.f2149b;
            c += i4;
        }
        int i10 = 0;
        a2 = i4;
        i4 = c;
        c = i6;
        i6 = i5;
        while (i10 < i3) {
            int i11;
            int i12;
            view = this.f1786d[i10];
            cnVar = (cn) view.getLayoutParams();
            if (this.i != 1) {
                c = this.f1785c[cnVar.f2127e] + m3737y();
                i6 = this.j.mo737d(view) + c;
                i11 = i4;
                i12 = a2;
            } else if (m3799g()) {
                i4 = m3736x() + this.f1785c[cnVar.f2127e + cnVar.f2128f];
                i11 = i4;
                i12 = i4 - this.j.mo737d(view);
            } else {
                a2 = this.f1785c[cnVar.f2127e] + m3736x();
                i11 = this.j.mo737d(view) + a2;
                i12 = a2;
            }
            m3651a(view, i12 + cnVar.leftMargin, c + cnVar.topMargin, i11 - cnVar.rightMargin, i6 - cnVar.bottomMargin);
            if (cnVar.m4358c() || cnVar.m4359d()) {
                ctVar.f2146c = true;
            }
            ctVar.f2147d |= view.isFocusable();
            i10++;
            i4 = i11;
            a2 = i12;
        }
        Arrays.fill(this.f1786d, null);
    }

    public void mo690a(eo eoVar, ev evVar, View view, C0190g c0190g) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof cn) {
            cn cnVar = (cn) layoutParams;
            int a = m3809a(eoVar, evVar, cnVar.m4360e());
            if (this.i == 0) {
                int a2 = cnVar.m4365a();
                int b = cnVar.m4366b();
                boolean z = this.f1784b > 1 && cnVar.m4366b() == this.f1784b;
                c0190g.m1701b(C0201r.m1795a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = cnVar.m4365a();
            int b2 = cnVar.m4366b();
            boolean z2 = this.f1784b > 1 && cnVar.m4366b() == this.f1784b;
            c0190g.m1701b(C0201r.m1795a(a, 1, a3, b2, z2, false));
            return;
        }
        super.m3654a(view, c0190g);
    }

    public void mo691a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo691a(false);
    }

    public boolean mo692a(ej ejVar) {
        return ejVar instanceof cn;
    }

    public int mo664b(int i, eo eoVar, ev evVar) {
        m3807J();
        m3808K();
        return super.mo664b(i, eoVar, evVar);
    }

    public int mo693b(eo eoVar, ev evVar) {
        return this.i == 1 ? this.f1784b : evVar.m4610e() < 1 ? 0 : m3809a(eoVar, evVar, evVar.m4610e() - 1) + 1;
    }

    public void mo694b(RecyclerView recyclerView, int i, int i2) {
        this.f1789g.m4352a();
    }

    public boolean mo666b() {
        return this.n == null && !this.f1783a;
    }

    public void mo670c(eo eoVar, ev evVar) {
        if (evVar.m4606a()) {
            m3806I();
        }
        super.mo670c(eoVar, evVar);
        m3805H();
        if (!evVar.m4606a()) {
            this.f1783a = false;
        }
    }
}
