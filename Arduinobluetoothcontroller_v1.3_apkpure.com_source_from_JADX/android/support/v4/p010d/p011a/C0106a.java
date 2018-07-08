package android.support.v4.p010d.p011a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class C0106a {
    static final C0112c f807a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f807a = new C0119i();
        } else if (i >= 21) {
            f807a = new C0118h();
        } else if (i >= 19) {
            f807a = new C0117g();
        } else if (i >= 17) {
            f807a = new C0116f();
        } else if (i >= 11) {
            f807a = new C0115e();
        } else if (i >= 5) {
            f807a = new C0114d();
        } else {
            f807a = new C0113b();
        }
    }

    public static void m1332a(Drawable drawable) {
        f807a.mo218a(drawable);
    }

    public static void m1333a(Drawable drawable, float f, float f2) {
        f807a.mo219a(drawable, f, f2);
    }

    public static void m1334a(Drawable drawable, int i) {
        f807a.mo220a(drawable, i);
    }

    public static void m1335a(Drawable drawable, int i, int i2, int i3, int i4) {
        f807a.mo221a(drawable, i, i2, i3, i4);
    }

    public static void m1336a(Drawable drawable, ColorStateList colorStateList) {
        f807a.mo222a(drawable, colorStateList);
    }

    public static void m1337a(Drawable drawable, Theme theme) {
        f807a.mo223a(drawable, theme);
    }

    public static void m1338a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f807a.mo224a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void m1339a(Drawable drawable, Mode mode) {
        f807a.mo225a(drawable, mode);
    }

    public static void m1340a(Drawable drawable, boolean z) {
        f807a.mo226a(drawable, z);
    }

    public static void m1341b(Drawable drawable, int i) {
        f807a.mo227b(drawable, i);
    }

    public static boolean m1342b(Drawable drawable) {
        return f807a.mo228b(drawable);
    }

    public static int m1343c(Drawable drawable) {
        return f807a.mo231e(drawable);
    }

    public static boolean m1344d(Drawable drawable) {
        return f807a.mo232f(drawable);
    }

    public static ColorFilter m1345e(Drawable drawable) {
        return f807a.mo233g(drawable);
    }

    public static Drawable m1346f(Drawable drawable) {
        return f807a.mo229c(drawable);
    }

    public static int m1347g(Drawable drawable) {
        return f807a.mo230d(drawable);
    }
}
