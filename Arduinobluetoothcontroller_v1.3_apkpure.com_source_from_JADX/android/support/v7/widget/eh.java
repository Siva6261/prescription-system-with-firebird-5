package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.bv;
import android.support.v4.view.p016a.C0183a;
import android.support.v4.view.p016a.C0190g;
import android.support.v4.view.p016a.C0200q;
import android.support.v4.view.p016a.C0201r;
import android.support.v4.view.p016a.aj;
import android.support.v7.p019d.C0310b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class eh {
    private boolean f1761a = false;
    private boolean f1762b = false;
    private boolean f1763c = true;
    private int f1764d;
    private int f1765e;
    br f1766p;
    RecyclerView f1767q;
    et f1768r;
    boolean f1769s = false;

    public static int m3607a(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(size, Math.max(i2, i3));
            case 1073741824:
                return size;
            default:
                return Math.max(i2, i3);
        }
    }

    public static int m3608a(int i, int i2, int i3, int i4, boolean z) {
        int i5 = 0;
        int max = Math.max(0, i - i3);
        if (z) {
            if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                switch (i2) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i5 = max;
                        break;
                    case 0:
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                max = i5;
                i5 = i2;
            } else {
                if (i4 == -2) {
                    max = 0;
                }
                max = 0;
            }
        } else if (i4 >= 0) {
            i5 = 1073741824;
            max = i4;
        } else if (i4 == -1) {
            i5 = i2;
        } else {
            if (i4 == -2) {
                if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                    i5 = Integer.MIN_VALUE;
                }
            }
            max = 0;
        }
        return MeasureSpec.makeMeasureSpec(max, i5);
    }

    public static ei m3609a(Context context, AttributeSet attributeSet, int i, int i2) {
        ei eiVar = new ei();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0310b.RecyclerView, i, i2);
        eiVar.f2205a = obtainStyledAttributes.getInt(C0310b.RecyclerView_android_orientation, 1);
        eiVar.f2206b = obtainStyledAttributes.getInt(C0310b.RecyclerView_spanCount, 1);
        eiVar.f2207c = obtainStyledAttributes.getBoolean(C0310b.RecyclerView_reverseLayout, false);
        eiVar.f2208d = obtainStyledAttributes.getBoolean(C0310b.RecyclerView_stackFromEnd, false);
        obtainStyledAttributes.recycle();
        return eiVar;
    }

    private void m3610a(int i, View view) {
        this.f1766p.m4199d(i);
    }

    private void m3612a(eo eoVar, int i, View view) {
        ey c = RecyclerView.m139c(view);
        if (!c.m4646c()) {
            if (!c.m4657n() || c.m4660q() || this.f1767q.f156q.m4490b()) {
                m3711g(i);
                eoVar.m4551c(view);
                this.f1767q.f145d.m4884h(c);
                return;
            }
            m3707f(i);
            eoVar.m4545b(c);
        }
    }

    private void m3613a(et etVar) {
        if (this.f1768r == etVar) {
            this.f1768r = null;
        }
    }

    private void m3614a(View view, int i, boolean z) {
        ey c = RecyclerView.m139c(view);
        if (z || c.m4660q()) {
            this.f1767q.f145d.m4881e(c);
        } else {
            this.f1767q.f145d.m4882f(c);
        }
        ej ejVar = (ej) view.getLayoutParams();
        if (c.m4654k() || c.m4652i()) {
            if (c.m4652i()) {
                c.m4653j();
            } else {
                c.m4655l();
            }
            this.f1766p.m4190a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.f1767q) {
            int b = this.f1766p.m4194b(view);
            if (i == -1) {
                i = this.f1766p.m4193b();
            }
            if (b == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1767q.indexOfChild(view));
            } else if (b != i) {
                this.f1767q.f146e.m3684c(b, i);
            }
        } else {
            this.f1766p.m4191a(view, i, false);
            ejVar.f2125c = true;
            if (this.f1768r != null && this.f1768r.m4581c()) {
                this.f1768r.m4579b(view);
            }
        }
        if (ejVar.f2126d) {
            c.f2256a.invalidate();
            ejVar.f2126d = false;
        }
    }

    private static boolean m3617b(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                return size >= i;
            case 0:
                return true;
            case 1073741824:
                return size == i;
            default:
                return false;
        }
    }

    public int m3619A() {
        return this.f1767q != null ? this.f1767q.getPaddingBottom() : 0;
    }

    public View m3620B() {
        if (this.f1767q == null) {
            return null;
        }
        View focusedChild = this.f1767q.getFocusedChild();
        return (focusedChild == null || this.f1766p.m4198c(focusedChild)) ? null : focusedChild;
    }

    public int m3621C() {
        return bv.m2038o(this.f1767q);
    }

    public int m3622D() {
        return bv.m2039p(this.f1767q);
    }

    void m3623E() {
        if (this.f1768r != null) {
            this.f1768r.m4575a();
        }
    }

    public void m3624F() {
        this.f1761a = true;
    }

    boolean m3625G() {
        int s = m3731s();
        for (int i = 0; i < s; i++) {
            LayoutParams layoutParams = m3713h(i).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    public int mo657a(int i, eo eoVar, ev evVar) {
        return 0;
    }

    public int mo679a(eo eoVar, ev evVar) {
        return (this.f1767q == null || this.f1767q.f156q == null || !mo675e()) ? 1 : this.f1767q.f156q.mo826a();
    }

    public abstract ej mo658a();

    public ej mo680a(Context context, AttributeSet attributeSet) {
        return new ej(context, attributeSet);
    }

    public ej mo681a(LayoutParams layoutParams) {
        return layoutParams instanceof ej ? new ej((ej) layoutParams) : layoutParams instanceof MarginLayoutParams ? new ej((MarginLayoutParams) layoutParams) : new ej(layoutParams);
    }

    public View mo659a(View view, int i, eo eoVar, ev evVar) {
        return null;
    }

    void m3632a(int i, int i2) {
        this.f1764d = i;
        this.f1765e = i2;
    }

    public void m3633a(int i, eo eoVar) {
        View h = m3713h(i);
        m3707f(i);
        eoVar.m4539a(h);
    }

    public void mo683a(Rect rect, int i, int i2) {
        m3697d(m3607a(i, (rect.width() + m3736x()) + m3738z(), m3621C()), m3607a(i2, (rect.height() + m3737y()) + m3619A(), m3622D()));
    }

    public void mo660a(Parcelable parcelable) {
    }

    void m3636a(C0190g c0190g) {
        m3645a(this.f1767q.f142a, this.f1767q.f148g, c0190g);
    }

    public void mo684a(RecyclerView recyclerView) {
    }

    public void mo685a(RecyclerView recyclerView, int i, int i2) {
    }

    public void mo686a(RecyclerView recyclerView, int i, int i2, int i3) {
    }

    public void mo687a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m3686c(recyclerView, i, i2);
    }

    public void mo661a(RecyclerView recyclerView, eo eoVar) {
        m3702e(recyclerView);
    }

    public void m3642a(dx dxVar, dx dxVar2) {
    }

    public void m3643a(eo eoVar) {
        for (int s = m3731s() - 1; s >= 0; s--) {
            m3612a(eoVar, s, m3713h(s));
        }
    }

    public void m3644a(eo eoVar, ev evVar, int i, int i2) {
        this.f1767q.m203d(i, i2);
    }

    public void m3645a(eo eoVar, ev evVar, C0190g c0190g) {
        if (bv.m2018b(this.f1767q, -1) || bv.m2013a(this.f1767q, -1)) {
            c0190g.m1694a(8192);
            c0190g.m1698a(true);
        }
        if (bv.m2018b(this.f1767q, 1) || bv.m2013a(this.f1767q, 1)) {
            c0190g.m1694a(4096);
            c0190g.m1698a(true);
        }
        c0190g.m1697a(C0200q.m1794a(mo679a(eoVar, evVar), mo693b(eoVar, evVar), m3704e(eoVar, evVar), m3692d(eoVar, evVar)));
    }

    public void mo690a(eo eoVar, ev evVar, View view, C0190g c0190g) {
        c0190g.m1701b(C0201r.m1795a(mo675e() ? m3694d(view) : 0, 1, mo673d() ? m3694d(view) : 0, 1, false, false));
    }

    public void m3647a(eo eoVar, ev evVar, AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        aj a = C0183a.m1624a(accessibilityEvent);
        if (this.f1767q != null && a != null) {
            if (!(bv.m2018b(this.f1767q, 1) || bv.m2018b(this.f1767q, -1) || bv.m2013a(this.f1767q, -1) || bv.m2013a(this.f1767q, 1))) {
                z = false;
            }
            a.m1644a(z);
            if (this.f1767q.f156q != null) {
                a.m1643a(this.f1767q.f156q.mo826a());
            }
        }
    }

    public void m3648a(View view) {
        m3649a(view, -1);
    }

    public void m3649a(View view, int i) {
        m3614a(view, i, true);
    }

    public void m3650a(View view, int i, int i2) {
        ej ejVar = (ej) view.getLayoutParams();
        Rect g = this.f1767q.m210g(view);
        int i3 = (g.left + g.right) + i;
        int i4 = (g.bottom + g.top) + i2;
        i3 = m3608a(m3734v(), m3732t(), i3 + (((m3736x() + m3738z()) + ejVar.leftMargin) + ejVar.rightMargin), ejVar.width, mo673d());
        i4 = m3608a(m3735w(), m3733u(), i4 + (((m3737y() + m3619A()) + ejVar.topMargin) + ejVar.bottomMargin), ejVar.height, mo675e());
        if (m3680b(view, i3, i4, ejVar)) {
            view.measure(i3, i4);
        }
    }

    public void m3651a(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((ej) view.getLayoutParams()).f2124b;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    public void m3652a(View view, int i, ej ejVar) {
        ey c = RecyclerView.m139c(view);
        if (c.m4660q()) {
            this.f1767q.f145d.m4881e(c);
        } else {
            this.f1767q.f145d.m4882f(c);
        }
        this.f1766p.m4190a(view, i, ejVar, c.m4660q());
    }

    public void m3653a(View view, Rect rect) {
        if (this.f1767q == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(this.f1767q.m210g(view));
        }
    }

    void m3654a(View view, C0190g c0190g) {
        ey c = RecyclerView.m139c(view);
        if (c != null && !c.m4660q() && !this.f1766p.m4198c(c.f2256a)) {
            mo690a(this.f1767q.f142a, this.f1767q.f148g, view, c0190g);
        }
    }

    public void m3655a(View view, eo eoVar) {
        m3689c(view);
        eoVar.m4539a(view);
    }

    public void mo662a(AccessibilityEvent accessibilityEvent) {
        m3647a(this.f1767q.f142a, this.f1767q.f148g, accessibilityEvent);
    }

    public void mo663a(String str) {
        if (this.f1767q != null) {
            this.f1767q.m189a(str);
        }
    }

    boolean m3658a(int i, Bundle bundle) {
        return m3664a(this.f1767q.f142a, this.f1767q.f148g, i, bundle);
    }

    public boolean m3659a(RecyclerView recyclerView, ev evVar, View view, View view2) {
        return m3661a(recyclerView, view, view2);
    }

    public boolean m3660a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
        int x = m3736x();
        int y = m3737y();
        int v = m3734v() - m3738z();
        int w = m3735w() - m3619A();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - x);
        int min2 = Math.min(0, top - y);
        int max = Math.max(0, width - v);
        w = Math.max(0, height - w);
        if (m3729q() == 1) {
            if (max == 0) {
                max = Math.max(min, width - v);
            }
            min = max;
        } else {
            min = min != 0 ? min : Math.min(left - x, max);
        }
        max = min2 != 0 ? min2 : Math.min(top - y, w);
        if (min == 0 && max == 0) {
            return false;
        }
        if (z) {
            recyclerView.scrollBy(min, max);
        } else {
            recyclerView.m186a(min, max);
        }
        return true;
    }

    @Deprecated
    public boolean m3661a(RecyclerView recyclerView, View view, View view2) {
        return m3728p() || recyclerView.m216j();
    }

    public boolean m3662a(RecyclerView recyclerView, ArrayList arrayList, int i, int i2) {
        return false;
    }

    public boolean mo692a(ej ejVar) {
        return ejVar != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m3664a(android.support.v7.widget.eo r7, android.support.v7.widget.ev r8, int r9, android.os.Bundle r10) {
        /*
        r6 = this;
        r4 = -1;
        r2 = 1;
        r1 = 0;
        r0 = r6.f1767q;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        switch(r9) {
            case 4096: goto L_0x004a;
            case 8192: goto L_0x0018;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = r1;
        r3 = r1;
    L_0x000d:
        if (r3 != 0) goto L_0x0011;
    L_0x000f:
        if (r0 == 0) goto L_0x0007;
    L_0x0011:
        r1 = r6.f1767q;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x0007;
    L_0x0018:
        r0 = r6.f1767q;
        r0 = android.support.v4.view.bv.m2018b(r0, r4);
        if (r0 == 0) goto L_0x007f;
    L_0x0020:
        r0 = r6.m3735w();
        r3 = r6.m3737y();
        r0 = r0 - r3;
        r3 = r6.m3619A();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x002f:
        r3 = r6.f1767q;
        r3 = android.support.v4.view.bv.m2013a(r3, r4);
        if (r3 == 0) goto L_0x007a;
    L_0x0037:
        r3 = r6.m3734v();
        r4 = r6.m3736x();
        r3 = r3 - r4;
        r4 = r6.m3738z();
        r3 = r3 - r4;
        r3 = -r3;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x004a:
        r0 = r6.f1767q;
        r0 = android.support.v4.view.bv.m2018b(r0, r2);
        if (r0 == 0) goto L_0x007d;
    L_0x0052:
        r0 = r6.m3735w();
        r3 = r6.m3737y();
        r0 = r0 - r3;
        r3 = r6.m3619A();
        r0 = r0 - r3;
    L_0x0060:
        r3 = r6.f1767q;
        r3 = android.support.v4.view.bv.m2013a(r3, r2);
        if (r3 == 0) goto L_0x007a;
    L_0x0068:
        r3 = r6.m3734v();
        r4 = r6.m3736x();
        r3 = r3 - r4;
        r4 = r6.m3738z();
        r3 = r3 - r4;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x007a:
        r3 = r0;
        r0 = r1;
        goto L_0x000d;
    L_0x007d:
        r0 = r1;
        goto L_0x0060;
    L_0x007f:
        r0 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.eh.a(android.support.v7.widget.eo, android.support.v7.widget.ev, int, android.os.Bundle):boolean");
    }

    public boolean m3665a(eo eoVar, ev evVar, View view, int i, Bundle bundle) {
        return false;
    }

    boolean m3666a(View view, int i, int i2, ej ejVar) {
        return (this.f1763c && m3617b(view.getMeasuredWidth(), i, ejVar.width) && m3617b(view.getMeasuredHeight(), i2, ejVar.height)) ? false : true;
    }

    boolean m3667a(View view, int i, Bundle bundle) {
        return m3665a(this.f1767q.f142a, this.f1767q.f148g, view, i, bundle);
    }

    public boolean m3668a(Runnable runnable) {
        return this.f1767q != null ? this.f1767q.removeCallbacks(runnable) : false;
    }

    public int mo664b(int i, eo eoVar, ev evVar) {
        return 0;
    }

    public int mo693b(eo eoVar, ev evVar) {
        return (this.f1767q == null || this.f1767q.f156q == null || !mo673d()) ? 1 : this.f1767q.f156q.mo826a();
    }

    public int mo665b(ev evVar) {
        return 0;
    }

    void m3672b(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        int s = m3731s();
        if (s == 0) {
            this.f1767q.m203d(i, i2);
            return;
        }
        int i5 = 0;
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        while (i5 < s) {
            View h = m3713h(i5);
            ej ejVar = (ej) h.getLayoutParams();
            int h2 = m3712h(h) - ejVar.leftMargin;
            int j = ejVar.rightMargin + m3716j(h);
            int i8 = m3714i(h) - ejVar.topMargin;
            int k = ejVar.bottomMargin + m3719k(h);
            if (h2 >= i7) {
                h2 = i7;
            }
            if (j <= i6) {
                j = i6;
            }
            if (i8 >= i3) {
                i8 = i3;
            }
            if (k <= i4) {
                k = i4;
            }
            i5++;
            i6 = j;
            i3 = i8;
            i7 = h2;
            i4 = k;
        }
        this.f1767q.f155p.set(i7, i3, i6, i4);
        mo683a(this.f1767q.f155p, i, i2);
    }

    void m3673b(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f1767q = null;
            this.f1766p = null;
            this.f1764d = MeasureSpec.makeMeasureSpec(0, 1073741824);
            this.f1765e = MeasureSpec.makeMeasureSpec(0, 1073741824);
            return;
        }
        this.f1767q = recyclerView;
        this.f1766p = recyclerView.f144c;
        this.f1764d = MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
        this.f1765e = MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
    }

    public void mo694b(RecyclerView recyclerView, int i, int i2) {
    }

    void m3675b(RecyclerView recyclerView, eo eoVar) {
        this.f1769s = false;
        mo661a(recyclerView, eoVar);
    }

    void m3676b(eo eoVar) {
        int d = eoVar.m4552d();
        for (int i = d - 1; i >= 0; i--) {
            View e = eoVar.m4555e(i);
            ey c = RecyclerView.m139c(e);
            if (!c.m4646c()) {
                c.m4642a(false);
                if (c.m4661r()) {
                    this.f1767q.removeDetachedView(e, false);
                }
                if (this.f1767q.f147f != null) {
                    this.f1767q.f147f.mo723c(c);
                }
                c.m4642a(true);
                eoVar.m4546b(e);
            }
        }
        eoVar.m4556e();
        if (d > 0) {
            this.f1767q.invalidate();
        }
    }

    public void m3677b(View view) {
        m3678b(view, -1);
    }

    public void m3678b(View view, int i) {
        m3614a(view, i, false);
    }

    public boolean mo666b() {
        return false;
    }

    boolean m3680b(View view, int i, int i2, ej ejVar) {
        return (!view.isLayoutRequested() && this.f1763c && m3617b(view.getWidth(), i, ejVar.width) && m3617b(view.getHeight(), i2, ejVar.height)) ? false : true;
    }

    public int mo667c(ev evVar) {
        return 0;
    }

    public Parcelable mo668c() {
        return null;
    }

    public View mo669c(int i) {
        int s = m3731s();
        for (int i2 = 0; i2 < s; i2++) {
            View h = m3713h(i2);
            ey c = RecyclerView.m139c(h);
            if (c != null && c.m4647d() == i && !c.m4646c() && (this.f1767q.f148g.m4606a() || !c.m4660q())) {
                return h;
            }
        }
        return null;
    }

    public void m3684c(int i, int i2) {
        View h = m3713h(i);
        if (h == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
        }
        m3711g(i);
        m3690c(h, i2);
    }

    void m3685c(RecyclerView recyclerView) {
        this.f1769s = true;
        m3698d(recyclerView);
    }

    public void m3686c(RecyclerView recyclerView, int i, int i2) {
    }

    public void m3687c(eo eoVar) {
        for (int s = m3731s() - 1; s >= 0; s--) {
            if (!RecyclerView.m139c(m3713h(s)).m4646c()) {
                m3633a(s, eoVar);
            }
        }
    }

    public void mo670c(eo eoVar, ev evVar) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public void m3689c(View view) {
        this.f1766p.m4189a(view);
    }

    public void m3690c(View view, int i) {
        m3652a(view, i, (ej) view.getLayoutParams());
    }

    public void m3691c(boolean z) {
        this.f1762b = z;
    }

    public int m3692d(eo eoVar, ev evVar) {
        return 0;
    }

    public int mo671d(ev evVar) {
        return 0;
    }

    public int m3694d(View view) {
        return ((ej) view.getLayoutParams()).m4360e();
    }

    public View m3695d(View view, int i) {
        return null;
    }

    public void mo672d(int i) {
    }

    public void m3697d(int i, int i2) {
        this.f1767q.setMeasuredDimension(i, i2);
    }

    public void m3698d(RecyclerView recyclerView) {
    }

    public boolean mo673d() {
        return false;
    }

    public int mo674e(ev evVar) {
        return 0;
    }

    public View m3701e(View view) {
        if (this.f1767q == null) {
            return null;
        }
        View b = this.f1767q.m193b(view);
        return (b == null || this.f1766p.m4198c(b)) ? null : b;
    }

    @Deprecated
    public void m3702e(RecyclerView recyclerView) {
    }

    public boolean mo675e() {
        return false;
    }

    public boolean m3704e(eo eoVar, ev evVar) {
        return false;
    }

    public int mo676f(ev evVar) {
        return 0;
    }

    public int m3706f(View view) {
        Rect rect = ((ej) view.getLayoutParams()).f2124b;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    public void m3707f(int i) {
        if (m3713h(i) != null) {
            this.f1766p.m4188a(i);
        }
    }

    void m3708f(RecyclerView recyclerView) {
        m3632a(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public int mo677g(ev evVar) {
        return 0;
    }

    public int m3710g(View view) {
        Rect rect = ((ej) view.getLayoutParams()).f2124b;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public void m3711g(int i) {
        m3610a(i, m3713h(i));
    }

    public int m3712h(View view) {
        return view.getLeft() - m3724n(view);
    }

    public View m3713h(int i) {
        return this.f1766p != null ? this.f1766p.m4195b(i) : null;
    }

    public int m3714i(View view) {
        return view.getTop() - m3721l(view);
    }

    public void mo695i(int i) {
        if (this.f1767q != null) {
            this.f1767q.m195b(i);
        }
    }

    public int m3716j(View view) {
        return view.getRight() + m3726o(view);
    }

    public void mo696j(int i) {
        if (this.f1767q != null) {
            this.f1767q.m185a(i);
        }
    }

    boolean mo678j() {
        return false;
    }

    public int m3719k(View view) {
        return view.getBottom() + m3722m(view);
    }

    public void mo697k(int i) {
    }

    public int m3721l(View view) {
        return ((ej) view.getLayoutParams()).f2124b.top;
    }

    public int m3722m(View view) {
        return ((ej) view.getLayoutParams()).f2124b.bottom;
    }

    public void m3723m() {
        if (this.f1767q != null) {
            this.f1767q.requestLayout();
        }
    }

    public int m3724n(View view) {
        return ((ej) view.getLayoutParams()).f2124b.left;
    }

    public boolean m3725n() {
        return this.f1769s;
    }

    public int m3726o(View view) {
        return ((ej) view.getLayoutParams()).f2124b.right;
    }

    public boolean m3727o() {
        return this.f1767q != null && this.f1767q.f153n;
    }

    public boolean m3728p() {
        return this.f1768r != null && this.f1768r.m4581c();
    }

    public int m3729q() {
        return bv.m2031h(this.f1767q);
    }

    public int m3730r() {
        return -1;
    }

    public int m3731s() {
        return this.f1766p != null ? this.f1766p.m4193b() : 0;
    }

    public int m3732t() {
        return MeasureSpec.getMode(this.f1764d);
    }

    public int m3733u() {
        return MeasureSpec.getMode(this.f1765e);
    }

    public int m3734v() {
        return MeasureSpec.getSize(this.f1764d);
    }

    public int m3735w() {
        return MeasureSpec.getSize(this.f1765e);
    }

    public int m3736x() {
        return this.f1767q != null ? this.f1767q.getPaddingLeft() : 0;
    }

    public int m3737y() {
        return this.f1767q != null ? this.f1767q.getPaddingTop() : 0;
    }

    public int m3738z() {
        return this.f1767q != null ? this.f1767q.getPaddingRight() : 0;
    }
}
