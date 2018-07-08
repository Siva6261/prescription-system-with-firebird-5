package io.realm.internal;

import io.realm.RealmFieldType;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicInteger;

public class Table implements C0438u, Closeable {
    public static final String f2878a = Util.m5626a();
    static AtomicInteger f2879d = new AtomicInteger(0);
    protected long f2880b;
    protected final Object f2881c;
    private final C0465c f2882e;
    private long f2883f;

    static {
        C0473l.m5729b();
    }

    public Table() {
        this.f2883f = -1;
        this.f2881c = null;
        this.f2882e = new C0465c();
        this.f2880b = createNative();
        if (this.f2880b == 0) {
            throw new OutOfMemoryError("Out of native memory.");
        }
    }

    Table(C0465c c0465c, Object obj, long j) {
        this.f2883f = -1;
        this.f2882e = c0465c;
        this.f2881c = obj;
        this.f2880b = j;
    }

    private void m5522a(Group group, Table table) {
        nativeMigratePrimaryKeyTableIfNeeded(group.f2865a, table.f2880b);
    }

    private void m5523b(Object obj) {
        throw new RealmPrimaryKeyConstraintException("Value already exists: " + obj);
    }

    public static String m5524c(String str) {
        return !str.startsWith(f2878a) ? str : str.substring(f2878a.length());
    }

    private void m5525d(String str) {
        if (str.length() > 63) {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        }
    }

    private Table m5526n() {
        Group g = m5553g();
        if (g == null) {
            return null;
        }
        Table b = g.m5493b("pk");
        if (b.m5545c() == 0) {
            b.m5533a(RealmFieldType.STRING, "pk_table");
            b.m5533a(RealmFieldType.STRING, "pk_property");
            return b;
        }
        m5522a(g, b);
        return b;
    }

    private boolean m5527n(long j) {
        return j == m5549e();
    }

    private native long nativeAddColumn(long j, int i, String str, boolean z);

    private native long nativeAddEmptyRow(long j, long j2);

    private native void nativeAddSearchIndex(long j, long j2);

    private native void nativeClear(long j);

    static native void nativeClose(long j);

    private native long nativeFindFirstInt(long j, long j2, long j3);

    private native long nativeFindFirstString(long j, long j2, String str);

    private native long nativeGetColumnCount(long j);

    private native long nativeGetColumnIndex(long j, String str);

    private native String nativeGetColumnName(long j, long j2);

    private native int nativeGetColumnType(long j, long j2);

    private native long nativeGetLinkTarget(long j, long j2);

    private native long nativeGetLong(long j, long j2, long j3);

    private native String nativeGetName(long j);

    private native boolean nativeHasSearchIndex(long j, long j2);

    private native boolean nativeIsColumnNullable(long j, long j2);

    private native void nativeMigratePrimaryKeyTableIfNeeded(long j, long j2);

    private native void nativeRemove(long j, long j2);

    private native void nativeRemoveColumn(long j, long j2);

    private native void nativeRemoveSearchIndex(long j, long j2);

    private native void nativeSetLong(long j, long j2, long j3, long j4);

    private native long nativeSetPrimaryKey(long j, long j2, String str);

    private native long nativeSize(long j);

    private native String nativeToString(long j, long j2);

    private native long nativeVersion(long j);

    private native long nativeWhere(long j);

    private void m5528o() {
        if (!m5551f()) {
            throw new IllegalStateException(m5561k() + " has no primary key defined");
        }
    }

    private void m5529p() {
        throw new IllegalStateException("Changing Realm data can only be done from inside a transaction.");
    }

    public long mo895a() {
        return nativeSize(this.f2880b);
    }

    public long m5531a(long j, long j2) {
        return nativeGetLong(this.f2880b, j, j2);
    }

    public long m5532a(long j, String str) {
        if (str != null) {
            return nativeFindFirstString(this.f2880b, j, str);
        }
        throw new IllegalArgumentException("null is not supported");
    }

    public long m5533a(RealmFieldType realmFieldType, String str) {
        return m5534a(realmFieldType, str, false);
    }

    public long m5534a(RealmFieldType realmFieldType, String str, boolean z) {
        m5525d(str);
        return nativeAddColumn(this.f2880b, realmFieldType.getNativeValue(), str, z);
    }

