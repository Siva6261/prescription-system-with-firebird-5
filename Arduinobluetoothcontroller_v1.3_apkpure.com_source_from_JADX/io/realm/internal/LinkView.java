package io.realm.internal;

public class LinkView extends C0437j {
    final Table f2869a;
    final long f2870b;
    private final C0465c f2871d;

    public LinkView(C0465c c0465c, Table table, long j, long j2) {
        this.f2871d = c0465c;
        this.f2869a = table;
        this.f2870b = j;
        this.c = j2;
        c0465c.m5686a();
        c0465c.m5687a(0, (C0437j) this);
    }

    private void m5494e() {
        if (this.f2869a.m5556h()) {
            throw new IllegalStateException("Changing Realm data can only be done from inside a transaction.");
        }
    }

    private native void nativeAdd(long j, long j2);

    private native void nativeClear(long j);

    static native void nativeClose(long j);

    private native long nativeFind(long j, long j2);

    private native long nativeGetTargetRowIndex(long j, long j2);

    private native long nativeGetTargetTable(long j);

    private native void nativeInsert(long j, long j2, long j3);

    private native boolean nativeIsAttached(long j);

    private native void nativeRemove(long j, long j2);

    private native void nativeSet(long j, long j2, long j3);

    private native long nativeSize(long j);

    public long m5495a(long j) {
        return nativeGetTargetRowIndex(this.c, j);
    }

    public void m5496a() {
        m5494e();
        nativeClear(this.c);
    }

    public void m5497a(long j, long j2) {
        m5494e();
        nativeInsert(this.c, j, j2);
    }

    public long m5498b() {
        return nativeSize(this.c);
    }

    public void m5499b(long j) {
        m5494e();
        nativeAdd(this.c, j);
    }

    public void m5500b(long j, long j2) {
        m5494e();
        nativeSet(this.c, j, j2);
    }

    public void m5501c(long j) {
        m5494e();
        nativeRemove(this.c, j);
    }

    public boolean m5502c() {
        return nativeIsAttached(this.c);
    }

    public Table m5503d() {
        this.f2871d.m5686a();
        long nativeGetTargetTable = nativeGetTargetTable(this.c);
        try {
            return new Table(this.f2871d, this.f2869a, nativeGetTargetTable);
        } catch (RuntimeException e) {
            Table.nativeClose(nativeGetTargetTable);
            throw e;
        }
    }

    public boolean m5504d(long j) {
        return nativeFind(this.c, j) != -1;
    }
}
