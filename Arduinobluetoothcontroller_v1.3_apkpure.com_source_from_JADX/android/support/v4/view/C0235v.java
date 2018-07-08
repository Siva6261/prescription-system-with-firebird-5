package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class C0235v {
    static final C0236z f1041a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f1041a = new C0239y();
        } else {
            f1041a = new C0237w();
        }
    }

    public static boolean m2519a(KeyEvent keyEvent) {
        return f1041a.mo433b(keyEvent.getMetaState());
    }

    public static boolean m2520a(KeyEvent keyEvent, int i) {
        return f1041a.mo432a(keyEvent.getMetaState(), i);
    }
}
