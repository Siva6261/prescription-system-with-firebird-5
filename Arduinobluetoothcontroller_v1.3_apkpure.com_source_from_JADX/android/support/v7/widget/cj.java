package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.p010d.p011a.C0107q;
import android.support.v7.p003c.p004a.C0034a;

class cj {
    public static final Rect f2119a = new Rect();
    private static Class f2120b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f2120b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    static Mode m4346a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return VERSION.SDK_INT >= 11 ? Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }

    static void m4347a(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m4349c(drawable);
        }
    }

    static boolean m4348b(Drawable drawable) {
        if (drawable instanceof LayerDrawable) {
            return VERSION.SDK_INT >= 16;
        } else if (drawable instanceof InsetDrawable) {
            return VERSION.SDK_INT >= 14;
        } else {
            if (drawable instanceof StateListDrawable) {
                return VERSION.SDK_INT >= 8;
            } else {
                if (drawable instanceof GradientDrawable) {
                    return VERSION.SDK_INT >= 14;
                } else {
                    if (!(drawable instanceof DrawableContainer)) {
                        return drawable instanceof C0107q ? m4348b(((C0107q) drawable).mo209a()) : drawable instanceof C0034a ? m4348b(((C0034a) drawable).m611b()) : true;
                    } else {
                        ConstantState constantState = drawable.getConstantState();
                        if (!(constantState instanceof DrawableContainerState)) {
                            return true;
                        }
                        for (Drawable b : ((DrawableContainerState) constantState).getChildren()) {
                            if (!m4348b(b)) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    private static void m4349c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(ga.f2364e);
        } else {
            drawable.setState(ga.f2367h);
        }
        drawable.setState(state);
    }
}
