package io.realm.internal;

import android.content.Context;
import io.realm.internal.p028a.C0442b;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Locale;

public class C0473l {
    private static final String f2953a = File.separator;
    private static final String f2954b = File.pathSeparator;
    private static final String f2955c = ("lib" + f2954b + ".." + f2953a + "lib");
    private static volatile boolean f2956d = false;

    private static String m5725a(String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                System.loadLibrary(str);
                return str;
            } catch (Throwable th) {
                i++;
            }
        }
        return null;
    }

    public static synchronized void m5726a(Context context) {
        synchronized (C0473l.class) {
            if (!f2956d) {
                C0442b.m5639a(context, "realm-jni");
                f2956d = true;
            }
        }
    }

    public static void m5727a(String str) {
        try {
            System.setProperty("java.library.path", System.getProperty("java.library.path") + f2954b + str + f2954b);
        } catch (Throwable e) {
            throw new RuntimeException("Cannot set the library path!", e);
        }
    }

    public static boolean m5728a() {
        return System.getProperty("os.name").toLowerCase(Locale.getDefault()).contains("win");
    }

    public static synchronized void m5729b() {
        synchronized (C0473l.class) {
            if (!f2956d) {
                if (C0473l.m5728a()) {
                    C0473l.m5730c();
                } else {
                    String str = System.getenv("REALM_JAVA_DEBUG");
                    str = (str == null || str.isEmpty()) ? "realm-jni" : "realm-jni-dbg";
                    System.loadLibrary(str);
                }
                f2956d = true;
                Version.m5628a(true);
            }
        }
    }

    private static String m5730c() {
        try {
            C0473l.m5727a(f2955c);
            C0473l.m5731d();
        } catch (Throwable th) {
        }
        String a = C0473l.m5725a("realm_jni32d", "realm_jni64d");
        if (a != null) {
            System.out.println("!!! Realm debug version loaded. !!!\n");
        } else {
            a = C0473l.m5725a("realm_jni32", "realm_jni64");
            if (a == null) {
                System.err.println("Searched java.library.path=" + System.getProperty("java.library.path"));
                throw new RuntimeException("Couldn't load the Realm JNI library 'realm_jni32.dll or realm_jni64.dll'. Please include the directory to the library in java.library.path.");
            }
        }
        return a;
    }

    private static void m5731d() {
        try {
            Field declaredField = ClassLoader.class.getDeclaredField("sys_paths");
            declaredField.setAccessible(true);
            declaredField.set(null, null);
        } catch (Throwable e) {
            throw new RuntimeException("Cannot reset the library path!", e);
        }
    }
}
