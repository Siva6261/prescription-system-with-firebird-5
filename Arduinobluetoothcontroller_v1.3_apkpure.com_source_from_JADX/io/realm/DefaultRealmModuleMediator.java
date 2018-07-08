package io.realm;

import com.giumig.apps.bluetoothcontroller.p025d.C0393a;
import com.giumig.apps.bluetoothcontroller.p025d.C0396c;
import io.realm.annotations.RealmModule;
import io.realm.internal.C0420n;
import io.realm.internal.C0427m;
import io.realm.internal.C0428b;
import io.realm.internal.C0469g;
import io.realm.internal.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RealmModule
class DefaultRealmModuleMediator extends C0420n {
    private static final Set f2778a;

    static {
        Set hashSet = new HashSet();
        hashSet.add(C0396c.class);
        hashSet.add(C0393a.class);
        f2778a = Collections.unmodifiableSet(hashSet);
    }

    DefaultRealmModuleMediator() {
    }

    public Table mo875a(Class cls, C0469g c0469g) {
        C0420n.m5339b(cls);
        if (cls.equals(C0396c.class)) {
            return aj.m5425a(c0469g);
        }
        if (cls.equals(C0393a.class)) {
            return C0433e.m5446a(c0469g);
        }
        throw C0420n.m5340c(cls);
    }

    public C0391z mo876a(C0483m c0483m, C0391z c0391z, boolean z, Map map) {
        Class superclass = c0391z instanceof C0427m ? c0391z.getClass().getSuperclass() : c0391z.getClass();
        if (superclass.equals(C0396c.class)) {
            return (C0391z) superclass.cast(aj.m5424a(c0483m, (C0396c) c0391z, z, map));
        }
        if (superclass.equals(C0393a.class)) {
            return (C0391z) superclass.cast(C0433e.m5445a(c0483m, (C0393a) c0391z, z, map));
        }
        throw C0420n.m5340c(superclass);
    }

    public C0391z mo877a(Class cls, C0428b c0428b) {
        C0420n.m5339b(cls);
        if (cls.equals(C0396c.class)) {
            return (C0391z) cls.cast(new aj(c0428b));
        }
        if (cls.equals(C0393a.class)) {
            return (C0391z) cls.cast(new C0433e(c0428b));
        }
        throw C0420n.m5340c(cls);
    }

    public String mo878a(Class cls) {
        C0420n.m5339b(cls);
        if (cls.equals(C0396c.class)) {
            return aj.m5428h();
        }
        if (cls.equals(C0393a.class)) {
            return C0433e.m5449y();
        }
        throw C0420n.m5340c(cls);
    }

    public Set mo879a() {
        return f2778a;
    }

    public C0428b mo880b(Class cls, C0469g c0469g) {
        C0420n.m5339b(cls);
        if (cls.equals(C0396c.class)) {
            return aj.m5427b(c0469g);
        }
        if (cls.equals(C0393a.class)) {
            return C0433e.m5448b(c0469g);
        }
        throw C0420n.m5340c(cls);
    }

    public boolean mo881b() {
        return true;
    }
}
