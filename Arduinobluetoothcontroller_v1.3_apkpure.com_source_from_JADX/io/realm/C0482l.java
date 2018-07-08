package io.realm;

import android.os.Handler.Callback;
import android.os.Message;
import io.realm.internal.C0439o;
import io.realm.internal.C0468f;
import io.realm.internal.async.C0449d;
import io.realm.internal.async.C0457l;
import io.realm.internal.async.C0458n;
import io.realm.internal.async.C0460o;
import io.realm.internal.p027b.C0462b;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

public class C0482l implements Callback {
    protected final CopyOnWriteArrayList f2974a = new CopyOnWriteArrayList();
    protected final List f2975b = new CopyOnWriteArrayList();
    final C0426a f2976c;
    final ReferenceQueue f2977d = new ReferenceQueue();
    final ReferenceQueue f2978e = new ReferenceQueue();
    final ReferenceQueue f2979f = new ReferenceQueue();
    final Map f2980g = new IdentityHashMap();
    final Map f2981h = new IdentityHashMap();
    final C0468f f2982i = new C0468f();
    final Map f2983j = new IdentityHashMap();
    private Future f2984k;

    public C0482l(C0426a c0426a) {
        this.f2976c = c0426a;
    }

    private void m5764a(C0460o c0460o) {
        Set keySet = c0460o.f2925a.keySet();
        if (keySet.size() > 0) {
            WeakReference weakReference = (WeakReference) keySet.iterator().next();
            ae aeVar = (ae) weakReference.get();
            if (aeVar == null) {
                this.f2980g.remove(weakReference);
                C0462b.m5666a("[COMPLETED_ASYNC_REALM_RESULTS " + weakReference + "] realm:" + this + " RealmResults GC'd ignore results");
                return;
            }
            int a = this.f2976c.f2788e.m5758c().m5752a(c0460o.f2927c);
            if (a == 0) {
                if (aeVar.m5408b()) {
                    C0462b.m5666a("[COMPLETED_ASYNC_REALM_RESULTS " + weakReference + "] , realm:" + this + " ignoring result the RealmResults (is already loaded)");
                    return;
                }
                C0462b.m5666a("[COMPLETED_ASYNC_REALM_RESULTS " + weakReference + "] , realm:" + this + " same versions, using results (RealmResults is not loaded)");
                aeVar.m5405a(((Long) c0460o.f2925a.get(weakReference)).longValue());
                aeVar.m5409c();
            } else if (a <= 0) {
                C0462b.m5666a("[COMPLETED_ASYNC_REALM_RESULTS " + weakReference + "] , realm:" + this + " caller thread behind worker thread, ignore results (a batch update will update everything including this query)");
            } else if (aeVar.m5408b()) {
                C0462b.m5666a("[COMPLETED_ASYNC_REALM_RESULTS " + weakReference + "] , realm:" + this + " caller is more advanced & RealmResults is loaded ignore the outdated result");
            } else {
                C0462b.m5666a("[COMPLETED_ASYNC_REALM_RESULTS " + weakReference + "] , realm:" + this + " caller is more advanced & RealmResults is not loaded, rerunning the query against the latest version");
                ad adVar = (ad) this.f2980g.get(weakReference);
                C0483m.b.submit(C0449d.m5645a().mo927a(this.f2976c.mo890g()).mo926a(weakReference, adVar.m5398c(), adVar.m5397b()).mo925a(this.f2976c.f2791h, 39088169).mo924a());
            }
        }
    }

