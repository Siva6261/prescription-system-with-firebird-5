package android.support.v4.p006b;

import android.content.Context;
import android.os.Build.VERSION;

public final class C0079i {
    private static final C0081l f734a;

    static {
        if (VERSION.SDK_INT >= 23) {
            f734a = new C0082k();
        } else {
            f734a = new C0081l();
        }
    }

    public static int m1253a(Context context, String str, String str2) {
        return f734a.mo200a(context, str, str2);
    }

    public static String m1254a(String str) {
        return f734a.mo201a(str);
    }
}
