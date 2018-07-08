package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class aw extends AnimatorListenerAdapter {
    final /* synthetic */ boolean f357a;
    final /* synthetic */ ba f358b;
    final /* synthetic */ av f359c;
    private boolean f360d;

    aw(av avVar, boolean z, ba baVar) {
        this.f359c = avVar;
        this.f357a = z;
        this.f358b = baVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f359c.f356m = false;
        this.f360d = true;
    }

    public void onAnimationEnd(Animator animator) {
        this.f359c.f356m = false;
        if (!this.f360d) {
            this.f359c.k.m436a(8, this.f357a);
            if (this.f358b != null) {
                this.f358b.mo74b();
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f359c.f356m = true;
        this.f360d = false;
        this.f359c.k.m436a(0, this.f357a);
    }
}
