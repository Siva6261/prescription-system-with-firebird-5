package io.realm.internal;

import java.util.ArrayList;

class C0467e {
    ArrayList f2942a;
    ArrayList f2943b;

    private C0467e() {
        this.f2942a = new ArrayList();
        this.f2943b = new ArrayList();
    }

    Integer m5693a() {
        int size = this.f2943b.size();
        return size == 0 ? Integer.valueOf(this.f2942a.size()) : (Integer) this.f2943b.remove(size - 1);
    }

    void m5694a(C0472k c0472k) {
        if (this.f2942a.size() <= c0472k.f2952c.intValue()) {
            this.f2942a.add(c0472k);
        } else {
            this.f2942a.set(c0472k.f2952c.intValue(), c0472k);
        }
    }
}