    private void m5765a(Iterator it) {
        List arrayList = new ArrayList();
        while (it.hasNext()) {
            ae aeVar = (ae) ((WeakReference) it.next()).get();
            if (aeVar == null) {
                it.remove();
            } else {
                arrayList.add(aeVar);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext() && !this.f2976c.mo892j()) {
            ((ae) it2.next()).m5409c();
        }
    }

    private void m5766b(C0460o c0460o) {
        int a = this.f2976c.f2788e.m5758c().m5752a(c0460o.f2927c);
        if (a > 0) {
            C0462b.m5666a("COMPLETED_UPDATE_ASYNC_QUERIES realm:" + this + " caller is more advanced, rerun updates");
            this.f2976c.f2791h.sendEmptyMessage(14930352);
            return;
        }
        if (a != 0) {
            C0462b.m5666a("COMPLETED_UPDATE_ASYNC_QUERIES realm:" + this + " caller is behind  advance_read");
            try {
                this.f2976c.f2788e.m5754a(c0460o.f2927c);
            } catch (Throwable e) {
                throw new IllegalStateException("Failed to advance Caller Realm to Worker Realm version", e);
            }
        }
        ArrayList arrayList = new ArrayList(c0460o.f2925a.size());
        for (Entry entry : c0460o.f2925a.entrySet()) {
            WeakReference weakReference = (WeakReference) entry.getKey();
            ae aeVar = (ae) weakReference.get();
            if (aeVar == null) {
                this.f2980g.remove(weakReference);
            } else {
                aeVar.m5405a(((Long) entry.getValue()).longValue());
                arrayList.add(aeVar);
                C0462b.m5666a("COMPLETED_UPDATE_ASYNC_QUERIES realm:" + this + " updating RealmResults " + weakReference);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ae) it.next()).m5409c();
        }
        m5776a();
        m5770g();
        m5771h();
        this.f2984k = null;
    }

    private void m5767c(C0460o c0460o) {
        Set keySet = c0460o.f2926b.keySet();
        if (keySet.size() > 0) {
            WeakReference weakReference = (WeakReference) keySet.iterator().next();
            C0391z c0391z = (C0391z) weakReference.get();
            if (c0391z != null) {
                int a = this.f2976c.f2788e.m5758c().m5752a(c0460o.f2927c);
                if (a == 0) {
                    long longValue = ((Long) c0460o.f2926b.get(weakReference)).longValue();
                    if (longValue != 0 && this.f2981h.containsKey(weakReference)) {
                        this.f2981h.remove(weakReference);
                        this.f2983j.put(weakReference, null);
                    }
                    c0391z.m5231a(Long.valueOf(longValue));
                    c0391z.m5229A();
                } else if (a <= 0) {
                    throw new IllegalStateException("Caller thread behind the Worker thread");
                } else if (c0391z.m5232z()) {
                    C0462b.m5666a("[COMPLETED_ASYNC_REALM_OBJECT " + c0391z + "] , realm:" + this + " RealmObject is already loaded, just notify it.");
                    c0391z.m5229A();
                } else {
                    C0462b.m5666a("[COMPLETED_ASYNC_REALM_OBJECT " + c0391z + "] , realm:" + this + " RealmObject is not loaded yet. Rerun the query.");
                    ad adVar = (ad) this.f2983j.get(weakReference);
                    if (adVar == null) {
                        adVar = (ad) this.f2981h.get(weakReference);
                    }
                    C0483m.b.submit(C0449d.m5645a().mo927a(this.f2976c.mo890g()).mo928b(weakReference, adVar.m5398c(), adVar.m5397b()).mo925a(this.f2976c.f2791h, 63245986).mo924a());
                }
            }
        }
    }

    private void m5768e() {
        m5769f();
        m5770g();
        m5771h();
    }

    private void m5769f() {
        m5765a(this.f2980g.keySet().iterator());
    }

    private void m5770g() {
        m5765a(this.f2982i.keySet().iterator());
    }

