package android.support.design.widget;

import android.support.v4.view.bv;
import android.view.View;

class C0046n implements Runnable {
    final /* synthetic */ BottomSheetBehavior f465a;
    private final View f466b;
    private final int f467c;

    C0046n(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.f465a = bottomSheetBehavior;
        this.f466b = view;
        this.f467c = i;
    }

    public void run() {
        if (this.f465a.f203g == null || !this.f465a.f203g.m2744a(true)) {
            this.f465a.m345b(this.f467c);
        } else {
            bv.m2010a(this.f466b, (Runnable) this);
        }
    }
}
