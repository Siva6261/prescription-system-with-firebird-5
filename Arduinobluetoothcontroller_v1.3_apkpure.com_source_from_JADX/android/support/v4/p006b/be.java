package android.support.v4.p006b;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class be implements OnPreDrawListener {
    final /* synthetic */ View f695a;
    final /* synthetic */ Transition f696b;
    final /* synthetic */ ArrayList f697c;
    final /* synthetic */ Transition f698d;
    final /* synthetic */ ArrayList f699e;
    final /* synthetic */ Transition f700f;
    final /* synthetic */ ArrayList f701g;
    final /* synthetic */ Map f702h;
    final /* synthetic */ ArrayList f703i;
    final /* synthetic */ Transition f704j;
    final /* synthetic */ View f705k;

    be(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
        this.f695a = view;
        this.f696b = transition;
        this.f697c = arrayList;
        this.f698d = transition2;
        this.f699e = arrayList2;
        this.f700f = transition3;
        this.f701g = arrayList3;
        this.f702h = map;
        this.f703i = arrayList4;
        this.f704j = transition4;
        this.f705k = view2;
    }

    public boolean onPreDraw() {
        this.f695a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f696b != null) {
            ba.m1178a(this.f696b, this.f697c);
        }
        if (this.f698d != null) {
            ba.m1178a(this.f698d, this.f699e);
        }
        if (this.f700f != null) {
            ba.m1178a(this.f700f, this.f701g);
        }
        for (Entry entry : this.f702h.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.f703i.size();
        for (int i = 0; i < size; i++) {
            this.f704j.excludeTarget((View) this.f703i.get(i), false);
        }
        this.f704j.excludeTarget(this.f705k, false);
        return true;
    }
}
