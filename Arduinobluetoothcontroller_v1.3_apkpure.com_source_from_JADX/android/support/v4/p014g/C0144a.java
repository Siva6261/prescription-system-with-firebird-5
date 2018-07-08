package android.support.v4.p014g;

import android.os.Build.VERSION;
import java.util.Locale;

public final class C0144a {
    private static final C0145b f826a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f826a = new C0148e();
        } else if (i >= 14) {
            f826a = new C0147d();
        } else {
            f826a = new C0146c();
        }
    }

    public static String m1465a(Locale locale) {
        return f826a.mo235a(locale);
    }
}
