package io.realm;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

final class C0431c implements C0429q {
    final /* synthetic */ C0490u f2845a;
    final /* synthetic */ AtomicBoolean f2846b;
    final /* synthetic */ C0394y f2847c;
    final /* synthetic */ C0432d f2848d;

    C0431c(C0490u c0490u, AtomicBoolean atomicBoolean, C0394y c0394y, C0432d c0432d) {
        this.f2845a = c0490u;
        this.f2846b = atomicBoolean;
        this.f2847c = c0394y;
        this.f2848d = c0432d;
    }

    public void mo883a(int i) {
        if (i != 0) {
            throw new IllegalStateException("Cannot migrate a Realm file that is already open: " + this.f2845a.m5836i());
        } else if (new File(this.f2845a.m5836i()).exists()) {
            C0394y e = this.f2847c == null ? this.f2845a.m5832e() : this.f2847c;
            C0435h c0435h = null;
            try {
                c0435h = C0435h.m5476b(this.f2845a);
                c0435h.mo885b();
                e.mo866a(c0435h, c0435h.mo891h(), this.f2845a.m5831d());
                c0435h.m5362a(this.f2845a.m5831d());
                c0435h.mo886c();
                if (c0435h != null) {
                    c0435h.close();
                    this.f2848d.mo932a();
                }
            } catch (RuntimeException e2) {
                if (c0435h != null) {
                    c0435h.mo888d();
                }
                throw e2;
            } catch (Throwable th) {
                if (c0435h != null) {
                    c0435h.close();
                    this.f2848d.mo932a();
                }
            }
        } else {
            this.f2846b.set(true);
        }
    }
}
