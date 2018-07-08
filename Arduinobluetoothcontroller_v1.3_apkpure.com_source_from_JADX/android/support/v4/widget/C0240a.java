package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.az;
import android.support.v4.view.bv;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class C0240a implements OnTouchListener {
    private static final int f1069r = ViewConfiguration.getTapTimeout();
    private final C0244c f1070a = new C0244c();
    private final Interpolator f1071b = new AccelerateInterpolator();
    private final View f1072c;
    private Runnable f1073d;
    private float[] f1074e = new float[]{0.0f, 0.0f};
    private float[] f1075f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int f1076g;
    private int f1077h;
    private float[] f1078i = new float[]{0.0f, 0.0f};
    private float[] f1079j = new float[]{0.0f, 0.0f};
    private float[] f1080k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean f1081l;
    private boolean f1082m;
    private boolean f1083n;
    private boolean f1084o;
    private boolean f1085p;
    private boolean f1086q;

    public C0240a(View view) {
        this.f1072c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2581a((float) i, (float) i);
        m2585b((float) i2, (float) i2);
        m2582a(1);
        m2591e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2589d(0.2f, 0.2f);
        m2587c(1.0f, 1.0f);
        m2586b(f1069r);
        m2588c(500);
        m2590d(500);
    }

    private float m2561a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0240a.m2567b(f * f2, 0.0f, f3);
        b = m2578f(f2 - f4, b) - m2578f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f1071b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f1071b.getInterpolation(b);
        }
        return C0240a.m2567b(f5, -1.0f, 1.0f);
    }

    private float m2562a(int i, float f, float f2, float f3) {
        float a = m2561a(this.f1074e[i], f2, this.f1075f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f1078i[i];
        float f5 = this.f1079j[i];
        float f6 = this.f1080k[i];
        f4 *= f3;
        return a > 0.0f ? C0240a.m2567b(a * f4, f5, f6) : -C0240a.m2567b((-a) * f4, f5, f6);
    }

    private boolean m2564a() {
        C0244c c0244c = this.f1070a;
        int f = c0244c.m2762f();
        int e = c0244c.m2761e();
        return (f != 0 && mo473f(f)) || (e != 0 && mo472e(e));
    }

    private static float m2567b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private static int m2568b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void m2569b() {
        if (this.f1073d == null) {
            this.f1073d = new C0245d();
        }
        this.f1084o = true;
        this.f1082m = true;
        if (this.f1081l || this.f1077h <= 0) {
            this.f1073d.run();
        } else {
            bv.m2011a(this.f1072c, this.f1073d, (long) this.f1077h);
        }
        this.f1081l = true;
    }

    private void m2573c() {
        if (this.f1082m) {
            this.f1084o = false;
        } else {
            this.f1070a.m2757b();
        }
    }

    private void m2575d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1072c.onTouchEvent(obtain);
        obtain.recycle();
    }

    private float m2578f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1076g) {
            case 0:
            case 1:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.f1084o && this.f1076g == 1) ? 1.0f : 0.0f : 0.0f;
            case 2:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    public C0240a m2581a(float f, float f2) {
        this.f1080k[0] = f / 1000.0f;
        this.f1080k[1] = f2 / 1000.0f;
        return this;
    }

    public C0240a m2582a(int i) {
        this.f1076g = i;
        return this;
    }

    public C0240a m2583a(boolean z) {
        if (this.f1085p && !z) {
            m2573c();
        }
        this.f1085p = z;
        return this;
    }

    public abstract void mo471a(int i, int i2);

    public C0240a m2585b(float f, float f2) {
        this.f1079j[0] = f / 1000.0f;
        this.f1079j[1] = f2 / 1000.0f;
        return this;
    }

    public C0240a m2586b(int i) {
        this.f1077h = i;
        return this;
    }

    public C0240a m2587c(float f, float f2) {
        this.f1078i[0] = f / 1000.0f;
        this.f1078i[1] = f2 / 1000.0f;
        return this;
    }

    public C0240a m2588c(int i) {
        this.f1070a.m2756a(i);
        return this;
    }

    public C0240a m2589d(float f, float f2) {
        this.f1074e[0] = f;
        this.f1074e[1] = f2;
        return this;
    }

    public C0240a m2590d(int i) {
        this.f1070a.m2758b(i);
        return this;
    }

    public C0240a m2591e(float f, float f2) {
        this.f1075f[0] = f;
        this.f1075f[1] = f2;
        return this;
    }

    public abstract boolean mo472e(int i);

    public abstract boolean mo473f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1085p) {
            return false;
        }
        switch (az.m1904a(motionEvent)) {
            case 0:
                this.f1083n = true;
                this.f1081l = false;
                break;
            case 1:
            case 3:
                m2573c();
                break;
            case 2:
                break;
        }
        this.f1070a.m2755a(m2562a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1072c.getWidth()), m2562a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1072c.getHeight()));
        if (!this.f1084o && m2564a()) {
            m2569b();
        }
        if (!(this.f1086q && this.f1084o)) {
            z = false;
        }
        return z;
    }
}
