package com.giumig.apps.bluetoothcontroller;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class C0406m implements OnFocusChangeListener {
    final /* synthetic */ ControllerProfileSettingsActivity f2764a;

    C0406m(ControllerProfileSettingsActivity controllerProfileSettingsActivity) {
        this.f2764a = controllerProfileSettingsActivity;
    }

    public void onFocusChange(View view, boolean z) {
        this.f2764a.m4963a(view.getId(), z);
    }
}
