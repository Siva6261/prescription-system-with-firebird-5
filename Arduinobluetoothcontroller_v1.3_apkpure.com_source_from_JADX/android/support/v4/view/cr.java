package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.WindowInsets;

class cr {
    public static es m2299a(View view, es esVar) {
        if (!(esVar instanceof et)) {
            return esVar;
        }
        WindowInsets g = ((et) esVar).m2465g();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(g);
        return onApplyWindowInsets != g ? new et(onApplyWindowInsets) : esVar;
    }

    public static void m2300a(View view) {
        view.requestApplyInsets();
    }

    public static void m2301a(View view, float f) {
        view.setElevation(f);
    }

    static void m2302a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    static void m2303a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void m2304a(View view, bm bmVar) {
        if (bmVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new cs(bmVar));
        }
    }

    public static float m2305b(View view) {
        return view.getElevation();
    }

    public static es m2306b(View view, es esVar) {
        if (!(esVar instanceof et)) {
            return esVar;
        }
        WindowInsets g = ((et) esVar).m2465g();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(g);
        return dispatchApplyWindowInsets != g ? new et(dispatchApplyWindowInsets) : esVar;
    }

    public static float m2307c(View view) {
        return view.getTranslationZ();
    }

    static ColorStateList m2308d(View view) {
        return view.getBackgroundTintList();
    }

    static Mode m2309e(View view) {
        return view.getBackgroundTintMode();
    }

    public static void m2310f(View view) {
        view.stopNestedScroll();
    }

    public static float m2311g(View view) {
        return view.getZ();
    }
}
