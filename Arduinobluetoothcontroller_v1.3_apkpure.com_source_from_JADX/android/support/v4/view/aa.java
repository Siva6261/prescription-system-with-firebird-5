package android.support.v4.view;

import android.view.KeyEvent;

class aa {
    public static int m1843a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m1844a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m1845b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
