package android.support.design.widget;

import android.view.View;
import java.util.Comparator;

class C0061z implements Comparator {
    final /* synthetic */ CoordinatorLayout f587a;

    C0061z(CoordinatorLayout coordinatorLayout) {
        this.f587a = coordinatorLayout;
    }

    public int m952a(View view, View view2) {
        return view == view2 ? 0 : ((ae) view.getLayoutParams()).m507a(this.f587a, view, view2) ? 1 : ((ae) view2.getLayoutParams()).m507a(this.f587a, view2, view) ? -1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m952a((View) obj, (View) obj2);
    }
}
