package io.realm.internal;

import java.io.Closeable;

public class Group implements Closeable {
    protected long f2865a;
    protected boolean f2866b;
    private final C0465c f2867c;

    public Group() {
        this.f2866b = false;
        this.f2867c = new C0465c();
        this.f2865a = createNative();
        mo929b();
    }

    Group(C0465c c0465c, long j, boolean z) {
        this.f2867c = c0465c;
        this.f2865a = j;
        this.f2866b = z;
    }

    private void mo929b() {
        if (this.f2865a == 0) {
            throw new OutOfMemoryError("Out of native memory.");
        }
    }

    private void mo930c() {
        if (this.f2865a == 0) {
            throw new IllegalStateException("Illegal to call methods on a closed Group.");
        }
    }

    protected static native void nativeClose(long j);

    boolean m5491a() {
        return this.f2865a == 0;
    }

    public boolean m5492a(String str) {
        mo930c();
        return str != null && nativeHasTable(this.f2865a, str);
    }

    public Table m5493b(String str) {
        mo930c();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid name. Name must be a non-empty String.");
        } else if (!this.f2866b || m5492a(str)) {
            this.f2867c.m5686a();
            long nativeGetTableNativePtr = nativeGetTableNativePtr(this.f2865a, str);
            try {
                return new Table(this.f2867c, this, nativeGetTableNativePtr);
            } catch (RuntimeException e) {
                Table.nativeClose(nativeGetTableNativePtr);
                throw e;
            }
        } else {
            throw new IllegalStateException("Requested table is not in this Realm. Creating it requires a transaction: " + str);
        }
    }

    public void close() {
        synchronized (this.f2867c) {
            if (this.f2865a != 0) {
                nativeClose(this.f2865a);
                this.f2865a = 0;
            }
        }
    }

    protected native long createNative();

    protected void finalize() {
        synchronized (this.f2867c) {
            if (this.f2865a != 0) {
                this.f2867c.m5691c(this.f2865a);
                this.f2865a = 0;
            }
        }
    }

    protected native long nativeGetTableNativePtr(long j, String str);

    protected native boolean nativeHasTable(long j, String str);

    protected native String nativeToString(long j);

    public String toString() {
        return nativeToString(this.f2865a);
    }
}
