package android.support.v7.widget;

import android.support.v4.p002f.C0142h;
import android.support.v4.view.bv;
import android.support.v4.widget.at;
import android.view.animation.Interpolator;

class ex implements Runnable {
    final /* synthetic */ RecyclerView f2248a;
    private int f2249b;
    private int f2250c;
    private at f2251d;
    private Interpolator f2252e = RecyclerView.ao;
    private boolean f2253f = false;
    private boolean f2254g = false;

    public ex(RecyclerView recyclerView) {
        this.f2248a = recyclerView;
        this.f2251d = at.m2639a(recyclerView.getContext(), RecyclerView.ao);
    }

    private float m4612a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private int m4613b(int i, int i2, int i3, int i4) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.f2248a.getWidth() : this.f2248a.getHeight();
        int i5 = width / 2;
        float a = (m4612a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
        } else {
            round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
        }
        return Math.min(round, 2000);
    }

    private void m4614c() {
        this.f2254g = false;
        this.f2253f = true;
    }

    private void m4615d() {
        this.f2253f = false;
        if (this.f2254g) {
            m4616a();
        }
    }

    void m4616a() {
        if (this.f2253f) {
            this.f2254g = true;
            return;
        }
        this.f2248a.removeCallbacks(this);
        bv.m2010a(this.f2248a, (Runnable) this);
    }

    public void m4617a(int i, int i2) {
        this.f2248a.setScrollState(2);
        this.f2250c = 0;
        this.f2249b = 0;
        this.f2251d.m2642a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        m4616a();
    }

    public void m4618a(int i, int i2, int i3) {
        m4620a(i, i2, i3, RecyclerView.ao);
    }

    public void m4619a(int i, int i2, int i3, int i4) {
        m4618a(i, i2, m4613b(i, i2, i3, i4));
    }

    public void m4620a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.f2252e != interpolator) {
            this.f2252e = interpolator;
            this.f2251d = at.m2639a(this.f2248a.getContext(), interpolator);
        }
        this.f2248a.setScrollState(2);
        this.f2250c = 0;
        this.f2249b = 0;
        this.f2251d.m2641a(0, 0, i, i2, i3);
        m4616a();
    }

    public void m4621b() {
        this.f2248a.removeCallbacks(this);
        this.f2251d.m2652h();
    }

    public void m4622b(int i, int i2) {
        m4619a(i, i2, 0, 0);
    }

    public void run() {
        if (this.f2248a.f146e == null) {
            m4621b();
            return;
        }
        m4614c();
        this.f2248a.m172t();
        at atVar = this.f2251d;
        et etVar = this.f2248a.f146e.f1768r;
        if (atVar.m2651g()) {
            int e;
            int i;
            int f;
            int i2;
            Object obj;
            Object obj2;
            int b = atVar.m2646b();
            int c = atVar.m2647c();
            int i3 = b - this.f2249b;
            int i4 = c - this.f2250c;
            int i5 = 0;
            int i6 = 0;
            this.f2249b = b;
            this.f2250c = c;
            int i7 = 0;
            int i8 = 0;
            if (this.f2248a.f156q != null) {
                this.f2248a.m194b();
                this.f2248a.m180z();
                C0142h.m1462a("RV Scroll");
                if (i3 != 0) {
                    i5 = this.f2248a.f146e.mo657a(i3, this.f2248a.f142a, this.f2248a.f148g);
                    i7 = i3 - i5;
                }
                if (i4 != 0) {
                    i6 = this.f2248a.f146e.mo664b(i4, this.f2248a.f142a, this.f2248a.f148g);
                    i8 = i4 - i6;
                }
                C0142h.m1461a();
                this.f2248a.m109J();
                this.f2248a.m100A();
                this.f2248a.m190a(false);
                if (!(etVar == null || etVar.m4580b() || !etVar.m4581c())) {
                    e = this.f2248a.f148g.m4610e();
                    if (e == 0) {
                        etVar.m4575a();
                        i = i7;
                        i7 = i6;
                        i6 = i;
                    } else if (etVar.m4582d() >= e) {
                        etVar.m4576a(e - 1);
                        etVar.m4572a(i3 - i7, i4 - i8);
                        i = i7;
                        i7 = i6;
                        i6 = i;
                    } else {
                        etVar.m4572a(i3 - i7, i4 - i8);
                    }
                    if (!this.f2248a.f158s.isEmpty()) {
                        this.f2248a.invalidate();
                    }
                    if (bv.m2000a(this.f2248a) != 2) {
                        this.f2248a.m154i(i3, i4);
                    }
                    if (!(i6 == 0 && i8 == 0)) {
                        f = (int) atVar.m2650f();
                        if (i6 == b) {
                            e = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                            i2 = e;
                        } else {
                            i2 = 0;
                        }
                        if (i8 != c) {
                            f = 0;
                        } else if (i8 < 0) {
                            f = -f;
                        } else if (i8 <= 0) {
                            f = 0;
                        }
                        if (bv.m2000a(this.f2248a) != 2) {
                            this.f2248a.m199c(i2, f);
                        }
                        if ((i2 != 0 || i6 == b || atVar.m2648d() == 0) && (f != 0 || i8 == c || atVar.m2649e() == 0)) {
                            atVar.m2652h();
                        }
                    }
                    if (!(i5 == 0 && i7 == 0)) {
                        this.f2248a.m214h(i5, i7);
                    }
                    if (!this.f2248a.awakenScrollBars()) {
                        this.f2248a.invalidate();
                    }
                    obj = (i4 == 0 && this.f2248a.f146e.mo675e() && i7 == i4) ? 1 : null;
                    obj2 = (i3 == 0 && this.f2248a.f146e.mo673d() && i5 == i3) ? 1 : null;
                    obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                    if (!atVar.m2644a() || obj2 == null) {
                        this.f2248a.setScrollState(0);
                    } else {
                        m4616a();
                    }
                }
            }
            i = i7;
            i7 = i6;
            i6 = i;
            if (this.f2248a.f158s.isEmpty()) {
                this.f2248a.invalidate();
            }
            if (bv.m2000a(this.f2248a) != 2) {
                this.f2248a.m154i(i3, i4);
            }
            f = (int) atVar.m2650f();
            if (i6 == b) {
                i2 = 0;
            } else {
                if (i6 >= 0) {
                    if (i6 <= 0) {
                    }
                }
                i2 = e;
            }
            if (i8 != c) {
                f = 0;
            } else if (i8 < 0) {
                f = -f;
            } else if (i8 <= 0) {
                f = 0;
            }
            if (bv.m2000a(this.f2248a) != 2) {
                this.f2248a.m199c(i2, f);
            }
            atVar.m2652h();
            this.f2248a.m214h(i5, i7);
            if (this.f2248a.awakenScrollBars()) {
                this.f2248a.invalidate();
            }
            if (i4 == 0) {
            }
            if (i3 == 0) {
            }
            if (i3 == 0) {
            }
            if (atVar.m2644a()) {
            }
            this.f2248a.setScrollState(0);
        }
        if (etVar != null) {
            if (etVar.m4580b()) {
                etVar.m4572a(0, 0);
            }
            if (!this.f2254g) {
                etVar.m4575a();
            }
        }
        m4615d();
    }
}
