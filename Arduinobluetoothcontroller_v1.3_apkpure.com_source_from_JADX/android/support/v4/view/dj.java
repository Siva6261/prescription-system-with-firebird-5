package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p016a.C0183a;
import android.support.v4.view.p016a.C0190g;
import android.support.v4.view.p016a.aj;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class dj extends C0209a {
    final /* synthetic */ ViewPager f1008b;

    dj(ViewPager viewPager) {
        this.f1008b = viewPager;
    }

    private boolean m2328b() {
        return this.f1008b.f926h != null && this.f1008b.f926h.mo839b() > 1;
    }

    public void mo393a(View view, C0190g c0190g) {
        super.mo393a(view, c0190g);
        c0190g.m1696a(ViewPager.class.getName());
        c0190g.m1698a(m2328b());
        if (this.f1008b.canScrollHorizontally(1)) {
            c0190g.m1694a(4096);
        }
        if (this.f1008b.canScrollHorizontally(-1)) {
            c0190g.m1694a(8192);
        }
    }

    public boolean mo394a(View view, int i, Bundle bundle) {
        if (super.mo394a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.f1008b.canScrollHorizontally(1)) {
                    return false;
                }
                this.f1008b.setCurrentItem(this.f1008b.f927i + 1);
                return true;
            case 8192:
                if (!this.f1008b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f1008b.setCurrentItem(this.f1008b.f927i - 1);
                return true;
            default:
                return false;
        }
    }

    public void mo395d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo395d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        aj a = C0183a.m1624a(accessibilityEvent);
        a.m1644a(m2328b());
        if (accessibilityEvent.getEventType() == 4096 && this.f1008b.f926h != null) {
            a.m1643a(this.f1008b.f926h.mo839b());
            a.m1645b(this.f1008b.f927i);
            a.m1646c(this.f1008b.f927i);
        }
    }
}
