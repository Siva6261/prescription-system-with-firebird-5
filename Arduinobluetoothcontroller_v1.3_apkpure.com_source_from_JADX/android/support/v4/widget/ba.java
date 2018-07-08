package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class ba {
    static final bg f1106a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1106a = new bb();
        } else if (i >= 18) {
            f1106a = new be();
        } else if (i >= 17) {
            f1106a = new bd();
        } else if (i >= 16) {
            f1106a = new bf();
        } else {
            f1106a = new bc();
        }
    }

    public static void m2710a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1106a.mo458a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
