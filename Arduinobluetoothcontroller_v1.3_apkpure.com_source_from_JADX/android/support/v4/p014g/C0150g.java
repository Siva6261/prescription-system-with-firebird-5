package android.support.v4.p014g;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class C0150g {
    private static Method f828a;
    private static Method f829b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f828a = cls.getMethod("getScript", new Class[]{String.class});
                f829b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f828a = null;
            f829b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    private static String m1471a(String str) {
        try {
            if (f828a != null) {
                return (String) f828a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String m1472a(Locale locale) {
        String b = C0150g.m1473b(locale);
        return b != null ? C0150g.m1471a(b) : null;
    }

    private static String m1473b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f829b != null) {
                return (String) f829b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
