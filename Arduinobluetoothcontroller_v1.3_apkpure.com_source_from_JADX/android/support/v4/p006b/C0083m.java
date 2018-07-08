package android.support.v4.p006b;

import android.app.AppOpsManager;
import android.content.Context;

class C0083m {
    public static int m1259a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }

    public static String m1260a(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