    private void m5771h() {
        List arrayList = new ArrayList();
        Iterator it = this.f2983j.keySet().iterator();
        while (it.hasNext()) {
            C0391z c0391z = (C0391z) ((WeakReference) it.next()).get();
            if (c0391z == null) {
                it.remove();
            } else if (c0391z.f2728a.mo910d()) {
                arrayList.add(c0391z);
            } else if (c0391z.f2728a != C0439o.f2894b) {
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext() && !this.f2976c.mo892j()) {
            ((C0391z) it2.next()).m5229A();
        }
    }

    private void m5772i() {
        if (!(this.f2984k == null || this.f2984k.isDone())) {
            this.f2984k.cancel(true);
            C0483m.b.getQueue().remove(this.f2984k);
            C0462b.m5666a("REALM_CHANGED realm:" + this + " cancelling pending COMPLETED_UPDATE_ASYNC_QUERIES updates");
        }
        C0462b.m5666a("REALM_CHANGED realm:" + this + " updating async queries, total: " + this.f2980g.size());
        C0458n a = C0449d.m5645a().mo927a(this.f2976c.mo890g());
        C0457l c0457l = null;
        Iterator it = this.f2980g.entrySet().iterator();
        while (it.hasNext()) {
            C0457l c0457l2;
            Entry entry = (Entry) it.next();
            WeakReference weakReference = (WeakReference) entry.getKey();
            if (((ae) weakReference.get()) == null) {
                it.remove();
                c0457l2 = c0457l;
            } else {
                c0457l2 = a.mo926a(weakReference, ((ad) entry.getValue()).m5398c(), ((ad) entry.getValue()).m5397b());
            }
            c0457l = c0457l2;
        }
        if (c0457l != null) {
            this.f2984k = C0483m.b.submit(c0457l.mo925a(this.f2976c.f2791h, 24157817).mo924a());
        }
    }

    private void m5773j() {
        m5775l();
        if (m5774k()) {
            m5772i();
            return;
        }
        C0462b.m5666a("REALM_CHANGED realm:" + this + " no async queries, advance_read");
        this.f2976c.f2788e.m5756b();
        m5780c();
        if (!this.f2976c.mo892j() && m5781d()) {
            m5779b();
        }
    }

    private boolean m5774k() {
        Iterator it = this.f2980g.entrySet().iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (((WeakReference) ((Entry) it.next()).getKey()).get() == null) {
                it.remove();
                z2 = z;
            } else {
                z2 = false;
            }
            z = z2;
        }
        return !z;
    }

    private void m5775l() {
        while (true) {
            Reference poll = this.f2977d.poll();
            if (poll == null) {
                break;
            }
            this.f2980g.remove(poll);
        }
        while (true) {
            poll = this.f2978e.poll();
            if (poll == null) {
                break;
            }
            this.f2982i.remove(poll);
        }
        while (true) {
            poll = this.f2979f.poll();
            if (poll != null) {
                this.f2983j.remove(poll);
            } else {
                return;
            }
        }
    }

    void m5776a() {
        Iterator it = this.f2974a.iterator();
        while (it.hasNext() && !this.f2976c.mo892j()) {
            ((C0489t) it.next()).m5822a();
        }
        Iterator it2 = this.f2975b.iterator();
        Collection collection = null;
        while (it2.hasNext() && !this.f2976c.mo892j()) {
            List arrayList;
            WeakReference weakReference = (WeakReference) it2.next();
            C0489t c0489t = (C0489t) weakReference.get();
            Collection collection2;
            if (c0489t == null) {
                if (collection == null) {
                    arrayList = new ArrayList(this.f2975b.size());
                } else {
                    collection2 = collection;
                }
                arrayList.add(weakReference);
            } else {
                c0489t.m5822a();
                collection2 = collection;
            }
            Object obj = arrayList;
        }
        if (collection != null) {
            this.f2975b.removeAll(collection);
        }
    }

    void m5777a(ae aeVar) {
        this.f2982i.m5695a(new WeakReference(aeVar, this.f2978e));
    }

    void m5778a(C0391z c0391z) {
        this.f2983j.put(new WeakReference(c0391z), null);
    }

    void m5779b() {
        Iterator it = this.f2981h.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((WeakReference) entry.getKey()).get() != null) {
                C0483m.b.submit(C0449d.m5645a().mo927a(this.f2976c.mo890g()).mo928b((WeakReference) entry.getKey(), ((ad) entry.getValue()).m5398c(), ((ad) entry.getValue()).m5397b()).mo925a(this.f2976c.f2791h, 63245986).mo924a());
            } else {
                it.remove();
            }
        }
    }

    void m5780c() {
        m5776a();
        m5768e();
    }

    boolean m5781d() {
        Iterator it = this.f2981h.entrySet().iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (((WeakReference) ((Entry) it.next()).getKey()).get() == null) {
                it.remove();
                z2 = z;
            } else {
                z2 = false;
            }
            z = z2;
        }
        return !z;
    }

    public boolean handleMessage(Message message) {
        if (this.f2976c.f2788e != null) {
            switch (message.what) {
                case 14930352:
                    m5773j();
                    break;
                case 24157817:
                    m5766b((C0460o) message.obj);
                    break;
                case 39088169:
                    m5764a((C0460o) message.obj);
                    break;
                case 63245986:
                    m5767c((C0460o) message.obj);
                    break;
                case 102334155:
                    throw ((Error) message.obj);
                default:
                    throw new IllegalArgumentException("Unknown message: " + message.what);
            }
        }
        return true;
    }
}
