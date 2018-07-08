package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;

public class eu {
    private int f2229a;
    private int f2230b;
    private int f2231c;
    private int f2232d;
    private Interpolator f2233e;
    private boolean f2234f;
    private int f2235g;

    private void m4584a(RecyclerView recyclerView) {
        if (this.f2232d >= 0) {
            int i = this.f2232d;
            this.f2232d = -1;
            recyclerView.m148e(i);
            this.f2234f = false;
        } else if (this.f2234f) {
            m4586b();
            if (this.f2233e != null) {
                recyclerView.ab.m4620a(this.f2229a, this.f2230b, this.f2231c, this.f2233e);
            } else if (this.f2231c == Integer.MIN_VALUE) {
                recyclerView.ab.m4622b(this.f2229a, this.f2230b);
            } else {
                recyclerView.ab.m4618a(this.f2229a, this.f2230b, this.f2231c);
            }
            this.f2235g++;
            if (this.f2235g > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f2234f = false;
        } else {
            this.f2235g = 0;
        }
    }

    private void m4586b() {
        if (this.f2233e != null && this.f2231c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (this.f2231c < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }

    boolean m4587a() {
        return this.f2232d >= 0;
    }
}
