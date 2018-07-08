package android.support.design.widget;

import android.view.animation.Animation;

class aq extends C0033b {
    final /* synthetic */ boolean f346a;
    final /* synthetic */ ba f347b;
    final /* synthetic */ ap f348c;

    aq(ap apVar, boolean z, ba baVar) {
        this.f348c = apVar;
        this.f346a = z;
        this.f347b = baVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f348c.f345o = false;
        this.f348c.k.m436a(8, this.f346a);
        if (this.f347b != null) {
            this.f347b.mo74b();
        }
    }

    public void onAnimationStart(Animation animation) {
        this.f348c.f345o = true;
    }
}
