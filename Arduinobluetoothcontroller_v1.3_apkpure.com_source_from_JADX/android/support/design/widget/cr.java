package android.support.design.widget;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

class cr extends cm {
    final ValueAnimator f441a = new ValueAnimator();

    cr() {
    }

    public void mo125a() {
        this.f441a.start();
    }

    public void mo126a(float f, float f2) {
        this.f441a.setFloatValues(new float[]{f, f2});
    }

    public void mo127a(int i) {
        this.f441a.setDuration((long) i);
    }

    public void mo128a(int i, int i2) {
        this.f441a.setIntValues(new int[]{i, i2});
    }

    public void mo129a(co coVar) {
        this.f441a.addUpdateListener(new cs(this, coVar));
    }

    public void mo130a(Interpolator interpolator) {
        this.f441a.setInterpolator(interpolator);
    }

    public boolean mo131b() {
        return this.f441a.isRunning();
    }

    public int mo132c() {
        return ((Integer) this.f441a.getAnimatedValue()).intValue();
    }

    public float mo133d() {
        return ((Float) this.f441a.getAnimatedValue()).floatValue();
    }

    public void mo134e() {
        this.f441a.cancel();
    }
}
