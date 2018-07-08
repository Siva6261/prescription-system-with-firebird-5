package android.support.v7.widget;

import android.util.SparseArray;

public class ev {
    int f2236a = 0;
    private int f2237b = -1;
    private int f2238c = 1;
    private SparseArray f2239d;
    private int f2240e = 0;
    private int f2241f = 0;
    private boolean f2242g = false;
    private boolean f2243h = false;
    private boolean f2244i = false;
    private boolean f2245j = false;
    private boolean f2246k = false;
    private boolean f2247l = false;

    static /* synthetic */ int m4589a(ev evVar, int i) {
        int i2 = evVar.f2241f + i;
        evVar.f2241f = i2;
        return i2;
    }

    void m4605a(int i) {
        if ((this.f2238c & i) == 0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f2238c));
        }
    }

    public boolean m4606a() {
        return this.f2243h;
    }

    public boolean m4607b() {
        return this.f2245j;
    }

    public int m4608c() {
        return this.f2237b;
    }

    public boolean m4609d() {
        return this.f2237b != -1;
    }

    public int m4610e() {
        return this.f2243h ? this.f2240e - this.f2241f : this.f2236a;
    }

    public String toString() {
        return "State{mTargetPosition=" + this.f2237b + ", mData=" + this.f2239d + ", mItemCount=" + this.f2236a + ", mPreviousLayoutItemCount=" + this.f2240e + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2241f + ", mStructureChanged=" + this.f2242g + ", mInPreLayout=" + this.f2243h + ", mRunSimpleAnimations=" + this.f2244i + ", mRunPredictiveAnimations=" + this.f2245j + '}';
    }
}
