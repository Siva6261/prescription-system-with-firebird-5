package android.support.v7.widget;

import android.view.View;

class cp {
    boolean f2129a = true;
    int f2130b;
    int f2131c;
    int f2132d;
    int f2133e;
    int f2134f = 0;
    int f2135g = 0;
    boolean f2136h;
    boolean f2137i;

    cp() {
    }

    View m4367a(eo eoVar) {
        View c = eoVar.m4547c(this.f2131c);
        this.f2131c += this.f2132d;
        return c;
    }

    boolean m4368a(ev evVar) {
        return this.f2131c >= 0 && this.f2131c < evVar.m4610e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2130b + ", mCurrentPosition=" + this.f2131c + ", mItemDirection=" + this.f2132d + ", mLayoutDirection=" + this.f2133e + ", mStartLine=" + this.f2134f + ", mEndLine=" + this.f2135g + '}';
    }
}
