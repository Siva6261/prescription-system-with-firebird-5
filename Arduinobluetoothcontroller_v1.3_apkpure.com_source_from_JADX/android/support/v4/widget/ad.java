package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.C0209a;
import android.support.v4.view.p016a.C0183a;
import android.support.v4.view.p016a.C0190g;
import android.support.v4.view.p016a.aj;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

class ad extends C0209a {
    ad() {
    }

    public void mo393a(View view, C0190g c0190g) {
        super.mo393a(view, c0190g);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        c0190g.m1696a(ScrollView.class.getName());
        if (nestedScrollView.isEnabled()) {
            int a = nestedScrollView.getScrollRange();
            if (a > 0) {
                c0190g.m1698a(true);
                if (nestedScrollView.getScrollY() > 0) {
                    c0190g.m1694a(8192);
                }
                if (nestedScrollView.getScrollY() < a) {
                    c0190g.m1694a(4096);
                }
            }
        }
    }

    public boolean mo394a(View view, int i, Bundle bundle) {
        if (super.mo394a(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int min;
        switch (i) {
            case 4096:
                min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m2555b(0, min);
                return true;
            case 8192:
                min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m2555b(0, min);
                return true;
            default:
                return false;
        }
    }

    public void mo395d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo395d(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        aj a = C0183a.m1624a(accessibilityEvent);
        a.m1644a(nestedScrollView.getScrollRange() > 0);
        a.m1647d(nestedScrollView.getScrollX());
        a.m1648e(nestedScrollView.getScrollY());
        a.m1649f(nestedScrollView.getScrollX());
        a.m1650g(nestedScrollView.getScrollRange());
    }
}
