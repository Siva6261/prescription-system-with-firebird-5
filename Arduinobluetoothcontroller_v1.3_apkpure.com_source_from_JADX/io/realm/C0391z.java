package io.realm;

import io.realm.internal.C0439o;
import io.realm.internal.Table;
import io.realm.internal.TableQuery;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class C0391z {
    protected C0439o f2728a;
    protected C0426a f2729b;
    private final List f2730c = new CopyOnWriteArrayList();
    private boolean f2731d = false;
    private long f2732e = -1;

    void m5229A() {
        Object obj = 1;
        if (!this.f2730c.isEmpty()) {
            Table b = this.f2728a.mo907b();
            if (b != null) {
                long m = b.m5565m();
                if (this.f2732e != m) {
                    this.f2732e = m;
                } else {
                    obj = null;
                }
            }
            if (obj != null) {
                for (C0489t a : this.f2730c) {
                    a.m5822a();
                }
            }
        }
    }

    void m5230B() {
        if (this.f2728a.mo907b() != null) {
            this.f2732e = this.f2728a.mo907b().m5565m();
        }
    }

    void m5231a(Long l) {
        if (l.longValue() == 0) {
            this.f2731d = true;
        } else if (!this.f2731d || this.f2728a == C0439o.f2894b) {
            this.f2731d = true;
            this.f2728a = b_().m5557i(TableQuery.nativeImportHandoverRowIntoSharedGroup(l.longValue(), this.f2729b.f2788e.m5763h()));
        }
    }

    protected Table b_() {
        return this.f2729b.f2790g.m5419b(getClass());
    }

    public final boolean m5232z() {
        return this.f2728a != null && this.f2728a.mo910d();
    }
}
