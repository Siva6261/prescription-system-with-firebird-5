package android.support.v4.p015h;

import java.util.Iterator;
import java.util.Map.Entry;

final class C0177l implements Iterator, Entry {
    int f884a;
    int f885b;
    boolean f886c = false;
    final /* synthetic */ C0167h f887d;

    C0177l(C0167h c0167h) {
        this.f887d = c0167h;
        this.f884a = c0167h.mo240a() - 1;
        this.f885b = -1;
    }

    public Entry m1561a() {
        this.f885b++;
        this.f886c = true;
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f886c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(C0169c.m1537a(entry.getKey(), this.f887d.mo242a(this.f885b, 0)) && C0169c.m1537a(entry.getValue(), this.f887d.mo242a(this.f885b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public Object getKey() {
        if (this.f886c) {
            return this.f887d.mo242a(this.f885b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public Object getValue() {
        if (this.f886c) {
            return this.f887d.mo242a(this.f885b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.f885b < this.f884a;
    }

    public final int hashCode() {
        int i = 0;
        if (this.f886c) {
            Object a = this.f887d.mo242a(this.f885b, 0);
            Object a2 = this.f887d.mo242a(this.f885b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public /* synthetic */ Object next() {
        return m1561a();
    }

    public void remove() {
        if (this.f886c) {
            this.f887d.mo244a(this.f885b);
            this.f885b--;
            this.f884a--;
            this.f886c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public Object setValue(Object obj) {
        if (this.f886c) {
            return this.f887d.mo243a(this.f885b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
