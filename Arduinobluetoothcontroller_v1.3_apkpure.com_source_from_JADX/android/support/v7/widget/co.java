package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class co {
    final SparseIntArray f2121a = new SparseIntArray();
    private boolean f2122b = false;

    public abstract int mo724a(int i);

    public int mo725a(int i, int i2) {
        int a = mo724a(i);
        if (a == i2) {
            return 0;
        }
        int b;
        int a2;
        int i3;
        if (this.f2122b && this.f2121a.size() > 0) {
            b = m4353b(i);
            if (b >= 0) {
                a2 = this.f2121a.get(b) + mo724a(b);
                b++;
                i3 = b;
                while (i3 < i) {
                    b = mo724a(i3);
                    a2 += b;
                    if (a2 == i2) {
                        b = 0;
                    } else if (a2 <= i2) {
                        b = a2;
                    }
                    i3++;
                    a2 = b;
                }
                return a2 + a > i2 ? a2 : 0;
            }
        }
        b = 0;
        a2 = 0;
        i3 = b;
        while (i3 < i) {
            b = mo724a(i3);
            a2 += b;
            if (a2 == i2) {
                b = 0;
            } else if (a2 <= i2) {
                b = a2;
            }
            i3++;
            a2 = b;
        }
        if (a2 + a > i2) {
        }
    }

    public void m4352a() {
        this.f2121a.clear();
    }

    int m4353b(int i) {
        int i2 = 0;
        int size = this.f2121a.size() - 1;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            if (this.f2121a.keyAt(i3) < i) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        size = i2 - 1;
        return (size < 0 || size >= this.f2121a.size()) ? -1 : this.f2121a.keyAt(size);
    }

    int m4354b(int i, int i2) {
        if (!this.f2122b) {
            return mo725a(i, i2);
        }
        int i3 = this.f2121a.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = mo725a(i, i2);
        this.f2121a.put(i, i3);
        return i3;
    }

    public int m4355c(int i, int i2) {
        int a = mo724a(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            int a2 = mo724a(i3);
            i5 += a2;
            if (i5 == i2) {
                i4++;
                a2 = 0;
            } else if (i5 > i2) {
                i4++;
            } else {
                a2 = i5;
            }
            i3++;
            i5 = a2;
        }
        return i5 + a > i2 ? i4 + 1 : i4;
    }
}
