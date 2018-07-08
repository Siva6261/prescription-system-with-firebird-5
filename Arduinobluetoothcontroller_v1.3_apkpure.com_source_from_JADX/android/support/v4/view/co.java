package android.support.v4.view;

import android.view.View;

class co {
    public static void m2279a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void m2280a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m2281a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static boolean m2282a(View view) {
        return view.hasTransientState();
    }

    public static void m2283b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int m2284c(View view) {
        return view.getImportantForAccessibility();
    }

    public static int m2285d(View view) {
        return view.getMinimumWidth();
    }

    public static int m2286e(View view) {
        return view.getMinimumHeight();
    }

    public static void m2287f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m2288g(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m2289h(View view) {
        return view.hasOverlappingRendering();
    }
}
