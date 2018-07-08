package android.support.v4.p008c;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class C0098e {
    private static final C0099f f798a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f798a = new C0102i();
        } else if (i >= 11) {
            f798a = new C0101h();
        } else {
            f798a = new C0100g();
        }
    }

    public static Intent m1313a(ComponentName componentName) {
        return f798a.mo208a(componentName);
    }
}
