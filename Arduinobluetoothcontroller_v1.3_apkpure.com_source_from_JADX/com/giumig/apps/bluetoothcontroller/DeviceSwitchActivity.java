package com.giumig.apps.bluetoothcontroller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.giumig.apps.bluetoothcontroller.p025d.C0396c;
import com.giumig.apps.bluetoothserialmonitor.R;
import io.realm.C0483m;
import io.realm.ae;

public class DeviceSwitchActivity extends C0374b {
    private ProgressBar f2548o;
    private ImageView f2549p;
    private C0483m f2550q;
    private C0396c f2551r;
    private boolean f2552s;
    private boolean f2553t = false;
    private OnClickListener f2554u = new ad(this);

    private void m5051A() {
        ae a = this.f2550q.m5799b(C0396c.class).m5396a();
        if (a.size() > 0) {
            this.f2551r = (C0396c) a.m5403a(0);
            Log.d("DeviceSwitchActivity", "retrieved switch profile with id '" + this.f2551r.m5319a() + "'");
        }
    }

    private void m5055b(String str) {
        Snackbar a = Snackbar.m453a(this.f2549p, "" + str, -2);
        a.m470a((CharSequence) "OK", new ab(this));
        a.m468a(Color.parseColor("#00FF00"));
        a.m471a();
    }

    private void m5058c(String str) {
        m5009a(str.getBytes());
    }

    private void m5062s() {
        this.f2548o = (ProgressBar) findViewById(R.id.connectionProgress);
        this.f2549p = (ImageView) findViewById(R.id.onOffSwitchImageView);
        this.f2549p.setOnClickListener(this.f2554u);
        m5067x();
    }

    private void m5063t() {
        this.f2548o.setVisibility(0);
        this.f2549p.setVisibility(8);
    }

    private void m5064u() {
        this.f2548o.setVisibility(8);
        this.f2549p.setVisibility(0);
    }

    private void m5065v() {
        startActivity(new Intent(this, SwitchProfileSettingsActivity.class));
    }

    private void m5066w() {
        Snackbar a = Snackbar.m453a(this.f2549p, getString(R.string.switch_mode_no_profiles_message), -2);
        a.m470a(getString(R.string.controller_mode_no_profiles_action), new ac(this));
        a.m468a(Color.parseColor("#00FF00"));
        a.m471a();
    }

    private void m5067x() {
        this.f2549p.setColorFilter(this.f2553t ? getResources().getColor(R.color.switch_on) : getResources().getColor(R.color.switch_off));
    }

    private boolean m5068y() {
        return (this.f2551r == null || TextUtils.isEmpty(this.f2551r.m5323c()) || TextUtils.isEmpty(this.f2551r.m5321b())) ? false : true;
    }

    private int m5069z() {
        return this.f2550q.m5802c(C0396c.class).size();
    }

    protected void mo818a(String str) {
    }

    protected void mo819n() {
        super.mo819n();
        m5055b(getString(R.string.bluetooth_disabled));
    }

    protected void mo820o() {
        m5055b(getString(R.string.device_disconnection));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_switch);
        m5062s();
        this.f2550q = C0483m.m5793l();
        m5063t();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.switch_onoff, menu);
        return true;
    }

    protected void onDestroy() {
        this.f2550q.close();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_switch_mapping:
                m5065v();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onResume() {
        super.onResume();
        if (m5069z() > 0) {
            m5051A();
            this.f2552s = m5068y();
            return;
        }
        Log.d("DeviceSwitchActivity", "no switch profile retrieved");
        this.f2552s = false;
    }

    protected void mo821p() {
        m5055b(getString(R.string.device_connection_failed));
        this.f2548o.setVisibility(8);
    }

    protected void mo822q() {
        m5055b(getString(R.string.device_connection_failed));
        this.f2548o.setVisibility(8);
    }

    protected void mo823r() {
        m5064u();
    }
}
