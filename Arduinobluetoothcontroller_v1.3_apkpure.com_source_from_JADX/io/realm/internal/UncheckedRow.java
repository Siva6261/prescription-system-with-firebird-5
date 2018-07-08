package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Date;

public class UncheckedRow extends C0437j implements C0439o {
    final C0465c f2895a;
    final Table f2896d;

    protected UncheckedRow(C0465c c0465c, Table table, long j) {
        this.f2895a = c0465c;
        this.f2896d = table;
        this.c = j;
        c0465c.m5686a();
    }

    public static UncheckedRow m5602a(C0465c c0465c, Table table, long j) {
        C0437j uncheckedRow = new UncheckedRow(c0465c, table, table.nativeGetRowPtr(table.f2880b, j));
        c0465c.m5687a(1, uncheckedRow);
        return uncheckedRow;
    }

    public static UncheckedRow m5603b(C0465c c0465c, Table table, long j) {
        C0437j uncheckedRow = new UncheckedRow(c0465c, table, j);
        c0465c.m5687a(1, uncheckedRow);
        return uncheckedRow;
    }

    static native void nativeClose(long j);

    public long mo901a() {
        return nativeGetColumnCount(this.c);
    }

    public long mo902a(String str) {
        if (str != null) {
            return nativeGetColumnIndex(this.c, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public String mo903a(long j) {
        return nativeGetColumnName(this.c, j);
    }

    public void m5607a(long j, long j2) {
        this.f2896d.m5558i();
        mo907b().m5538a(j, mo908c(), j2);
        nativeSetLong(this.c, j, j2);
    }

    public void mo904a(long j, String str) {
        this.f2896d.m5558i();
        mo907b().m5539a(j, mo908c(), str);
        nativeSetString(this.c, j, str);
    }

    public void mo905a(long j, boolean z) {
        this.f2896d.m5558i();
        nativeSetBoolean(this.c, j, z);
    }

    public RealmFieldType mo906b(long j) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.c, j));
    }

    public Table mo907b() {
        return this.f2896d;
    }

    public long mo908c() {
        return nativeGetIndex(this.c);
    }

    public long mo909c(long j) {
        return nativeGetLong(this.c, j);
    }

    public boolean mo910d() {
        return this.c != 0 && nativeIsAttached(this.c);
    }

    public boolean mo911d(long j) {
        return nativeGetBoolean(this.c, j);
    }

    public float mo912e(long j) {
        return nativeGetFloat(this.c, j);
    }

    public double mo913f(long j) {
        return nativeGetDouble(this.c, j);
    }

    public Date mo914g(long j) {
        return new Date(nativeGetDateTime(this.c, j) * 1000);
    }

    public String mo915h(long j) {
        return nativeGetString(this.c, j);
    }

    public byte[] mo916i(long j) {
        return nativeGetByteArray(this.c, j);
    }

    public boolean mo917j(long j) {
        return nativeIsNullLink(this.c, j);
    }

    public LinkView mo918k(long j) {
        return new LinkView(this.f2895a, this.f2896d, j, nativeGetLinkView(this.c, j));
    }

    public boolean mo919l(long j) {
        return nativeIsNull(this.c, j);
    }

    public void mo920m(long j) {
        nativeSetNull(this.c, j);
    }

    protected native boolean nativeGetBoolean(long j, long j2);

    protected native byte[] nativeGetByteArray(long j, long j2);

    protected native long nativeGetColumnCount(long j);

    protected native long nativeGetColumnIndex(long j, String str);

    protected native String nativeGetColumnName(long j, long j2);

    protected native int nativeGetColumnType(long j, long j2);

    protected native long nativeGetDateTime(long j, long j2);

    protected native double nativeGetDouble(long j, long j2);

    protected native float nativeGetFloat(long j, long j2);

    protected native long nativeGetIndex(long j);

    protected native long nativeGetLinkView(long j, long j2);

    protected native long nativeGetLong(long j, long j2);

    protected native String nativeGetString(long j, long j2);

    protected native boolean nativeIsAttached(long j);

    protected native boolean nativeIsNull(long j, long j2);

    protected native boolean nativeIsNullLink(long j, long j2);

    protected native void nativeSetBoolean(long j, long j2, boolean z);

    protected native void nativeSetLong(long j, long j2, long j3);

    protected native void nativeSetNull(long j, long j2);

    protected native void nativeSetString(long j, long j2, String str);
}
