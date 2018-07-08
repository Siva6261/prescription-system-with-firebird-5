package io.realm;

import io.realm.internal.C0428b;
import io.realm.internal.C0445a;
import io.realm.internal.C0469g;
import io.realm.internal.Table;
import io.realm.internal.Util;
import java.util.HashMap;
import java.util.Map;

public final class ah {
    private static final String f2824b = Table.f2878a;
    C0445a f2825a;
    private final Map f2826c = new HashMap();
    private final Map f2827d = new HashMap();
    private final Map f2828e = new HashMap();
    private final Map f2829f = new HashMap();
    private final C0469g f2830g;
    private final C0426a f2831h;

    ah(C0426a c0426a, C0469g c0469g) {
        this.f2831h = c0426a;
        this.f2830g = c0469g;
    }

    static String m5415a(Table table) {
        return table.m5561k().substring(Table.f2878a.length());
    }

    private void m5416a(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(str2);
        }
    }

    public aa m5417a(String str) {
        m5416a(str, "Null or empty class names are not allowed");
        String str2 = f2824b + str;
        if (str2.length() > 56) {
            throw new IllegalArgumentException("Class name is to long. Limit is 57 characters: " + str.length());
        } else if (this.f2830g.m5492a(str2)) {
            throw new IllegalArgumentException("Class already exists: " + str);
        } else {
            Table b = this.f2830g.m5493b(str2);
            return new aa(this.f2831h, b, new ab(b));
        }
    }

    C0428b m5418a(Class cls) {
        C0428b a = this.f2825a.m5644a(cls);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("No validated schema information found for " + this.f2831h.f2787d.m5835h().mo878a(cls));
    }

    Table m5419b(Class cls) {
        Table table = (Table) this.f2827d.get(cls);
        if (table != null) {
            return table;
        }
        Class a = Util.m5625a(cls);
        table = this.f2830g.m5493b(this.f2831h.f2787d.m5835h().mo878a(a));
        this.f2827d.put(a, table);
        return table;
    }

    Table m5420b(String str) {
        String str2 = Table.f2878a + str;
        Table table = (Table) this.f2826c.get(str2);
        if (table != null) {
            return table;
        }
        if (this.f2830g.m5492a(str2)) {
            table = this.f2830g.m5493b(str2);
            this.f2826c.put(str2, table);
            return table;
        }
        throw new IllegalArgumentException("The class " + str2 + " doesn't exist in this Realm.");
    }

    aa m5421c(Class cls) {
        aa aaVar = (aa) this.f2828e.get(cls);
        if (aaVar != null) {
            return aaVar;
        }
        Class a = Util.m5625a(cls);
        aaVar = new aa(this.f2831h, this.f2830g.m5493b(this.f2831h.f2787d.m5835h().mo878a(a)), this.f2825a.m5644a(a).m5438a());
        this.f2828e.put(a, aaVar);
        return aaVar;
    }
}
