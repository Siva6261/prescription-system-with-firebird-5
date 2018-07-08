package android.support.v4.view.p016a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class C0208z implements af {
    final /* synthetic */ C0206w f958a;
    final /* synthetic */ C0207y f959b;

    C0208z(C0207y c0207y, C0206w c0206w) {
        this.f959b = c0207y;
        this.f958a = c0206w;
    }

    public Object mo291a(int i) {
        C0190g a = this.f958a.m1824a(i);
        return a == null ? null : a.m1693a();
    }

    public List mo292a(String str, int i) {
        List a = this.f958a.m1826a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0190g) a.get(i2)).m1693a());
        }
        return arrayList;
    }

    public boolean mo293a(int i, int i2, Bundle bundle) {
        return this.f958a.m1827a(i, i2, bundle);
    }
}
