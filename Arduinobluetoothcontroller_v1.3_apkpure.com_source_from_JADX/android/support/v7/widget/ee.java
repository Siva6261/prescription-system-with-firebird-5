package android.support.v7.widget;

import android.view.View;

public class ee {
    public int f2200a;
    public int f2201b;
    public int f2202c;
    public int f2203d;

    public ee m4503a(ey eyVar) {
        return m4504a(eyVar, 0);
    }

    public ee m4504a(ey eyVar, int i) {
        View view = eyVar.f2256a;
        this.f2200a = view.getLeft();
        this.f2201b = view.getTop();
        this.f2202c = view.getRight();
        this.f2203d = view.getBottom();
        return this;
    }
}
