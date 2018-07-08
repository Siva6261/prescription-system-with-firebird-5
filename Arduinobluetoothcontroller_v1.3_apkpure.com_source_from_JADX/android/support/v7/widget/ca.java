package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class ca implements Runnable {
    final /* synthetic */ ArrayList f2088a;
    final /* synthetic */ bx f2089b;

    ca(bx bxVar, ArrayList arrayList) {
        this.f2089b = bxVar;
        this.f2088a = arrayList;
    }

    public void run() {
        Iterator it = this.f2088a.iterator();
        while (it.hasNext()) {
            this.f2089b.m4319u((ey) it.next());
        }
        this.f2088a.clear();
        this.f2089b.f2076f.remove(this.f2088a);
    }
}
