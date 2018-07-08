package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class cu {
    static final cz f993a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f993a = new cy();
        } else if (VERSION.SDK_INT >= 11) {
            f993a = new cx();
        } else if (VERSION.SDK_INT >= 8) {
            f993a = new cw();
        } else {
            f993a = new cv();
        }
    }

    public static int m2315a(ViewConfiguration viewConfiguration) {
        return f993a.mo391a(viewConfiguration);
    }

    public static boolean m2316b(ViewConfiguration viewConfiguration) {
        return f993a.mo392b(viewConfiguration);
    }
}
