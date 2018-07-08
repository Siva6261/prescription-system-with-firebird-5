package android.support.v4.p015h;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class C0175j implements Set {
    final /* synthetic */ C0167h f882a;

    C0175j(C0167h c0167h) {
        this.f882a = c0167h;
    }

    public boolean m1560a(Entry entry) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean add(Object obj) {
        return m1560a((Entry) obj);
    }

    public boolean addAll(Collection collection) {
        int a = this.f882a.mo240a();
        for (Entry entry : collection) {
            this.f882a.mo245a(entry.getKey(), entry.getValue());
        }
        return a != this.f882a.mo240a();
    }

    public void clear() {
        this.f882a.mo248c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f882a.mo241a(entry.getKey());
        return a >= 0 ? C0169c.m1537a(this.f882a.mo242a(a, 1), entry.getValue()) : false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return C0167h.m1508a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f882a.mo240a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f882a.mo242a(a, 0);
            Object a3 = this.f882a.mo242a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f882a.mo240a() == 0;
    }

    public Iterator iterator() {
        return new C0177l(this.f882a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f882a.mo240a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object[] objArr) {
        throw new UnsupportedOperationException();
    }
}
