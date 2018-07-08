package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class br implements AnimationListener {
    final /* synthetic */ Snackbar f398a;

    br(Snackbar snackbar) {
        this.f398a = snackbar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f398a.m466f();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
