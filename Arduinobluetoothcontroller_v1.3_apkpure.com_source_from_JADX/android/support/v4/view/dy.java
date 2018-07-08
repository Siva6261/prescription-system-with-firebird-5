package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class dy {
    static final ei f1014a;
    private WeakReference f1015b;
    private Runnable f1016c = null;
    private Runnable f1017d = null;
    private int f1018e = -1;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1014a = new eh();
        } else if (i >= 19) {
            f1014a = new eg();
        } else if (i >= 18) {
            f1014a = new ee();
        } else if (i >= 16) {
            f1014a = new ef();
        } else if (i >= 14) {
            f1014a = new ec();
        } else {
            f1014a = new ea();
        }
    }

    dy(View view) {
        this.f1015b = new WeakReference(view);
    }

    public long m2383a() {
        View view = (View) this.f1015b.get();
        return view != null ? f1014a.mo403a(this, view) : 0;
    }

    public dy m2384a(float f) {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo404a(this, view, f);
        }
        return this;
    }

    public dy m2385a(long j) {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo405a(this, view, j);
        }
        return this;
    }

    public dy m2386a(ep epVar) {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo406a(this, view, epVar);
        }
        return this;
    }

    public dy m2387a(er erVar) {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo407a(this, view, erVar);
        }
        return this;
    }

    public dy m2388a(Interpolator interpolator) {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo408a(this, view, interpolator);
        }
        return this;
    }

    public dy m2389b(float f) {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo410b(this, view, f);
        }
        return this;
    }

    public dy m2390b(long j) {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo411b(this, view, j);
        }
        return this;
    }

    public void m2391b() {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo409b(this, view);
        }
    }

    public dy m2392c(float f) {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo413c(this, view, f);
        }
        return this;
    }

    public void m2393c() {
        View view = (View) this.f1015b.get();
        if (view != null) {
            f1014a.mo412c(this, view);
        }
    }
}
