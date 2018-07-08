package io.realm.internal;

public class C0469g extends Group {
    private final SharedGroup f2945c;

    public C0469g(C0465c c0465c, SharedGroup sharedGroup, long j) {
        super(c0465c, j, true);
        this.f2945c = sharedGroup;
    }

    private void m5696g() {
        if (m5491a() || this.f2945c.m5512f()) {
            throw new IllegalStateException("Cannot use ImplicitTransaction after it or its parent has been closed.");
        }
    }

    public void m5697a(C0476r c0476r) {
        m5696g();
        this.f2945c.m5507a(c0476r);
    }

    public void mo929b() {
        m5696g();
        this.f2945c.m5506a();
    }

    public void mo930c() {
        m5696g();
        if (this.b) {
            this.b = false;
            this.f2945c.m5508b();
            return;
        }
        throw new IllegalStateException("Nested transactions are not allowed. Use commitTransaction() after each beginTransaction().");
    }

    public void m5700d() {
        m5696g();
        if (this.b) {
            throw new IllegalStateException("Not inside a transaction.");
        }
        this.f2945c.m5509c();
        this.b = true;
    }

    public void m5701e() {
        m5696g();
        if (this.b) {
            throw new IllegalStateException("Not inside a transaction.");
        }
        this.f2945c.m5510d();
        this.b = true;
    }

    public String m5702f() {
        return this.f2945c.m5513g();
    }

    protected void finalize() {
    }
}
