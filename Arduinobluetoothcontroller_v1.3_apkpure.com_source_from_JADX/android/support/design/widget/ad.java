package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class ad implements OnHierarchyChangeListener {
    final /* synthetic */ CoordinatorLayout f308a;

    private ad(CoordinatorLayout coordinatorLayout) {
        this.f308a = coordinatorLayout;
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.f308a.f261y != null) {
            this.f308a.f261y.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        this.f308a.m417b(view2);
        if (this.f308a.f261y != null) {
            this.f308a.f261y.onChildViewRemoved(view, view2);
        }
    }
}
