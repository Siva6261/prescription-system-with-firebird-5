package android.support.v7.widget;

import android.support.v4.p015h.C0166a;
import android.support.v4.p015h.C0172f;

class gr {
    final C0166a f2412a = new C0166a();
    final C0172f f2413b = new C0172f();

    gr() {
    }

    private ee m4868a(ey eyVar, int i) {
        ee eeVar = null;
        int a = this.f2412a.m1497a((Object) eyVar);
        if (a >= 0) {
            gs gsVar = (gs) this.f2412a.m1503c(a);
            if (!(gsVar == null || (gsVar.f2415a & i) == 0)) {
                gsVar.f2415a &= i ^ -1;
                if (i == 4) {
                    eeVar = gsVar.f2416b;
                } else if (i == 8) {
                    eeVar = gsVar.f2417c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((gsVar.f2415a & 12) == 0) {
                    this.f2412a.m1504d(a);
                    gs.m4886a(gsVar);
                }
            }
        }
        return eeVar;
    }

    ey m4869a(long j) {
        return (ey) this.f2413b.m1544a(j);
    }

    void m4870a() {
        this.f2412a.clear();
        this.f2413b.m1552c();
    }

    void m4871a(long j, ey eyVar) {
        this.f2413b.m1550b(j, eyVar);
    }

    void m4872a(ey eyVar, ee eeVar) {
        gs gsVar = (gs) this.f2412a.get(eyVar);
        if (gsVar == null) {
            gsVar = gs.m4885a();
            this.f2412a.put(eyVar, gsVar);
        }
        gsVar.f2416b = eeVar;
        gsVar.f2415a |= 4;
    }

    void m4873a(gt gtVar) {
        for (int size = this.f2412a.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2412a.m1502b(size);
            gs gsVar = (gs) this.f2412a.m1504d(size);
            if ((gsVar.f2415a & 3) == 3) {
                gtVar.mo743a(eyVar);
            } else if ((gsVar.f2415a & 1) != 0) {
                if (gsVar.f2416b == null) {
                    gtVar.mo743a(eyVar);
                } else {
                    gtVar.mo744a(eyVar, gsVar.f2416b, gsVar.f2417c);
                }
            } else if ((gsVar.f2415a & 14) == 14) {
                gtVar.mo745b(eyVar, gsVar.f2416b, gsVar.f2417c);
            } else if ((gsVar.f2415a & 12) == 12) {
                gtVar.mo746c(eyVar, gsVar.f2416b, gsVar.f2417c);
            } else if ((gsVar.f2415a & 4) != 0) {
                gtVar.mo744a(eyVar, gsVar.f2416b, null);
            } else if ((gsVar.f2415a & 8) != 0) {
                gtVar.mo745b(eyVar, gsVar.f2416b, gsVar.f2417c);
            } else if ((gsVar.f2415a & 2) != 0) {
            }
            gs.m4886a(gsVar);
        }
    }

    boolean m4874a(ey eyVar) {
        gs gsVar = (gs) this.f2412a.get(eyVar);
        return (gsVar == null || (gsVar.f2415a & 1) == 0) ? false : true;
    }

    ee m4875b(ey eyVar) {
        return m4868a(eyVar, 4);
    }

    void m4876b() {
        gs.m4887b();
    }

    void m4877b(ey eyVar, ee eeVar) {
        gs gsVar = (gs) this.f2412a.get(eyVar);
        if (gsVar == null) {
            gsVar = gs.m4885a();
            this.f2412a.put(eyVar, gsVar);
        }
        gsVar.f2415a |= 2;
        gsVar.f2416b = eeVar;
    }

    ee m4878c(ey eyVar) {
        return m4868a(eyVar, 8);
    }

    void m4879c(ey eyVar, ee eeVar) {
        gs gsVar = (gs) this.f2412a.get(eyVar);
        if (gsVar == null) {
            gsVar = gs.m4885a();
            this.f2412a.put(eyVar, gsVar);
        }
        gsVar.f2417c = eeVar;
        gsVar.f2415a |= 8;
    }

    boolean m4880d(ey eyVar) {
        gs gsVar = (gs) this.f2412a.get(eyVar);
        return (gsVar == null || (gsVar.f2415a & 4) == 0) ? false : true;
    }

    void m4881e(ey eyVar) {
        gs gsVar = (gs) this.f2412a.get(eyVar);
        if (gsVar == null) {
            gsVar = gs.m4885a();
            this.f2412a.put(eyVar, gsVar);
        }
        r0.f2415a |= 1;
    }

    void m4882f(ey eyVar) {
        gs gsVar = (gs) this.f2412a.get(eyVar);
        if (gsVar != null) {
            gsVar.f2415a &= -2;
        }
    }

    void m4883g(ey eyVar) {
        for (int b = this.f2413b.m1547b() - 1; b >= 0; b--) {
            if (eyVar == this.f2413b.m1551c(b)) {
                this.f2413b.m1546a(b);
                break;
            }
        }
        gs gsVar = (gs) this.f2412a.remove(eyVar);
        if (gsVar != null) {
            gs.m4886a(gsVar);
        }
    }

    public void m4884h(ey eyVar) {
        m4882f(eyVar);
    }
}
