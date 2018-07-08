package com.giumig.apps.bluetoothcontroller.controls;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class C0387a implements OnTouchListener {
    final /* synthetic */ ArrowButtonControl f2716a;

    C0387a(ArrowButtonControl arrowButtonControl) {
        this.f2716a = arrowButtonControl;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2716a.f2702a.setColorFilter(this.f2716a.f2706e);
            this.f2716a.f2703b.setColorFilter(this.f2716a.f2708g);
            return true;
        } else if (motionEvent.getAction() == 1) {
            this.f2716a.f2702a.setColorFilter(this.f2716a.f2705d);
            this.f2716a.f2703b.setColorFilter(this.f2716a.f2707f);
            this.f2716a.callOnClick();
            return true;
        } else {
            if (motionEvent.getAction() == 2) {
            }
            return false;
        }
    }
}
