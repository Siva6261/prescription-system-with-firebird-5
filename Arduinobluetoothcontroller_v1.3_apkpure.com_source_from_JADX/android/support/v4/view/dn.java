package android.support.v4.view;

import android.database.DataSetObserver;

class dn extends DataSetObserver {
    final /* synthetic */ ViewPager f1009a;

    private dn(ViewPager viewPager) {
        this.f1009a = viewPager;
    }

    public void onChanged() {
        this.f1009a.m1619b();
    }

    public void onInvalidated() {
        this.f1009a.m1619b();
    }
}
