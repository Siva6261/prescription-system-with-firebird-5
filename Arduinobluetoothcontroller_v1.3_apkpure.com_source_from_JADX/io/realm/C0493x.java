package io.realm;

import io.realm.internal.C0470h;
import io.realm.internal.LinkView;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class C0493x extends AbstractList {
    protected Class f3020a;
    protected String f3021b;
    protected LinkView f3022c;
    protected C0426a f3023d;
    private final boolean f3024e = false;
    private List f3025f = new ArrayList();

    private boolean m5850a() {
        return this.f3022c != null && this.f3022c.m5502c();
    }

    private C0391z m5851b(C0391z c0391z) {
        if (c0391z instanceof C0436i) {
            String a = ah.m5415a(this.f3022c.m5503d());
            String b = ((C0436i) c0391z).m5488b();
            if (c0391z.f2729b == this.f3023d) {
                if (a.equals(b)) {
                    return c0391z;
                }
                throw new IllegalArgumentException(String.format("The object has a different type from list's. Type of the list is '%s', type of object is '%s'.", new Object[]{a, b}));
            } else if (this.f3023d.f2786c == c0391z.f2729b.f2786c) {
                throw new IllegalArgumentException("Cannot copy DynamicRealmObject between Realm instances.");
            } else {
                throw new IllegalStateException("Cannot copy an object to a Realm instance created in another thread.");
            }
        } else if (c0391z.f2728a == null || !c0391z.f2729b.mo889f().equals(this.f3023d.mo889f())) {
            C0483m c0483m = (C0483m) this.f3023d;
            return c0483m.m5804d(c0391z.getClass()).m5551f() ? c0483m.m5800b(c0391z) : c0483m.m5795a(c0391z);
        } else if (this.f3023d == c0391z.f2729b) {
            return c0391z;
        } else {
            throw new IllegalArgumentException("Cannot copy an object from another Realm instance.");
        }
    }

    private void m5852b() {
        this.f3023d.m5368e();
        if (this.f3022c == null || !this.f3022c.m5502c()) {
            throw new IllegalStateException("Realm instance has been closed or parent object has been removed.");
        }
    }

    private void m5853c(C0391z c0391z) {
        if (c0391z == null) {
            throw new IllegalArgumentException("RealmList does not accept null values");
        }
    }

    public C0391z m5854a(int i) {
        if (!this.f3024e) {
            return (C0391z) this.f3025f.remove(i);
        }
        m5852b();
        C0391z b = m5857b(i);
        this.f3022c.m5501c((long) i);
        return b;
    }

    public void m5855a(int i, C0391z c0391z) {
        m5853c(c0391z);
        if (this.f3024e) {
            m5852b();
            this.f3022c.m5497a((long) i, m5851b(c0391z).f2728a.mo908c());
            return;
        }
        this.f3025f.add(i, c0391z);
    }

    public boolean m5856a(C0391z c0391z) {
        m5853c(c0391z);
        if (this.f3024e) {
            m5852b();
            this.f3022c.m5499b(m5851b(c0391z).f2728a.mo908c());
        } else {
            this.f3025f.add(c0391z);
        }
        return true;
    }

    public /* synthetic */ void add(int i, Object obj) {
        m5855a(i, (C0391z) obj);
    }

    public /* synthetic */ boolean add(Object obj) {
        return m5856a((C0391z) obj);
    }

    public C0391z m5857b(int i) {
        if (!this.f3024e) {
            return (C0391z) this.f3025f.get(i);
        }
        m5852b();
        return this.f3023d.m5360a(this.f3020a, this.f3021b, this.f3022c.m5495a((long) i));
    }

    public C0391z m5858b(int i, C0391z c0391z) {
        m5853c(c0391z);
        if (!this.f3024e) {
            return (C0391z) this.f3025f.set(i, c0391z);
        }
        m5852b();
        C0391z b = m5851b(c0391z);
        C0391z b2 = m5857b(i);
        this.f3022c.m5500b((long) i, b.f2728a.mo908c());
        return b2;
    }

    public void clear() {
        if (this.f3024e) {
            m5852b();
            this.f3022c.m5496a();
            return;
        }
        this.f3025f.clear();
    }

    public boolean contains(Object obj) {
        if (!this.f3024e) {
            return this.f3025f.contains(obj);
        }
        if (!(obj instanceof C0391z)) {
            return false;
        }
        C0391z c0391z = (C0391z) obj;
        return (c0391z.f2728a == null || !this.f3023d.mo889f().equals(c0391z.f2729b.mo889f()) || c0391z.f2728a == C0470h.INSTANCE) ? false : this.f3022c.m5504d(c0391z.f2728a.mo908c());
    }

    public /* synthetic */ Object get(int i) {
        return m5857b(i);
    }

    public /* synthetic */ Object remove(int i) {
        return m5854a(i);
    }

    public /* synthetic */ Object set(int i, Object obj) {
        return m5858b(i, (C0391z) obj);
    }

    public int size() {
        if (!this.f3024e) {
            return this.f3025f.size();
        }
        m5852b();
        long b = this.f3022c.m5498b();
        return b < 2147483647L ? (int) b : Integer.MAX_VALUE;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f3024e ? this.f3020a.getSimpleName() : getClass().getSimpleName());
        stringBuilder.append("@[");
        if (!this.f3024e || m5850a()) {
            for (int i = 0; i < size(); i++) {
                if (this.f3024e) {
                    stringBuilder.append(m5857b(i).f2728a.mo908c());
                } else {
                    stringBuilder.append(System.identityHashCode(m5857b(i)));
                }
                if (i < size() - 1) {
                    stringBuilder.append(',');
                }
            }
        } else {
            stringBuilder.append("invalid");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
