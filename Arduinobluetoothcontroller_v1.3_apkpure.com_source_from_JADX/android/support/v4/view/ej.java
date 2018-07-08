package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;

class ej {
    public static long m2438a(View view) {
        return view.animate().getDuration();
    }

    public static void m2439a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m2440a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m2441a(View view, ep epVar) {
        if (epVar != null) {
            view.animate().setListener(new ek(epVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public static void m2442a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m2443b(View view) {
        view.animate().cancel();
    }

    public static void m2444b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m2445b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m2446c(View view) {
        view.animate().start();
    }

    public static void m2447c(View view, float f) {
        view.animate().translationY(f);
    }
}
