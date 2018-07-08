package android.support.design.widget;

import android.support.v4.view.eq;
import android.view.View;

class bs extends eq {
    boolean f399a = false;
    final /* synthetic */ int f400b;
    final /* synthetic */ Snackbar f401c;

    bs(Snackbar snackbar, int i) {
        this.f401c = snackbar;
        this.f400b = i;
    }

    public void mo112a(View view) {
        if (!this.f401c.f290g.isEnabled()) {
            this.f401c.f287d.m452b(0, 180);
        }
    }

    public void mo113b(View view) {
        this.f401c.m467f(this.f400b);
    }
}
