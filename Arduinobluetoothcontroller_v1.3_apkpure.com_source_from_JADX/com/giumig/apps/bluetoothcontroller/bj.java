package com.giumig.apps.bluetoothcontroller;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class bj implements OnEditorActionListener {
    final /* synthetic */ SwitchProfileSettingsActivity f2699a;

    bj(SwitchProfileSettingsActivity switchProfileSettingsActivity) {
        this.f2699a = switchProfileSettingsActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        String charSequence = textView.getText().toString();
        textView.setText("");
        this.f2699a.m5155a((View) textView);
        int id = textView.getId();
        this.f2699a.m5154a(id, false);
        if (id == this.f2699a.f2612r.getId()) {
            this.f2699a.m5160a(charSequence);
        } else if (id == this.f2699a.f2613s.getId()) {
            this.f2699a.m5164b(charSequence);
        }
        return true;
    }
}
