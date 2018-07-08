package android.support.v7.widget;

import android.view.View;

final class dp extends C0352do {
    dp(eh ehVar) {
        super(ehVar);
    }

    public int mo731a(View view) {
        return this.a.m3712h(view) - ((ej) view.getLayoutParams()).leftMargin;
    }

    public void mo732a(int i) {
        this.a.mo695i(i);
    }

    public int mo733b(View view) {
        ej ejVar = (ej) view.getLayoutParams();
        return ejVar.rightMargin + this.a.m3716j(view);
    }

    public int mo734c() {
        return this.a.m3736x();
    }

    public int mo735c(View view) {
        ej ejVar = (ej) view.getLayoutParams();
        return ejVar.rightMargin + (this.a.m3706f(view) + ejVar.leftMargin);
    }

    public int mo736d() {
        return this.a.m3734v() - this.a.m3738z();
    }

    public int mo737d(View view) {
        ej ejVar = (ej) view.getLayoutParams();
        return ejVar.bottomMargin + (this.a.m3710g(view) + ejVar.topMargin);
    }

    public int mo738e() {
        return this.a.m3734v();
    }

    public int mo739f() {
        return (this.a.m3734v() - this.a.m3736x()) - this.a.m3738z();
    }

    public int mo740g() {
        return this.a.m3738z();
    }

    public int mo741h() {
        return this.a.m3732t();
    }

    public int mo742i() {
        return this.a.m3733u();
    }
}
