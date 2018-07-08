package com.giumig.apps.bluetoothcontroller;

import android.view.View;
import android.view.View.OnClickListener;
import com.giumig.apps.bluetoothserialmonitor.R;

class C0404k implements OnClickListener {
    final /* synthetic */ ControllerProfileSettingsActivity f2762a;

    C0404k(ControllerProfileSettingsActivity controllerProfileSettingsActivity) {
        this.f2762a = controllerProfileSettingsActivity;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.leftArrowConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2510v.getId(), true);
        } else if (id == R.id.upArrowConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2511w.getId(), true);
        } else if (id == R.id.rightArrowConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2512x.getId(), true);
        } else if (id == R.id.downArrowConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2513y.getId(), true);
        } else if (id == R.id.selectButtonConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2482D.getId(), true);
        } else if (id == R.id.startButtonConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2483E.getId(), true);
        } else if (id == R.id.leftButtonConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2492N.getId(), true);
        } else if (id == R.id.upButtonConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2493O.getId(), true);
        } else if (id == R.id.rightButtonConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2494P.getId(), true);
        } else if (id == R.id.downButtonConfiguration) {
            this.f2762a.m4963a(this.f2762a.f2495Q.getId(), true);
        }
    }
}
