package android.support.v4.view.p016a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class ab implements ai {
    final /* synthetic */ C0206w f946a;
    final /* synthetic */ aa f947b;

    ab(aa aaVar, C0206w c0206w) {
        this.f947b = aaVar;
        this.f946a = c0206w;
    }

    public Object mo252a(int i) {
        C0190g a = this.f946a.m1824a(i);
        return a == null ? null : a.m1693a();
    }

    public List mo253a(String str, int i) {
        List a = this.f946a.m1826a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0190g) a.get(i2)).m1693a());
        }
        return arrayList;
    }

    public boolean mo254a(int i, int i2, Bundle bundle) {
        return this.f946a.m1827a(i, i2, bundle);
    }

    public Object mo255b(int i) {
        C0190g b = this.f946a.m1828b(i);
        return b == null ? null : b.m1693a();
    }
}
