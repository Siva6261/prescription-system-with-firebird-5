package android.support.v4.p014g;

import java.util.Locale;

class C0162s {
    private C0162s() {
    }

    private static int m1490b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case (byte) 1:
            case (byte) 2:
                return 1;
            default:
                return 0;
        }
    }

    public int mo239a(Locale locale) {
        if (!(locale == null || locale.equals(C0160q.f843a))) {
            String a = C0144a.m1465a(locale);
            if (a == null) {
                return C0162s.m1490b(locale);
            }
            if (a.equalsIgnoreCase(C0160q.f845c) || a.equalsIgnoreCase(C0160q.f846d)) {
                return 1;
            }
        }
        return 0;
    }
}
