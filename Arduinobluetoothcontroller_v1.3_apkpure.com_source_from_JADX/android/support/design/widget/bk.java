package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;

class bk implements OnClickListener {
    final /* synthetic */ OnClickListener f390a;
    final /* synthetic */ Snackbar f391b;

    bk(Snackbar snackbar, OnClickListener onClickListener) {
        this.f391b = snackbar;
        this.f390a = onClickListener;
    }

    public void onClick(View view) {
        this.f390a.onClick(view);
        this.f391b.m462d(1);
    }
}
