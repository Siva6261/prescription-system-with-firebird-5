package io.realm;

import android.os.Handler;
import android.os.Looper;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.C0439o;
import io.realm.internal.C0477s;
import io.realm.internal.Table;
import io.realm.internal.async.C0461p;
import io.realm.internal.p027b.C0462b;
import io.realm.internal.p028a.C0444d;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class C0426a implements Closeable {
    protected static final Map f2784a = new ConcurrentHashMap();
    static final C0461p f2785b = C0461p.m5664a();
    final long f2786c = Thread.currentThread().getId();
    protected C0490u f2787d;
    protected C0477s f2788e;
    protected boolean f2789f;
    ah f2790g;
    Handler f2791h;
    C0482l f2792i;

    static {
        C0462b.m5665a(new C0444d());
    }

    protected C0426a(C0490u c0490u, boolean z) {
        this.f2787d = c0490u;
        this.f2788e = new C0477s(c0490u);
        this.f2790g = new ah(this, this.f2788e.m5762g());
        mo884a(z);
    }

    protected static void m5357a(C0490u c0490u, C0394y c0394y, C0432d c0432d) {
        if (c0490u == null) {
            throw new IllegalArgumentException("RealmConfiguration must be provided");
        } else if (c0394y == null && c0490u.m5832e() == null) {
            throw new RealmMigrationNeededException(c0490u.m5836i(), "RealmMigration must be provided");
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            C0485o.m5815a(c0490u, new C0431c(c0490u, atomicBoolean, c0394y, c0432d));
            if (atomicBoolean.get()) {
                throw new FileNotFoundException("Cannot migrate a Realm file which doesn't exist: " + c0490u.m5836i());
            }
        }
    }

    static boolean m5358a(C0490u c0490u) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        C0485o.m5815a(c0490u, new C0430b(c0490u, atomicBoolean));
        return atomicBoolean.get();
    }

    C0391z m5359a(Class cls, long j) {
        C0439o h = this.f2790g.m5419b(cls).m5555h(j);
        C0391z a = this.f2787d.m5835h().mo877a(cls, this.f2790g.m5418a(cls));
        a.f2728a = h;
        a.f2729b = this;
        a.m5230B();
        if (this.f2792i != null) {
            this.f2792i.m5778a(a);
        }
        return a;
    }

    C0391z m5360a(Class cls, String str, long j) {
        Table b;
        C0391z c0436i;
        if (str != null) {
            b = this.f2790g.m5420b(str);
            c0436i = new C0436i();
        } else {
            b = this.f2790g.m5419b(cls);
            c0436i = this.f2787d.m5835h().mo877a(cls, this.f2790g.m5418a(cls));
        }
        c0436i.f2728a = b.m5555h(j);
        c0436i.f2729b = this;
        c0436i.m5230B();
        if (this.f2792i != null) {
            this.f2792i.m5778a(c0436i);
        }
        return c0436i;
    }

    protected void m5361a() {
        f2784a.remove(this.f2791h);
        this.f2791h.removeCallbacksAndMessages(null);
        this.f2791h = null;
    }

    void m5362a(long j) {
        Table a = this.f2788e.m5753a("metadata");
        if (a.m5545c() == 0) {
            a.m5533a(RealmFieldType.INTEGER, "version");
            a.m5547d();
        }
        a.m5542b(0, 0, j);
    }

    public void mo884a(boolean z) {
        m5368e();
        if (z && Looper.myLooper() == null) {
            throw new IllegalStateException("Cannot set auto-refresh in a Thread without a Looper");
        }
        if (z && !this.f2789f) {
            this.f2792i = new C0482l(this);
            this.f2791h = new Handler(this.f2792i);
            f2784a.put(this.f2791h, this.f2787d.m5836i());
        } else if (!(z || !this.f2789f || this.f2791h == null)) {
            m5361a();
        }
        this.f2789f = z;
    }

    void m5364a(boolean z, Runnable runnable) {
        m5368e();
        this.f2788e.m5760e();
        if (runnable != null) {
            runnable.run();
        }
        for (Entry entry : f2784a.entrySet()) {
            Handler handler = (Handler) entry.getKey();
            String str = (String) entry.getValue();
            if ((z || !handler.equals(this.f2791h)) && str.equals(this.f2787d.m5836i()) && !handler.hasMessages(14930352) && handler.getLooper().getThread().isAlive() && !handler.sendEmptyMessage(14930352)) {
                C0462b.m5668b("Cannot update Looper threads when the Looper has quit. Use realm.setAutoRefresh(false) to prevent this.");
            }
        }
    }

    public void mo885b() {
        m5368e();
        this.f2788e.m5759d();
    }

    public void mo886c() {
        m5364a(true, null);
    }

    public void close() {
        if (this.f2786c != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.");
        }
        C0485o.m5813a(this);
    }

    public void mo888d() {
        m5368e();
        this.f2788e.m5761f();
    }

    protected void m5368e() {
        if (this.f2788e == null || !this.f2788e.m5755a()) {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        } else if (this.f2786c != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
        }
    }

    public String mo889f() {
        return this.f2787d.m5836i();
    }

    public C0490u mo890g() {
        return this.f2787d;
    }

    public long mo891h() {
        return !this.f2788e.m5757b("metadata") ? -1 : this.f2788e.m5753a("metadata").m5531a(0, 0);
    }

    void m5372i() {
        if (this.f2788e != null) {
            this.f2788e.close();
            this.f2788e = null;
        }
        if (this.f2791h != null) {
            m5361a();
        }
    }

    public boolean mo892j() {
        if (this.f2786c == Thread.currentThread().getId()) {
            return this.f2788e == null || !this.f2788e.m5755a();
        } else {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
        }
    }

    public ah mo893k() {
        return this.f2790g;
    }
}
