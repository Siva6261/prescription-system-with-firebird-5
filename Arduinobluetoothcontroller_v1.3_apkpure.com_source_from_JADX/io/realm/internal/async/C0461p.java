package io.realm.internal.async;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class C0461p extends ThreadPoolExecutor {
    private static final int f2928a = ((Runtime.getRuntime().availableProcessors() * 2) + 1);
    private boolean f2929b;
    private ReentrantLock f2930c = new ReentrantLock();
    private Condition f2931d = this.f2930c.newCondition();

    private C0461p(int i, int i2) {
        super(i, i2, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
    }

    public static C0461p m5664a() {
        return new C0461p(f2928a, f2928a);
    }

    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.f2930c.lock();
        while (this.f2929b) {
            try {
                this.f2931d.await();
            } catch (InterruptedException e) {
                thread.interrupt();
            } finally {
                this.f2930c.unlock();
            }
        }
    }

    public Future submit(Runnable runnable) {
        return super.submit(new C0448c(runnable));
    }

    public Future submit(Callable callable) {
        return super.submit(new C0447b(callable));
    }
}
