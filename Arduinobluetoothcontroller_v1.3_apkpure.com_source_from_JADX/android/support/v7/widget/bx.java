package android.support.v7.widget;

import android.support.v4.p007a.C0062a;
import android.support.v4.view.bv;
import android.support.v4.view.dy;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bx extends fo {
    private ArrayList f2072b = new ArrayList();
    private ArrayList f2073c = new ArrayList();
    private ArrayList f2074d = new ArrayList();
    private ArrayList f2075e = new ArrayList();
    private ArrayList f2076f = new ArrayList();
    private ArrayList f2077g = new ArrayList();
    private ArrayList f2078h = new ArrayList();
    private ArrayList f2079i = new ArrayList();
    private ArrayList f2080j = new ArrayList();
    private ArrayList f2081k = new ArrayList();
    private ArrayList f2082l = new ArrayList();

    private void m4305a(cg cgVar) {
        View view = null;
        ey eyVar = cgVar.f2108a;
        View view2 = eyVar == null ? null : eyVar.f2256a;
        ey eyVar2 = cgVar.f2109b;
        if (eyVar2 != null) {
            view = eyVar2.f2256a;
        }
        if (view2 != null) {
            dy a = bv.m2040q(view2).m2385a(m4272g());
            this.f2082l.add(cgVar.f2108a);
            a.m2389b((float) (cgVar.f2112e - cgVar.f2110c));
            a.m2392c((float) (cgVar.f2113f - cgVar.f2111d));
            a.m2384a(0.0f).m2386a(new ce(this, cgVar, a)).m2393c();
        }
        if (view != null) {
            a = bv.m2040q(view);
            this.f2082l.add(cgVar.f2109b);
            a.m2389b(0.0f).m2392c(0.0f).m2385a(m4272g()).m2384a(1.0f).m2386a(new cf(this, cgVar, a, view)).m2393c();
        }
    }

    private void m4306a(List list, ey eyVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            cg cgVar = (cg) list.get(size);
            if (m4307a(cgVar, eyVar) && cgVar.f2108a == null && cgVar.f2109b == null) {
                list.remove(cgVar);
            }
        }
    }

    private boolean m4307a(cg cgVar, ey eyVar) {
        boolean z = false;
        if (cgVar.f2109b == eyVar) {
            cgVar.f2109b = null;
        } else if (cgVar.f2108a != eyVar) {
            return false;
        } else {
            cgVar.f2108a = null;
            z = true;
        }
        bv.m2019c(eyVar.f2256a, 1.0f);
        bv.m2002a(eyVar.f2256a, 0.0f);
        bv.m2015b(eyVar.f2256a, 0.0f);
        m4276a(eyVar, z);
        return true;
    }

    private void m4309b(cg cgVar) {
        if (cgVar.f2108a != null) {
            m4307a(cgVar, cgVar.f2108a);
        }
        if (cgVar.f2109b != null) {
            m4307a(cgVar, cgVar.f2109b);
        }
    }

    private void m4310b(ey eyVar, int i, int i2, int i3, int i4) {
        View view = eyVar.f2256a;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            bv.m2040q(view).m2389b(0.0f);
        }
        if (i6 != 0) {
            bv.m2040q(view).m2392c(0.0f);
        }
        dy q = bv.m2040q(view);
        this.f2080j.add(eyVar);
        q.m2385a(m4267d()).m2386a(new cd(this, eyVar, i5, i6, q)).m2393c();
    }

    private void m4317j() {
        if (!mo720b()) {
            m4274h();
        }
    }

    private void m4318t(ey eyVar) {
        dy q = bv.m2040q(eyVar.f2256a);
        this.f2081k.add(eyVar);
        q.m2385a(m4270f()).m2384a(0.0f).m2386a(new cb(this, eyVar, q)).m2393c();
    }

    private void m4319u(ey eyVar) {
        dy q = bv.m2040q(eyVar.f2256a);
        this.f2079i.add(eyVar);
        q.m2384a(1.0f).m2385a(m4268e()).m2386a(new cc(this, eyVar, q)).m2393c();
    }

    private void m4320v(ey eyVar) {
        C0062a.m953a(eyVar.f2256a);
        mo723c(eyVar);
    }

    public void mo715a() {
        int i = !this.f2072b.isEmpty() ? 1 : 0;
        int i2 = !this.f2074d.isEmpty() ? 1 : 0;
        int i3 = !this.f2075e.isEmpty() ? 1 : 0;
        int i4 = !this.f2073c.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            ArrayList arrayList;
            Runnable byVar;
            Iterator it = this.f2072b.iterator();
            while (it.hasNext()) {
                m4318t((ey) it.next());
            }
            this.f2072b.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2074d);
                this.f2077g.add(arrayList);
                this.f2074d.clear();
                byVar = new by(this, arrayList);
                if (i != 0) {
                    bv.m2011a(((ch) arrayList.get(0)).f2114a.f2256a, byVar, m4270f());
                } else {
                    byVar.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2075e);
                this.f2078h.add(arrayList);
                this.f2075e.clear();
                byVar = new bz(this, arrayList);
                if (i != 0) {
                    bv.m2011a(((cg) arrayList.get(0)).f2108a.f2256a, byVar, m4270f());
                } else {
                    byVar.run();
                }
            }
            if (i4 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2073c);
                this.f2076f.add(arrayList2);
                this.f2073c.clear();
                Runnable caVar = new ca(this, arrayList2);
                if (i == 0 && i2 == 0 && i3 == 0) {
                    caVar.run();
                } else {
                    bv.m2011a(((ey) arrayList2.get(0)).f2256a, caVar, (i != 0 ? m4270f() : 0) + Math.max(i2 != 0 ? m4267d() : 0, i3 != 0 ? m4272g() : 0));
                }
            }
        }
    }

    void m4322a(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            bv.m2040q(((ey) list.get(size)).f2256a).m2391b();
        }
    }

    public boolean mo716a(ey eyVar) {
        m4320v(eyVar);
        this.f2072b.add(eyVar);
        return true;
    }

    public boolean mo717a(ey eyVar, int i, int i2, int i3, int i4) {
        View view = eyVar.f2256a;
        int m = (int) (((float) i) + bv.m2036m(eyVar.f2256a));
        int n = (int) (((float) i2) + bv.m2037n(eyVar.f2256a));
        m4320v(eyVar);
        int i5 = i3 - m;
        int i6 = i4 - n;
        if (i5 == 0 && i6 == 0) {
            m4290i(eyVar);
            return false;
        }
        if (i5 != 0) {
            bv.m2002a(view, (float) (-i5));
        }
        if (i6 != 0) {
            bv.m2015b(view, (float) (-i6));
        }
        this.f2074d.add(new ch(eyVar, m, n, i3, i4));
        return true;
    }

    public boolean mo718a(ey eyVar, ey eyVar2, int i, int i2, int i3, int i4) {
        if (eyVar == eyVar2) {
            return mo717a(eyVar, i, i2, i3, i4);
        }
        float m = bv.m2036m(eyVar.f2256a);
        float n = bv.m2037n(eyVar.f2256a);
        float f = bv.m2028f(eyVar.f2256a);
        m4320v(eyVar);
        int i5 = (int) (((float) (i3 - i)) - m);
        int i6 = (int) (((float) (i4 - i2)) - n);
        bv.m2002a(eyVar.f2256a, m);
        bv.m2015b(eyVar.f2256a, n);
        bv.m2019c(eyVar.f2256a, f);
        if (eyVar2 != null) {
            m4320v(eyVar2);
            bv.m2002a(eyVar2.f2256a, (float) (-i5));
            bv.m2015b(eyVar2.f2256a, (float) (-i6));
            bv.m2019c(eyVar2.f2256a, 0.0f);
        }
        this.f2075e.add(new cg(eyVar, eyVar2, i, i2, i3, i4));
        return true;
    }

    public boolean mo719a(ey eyVar, List list) {
        return !list.isEmpty() || super.mo719a(eyVar, list);
    }

    public boolean mo720b() {
        return (this.f2073c.isEmpty() && this.f2075e.isEmpty() && this.f2074d.isEmpty() && this.f2072b.isEmpty() && this.f2080j.isEmpty() && this.f2081k.isEmpty() && this.f2079i.isEmpty() && this.f2082l.isEmpty() && this.f2077g.isEmpty() && this.f2076f.isEmpty() && this.f2078h.isEmpty()) ? false : true;
    }

    public boolean mo721b(ey eyVar) {
        m4320v(eyVar);
        bv.m2019c(eyVar.f2256a, 0.0f);
        this.f2073c.add(eyVar);
        return true;
    }

    public void mo722c() {
        int size;
        for (size = this.f2074d.size() - 1; size >= 0; size--) {
            ch chVar = (ch) this.f2074d.get(size);
            View view = chVar.f2114a.f2256a;
            bv.m2015b(view, 0.0f);
            bv.m2002a(view, 0.0f);
            m4290i(chVar.f2114a);
            this.f2074d.remove(size);
        }
        for (size = this.f2072b.size() - 1; size >= 0; size--) {
            m4289h((ey) this.f2072b.get(size));
            this.f2072b.remove(size);
        }
        for (size = this.f2073c.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2073c.get(size);
            bv.m2019c(eyVar.f2256a, 1.0f);
            m4291j(eyVar);
            this.f2073c.remove(size);
        }
        for (size = this.f2075e.size() - 1; size >= 0; size--) {
            m4309b((cg) this.f2075e.get(size));
        }
        this.f2075e.clear();
        if (mo720b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f2077g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2077g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ch chVar2 = (ch) arrayList.get(size3);
                    View view2 = chVar2.f2114a.f2256a;
                    bv.m2015b(view2, 0.0f);
                    bv.m2002a(view2, 0.0f);
                    m4290i(chVar2.f2114a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2077g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2076f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2076f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ey eyVar2 = (ey) arrayList.get(size3);
                    bv.m2019c(eyVar2.f2256a, 1.0f);
                    m4291j(eyVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2076f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2078h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2078h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m4309b((cg) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f2078h.remove(arrayList);
                    }
                }
            }
            m4322a(this.f2081k);
            m4322a(this.f2080j);
            m4322a(this.f2079i);
            m4322a(this.f2082l);
            m4274h();
        }
    }

    public void mo723c(ey eyVar) {
        int size;
        View view = eyVar.f2256a;
        bv.m2040q(view).m2391b();
        for (size = this.f2074d.size() - 1; size >= 0; size--) {
            if (((ch) this.f2074d.get(size)).f2114a == eyVar) {
                bv.m2015b(view, 0.0f);
                bv.m2002a(view, 0.0f);
                m4290i(eyVar);
                this.f2074d.remove(size);
            }
        }
        m4306a(this.f2075e, eyVar);
        if (this.f2072b.remove(eyVar)) {
            bv.m2019c(view, 1.0f);
            m4289h(eyVar);
        }
        if (this.f2073c.remove(eyVar)) {
            bv.m2019c(view, 1.0f);
            m4291j(eyVar);
        }
        for (size = this.f2078h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f2078h.get(size);
            m4306a(list, eyVar);
            if (list.isEmpty()) {
                this.f2078h.remove(size);
            }
        }
        for (int size2 = this.f2077g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f2077g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((ch) arrayList.get(size3)).f2114a == eyVar) {
                    bv.m2015b(view, 0.0f);
                    bv.m2002a(view, 0.0f);
                    m4290i(eyVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2077g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f2076f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f2076f.get(size);
            if (arrayList.remove(eyVar)) {
                bv.m2019c(view, 1.0f);
                m4291j(eyVar);
                if (arrayList.isEmpty()) {
                    this.f2076f.remove(size);
                }
            }
        }
        if (this.f2081k.remove(eyVar)) {
        }
        if (this.f2079i.remove(eyVar)) {
        }
        if (this.f2082l.remove(eyVar)) {
        }
        if (this.f2080j.remove(eyVar)) {
            m4317j();
        } else {
            m4317j();
        }
    }
}
