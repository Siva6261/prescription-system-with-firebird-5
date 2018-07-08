package io.realm.internal.p027b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class C0462b {
    private static final List f2932a = new CopyOnWriteArrayList();

    public static void m5665a(C0440a c0440a) {
        if (c0440a == null) {
            throw new IllegalArgumentException("A non-null logger has to be provided");
        }
        f2932a.add(c0440a);
    }

    public static void m5666a(String str) {
        for (int i = 0; i < f2932a.size(); i++) {
            ((C0440a) f2932a.get(i)).mo921a(str);
        }
    }

    public static void m5667a(String str, Throwable th) {
        for (int i = 0; i < f2932a.size(); i++) {
            ((C0440a) f2932a.get(i)).mo922a(str, th);
        }
    }

    public static void m5668b(String str) {
        for (int i = 0; i < f2932a.size(); i++) {
            ((C0440a) f2932a.get(i)).mo923b(str);
        }
    }
}
