package android.support.v7.widget;

import android.view.View;

public abstract class C0352do {
    protected final eh f2189a;
    private int f2190b;

    private C0352do(eh ehVar) {
        this.f2190b = Integer.MIN_VALUE;
        this.f2189a = ehVar;
    }

    public static C0352do m4408a(eh ehVar) {
        return new dp(ehVar);
    }

    public static C0352do m4409a(eh ehVar, int i) {
        switch (i) {
            case 0:
                return C0352do.m4408a(ehVar);
            case 1:
                return C0352do.m4410b(ehVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static C0352do m4410b(eh ehVar) {
        return new dq(ehVar);
    }

    public abstract int mo731a(View view);

    public void m4412a() {
        this.f2190b = mo739f();
    }

    public abstract void mo732a(int i);

    public int m4414b() {
        return Integer.MIN_VALUE == this.f2190b ? 0 : mo739f() - this.f2190b;
    }

    public abstract int mo733b(View view);

    public abstract int mo734c();

    public abstract int mo735c(View view);

    public abstract int mo736d();

    public abstract int mo737d(View view);

    public abstract int mo738e();

    public abstract int mo739f();

    public abstract int mo740g();

    public abstract int mo741h();

    public abstract int mo742i();
}
