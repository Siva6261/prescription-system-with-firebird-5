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
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.giumig.apps.bluetoothcontroller.controls.ArrowButtonControl;
import com.giumig.apps.bluetoothcontroller.controls.C0388b;
import com.giumig.apps.bluetoothcontroller.controls.C0390d;
import com.giumig.apps.bluetoothcontroller.controls.ControllerButtonControl;
import com.giumig.apps.bluetoothcontroller.p025d.C0393a;
import com.giumig.apps.bluetoothserialmonitor.R;
import io.realm.C0483m;
import io.realm.ae;

public class DeviceControllerActivity extends C0374b {
    private ControllerButtonControl f2520A;
    private Button f2521B;
    private Button f2522C;
    private OnClickListener f2523D = new C0412s(this);
    private OnClickListener f2524E = new C0413t(this);
    private OnClickListener f2525F = new C0414u(this);
    private OnClickListener f2526G = new C0415v(this);
    private OnClickListener f2527H = new C0416w(this);
    private OnClickListener f2528I = new C0417x(this);
    private OnClickListener f2529J = new C0418y(this);
    private OnClickListener f2530K = new C0408o(this);
    private OnClickListener f2531L = new C0409p(this);
    private OnClickListener f2532M = new C0410q(this);
    private ProgressBar f2533o;
    private RelativeLayout f2534p;
    private C0483m f2535q;
    private C0393a f2536r;
    private boolean f2537s;
    private ArrowButtonControl f2538t;
    private ArrowButtonControl f2539u;
    private ArrowButtonControl f2540v;
    private ArrowButtonControl f2541w;
    private ControllerButtonControl f2542x;
    private ControllerButtonControl f2543y;
    private ControllerButtonControl f2544z;

    private void m5015A() {
        ae a = this.f2535q.m5799b(C0393a.class).m5395a("currentlyUsed", Boolean.valueOf(true)).m5396a();
        if (a.size() > 0) {
            this.f2536r = (C0393a) a.m5403a(0);
            Log.d("ControllerActivity", "retrieved controller profile with id '" + this.f2536r.m5259a() + "'");
        }
    }

    private boolean m5016B() {
        return (this.f2536r == null || (TextUtils.isEmpty(this.f2536r.m5262b()) && TextUtils.isEmpty(this.f2536r.m5267d()) && TextUtils.isEmpty(this.f2536r.m5265c()) && TextUtils.isEmpty(this.f2536r.m5269e()) && TextUtils.isEmpty(this.f2536r.m5271f()) && TextUtils.isEmpty(this.f2536r.m5273g()) && TextUtils.isEmpty(this.f2536r.m5275h()) && TextUtils.isEmpty(this.f2536r.m5279j()) && TextUtils.isEmpty(this.f2536r.m5277i()) && TextUtils.isEmpty(this.f2536r.m5281k()))) ? false : true;
    }

    private void m5019b(String str) {
        Snackbar a = Snackbar.m453a(this.f2534p, "" + str, -2);
        a.m470a((CharSequence) "OK", new C0407n(this));
        a.m468a(Color.parseColor("#00FF00"));
        a.m471a();
    }

    private void m5022c(String str) {
        m5009a(str.getBytes());
    }

    private void m5024s() {
        this.f2533o = (ProgressBar) findViewById(R.id.connectionProgress);
        this.f2534p = (RelativeLayout) findViewById(R.id.connectionContent);
        m5025t();
    }

