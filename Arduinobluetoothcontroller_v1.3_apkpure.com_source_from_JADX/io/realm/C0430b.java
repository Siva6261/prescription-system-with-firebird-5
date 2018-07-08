package io.realm;

import io.realm.internal.p027b.C0462b;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

final class C0430b implements C0429q {
    final /* synthetic */ C0490u f2843a;
    final /* synthetic */ AtomicBoolean f2844b;

    C0430b(C0490u c0490u, AtomicBoolean atomicBoolean) {
        this.f2843a = c0490u;
        this.f2844b = atomicBoolean;
    }

    public void mo883a(int i) {
        if (i != 0) {
            throw new IllegalStateException("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file: " + this.f2843a.m5836i());
        }
        String i2 = this.f2843a.m5836i();
        File a = this.f2843a.m5828a();
        String b = this.f2843a.m5829b();
        for (File file : Arrays.asList(new File[]{new File(i2), new File(a, b + ".lock"), new File(a, b + ".log_a"), new File(a, b + ".log_b"), new File(a, b + ".log")})) {
            if (file.exists() && !file.delete()) {
                this.f2844b.set(false);
                C0462b.m5668b("Could not delete the file " + file);
            }
        }
    }
}
