package android.support.v4.p006b;

import android.support.v4.p015h.C0166a;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;

class C0086p implements OnPreDrawListener {
    final /* synthetic */ View f759a;
    final /* synthetic */ Object f760b;
    final /* synthetic */ ArrayList f761c;
    final /* synthetic */ C0089s f762d;
    final /* synthetic */ boolean f763e;
    final /* synthetic */ C0051y f764f;
    final /* synthetic */ C0051y f765g;
    final /* synthetic */ C0084n f766h;

    C0086p(C0084n c0084n, View view, Object obj, ArrayList arrayList, C0089s c0089s, boolean z, C0051y c0051y, C0051y c0051y2) {
        this.f766h = c0084n;
        this.f759a = view;
        this.f760b = obj;
        this.f761c = arrayList;
        this.f762d = c0089s;
        this.f763e = z;
        this.f764f = c0051y;
        this.f765g = c0051y2;
    }

    public boolean onPreDraw() {
        this.f759a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f760b != null) {
            ba.m1178a(this.f760b, this.f761c);
            this.f761c.clear();
            C0166a a = this.f766h.m1264a(this.f762d, this.f763e, this.f764f);
            ba.m1175a(this.f760b, this.f762d.f784d, (Map) a, this.f761c);
            this.f766h.m1278a(a, this.f762d);
            this.f766h.m1274a(this.f762d, this.f764f, this.f765g, this.f763e, a);
        }
        return true;
    }
}
