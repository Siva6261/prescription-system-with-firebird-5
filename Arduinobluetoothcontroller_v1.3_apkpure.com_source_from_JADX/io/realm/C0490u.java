package io.realm;

import io.realm.exceptions.RealmException;
import io.realm.internal.C0420n;
import io.realm.internal.C0475q;
import io.realm.internal.p029c.C0463a;
import io.realm.internal.p029c.C0464b;
import io.realm.p026a.C0421e;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class C0490u {
    private static final Object f2997a = C0483m.m5794m();
    private static final C0420n f2998b;
    private static Boolean f2999c;
    private final File f3000d;
    private final String f3001e;
    private final String f3002f;
    private final byte[] f3003g;
    private final long f3004h;
    private final C0394y f3005i;
    private final boolean f3006j;
    private final C0475q f3007k;
    private final C0420n f3008l;
    private final C0421e f3009m;

    static {
        if (f2997a != null) {
            C0420n a = C0490u.m5824a(f2997a.getClass().getCanonicalName());
            if (a.mo881b()) {
                f2998b = a;
                return;
            }
            throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
        }
        f2998b = null;
    }

    private C0490u(C0492w c0492w) {
        this.f3000d = c0492w.f3010a;
        this.f3001e = c0492w.f3011b;
        this.f3002f = C0483m.m5784a(new File(this.f3000d, this.f3001e));
        this.f3003g = c0492w.f3012c;
        this.f3004h = c0492w.f3013d;
        this.f3006j = c0492w.f3015f;
        this.f3005i = c0492w.f3014e;
        this.f3007k = c0492w.f3016g;
        this.f3008l = m5823a(c0492w);
        this.f3009m = c0492w.f3019j;
    }

    private C0420n m5823a(C0492w c0492w) {
        Set<Object> i = c0492w.f3017h;
        Collection j = c0492w.f3018i;
        if (j.size() > 0) {
            return new C0464b(f2998b, j);
        }
        if (i.size() == 1) {
            return C0490u.m5824a(i.iterator().next().getClass().getCanonicalName());
        }
        C0420n[] c0420nArr = new C0420n[i.size()];
        int i2 = 0;
        for (Object obj : i) {
            c0420nArr[i2] = C0490u.m5824a(obj.getClass().getCanonicalName());
            i2++;
        }
        return new C0463a(c0420nArr);
    }

    private static C0420n m5824a(String str) {
        String[] split = str.split("\\.");
        Object obj = split[split.length - 1];
        String format = String.format("io.realm.%s%s", new Object[]{obj, "Mediator"});
        try {
            Constructor constructor = Class.forName(format).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (C0420n) constructor.newInstance(new Object[0]);
        } catch (Throwable e) {
            throw new RealmException("Could not find " + format, e);
        } catch (Throwable e2) {
            throw new RealmException("Could not create an instance of " + format, e2);
        } catch (Throwable e22) {
            throw new RealmException("Could not create an instance of " + format, e22);
        } catch (Throwable e222) {
            throw new RealmException("Could not create an instance of " + format, e222);
        }
    }

    private static synchronized boolean m5827l() {
        boolean booleanValue;
        synchronized (C0490u.class) {
            if (f2999c == null) {
                try {
                    Class.forName("rx.Observable");
                    f2999c = Boolean.valueOf(true);
                } catch (ClassNotFoundException e) {
                    f2999c = Boolean.valueOf(false);
                }
            }
            booleanValue = f2999c.booleanValue();
        }
        return booleanValue;
    }

    public File m5828a() {
        return this.f3000d;
    }

    public String m5829b() {
        return this.f3001e;
    }

    public byte[] m5830c() {
        return this.f3003g == null ? null : Arrays.copyOf(this.f3003g, this.f3003g.length);
    }

    public long m5831d() {
        return this.f3004h;
    }

    public C0394y m5832e() {
        return this.f3005i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0490u c0490u = (C0490u) obj;
        if (this.f3004h != c0490u.f3004h || this.f3006j != c0490u.f3006j || !this.f3000d.equals(c0490u.f3000d) || !this.f3001e.equals(c0490u.f3001e) || !this.f3002f.equals(c0490u.f3002f) || !Arrays.equals(this.f3003g, c0490u.f3003g) || !this.f3007k.equals(c0490u.f3007k)) {
            return false;
        }
        if (this.f3005i != null) {
            if (!this.f3005i.equals(c0490u.f3005i)) {
                return false;
            }
        } else if (c0490u.f3005i != null) {
            return false;
        }
        if (this.f3009m != null) {
            if (!this.f3009m.equals(c0490u.f3009m)) {
                return false;
            }
        } else if (c0490u.f3009m != null) {
            return false;
        }
        return this.f3008l.equals(c0490u.f3008l);
    }

    public boolean m5833f() {
        return this.f3006j;
    }

    public C0475q m5834g() {
        return this.f3007k;
    }

    C0420n m5835h() {
        return this.f3008l;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f3006j ? 1 : 0) + (((this.f3005i != null ? this.f3005i.hashCode() : 0) + (((((this.f3003g != null ? Arrays.hashCode(this.f3003g) : 0) + (((((this.f3000d.hashCode() * 31) + this.f3001e.hashCode()) * 31) + this.f3002f.hashCode()) * 31)) * 31) + ((int) this.f3004h)) * 31)) * 31)) * 31) + this.f3008l.hashCode()) * 31) + this.f3007k.hashCode()) * 31;
        if (this.f3009m != null) {
            i = this.f3009m.hashCode();
        }
        return hashCode + i;
    }

    public String m5836i() {
        return this.f3002f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("realmFolder: ").append(this.f3000d.toString());
        stringBuilder.append("\n");
        stringBuilder.append("realmFileName : ").append(this.f3001e);
        stringBuilder.append("\n");
        stringBuilder.append("canonicalPath: ").append(this.f3002f);
        stringBuilder.append("\n");
        stringBuilder.append("key: ").append("[length: ").append(this.f3003g == null ? 0 : 64).append("]");
        stringBuilder.append("\n");
        stringBuilder.append("schemaVersion: ").append(Long.toString(this.f3004h));
        stringBuilder.append("\n");
        stringBuilder.append("migration: ").append(this.f3005i);
        stringBuilder.append("\n");
        stringBuilder.append("deleteRealmIfMigrationNeeded: ").append(this.f3006j);
        stringBuilder.append("\n");
        stringBuilder.append("durability: ").append(this.f3007k);
        stringBuilder.append("\n");
        stringBuilder.append("schemaMediator: ").append(this.f3008l);
        return stringBuilder.toString();
    }
}
