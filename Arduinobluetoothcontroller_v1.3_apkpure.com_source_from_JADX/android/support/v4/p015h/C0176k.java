package android.support.v4.p015h;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class C0176k implements Set {
    final /* synthetic */ C0167h f883a;

    C0176k(C0167h c0167h) {
        this.f883a = c0167h;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f883a.mo248c();
    }

    public boolean contains(Object obj) {
        return this.f883a.mo241a(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        return C0167h.m1507a(this.f883a.mo247b(), collection);
    }

    public boolean equals(Object obj) {
        return C0167h.m1508a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f883a.mo240a() - 1; a >= 0; a--) {
            Object a2 = this.f883a.mo242a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f883a.mo240a() == 0;
    }

    public Iterator iterator() {
        return new C0174i(this.f883a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f883a.mo241a(obj);
        if (a < 0) {
            return false;
        }
        this.f883a.mo244a(a);
        return true;
    }

    public boolean removeAll(Collection collection) {
        return C0167h.m1509b(this.f883a.mo247b(), collection);
    }

    public boolean retainAll(Collection collection) {
        return C0167h.m1510c(this.f883a.mo247b(), collection);
    }

    public int size() {
        return this.f883a.mo240a();
    }

    public Object[] toArray() {
        return this.f883a.m1520b(0);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f883a.m1517a(objArr, 0);
    }
}
