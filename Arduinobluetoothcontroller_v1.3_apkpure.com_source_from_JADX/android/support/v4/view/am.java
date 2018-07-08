package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class am {
    static final an f967a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f967a = new ap();
        } else {
            f967a = new ao();
        }
    }

    public static int m1859a(MarginLayoutParams marginLayoutParams) {
        return f967a.mo296a(marginLayoutParams);
    }

    public static int m1860b(MarginLayoutParams marginLayoutParams) {
        return f967a.mo297b(marginLayoutParams);
    }
}
