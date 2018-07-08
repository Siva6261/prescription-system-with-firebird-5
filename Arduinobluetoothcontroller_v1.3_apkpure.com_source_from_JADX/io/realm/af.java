package io.realm;

import io.realm.exceptions.RealmException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class af implements Iterator {
    long f2820a = 0;
    int f2821b = -1;
    final /* synthetic */ ae f2822c;

    af(ae aeVar) {
        this.f2822c = aeVar;
        this.f2820a = aeVar.f2814d.mo899l();
    }

    public C0391z m5410a() {
        m5411b();
        this.f2821b++;
        if (this.f2821b < this.f2822c.size()) {
            return this.f2822c.m5403a(this.f2821b);
        }
        throw new IndexOutOfBoundsException("Cannot access index " + this.f2821b + " when size is " + this.f2822c.size() + ". Remember to check hasNext() before using next().");
    }

    protected void m5411b() {
        long l = this.f2822c.f2814d.mo899l();
        if (this.f2820a <= -1 || l == this.f2820a) {
            this.f2820a = l;
            return;
        }
        throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a RealmResults. Use iterators methods instead.");
    }

    public boolean hasNext() {
        m5411b();
        return this.f2821b + 1 < this.f2822c.size();
    }

    public /* synthetic */ Object next() {
        return m5410a();
    }

    public void remove() {
        throw new RealmException("Removing is not supported.");
    }
}
