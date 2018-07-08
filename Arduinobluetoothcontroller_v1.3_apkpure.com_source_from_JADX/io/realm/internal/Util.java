package io.realm.internal;

import io.realm.C0391z;

public class Util {
    static {
        C0473l.m5729b();
    }

    public static Class m5625a(Class cls) {
        Class superclass = cls.getSuperclass();
        return !superclass.equals(C0391z.class) ? superclass : cls;
    }

    public static String m5626a() {
        return nativeGetTablePrefix();
    }

    static native String nativeGetTablePrefix();
}
