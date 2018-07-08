package android.support.v4.p008c;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;

public class C0066a {
    public static int m957a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static final Drawable m958a(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C0095b.m1310a(context, i) : context.getResources().getDrawable(i);
    }

    public static boolean m959a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0097d.m1312a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0096c.m1311a(context, intentArr);
            return true;
        }
    }
}
