package io.realm;

import android.os.Looper;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmIOException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.C0420n;
import io.realm.internal.C0445a;
import io.realm.internal.Table;
import io.realm.internal.Util;
import io.realm.internal.p027b.C0462b;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class C0483m extends C0426a {
    private static C0490u f2985k;
    private final Map f2986j = new HashMap();

    C0483m(C0490u c0490u, boolean z) {
        super(c0490u, z);
    }

    static C0483m m5782a(C0490u c0490u, C0445a c0445a) {
        try {
            return C0483m.m5787b(c0490u, c0445a);
        } catch (RealmMigrationNeededException e) {
            if (c0490u.m5833f()) {
                C0483m.m5791d(c0490u);
            } else {
                try {
                    C0483m.m5789c(c0490u);
                } catch (Throwable e2) {
                    throw new RealmIOException(e2);
                }
            }
            return C0483m.m5787b(c0490u, c0445a);
        }
    }

    private C0391z m5783a(C0391z c0391z, boolean z) {
        m5368e();
        return this.d.m5835h().mo876a(this, c0391z, z, new HashMap());
    }

    static String m5784a(File file) {
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            throw new RealmException("Could not resolve the canonical path to the Realm file: " + file.getAbsolutePath());
        }
    }

    private static void m5785a(C0483m c0483m) {
        boolean z;
        Throwable th;
        long h = c0483m.mo891h();
        try {
            c0483m.mo885b();
            if (h == -1) {
                z = true;
                try {
                    c0483m.m5362a(c0483m.d.m5831d());
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        c0483m.m5364a(false, null);
                    } else {
                        c0483m.mo888d();
                    }
                    throw th;
                }
            }
            z = false;
            C0420n h2 = c0483m.d.m5835h();
            Set<Class> a = h2.mo879a();
            Map hashMap = new HashMap(a.size());
            for (Class cls : a) {
                if (h == -1) {
                    h2.mo875a(cls, c0483m.e.m5762g());
                }
                hashMap.put(cls, h2.mo880b(cls, c0483m.e.m5762g()));
            }
            c0483m.g.f2825a = new C0445a(hashMap);
            if (z) {
                c0483m.m5364a(false, null);
            } else {
                c0483m.mo888d();
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            if (z) {
                c0483m.m5364a(false, null);
            } else {
                c0483m.mo888d();
            }
            throw th;
        }
    }

    public static void m5786a(C0490u c0490u, C0394y c0394y) {
        C0426a.m5357a(c0490u, c0394y, new C0484n());
    }

    static C0483m m5787b(C0490u c0490u, C0445a c0445a) {
        C0483m c0483m = new C0483m(c0490u, Looper.myLooper() != null);
        long h = c0483m.mo891h();
        long d = c0490u.m5831d();
        if (h != -1 && h < d && c0445a == null) {
            c0483m.m5372i();
            throw new RealmMigrationNeededException(c0490u.m5836i(), String.format("Realm on disk need to migrate from v%s to v%s", new Object[]{Long.valueOf(h), Long.valueOf(d)}));
        } else if (h == -1 || d >= h || c0445a != null) {
            if (c0445a == null) {
                try {
                    C0483m.m5785a(c0483m);
                } catch (RuntimeException e) {
                    c0483m.m5372i();
                    throw e;
                }
            }
            c0483m.g.f2825a = c0445a;
            return c0483m;
        } else {
            c0483m.m5372i();
            throw new IllegalArgumentException(String.format("Realm on disk is newer than the one specified: v%s vs. v%s", new Object[]{Long.valueOf(h), Long.valueOf(d)}));
        }
    }

    public static void m5788b(C0490u c0490u) {
        if (c0490u == null) {
            throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
        }
        f2985k = c0490u;
    }

    public static void m5789c(C0490u c0490u) {
        C0483m.m5786a(c0490u, null);
    }

    private void m5790c(C0391z c0391z) {
        if (c0391z == null) {
            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
        }
    }

    public static boolean m5791d(C0490u c0490u) {
        return C0426a.m5358a(c0490u);
    }

    private void m5792e(Class cls) {
        if (!m5804d(cls).m5551f()) {
            throw new IllegalArgumentException("A RealmObject with no @PrimaryKey cannot be updated: " + cls.toString());
        }
    }

    public static C0483m m5793l() {
        if (f2985k != null) {
            return (C0483m) C0485o.m5812a(f2985k, C0483m.class);
        }
        throw new NullPointerException("No default RealmConfiguration was found. Call setDefaultConfiguration() first");
    }

    public static Object m5794m() {
        String str = "io.realm.DefaultRealmModule";
        try {
            Constructor constructor = Class.forName(str).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (Throwable e2) {
            throw new RealmException("Could not create an instance of " + str, e2);
        } catch (Throwable e22) {
            throw new RealmException("Could not create an instance of " + str, e22);
        } catch (Throwable e222) {
            throw new RealmException("Could not create an instance of " + str, e222);
        }
    }

    public C0391z m5795a(C0391z c0391z) {
        m5790c(c0391z);
        return m5783a(c0391z, false);
    }

    public C0391z m5796a(Class cls) {
        m5368e();
        return m5359a(cls, m5804d(cls).m5547d());
    }

    C0391z m5797a(Class cls, Object obj) {
        return m5359a(cls, m5804d(cls).m5535a(obj));
    }

    public ad m5799b(Class cls) {
        m5368e();
        return ad.m5392a(this, cls);
    }

    public C0391z m5800b(C0391z c0391z) {
        m5790c(c0391z);
        m5792e(c0391z.getClass());
        return m5783a(c0391z, true);
    }

    public /* bridge */ /* synthetic */ void mo885b() {
        super.mo885b();
    }

    public ae m5802c(Class cls) {
        return m5799b(cls).m5396a();
    }

    public /* bridge */ /* synthetic */ void mo886c() {
        super.mo886c();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Deprecated
    public Table m5804d(Class cls) {
        Table table = (Table) this.f2986j.get(cls);
        if (table != null) {
            return table;
        }
        Class a = Util.m5625a(cls);
        table = this.e.m5753a(this.d.m5835h().mo878a(a));
        this.f2986j.put(a, table);
        return table;
    }

    public /* bridge */ /* synthetic */ void mo888d() {
        super.mo888d();
    }

    public /* bridge */ /* synthetic */ String mo889f() {
        return super.mo889f();
    }

    protected void finalize() {
        if (this.e != null && this.e.m5755a()) {
            C0462b.m5668b("Remember to call close() on all Realm instances. Realm " + this.d.m5836i() + " is being finalized without being closed, " + "this can lead to running out of native memory.");
        }
        super.finalize();
    }

    public /* bridge */ /* synthetic */ C0490u mo890g() {
        return super.mo890g();
    }

    public /* bridge */ /* synthetic */ long mo891h() {
        return super.mo891h();
    }

    public /* bridge */ /* synthetic */ boolean mo892j() {
        return super.mo892j();
    }

    public /* bridge */ /* synthetic */ ah mo893k() {
        return super.mo893k();
    }
}
