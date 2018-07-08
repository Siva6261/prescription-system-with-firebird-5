package android.support.v7.widget;

import java.util.List;

class dm {
    final dn f2188a;

    public dm(dn dnVar) {
        this.f2188a = dnVar;
    }

    private void m4402a(List list, int i, int i2) {
        ak akVar = (ak) list.get(i);
        ak akVar2 = (ak) list.get(i2);
        switch (akVar2.f1926a) {
            case 1:
                m4404c(list, i, akVar, i2, akVar2);
                return;
            case 2:
                m4406a(list, i, akVar, i2, akVar2);
                return;
            case 4:
                m4407b(list, i, akVar, i2, akVar2);
                return;
            default:
                return;
        }
    }

    private int m4403b(List list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((ak) list.get(size)).f1926a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }

    private void m4404c(List list, int i, ak akVar, int i2, ak akVar2) {
        int i3 = 0;
        if (akVar.f1929d < akVar2.f1927b) {
            i3 = -1;
        }
        if (akVar.f1927b < akVar2.f1927b) {
            i3++;
        }
        if (akVar2.f1927b <= akVar.f1927b) {
            akVar.f1927b += akVar2.f1929d;
        }
        if (akVar2.f1927b <= akVar.f1929d) {
            akVar.f1929d += akVar2.f1929d;
        }
        akVar2.f1927b = i3 + akVar2.f1927b;
        list.set(i, akVar2);
        list.set(i2, akVar);
    }

    void m4405a(List list) {
        while (true) {
            int b = m4403b(list);
            if (b != -1) {
                m4402a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    void m4406a(List list, int i, ak akVar, int i2, ak akVar2) {
        int i3;
        ak akVar3;
        int i4 = 0;
        if (akVar.f1927b < akVar.f1929d) {
            i3 = (akVar2.f1927b == akVar.f1927b && akVar2.f1929d == akVar.f1929d - akVar.f1927b) ? 1 : 0;
        } else if (akVar2.f1927b == akVar.f1929d + 1 && akVar2.f1929d == akVar.f1927b - akVar.f1929d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (akVar.f1929d < akVar2.f1927b) {
            akVar2.f1927b--;
        } else if (akVar.f1929d < akVar2.f1927b + akVar2.f1929d) {
            akVar2.f1929d--;
            akVar.f1926a = 2;
            akVar.f1929d = 1;
            if (akVar2.f1929d == 0) {
                list.remove(i2);
                this.f2188a.mo699a(akVar2);
                return;
            }
            return;
        }
        if (akVar.f1927b <= akVar2.f1927b) {
            akVar2.f1927b++;
            akVar3 = null;
        } else if (akVar.f1927b < akVar2.f1927b + akVar2.f1929d) {
            akVar3 = this.f2188a.mo698a(2, akVar.f1927b + 1, (akVar2.f1927b + akVar2.f1929d) - akVar.f1927b, null);
            akVar2.f1929d = akVar.f1927b - akVar2.f1927b;
        } else {
            akVar3 = null;
        }
        if (i3 != 0) {
            list.set(i, akVar2);
            list.remove(i2);
            this.f2188a.mo699a(akVar);
            return;
        }
        if (i4 != 0) {
            if (akVar3 != null) {
                if (akVar.f1927b > akVar3.f1927b) {
                    akVar.f1927b -= akVar3.f1929d;
                }
                if (akVar.f1929d > akVar3.f1927b) {
                    akVar.f1929d -= akVar3.f1929d;
                }
            }
            if (akVar.f1927b > akVar2.f1927b) {
                akVar.f1927b -= akVar2.f1929d;
            }
            if (akVar.f1929d > akVar2.f1927b) {
                akVar.f1929d -= akVar2.f1929d;
            }
        } else {
            if (akVar3 != null) {
                if (akVar.f1927b >= akVar3.f1927b) {
                    akVar.f1927b -= akVar3.f1929d;
                }
                if (akVar.f1929d >= akVar3.f1927b) {
                    akVar.f1929d -= akVar3.f1929d;
                }
            }
            if (akVar.f1927b >= akVar2.f1927b) {
                akVar.f1927b -= akVar2.f1929d;
            }
            if (akVar.f1929d >= akVar2.f1927b) {
                akVar.f1929d -= akVar2.f1929d;
            }
        }
        list.set(i, akVar2);
        if (akVar.f1927b != akVar.f1929d) {
            list.set(i2, akVar);
        } else {
            list.remove(i2);
        }
        if (akVar3 != null) {
            list.add(i, akVar3);
        }
    }

    void m4407b(List list, int i, ak akVar, int i2, ak akVar2) {
        Object obj;
        Object obj2 = null;
        if (akVar.f1929d < akVar2.f1927b) {
            akVar2.f1927b--;
            obj = null;
        } else if (akVar.f1929d < akVar2.f1927b + akVar2.f1929d) {
            akVar2.f1929d--;
            obj = this.f2188a.mo698a(4, akVar.f1927b, 1, akVar2.f1928c);
        } else {
            obj = null;
        }
        if (akVar.f1927b <= akVar2.f1927b) {
            akVar2.f1927b++;
        } else if (akVar.f1927b < akVar2.f1927b + akVar2.f1929d) {
            int i3 = (akVar2.f1927b + akVar2.f1929d) - akVar.f1927b;
            obj2 = this.f2188a.mo698a(4, akVar.f1927b + 1, i3, akVar2.f1928c);
            akVar2.f1929d -= i3;
        }
        list.set(i2, akVar);
        if (akVar2.f1929d > 0) {
            list.set(i, akVar2);
        } else {
            list.remove(i);
            this.f2188a.mo699a(akVar2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }
}
