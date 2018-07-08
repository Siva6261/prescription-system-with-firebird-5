package android.support.design.widget;

import android.support.v4.view.p017b.C0211a;
import android.support.v4.view.p017b.C0212b;
import android.support.v4.view.p017b.C0213c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class C0031a {
    static final Interpolator f302a = new LinearInterpolator();
    static final Interpolator f303b = new C0212b();
    static final Interpolator f304c = new C0211a();
    static final Interpolator f305d = new C0213c();
    static final Interpolator f306e = new DecelerateInterpolator();

    static float m495a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int m496a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
