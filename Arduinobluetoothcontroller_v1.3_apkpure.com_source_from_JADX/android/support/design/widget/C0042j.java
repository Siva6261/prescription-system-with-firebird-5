package android.support.design.widget;

import android.support.v4.view.bv;
import android.support.v4.widget.bn;
import android.view.View;

class C0042j extends bn {
    final /* synthetic */ BottomSheetBehavior f463a;

    C0042j(BottomSheetBehavior bottomSheetBehavior) {
        this.f463a = bottomSheetBehavior;
    }

    public int mo138a(View view) {
        return this.f463a.f201e ? this.f463a.f207k - this.f463a.f199c : this.f463a.f200d - this.f463a.f199c;
    }

    public int mo116a(View view, int i, int i2) {
        return bf.m609a(i, this.f463a.f199c, this.f463a.f201e ? this.f463a.f207k : this.f463a.f200d);
    }

    public void mo117a(int i) {
        if (i == 1) {
            this.f463a.m345b(1);
        }
    }

    public void mo118a(View view, float f, float f2) {
        int f3;
        int i = 3;
        if (f2 < 0.0f) {
            f3 = this.f463a.f199c;
        } else if (this.f463a.f201e && this.f463a.m342a(view, f2)) {
            f3 = this.f463a.f207k;
            i = 5;
        } else if (f2 == 0.0f) {
            int top = view.getTop();
            if (Math.abs(top - this.f463a.f199c) < Math.abs(top - this.f463a.f200d)) {
                f3 = this.f463a.f199c;
            } else {
                f3 = this.f463a.f200d;
                i = 4;
            }
        } else {
            f3 = this.f463a.f200d;
            i = 4;
        }
        if (this.f463a.f203g.m2741a(view.getLeft(), f3)) {
            this.f463a.m345b(2);
            bv.m2010a(view, new C0046n(this.f463a, view, i));
            return;
        }
        this.f463a.m345b(i);
    }

    public void mo119a(View view, int i, int i2, int i3, int i4) {
        this.f463a.m349c(i2);
    }

    public boolean mo120a(View view, int i) {
        if (this.f463a.f202f == 1 || this.f463a.f214r) {
            return false;
        }
        if (this.f463a.f202f == 3 && this.f463a.f212p == i) {
            View view2 = (View) this.f463a.f209m.get();
            if (view2 != null && bv.m2018b(view2, -1)) {
                return false;
            }
        }
        boolean z = this.f463a.f208l != null && this.f463a.f208l.get() == view;
        return z;
    }

    public int mo122b(View view, int i, int i2) {
        return view.getLeft();
    }
}
