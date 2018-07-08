package android.support.v4.p010d.p011a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class C0121k {
    public static Drawable m1424a(Drawable drawable) {
        return !(drawable instanceof C0108r) ? new C0108r(drawable) : drawable;
    }

    public static void m1425a(Drawable drawable, int i) {
        if (drawable instanceof C0107q) {
            ((C0107q) drawable).mo210a(i);
        }
    }

    public static void m1426a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0107q) {
            ((C0107q) drawable).mo211a(colorStateList);
        }
    }

    public static void m1427a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    public static void m1428a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0107q) {
            ((C0107q) drawable).mo212a(mode);
        }
    }
}
