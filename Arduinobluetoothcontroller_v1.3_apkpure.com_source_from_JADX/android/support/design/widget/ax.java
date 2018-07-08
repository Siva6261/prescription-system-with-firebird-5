package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ax extends AnimatorListenerAdapter {
    final /* synthetic */ boolean f361a;
    final /* synthetic */ ba f362b;
    final /* synthetic */ av f363c;

    ax(av avVar, boolean z, ba baVar) {
        this.f363c = avVar;
        this.f361a = z;
        this.f362b = baVar;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f362b != null) {
            this.f362b.mo73a();
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f363c.k.m436a(0, this.f361a);
    }
}
