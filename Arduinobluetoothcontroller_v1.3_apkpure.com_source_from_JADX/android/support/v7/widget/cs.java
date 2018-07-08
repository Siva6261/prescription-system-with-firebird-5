package android.support.v7.widget;

import android.view.View;

class cs {
    int f2140a;
    int f2141b;
    boolean f2142c;
    final /* synthetic */ LinearLayoutManager f2143d;

    cs(LinearLayoutManager linearLayoutManager) {
        this.f2143d = linearLayoutManager;
    }

    private boolean m4370a(View view, ev evVar) {
        ej ejVar = (ej) view.getLayoutParams();
        return !ejVar.m4358c() && ejVar.m4360e() >= 0 && ejVar.m4360e() < evVar.m4610e();
    }

    void m4371a() {
        this.f2140a = -1;
        this.f2141b = Integer.MIN_VALUE;
        this.f2142c = false;
    }

    public void m4372a(View view) {
        int b = this.f2143d.f1777j.m4414b();
        if (b >= 0) {
            m4374b(view);
            return;
        }
        this.f2140a = this.f2143d.m3694d(view);
        int c;
        if (this.f2142c) {
            b = (this.f2143d.f1777j.mo736d() - b) - this.f2143d.f1777j.mo733b(view);
            this.f2141b = this.f2143d.f1777j.mo736d() - b;
            if (b > 0) {
                c = this.f2141b - this.f2143d.f1777j.mo735c(view);
                int c2 = this.f2143d.f1777j.mo734c();
                c -= c2 + Math.min(this.f2143d.f1777j.mo731a(view) - c2, 0);
                if (c < 0) {
                    this.f2141b = Math.min(b, -c) + this.f2141b;
                    return;
                }
                return;
            }
            return;
        }
        c = this.f2143d.f1777j.mo731a(view);
        c2 = c - this.f2143d.f1777j.mo734c();
        this.f2141b = c;
        if (c2 > 0) {
            b = (this.f2143d.f1777j.mo736d() - Math.min(0, (this.f2143d.f1777j.mo736d() - b) - this.f2143d.f1777j.mo733b(view))) - (c + this.f2143d.f1777j.mo735c(view));
            if (b < 0) {
                this.f2141b -= Math.min(c2, -b);
            }
        }
    }

    void m4373b() {
        this.f2141b = this.f2142c ? this.f2143d.f1777j.mo736d() : this.f2143d.f1777j.mo734c();
    }

    public void m4374b(View view) {
        if (this.f2142c) {
            this.f2141b = this.f2143d.f1777j.mo733b(view) + this.f2143d.f1777j.m4414b();
        } else {
            this.f2141b = this.f2143d.f1777j.mo731a(view);
        }
        this.f2140a = this.f2143d.m3694d(view);
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.f2140a + ", mCoordinate=" + this.f2141b + ", mLayoutFromEnd=" + this.f2142c + '}';
    }
}
