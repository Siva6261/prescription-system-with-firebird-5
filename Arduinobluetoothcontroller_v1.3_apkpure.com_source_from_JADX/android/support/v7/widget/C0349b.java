package android.support.v7.widget;

import android.support.v4.view.dy;
import android.support.v4.view.ep;
import android.view.View;

public class C0349b implements ep {
    int f1971a;
    final /* synthetic */ C0348a f1972b;
    private boolean f1973c = false;

    protected C0349b(C0348a c0348a) {
        this.f1972b = c0348a;
    }

    public C0349b m4112a(dy dyVar, int i) {
        this.f1972b.f1681f = dyVar;
        this.f1971a = i;
        return this;
    }

    public void mo112a(View view) {
        super.setVisibility(0);
        this.f1973c = false;
    }

    public void mo113b(View view) {
        if (!this.f1973c) {
            this.f1972b.f1681f = null;
            super.setVisibility(this.f1971a);
        }
    }

    public void mo114c(View view) {
        this.f1973c = true;
    }
}
