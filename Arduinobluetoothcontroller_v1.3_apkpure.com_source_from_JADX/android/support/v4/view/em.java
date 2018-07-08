package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class em extends AnimatorListenerAdapter {
    final /* synthetic */ ep f1028a;
    final /* synthetic */ View f1029b;

    em(ep epVar, View view) {
        this.f1028a = epVar;
        this.f1029b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1028a.mo114c(this.f1029b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1028a.mo113b(this.f1029b);
    }

    public void onAnimationStart(Animator animator) {
        this.f1028a.mo112a(this.f1029b);
    }
}
