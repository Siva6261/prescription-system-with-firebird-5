package io.realm.internal;

import io.realm.exceptions.RealmIOException;
import java.io.Closeable;
import java.io.IOError;

public class SharedGroup implements Closeable {
    private final String f2872a;
    private long f2873b;
    private long f2874c;
    private boolean f2875d = false;
    private boolean f2876e;
    private final C0465c f2877f;

    public SharedGroup(String str, boolean z, C0475q c0475q, byte[] bArr) {
        if (z) {
            this.f2874c = nativeCreateReplication(str, bArr);
            this.f2873b = createNativeWithImplicitTransactions(this.f2874c, c0475q.f2960c, bArr);
            this.f2875d = true;
        } else {
            this.f2873b = nativeCreate(str, C0475q.FULL.f2960c, false, false, bArr);
        }
        this.f2877f = new C0465c();
        this.f2872a = str;
        m5505j();
    }

    private native long createNativeWithImplicitTransactions(long j, int i, byte[] bArr);

    private void m5505j() {
        if (this.f2873b == 0) {
            throw new IOError(new RealmIOException("Realm could not be opened"));
        }
    }

    private native void nativeAdvanceRead(long j);

    private native void nativeAdvanceReadToVersion(long j, long j2, long j3);

    private native long nativeBeginImplicit(long j);

    protected static native void nativeClose(long j);

    private native void nativeCloseReplication(long j);

    private native void nativeCommitAndContinueAsRead(long j);

    private native long nativeCreate(String str, int i, boolean z, boolean z2, byte[] bArr);

    private native long nativeCreateReplication(String str, byte[] bArr);

    private native long[] nativeGetVersionID(long j);

    private native void nativePromoteToWrite(long j);

    private native void nativeRollbackAndContinueAsRead(long j);

    void m5506a() {
        nativeAdvanceRead(this.f2873b);
    }

    void m5507a(C0476r c0476r) {
        nativeAdvanceReadToVersion(this.f2873b, c0476r.f2961a, c0476r.f2962b);
    }

    void m5508b() {
        nativePromoteToWrite(this.f2873b);
    }

    void m5509c() {
        nativeCommitAndContinueAsRead(this.f2873b);
    }

    public void close() {
        synchronized (this.f2877f) {
            if (this.f2873b != 0) {
                nativeClose(this.f2873b);
                this.f2873b = 0;
                if (this.f2875d && this.f2874c != 0) {
                    nativeCloseReplication(this.f2874c);
                    this.f2874c = 0;
                }
            }
        }
    }

    void m5510d() {
        nativeRollbackAndContinueAsRead(this.f2873b);
    }

    public C0469g m5511e() {
        if (this.f2876e) {
            throw new IllegalStateException("Can't beginImplicitTransaction() during another active transaction");
        }
        C0469g c0469g = new C0469g(this.f2877f, this, nativeBeginImplicit(this.f2873b));
        this.f2876e = true;
        return c0469g;
    }

    public boolean m5512f() {
        return this.f2873b == 0;
    }

    protected void finalize() {
        synchronized (this.f2877f) {
            if (this.f2873b != 0) {
                this.f2877f.m5692d(this.f2873b);
                this.f2873b = 0;
                if (this.f2875d && this.f2874c != 0) {
                    nativeCloseReplication(this.f2874c);
                    this.f2874c = 0;
                }
            }
        }
    }

    public String m5513g() {
        return this.f2872a;
    }

    public long m5514h() {
        return this.f2873b;
    }

    public C0476r m5515i() {
        long[] nativeGetVersionID = nativeGetVersionID(this.f2873b);
        return new C0476r(nativeGetVersionID[0], nativeGetVersionID[1]);
    }
}
