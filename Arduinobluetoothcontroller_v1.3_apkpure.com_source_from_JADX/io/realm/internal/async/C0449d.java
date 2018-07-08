package io.realm.internal.async;

import android.os.Handler;
import io.realm.C0490u;
import io.realm.internal.SharedGroup;
import io.realm.internal.TableQuery;
import io.realm.internal.p027b.C0462b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.IdentityHashMap;
import java.util.List;

public class C0449d implements Runnable {
    private final int f2907a;
    private C0490u f2908b;
    private List f2909c;
    private C0455j f2910d;
    private WeakReference f2911e;
    private int f2912f;

    private C0449d(int i, C0490u c0490u, List list, C0455j c0455j, WeakReference weakReference, int i2) {
        this.f2907a = i;
        this.f2908b = c0490u;
        this.f2909c = list;
        this.f2910d = c0455j;
        this.f2911e = weakReference;
        this.f2912f = i2;
    }

    public static C0456k m5645a() {
        return new C0459m();
    }

    private void m5646a(C0460o c0460o, long[] jArr) {
        int i = 0;
        for (C0455j c0455j : this.f2909c) {
            IdentityHashMap identityHashMap = c0460o.f2925a;
            WeakReference weakReference = c0455j.f2917a;
            int i2 = i + 1;
            identityHashMap.put(weakReference, Long.valueOf(jArr[i]));
            i = i2;
        }
    }

    private boolean m5647a(Handler handler) {
        return handler != null && handler.getLooper().getThread().isAlive();
    }

    private boolean m5648a(SharedGroup sharedGroup, C0460o c0460o) {
        if (m5650c()) {
            TableQuery.nativeCloseQueryHandover(this.f2910d.f2918b);
            return false;
        }
        switch (this.f2910d.f2919c.f2900a) {
            case 3:
                c0460o.f2926b.put(this.f2910d.f2917a, Long.valueOf(TableQuery.nativeFindWithHandover(sharedGroup.m5514h(), this.f2910d.f2918b, 0)));
                return true;
            default:
                throw new IllegalArgumentException("Query mode " + this.f2910d.f2919c.f2900a + " not supported");
        }
    }

    private C0451f m5649b() {
        long[] jArr = new long[this.f2909c.size()];
        long[][] jArr2 = (long[][]) Array.newInstance(Long.TYPE, new int[]{this.f2909c.size(), 6});
        long[][] jArr3 = new long[this.f2909c.size()][];
        boolean[][] zArr = new boolean[this.f2909c.size()][];
        int i = 0;
        for (C0455j c0455j : this.f2909c) {
            switch (c0455j.f2919c.f2900a) {
                case 0:
                    jArr[i] = c0455j.f2918b;
                    jArr2[i][0] = 0;
                    jArr2[i][1] = 0;
                    jArr2[i][2] = -1;
                    jArr2[i][3] = -1;
                    break;
                case 1:
                    jArr[i] = c0455j.f2918b;
                    jArr2[i][0] = 1;
                    jArr2[i][1] = 0;
                    jArr2[i][2] = -1;
                    jArr2[i][3] = -1;
                    jArr2[i][4] = c0455j.f2919c.f2901b;
                    jArr2[i][5] = c0455j.f2919c.f2902c.m5422a() ? 1 : 0;
                    break;
                case 2:
                    jArr[i] = c0455j.f2918b;
                    jArr2[i][0] = 2;
                    jArr2[i][1] = 0;
                    jArr2[i][2] = -1;
                    jArr2[i][3] = -1;
                    jArr3[i] = c0455j.f2919c.f2903d;
                    zArr[i] = TableQuery.m5567a(c0455j.f2919c.f2904e);
                    break;
                case 4:
                    jArr[i] = c0455j.f2918b;
                    jArr2[i][0] = 4;
                    jArr2[i][1] = c0455j.f2919c.f2901b;
                    break;
                default:
                    throw new IllegalArgumentException("Query mode " + c0455j.f2919c.f2900a + " not supported");
            }
            i++;
        }
        C0451f c0451f = new C0451f();
        c0451f.f2913a = jArr;
        c0451f.f2915c = jArr3;
        c0451f.f2916d = zArr;
        c0451f.f2914b = jArr2;
        return c0451f;
    }

    private boolean m5650c() {
        return Thread.currentThread().isInterrupted();
    }

    public void run() {
        Throwable e;
        SharedGroup sharedGroup = null;
        SharedGroup sharedGroup2;
        try {
            sharedGroup2 = new SharedGroup(this.f2908b.m5836i(), true, this.f2908b.m5834g(), this.f2908b.m5830c());
            try {
                boolean z;
                Object obj;
                if (this.f2907a == 0) {
                    C0460o a = C0460o.m5662a();
                    C0451f b = m5649b();
                    m5646a(a, TableQuery.nativeBatchUpdateQueries(sharedGroup2.m5514h(), b.f2913a, b.f2914b, b.f2915c, b.f2916d));
                    a.f2927c = sharedGroup2.m5515i();
                    z = true;
                    obj = a;
                } else {
                    C0460o b2 = C0460o.m5663b();
                    boolean a2 = m5648a(sharedGroup2, b2);
                    b2.f2927c = sharedGroup2.m5515i();
                    C0460o c0460o = b2;
                    z = a2;
                }
                Handler handler = (Handler) this.f2911e.get();
                if (z && !m5650c() && m5647a(handler)) {
                    handler.obtainMessage(this.f2912f, obj).sendToTarget();
                }
                if (sharedGroup2 != null) {
                    sharedGroup2.close();
                }
            } catch (Exception e2) {
                e = e2;
                sharedGroup = sharedGroup2;
                try {
                    C0462b.m5667a(e.getMessage(), e);
                    if (sharedGroup != null) {
                        sharedGroup.close();
                    }
                } catch (Throwable th) {
                    e = th;
                    sharedGroup2 = sharedGroup;
                    if (sharedGroup2 != null) {
                        sharedGroup2.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                if (sharedGroup2 != null) {
                    sharedGroup2.close();
                }
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            C0462b.m5667a(e.getMessage(), e);
            if (sharedGroup != null) {
                sharedGroup.close();
            }
        } catch (Throwable th3) {
            e = th3;
            sharedGroup2 = null;
            if (sharedGroup2 != null) {
                sharedGroup2.close();
            }
            throw e;
        }
    }
}
