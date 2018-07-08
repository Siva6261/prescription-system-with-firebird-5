package com.giumig.apps.bluetoothcontroller;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class C0405l implements OnEditorActionListener {
    final /* synthetic */ ControllerProfileSettingsActivity f2763a;

    C0405l(ControllerProfileSettingsActivity controllerProfileSettingsActivity) {
        this.f2763a = controllerProfileSettingsActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        String charSequence = textView.getText().toString();
        textView.setText("");
        this.f2763a.m4964a((View) textView);
        int id = textView.getId();
        this.f2763a.m4963a(id, false);
        if (id == this.f2763a.f2510v.getId()) {
            this.f2763a.m4969a(charSequence);
        } else if (id == this.f2763a.f2511w.getId()) {
            this.f2763a.m4973b(charSequence);
        } else if (id == this.f2763a.f2512x.getId()) {
            this.f2763a.m4976c(charSequence);
        } else if (id == this.f2763a.f2513y.getId()) {
            this.f2763a.m4979d(charSequence);
        } else if (id == this.f2763a.f2482D.getId()) {
            this.f2763a.m4985f(charSequence);
        } else if (id == this.f2763a.f2483E.getId()) {
            this.f2763a.m4988g(charSequence);
        } else if (id == this.f2763a.f2492N.getId()) {
            this.f2763a.m4982e(charSequence);
        } else if (id == this.f2763a.f2493O.getId()) {
            this.f2763a.m4991h(charSequence);
        } else if (id == this.f2763a.f2494P.getId()) {
            this.f2763a.m4994i(charSequence);
        } else if (id == this.f2763a.f2495Q.getId()) {
            this.f2763a.m4997j(charSequence);
        }
        return true;
    }
}
