package android.support.v4.p006b;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p008c.C0066a;

public class C0067a extends C0066a {
    public static void m960a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0078h.m1251a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m961a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0078h.m1252a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m962a(Activity activity, String[] strArr, int i) {
        if (VERSION.SDK_INT >= 23) {
            C0076e.m1249a(activity, strArr, i);
        } else if (activity instanceof C0070c) {
            new Handler(Looper.getMainLooper()).post(new C0072b(strArr, activity, i));
        }
    }

    public static void m963b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0075d.m1248a(activity);
        } else {
            activity.finish();
        }
    }
}
