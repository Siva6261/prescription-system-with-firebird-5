package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bx {
    private static bx f403a;
    private final Object f404b = new Object();
    private final Handler f405c = new Handler(Looper.getMainLooper(), new by(this));
    private ca f406d;
    private ca f407e;

    private bx() {
    }

    static bx m653a() {
        if (f403a == null) {
            f403a = new bx();
        }
        return f403a;
    }

    private void m655a(ca caVar) {
        if (caVar.f411b != -2) {
            int i = 2750;
            if (caVar.f411b > 0) {
                i = caVar.f411b;
            } else if (caVar.f411b == -1) {
                i = 1500;
            }
            this.f405c.removeCallbacksAndMessages(caVar);
            this.f405c.sendMessageDelayed(Message.obtain(this.f405c, 0, caVar), (long) i);
        }
    }

    private boolean m656a(ca caVar, int i) {
        bz bzVar = (bz) caVar.f410a.get();
        if (bzVar == null) {
            return false;
        }
        this.f405c.removeCallbacksAndMessages(caVar);
        bzVar.mo106a(i);
        return true;
    }

    private void m657b() {
        if (this.f407e != null) {
            this.f406d = this.f407e;
            this.f407e = null;
            bz bzVar = (bz) this.f406d.f410a.get();
            if (bzVar != null) {
                bzVar.mo105a();
            } else {
                this.f406d = null;
            }
        }
    }

    private void m658b(ca caVar) {
        synchronized (this.f404b) {
            if (this.f406d == caVar || this.f407e == caVar) {
                m656a(caVar, 2);
            }
        }
    }

    private boolean m659f(bz bzVar) {
        return this.f406d != null && this.f406d.m672a(bzVar);
    }

    private boolean m660g(bz bzVar) {
        return this.f407e != null && this.f407e.m672a(bzVar);
    }

    public void m661a(int i, bz bzVar) {
        synchronized (this.f404b) {
            if (m659f(bzVar)) {
                this.f406d.f411b = i;
                this.f405c.removeCallbacksAndMessages(this.f406d);
                m655a(this.f406d);
                return;
            }
            if (m660g(bzVar)) {
                this.f407e.f411b = i;
            } else {
                this.f407e = new ca(i, bzVar);
            }
            if (this.f406d == null || !m656a(this.f406d, 4)) {
                this.f406d = null;
                m657b();
                return;
            }
        }
    }

    public void m662a(bz bzVar) {
        synchronized (this.f404b) {
            if (m659f(bzVar)) {
                this.f406d = null;
                if (this.f407e != null) {
                    m657b();
                }
            }
        }
    }

    public void m663a(bz bzVar, int i) {
        synchronized (this.f404b) {
            if (m659f(bzVar)) {
                m656a(this.f406d, i);
            } else if (m660g(bzVar)) {
                m656a(this.f407e, i);
            }
        }
    }

    public void m664b(bz bzVar) {
        synchronized (this.f404b) {
            if (m659f(bzVar)) {
                m655a(this.f406d);
            }
        }
    }

    public void m665c(bz bzVar) {
        synchronized (this.f404b) {
            if (m659f(bzVar)) {
                this.f405c.removeCallbacksAndMessages(this.f406d);
            }
        }
    }

    public void m666d(bz bzVar) {
        synchronized (this.f404b) {
            if (m659f(bzVar)) {
                m655a(this.f406d);
            }
        }
    }

    public boolean m667e(bz bzVar) {
        boolean z;
        synchronized (this.f404b) {
            z = m659f(bzVar) || m660g(bzVar);
        }
        return z;
    }
}
