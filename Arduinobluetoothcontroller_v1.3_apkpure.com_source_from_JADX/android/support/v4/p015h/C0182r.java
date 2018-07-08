package android.support.v4.p015h;

public class C0182r implements Cloneable {
    private static final Object f891a = new Object();
    private boolean f892b;
    private int[] f893c;
    private Object[] f894d;
    private int f895e;

    public C0182r() {
        this(10);
    }

    public C0182r(int i) {
        this.f892b = false;
        if (i == 0) {
            this.f893c = C0169c.f859a;
            this.f894d = C0169c.f861c;
        } else {
            int a = C0169c.m1534a(i);
            this.f893c = new int[a];
            this.f894d = new Object[a];
        }
        this.f895e = 0;
    }

    private void m1567d() {
        int i = this.f895e;
        int[] iArr = this.f893c;
        Object[] objArr = this.f894d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f891a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f892b = false;
        this.f895e = i2;
    }

    public C0182r m1568a() {
        try {
            C0182r c0182r = (C0182r) super.clone();
            try {
                c0182r.f893c = (int[]) this.f893c.clone();
                c0182r.f894d = (Object[]) this.f894d.clone();
                return c0182r;
            } catch (CloneNotSupportedException e) {
                return c0182r;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public Object m1569a(int i) {
        return m1570a(i, null);
    }

    public Object m1570a(int i, Object obj) {
        int a = C0169c.m1535a(this.f893c, this.f895e, i);
        return (a < 0 || this.f894d[a] == f891a) ? obj : this.f894d[a];
    }

    public int m1571b() {
        if (this.f892b) {
            m1567d();
        }
        return this.f895e;
    }

    public void m1572b(int i) {
        int a = C0169c.m1535a(this.f893c, this.f895e, i);
        if (a >= 0 && this.f894d[a] != f891a) {
            this.f894d[a] = f891a;
            this.f892b = true;
        }
    }

    public void m1573b(int i, Object obj) {
        int a = C0169c.m1535a(this.f893c, this.f895e, i);
        if (a >= 0) {
            this.f894d[a] = obj;
            return;
        }
        a ^= -1;
        if (a >= this.f895e || this.f894d[a] != f891a) {
            if (this.f892b && this.f895e >= this.f893c.length) {
                m1567d();
                a = C0169c.m1535a(this.f893c, this.f895e, i) ^ -1;
            }
            if (this.f895e >= this.f893c.length) {
                int a2 = C0169c.m1534a(this.f895e + 1);
                Object obj2 = new int[a2];
                Object obj3 = new Object[a2];
                System.arraycopy(this.f893c, 0, obj2, 0, this.f893c.length);
                System.arraycopy(this.f894d, 0, obj3, 0, this.f894d.length);
                this.f893c = obj2;
                this.f894d = obj3;
            }
            if (this.f895e - a != 0) {
                System.arraycopy(this.f893c, a, this.f893c, a + 1, this.f895e - a);
                System.arraycopy(this.f894d, a, this.f894d, a + 1, this.f895e - a);
            }
            this.f893c[a] = i;
            this.f894d[a] = obj;
            this.f895e++;
            return;
        }
        this.f893c[a] = i;
        this.f894d[a] = obj;
    }

    public void m1574c() {
        int i = this.f895e;
        Object[] objArr = this.f894d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f895e = 0;
        this.f892b = false;
    }

    public void m1575c(int i) {
        m1572b(i);
    }

    public /* synthetic */ Object clone() {
        return m1568a();
    }

    public int m1576d(int i) {
        if (this.f892b) {
            m1567d();
        }
        return this.f893c[i];
    }

    public Object m1577e(int i) {
        if (this.f892b) {
            m1567d();
        }
        return this.f894d[i];
    }

    public int m1578f(int i) {
        if (this.f892b) {
            m1567d();
        }
        return C0169c.m1535a(this.f893c, this.f895e, i);
    }

    public String toString() {
        if (m1571b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f895e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f895e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1576d(i));
            stringBuilder.append('=');
            C0182r e = m1577e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
