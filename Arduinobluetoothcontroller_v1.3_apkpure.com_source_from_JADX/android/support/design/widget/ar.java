package android.support.design.widget;

import android.view.animation.Animation;

class ar extends C0033b {
    final /* synthetic */ ba f349a;
    final /* synthetic */ ap f350b;

    ar(ap apVar, ba baVar) {
        this.f350b = apVar;
        this.f349a = baVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f349a != null) {
            this.f349a.mo73a();
        }
    }
}
