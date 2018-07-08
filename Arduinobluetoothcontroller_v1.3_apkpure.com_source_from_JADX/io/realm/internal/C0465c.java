package io.realm.internal;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class C0465c {
    private List f2936a = new ArrayList();
    private List f2937b = new ArrayList();
    private List f2938c = new ArrayList();
    private C0467e f2939d = new C0467e();
    private ReferenceQueue f2940e = new ReferenceQueue();
    private boolean f2941f = false;

    private void m5685b() {
        C0472k c0472k = (C0472k) this.f2940e.poll();
        while (c0472k != null) {
            c0472k.m5724a();
            this.f2939d.f2943b.add(c0472k.f2952c);
            c0472k = (C0472k) this.f2940e.poll();
        }
    }

    public synchronized void m5686a() {
        int i = 0;
        synchronized (this) {
            int i2;
            for (i2 = 0; i2 < this.f2936a.size(); i2++) {
                Table.nativeClose(((Long) this.f2936a.get(i2)).longValue());
            }
            this.f2936a.clear();
            for (i2 = 0; i2 < this.f2937b.size(); i2++) {
                TableView.nativeClose(((Long) this.f2937b.get(i2)).longValue());
            }
            this.f2937b.clear();
            while (i < this.f2938c.size()) {
                TableQuery.nativeClose(((Long) this.f2938c.get(i)).longValue());
                i++;
            }
            this.f2938c.clear();
            m5685b();
        }
    }

    public synchronized void m5687a(int i, C0437j c0437j) {
        this.f2939d.m5694a(new C0472k(i, c0437j, this.f2940e, this.f2939d.m5693a()));
    }

    public void m5688a(long j) {
        if (this.f2941f) {
            TableView.nativeClose(j);
        } else {
            this.f2937b.add(Long.valueOf(j));
        }
    }

    public void m5689a(long j, boolean z) {
        if (z || this.f2941f) {
            Table.nativeClose(j);
        } else {
            this.f2936a.add(Long.valueOf(j));
        }
    }

    public void m5690b(long j) {
        if (this.f2941f) {
            TableQuery.nativeClose(j);
        } else {
            this.f2938c.add(Long.valueOf(j));
        }
    }

    public void m5691c(long j) {
        Group.nativeClose(j);
    }

    public void m5692d(long j) {
        SharedGroup.nativeClose(j);
    }

    protected void finalize() {
        synchronized (this) {
            this.f2941f = true;
        }
        m5686a();
        super.finalize();
    }
}
