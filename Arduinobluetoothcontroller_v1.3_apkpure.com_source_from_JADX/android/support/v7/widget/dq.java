package android.support.v7.widget;

import android.view.View;

final class dq extends C0352do {
    dq(eh ehVar) {
        super(ehVar);
    }

    public int mo731a(View view) {
        return this.a.m3714i(view) - ((ej) view.getLayoutParams()).topMargin;
    }

    public void mo732a(int i) {
        this.a.mo696j(i);
    }

    public int mo733b(View view) {
        ej ejVar = (ej) view.getLayoutParams();
        return ejVar.bottomMargin + this.a.m3719k(view);
    }

    public int mo734c() {
        return this.a.m3737y();
    }

    public int mo735c(View view) {
        ej ejVar = (ej) view.getLayoutParams();
        return ejVar.bottomMargin + (this.a.m3710g(view) + ejVar.topMargin);
    }

    public int mo736d() {
        return this.a.m3735w() - this.a.m3619A();
    }

    public int mo737d(View view) {
        ej ejVar = (ej) view.getLayoutParams();
        return ejVar.rightMargin + (this.a.m3706f(view) + ejVar.leftMargin);
    }

    public int mo738e() {
        return this.a.m3735w();
    }

    public int mo739f() {
        return (this.a.m3735w() - this.a.m3737y()) - this.a.m3619A();
    }

    public int mo740g() {
        return this.a.m3619A();
    }

    public int mo741h() {
        return this.a.m3733u();
    }

    public int mo742i() {
        return this.a.m3732t();
    }
}
