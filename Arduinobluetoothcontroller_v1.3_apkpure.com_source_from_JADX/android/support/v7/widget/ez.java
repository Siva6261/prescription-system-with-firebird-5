package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0209a;
import android.support.v4.view.p016a.C0190g;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ez extends C0209a {
    final RecyclerView f2272b;
    final C0209a f2273c = new fa(this);

    public ez(RecyclerView recyclerView) {
        this.f2272b = recyclerView;
    }

    private boolean m4669c() {
        return this.f2272b.m222p();
    }

    public void mo393a(View view, C0190g c0190g) {
        super.mo393a(view, c0190g);
        c0190g.m1696a(RecyclerView.class.getName());
        if (!m4669c() && this.f2272b.getLayoutManager() != null) {
            this.f2272b.getLayoutManager().m3636a(c0190g);
        }
    }

    public boolean mo394a(View view, int i, Bundle bundle) {
        return super.mo394a(view, i, bundle) ? true : (m4669c() || this.f2272b.getLayoutManager() == null) ? false : this.f2272b.getLayoutManager().m3658a(i, bundle);
    }

    C0209a m4672b() {
        return this.f2273c;
    }

    public void mo395d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo395d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m4669c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo662a(accessibilityEvent);
            }
        }
    }
}
