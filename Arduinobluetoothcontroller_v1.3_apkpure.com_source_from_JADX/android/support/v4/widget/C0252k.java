package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class C0252k {
    private static Field f1144a;
    private static boolean f1145b;

    static Drawable m2778a(CompoundButton compoundButton) {
        if (!f1145b) {
            try {
                f1144a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1144a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f1145b = true;
        }
        if (f1144a != null) {
            try {
                return (Drawable) f1144a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f1144a = null;
            }
        }
        return null;
    }

    static void m2779a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof bj) {
            ((bj) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m2780a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof bj) {
            ((bj) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
