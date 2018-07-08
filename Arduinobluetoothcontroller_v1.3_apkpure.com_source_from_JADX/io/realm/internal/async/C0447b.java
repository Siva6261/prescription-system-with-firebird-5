package io.realm.internal.async;

import android.os.Process;
import java.util.concurrent.Callable;

public class C0447b implements Callable {
    private final Callable f2905a;

    C0447b(Callable callable) {
        this.f2905a = callable;
    }

    public Object call() {
        Process.setThreadPriority(10);
        return this.f2905a.call();
    }
}
