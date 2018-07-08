package android.support.v4.p006b;

import android.app.Activity;

class C0076e {
    public static void m1249a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C0071f) {
            ((C0071f) activity).mo162a(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
