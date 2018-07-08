package android.support.v7.widget;

import java.util.ArrayList;
import java.util.List;

public abstract class eb {
    private ed f2065a = null;
    private ArrayList f2066b = new ArrayList();
    private long f2067c = 120;
    private long f2068d = 120;
    private long f2069e = 250;
    private long f2070f = 250;

    static int m4254d(ey eyVar) {
        int f = eyVar.f2267l & 14;
        if (eyVar.m4657n()) {
            return 4;
        }
        if ((f & 4) != 0) {
            return f;
        }
        int f2 = eyVar.m4649f();
        int e = eyVar.m4648e();
        return (f2 == -1 || e == -1 || f2 == e) ? f : f | 2048;
    }

    public ee m4255a(ev evVar, ey eyVar) {
        return m4275i().m4503a(eyVar);
    }

    public ee m4256a(ev evVar, ey eyVar, int i, List list) {
        return m4275i().m4503a(eyVar);
    }

    public abstract void mo715a();

    void m4258a(ed edVar) {
        this.f2065a = edVar;
    }

    public abstract boolean mo710a(ey eyVar, ee eeVar, ee eeVar2);

    public abstract boolean mo711a(ey eyVar, ey eyVar2, ee eeVar, ee eeVar2);

    public boolean mo719a(ey eyVar, List list) {
        return mo714g(eyVar);
    }

    public abstract boolean mo720b();

    public abstract boolean mo712b(ey eyVar, ee eeVar, ee eeVar2);

    public abstract void mo722c();

    public abstract void mo723c(ey eyVar);

    public abstract boolean mo713c(ey eyVar, ee eeVar, ee eeVar2);

    public long m4267d() {
        return this.f2069e;
    }

    public long m4268e() {
        return this.f2067c;
    }

    public final void m4269e(ey eyVar) {
        m4271f(eyVar);
        if (this.f2065a != null) {
            this.f2065a.mo766a(eyVar);
        }
    }

    public long m4270f() {
        return this.f2068d;
    }

    public void m4271f(ey eyVar) {
    }

    public long m4272g() {
        return this.f2070f;
    }

    public boolean mo714g(ey eyVar) {
        return true;
    }

    public final void m4274h() {
        int size = this.f2066b.size();
        for (int i = 0; i < size; i++) {
            ((ec) this.f2066b.get(i)).m4501a();
        }
        this.f2066b.clear();
    }

    public ee m4275i() {
        return new ee();
    }
}
