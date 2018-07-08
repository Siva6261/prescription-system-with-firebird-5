package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class cc implements AnimationListener {
    final /* synthetic */ cb f417a;

    cc(cb cbVar) {
        this.f417a = cbVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f417a.f414c == animation) {
            this.f417a.f414c = null;
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
