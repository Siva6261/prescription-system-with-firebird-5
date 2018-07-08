package io.realm;

import io.realm.internal.C0438u;
import io.realm.internal.LinkView;
import io.realm.internal.TableQuery;
import io.realm.internal.async.C0446a;

public class ad {
    private static final Long f2802h = Long.valueOf(0);
    private C0426a f2803a;
    private Class f2804b;
    private String f2805c;
    private C0438u f2806d = this.f2807e.f2795a;
    private aa f2807e;
    private LinkView f2808f = null;
    private TableQuery f2809g = this.f2806d.mo898j();
    private C0446a f2810i;

    private ad(C0483m c0483m, Class cls) {
        this.f2803a = c0483m;
        this.f2804b = cls;
        this.f2807e = c0483m.g.m5421c(cls);
    }

    public static ad m5392a(C0483m c0483m, Class cls) {
        return new ad(c0483m, cls);
    }

    private boolean m5393d() {
        return this.f2805c != null;
    }

    private void m5394e() {
        if (this.f2810i != null) {
            throw new IllegalStateException("This RealmQuery is already used by a find* query, please create a new query");
        }
    }

    public ad m5395a(String str, Boolean bool) {
        long[] a = this.f2807e.m5386a(str, RealmFieldType.BOOLEAN);
        if (bool == null) {
            this.f2809g.m5570a(a);
        } else {
            this.f2809g.m5571a(a, bool.booleanValue());
        }
        return this;
    }

    public ae m5396a() {
        m5394e();
        return m5393d() ? ae.m5400a(this.f2803a, this.f2809g.m5572a(), this.f2805c) : ae.m5399a(this.f2803a, this.f2809g.m5572a(), this.f2804b);
    }

    public C0446a m5397b() {
        return this.f2810i;
    }

    long m5398c() {
        return this.f2809g.m5569a(this.f2803a.f2788e.m5763h());
    }
}
