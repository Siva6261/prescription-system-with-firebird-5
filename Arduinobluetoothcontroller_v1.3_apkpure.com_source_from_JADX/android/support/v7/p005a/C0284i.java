package android.support.v7.p005a;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class C0284i implements OnScrollListener {
    final /* synthetic */ View f1371a;
    final /* synthetic */ View f1372b;
    final /* synthetic */ C0280e f1373c;

    C0284i(C0280e c0280e, View view, View view2) {
        this.f1373c = c0280e;
        this.f1371a = view;
        this.f1372b = view2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        C0280e.m3172b(absListView, this.f1371a, this.f1372b);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
