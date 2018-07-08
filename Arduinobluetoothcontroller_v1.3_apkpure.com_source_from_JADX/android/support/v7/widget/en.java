package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class en {
    private SparseArray f2209a = new SparseArray();
    private SparseIntArray f2210b = new SparseIntArray();
    private int f2211c = 0;

    private ArrayList m4519b(int i) {
        ArrayList arrayList = (ArrayList) this.f2209a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f2209a.put(i, arrayList);
            if (this.f2210b.indexOfKey(i) < 0) {
                this.f2210b.put(i, 5);
            }
        }
        return arrayList;
    }

    public ey m4520a(int i) {
        ArrayList arrayList = (ArrayList) this.f2209a.get(i);
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size() - 1;
        ey eyVar = (ey) arrayList.get(size);
        arrayList.remove(size);
        return eyVar;
    }

    public void m4521a() {
        this.f2209a.clear();
    }

    void m4522a(dx dxVar) {
        this.f2211c++;
    }

    void m4523a(dx dxVar, dx dxVar2, boolean z) {
        if (dxVar != null) {
            m4525b();
        }
        if (!z && this.f2211c == 0) {
            m4521a();
        }
        if (dxVar2 != null) {
            m4522a(dxVar2);
        }
    }

    public void m4524a(ey eyVar) {
        int h = eyVar.m4651h();
        ArrayList b = m4519b(h);
        if (this.f2210b.get(h) > b.size()) {
            eyVar.m4665v();
            b.add(eyVar);
        }
    }

    void m4525b() {
        this.f2211c--;
    }
}
