package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class dq implements Comparator {
    dq() {
    }

    public int m2341a(View view, View view2) {
        di diVar = (di) view.getLayoutParams();
        di diVar2 = (di) view2.getLayoutParams();
        return diVar.f1002a != diVar2.f1002a ? diVar.f1002a ? 1 : -1 : diVar.f1006e - diVar2.f1006e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2341a((View) obj, (View) obj2);
    }
}
