package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bj implements AnimationListener {
    final /* synthetic */ int f388a;
    final /* synthetic */ Snackbar f389b;

    bj(Snackbar snackbar, int i) {
        this.f389b = snackbar;
        this.f388a = i;
    }

    public void onAnimationEnd(Animation animation) {
        this.f389b.m467f(this.f388a);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
