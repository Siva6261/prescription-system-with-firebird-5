package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class cj {
    private static Field f988a;
    private static boolean f989b;
    private static Field f990c;
    private static boolean f991d;

    static ColorStateList m2244a(View view) {
        return view instanceof bp ? ((bp) view).getSupportBackgroundTintList() : null;
    }

    static void m2245a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m2246a(View view, ColorStateList colorStateList) {
        if (view instanceof bp) {
            ((bp) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static void m2247a(View view, Mode mode) {
        if (view instanceof bp) {
            ((bp) view).setSupportBackgroundTintMode(mode);
        }
    }

    static Mode m2248b(View view) {
        return view instanceof bp ? ((bp) view).getSupportBackgroundTintMode() : null;
    }

    static void m2249b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    static boolean m2250c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m2251d(View view) {
        if (!f989b) {
            try {
                f988a = View.class.getDeclaredField("mMinWidth");
                f988a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f989b = true;
        }
        if (f988a != null) {
            try {
                return ((Integer) f988a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m2252e(View view) {
        if (!f991d) {
            try {
                f990c = View.class.getDeclaredField("mMinHeight");
                f990c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f991d = true;
        }
        if (f990c != null) {
            try {
                return ((Integer) f990c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m2253f(View view) {
        return view.getWindowToken() != null;
    }
}
