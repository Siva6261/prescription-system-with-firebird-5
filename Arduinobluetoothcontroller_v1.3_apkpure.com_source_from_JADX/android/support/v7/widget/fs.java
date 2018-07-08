package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class fs {
    int[] f2317a;
    List f2318b;

    fs() {
    }

    private void m4711c(int i, int i2) {
        if (this.f2318b != null) {
            int i3 = i + i2;
            for (int size = this.f2318b.size() - 1; size >= 0; size--) {
                ft ftVar = (ft) this.f2318b.get(size);
                if (ftVar.f2319a >= i) {
                    if (ftVar.f2319a < i3) {
                        this.f2318b.remove(size);
                    } else {
                        ftVar.f2319a -= i2;
                    }
                }
            }
        }
    }

    private void m4712d(int i, int i2) {
        if (this.f2318b != null) {
            for (int size = this.f2318b.size() - 1; size >= 0; size--) {
                ft ftVar = (ft) this.f2318b.get(size);
                if (ftVar.f2319a >= i) {
                    ftVar.f2319a += i2;
                }
            }
        }
    }

    private int m4713g(int i) {
        if (this.f2318b == null) {
            return -1;
        }
        ft f = m4725f(i);
        if (f != null) {
            this.f2318b.remove(f);
        }
        int size = this.f2318b.size();
        int i2 = 0;
        while (i2 < size) {
            if (((ft) this.f2318b.get(i2)).f2319a >= i) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 == -1) {
            return -1;
        }
        f = (ft) this.f2318b.get(i2);
        this.f2318b.remove(i2);
        return f.f2319a;
    }

    int m4714a(int i) {
        if (this.f2318b != null) {
            for (int size = this.f2318b.size() - 1; size >= 0; size--) {
                if (((ft) this.f2318b.get(size)).f2319a >= i) {
                    this.f2318b.remove(size);
                }
            }
        }
        return m4720b(i);
    }

    public ft m4715a(int i, int i2, int i3, boolean z) {
        if (this.f2318b == null) {
            return null;
        }
        int size = this.f2318b.size();
        for (int i4 = 0; i4 < size; i4++) {
            ft ftVar = (ft) this.f2318b.get(i4);
            if (ftVar.f2319a >= i2) {
                return null;
            }
            if (ftVar.f2319a >= i) {
                if (i3 == 0 || ftVar.f2320b == i3) {
                    return ftVar;
                }
                if (z && ftVar.f2322d) {
                    return ftVar;
                }
            }
        }
        return null;
    }

    void m4716a() {
        if (this.f2317a != null) {
            Arrays.fill(this.f2317a, -1);
        }
        this.f2318b = null;
    }

    void m4717a(int i, int i2) {
        if (this.f2317a != null && i < this.f2317a.length) {
            m4724e(i + i2);
            System.arraycopy(this.f2317a, i + i2, this.f2317a, i, (this.f2317a.length - i) - i2);
            Arrays.fill(this.f2317a, this.f2317a.length - i2, this.f2317a.length, -1);
            m4711c(i, i2);
        }
    }

    void m4718a(int i, fx fxVar) {
        m4724e(i);
        this.f2317a[i] = fxVar.f2336d;
    }

    public void m4719a(ft ftVar) {
        if (this.f2318b == null) {
            this.f2318b = new ArrayList();
        }
        int size = this.f2318b.size();
        for (int i = 0; i < size; i++) {
            ft ftVar2 = (ft) this.f2318b.get(i);
            if (ftVar2.f2319a == ftVar.f2319a) {
                this.f2318b.remove(i);
            }
            if (ftVar2.f2319a >= ftVar.f2319a) {
                this.f2318b.add(i, ftVar);
                return;
            }
        }
        this.f2318b.add(ftVar);
    }

    int m4720b(int i) {
        if (this.f2317a == null || i >= this.f2317a.length) {
            return -1;
        }
        int g = m4713g(i);
        if (g == -1) {
            Arrays.fill(this.f2317a, i, this.f2317a.length, -1);
            return this.f2317a.length;
        }
        Arrays.fill(this.f2317a, i, g + 1, -1);
        return g + 1;
    }

    void m4721b(int i, int i2) {
        if (this.f2317a != null && i < this.f2317a.length) {
            m4724e(i + i2);
            System.arraycopy(this.f2317a, i, this.f2317a, i + i2, (this.f2317a.length - i) - i2);
            Arrays.fill(this.f2317a, i, i + i2, -1);
            m4712d(i, i2);
        }
    }

    int m4722c(int i) {
        return (this.f2317a == null || i >= this.f2317a.length) ? -1 : this.f2317a[i];
    }

    int m4723d(int i) {
        int length = this.f2317a.length;
        while (length <= i) {
            length *= 2;
        }
        return length;
    }

    void m4724e(int i) {
        if (this.f2317a == null) {
            this.f2317a = new int[(Math.max(i, 10) + 1)];
            Arrays.fill(this.f2317a, -1);
        } else if (i >= this.f2317a.length) {
            Object obj = this.f2317a;
            this.f2317a = new int[m4723d(i)];
            System.arraycopy(obj, 0, this.f2317a, 0, obj.length);
            Arrays.fill(this.f2317a, obj.length, this.f2317a.length, -1);
        }
    }

    public ft m4725f(int i) {
        if (this.f2318b == null) {
            return null;
        }
        for (int size = this.f2318b.size() - 1; size >= 0; size--) {
            ft ftVar = (ft) this.f2318b.get(size);
            if (ftVar.f2319a == i) {
                return ftVar;
            }
        }
        return null;
    }
}