    private void m5025t() {
        this.f2539u = (ArrowButtonControl) findViewById(R.id.controller_arrowBottom);
        this.f2538t = (ArrowButtonControl) findViewById(R.id.controller_arrowTop);
        this.f2540v = (ArrowButtonControl) findViewById(R.id.controller_arrowLeft);
        this.f2541w = (ArrowButtonControl) findViewById(R.id.controller_arrowRight);
        this.f2539u.setSymbol(C0388b.BOTTOM);
        this.f2538t.setSymbol(C0388b.TOP);
        this.f2540v.setSymbol(C0388b.LEFT);
        this.f2541w.setSymbol(C0388b.RIGHT);
        this.f2539u.setBackgroundColor(getResources().getColor(R.color.joystick_darker_background));
        this.f2539u.setBackgroundPressedColor(getResources().getColor(R.color.joystick_darker_pressed_background));
        this.f2539u.setForegroundColor(getResources().getColor(R.color.black));
        this.f2539u.setForegroundPressedColor(getResources().getColor(R.color.white));
        this.f2538t.setBackgroundColor(getResources().getColor(R.color.joystick_darker_background));
        this.f2538t.setBackgroundPressedColor(getResources().getColor(R.color.joystick_darker_pressed_background));
        this.f2538t.setForegroundColor(getResources().getColor(R.color.black));
        this.f2538t.setForegroundPressedColor(getResources().getColor(R.color.white));
        this.f2540v.setBackgroundColor(getResources().getColor(R.color.joystick_darker_background));
        this.f2540v.setBackgroundPressedColor(getResources().getColor(R.color.joystick_darker_pressed_background));
        this.f2540v.setForegroundColor(getResources().getColor(R.color.black));
        this.f2540v.setForegroundPressedColor(getResources().getColor(R.color.white));
        this.f2541w.setBackgroundColor(getResources().getColor(R.color.joystick_darker_background));
        this.f2541w.setBackgroundPressedColor(getResources().getColor(R.color.joystick_darker_pressed_background));
        this.f2541w.setForegroundColor(getResources().getColor(R.color.black));
        this.f2541w.setForegroundPressedColor(getResources().getColor(R.color.white));
        this.f2521B = (Button) findViewById(R.id.centerButton1);
        this.f2522C = (Button) findViewById(R.id.centerButton2);
        this.f2543y = (ControllerButtonControl) findViewById(R.id.controller_buttonBottom);
        this.f2542x = (ControllerButtonControl) findViewById(R.id.controller_buttonTop);
        this.f2544z = (ControllerButtonControl) findViewById(R.id.controller_buttonLeft);
        this.f2520A = (ControllerButtonControl) findViewById(R.id.controller_buttonRight);
        this.f2543y.setSymbol(C0390d.BOTTOM);
        this.f2542x.setSymbol(C0390d.TOP);
        this.f2544z.setSymbol(C0390d.LEFT);
        this.f2520A.setSymbol(C0390d.RIGHT);
        this.f2543y.setBackgroundColor(getResources().getColor(R.color.joystick_background));
        this.f2543y.setBackgroundPressedColor(getResources().getColor(R.color.joystick_pressed_background));
        this.f2543y.setForegroundColor(getResources().getColor(R.color.arduinoGray1));
        this.f2543y.setForegroundPressedColor(getResources().getColor(R.color.white));
        this.f2542x.setBackgroundColor(getResources().getColor(R.color.joystick_background));
        this.f2542x.setBackgroundPressedColor(getResources().getColor(R.color.joystick_pressed_background));
        this.f2542x.setForegroundColor(getResources().getColor(R.color.arduinoBrown1));
        this.f2542x.setForegroundPressedColor(getResources().getColor(R.color.white));
        this.f2544z.setBackgroundColor(getResources().getColor(R.color.joystick_background));
        this.f2544z.setBackgroundPressedColor(getResources().getColor(R.color.joystick_pressed_background));
        this.f2544z.setForegroundColor(getResources().getColor(R.color.arduinoOrange2));
        this.f2544z.setForegroundPressedColor(getResources().getColor(R.color.white));
        this.f2520A.setBackgroundColor(getResources().getColor(R.color.joystick_background));
        this.f2520A.setBackgroundPressedColor(getResources().getColor(R.color.joystick_pressed_background));
        this.f2520A.setForegroundColor(getResources().getColor(R.color.arduinoYellow1));
        this.f2520A.setForegroundPressedColor(getResources().getColor(R.color.white));
        this.f2539u.setOnClickListener(this.f2525F);
        this.f2538t.setOnClickListener(this.f2526G);
        this.f2540v.setOnClickListener(this.f2523D);
        this.f2541w.setOnClickListener(this.f2524E);
        this.f2543y.setOnClickListener(this.f2530K);
        this.f2542x.setOnClickListener(this.f2529J);
        this.f2544z.setOnClickListener(this.f2527H);
        this.f2520A.setOnClickListener(this.f2528I);
        this.f2521B.setOnClickListener(this.f2531L);
        this.f2522C.setOnClickListener(this.f2532M);
    }

    private void m5026u() {
        this.f2533o.setVisibility(0);
        this.f2534p.setVisibility(8);
    }

    private void m5027v() {
        this.f2533o.setVisibility(8);
        this.f2534p.setVisibility(0);
    }

    private void m5028w() {
        Snackbar a = Snackbar.m453a(this.f2534p, getString(R.string.controller_mode_no_profiles_message), -2);
        a.m470a(getString(R.string.controller_mode_no_profiles_action), new C0411r(this));
        a.m468a(Color.parseColor("#00FF00"));
        a.m471a();
    }

    private void m5029x() {
        startActivity(new Intent(this, ControllerProfileSettingsActivity.class));
    }

    private void m5030y() {
    }

    private int m5031z() {
        return this.f2535q.m5802c(C0393a.class).size();
    }

    protected void mo818a(String str) {
    }

    protected void mo819n() {
        super.mo819n();
        m5019b(getString(R.string.bluetooth_disabled));
    }

    protected void mo820o() {
        super.mo820o();
        m5019b(getString(R.string.device_disconnection));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_controller);
        if (!MyApplication.m5137a().m5142e()) {
            setRequestedOrientation(0);
        }
        m5024s();
        this.f2535q = C0483m.m5793l();
        m5026u();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.controller, menu);
        return true;
    }

    protected void onDestroy() {
        this.f2535q.close();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_controller_mapping:
                m5029x();
                return true;
            case R.id.action_controller_load_profile:
                m5030y();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean z = true;
        MenuItem findItem = menu.findItem(R.id.action_controller_load_profile);
        if (m5031z() <= 1) {
            z = false;
        }
        findItem.setVisible(z);
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onResume() {
        super.onResume();
        if (m5031z() > 0) {
            m5015A();
            this.f2537s = m5016B();
            return;
        }
        Log.d("ControllerActivity", "no controller profile retrieved");
        this.f2537s = false;
    }

    protected void mo821p() {
        m5019b(getString(R.string.device_connection_failed));
        this.f2533o.setVisibility(8);
    }

    protected void mo822q() {
        m5019b(getString(R.string.device_connection_failed));
        this.f2533o.setVisibility(8);
    }

    protected void mo823r() {
        m5027v();
    }
}
