package android.support.v4.view;

import android.view.WindowInsets;

class et extends es {
    private final WindowInsets f1032a;

    et(WindowInsets windowInsets) {
        this.f1032a = windowInsets;
    }

    public int mo414a() {
        return this.f1032a.getSystemWindowInsetLeft();
    }

    public es mo415a(int i, int i2, int i3, int i4) {
        return new et(this.f1032a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public int mo416b() {
        return this.f1032a.getSystemWindowInsetTop();
    }

    public int mo417c() {
        return this.f1032a.getSystemWindowInsetRight();
    }

    public int mo418d() {
        return this.f1032a.getSystemWindowInsetBottom();
    }

    public boolean mo419e() {
        return this.f1032a.isConsumed();
    }

    public es mo420f() {
        return new et(this.f1032a.consumeSystemWindowInsets());
    }

    WindowInsets m2465g() {
        return this.f1032a;
    }
}
