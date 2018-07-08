package android.support.v4.p002f;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public final class C0136a {
    public static AsyncTask m1457a(AsyncTask asyncTask, Object... objArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0137b.m1458a(asyncTask, objArr);
        } else {
            asyncTask.execute(objArr);
        }
        return asyncTask;
    }
}
