package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.v4.view.bv;
import android.view.View;
import android.view.ViewParent;

class da {
    private final View f451a;
    private int f452b;
    private int f453c;
    private int f454d;
    private int f455e;

    public da(View view) {
        this.f451a = view;
    }

    private static void m763a(View view) {
        float n = bv.m2037n(view);
        bv.m2015b(view, 1.0f + n);
        bv.m2015b(view, n);
    }

    private void m764c() {
        bv.m2027e(this.f451a, this.f454d - (this.f451a.getTop() - this.f452b));
        bv.m2029f(this.f451a, this.f455e - (this.f451a.getLeft() - this.f453c));
        if (VERSION.SDK_INT < 23) {
            m763a(this.f451a);
            ViewParent parent = this.f451a.getParent();
            if (parent instanceof View) {
                m763a((View) parent);
            }
        }
    }

    public void m765a() {
        this.f452b = this.f451a.getTop();
        this.f453c = this.f451a.getLeft();
        m764c();
    }

    public boolean m766a(int i) {
        if (this.f454d == i) {
            return false;
        }
        this.f454d = i;
        m764c();
        return true;
    }

    public int m767b() {
        return this.f454d;
    }

    public boolean m768b(int i) {
        if (this.f455e == i) {
            return false;
        }
        this.f455e = i;
        m764c();
        return true;
    }
}
