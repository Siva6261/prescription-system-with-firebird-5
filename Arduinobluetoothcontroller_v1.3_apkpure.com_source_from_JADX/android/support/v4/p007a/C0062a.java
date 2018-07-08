package android.support.v4.p007a;

import android.os.Build.VERSION;
import android.view.View;

public final class C0062a {
    private static final C0063b f588a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f588a = new C0065d();
        } else {
            f588a = new C0064c();
        }
    }

    public static void m953a(View view) {
        f588a.mo160a(view);
    }
}
