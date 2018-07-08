package android.support.v4.view.p016a;

import android.os.Build.VERSION;

public class aj {
    private static final am f950a;
    private final Object f951b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f950a = new an();
        } else if (VERSION.SDK_INT >= 15) {
            f950a = new al();
        } else if (VERSION.SDK_INT >= 14) {
            f950a = new ak();
        } else {
            f950a = new ao();
        }
    }

    public aj(Object obj) {
        this.f951b = obj;
    }

    public void m1643a(int i) {
        f950a.mo258b(this.f951b, i);
    }

    public void m1644a(boolean z) {
        f950a.mo257a(this.f951b, z);
    }

    public void m1645b(int i) {
        f950a.mo256a(this.f951b, i);
    }

    public void m1646c(int i) {
        f950a.mo261e(this.f951b, i);
    }

    public void m1647d(int i) {
        f950a.mo259c(this.f951b, i);
    }

    public void m1648e(int i) {
        f950a.mo260d(this.f951b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        aj ajVar = (aj) obj;
        return this.f951b == null ? ajVar.f951b == null : this.f951b.equals(ajVar.f951b);
    }

    public void m1649f(int i) {
        f950a.mo262f(this.f951b, i);
    }

    public void m1650g(int i) {
        f950a.mo263g(this.f951b, i);
    }

    public int hashCode() {
        return this.f951b == null ? 0 : this.f951b.hashCode();
    }
}
