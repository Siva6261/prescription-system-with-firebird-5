package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;

public final class bv {
    static final ci f982a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f982a = new ch();
        } else if (i >= 21) {
            f982a = new cg();
        } else if (i >= 19) {
            f982a = new cf();
        } else if (i >= 17) {
            f982a = new cd();
        } else if (i >= 16) {
            f982a = new cc();
        } else if (i >= 15) {
            f982a = new ca();
        } else if (i >= 14) {
            f982a = new cb();
        } else if (i >= 11) {
            f982a = new bz();
        } else if (i >= 9) {
            f982a = new by();
        } else if (i >= 7) {
            f982a = new bx();
        } else {
            f982a = new bw();
        }
    }

    public static boolean m1994A(View view) {
        return f982a.mo327C(view);
    }

    public static float m1995B(View view) {
        return f982a.mo328D(view);
    }

    public static boolean m1996C(View view) {
        return f982a.mo329E(view);
    }

    public static boolean m1997D(View view) {
        return f982a.mo330F(view);
    }

    public static int m1998a(int i, int i2) {
        return f982a.mo331a(i, i2);
    }

    public static int m1999a(int i, int i2, int i3) {
        return f982a.mo332a(i, i2, i3);
    }

    public static int m2000a(View view) {
        return f982a.mo333a(view);
    }

    public static es m2001a(View view, es esVar) {
        return f982a.mo334a(view, esVar);
    }

    public static void m2002a(View view, float f) {
        f982a.mo335a(view, f);
    }

    public static void m2003a(View view, int i, int i2) {
        f982a.mo336a(view, i, i2);
    }

    public static void m2004a(View view, int i, int i2, int i3, int i4) {
        f982a.mo337a(view, i, i2, i3, i4);
    }

    public static void m2005a(View view, int i, Paint paint) {
        f982a.mo338a(view, i, paint);
    }

    public static void m2006a(View view, ColorStateList colorStateList) {
        f982a.mo339a(view, colorStateList);
    }

    public static void m2007a(View view, Mode mode) {
        f982a.mo340a(view, mode);
    }

    public static void m2008a(View view, C0209a c0209a) {
        f982a.mo341a(view, c0209a);
    }

    public static void m2009a(View view, bm bmVar) {
        f982a.mo342a(view, bmVar);
    }

    public static void m2010a(View view, Runnable runnable) {
        f982a.mo343a(view, runnable);
    }

    public static void m2011a(View view, Runnable runnable, long j) {
        f982a.mo344a(view, runnable, j);
    }

    public static void m2012a(View view, boolean z) {
        f982a.mo345a(view, z);
    }

    public static boolean m2013a(View view, int i) {
        return f982a.mo346a(view, i);
    }

    public static es m2014b(View view, es esVar) {
        return f982a.mo347b(view, esVar);
    }

    public static void m2015b(View view, float f) {
        f982a.mo348b(view, f);
    }

    public static void m2016b(View view, boolean z) {
        f982a.mo349b(view, z);
    }

    public static boolean m2017b(View view) {
        return f982a.mo350b(view);
    }

    public static boolean m2018b(View view, int i) {
        return f982a.mo351b(view, i);
    }

    public static void m2019c(View view, float f) {
        f982a.mo352c(view, f);
    }

    public static void m2020c(View view, int i) {
        f982a.mo353c(view, i);
    }

    public static void m2021c(View view, boolean z) {
        f982a.mo354c(view, z);
    }

    public static boolean m2022c(View view) {
        return f982a.mo355c(view);
    }

    public static void m2023d(View view) {
        f982a.mo356d(view);
    }

    public static void m2024d(View view, float f) {
        f982a.mo357d(view, f);
    }

    public static void m2025d(View view, int i) {
        f982a.mo358d(view, i);
    }

    public static int m2026e(View view) {
        return f982a.mo359e(view);
    }

    public static void m2027e(View view, int i) {
        f982a.mo362f(view, i);
    }

    public static float m2028f(View view) {
        return f982a.mo361f(view);
    }

    public static void m2029f(View view, int i) {
        f982a.mo360e(view, i);
    }

    public static int m2030g(View view) {
        return f982a.mo363g(view);
    }

    public static int m2031h(View view) {
        return f982a.mo364h(view);
    }

    public static int m2032i(View view) {
        return f982a.mo365i(view);
    }

    public static int m2033j(View view) {
        return f982a.mo366j(view);
    }

    public static int m2034k(View view) {
        return f982a.mo367k(view);
    }

    public static int m2035l(View view) {
        return f982a.mo368l(view);
    }

    public static float m2036m(View view) {
        return f982a.mo370n(view);
    }

    public static float m2037n(View view) {
        return f982a.mo371o(view);
    }

    public static int m2038o(View view) {
        return f982a.mo372p(view);
    }

    public static int m2039p(View view) {
        return f982a.mo373q(view);
    }

    public static dy m2040q(View view) {
        return f982a.mo374r(view);
    }

    public static int m2041r(View view) {
        return f982a.mo375s(view);
    }

    public static void m2042s(View view) {
        f982a.mo376t(view);
    }

    public static boolean m2043t(View view) {
        return f982a.mo377w(view);
    }

    public static void m2044u(View view) {
        f982a.mo378x(view);
    }

    public static boolean m2045v(View view) {
        return f982a.mo369m(view);
    }

    public static boolean m2046w(View view) {
        return f982a.mo379y(view);
    }

    public static ColorStateList m2047x(View view) {
        return f982a.mo380z(view);
    }

    public static Mode m2048y(View view) {
        return f982a.mo325A(view);
    }

    public static void m2049z(View view) {
        f982a.mo326B(view);
    }
}
