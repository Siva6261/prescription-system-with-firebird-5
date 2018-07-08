package android.support.v4.p006b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class aq implements AnimationListener {
    private AnimationListener f653a = null;
    private boolean f654b = false;
    private View f655c = null;

    public aq(View view, Animation animation) {
        if (view != null && animation != null) {
            this.f655c = view;
        }
    }

    public aq(View view, Animation animation, AnimationListener animationListener) {
        if (view != null && animation != null) {
            this.f653a = animationListener;
            this.f655c = view;
        }
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f655c != null && this.f654b) {
            this.f655c.post(new as(this));
        }
        if (this.f653a != null) {
            this.f653a.onAnimationEnd(animation);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        if (this.f653a != null) {
            this.f653a.onAnimationRepeat(animation);
        }
    }

    public void onAnimationStart(Animation animation) {
        if (this.f655c != null) {
            this.f654b = am.m1065a(this.f655c, animation);
            if (this.f654b) {
                this.f655c.post(new ar(this));
            }
        }
        if (this.f653a != null) {
            this.f653a.onAnimationStart(animation);
        }
    }
}
