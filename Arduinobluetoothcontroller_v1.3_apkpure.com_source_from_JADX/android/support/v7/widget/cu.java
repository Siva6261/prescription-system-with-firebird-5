package android.support.v7.widget;

import android.view.View;
import java.util.List;

class cu {
    boolean f2148a = true;
    int f2149b;
    int f2150c;
    int f2151d;
    int f2152e;
    int f2153f;
    int f2154g;
    int f2155h = 0;
    boolean f2156i = false;
    int f2157j;
    List f2158k = null;
    boolean f2159l;

    cu() {
    }

    private View m4376b() {
        int size = this.f2158k.size();
        for (int i = 0; i < size; i++) {
            View view = ((ey) this.f2158k.get(i)).f2256a;
            ej ejVar = (ej) view.getLayoutParams();
            if (!ejVar.m4358c() && this.f2151d == ejVar.m4360e()) {
                m4379a(view);
                return view;
            }
        }
        return null;
    }

    View m4377a(eo eoVar) {
        if (this.f2158k != null) {
            return m4376b();
        }
        View c = eoVar.m4547c(this.f2151d);
        this.f2151d += this.f2152e;
        return c;
    }

    public void m4378a() {
        m4379a(null);
    }

    public void m4379a(View view) {
        View b = m4381b(view);
        if (b == null) {
            this.f2151d = -1;
        } else {
            this.f2151d = ((ej) b.getLayoutParams()).m4360e();
        }
    }

    boolean m4380a(ev evVar) {
        return this.f2151d >= 0 && this.f2151d < evVar.m4610e();
    }

    public View m4381b(View view) {
        int size = this.f2158k.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            int i3;
            View view3;
            View view4 = ((ey) this.f2158k.get(i2)).f2256a;
            ej ejVar = (ej) view4.getLayoutParams();
            if (view4 != view) {
                if (ejVar.m4358c()) {
                    i3 = i;
                    view3 = view2;
                } else {
                    i3 = (ejVar.m4360e() - this.f2151d) * this.f2152e;
                    if (i3 < 0) {
                        i3 = i;
                        view3 = view2;
                    } else if (i3 < i) {
                        if (i3 == 0) {
                            return view4;
                        }
                        view3 = view4;
                    }
                }
                i2++;
                view2 = view3;
                i = i3;
            }
            i3 = i;
            view3 = view2;
            i2++;
            view2 = view3;
            i = i3;
        }
        return view2;
    }
}
