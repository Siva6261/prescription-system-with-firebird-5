package android.support.v4.p010d.p011a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class C0126p {
    public static Drawable m1438a(Drawable drawable) {
        return !(drawable instanceof aa) ? new aa(drawable) : drawable;
    }

    public static void m1439a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m1440a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m1441a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m1442a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m1443a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static void m1444a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static void m1445a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static boolean m1446b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m1447c(Drawable drawable) {
        return drawable.getColorFilter();
    }
}
