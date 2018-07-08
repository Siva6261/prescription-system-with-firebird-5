package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class bj {
    private final View f975a;
    private ViewParent f976b;
    private boolean f977c;
    private int[] f978d;

    public bj(View view) {
        this.f975a = view;
    }

    public void m1972a(boolean z) {
        if (this.f977c) {
            bv.m2049z(this.f975a);
        }
        this.f977c = z;
    }

    public boolean m1973a() {
        return this.f977c;
    }

    public boolean m1974a(float f, float f2) {
        return (!m1973a() || this.f976b == null) ? false : dr.m2345a(this.f976b, this.f975a, f, f2);
    }

    public boolean m1975a(float f, float f2, boolean z) {
        return (!m1973a() || this.f976b == null) ? false : dr.m2346a(this.f976b, this.f975a, f, f2, z);
    }

    public boolean m1976a(int i) {
        if (m1979b()) {
            return true;
        }
        if (m1973a()) {
            View view = this.f975a;
            for (ViewParent parent = this.f975a.getParent(); parent != null; parent = parent.getParent()) {
                if (dr.m2347a(parent, view, this.f975a, i)) {
                    this.f976b = parent;
                    dr.m2348b(parent, view, this.f975a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean m1977a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m1973a() || this.f976b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f975a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            dr.m2343a(this.f976b, this.f975a, i, i2, i3, i4);
            if (iArr != null) {
                this.f975a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m1978a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m1973a() || this.f976b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f975a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f978d == null) {
                    this.f978d = new int[2];
                }
                iArr = this.f978d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            dr.m2344a(this.f976b, this.f975a, i, i2, iArr);
            if (iArr2 != null) {
                this.f975a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m1979b() {
        return this.f976b != null;
    }

    public void m1980c() {
        if (this.f976b != null) {
            dr.m2342a(this.f976b, this.f975a);
            this.f976b = null;
        }
    }
}
