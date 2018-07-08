package io.realm.internal;

import java.io.Closeable;

public class TableView implements C0438u, Closeable {
    protected long f2890a;
    protected final Table f2891b;
    private final TableQuery f2892c;
    private final C0465c f2893d;

    protected TableView(C0465c c0465c, Table table, long j) {
        this.f2893d = c0465c;
        this.f2891b = table;
        this.f2890a = j;
        this.f2892c = null;
    }

    protected TableView(C0465c c0465c, Table table, long j, TableQuery tableQuery) {
        this.f2893d = c0465c;
        this.f2891b = table;
        this.f2890a = j;
        this.f2892c = tableQuery;
    }

    private void m5574c() {
        throw new IllegalStateException("Mutable method call during read transaction.");
    }

    private native void nativeClear(long j);

    static native void nativeClose(long j);

    private native long nativeFindBySourceNdx(long j, long j2);

    private native long nativeGetSourceRowIndex(long j, long j2);

    private native void nativeRemoveRow(long j, long j2);

    private native long nativeSize(long j);

    private native long nativeSync(long j);

    private native String nativeToString(long j, long j2);

    private native long nativeWhere(long j);

    public long mo895a() {
        return nativeSize(this.f2890a);
    }

    public long m5576a(long j) {
        return nativeGetSourceRowIndex(this.f2890a, j);
    }

    public void mo896b() {
        if (this.f2891b.m5556h()) {
            m5574c();
        }
        nativeClear(this.f2890a);
    }

    public void close() {
        synchronized (this.f2893d) {
            if (this.f2890a != 0) {
                nativeClose(this.f2890a);
                this.f2890a = 0;
            }
        }
    }

    public void mo897e(long j) {
        if (this.f2891b.m5556h()) {
            m5574c();
        }
        nativeRemoveRow(this.f2890a, j);
    }

    protected void finalize() {
        synchronized (this.f2893d) {
            if (this.f2890a != 0) {
                this.f2893d.m5688a(this.f2890a);
                this.f2890a = 0;
            }
        }
    }

    public TableQuery mo898j() {
        this.f2893d.m5686a();
        long nativeWhere = nativeWhere(this.f2890a);
        try {
            return new TableQuery(this.f2893d, this.f2891b, nativeWhere, this);
        } catch (RuntimeException e) {
            TableQuery.nativeClose(nativeWhere);
            throw e;
        }
    }

    public long mo899l() {
        return nativeSync(this.f2890a);
    }

    public long mo900m(long j) {
        return nativeFindBySourceNdx(this.f2890a, j);
    }

    public String toString() {
        return nativeToString(this.f2890a, 500);
    }
}
