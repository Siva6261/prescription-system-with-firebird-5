package android.support.v4.p002f;

import android.os.AsyncTask;

class C0137b {
    static void m1458a(AsyncTask asyncTask, Object... objArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
    }
}
