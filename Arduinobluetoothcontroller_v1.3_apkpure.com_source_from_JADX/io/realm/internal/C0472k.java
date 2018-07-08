package io.realm.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public final class C0472k extends PhantomReference {
    final long f2950a;
    final int f2951b;
    final Integer f2952c;

    C0472k(int i, C0437j c0437j, ReferenceQueue referenceQueue, Integer num) {
        super(c0437j, referenceQueue);
        this.f2951b = i;
        this.f2950a = c0437j.f2868c;
        this.f2952c = num;
    }

    void m5724a() {
        switch (this.f2951b) {
            case 0:
                LinkView.nativeClose(this.f2950a);
                return;
            case 1:
                UncheckedRow.nativeClose(this.f2950a);
                return;
            default:
                throw new IllegalStateException("Unknown native reference type " + this.f2951b + ".");
        }
    }
}
