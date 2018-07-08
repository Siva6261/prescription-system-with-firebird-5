package android.support.v4.p006b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class bo extends bn {
    bo() {
    }

    public Intent mo196a(Activity activity) {
        Intent a = bp.m1233a(activity);
        return a == null ? m1231b(activity) : a;
    }

    public String mo197a(Context context, ActivityInfo activityInfo) {
        String a = bp.m1234a(activityInfo);
        return a == null ? super.mo197a(context, activityInfo) : a;
    }

    public boolean mo198a(Activity activity, Intent intent) {
        return bp.m1235a(activity, intent);
    }

    Intent m1231b(Activity activity) {
        return super.mo196a(activity);
    }

    public void mo199b(Activity activity, Intent intent) {
        bp.m1236b(activity, intent);
    }
}
