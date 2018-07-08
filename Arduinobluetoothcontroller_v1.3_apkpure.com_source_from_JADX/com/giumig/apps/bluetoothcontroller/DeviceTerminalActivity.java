package com.giumig.apps.bluetoothcontroller;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.giumig.apps.bluetoothserialmonitor.R;

public class DeviceTerminalActivity extends C0374b {
    private ProgressBar f2555o;
    private RelativeLayout f2556p;
    private ScrollView f2557q;
    private EditText f2558r;
    private TextView f2559s;
    private OnEditorActionListener f2560t = new ae(this);

    private synchronized void m5078b(String str) {
        if (this.f2559s.getLineCount() == 100) {
            this.f2559s.setText("");
        }
        this.f2559s.append(str);
        m5084w();
    }

    private void m5079c(String str) {
        Snackbar a = Snackbar.m453a(this.f2556p, "" + str, -2);
        a.m470a((CharSequence) "OK", new ag(this));
        a.m471a();
    }

    private void m5080s() {
        this.f2555o = (ProgressBar) findViewById(R.id.connectionProgress);
        this.f2556p = (RelativeLayout) findViewById(R.id.connectionContent);
        this.f2557q = (ScrollView) findViewById(R.id.consoleScrollView);
        this.f2559s = (TextView) findViewById(R.id.consoleTextView);
        this.f2558r = (EditText) findViewById(R.id.consoleEditText);
        this.f2558r.setOnEditorActionListener(this.f2560t);
        bl.m5214a(this.f2559s, "Roboto-Light.ttf");
        bl.m5214a(this.f2558r, "Roboto-Regular.ttf");
    }

    private void m5081t() {
        this.f2555o.setVisibility(0);
        this.f2556p.setVisibility(8);
    }

    private void m5082u() {
        this.f2555o.setVisibility(8);
        this.f2556p.setVisibility(0);
    }

    private void m5083v() {
        String obj = this.f2558r.getText().toString();
        m5078b("\n> " + obj);
        this.f2558r.setText("");
        m5009a(obj.getBytes());
    }

    private void m5084w() {
        this.f2557q.post(new af(this));
    }

    protected void mo818a(String str) {
        m5078b("\n" + this.n.getName() + ": " + str);
    }

    protected void mo819n() {
        super.mo819n();
        m5079c(getString(R.string.bluetooth_disabled));
    }

    protected void mo820o() {
        super.mo820o();
        m5079c(getString(R.string.device_disconnection));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_terminal);
        m5080s();
        m5081t();
    }

    protected void mo821p() {
        m5079c(getString(R.string.device_connection_failed));
        this.f2555o.setVisibility(8);
    }

    protected void mo822q() {
        m5079c(getString(R.string.device_connection_failed));
        this.f2555o.setVisibility(8);
    }

    protected void mo823r() {
        m5082u();
    }
}
