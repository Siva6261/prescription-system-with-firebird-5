package android.support.v4.p006b;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class bp {
    public static Intent m1233a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static String m1234a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }

    public static boolean m1235a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m1236b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }
}
