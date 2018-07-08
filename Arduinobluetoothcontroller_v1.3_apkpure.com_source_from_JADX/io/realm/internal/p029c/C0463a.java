package io.realm.internal.p029c;

import io.realm.C0391z;
import io.realm.C0483m;
import io.realm.internal.C0420n;
import io.realm.internal.C0428b;
import io.realm.internal.C0469g;
import io.realm.internal.Table;
import io.realm.internal.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C0463a extends C0420n {
    private final Map f2933a;

    public C0463a(C0420n... c0420nArr) {
        Map hashMap = new HashMap();
        if (c0420nArr != null) {
            for (C0420n c0420n : c0420nArr) {
                for (Class put : c0420n.mo879a()) {
                    hashMap.put(put, c0420n);
                }
            }
        }
        this.f2933a = Collections.unmodifiableMap(hashMap);
    }

    private C0420n m5669d(Class cls) {
        C0420n c0420n = (C0420n) this.f2933a.get(cls);
        if (c0420n != null) {
            return c0420n;
        }
        throw new IllegalArgumentException(cls.getSimpleName() + " is not part of the schema for this Realm");
    }

    public Table mo875a(Class cls, C0469g c0469g) {
        return m5669d(cls).mo875a(cls, c0469g);
    }

    public C0391z mo876a(C0483m c0483m, C0391z c0391z, boolean z, Map map) {
        return m5669d(Util.m5625a(c0391z.getClass())).mo876a(c0483m, c0391z, z, map);
    }

    public C0391z mo877a(Class cls, C0428b c0428b) {
        return m5669d(cls).mo877a(cls, c0428b);
    }

    public String mo878a(Class cls) {
        return m5669d(cls).mo878a(cls);
    }

    public Set mo879a() {
        return this.f2933a.keySet();
    }

    public C0428b mo880b(Class cls, C0469g c0469g) {
        return m5669d(cls).mo880b(cls, c0469g);
    }

    public boolean mo881b() {
        for (Entry value : this.f2933a.entrySet()) {
            if (!((C0420n) value.getValue()).mo881b()) {
                return false;
            }
        }
        return true;
    }
}
