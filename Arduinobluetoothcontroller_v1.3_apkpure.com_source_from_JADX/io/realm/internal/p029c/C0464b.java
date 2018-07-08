package io.realm.internal.p029c;

import io.realm.C0391z;
import io.realm.C0483m;
import io.realm.internal.C0420n;
import io.realm.internal.C0428b;
import io.realm.internal.C0469g;
import io.realm.internal.Table;
import io.realm.internal.Util;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C0464b extends C0420n {
    private final C0420n f2934a;
    private final Set f2935b;

    public C0464b(C0420n c0420n, Collection collection) {
        this.f2934a = c0420n;
        Set hashSet = new HashSet();
        if (c0420n != null) {
            Set a = c0420n.mo879a();
            for (Class cls : collection) {
                if (a.contains(cls)) {
                    hashSet.add(cls);
                }
            }
        }
        this.f2935b = Collections.unmodifiableSet(hashSet);
    }

    private void m5677d(Class cls) {
        if (!this.f2935b.contains(cls)) {
            throw new IllegalArgumentException(cls.getSimpleName() + " is not part of the schema for this Realm");
        }
    }

    public Table mo875a(Class cls, C0469g c0469g) {
        m5677d(cls);
        return this.f2934a.mo875a(cls, c0469g);
    }

    public C0391z mo876a(C0483m c0483m, C0391z c0391z, boolean z, Map map) {
        m5677d(Util.m5625a(c0391z.getClass()));
        return this.f2934a.mo876a(c0483m, c0391z, z, map);
    }

    public C0391z mo877a(Class cls, C0428b c0428b) {
        m5677d(cls);
        return this.f2934a.mo877a(cls, c0428b);
    }

    public String mo878a(Class cls) {
        m5677d(cls);
        return this.f2934a.mo878a(cls);
    }

    public Set mo879a() {
        return this.f2935b;
    }

    public C0428b mo880b(Class cls, C0469g c0469g) {
        m5677d(cls);
        return this.f2934a.mo880b(cls, c0469g);
    }

    public boolean mo881b() {
        return this.f2934a == null ? true : this.f2934a.mo881b();
    }
}
