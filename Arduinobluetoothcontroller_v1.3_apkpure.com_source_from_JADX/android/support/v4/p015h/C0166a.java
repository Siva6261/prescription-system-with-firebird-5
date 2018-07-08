package android.support.v4.p015h;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C0166a extends C0165q implements Map {
    C0167h f854a;

    public C0166a(int i) {
        super(i);
    }

    private C0167h m1505b() {
        if (this.f854a == null) {
            this.f854a = new C0168b(this);
        }
        return this.f854a;
    }

    public boolean m1506a(Collection collection) {
        return C0167h.m1510c(this, collection);
    }

    public Set entrySet() {
        return m1505b().m1522d();
    }

    public Set keySet() {
        return m1505b().m1523e();
    }

    public void putAll(Map map) {
        m1500a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection values() {
        return m1505b().m1524f();
    }
}
