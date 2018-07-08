package io.realm.internal;

import io.realm.ai;
import java.io.Closeable;

public class TableQuery implements Closeable {
    protected boolean f2884a = false;
    protected long f2885b;
    protected final Table f2886c;
    private final C0438u f2887d;
    private final C0465c f2888e;
    private boolean f2889f = true;

    public TableQuery(C0465c c0465c, Table table, long j) {
        if (this.f2884a) {
            System.err.println("++++++ new TableQuery, ptr= " + j);
        }
        this.f2888e = c0465c;
        this.f2886c = table;
        this.f2885b = j;
        this.f2887d = null;
    }

    public TableQuery(C0465c c0465c, Table table, long j, C0438u c0438u) {
        if (this.f2884a) {
            System.err.println("++++++ new TableQuery, ptr= " + j);
        }
        this.f2888e = c0465c;
        this.f2886c = table;
        this.f2885b = j;
        this.f2887d = c0438u;
    }

    public static boolean[] m5567a(ai[] aiVarArr) {
        boolean[] zArr = new boolean[aiVarArr.length];
        for (int i = 0; i < aiVarArr.length; i++) {
            zArr[i] = aiVarArr[i].m5422a();
        }
        return zArr;
    }

    private void m5568b() {
        if (!this.f2889f) {
            String nativeValidateQuery = nativeValidateQuery(this.f2885b);
            if (nativeValidateQuery.equals("")) {
                this.f2889f = true;
                return;
            }
            throw new UnsupportedOperationException(nativeValidateQuery);
        }
    }

    public static native long[] nativeBatchUpdateQueries(long j, long[] jArr, long[][] jArr2, long[][] jArr3, boolean[][] zArr);

    protected static native void nativeClose(long j);

    public static native void nativeCloseQueryHandover(long j);

    private native void nativeEqual(long j, long[] jArr, boolean z);

    private native long nativeFindAll(long j, long j2, long j3, long j4);

    public static native long nativeFindWithHandover(long j, long j2, long j3);

    private native long nativeHandoverQuery(long j, long j2);

    public static native long nativeImportHandoverRowIntoSharedGroup(long j, long j2);

    private native long nativeImportHandoverTableViewIntoSharedGroup(long j, long j2);

    private native void nativeIsNull(long j, long[] jArr);

    private native String nativeValidateQuery(long j);

    public long m5569a(long j) {
        return nativeHandoverQuery(j, this.f2885b);
    }

    public TableQuery m5570a(long[] jArr) {
        nativeIsNull(this.f2885b, jArr);
        this.f2889f = false;
        return this;
    }

    public TableQuery m5571a(long[] jArr, boolean z) {
        nativeEqual(this.f2885b, jArr, z);
        this.f2889f = false;
        return this;
    }

    public TableView m5572a() {
        m5568b();
        this.f2888e.m5686a();
        long nativeFindAll = nativeFindAll(this.f2885b, 0, -1, -1);
        try {
            return new TableView(this.f2888e, this.f2886c, nativeFindAll, this);
        } catch (RuntimeException e) {
            TableView.nativeClose(nativeFindAll);
            throw e;
        }
    }

    public TableView m5573a(long j, long j2) {
        long nativeImportHandoverTableViewIntoSharedGroup = nativeImportHandoverTableViewIntoSharedGroup(j, j2);
        try {
            return new TableView(this.f2888e, this.f2886c, nativeImportHandoverTableViewIntoSharedGroup);
        } catch (RuntimeException e) {
            if (nativeImportHandoverTableViewIntoSharedGroup != 0) {
                TableView.nativeClose(nativeImportHandoverTableViewIntoSharedGroup);
            }
            throw e;
        }
    }

    public void close() {
        synchronized (this.f2888e) {
            if (this.f2885b != 0) {
                nativeClose(this.f2885b);
                if (this.f2884a) {
                    System.err.println("++++ Query CLOSE, ptr= " + this.f2885b);
                }
                this.f2885b = 0;
            }
        }
    }

    protected void finalize() {
        synchronized (this.f2888e) {
            if (this.f2885b != 0) {
                this.f2888e.m5690b(this.f2885b);
                this.f2885b = 0;
            }
        }
    }
}
