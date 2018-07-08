package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class ab {
    static final ac f963a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f963a = new af();
        } else if (i >= 11) {
            f963a = new ae();
        } else {
            f963a = new ad();
        }
    }

    public static al m1846a(LayoutInflater layoutInflater) {
        return f963a.mo294a(layoutInflater);
    }

    public static void m1847a(LayoutInflater layoutInflater, al alVar) {
        f963a.mo295a(layoutInflater, alVar);
    }
}
