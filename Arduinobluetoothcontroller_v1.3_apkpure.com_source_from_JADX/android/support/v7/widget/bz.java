package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class bz implements Runnable {
    final /* synthetic */ ArrayList f2085a;
    final /* synthetic */ bx f2086b;

    bz(bx bxVar, ArrayList arrayList) {
        this.f2086b = bxVar;
        this.f2085a = arrayList;
    }

    public void run() {
        Iterator it = this.f2085a.iterator();
        while (it.hasNext()) {
            this.f2086b.m4305a((cg) it.next());
        }
        this.f2085a.clear();
        this.f2086b.f2078h.remove(this.f2085a);
    }
}
