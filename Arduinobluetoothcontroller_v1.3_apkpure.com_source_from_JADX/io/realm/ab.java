package io.realm;

import io.realm.internal.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class ab implements Map {
    private final Table f2799a;

    public ab(Table table) {
        this.f2799a = table;
    }

    public Long m5389a(Object obj) {
        return Long.valueOf(this.f2799a.m5536a((String) obj));
    }

    public Long m5390a(String str, Long l) {
        throw new UnsupportedOperationException();
    }

    public Long m5391b(Object obj) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Set entrySet() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object get(Object obj) {
        return m5389a(obj);
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m5390a((String) obj, (Long) obj2);
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object remove(Object obj) {
        return m5391b(obj);
    }

    public int size() {
        throw new UnsupportedOperationException();
    }

    public Collection values() {
        throw new UnsupportedOperationException();
    }
}
