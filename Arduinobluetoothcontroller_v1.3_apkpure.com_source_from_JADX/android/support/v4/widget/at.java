package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public final class at {
    Object f1104a;
    au f1105b;

    private at(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1105b = new ax();
        } else if (i >= 9) {
            this.f1105b = new aw();
        } else {
            this.f1105b = new av();
        }
        this.f1104a = this.f1105b.mo444a(context, interpolator);
    }

    public static at m2638a(Context context) {
        return m2639a(context, null);
    }

    public static at m2639a(Context context, Interpolator interpolator) {
        return new at(VERSION.SDK_INT, context, interpolator);
    }

    public void m2640a(int i, int i2, int i3, int i4) {
        this.f1105b.mo445a(this.f1104a, i, i2, i3, i4);
    }

    public void m2641a(int i, int i2, int i3, int i4, int i5) {
        this.f1105b.mo446a(this.f1104a, i, i2, i3, i4, i5);
    }

    public void m2642a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1105b.mo447a(this.f1104a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m2643a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1105b.mo448a(this.f1104a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m2644a() {
        return this.f1105b.mo449a(this.f1104a);
    }

    public boolean m2645a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1105b.mo450a(this.f1104a, i, i2, i3, i4, i5, i6);
    }

    public int m2646b() {
        return this.f1105b.mo451b(this.f1104a);
    }

    public int m2647c() {
        return this.f1105b.mo452c(this.f1104a);
    }

    public int m2648d() {
        return this.f1105b.mo456g(this.f1104a);
    }

    public int m2649e() {
        return this.f1105b.mo457h(this.f1104a);
    }

    public float m2650f() {
        return this.f1105b.mo453d(this.f1104a);
    }

    public boolean m2651g() {
        return this.f1105b.mo454e(this.f1104a);
    }

    public void m2652h() {
        this.f1105b.mo455f(this.f1104a);
    }
}
