package android.support.v4.p015h;

import java.util.Map;

public class C0165q {
    static Object[] f847b;
    static int f848c;
    static Object[] f849d;
    static int f850e;
    int[] f851f;
    Object[] f852g;
    int f853h;

    public C0165q() {
        this.f851f = C0169c.f859a;
        this.f852g = C0169c.f861c;
        this.f853h = 0;
    }

    public C0165q(int i) {
        if (i == 0) {
            this.f851f = C0169c.f859a;
            this.f852g = C0169c.f861c;
        } else {
            m1495e(i);
        }
        this.f853h = 0;
    }

    private static void m1494a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0166a.class) {
                if (f850e < 10) {
                    objArr[0] = f849d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f849d = objArr;
                    f850e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0166a.class) {
                if (f848c < 10) {
                    objArr[0] = f847b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f847b = objArr;
                    f848c++;
                }
            }
        }
    }

    private void m1495e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0166a.class) {
                if (f849d != null) {
                    objArr = f849d;
                    this.f852g = objArr;
                    f849d = (Object[]) objArr[0];
                    this.f851f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f850e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0166a.class) {
                if (f847b != null) {
                    objArr = f847b;
                    this.f852g = objArr;
                    f847b = (Object[]) objArr[0];
                    this.f851f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f848c--;
                    return;
                }
            }
        }
        this.f851f = new int[i];
        this.f852g = new Object[(i << 1)];
    }

    int m1496a() {
        int i = this.f853h;
        if (i == 0) {
            return -1;
        }
        int a = C0169c.m1535a(this.f851f, i, 0);
        if (a < 0 || this.f852g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f851f[i2] == 0) {
            if (this.f852g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f851f[a] == 0) {
            if (this.f852g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    public int m1497a(Object obj) {
        return obj == null ? m1496a() : m1498a(obj, obj.hashCode());
    }

    int m1498a(Object obj, int i) {
        int i2 = this.f853h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0169c.m1535a(this.f851f, i2, i);
        if (a < 0 || obj.equals(this.f852g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f851f[i3] == i) {
            if (obj.equals(this.f852g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f851f[a] == i) {
            if (obj.equals(this.f852g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public Object m1499a(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object obj2 = this.f852g[i2];
        this.f852g[i2] = obj;
        return obj2;
    }

    public void m1500a(int i) {
        if (this.f851f.length < i) {
            Object obj = this.f851f;
            Object obj2 = this.f852g;
            m1495e(i);
            if (this.f853h > 0) {
                System.arraycopy(obj, 0, this.f851f, 0, this.f853h);
                System.arraycopy(obj2, 0, this.f852g, 0, this.f853h << 1);
            }
            C0165q.m1494a(obj, obj2, this.f853h);
        }
    }

    int m1501b(Object obj) {
        int i = 1;
        int i2 = this.f853h * 2;
        Object[] objArr = this.f852g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public Object m1502b(int i) {
        return this.f852g[i << 1];
    }

    public Object m1503c(int i) {
        return this.f852g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f853h != 0) {
            C0165q.m1494a(this.f851f, this.f852g, this.f853h);
            this.f851f = C0169c.f859a;
            this.f852g = C0169c.f861c;
            this.f853h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return m1497a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m1501b(obj) >= 0;
    }

    public Object m1504d(int i) {
        int i2 = 8;
        Object obj = this.f852g[(i << 1) + 1];
        if (this.f853h <= 1) {
            C0165q.m1494a(this.f851f, this.f852g, this.f853h);
            this.f851f = C0169c.f859a;
            this.f852g = C0169c.f861c;
            this.f853h = 0;
        } else if (this.f851f.length <= 8 || this.f853h >= this.f851f.length / 3) {
            this.f853h--;
            if (i < this.f853h) {
                System.arraycopy(this.f851f, i + 1, this.f851f, i, this.f853h - i);
                System.arraycopy(this.f852g, (i + 1) << 1, this.f852g, i << 1, (this.f853h - i) << 1);
            }
            this.f852g[this.f853h << 1] = null;
            this.f852g[(this.f853h << 1) + 1] = null;
        } else {
            if (this.f853h > 8) {
                i2 = this.f853h + (this.f853h >> 1);
            }
            Object obj2 = this.f851f;
            Object obj3 = this.f852g;
            m1495e(i2);
            this.f853h--;
            if (i > 0) {
                System.arraycopy(obj2, 0, this.f851f, 0, i);
                System.arraycopy(obj3, 0, this.f852g, 0, i << 1);
            }
            if (i < this.f853h) {
                System.arraycopy(obj2, i + 1, this.f851f, i, this.f853h - i);
                System.arraycopy(obj3, (i + 1) << 1, this.f852g, i << 1, (this.f853h - i) << 1);
            }
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f853h) {
            try {
                Object b = m1502b(i);
                Object c = m1503c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public Object get(Object obj) {
        int a = m1497a(obj);
        return a >= 0 ? this.f852g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f851f;
        Object[] objArr = this.f852g;
        int i = this.f853h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f853h <= 0;
    }

    public Object put(Object obj, Object obj2) {
        int a;
        int i;
        int i2 = 8;
        if (obj == null) {
            a = m1496a();
            i = 0;
        } else {
            i = obj.hashCode();
            a = m1498a(obj, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            Object obj3 = this.f852g[i3];
            this.f852g[i3] = obj2;
            return obj3;
        }
        a ^= -1;
        if (this.f853h >= this.f851f.length) {
            if (this.f853h >= 8) {
                i2 = this.f853h + (this.f853h >> 1);
            } else if (this.f853h < 4) {
                i2 = 4;
            }
            Object obj4 = this.f851f;
            Object obj5 = this.f852g;
            m1495e(i2);
            if (this.f851f.length > 0) {
                System.arraycopy(obj4, 0, this.f851f, 0, obj4.length);
                System.arraycopy(obj5, 0, this.f852g, 0, obj5.length);
            }
            C0165q.m1494a(obj4, obj5, this.f853h);
        }
        if (a < this.f853h) {
            System.arraycopy(this.f851f, a, this.f851f, a + 1, this.f853h - a);
            System.arraycopy(this.f852g, a << 1, this.f852g, (a + 1) << 1, (this.f853h - a) << 1);
        }
        this.f851f[a] = i;
        this.f852g[a << 1] = obj;
        this.f852g[(a << 1) + 1] = obj2;
        this.f853h++;
        return null;
    }

    public Object remove(Object obj) {
        int a = m1497a(obj);
        return a >= 0 ? m1504d(a) : null;
    }

    public int size() {
        return this.f853h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f853h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f853h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0165q b = m1502b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1503c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
