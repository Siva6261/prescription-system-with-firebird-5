package com.giumig.apps.bluetoothcontroller;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class C0419z implements OnSeekBarChangeListener {
    final /* synthetic */ DeviceDimmerActivity f2777a;

    C0419z(DeviceDimmerActivity deviceDimmerActivity) {
        this.f2777a = deviceDimmerActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f2777a.f2547q.setText("" + i);
        this.f2777a.m5041c("" + i);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
