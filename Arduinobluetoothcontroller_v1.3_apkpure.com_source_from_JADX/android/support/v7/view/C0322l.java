package android.support.v7.view;

import android.support.v4.view.dy;
import android.support.v4.view.ep;
import android.support.v4.view.eq;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class C0322l {
    private final ArrayList f1489a = new ArrayList();
    private long f1490b = -1;
    private Interpolator f1491c;
    private ep f1492d;
    private boolean f1493e;
    private final eq f1494f = new C0323m(this);

    private void m3287c() {
        this.f1493e = false;
    }

    public C0322l m3288a(long j) {
        if (!this.f1493e) {
            this.f1490b = j;
        }
        return this;
    }

    public C0322l m3289a(dy dyVar) {
        if (!this.f1493e) {
            this.f1489a.add(dyVar);
        }
        return this;
    }

    public C0322l m3290a(dy dyVar, dy dyVar2) {
        this.f1489a.add(dyVar);
        dyVar2.m2390b(dyVar.m2383a());
        this.f1489a.add(dyVar2);
        return this;
    }

    public C0322l m3291a(ep epVar) {
        if (!this.f1493e) {
            this.f1492d = epVar;
        }
        return this;
    }

    public C0322l m3292a(Interpolator interpolator) {
        if (!this.f1493e) {
            this.f1491c = interpolator;
        }
        return this;
    }

    public void m3293a() {
        if (!this.f1493e) {
            Iterator it = this.f1489a.iterator();
            while (it.hasNext()) {
                dy dyVar = (dy) it.next();
                if (this.f1490b >= 0) {
                    dyVar.m2385a(this.f1490b);
                }
                if (this.f1491c != null) {
                    dyVar.m2388a(this.f1491c);
                }
                if (this.f1492d != null) {
                    dyVar.m2386a(this.f1494f);
                }
                dyVar.m2393c();
            }
            this.f1493e = true;
        }
    }

    public void m3294b() {
        if (this.f1493e) {
            Iterator it = this.f1489a.iterator();
            while (it.hasNext()) {
                ((dy) it.next()).m2391b();
            }
            this.f1493e = false;
        }
    }
}
