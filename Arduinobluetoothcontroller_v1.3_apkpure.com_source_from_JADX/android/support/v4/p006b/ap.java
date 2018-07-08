package android.support.v4.p006b;

import android.view.View;
import android.view.animation.Animation;

class ap extends aq {
    final /* synthetic */ C0051y f656a;
    final /* synthetic */ am f657b;

    ap(am amVar, View view, Animation animation, C0051y c0051y) {
        this.f657b = amVar;
        this.f656a = c0051y;
        super(view, animation);
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.f656a.f501l != null) {
            this.f656a.f501l = null;
            this.f657b.m1088a(this.f656a, this.f656a.f502m, 0, 0, false);
        }
    }
}
