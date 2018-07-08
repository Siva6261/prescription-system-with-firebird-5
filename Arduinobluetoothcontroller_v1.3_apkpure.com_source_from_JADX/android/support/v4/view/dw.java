package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class dw implements dt {
    dw() {
    }

    public void mo396a(ViewParent viewParent, View view) {
        if (viewParent instanceof bk) {
            ((bk) viewParent).onStopNestedScroll(view);
        }
    }

    public void mo397a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        if (viewParent instanceof bk) {
            ((bk) viewParent).onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void mo398a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        if (viewParent instanceof bk) {
            ((bk) viewParent).onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public boolean mo399a(ViewParent viewParent, View view, float f, float f2) {
        return viewParent instanceof bk ? ((bk) viewParent).onNestedPreFling(view, f, f2) : false;
    }

    public boolean mo400a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return viewParent instanceof bk ? ((bk) viewParent).onNestedFling(view, f, f2, z) : false;
    }

    public boolean mo401a(ViewParent viewParent, View view, View view2, int i) {
        return viewParent instanceof bk ? ((bk) viewParent).onStartNestedScroll(view, view2, i) : false;
    }

    public void mo402b(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof bk) {
            ((bk) viewParent).onNestedScrollAccepted(view, view2, i);
        }
    }
}
