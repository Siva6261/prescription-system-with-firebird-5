package com.giumig.apps.bluetoothcontroller;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.giumig.apps.bluetoothserialmonitor.R;

public class DeviceDimmerActivity extends C0374b {
    private ProgressBar f2545o;
    private AppCompatSeekBar f2546p;
    private TextView f2547q;

    private void m5040b(String str) {
        Snackbar a = Snackbar.m453a(this.f2546p, "" + str, -2);
        a.m470a((CharSequence) "OK", new aa(this));
        a.m468a(Color.parseColor("#00FF00"));
        a.m471a();
    }

    private void m5041c(String str) {
        m5009a(str.getBytes());
    }

    private void m5042s() {
        this.f2545o = (ProgressBar) findViewById(R.id.connectionProgress);
        this.f2547q = (TextView) findViewById(R.id.dimmerValue);
        bl.m5214a(this.f2547q, "Roboto-Light.ttf");
        this.f2546p = (AppCompatSeekBar) findViewById(R.id.dimmerSeekbar);
        this.f2546p.setOnSeekBarChangeListener(new C0419z(this));
    }

    private void m5043t() {
        this.f2545o.setVisibility(0);
        this.f2546p.setVisibility(8);
        this.f2547q.setVisibility(8);
    }

    private void m5044u() {
        this.f2545o.setVisibility(8);
        this.f2546p.setVisibility(0);
        this.f2547q.setVisibility(0);
    }

    protected void mo818a(String str) {
    }

    protected void mo819n() {
        super.mo819n();
        m5040b(getString(R.string.bluetooth_disabled));
    }

    protected void mo820o() {
        m5040b(getString(R.string.device_disconnection));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_dimmer);
        m5042s();
        m5043t();
    }

    protected void mo821p() {
        m5040b(getString(R.string.device_connection_failed));
        this.f2545o.setVisibility(8);
    }

    protected void mo822q() {
        m5040b(getString(R.string.device_connection_failed));
        this.f2545o.setVisibility(8);
    }

    protected void mo823r() {
        m5044u();
    }
}
