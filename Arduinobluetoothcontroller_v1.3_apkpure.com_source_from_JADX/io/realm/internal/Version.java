package io.realm.internal;

public class Version {
    public static String m5627a() {
        return nativeGetVersion();
    }

    public static boolean m5628a(boolean z) {
        boolean z2 = false;
        String str;
        if (nativeIsAtLeast(0, 1, 6)) {
            if (nativeGetAPIVersion() == 23) {
                z2 = true;
            }
            if (!z2) {
                str = "Native lib API is version " + nativeGetAPIVersion() + " != " + 23 + " which is expected by the jar.";
                if (z) {
                    throw new RuntimeException(str);
                }
                System.err.println(str);
            }
        } else {
            str = "Version mismatch between realm.jar (0.1.6) and native core library (" + m5627a() + ")";
            if (z) {
                throw new RuntimeException(str);
            }
            System.err.println(str);
        }
        return z2;
    }

    static native int nativeGetAPIVersion();

    static native String nativeGetVersion();

    static native boolean nativeIsAtLeast(int i, int i2, int i3);
}
