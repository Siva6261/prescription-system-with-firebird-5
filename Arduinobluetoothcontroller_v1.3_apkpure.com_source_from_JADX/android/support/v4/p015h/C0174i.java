package android.support.v4.p015h;

import java.util.Iterator;

final class C0174i implements Iterator {
    final int f877a;
    int f878b;
    int f879c;
    boolean f880d = false;
    final /* synthetic */ C0167h f881e;

    C0174i(C0167h c0167h, int i) {
        this.f881e = c0167h;
        this.f877a = i;
        this.f878b = c0167h.mo240a();
    }

    public boolean hasNext() {
        return this.f879c < this.f878b;
    }

    public Object next() {
        Object a = this.f881e.mo242a(this.f879c, this.f877a);
        this.f879c++;
        this.f880d = true;
        return a;
    }

    public void remove() {
        if (this.f880d) {
            this.f879c--;
            this.f878b--;
            this.f880d = false;
            this.f881e.mo244a(this.f879c);
            return;
        }
        throw new IllegalStateException();
    }
}
