package com.giumig.apps.bluetoothcontroller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.p006b.C0067a;
import android.support.v4.p008c.C0066a;
import android.support.v7.p005a.C0296u;
import android.util.Log;

public class C0373a extends C0296u {
    private static String f2476m;
    private final int f2477n = 99;
    private boolean f2478o;

    protected void m4959k() {
        int a = C0066a.m957a((Context) this, "android.permission.ACCESS_COARSE_LOCATION");
        if (a == 0) {
            m4961m();
        } else if (a == -1) {
            m4960l();
        }
    }

    public void m4960l() {
        Log.d(f2476m, "PERMISSION_DENIED");
        C0067a.m962a(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 99);
    }

    public void m4961m() {
        Log.d(f2476m, "PERMISSION_GRANTED");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f2476m = getClass().getSimpleName();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Log.d(f2476m, "onRequestPermissionsResult");
        switch (i) {
            case 99:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    Log.d(f2476m, "permission denied, boo!");
                    this.f2478o = true;
                    return;
                }
                Log.d(f2476m, "permission was granted, yay!");
                this.f2478o = false;
                return;
            default:
                return;
        }
    }

    protected void onResume() {
        super.onResume();
        Log.d(f2476m, "onResume");
    }
}