    public long m5535a(Object obj) {
        m5558i();
        m5528o();
        long e = m5549e();
        RealmFieldType d = m5548d(e);
        long nativeAddEmptyRow;
        switch (C0478t.f2965a[d.ordinal()]) {
            case 1:
                if (obj instanceof String) {
                    if (m5532a(e, (String) obj) != -1) {
                        m5523b(obj);
                    }
                    nativeAddEmptyRow = nativeAddEmptyRow(this.f2880b, 1);
                    m5555h(nativeAddEmptyRow).mo904a(e, (String) obj);
                    return nativeAddEmptyRow;
                }
                throw new IllegalArgumentException("Primary key value is not a String: " + obj);
            case 2:
                try {
                    long parseLong = Long.parseLong(obj.toString());
                    if (m5540b(e, parseLong) != -1) {
                        m5523b(Long.valueOf(parseLong));
                    }
                    nativeAddEmptyRow = nativeAddEmptyRow(this.f2880b, 1);
                    m5555h(nativeAddEmptyRow).m5607a(e, parseLong);
                    return nativeAddEmptyRow;
                } catch (RuntimeException e2) {
                    throw new IllegalArgumentException("Primary key value is not a long: " + obj);
                }
            default:
                throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + d);
        }
    }

    public long m5536a(String str) {
        if (str != null) {
            return nativeGetColumnIndex(this.f2880b, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public void m5537a(long j) {
        nativeRemoveColumn(this.f2880b, j);
    }

    void m5538a(long j, long j2, long j3) {
        if (m5527n(j)) {
            long b = m5540b(j, j3);
            if (b != j2 && b != -1) {
                m5523b(Long.valueOf(j3));
            }
        }
    }

    void m5539a(long j, long j2, String str) {
        if (m5552f(j)) {
            long a = m5532a(j, str);
            if (a != j2 && a != -1) {
                m5523b((Object) str);
            }
        }
    }

    public long m5540b(long j, long j2) {
        return nativeFindFirstInt(this.f2880b, j, j2);
    }

    public void mo896b() {
        m5558i();
        nativeClear(this.f2880b);
    }

    public void m5542b(long j, long j2, long j3) {
        m5558i();
        m5538a(j, j2, j3);
        nativeSetLong(this.f2880b, j, j2, j3);
    }

    public void m5543b(String str) {
        Table n = m5526n();
        if (n == null) {
            throw new RealmException("Primary keys are only supported if Table is part of a Group");
        }
        this.f2883f = nativeSetPrimaryKey(n.f2880b, this.f2880b, str);
    }

    public boolean m5544b(long j) {
        return nativeIsColumnNullable(this.f2880b, j);
    }

    public long m5545c() {
        return nativeGetColumnCount(this.f2880b);
    }

    public String m5546c(long j) {
        return nativeGetColumnName(this.f2880b, j);
    }

    public void close() {
        synchronized (this.f2882e) {
            if (this.f2880b != 0) {
                nativeClose(this.f2880b);
                this.f2880b = 0;
            }
        }
    }

    protected native long createNative();

    public long m5547d() {
        m5558i();
        if (m5551f()) {
            long e = m5549e();
            RealmFieldType d = m5548d(e);
            switch (C0478t.f2965a[d.ordinal()]) {
                case 1:
                    if (m5532a(e, "") != -1) {
                        m5523b((Object) "");
                        break;
                    }
                    break;
                case 2:
                    if (m5540b(e, 0) != -1) {
                        m5523b(Long.valueOf(0));
                        break;
                    }
                    break;
                default:
                    throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + d);
            }
        }
        return nativeAddEmptyRow(this.f2880b, 1);
    }

    public RealmFieldType m5548d(long j) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.f2880b, j));
    }

    public long m5549e() {
        if (this.f2883f >= 0 || this.f2883f == -2) {
            return this.f2883f;
        }
        Table n = m5526n();
        if (n == null) {
            return -2;
        }
        long a = n.m5532a(0, m5524c(m5561k()));
        if (a != -1) {
            this.f2883f = m5536a(n.m5555h(a).mo915h(1));
        } else {
            this.f2883f = -2;
        }
        return this.f2883f;
    }

    public void mo897e(long j) {
        m5558i();
        nativeRemove(this.f2880b, j);
    }

    public boolean m5551f() {
        return m5549e() >= 0;
    }

    public boolean m5552f(long j) {
        return j >= 0 && j == m5549e();
    }

    protected void finalize() {
        synchronized (this.f2882e) {
            if (this.f2880b != 0) {
                this.f2882e.m5689a(this.f2880b, this.f2881c == null);
                this.f2880b = 0;
            }
        }
    }

    Group m5553g() {
        return this.f2881c instanceof Group ? (Group) this.f2881c : this.f2881c instanceof Table ? ((Table) this.f2881c).m5553g() : null;
    }

    public Table m5554g(long j) {
        this.f2882e.m5686a();
        long nativeGetLinkTarget = nativeGetLinkTarget(this.f2880b, j);
        try {
            return new Table(this.f2882e, this.f2881c, nativeGetLinkTarget);
        } catch (RuntimeException e) {
            nativeClose(nativeGetLinkTarget);
            throw e;
        }
    }

    public UncheckedRow m5555h(long j) {
        return UncheckedRow.m5602a(this.f2882e, this, j);
    }

    boolean m5556h() {
        return !(this.f2881c instanceof Table) ? this.f2881c != null && ((Group) this.f2881c).f2866b : ((Table) this.f2881c).m5556h();
    }

    public UncheckedRow m5557i(long j) {
        return UncheckedRow.m5603b(this.f2882e, this, j);
    }

    void m5558i() {
        if (m5556h()) {
            m5529p();
        }
    }

    public TableQuery mo898j() {
        this.f2882e.m5686a();
        long nativeWhere = nativeWhere(this.f2880b);
        try {
            return new TableQuery(this.f2882e, this, nativeWhere);
        } catch (RuntimeException e) {
            TableQuery.nativeClose(nativeWhere);
            throw e;
        }
    }

    public void m5560j(long j) {
        m5558i();
        nativeAddSearchIndex(this.f2880b, j);
    }

    public String m5561k() {
        return nativeGetName(this.f2880b);
    }

    public void m5562k(long j) {
        m5558i();
        nativeRemoveSearchIndex(this.f2880b, j);
    }

    public long mo899l() {
        throw new RuntimeException("Not supported for tables");
    }

    public boolean m5564l(long j) {
        return nativeHasSearchIndex(this.f2880b, j);
    }

    public long m5565m() {
        return nativeVersion(this.f2880b);
    }

    public long mo900m(long j) {
        return j;
    }

    native long nativeGetRowPtr(long j, long j2);

    public String toString() {
        return nativeToString(this.f2880b, -1);
    }
}
