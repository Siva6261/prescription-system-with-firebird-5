package android.support.v4.p014g;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class C0149f {
    private static Method f827a;

    static {
        try {
            f827a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m1470a(Locale locale) {
        try {
            return ((Locale) f827a.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
