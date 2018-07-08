package io.realm.internal;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class C0471i {
    static final /* synthetic */ boolean f2948a = (!C0471i.class.desiredAssertionStatus());
    private Object f2949b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0471i c0471i = (C0471i) obj;
        if (this.f2949b.getClass() != c0471i.f2949b.getClass()) {
            return false;
        }
        if (this.f2949b instanceof byte[]) {
            return Arrays.equals((byte[]) this.f2949b, (byte[]) c0471i.f2949b);
        }
        if (!(this.f2949b instanceof ByteBuffer)) {
            return this.f2949b.equals(c0471i.f2949b);
        }
        return ((ByteBuffer) this.f2949b).compareTo((ByteBuffer) c0471i.f2949b) == 0;
    }

    public int hashCode() {
        return this.f2949b instanceof byte[] ? Arrays.hashCode((byte[]) this.f2949b) : this.f2949b.hashCode();
    }
}
