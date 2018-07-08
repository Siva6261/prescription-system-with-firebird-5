package android.support.design.widget;

import android.support.v4.view.bv;
import android.support.v4.widget.bn;
import android.view.View;
import android.view.ViewParent;

class ce extends bn {
    final /* synthetic */ SwipeDismissBehavior f420a;
    private int f421b;

    ce(SwipeDismissBehavior swipeDismissBehavior) {
        this.f420a = swipeDismissBehavior;
    }

    private boolean m696a(View view, float f) {
        if (f != 0.0f) {
            boolean z = bv.m2031h(view) == 1;
            return this.f420a.f297f == 2 ? true : this.f420a.f297f == 0 ? z ? f < 0.0f : f > 0.0f : this.f420a.f297f == 1 ? z ? f > 0.0f : f < 0.0f : false;
        } else {
            return Math.abs(view.getLeft() - this.f421b) >= Math.round(((float) view.getWidth()) * this.f420a.f298g);
        }
    }

    public int mo116a(View view, int i, int i2) {
        return view.getTop();
    }

    public void mo117a(int i) {
        if (this.f420a.f293b != null) {
            this.f420a.f293b.mo107a(i);
        }
    }

    public void mo118a(View view, float f, float f2) {
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int width = view.getWidth();
        if (m696a(view, f)) {
            width = view.getLeft() < this.f421b ? this.f421b - width : this.f421b + width;
            z = true;
        } else {
            width = this.f421b;
        }
        if (this.f420a.f292a.m2741a(width, view.getTop())) {
            bv.m2010a(view, new cg(this.f420a, view, z));
        } else if (z && this.f420a.f293b != null) {
            this.f420a.f293b.mo108a(view);
        }
    }

    public void mo119a(View view, int i, int i2, int i3, int i4) {
        float width = ((float) this.f421b) + (((float) view.getWidth()) * this.f420a.f299h);
        float width2 = ((float) this.f421b) + (((float) view.getWidth()) * this.f420a.f300i);
        if (((float) i) <= width) {
            bv.m2019c(view, 1.0f);
        } else if (((float) i) >= width2) {
            bv.m2019c(view, 0.0f);
        } else {
            bv.m2019c(view, SwipeDismissBehavior.m483c(0.0f, 1.0f - SwipeDismissBehavior.m476a(width, width2, (float) i), 1.0f));
        }
    }

    public boolean mo120a(View view, int i) {
        return this.f420a.mo115a(view);
    }

    public int mo121b(View view) {
        return view.getWidth();
    }

    public int mo122b(View view, int i, int i2) {
        int width;
        int i3;
        Object obj = bv.m2031h(view) == 1 ? 1 : null;
        if (this.f420a.f297f == 0) {
            if (obj != null) {
                width = this.f421b - view.getWidth();
                i3 = this.f421b;
            } else {
                width = this.f421b;
                i3 = this.f421b + view.getWidth();
            }
        } else if (this.f420a.f297f != 1) {
            width = this.f421b - view.getWidth();
            i3 = this.f421b + view.getWidth();
        } else if (obj != null) {
            width = this.f421b;
            i3 = this.f421b + view.getWidth();
        } else {
            width = this.f421b - view.getWidth();
            i3 = this.f421b;
        }
        return SwipeDismissBehavior.m481b(width, i, i3);
    }

    public void mo123b(View view, int i) {
        this.f421b = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
}
