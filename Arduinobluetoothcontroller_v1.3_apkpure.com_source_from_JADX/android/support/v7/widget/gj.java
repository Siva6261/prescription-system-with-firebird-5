package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.C0314d;
import android.support.v7.view.menu.C0329i;
import android.support.v7.view.menu.C0332x;
import android.support.v7.view.menu.C0337m;
import android.support.v7.view.menu.ad;
import android.view.ViewGroup.LayoutParams;

class gj implements C0332x {
    C0329i f2383a;
    C0337m f2384b;
    final /* synthetic */ Toolbar f2385c;

    private gj(Toolbar toolbar) {
        this.f2385c = toolbar;
    }

    public void mo608a(Context context, C0329i c0329i) {
        if (!(this.f2383a == null || this.f2384b == null)) {
            this.f2383a.mo603d(this.f2384b);
        }
        this.f2383a = c0329i;
    }

    public void mo609a(C0329i c0329i, boolean z) {
    }

    public boolean mo610a(ad adVar) {
        return false;
    }

    public boolean mo611a(C0329i c0329i, C0337m c0337m) {
        this.f2385c.m3985p();
        if (this.f2385c.f1881i.getParent() != this.f2385c) {
            this.f2385c.addView(this.f2385c.f1881i);
        }
        this.f2385c.f1873a = c0337m.getActionView();
        this.f2384b = c0337m;
        if (this.f2385c.f1873a.getParent() != this.f2385c) {
            LayoutParams i = this.f2385c.m4003i();
            i.a = 8388611 | (this.f2385c.f1886n & 112);
            i.f2386b = 2;
            this.f2385c.f1873a.setLayoutParams(i);
            this.f2385c.addView(this.f2385c.f1873a);
        }
        this.f2385c.m4004j();
        this.f2385c.requestLayout();
        c0337m.m3469e(true);
        if (this.f2385c.f1873a instanceof C0314d) {
            ((C0314d) this.f2385c.f1873a).mo620a();
        }
        return true;
    }

    public void mo612b(boolean z) {
        Object obj = null;
        if (this.f2384b != null) {
            if (this.f2383a != null) {
                int size = this.f2383a.size();
                for (int i = 0; i < size; i++) {
                    if (this.f2383a.getItem(i) == this.f2384b) {
                        obj = 1;
                        break;
                    }
                }
            }
            if (obj == null) {
                mo614b(this.f2383a, this.f2384b);
            }
        }
    }

    public boolean mo613b() {
        return false;
    }

    public boolean mo614b(C0329i c0329i, C0337m c0337m) {
        if (this.f2385c.f1873a instanceof C0314d) {
            ((C0314d) this.f2385c.f1873a).mo621b();
        }
        this.f2385c.removeView(this.f2385c.f1873a);
        this.f2385c.removeView(this.f2385c.f1881i);
        this.f2385c.f1873a = null;
        this.f2385c.m4005k();
        this.f2384b = null;
        this.f2385c.requestLayout();
        c0337m.m3469e(false);
        return true;
    }
}
