package io.realm.internal.async;

import android.os.Process;

public class C0448c implements Runnable {
    private final Runnable f2906a;

    C0448c(Runnable runnable) {
        this.f2906a = runnable;
    }

    public void run() {
        Process.setThreadPriority(10);
        this.f2906a.run();
    }
}
