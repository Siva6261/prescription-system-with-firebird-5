package android.support.design.widget;

import android.os.Build.VERSION;
import android.view.View;

class db {
    static final cl f456a = new dc();
    private static final dd f457b;

    static {
        if (VERSION.SDK_INT >= 21) {
            f457b = new df();
        } else {
            f457b = new de();
        }
    }

    static ci m769a() {
        return f456a.mo136a();
    }

    static void m770a(View view) {
        f457b.mo137a(view);
    }
}
