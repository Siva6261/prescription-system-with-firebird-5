package io.realm.internal.async;

import android.os.Handler;
import io.realm.C0490u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class C0459m implements C0453h, C0454i, C0456k, C0457l, C0458n {
    private C0490u f2920a;
    private List f2921b;
    private C0455j f2922c;
    private WeakReference f2923d;
    private int f2924e;

    private C0459m() {
    }

    public C0449d mo924a() {
        return new C0449d(this.f2921b != null ? 0 : 1, this.f2920a, this.f2921b, this.f2922c, this.f2923d, this.f2924e);
    }

    public C0453h mo925a(Handler handler, int i) {
        this.f2923d = new WeakReference(handler);
        this.f2924e = i;
        return this;
    }

    public C0457l mo926a(WeakReference weakReference, long j, C0446a c0446a) {
        if (this.f2921b == null) {
            this.f2921b = new ArrayList(1);
        }
        this.f2921b.add(new C0455j(weakReference, j, c0446a));
        return this;
    }

    public C0458n mo927a(C0490u c0490u) {
        this.f2920a = c0490u;
        return this;
    }

    public C0454i mo928b(WeakReference weakReference, long j, C0446a c0446a) {
        this.f2922c = new C0455j(weakReference, j, c0446a);
        return this;
    }
}
