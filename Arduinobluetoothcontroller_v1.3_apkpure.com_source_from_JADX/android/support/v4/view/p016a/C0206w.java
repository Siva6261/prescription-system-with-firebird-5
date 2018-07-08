package android.support.v4.view.p016a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class C0206w {
    private static final C0184x f956a;
    private final Object f957b;

    static {
        if (VERSION.SDK_INT >= 19) {
            f956a = new aa();
        } else if (VERSION.SDK_INT >= 16) {
            f956a = new C0207y();
        } else {
            f956a = new ac();
        }
    }

    public C0206w() {
        this.f957b = f956a.mo251a(this);
    }

    public C0206w(Object obj) {
        this.f957b = obj;
    }

    public C0190g m1824a(int i) {
        return null;
    }

    public Object m1825a() {
        return this.f957b;
    }

    public List m1826a(String str, int i) {
        return null;
    }

    public boolean m1827a(int i, int i2, Bundle bundle) {
        return false;
    }

    public C0190g m1828b(int i) {
        return null;
    }
}
