package io.realm.internal;

import io.realm.C0490u;
import java.io.Closeable;

public class C0477s implements Closeable {
    private SharedGroup f2963a;
    private C0469g f2964b = this.f2963a.m5511e();

    public C0477s(C0490u c0490u) {
        this.f2963a = new SharedGroup(c0490u.m5836i(), true, c0490u.m5834g(), c0490u.m5830c());
    }

    public Table m5753a(String str) {
        return this.f2964b.m5493b(str);
    }

    public void m5754a(C0476r c0476r) {
        this.f2964b.m5697a(c0476r);
    }

    public boolean m5755a() {
        return this.f2963a != null;
    }

    public void m5756b() {
        this.f2964b.mo929b();
    }

    public boolean m5757b(String str) {
        return this.f2964b.m5492a(str);
    }

    public C0476r m5758c() {
        return this.f2963a.m5515i();
    }

    public void close() {
        this.f2963a.close();
        this.f2963a = null;
        this.f2964b = null;
    }

    public void m5759d() {
        this.f2964b.mo930c();
    }

    public void m5760e() {
        this.f2964b.m5700d();
    }

    public void m5761f() {
        this.f2964b.m5701e();
    }

    public C0469g m5762g() {
        return this.f2964b;
    }

    public long m5763h() {
        return this.f2963a.m5514h();
    }
}
