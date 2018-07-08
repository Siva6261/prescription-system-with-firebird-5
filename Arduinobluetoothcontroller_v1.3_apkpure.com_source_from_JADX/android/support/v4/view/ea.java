package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class ea implements ei {
    WeakHashMap f1019a = null;

    ea() {
    }

    private void m2409a(View view) {
        if (this.f1019a != null) {
            Runnable runnable = (Runnable) this.f1019a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    private void m2410d(dy dyVar, View view) {
        Object tag = view.getTag(2113929216);
        ep epVar = tag instanceof ep ? (ep) tag : null;
        Runnable a = dyVar.f1016c;
        Runnable b = dyVar.f1017d;
        dyVar.f1016c = null;
        dyVar.f1017d = null;
        if (a != null) {
            a.run();
        }
        if (epVar != null) {
            epVar.mo112a(view);
            epVar.mo113b(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.f1019a != null) {
            this.f1019a.remove(view);
        }
    }

    private void m2411e(dy dyVar, View view) {
        Runnable runnable = this.f1019a != null ? (Runnable) this.f1019a.get(view) : null;
        if (runnable == null) {
            runnable = new eb(this, dyVar, view);
            if (this.f1019a == null) {
                this.f1019a = new WeakHashMap();
            }
            this.f1019a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    public long mo403a(dy dyVar, View view) {
        return 0;
    }

    public void mo404a(dy dyVar, View view, float f) {
        m2411e(dyVar, view);
    }

    public void mo405a(dy dyVar, View view, long j) {
    }

    public void mo406a(dy dyVar, View view, ep epVar) {
        view.setTag(2113929216, epVar);
    }

    public void mo407a(dy dyVar, View view, er erVar) {
    }

    public void mo408a(dy dyVar, View view, Interpolator interpolator) {
    }

    public void mo409b(dy dyVar, View view) {
        m2411e(dyVar, view);
    }

    public void mo410b(dy dyVar, View view, float f) {
        m2411e(dyVar, view);
    }

    public void mo411b(dy dyVar, View view, long j) {
    }

    public void mo412c(dy dyVar, View view) {
        m2409a(view);
        m2410d(dyVar, view);
    }

    public void mo413c(dy dyVar, View view, float f) {
        m2411e(dyVar, view);
    }
}
