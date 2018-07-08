package android.support.v4.p007a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

class C0065d implements C0063b {
    private TimeInterpolator f589a;

    C0065d() {
    }

    public void mo160a(View view) {
        if (this.f589a == null) {
            this.f589a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f589a);
    }
}
