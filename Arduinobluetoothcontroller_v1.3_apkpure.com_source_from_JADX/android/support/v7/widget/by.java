package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class by implements Runnable {
    final /* synthetic */ ArrayList f2083a;
    final /* synthetic */ bx f2084b;

    by(bx bxVar, ArrayList arrayList) {
        this.f2084b = bxVar;
        this.f2083a = arrayList;
    }

    public void run() {
        Iterator it = this.f2083a.iterator();
        while (it.hasNext()) {
            ch chVar = (ch) it.next();
            this.f2084b.m4310b(chVar.f2114a, chVar.f2115b, chVar.f2116c, chVar.f2117d, chVar.f2118e);
        }
        this.f2083a.clear();
        this.f2084b.f2077g.remove(this.f2083a);
    }
}
