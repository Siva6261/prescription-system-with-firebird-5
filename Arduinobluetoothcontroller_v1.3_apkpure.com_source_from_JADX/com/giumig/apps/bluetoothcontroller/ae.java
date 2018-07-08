package com.giumig.apps.bluetoothcontroller;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ae implements OnEditorActionListener {
    final /* synthetic */ DeviceTerminalActivity f2642a;

    ae(DeviceTerminalActivity deviceTerminalActivity) {
        this.f2642a = deviceTerminalActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        switch (i & 255) {
            case 6:
                this.f2642a.m5083v();
                break;
        }
        return true;
    }
}
