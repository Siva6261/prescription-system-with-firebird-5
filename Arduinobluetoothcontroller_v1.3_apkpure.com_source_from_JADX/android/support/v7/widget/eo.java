package android.support.v7.widget;

import android.support.v4.view.bv;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class eo {
    final ArrayList f2212a = new ArrayList();
    final ArrayList f2213b = new ArrayList();
    final /* synthetic */ RecyclerView f2214c;
    private ArrayList f2215d = null;
    private final List f2216e = Collections.unmodifiableList(this.f2212a);
    private int f2217f = 2;
    private en f2218g;
    private ew f2219h;

    public eo(RecyclerView recyclerView) {
        this.f2214c = recyclerView;
    }

    private void m4527a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                m4527a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    private void m4528d(View view) {
        if (this.f2214c.m215i()) {
            if (bv.m2026e(view) == 0) {
                bv.m2020c(view, 1);
            }
            if (!bv.m2017b(view)) {
                bv.m2008a(view, this.f2214c.ag.m4672b());
            }
        }
    }

    private void m4529f(ey eyVar) {
        if (eyVar.f2256a instanceof ViewGroup) {
            m4527a((ViewGroup) eyVar.f2256a, false);
        }
    }

    ey m4530a(int i, int i2, boolean z) {
        View a;
        int i3 = 0;
        int size = this.f2212a.size();
        int i4 = 0;
        while (i4 < size) {
            ey eyVar = (ey) this.f2212a.get(i4);
            if (eyVar.m4654k() || eyVar.m4647d() != i || eyVar.m4657n() || (!this.f2214c.f148g.f2243h && eyVar.m4660q())) {
                i4++;
            } else if (i2 == -1 || eyVar.m4651h() == i2) {
                eyVar.m4645b(32);
                return eyVar;
            } else {
                Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + eyVar.m4651h() + " but expected " + i2 + ")");
                if (!z) {
                    a = this.f2214c.f144c.m4186a(i, i2);
                    if (a != null) {
                        eyVar = RecyclerView.m139c(a);
                        this.f2214c.f144c.m4201e(a);
                        i3 = this.f2214c.f144c.m4194b(a);
                        if (i3 != -1) {
                            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + eyVar);
                        }
                        this.f2214c.f144c.m4199d(i3);
                        m4551c(a);
                        eyVar.m4645b(8224);
                        return eyVar;
                    }
                }
                i4 = this.f2213b.size();
                while (i3 < i4) {
                    eyVar = (ey) this.f2213b.get(i3);
                    if (eyVar.m4657n() || eyVar.m4647d() != i) {
                        i3++;
                    } else if (z) {
                        return eyVar;
                    } else {
                        this.f2213b.remove(i3);
                        return eyVar;
                    }
                }
                return null;
            }
        }
        if (z) {
            a = this.f2214c.f144c.m4186a(i, i2);
            if (a != null) {
                eyVar = RecyclerView.m139c(a);
                this.f2214c.f144c.m4201e(a);
                i3 = this.f2214c.f144c.m4194b(a);
                if (i3 != -1) {
                    this.f2214c.f144c.m4199d(i3);
                    m4551c(a);
                    eyVar.m4645b(8224);
                    return eyVar;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + eyVar);
            }
        }
        i4 = this.f2213b.size();
        while (i3 < i4) {
            eyVar = (ey) this.f2213b.get(i3);
            if (eyVar.m4657n()) {
            }
            i3++;
        }
        return null;
    }

    ey m4531a(long j, int i, boolean z) {
        int size;
        for (size = this.f2212a.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2212a.get(size);
            if (eyVar.m4650g() == j && !eyVar.m4654k()) {
                if (i == eyVar.m4651h()) {
                    eyVar.m4645b(32);
                    if (!eyVar.m4660q() || this.f2214c.f148g.m4606a()) {
                        return eyVar;
                    }
                    eyVar.m4637a(2, 14);
                    return eyVar;
                } else if (!z) {
                    this.f2212a.remove(size);
                    this.f2214c.removeDetachedView(eyVar.f2256a, false);
                    m4546b(eyVar.f2256a);
                }
            }
        }
        for (size = this.f2213b.size() - 1; size >= 0; size--) {
            eyVar = (ey) this.f2213b.get(size);
            if (eyVar.m4650g() == j) {
                if (i == eyVar.m4651h()) {
                    if (z) {
                        return eyVar;
                    }
                    this.f2213b.remove(size);
                    return eyVar;
                } else if (!z) {
                    m4553d(size);
                }
            }
        }
        return null;
    }

    View m4532a(int i, boolean z) {
        boolean z2 = true;
        if (i < 0 || i >= this.f2214c.f148g.m4610e()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f2214c.f148g.m4610e());
        }
        ey f;
        boolean z3;
        ey eyVar;
        boolean z4;
        int b;
        boolean z5;
        int b2;
        LayoutParams layoutParams;
        ej ejVar;
        if (this.f2214c.f148g.m4606a()) {
            f = m4559f(i);
            ey eyVar2 = f;
            z3 = f != null;
            eyVar = eyVar2;
        } else {
            eyVar = null;
            z3 = false;
        }
        if (eyVar == null) {
            eyVar = m4530a(i, -1, z);
            if (eyVar != null) {
                if (m4540a(eyVar)) {
                    z4 = true;
                } else {
                    if (!z) {
                        eyVar.m4645b(4);
                        if (eyVar.m4652i()) {
                            this.f2214c.removeDetachedView(eyVar.f2256a, false);
                            eyVar.m4653j();
                        } else if (eyVar.m4654k()) {
                            eyVar.m4655l();
                        }
                        m4545b(eyVar);
                    }
                    eyVar = null;
                    z4 = z3;
                }
                if (eyVar == null) {
                    b = this.f2214c.f143b.m4038b(i);
                    if (b >= 0 || b >= this.f2214c.f156q.mo826a()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f2214c.f148g.m4610e());
                    }
                    int a = this.f2214c.f156q.m4478a(b);
                    if (this.f2214c.f156q.m4490b()) {
                        eyVar = m4531a(this.f2214c.f156q.m4485b(b), a, z);
                        if (eyVar != null) {
                            eyVar.f2257b = b;
                            z4 = true;
                        }
                    }
                    if (eyVar == null && this.f2219h != null) {
                        View a2 = this.f2219h.m4611a(this, i, a);
                        if (a2 != null) {
                            eyVar = this.f2214c.m183a(a2);
                            if (eyVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (eyVar.m4646c()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (eyVar == null) {
                        eyVar = m4558f().m4520a(a);
                        if (eyVar != null) {
                            eyVar.m4665v();
                            if (RecyclerView.f117j) {
                                m4529f(eyVar);
                            }
                        }
                    }
                    if (eyVar == null) {
                        f = this.f2214c.f156q.m4486b(this.f2214c, a);
                        z5 = z4;
                        if (z5 && !this.f2214c.f148g.m4606a() && f.m4643a(8192)) {
                            f.m4637a(0, 8192);
                            if (this.f2214c.f148g.f2244i) {
                                this.f2214c.m121a(f, this.f2214c.f147f.m4256a(this.f2214c.f148g, f, eb.m4254d(f) | 4096, f.m4664u()));
                            }
                        }
                        int i2;
                        if (!this.f2214c.f148g.m4606a() && f.m4659p()) {
                            f.f2261f = i;
                            i2 = 0;
                        } else if (f.m4659p() || f.m4658o() || f.m4657n()) {
                            b2 = this.f2214c.f143b.m4038b(i);
                            f.f2266k = this.f2214c;
                            this.f2214c.f156q.m4489b(f, b2);
                            m4528d(f.f2256a);
                            if (this.f2214c.f148g.m4606a()) {
                                f.f2261f = i;
                            }
                            z4 = true;
                        } else {
                            i2 = 0;
                        }
                        layoutParams = f.f2256a.getLayoutParams();
                        if (layoutParams != null) {
                            ejVar = (ej) this.f2214c.generateDefaultLayoutParams();
                            f.f2256a.setLayoutParams(ejVar);
                        } else if (this.f2214c.checkLayoutParams(layoutParams)) {
                            ejVar = (ej) layoutParams;
                        } else {
                            ejVar = (ej) this.f2214c.generateLayoutParams(layoutParams);
                            f.f2256a.setLayoutParams(ejVar);
                        }
                        ejVar.f2123a = f;
                        if (!z5 || r3 == 0) {
                            z2 = false;
                        }
                        ejVar.f2126d = z2;
                        return f.f2256a;
                    }
                }
                f = eyVar;
                z5 = z4;
                f.m4637a(0, 8192);
                if (this.f2214c.f148g.f2244i) {
                    this.f2214c.m121a(f, this.f2214c.f147f.m4256a(this.f2214c.f148g, f, eb.m4254d(f) | 4096, f.m4664u()));
                }
                if (!this.f2214c.f148g.m4606a()) {
                }
                if (f.m4659p()) {
                }
                b2 = this.f2214c.f143b.m4038b(i);
                f.f2266k = this.f2214c;
                this.f2214c.f156q.m4489b(f, b2);
                m4528d(f.f2256a);
                if (this.f2214c.f148g.m4606a()) {
                    f.f2261f = i;
                }
                z4 = true;
                layoutParams = f.f2256a.getLayoutParams();
                if (layoutParams != null) {
                    ejVar = (ej) this.f2214c.generateDefaultLayoutParams();
                    f.f2256a.setLayoutParams(ejVar);
                } else if (this.f2214c.checkLayoutParams(layoutParams)) {
                    ejVar = (ej) layoutParams;
                } else {
                    ejVar = (ej) this.f2214c.generateLayoutParams(layoutParams);
                    f.f2256a.setLayoutParams(ejVar);
                }
                ejVar.f2123a = f;
                z2 = false;
                ejVar.f2126d = z2;
                return f.f2256a;
            }
        }
        z4 = z3;
        if (eyVar == null) {
            b = this.f2214c.f143b.m4038b(i);
            if (b >= 0) {
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f2214c.f148g.m4610e());
        }
        f = eyVar;
        z5 = z4;
        f.m4637a(0, 8192);
        if (this.f2214c.f148g.f2244i) {
            this.f2214c.m121a(f, this.f2214c.f147f.m4256a(this.f2214c.f148g, f, eb.m4254d(f) | 4096, f.m4664u()));
        }
        if (!this.f2214c.f148g.m4606a()) {
        }
        if (f.m4659p()) {
        }
        b2 = this.f2214c.f143b.m4038b(i);
        f.f2266k = this.f2214c;
        this.f2214c.f156q.m4489b(f, b2);
        m4528d(f.f2256a);
        if (this.f2214c.f148g.m4606a()) {
            f.f2261f = i;
        }
        z4 = true;
        layoutParams = f.f2256a.getLayoutParams();
        if (layoutParams != null) {
            ejVar = (ej) this.f2214c.generateDefaultLayoutParams();
            f.f2256a.setLayoutParams(ejVar);
        } else if (this.f2214c.checkLayoutParams(layoutParams)) {
            ejVar = (ej) this.f2214c.generateLayoutParams(layoutParams);
            f.f2256a.setLayoutParams(ejVar);
        } else {
            ejVar = (ej) layoutParams;
        }
        ejVar.f2123a = f;
        z2 = false;
        ejVar.f2126d = z2;
        return f.f2256a;
    }

    public void m4533a() {
        this.f2212a.clear();
        m4548c();
    }

    public void m4534a(int i) {
        this.f2217f = i;
        for (int size = this.f2213b.size() - 1; size >= 0 && this.f2213b.size() > i; size--) {
            m4553d(size);
        }
    }

    void m4535a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = this.f2213b.size();
        for (int i6 = 0; i6 < size; i6++) {
            ey eyVar = (ey) this.f2213b.get(i6);
            if (eyVar != null && eyVar.f2257b >= r3 && eyVar.f2257b <= r2) {
                if (eyVar.f2257b == i) {
                    eyVar.m4639a(i2 - i, false);
                } else {
                    eyVar.m4639a(i3, false);
                }
            }
        }
    }

    void m4536a(dx dxVar, dx dxVar2, boolean z) {
        m4533a();
        m4558f().m4523a(dxVar, dxVar2, z);
    }

    void m4537a(en enVar) {
        if (this.f2218g != null) {
            this.f2218g.m4525b();
        }
        this.f2218g = enVar;
        if (enVar != null) {
            this.f2218g.m4522a(this.f2214c.getAdapter());
        }
    }

    void m4538a(ew ewVar) {
        this.f2219h = ewVar;
    }

    public void m4539a(View view) {
        ey c = RecyclerView.m139c(view);
        if (c.m4661r()) {
            this.f2214c.removeDetachedView(view, false);
        }
        if (c.m4652i()) {
            c.m4653j();
        } else if (c.m4654k()) {
            c.m4655l();
        }
        m4545b(c);
    }

    boolean m4540a(ey eyVar) {
        if (eyVar.m4660q()) {
            return this.f2214c.f148g.m4606a();
        }
        if (eyVar.f2257b >= 0 && eyVar.f2257b < this.f2214c.f156q.mo826a()) {
            return (this.f2214c.f148g.m4606a() || this.f2214c.f156q.m4478a(eyVar.f2257b) == eyVar.m4651h()) ? !this.f2214c.f156q.m4490b() || eyVar.m4650g() == this.f2214c.f156q.m4485b(eyVar.f2257b) : false;
        } else {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + eyVar);
        }
    }

    public int m4541b(int i) {
        if (i >= 0 && i < this.f2214c.f148g.m4610e()) {
            return !this.f2214c.f148g.m4606a() ? i : this.f2214c.f143b.m4038b(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f2214c.f148g.m4610e());
        }
    }

    public List m4542b() {
        return this.f2216e;
    }

    void m4543b(int i, int i2) {
        int size = this.f2213b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ey eyVar = (ey) this.f2213b.get(i3);
            if (eyVar != null && eyVar.f2257b >= i) {
                eyVar.m4639a(i2, true);
            }
        }
    }

    void m4544b(int i, int i2, boolean z) {
        int i3 = i + i2;
        for (int size = this.f2213b.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2213b.get(size);
            if (eyVar != null) {
                if (eyVar.f2257b >= i3) {
                    eyVar.m4639a(-i2, z);
                } else if (eyVar.f2257b >= i) {
                    eyVar.m4645b(8);
                    m4553d(size);
                }
            }
        }
    }

    void m4545b(ey eyVar) {
        boolean z = true;
        int i = 0;
        if (eyVar.m4652i() || eyVar.f2256a.getParent() != null) {
            StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(eyVar.m4652i()).append(" isAttached:");
            if (eyVar.f2256a.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (eyVar.m4661r()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + eyVar);
        } else if (eyVar.m4646c()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            int i2;
            boolean c = eyVar.m4625C();
            boolean z2 = this.f2214c.f156q != null && c && this.f2214c.f156q.m4491b(eyVar);
            if (z2 || eyVar.m4666w()) {
                if (!eyVar.m4643a(14)) {
                    int size = this.f2213b.size();
                    if (size == this.f2217f && size > 0) {
                        m4553d(0);
                    }
                    if (size < this.f2217f) {
                        this.f2213b.add(eyVar);
                        z2 = true;
                        if (z2) {
                            m4550c(eyVar);
                            i = 1;
                            i2 = z2;
                        } else {
                            z = z2;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    z = z2;
                } else {
                    m4550c(eyVar);
                    i = 1;
                    i2 = z2;
                }
            } else {
                i2 = 0;
            }
            this.f2214c.f145d.m4883g(eyVar);
            if (i2 == 0 && r1 == 0 && c) {
                eyVar.f2266k = null;
            }
        }
    }

    void m4546b(View view) {
        ey c = RecyclerView.m139c(view);
        c.f2269o = null;
        c.f2270p = false;
        c.m4655l();
        m4545b(c);
    }

    public View m4547c(int i) {
        return m4532a(i, false);
    }

    void m4548c() {
        for (int size = this.f2213b.size() - 1; size >= 0; size--) {
            m4553d(size);
        }
        this.f2213b.clear();
    }

    void m4549c(int i, int i2) {
        int i3 = i + i2;
        for (int size = this.f2213b.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2213b.get(size);
            if (eyVar != null) {
                int d = eyVar.m4647d();
                if (d >= i && d < i3) {
                    eyVar.m4645b(2);
                    m4553d(size);
                }
            }
        }
    }

    void m4550c(ey eyVar) {
        bv.m2008a(eyVar.f2256a, null);
        m4557e(eyVar);
        eyVar.f2266k = null;
        m4558f().m4524a(eyVar);
    }

    void m4551c(View view) {
        ey c = RecyclerView.m139c(view);
        if (!c.m4643a(12) && c.m4667x() && !this.f2214c.m145c(c)) {
            if (this.f2215d == null) {
                this.f2215d = new ArrayList();
            }
            c.m4640a(this, true);
            this.f2215d.add(c);
        } else if (!c.m4657n() || c.m4660q() || this.f2214c.f156q.m4490b()) {
            c.m4640a(this, false);
            this.f2212a.add(c);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    int m4552d() {
        return this.f2212a.size();
    }

    void m4553d(int i) {
        m4550c((ey) this.f2213b.get(i));
        this.f2213b.remove(i);
    }

    void m4554d(ey eyVar) {
        if (eyVar.f2270p) {
            this.f2215d.remove(eyVar);
        } else {
            this.f2212a.remove(eyVar);
        }
        eyVar.f2269o = null;
        eyVar.f2270p = false;
        eyVar.m4655l();
    }

    View m4555e(int i) {
        return ((ey) this.f2212a.get(i)).f2256a;
    }

    void m4556e() {
        this.f2212a.clear();
        if (this.f2215d != null) {
            this.f2215d.clear();
        }
    }

    void m4557e(ey eyVar) {
        if (this.f2214c.f157r != null) {
            this.f2214c.f157r.m4564a(eyVar);
        }
        if (this.f2214c.f156q != null) {
            this.f2214c.f156q.m4482a(eyVar);
        }
        if (this.f2214c.f148g != null) {
            this.f2214c.f145d.m4883g(eyVar);
        }
    }

    en m4558f() {
        if (this.f2218g == null) {
            this.f2218g = new en();
        }
        return this.f2218g;
    }

    ey m4559f(int i) {
        int i2 = 0;
        if (this.f2215d != null) {
            int size = this.f2215d.size();
            if (size != 0) {
                ey eyVar;
                int i3 = 0;
                while (i3 < size) {
                    eyVar = (ey) this.f2215d.get(i3);
                    if (eyVar.m4654k() || eyVar.m4647d() != i) {
                        i3++;
                    } else {
                        eyVar.m4645b(32);
                        return eyVar;
                    }
                }
                if (this.f2214c.f156q.m4490b()) {
                    int b = this.f2214c.f143b.m4038b(i);
                    if (b > 0 && b < this.f2214c.f156q.mo826a()) {
                        long b2 = this.f2214c.f156q.m4485b(b);
                        while (i2 < size) {
                            eyVar = (ey) this.f2215d.get(i2);
                            if (eyVar.m4654k() || eyVar.m4650g() != b2) {
                                i2++;
                            } else {
                                eyVar.m4645b(32);
                                return eyVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    void m4560g() {
        int size = this.f2213b.size();
        for (int i = 0; i < size; i++) {
            ey eyVar = (ey) this.f2213b.get(i);
            if (eyVar != null) {
                eyVar.m4645b(512);
            }
        }
    }

    void m4561h() {
        if (this.f2214c.f156q == null || !this.f2214c.f156q.m4490b()) {
            m4548c();
            return;
        }
        int size = this.f2213b.size();
        for (int i = 0; i < size; i++) {
            ey eyVar = (ey) this.f2213b.get(i);
            if (eyVar != null) {
                eyVar.m4645b(6);
                eyVar.m4641a(null);
            }
        }
    }

    void m4562i() {
        int i;
        int i2 = 0;
        int size = this.f2213b.size();
        for (i = 0; i < size; i++) {
            ((ey) this.f2213b.get(i)).m4636a();
        }
        size = this.f2212a.size();
        for (i = 0; i < size; i++) {
            ((ey) this.f2212a.get(i)).m4636a();
        }
        if (this.f2215d != null) {
            i = this.f2215d.size();
            while (i2 < i) {
                ((ey) this.f2215d.get(i2)).m4636a();
                i2++;
            }
        }
    }

    void m4563j() {
        int size = this.f2213b.size();
        for (int i = 0; i < size; i++) {
            ej ejVar = (ej) ((ey) this.f2213b.get(i)).f2256a.getLayoutParams();
            if (ejVar != null) {
                ejVar.f2125c = true;
            }
        }
    }
}
