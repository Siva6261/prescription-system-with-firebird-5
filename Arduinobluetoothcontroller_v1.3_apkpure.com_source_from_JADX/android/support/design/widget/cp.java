package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

class cp extends cm {
    private static final Handler f429a = new Handler(Looper.getMainLooper());
    private long f430b;
    private boolean f431c;
    private final int[] f432d = new int[2];
    private final float[] f433e = new float[2];
    private int f434f = 200;
    private Interpolator f435g;
    private cn f436h;
    private co f437i;
    private float f438j;
    private final Runnable f439k = new cq(this);

    cp() {
    }

    private void m733g() {
        if (this.f431c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f430b)) / ((float) this.f434f);
            if (this.f435g != null) {
                uptimeMillis = this.f435g.getInterpolation(uptimeMillis);
            }
            this.f438j = uptimeMillis;
            if (this.f437i != null) {
                this.f437i.mo124a();
            }
            if (SystemClock.uptimeMillis() >= this.f430b + ((long) this.f434f)) {
                this.f431c = false;
                if (this.f436h != null) {
                    this.f436h.m730b();
                }
            }
        }
        if (this.f431c) {
            f429a.postDelayed(this.f439k, 10);
        }
    }

    public void mo125a() {
        if (!this.f431c) {
            if (this.f435g == null) {
                this.f435g = new AccelerateDecelerateInterpolator();
            }
            this.f430b = SystemClock.uptimeMillis();
            this.f431c = true;
            if (this.f436h != null) {
                this.f436h.m729a();
            }
            f429a.postDelayed(this.f439k, 10);
        }
    }

    public void mo126a(float f, float f2) {
        this.f433e[0] = f;
        this.f433e[1] = f2;
    }

    public void mo127a(int i) {
        this.f434f = i;
    }

    public void mo128a(int i, int i2) {
        this.f432d[0] = i;
        this.f432d[1] = i2;
    }

    public void mo129a(co coVar) {
        this.f437i = coVar;
    }

    public void mo130a(Interpolator interpolator) {
        this.f435g = interpolator;
    }

    public boolean mo131b() {
        return this.f431c;
    }

    public int mo132c() {
        return C0031a.m496a(this.f432d[0], this.f432d[1], m744f());
    }

    public float mo133d() {
        return C0031a.m495a(this.f433e[0], this.f433e[1], m744f());
    }

    public void mo134e() {
        this.f431c = false;
        f429a.removeCallbacks(this.f439k);
        if (this.f436h != null) {
            this.f436h.m731c();
        }
    }

    public float m744f() {
        return this.f438j;
    }
}
