package io.realm;

import io.realm.internal.C0445a;
import io.realm.internal.p027b.C0462b;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

class C0485o {
    private static Map f2987d = new HashMap();
    private final EnumMap f2988a = new EnumMap(C0487r.class);
    private final C0490u f2989b;
    private C0445a f2990c;

    private C0485o(C0490u c0490u) {
        this.f2989b = c0490u;
        for (Enum put : C0487r.values()) {
            this.f2988a.put(put, new C0488s());
        }
    }

    static synchronized C0426a m5812a(C0490u c0490u, Class cls) {
        C0426a c0426a;
        synchronized (C0485o.class) {
            C0485o c0485o;
            Object obj = 1;
            C0485o c0485o2 = (C0485o) f2987d.get(c0490u.m5836i());
            if (c0485o2 == null) {
                c0485o = new C0485o(c0490u);
                obj = null;
            } else {
                c0485o2.m5814a(c0490u);
                c0485o = c0485o2;
            }
            C0488s c0488s = (C0488s) c0485o.f2988a.get(C0487r.m5816a(cls));
            if (c0488s.f2994a.get() == null) {
                Object a;
                if (cls == C0483m.class) {
                    a = C0483m.m5782a(c0490u, c0485o.f2990c);
                } else if (cls == C0435h.class) {
                    a = C0435h.m5477c(c0490u);
                } else {
                    throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
                }
                if (obj == null) {
                    f2987d.put(c0490u.m5836i(), c0485o);
                }
                c0488s.f2994a.set(a);
                c0488s.f2995b.set(Integer.valueOf(0));
            }
            Integer num = (Integer) c0488s.f2995b.get();
            if (num.intValue() == 0) {
                if (cls == C0483m.class && c0488s.f2996c == 0) {
                    c0485o.f2990c = ((C0426a) c0488s.f2994a.get()).f2790g.f2825a;
                }
                c0488s.f2996c = c0488s.f2996c + 1;
            }
            c0488s.f2995b.set(Integer.valueOf(num.intValue() + 1));
            c0426a = (C0426a) c0488s.f2994a.get();
        }
        return c0426a;
    }

    static synchronized void m5813a(C0426a c0426a) {
        int i = 0;
        Integer num = null;
        synchronized (C0485o.class) {
            C0488s c0488s;
            String f = c0426a.mo889f();
            C0485o c0485o = (C0485o) f2987d.get(f);
            if (c0485o != null) {
                C0488s c0488s2 = (C0488s) c0485o.f2988a.get(C0487r.m5816a(c0426a.getClass()));
                C0488s c0488s3 = c0488s2;
                num = (Integer) c0488s2.f2995b.get();
                c0488s = c0488s3;
            } else {
                c0488s = null;
            }
            if (num == null) {
                num = Integer.valueOf(0);
            }
            if (num.intValue() <= 0) {
                C0462b.m5668b("Realm " + f + " has been closed already.");
            } else {
                num = Integer.valueOf(num.intValue() - 1);
                if (num.intValue() == 0) {
                    c0488s.f2995b.set(null);
                    c0488s.f2994a.set(null);
                    c0488s.f2996c = c0488s.f2996c - 1;
                    if (c0488s.f2996c < 0) {
                        throw new IllegalStateException("Global reference counter of Realm" + f + " got corrupted.");
                    }
                    if ((c0426a instanceof C0483m) && c0488s.f2996c == 0) {
                        c0485o.f2990c = null;
                    }
                    for (Object obj : C0487r.values()) {
                        i += ((C0488s) c0485o.f2988a.get(obj)).f2996c;
                    }
                    if (i == 0) {
                        f2987d.remove(f);
                    }
                    c0426a.m5372i();
                } else {
                    c0488s.f2995b.set(num);
                }
            }
        }
    }

    private void m5814a(C0490u c0490u) {
        if (!this.f2989b.equals(c0490u)) {
            if (Arrays.equals(this.f2989b.m5830c(), c0490u.m5830c())) {
                throw new IllegalArgumentException("Configurations cannot be different if used to open the same file. \nCached configuration: \n" + this.f2989b + "\n\nNew configuration: \n" + c0490u);
            }
            throw new IllegalArgumentException("Wrong key used to decrypt Realm.");
        }
    }

    static synchronized void m5815a(C0490u c0490u, C0429q c0429q) {
        synchronized (C0485o.class) {
            C0485o c0485o = (C0485o) f2987d.get(c0490u.m5836i());
            if (c0485o == null) {
                c0429q.mo883a(0);
            } else {
                int i = 0;
                for (Object obj : C0487r.values()) {
                    i += ((C0488s) c0485o.f2988a.get(obj)).f2996c;
                }
                c0429q.mo883a(i);
            }
        }
    }
}
