package android.support.design.widget;

import android.support.v4.view.bv;
import android.view.View;
import java.util.Comparator;

class ai implements Comparator {
    ai() {
    }

    public int m525a(View view, View view2) {
        float B = bv.m1995B(view);
        float B2 = bv.m1995B(view2);
        return B > B2 ? -1 : B < B2 ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m525a((View) obj, (View) obj2);
    }
}
