package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class C0258s {
    private static final C0259v f1149b;
    private Object f1150a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f1149b = new C0262w();
        } else if (VERSION.SDK_INT >= 14) {
            f1149b = new C0261u();
        } else {
            f1149b = new C0260t();
        }
    }

    public C0258s(Context context) {
        this.f1150a = f1149b.mo462a(context);
    }

    public void m2783a(int i, int i2) {
        f1149b.mo463a(this.f1150a, i, i2);
    }

    public boolean m2784a() {
        return f1149b.mo464a(this.f1150a);
    }

    public boolean m2785a(float f) {
        return f1149b.mo465a(this.f1150a, f);
    }

    public boolean m2786a(float f, float f2) {
        return f1149b.mo466a(this.f1150a, f, f2);
    }

    public boolean m2787a(int i) {
        return f1149b.mo467a(this.f1150a, i);
    }

    public boolean m2788a(Canvas canvas) {
        return f1149b.mo468a(this.f1150a, canvas);
    }

    public void m2789b() {
        f1149b.mo469b(this.f1150a);
    }

    public boolean m2790c() {
        return f1149b.mo470c(this.f1150a);
    }
}
