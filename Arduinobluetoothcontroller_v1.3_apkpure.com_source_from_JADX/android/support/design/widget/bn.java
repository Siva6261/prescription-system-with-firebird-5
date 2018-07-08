package android.support.design.widget;

import android.view.View;

class bn implements bv {
    final /* synthetic */ Snackbar f394a;

    bn(Snackbar snackbar) {
        this.f394a = snackbar;
    }

    public void mo109a(View view) {
    }

    public void mo110b(View view) {
        if (this.f394a.m473b()) {
            Snackbar.f284a.post(new bo(this));
        }
    }
}
