package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

class cl {
    public static float m2255a(View view) {
        return view.getAlpha();
    }

    public static int m2256a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static int m2257a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    static long m2258a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m2259a(View view, float f) {
        view.setTranslationX(f);
    }

    static void m2260a(View view, int i) {
        view.offsetTopAndBottom(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m2273h((View) parent);
        }
    }

    public static void m2261a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void m2262a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static int m2263b(View view) {
        return view.getLayerType();
    }

    public static void m2264b(View view, float f) {
        view.setTranslationY(f);
    }

    static void m2265b(View view, int i) {
        view.offsetLeftAndRight(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m2273h((View) parent);
        }
    }

    public static void m2266b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int m2267c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static void m2268c(View view, float f) {
        view.setAlpha(f);
    }

    public static int m2269d(View view) {
        return view.getMeasuredState();
    }

    public static float m2270e(View view) {
        return view.getTranslationX();
    }

    public static float m2271f(View view) {
        return view.getTranslationY();
    }

    public static void m2272g(View view) {
        view.jumpDrawablesToCurrentState();
    }

    private static void m2273h(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
