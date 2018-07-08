package android.support.v4.p006b;

import android.app.Activity;
import android.content.pm.PackageManager;

final class C0072b implements Runnable {
    final /* synthetic */ String[] f682a;
    final /* synthetic */ Activity f683b;
    final /* synthetic */ int f684c;

    C0072b(String[] strArr, Activity activity, int i) {
        this.f682a = strArr;
        this.f683b = activity;
        this.f684c = i;
    }

    public void run() {
        int[] iArr = new int[this.f682a.length];
        PackageManager packageManager = this.f683b.getPackageManager();
        String packageName = this.f683b.getPackageName();
        int length = this.f682a.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.f682a[i], packageName);
        }
        ((C0070c) this.f683b).onRequestPermissionsResult(this.f684c, this.f682a, iArr);
    }
}
