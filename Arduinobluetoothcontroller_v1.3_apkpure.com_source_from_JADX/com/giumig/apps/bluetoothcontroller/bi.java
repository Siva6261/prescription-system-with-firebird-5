package com.giumig.apps.bluetoothcontroller;

import android.view.View;
import android.view.View.OnClickListener;
import com.giumig.apps.bluetoothserialmonitor.R;

class bi implements OnClickListener {
    final /* synthetic */ SwitchProfileSettingsActivity f2698a;

    bi(SwitchProfileSettingsActivity switchProfileSettingsActivity) {
        this.f2698a = switchProfileSettingsActivity;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.onConfiguration) {
            this.f2698a.m5154a(this.f2698a.f2612r.getId(), true);
        } else if (id == R.id.offConfiguration) {
            this.f2698a.m5154a(this.f2698a.f2613s.getId(), true);
        }
    }
}
