package io.realm;

import io.realm.internal.C0438u;
import io.realm.internal.C0470h;
import io.realm.internal.TableQuery;
import io.realm.internal.TableView;
import io.realm.internal.async.BadVersionException;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

public final class ae extends AbstractList {
    C0426a f2811a;
    Class f2812b;
    String f2813c;
    private C0438u f2814d;
    private long f2815e;
    private final TableQuery f2816f;
    private final List f2817g;
    private Future f2818h;
    private boolean f2819i;

    private ae(C0426a c0426a, C0438u c0438u, Class cls) {
        this.f2814d = null;
        this.f2815e = -1;
        this.f2817g = new CopyOnWriteArrayList();
        this.f2819i = false;
        this.f2811a = c0426a;
        this.f2812b = cls;
        this.f2814d = c0438u;
        this.f2818h = null;
        this.f2816f = null;
        this.f2815e = c0438u.mo899l();
    }

    private ae(C0426a c0426a, C0438u c0438u, String str) {
        this(c0426a, str);
        this.f2814d = c0438u;
    }

    private ae(C0426a c0426a, String str) {
        this.f2814d = null;
        this.f2815e = -1;
        this.f2817g = new CopyOnWriteArrayList();
        this.f2819i = false;
        this.f2811a = c0426a;
        this.f2813c = str;
        this.f2818h = null;
        this.f2816f = null;
    }

    static ae m5399a(C0426a c0426a, C0438u c0438u, Class cls) {
        ae aeVar = new ae(c0426a, c0438u, cls);
        if (c0426a.f2792i != null) {
            c0426a.f2792i.m5777a(aeVar);
        }
        return aeVar;
    }

    static ae m5400a(C0426a c0426a, C0438u c0438u, String str) {
        ae aeVar = new ae(c0426a, c0438u, str);
        if (c0426a.f2792i != null) {
            c0426a.f2792i.m5777a(aeVar);
        }
        return aeVar;
    }

    C0438u m5402a() {
        return this.f2814d == null ? this.f2811a.f2790g.m5419b(this.f2812b) : this.f2814d;
    }

    public C0391z m5403a(int i) {
        this.f2811a.m5368e();
        C0438u a = m5402a();
        return a instanceof TableView ? this.f2811a.m5360a(this.f2812b, this.f2813c, ((TableView) a).m5576a((long) i)) : this.f2811a.m5360a(this.f2812b, this.f2813c, (long) i);
    }

    @Deprecated
    public void m5404a(int i, C0391z c0391z) {
        throw new UnsupportedOperationException();
    }

    void m5405a(long j) {
        try {
            this.f2814d = this.f2816f.m5573a(j, this.f2811a.f2788e.m5763h());
            this.f2819i = true;
        } catch (BadVersionException e) {
            throw new IllegalStateException("Caller and Worker Realm should have been at the same version");
        }
    }

    @Deprecated
    public boolean m5406a(C0391z c0391z) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public /* synthetic */ void add(int i, Object obj) {
        m5404a(i, (C0391z) obj);
    }

    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return m5406a((C0391z) obj);
    }

    public C0391z m5407b(int i) {
        this.f2811a.m5368e();
        m5402a().mo897e((long) i);
        return null;
    }

    public boolean m5408b() {
        this.f2811a.m5368e();
        return this.f2818h == null || this.f2819i;
    }

    void m5409c() {
        if (this.f2817g != null && !this.f2817g.isEmpty()) {
            if (this.f2818h == null || this.f2819i) {
                long l = this.f2814d.mo899l();
                if (this.f2815e != l) {
                    this.f2815e = l;
                    for (C0489t a : this.f2817g) {
                        a.m5822a();
                    }
                }
            }
        }
    }

    public void clear() {
        this.f2811a.m5368e();
        m5402a().mo896b();
    }

    public boolean contains(Object obj) {
        if (!m5408b() || !(obj instanceof C0391z)) {
            return false;
        }
        C0391z c0391z = (C0391z) obj;
        return (c0391z.f2728a == null || !this.f2811a.mo889f().equals(c0391z.f2729b.mo889f()) || c0391z.f2728a == C0470h.INSTANCE || this.f2814d.mo900m(c0391z.f2728a.mo908c()) == -1) ? false : true;
    }

    public /* synthetic */ Object get(int i) {
        return m5403a(i);
    }

    public int indexOf(Object obj) {
        throw new NoSuchMethodError("indexOf is not supported on RealmResults");
    }

    public Iterator iterator() {
        return !m5408b() ? Collections.emptyList().iterator() : new af(this);
    }

    public ListIterator listIterator() {
        return !m5408b() ? Collections.emptyList().listIterator() : new ag(this, 0);
    }

    public ListIterator listIterator(int i) {
        return !m5408b() ? Collections.emptyList().listIterator(i) : new ag(this, i);
    }

    public /* synthetic */ Object remove(int i) {
        return m5407b(i);
    }

    public int size() {
        if (!m5408b()) {
            return 0;
        }
        long a = m5402a().mo895a();
        return a > 2147483647L ? Integer.MAX_VALUE : (int) a;
    }
}
