package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class eo implements AnimatorUpdateListener {
    final /* synthetic */ er f1030a;
    final /* synthetic */ View f1031b;

    eo(er erVar, View view) {
        this.f1030a = erVar;
        this.f1031b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1030a.mo553a(this.f1031b);
    }
}
