package android.support.v4.p006b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.p008c.C0098e;

public final class bl {
    private static final bm f729a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f729a = new bo();
        } else {
            f729a = new bn();
        }
    }

    public static Intent m1214a(Activity activity) {
        return f729a.mo196a(activity);
    }

    public static Intent m1215a(Context context, ComponentName componentName) {
        String b = bl.m1218b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return bl.m1218b(context, componentName2) == null ? C0098e.m1313a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static boolean m1216a(Activity activity, Intent intent) {
        return f729a.mo198a(activity, intent);
    }

    public static String m1217b(Activity activity) {
        try {
            return bl.m1218b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m1218b(Context context, ComponentName componentName) {
        return f729a.mo197a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void m1219b(Activity activity, Intent intent) {
        f729a.mo199b(activity, intent);
    }
}
