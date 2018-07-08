package android.support.v4.p014g;

import android.os.Build.VERSION;
import java.util.Locale;

public final class C0160q {
    public static final Locale f843a = new Locale("", "");
    private static final C0162s f844b;
    private static String f845c = "Arab";
    private static String f846d = "Hebr";

    static {
        if (VERSION.SDK_INT >= 17) {
            f844b = new C0163t();
        } else {
            f844b = new C0162s();
        }
    }

    public static int m1487a(Locale locale) {
        return f844b.mo239a(locale);
    }
}
