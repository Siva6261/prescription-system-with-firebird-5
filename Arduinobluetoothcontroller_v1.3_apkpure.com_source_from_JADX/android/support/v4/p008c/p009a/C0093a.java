package android.support.v4.p008c.p009a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class C0093a {
    public static Drawable m1308a(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? C0094b.m1309a(resources, i, theme) : resources.getDrawable(i);
    }
}
