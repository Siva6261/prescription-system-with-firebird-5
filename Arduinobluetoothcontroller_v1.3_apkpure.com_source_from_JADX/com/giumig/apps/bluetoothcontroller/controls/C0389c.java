package com.giumig.apps.bluetoothcontroller.controls;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class C0389c implements OnTouchListener {
    final /* synthetic */ ControllerButtonControl f2722a;

    C0389c(ControllerButtonControl controllerButtonControl) {
        this.f2722a = controllerButtonControl;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2722a.f2709a.setColorFilter(this.f2722a.f2713e);
            this.f2722a.f2710b.setColorFilter(this.f2722a.f2715g);
            return true;
        } else if (motionEvent.getAction() == 1) {
            this.f2722a.f2709a.setColorFilter(this.f2722a.f2712d);
            this.f2722a.f2710b.setColorFilter(this.f2722a.f2714f);
            this.f2722a.callOnClick();
            return true;
        } else {
            if (motionEvent.getAction() == 2) {
            }
            return false;
        }
    }
}
