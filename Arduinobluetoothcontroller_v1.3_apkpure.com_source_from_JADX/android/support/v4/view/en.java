package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class en {
    public static void m2449a(View view, er erVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (erVar != null) {
            animatorUpdateListener = new eo(erVar, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
