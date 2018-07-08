package android.support.design.widget;

import android.view.View;

class bm implements cf {
    final /* synthetic */ Snackbar f393a;

    bm(Snackbar snackbar) {
        this.f393a = snackbar;
    }

    public void mo107a(int i) {
        switch (i) {
            case 0:
                bx.m653a().m666d(this.f393a.f291h);
                return;
            case 1:
            case 2:
                bx.m653a().m665c(this.f393a.f291h);
                return;
            default:
                return;
        }
    }

    public void mo108a(View view) {
        view.setVisibility(8);
        this.f393a.m462d(0);
    }
}
