package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ek extends AnimatorListenerAdapter {
    final /* synthetic */ ep f1026a;
    final /* synthetic */ View f1027b;

    ek(ep epVar, View view) {
        this.f1026a = epVar;
        this.f1027b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1026a.mo114c(this.f1027b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1026a.mo113b(this.f1027b);
    }

    public void onAnimationStart(Animator animator) {
        this.f1026a.mo112a(this.f1027b);
    }
}
