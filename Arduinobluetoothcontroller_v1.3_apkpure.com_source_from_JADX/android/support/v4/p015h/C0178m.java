package android.support.v4.p015h;

import java.util.Collection;
import java.util.Iterator;

final class C0178m implements Collection {
    final /* synthetic */ C0167h f888a;

    C0178m(C0167h c0167h) {
        this.f888a = c0167h;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f888a.mo248c();
    }

    public boolean contains(Object obj) {
        return this.f888a.mo246b(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f888a.mo240a() == 0;
    }

    public Iterator iterator() {
        return new C0174i(this.f888a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f888a.mo246b(obj);
        if (b < 0) {
            return false;
        }
        this.f888a.mo244a(b);
        return true;
    }

    public boolean removeAll(Collection collection) {
        int i = 0;
        int a = this.f888a.mo240a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f888a.mo242a(i, 1))) {
                this.f888a.mo244a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection collection) {
        int i = 0;
        int a = this.f888a.mo240a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f888a.mo242a(i, 1))) {
                this.f888a.mo244a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f888a.mo240a();
    }

    public Object[] toArray() {
        return this.f888a.m1520b(1);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f888a.m1517a(objArr, 1);
    }
}
