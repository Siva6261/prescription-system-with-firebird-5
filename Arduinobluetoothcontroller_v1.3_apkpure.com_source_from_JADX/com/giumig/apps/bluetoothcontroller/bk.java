package com.giumig.apps.bluetoothcontroller;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class bk implements OnFocusChangeListener {
    final /* synthetic */ SwitchProfileSettingsActivity f2700a;

    bk(SwitchProfileSettingsActivity switchProfileSettingsActivity) {
        this.f2700a = switchProfileSettingsActivity;
    }

    public void onFocusChange(View view, boolean z) {
        this.f2700a.m5154a(view.getId(), z);
    }
}
