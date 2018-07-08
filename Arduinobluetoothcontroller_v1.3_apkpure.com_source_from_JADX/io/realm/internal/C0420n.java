package io.realm.internal;

import io.realm.C0391z;
import io.realm.C0483m;
import io.realm.exceptions.RealmException;
import java.util.Map;
import java.util.Set;

public abstract class C0420n {
    protected static void m5339b(Class cls) {
        if (cls == null) {
            throw new NullPointerException("A class extending RealmObject must be provided");
        }
    }

    protected static RealmException m5340c(Class cls) {
        return new RealmException(cls + " is not part of the schema for this Realm.");
    }

    public abstract Table mo875a(Class cls, C0469g c0469g);

    public abstract C0391z mo876a(C0483m c0483m, C0391z c0391z, boolean z, Map map);

    public abstract C0391z mo877a(Class cls, C0428b c0428b);

    public abstract String mo878a(Class cls);

    public abstract Set mo879a();

    public abstract C0428b mo880b(Class cls, C0469g c0469g);

    public boolean mo881b() {
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0420n)) {
            return false;
        }
        return mo879a().equals(((C0420n) obj).mo879a());
    }

    public int hashCode() {
        return mo879a().hashCode();
    }
}
