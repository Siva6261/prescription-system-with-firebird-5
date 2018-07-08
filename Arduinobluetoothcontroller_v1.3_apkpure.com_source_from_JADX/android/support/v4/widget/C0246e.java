package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class C0246e {
    private static final C0247h f1143a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1143a = new C0250f();
        } else if (i >= 21) {
            f1143a = new C0249i();
        } else {
            f1143a = new C0248g();
        }
    }

    public static Drawable m2765a(CompoundButton compoundButton) {
        return f1143a.mo459a(compoundButton);
    }

    public static void m2766a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1143a.mo460a(compoundButton, colorStateList);
    }

    public static void m2767a(CompoundButton compoundButton, Mode mode) {
        f1143a.mo461a(compoundButton, mode);
    }
}
