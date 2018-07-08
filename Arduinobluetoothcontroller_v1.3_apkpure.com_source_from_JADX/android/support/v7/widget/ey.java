package android.support.v7.widget;

import android.support.v4.view.bv;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ey {
    private static final List f2255m = Collections.EMPTY_LIST;
    public final View f2256a;
    int f2257b = -1;
    int f2258c = -1;
    long f2259d = -1;
    int f2260e = -1;
    int f2261f = -1;
    ey f2262g = null;
    ey f2263h = null;
    List f2264i = null;
    List f2265j = null;
    RecyclerView f2266k;
    private int f2267l;
    private int f2268n = 0;
    private eo f2269o = null;
    private boolean f2270p = false;
    private int f2271q = 0;

    public ey(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.f2256a = view;
    }

    private void m4623A() {
        bv.m2020c(this.f2256a, this.f2271q);
        this.f2271q = 0;
    }

    private boolean m4624B() {
        return (this.f2267l & 16) != 0;
    }

    private boolean m4625C() {
        return (this.f2267l & 16) == 0 && bv.m2022c(this.f2256a);
    }

    private void m4634y() {
        if (this.f2264i == null) {
            this.f2264i = new ArrayList();
            this.f2265j = Collections.unmodifiableList(this.f2264i);
        }
    }

    private void m4635z() {
        this.f2271q = bv.m2026e(this.f2256a);
        bv.m2020c(this.f2256a, 4);
    }

    void m4636a() {
        this.f2258c = -1;
        this.f2261f = -1;
    }

    void m4637a(int i, int i2) {
        this.f2267l = (this.f2267l & (i2 ^ -1)) | (i & i2);
    }

    void m4638a(int i, int i2, boolean z) {
        m4645b(8);
        m4639a(i2, z);
        this.f2257b = i;
    }

    void m4639a(int i, boolean z) {
        if (this.f2258c == -1) {
            this.f2258c = this.f2257b;
        }
        if (this.f2261f == -1) {
            this.f2261f = this.f2257b;
        }
        if (z) {
            this.f2261f += i;
        }
        this.f2257b += i;
        if (this.f2256a.getLayoutParams() != null) {
            ((ej) this.f2256a.getLayoutParams()).f2125c = true;
        }
    }

    void m4640a(eo eoVar, boolean z) {
        this.f2269o = eoVar;
        this.f2270p = z;
    }

    void m4641a(Object obj) {
        if (obj == null) {
            m4645b(1024);
        } else if ((this.f2267l & 1024) == 0) {
            m4634y();
            this.f2264i.add(obj);
        }
    }

    public final void m4642a(boolean z) {
        this.f2268n = z ? this.f2268n - 1 : this.f2268n + 1;
        if (this.f2268n < 0) {
            this.f2268n = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && this.f2268n == 1) {
            this.f2267l |= 16;
        } else if (z && this.f2268n == 0) {
            this.f2267l &= -17;
        }
    }

    boolean m4643a(int i) {
        return (this.f2267l & i) != 0;
    }

    void m4644b() {
        if (this.f2258c == -1) {
            this.f2258c = this.f2257b;
        }
    }

    void m4645b(int i) {
        this.f2267l |= i;
    }

    boolean m4646c() {
        return (this.f2267l & 128) != 0;
    }

    public final int m4647d() {
        return this.f2261f == -1 ? this.f2257b : this.f2261f;
    }

    public final int m4648e() {
        return this.f2266k == null ? -1 : this.f2266k.m146d(this);
    }

    public final int m4649f() {
        return this.f2258c;
    }

    public final long m4650g() {
        return this.f2259d;
    }

    public final int m4651h() {
        return this.f2260e;
    }

    boolean m4652i() {
        return this.f2269o != null;
    }

    void m4653j() {
        this.f2269o.m4554d(this);
    }

    boolean m4654k() {
        return (this.f2267l & 32) != 0;
    }

    void m4655l() {
        this.f2267l &= -33;
    }

    void m4656m() {
        this.f2267l &= -257;
    }

    boolean m4657n() {
        return (this.f2267l & 4) != 0;
    }

    boolean m4658o() {
        return (this.f2267l & 2) != 0;
    }

    boolean m4659p() {
        return (this.f2267l & 1) != 0;
    }

    boolean m4660q() {
        return (this.f2267l & 8) != 0;
    }

    boolean m4661r() {
        return (this.f2267l & 256) != 0;
    }

    boolean m4662s() {
        return (this.f2267l & 512) != 0 || m4657n();
    }

    void m4663t() {
        if (this.f2264i != null) {
            this.f2264i.clear();
        }
        this.f2267l &= -1025;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f2257b + " id=" + this.f2259d + ", oldPos=" + this.f2258c + ", pLpos:" + this.f2261f);
        if (m4652i()) {
            stringBuilder.append(" scrap ").append(this.f2270p ? "[changeScrap]" : "[attachedScrap]");
        }
        if (m4657n()) {
            stringBuilder.append(" invalid");
        }
        if (!m4659p()) {
            stringBuilder.append(" unbound");
        }
        if (m4658o()) {
            stringBuilder.append(" update");
        }
        if (m4660q()) {
            stringBuilder.append(" removed");
        }
        if (m4646c()) {
            stringBuilder.append(" ignored");
        }
        if (m4661r()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!m4666w()) {
            stringBuilder.append(" not recyclable(" + this.f2268n + ")");
        }
        if (m4662s()) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.f2256a.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    List m4664u() {
        return (this.f2267l & 1024) == 0 ? (this.f2264i == null || this.f2264i.size() == 0) ? f2255m : this.f2265j : f2255m;
    }

    void m4665v() {
        this.f2267l = 0;
        this.f2257b = -1;
        this.f2258c = -1;
        this.f2259d = -1;
        this.f2261f = -1;
        this.f2268n = 0;
        this.f2262g = null;
        this.f2263h = null;
        m4663t();
        this.f2271q = 0;
    }

    public final boolean m4666w() {
        return (this.f2267l & 16) == 0 && !bv.m2022c(this.f2256a);
    }

    boolean m4667x() {
        return (this.f2267l & 2) != 0;
    }
}
