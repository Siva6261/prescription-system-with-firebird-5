package android.support.v4.p006b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

class C0078h {
    public static void m1251a(Activity activity) {
        activity.finishAffinity();
    }

    public static void m1252a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }
}
