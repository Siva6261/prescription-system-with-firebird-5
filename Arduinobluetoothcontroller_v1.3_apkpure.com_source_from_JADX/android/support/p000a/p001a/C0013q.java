package android.support.p000a.p001a;

import android.graphics.Path;

class C0013q {
    protected C0009i[] f31m = null;
    String f32n;
    int f33o;

    public C0013q(C0013q c0013q) {
        this.f32n = c0013q.f32n;
        this.f33o = c0013q.f33o;
        this.f31m = C0006f.m12a(c0013q.f31m);
    }

    public void m35a(Path path) {
        path.reset();
        if (this.f31m != null) {
            C0009i.m18a(this.f31m, path);
        }
    }

    public boolean mo22a() {
        return false;
    }

    public String m37b() {
        return this.f32n;
    }
}
