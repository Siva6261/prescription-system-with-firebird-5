package android.support.v4.p015h;

public class C0172f implements Cloneable {
    private static final Object f864a = new Object();
    private boolean f865b;
    private long[] f866c;
    private Object[] f867d;
    private int f868e;

    public C0172f() {
        this(10);
    }

    public C0172f(int i) {
        this.f865b = false;
        if (i == 0) {
            this.f866c = C0169c.f860b;
            this.f867d = C0169c.f861c;
        } else {
            int b = C0169c.m1538b(i);
            this.f866c = new long[b];
            this.f867d = new Object[b];
        }
        this.f868e = 0;
    }

    private void m1542d() {
        int i = this.f868e;
        long[] jArr = this.f866c;
        Object[] objArr = this.f867d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f864a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f865b = false;
        this.f868e = i2;
    }

    public C0172f m1543a() {
        try {
            C0172f c0172f = (C0172f) super.clone();
            try {
                c0172f.f866c = (long[]) this.f866c.clone();
                c0172f.f867d = (Object[]) this.f867d.clone();
                return c0172f;
            } catch (CloneNotSupportedException e) {
                return c0172f;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public Object m1544a(long j) {
        return m1545a(j, null);
    }

    public Object m1545a(long j, Object obj) {
        int a = C0169c.m1536a(this.f866c, this.f868e, j);
        return (a < 0 || this.f867d[a] == f864a) ? obj : this.f867d[a];
    }

    public void m1546a(int i) {
        if (this.f867d[i] != f864a) {
            this.f867d[i] = f864a;
            this.f865b = true;
        }
    }

    public int m1547b() {
        if (this.f865b) {
            m1542d();
        }
        return this.f868e;
    }

    public long m1548b(int i) {
        if (this.f865b) {
            m1542d();
        }
        return this.f866c[i];
    }

    public void m1549b(long j) {
        int a = C0169c.m1536a(this.f866c, this.f868e, j);
        if (a >= 0 && this.f867d[a] != f864a) {
            this.f867d[a] = f864a;
            this.f865b = true;
        }
    }

    public void m1550b(long j, Object obj) {
        int a = C0169c.m1536a(this.f866c, this.f868e, j);
        if (a >= 0) {
            this.f867d[a] = obj;
            return;
        }
        a ^= -1;
        if (a >= this.f868e || this.f867d[a] != f864a) {
            if (this.f865b && this.f868e >= this.f866c.length) {
                m1542d();
                a = C0169c.m1536a(this.f866c, this.f868e, j) ^ -1;
            }
            if (this.f868e >= this.f866c.length) {
                int b = C0169c.m1538b(this.f868e + 1);
                Object obj2 = new long[b];
                Object obj3 = new Object[b];
                System.arraycopy(this.f866c, 0, obj2, 0, this.f866c.length);
                System.arraycopy(this.f867d, 0, obj3, 0, this.f867d.length);
                this.f866c = obj2;
                this.f867d = obj3;
            }
            if (this.f868e - a != 0) {
                System.arraycopy(this.f866c, a, this.f866c, a + 1, this.f868e - a);
                System.arraycopy(this.f867d, a, this.f867d, a + 1, this.f868e - a);
            }
            this.f866c[a] = j;
            this.f867d[a] = obj;
            this.f868e++;
            return;
        }
        this.f866c[a] = j;
        this.f867d[a] = obj;
    }

    public Object m1551c(int i) {
        if (this.f865b) {
            m1542d();
        }
        return this.f867d[i];
    }

    public void m1552c() {
        int i = this.f868e;
        Object[] objArr = this.f867d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f868e = 0;
        this.f865b = false;
    }

    public /* synthetic */ Object clone() {
        return m1543a();
    }

    public String toString() {
        if (m1547b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f868e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f868e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1548b(i));
            stringBuilder.append('=');
            C0172f c = m1551c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
