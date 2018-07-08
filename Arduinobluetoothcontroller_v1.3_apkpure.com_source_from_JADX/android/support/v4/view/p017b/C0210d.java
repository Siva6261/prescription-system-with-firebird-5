package android.support.v4.view.p017b;

import android.view.animation.Interpolator;

abstract class C0210d implements Interpolator {
    private final float[] f970a;
    private final float f971b = (1.0f / ((float) (this.f970a.length - 1)));

    public C0210d(float[] fArr) {
        this.f970a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f970a.length - 1)) * f), this.f970a.length - 2);
        float f2 = (f - (((float) min) * this.f971b)) / this.f971b;
        return ((this.f970a[min + 1] - this.f970a[min]) * f2) + this.f970a[min];
    }
}
