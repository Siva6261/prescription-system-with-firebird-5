package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class cs implements AnimatorUpdateListener {
    final /* synthetic */ co f442a;
    final /* synthetic */ cr f443b;

    cs(cr crVar, co coVar) {
        this.f443b = crVar;
        this.f442a = coVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f442a.mo124a();
    }
}
