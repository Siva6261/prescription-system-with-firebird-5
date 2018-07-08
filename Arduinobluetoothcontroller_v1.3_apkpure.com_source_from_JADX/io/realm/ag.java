package io.realm;

import io.realm.exceptions.RealmException;
import java.util.ListIterator;

class ag extends af implements ListIterator {
    final /* synthetic */ ae f2823d;

    ag(ae aeVar, int i) {
        this.f2823d = aeVar;
        super(aeVar);
        if (i < 0 || i > aeVar.size()) {
            throw new IndexOutOfBoundsException("Starting location must be a valid index: [0, " + (aeVar.size() - 1) + "]. Yours was " + i);
        }
        this.b = i - 1;
    }

    public void m5412a(C0391z c0391z) {
        throw new RealmException("Adding elements not supported. Use Realm.createObject() instead.");
    }

    public /* synthetic */ void add(Object obj) {
        m5412a((C0391z) obj);
    }

    public void m5413b(C0391z c0391z) {
        throw new RealmException("Replacing elements not supported.");
    }

    public C0391z m5414c() {
        m5411b();
        this.b--;
        if (this.b >= 0) {
            return this.f2823d.m5403a(this.b);
        }
        throw new IndexOutOfBoundsException("Cannot access index less than zero. This was " + this.b + ". Remember to check hasPrevious() before using previous().");
    }

    public boolean hasPrevious() {
        m5411b();
        return this.b > 0;
    }

    public int nextIndex() {
        m5411b();
        return this.b + 1;
    }

    public /* synthetic */ Object previous() {
        return m5414c();
    }

    public int previousIndex() {
        m5411b();
        return this.b;
    }

    public void remove() {
        throw new RealmException("Removing elements not supported.");
    }

    public /* synthetic */ void set(Object obj) {
        m5413b((C0391z) obj);
    }
}
