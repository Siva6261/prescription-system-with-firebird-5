package android.support.v4.p006b;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class bc implements OnPreDrawListener {
    final /* synthetic */ View f686a;
    final /* synthetic */ Transition f687b;
    final /* synthetic */ View f688c;
    final /* synthetic */ bg f689d;
    final /* synthetic */ Map f690e;
    final /* synthetic */ Map f691f;
    final /* synthetic */ ArrayList f692g;

    bc(View view, Transition transition, View view2, bg bgVar, Map map, Map map2, ArrayList arrayList) {
        this.f686a = view;
        this.f687b = transition;
        this.f688c = view2;
        this.f689d = bgVar;
        this.f690e = map;
        this.f691f = map2;
        this.f692g = arrayList;
    }

    public boolean onPreDraw() {
        this.f686a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f687b != null) {
            this.f687b.removeTarget(this.f688c);
        }
        View a = this.f689d.mo207a();
        if (a != null) {
            if (!this.f690e.isEmpty()) {
                ba.m1181a(this.f691f, a);
                this.f691f.keySet().retainAll(this.f690e.values());
                for (Entry entry : this.f690e.entrySet()) {
                    View view = (View) this.f691f.get((String) entry.getValue());
                    if (view != null) {
                        view.setTransitionName((String) entry.getKey());
                    }
                }
            }
            if (this.f687b != null) {
                ba.m1188b(this.f692g, a);
                this.f692g.removeAll(this.f691f.values());
                this.f692g.add(this.f688c);
                ba.m1187b(this.f687b, this.f692g);
            }
        }
        return true;
    }
}
