package android.support.v7.widget;

import android.support.v4.p015h.C0180o;
import android.support.v4.p015h.C0181p;
import java.util.ArrayList;
import java.util.List;

class ai implements dn {
    final ArrayList f1918a;
    final ArrayList f1919b;
    final aj f1920c;
    Runnable f1921d;
    final boolean f1922e;
    final dm f1923f;
    private C0180o f1924g;
    private int f1925h;

    ai(aj ajVar) {
        this(ajVar, false);
    }

    ai(aj ajVar, boolean z) {
        this.f1924g = new C0181p(30);
        this.f1918a = new ArrayList();
        this.f1919b = new ArrayList();
        this.f1925h = 0;
        this.f1920c = ajVar;
        this.f1922e = z;
        this.f1923f = new dm(this);
    }

    private void m4023b(ak akVar) {
        m4030g(akVar);
    }

    private int m4024c(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f1919b.size() - 1; size >= 0; size--) {
            ak akVar = (ak) this.f1919b.get(size);
            if (akVar.f1926a == 8) {
                int i5;
                int i6;
                if (akVar.f1927b < akVar.f1929d) {
                    i5 = akVar.f1927b;
                    i3 = akVar.f1929d;
                } else {
                    i5 = akVar.f1929d;
                    i3 = akVar.f1927b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < akVar.f1927b) {
                        if (i2 == 1) {
                            akVar.f1927b++;
                            akVar.f1929d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            akVar.f1927b--;
                            akVar.f1929d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == akVar.f1927b) {
                    if (i2 == 1) {
                        akVar.f1929d++;
                    } else if (i2 == 2) {
                        akVar.f1929d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        akVar.f1927b++;
                    } else if (i2 == 2) {
                        akVar.f1927b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (akVar.f1927b <= i4) {
                if (akVar.f1926a == 1) {
                    i4 -= akVar.f1929d;
                } else if (akVar.f1926a == 2) {
                    i4 += akVar.f1929d;
                }
            } else if (i2 == 1) {
                akVar.f1927b++;
            } else if (i2 == 2) {
                akVar.f1927b--;
            }
        }
        for (i3 = this.f1919b.size() - 1; i3 >= 0; i3--) {
            akVar = (ak) this.f1919b.get(i3);
            if (akVar.f1926a == 8) {
                if (akVar.f1929d == akVar.f1927b || akVar.f1929d < 0) {
                    this.f1919b.remove(i3);
                    mo699a(akVar);
                }
            } else if (akVar.f1929d <= 0) {
                this.f1919b.remove(i3);
                mo699a(akVar);
            }
        }
        return i4;
    }

    private void m4025c(ak akVar) {
        int i = akVar.f1927b;
        int i2 = akVar.f1927b + akVar.f1929d;
        Object obj = -1;
        int i3 = akVar.f1927b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f1920c.mo758a(i3) != null || m4027d(i3)) {
                if (obj == null) {
                    m4028e(mo698a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m4030g(mo698a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != akVar.f1929d) {
            mo699a(akVar);
            akVar = mo698a(2, i, i4, null);
        }
        if (obj == null) {
            m4028e(akVar);
        } else {
            m4030g(akVar);
        }
    }

    private void m4026d(ak akVar) {
        int i = akVar.f1927b;
        int i2 = akVar.f1927b + akVar.f1929d;
        int i3 = akVar.f1927b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f1920c.mo758a(i3) != null || m4027d(i3)) {
                if (obj == null) {
                    m4028e(mo698a(4, i, i4, akVar.f1928c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m4030g(mo698a(4, i, i4, akVar.f1928c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != akVar.f1929d) {
            Object obj4 = akVar.f1928c;
            mo699a(akVar);
            akVar = mo698a(4, i, i4, obj4);
        }
        if (obj == null) {
            m4028e(akVar);
        } else {
            m4030g(akVar);
        }
    }

    private boolean m4027d(int i) {
        int size = this.f1919b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ak akVar = (ak) this.f1919b.get(i2);
            if (akVar.f1926a == 8) {
                if (m4031a(akVar.f1929d, i2 + 1) == i) {
                    return true;
                }
            } else if (akVar.f1926a == 1) {
                int i3 = akVar.f1927b + akVar.f1929d;
                for (int i4 = akVar.f1927b; i4 < i3; i4++) {
                    if (m4031a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m4028e(ak akVar) {
        if (akVar.f1926a == 1 || akVar.f1926a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int c = m4024c(akVar.f1927b, akVar.f1926a);
        int i2 = akVar.f1927b;
        switch (akVar.f1926a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + akVar);
        }
        int i3 = 1;
        int i4 = c;
        c = i2;
        for (i2 = 1; i2 < akVar.f1929d; i2++) {
            Object obj;
            int c2 = m4024c(akVar.f1927b + (i * i2), akVar.f1926a);
            int i5;
            switch (akVar.f1926a) {
                case 2:
                    if (c2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (c2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                ak a = mo698a(akVar.f1926a, i4, i3, akVar.f1928c);
                m4035a(a, c);
                mo699a(a);
                if (akVar.f1926a == 4) {
                    c += i3;
                }
                i3 = 1;
                i4 = c2;
            }
        }
        Object obj2 = akVar.f1928c;
        mo699a(akVar);
        if (i3 > 0) {
            ak a2 = mo698a(akVar.f1926a, i4, i3, obj2);
            m4035a(a2, c);
            mo699a(a2);
        }
    }

    private void m4029f(ak akVar) {
        m4030g(akVar);
    }

    private void m4030g(ak akVar) {
        this.f1919b.add(akVar);
        switch (akVar.f1926a) {
            case 1:
                this.f1920c.mo764c(akVar.f1927b, akVar.f1929d);
                return;
            case 2:
                this.f1920c.mo762b(akVar.f1927b, akVar.f1929d);
                return;
            case 4:
                this.f1920c.mo760a(akVar.f1927b, akVar.f1929d, akVar.f1928c);
                return;
            case 8:
                this.f1920c.mo765d(akVar.f1927b, akVar.f1929d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + akVar);
        }
    }

    int m4031a(int i, int i2) {
        int size = this.f1919b.size();
        int i3 = i;
        while (i2 < size) {
            ak akVar = (ak) this.f1919b.get(i2);
            if (akVar.f1926a == 8) {
                if (akVar.f1927b == i3) {
                    i3 = akVar.f1929d;
                } else {
                    if (akVar.f1927b < i3) {
                        i3--;
                    }
                    if (akVar.f1929d <= i3) {
                        i3++;
                    }
                }
            } else if (akVar.f1927b > i3) {
                continue;
            } else if (akVar.f1926a == 2) {
                if (i3 < akVar.f1927b + akVar.f1929d) {
                    return -1;
                }
                i3 -= akVar.f1929d;
            } else if (akVar.f1926a == 1) {
                i3 += akVar.f1929d;
            }
            i2++;
        }
        return i3;
    }

    public ak mo698a(int i, int i2, int i3, Object obj) {
        ak akVar = (ak) this.f1924g.mo249a();
        if (akVar == null) {
            return new ak(i, i2, i3, obj);
        }
        akVar.f1926a = i;
        akVar.f1927b = i2;
        akVar.f1929d = i3;
        akVar.f1928c = obj;
        return akVar;
    }

    void m4033a() {
        m4036a(this.f1918a);
        m4036a(this.f1919b);
        this.f1925h = 0;
    }

    public void mo699a(ak akVar) {
        if (!this.f1922e) {
            akVar.f1928c = null;
            this.f1924g.mo250a(akVar);
        }
    }

    void m4035a(ak akVar, int i) {
        this.f1920c.mo761a(akVar);
        switch (akVar.f1926a) {
            case 2:
                this.f1920c.mo759a(i, akVar.f1929d);
                return;
            case 4:
                this.f1920c.mo760a(i, akVar.f1929d, akVar.f1928c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void m4036a(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo699a((ak) list.get(i));
        }
        list.clear();
    }

    boolean m4037a(int i) {
        return (this.f1925h & i) != 0;
    }

    int m4038b(int i) {
        return m4031a(i, 0);
    }

    void m4039b() {
        this.f1923f.m4405a(this.f1918a);
        int size = this.f1918a.size();
        for (int i = 0; i < size; i++) {
            ak akVar = (ak) this.f1918a.get(i);
            switch (akVar.f1926a) {
                case 1:
                    m4029f(akVar);
                    break;
                case 2:
                    m4025c(akVar);
                    break;
                case 4:
                    m4026d(akVar);
                    break;
                case 8:
                    m4023b(akVar);
                    break;
            }
            if (this.f1921d != null) {
                this.f1921d.run();
            }
        }
        this.f1918a.clear();
    }

    boolean m4040b(int i, int i2) {
        this.f1918a.add(mo698a(1, i, i2, null));
        this.f1925h |= 1;
        return this.f1918a.size() == 1;
    }

    public int m4041c(int i) {
        int size = this.f1918a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            ak akVar = (ak) this.f1918a.get(i3);
            switch (akVar.f1926a) {
                case 1:
                    if (akVar.f1927b > i2) {
                        break;
                    }
                    i2 += akVar.f1929d;
                    break;
                case 2:
                    if (akVar.f1927b <= i2) {
                        if (akVar.f1927b + akVar.f1929d <= i2) {
                            i2 -= akVar.f1929d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (akVar.f1927b != i2) {
                        if (akVar.f1927b < i2) {
                            i2--;
                        }
                        if (akVar.f1929d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = akVar.f1929d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    void m4042c() {
        int size = this.f1919b.size();
        for (int i = 0; i < size; i++) {
            this.f1920c.mo763b((ak) this.f1919b.get(i));
        }
        m4036a(this.f1919b);
        this.f1925h = 0;
    }

    boolean m4043d() {
        return this.f1918a.size() > 0;
    }

    void m4044e() {
        m4042c();
        int size = this.f1918a.size();
        for (int i = 0; i < size; i++) {
            ak akVar = (ak) this.f1918a.get(i);
            switch (akVar.f1926a) {
                case 1:
                    this.f1920c.mo763b(akVar);
                    this.f1920c.mo764c(akVar.f1927b, akVar.f1929d);
                    break;
                case 2:
                    this.f1920c.mo763b(akVar);
                    this.f1920c.mo759a(akVar.f1927b, akVar.f1929d);
                    break;
                case 4:
                    this.f1920c.mo763b(akVar);
                    this.f1920c.mo760a(akVar.f1927b, akVar.f1929d, akVar.f1928c);
                    break;
                case 8:
                    this.f1920c.mo763b(akVar);
                    this.f1920c.mo765d(akVar.f1927b, akVar.f1929d);
                    break;
            }
            if (this.f1921d != null) {
                this.f1921d.run();
            }
        }
        m4036a(this.f1918a);
        this.f1925h = 0;
    }

    boolean m4045f() {
        return (this.f1919b.isEmpty() || this.f1918a.isEmpty()) ? false : true;
    }
}
