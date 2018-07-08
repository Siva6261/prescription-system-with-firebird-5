package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

abstract class as extends Animation {
    final /* synthetic */ ap f351a;
    private float f352b;
    private float f353c;

    private as(ap apVar) {
        this.f351a = apVar;
    }

    protected abstract float mo95a();

    protected void applyTransformation(float f, Transformation transformation) {
        this.f351a.f342a.m622b(this.f352b + (this.f353c * f));
    }

    public void reset() {
        super.reset();
        this.f352b = this.f351a.f342a.m618a();
        this.f353c = mo95a() - this.f352b;
    }
}
