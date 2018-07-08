package android.support.v4.p008c;

import android.content.Context;
import android.os.Process;
import android.support.v4.p006b.C0079i;

public final class C0105n {
    public static int m1330a(Context context, String str) {
        return C0105n.m1331a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int m1331a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0079i.m1254a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0079i.m1253a(context, a, str2) != 0 ? -2 : 0;
    }
}
