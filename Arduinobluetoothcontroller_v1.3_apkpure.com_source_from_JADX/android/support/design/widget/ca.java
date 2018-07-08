package android.support.design.widget;

import java.lang.ref.WeakReference;

class ca {
    private final WeakReference f410a;
    private int f411b;

    ca(int i, bz bzVar) {
        this.f410a = new WeakReference(bzVar);
        this.f411b = i;
    }

    boolean m672a(bz bzVar) {
        return bzVar != null && this.f410a.get() == bzVar;
    }
}
