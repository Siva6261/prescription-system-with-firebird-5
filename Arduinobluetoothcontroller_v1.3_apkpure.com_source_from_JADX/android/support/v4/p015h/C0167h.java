package android.support.v4.p015h;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class C0167h {
    C0175j f855b;
    C0176k f856c;
    C0178m f857d;

    C0167h() {
    }

    public static boolean m1507a(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m1508a(Set set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static boolean m1509b(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static boolean m1510c(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int mo240a();

    protected abstract int mo241a(Object obj);

    protected abstract Object mo242a(int i, int i2);

    protected abstract Object mo243a(int i, Object obj);

    protected abstract void mo244a(int i);

    protected abstract void mo245a(Object obj, Object obj2);

    public Object[] m1517a(Object[] objArr, int i) {
        int a = mo240a();
        Object[] objArr2 = objArr.length < a ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), a) : objArr;
        for (int i2 = 0; i2 < a; i2++) {
            objArr2[i2] = mo242a(i2, i);
        }
        if (objArr2.length > a) {
            objArr2[a] = null;
        }
        return objArr2;
    }

    protected abstract int mo246b(Object obj);

    protected abstract Map mo247b();

    public Object[] m1520b(int i) {
        int a = mo240a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo242a(i2, i);
        }
        return objArr;
    }

    protected abstract void mo248c();

    public Set m1522d() {
        if (this.f855b == null) {
            this.f855b = new C0175j(this);
        }
        return this.f855b;
    }

    public Set m1523e() {
        if (this.f856c == null) {
            this.f856c = new C0176k(this);
        }
        return this.f856c;
    }

    public Collection m1524f() {
        if (this.f857d == null) {
            this.f857d = new C0178m(this);
        }
        return this.f857d;
    }
}
