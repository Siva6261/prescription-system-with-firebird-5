package com.giumig.apps.bluetoothcontroller;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.C0053r;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.dx;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.giumig.apps.bluetoothcontroller.p022a.C0375a;
import com.giumig.apps.bluetoothcontroller.p022a.C0378d;
import com.giumig.apps.bluetoothcontroller.p023c.C0382a;
import com.giumig.apps.bluetoothcontroller.p023c.C0383c;
import com.giumig.apps.bluetoothcontroller.p023c.C0384b;
import com.giumig.apps.bluetoothserialmonitor.R;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends C0373a {
    private FloatingActionButton f2561A;
    private Animation f2562B;
    private Animation f2563C;
    private Animation f2564D;
    private Animation f2565E;
    private Animation f2566F;
    private final BroadcastReceiver f2567G = new al(this);
    private final BroadcastReceiver f2568H = new am(this);
    private final BroadcastReceiver f2569I = new an(this);
    private C0382a f2570J = new ao(this);
    private C0383c f2571K = new ap(this);
    private C0384b f2572L = new aq(this);
    private BluetoothAdapter f2573m;
    private ArrayList f2574n = new ArrayList();
    private ArrayList f2575o = new ArrayList();
    private AppBarLayout f2576p;
    private CollapsingToolbarLayout f2577q;
    private Toolbar f2578r;
    private NestedScrollView f2579s;
    private TextView f2580t;
    private RecyclerView f2581u;
    private View f2582v;
    private TextView f2583w;
    private RecyclerView f2584x;
    private ProgressBar f2585y;
    private ProgressDialog f2586z;

    private void m5091a(BluetoothDevice bluetoothDevice) {
        this.f2573m.cancelDiscovery();
        Log.d("MainActivity", "going to pair with '" + bluetoothDevice.getAddress() + "'");
        if (VERSION.SDK_INT >= 19) {
            bluetoothDevice.createBond();
            return;
        }
        try {
            bluetoothDevice.getClass().getMethod("createBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m5095b(BluetoothDevice bluetoothDevice) {
        av avVar = new av(this);
        avVar.show(getFragmentManager(), "ConnectionModeDialogFragment");
        avVar.m5195a(bluetoothDevice);
    }

    private void m5098c(BluetoothDevice bluetoothDevice) {
        ba baVar = new ba(this);
        baVar.show(getFragmentManager(), "UnpairDeviceDialogFragment");
        baVar.m5202a(bluetoothDevice);
    }

    private void m5101d(BluetoothDevice bluetoothDevice) {
        try {
            bluetoothDevice.getClass().getMethod("removeBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null);
            this.f2574n.remove(bluetoothDevice);
            this.f2581u.getAdapter().m4492c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m5104e(BluetoothDevice bluetoothDevice) {
        MyApplication.m5137a().m5138a(bluetoothDevice);
        startActivity(new Intent(this, DeviceTerminalActivity.class));
    }

    private void m5107f(BluetoothDevice bluetoothDevice) {
        MyApplication.m5137a().m5138a(bluetoothDevice);
        startActivity(new Intent(this, DeviceControllerActivity.class));
    }

    private void m5109g(BluetoothDevice bluetoothDevice) {
        MyApplication.m5137a().m5138a(bluetoothDevice);
        startActivity(new Intent(this, DeviceSwitchActivity.class));
    }

    private void m5112h(BluetoothDevice bluetoothDevice) {
        MyApplication.m5137a().m5138a(bluetoothDevice);
        startActivity(new Intent(this, DeviceDimmerActivity.class));
    }

    private void m5121n() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 69);
    }

    private void m5122o() {
        this.f2576p = (AppBarLayout) findViewById(R.id.appbar);
        this.f2577q = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        this.f2577q.setExpandedTitleColor(getResources().getColor(17170445));
        this.f2578r = (Toolbar) findViewById(R.id.toolbar);
        m3219a(this.f2578r);
    }

    private void m5124p() {
        this.f2579s = (NestedScrollView) findViewById(R.id.mainScrollview);
        this.f2585y = (ProgressBar) findViewById(R.id.devicesScanProgress);
        this.f2580t = (TextView) findViewById(R.id.pairedDevicesTextView);
        this.f2582v = findViewById(R.id.pairedSeparator);
        this.f2583w = (TextView) findViewById(R.id.availableDevicesTextView);
        bl.m5214a(this.f2580t, "Roboto-Regular.ttf");
        bl.m5214a(this.f2583w, "Roboto-Light.ttf");
        this.f2561A = (FloatingActionButton) findViewById(R.id.bt_scan_fab);
        this.f2561A.setOnClickListener(new ah(this));
        this.f2566F = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dialog_fab_open);
        this.f2562B = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        this.f2563C = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        this.f2564D = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        this.f2565E = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
        this.f2584x = (RecyclerView) findViewById(R.id.availableDevicesRecyclerView);
        this.f2584x.setLayoutManager(new LinearLayoutManager(this));
        this.f2584x.setNestedScrollingEnabled(false);
        this.f2581u = (RecyclerView) findViewById(R.id.pairedDevicesRecyclerView);
        this.f2581u.setLayoutManager(new LinearLayoutManager(this));
        this.f2581u.setNestedScrollingEnabled(false);
        this.f2586z = new ProgressDialog(this);
    }

    private void m5127q() {
        Builder builder = new Builder(this);
        builder.setMessage(getString(R.string.bluetooth_unsupported));
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new aj(this));
        builder.create().show();
    }

    private void m5128r() {
        Builder builder = new Builder(this);
        builder.setMessage(getString(R.string.bluetooth_disabled));
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new ak(this));
        builder.create().show();
    }

    private void m5129s() {
        if (!this.f2573m.isEnabled()) {
            m5121n();
        } else if (!this.f2573m.isDiscovering()) {
            this.f2573m.startDiscovery();
        }
    }

    private void m5130t() {
        Set<BluetoothDevice> bondedDevices = this.f2573m.getBondedDevices();
        if (bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                Log.d("MainActivity", "paired device: " + bluetoothDevice.getName() + ", " + bluetoothDevice.getAddress());
                if (!this.f2574n.contains(bluetoothDevice)) {
                    this.f2574n.add(bluetoothDevice);
                }
                m5133w();
            }
            return;
        }
        m5134x();
    }

    private void m5131u() {
        this.f2585y.setVisibility(0);
    }

    private void m5132v() {
        this.f2585y.setVisibility(8);
    }

    private void m5133w() {
        this.f2580t.setVisibility(0);
        this.f2582v.setVisibility(0);
        this.f2581u.setVisibility(0);
        this.f2581u.getAdapter().m4492c();
    }

    private void m5134x() {
        this.f2580t.setVisibility(8);
        this.f2581u.setVisibility(8);
        this.f2582v.setVisibility(8);
    }

    private void m5135y() {
        dx c0378d = new C0378d(this.f2574n);
        c0378d.m5182a(this.f2571K);
        c0378d.m5181a(this.f2572L);
        this.f2581u.setAdapter(c0378d);
    }

    private void m5136z() {
        dx c0375a = new C0375a(this.f2575o);
        c0375a.m5173a(this.f2570J);
        this.f2584x.setAdapter(c0375a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 69) {
            return;
        }
        if (i2 == -1) {
            m5130t();
            m5129s();
            return;
        }
        m5128r();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f2576p != null && !MyApplication.m5137a().m5142e()) {
            this.f2576p.m335a(configuration.orientation != 2, true);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        m5122o();
        m5124p();
        this.f2573m = BluetoothAdapter.getDefaultAdapter();
        if (this.f2573m == null) {
            m5127q();
            return;
        }
        m5135y();
        m5136z();
        if (!MyApplication.m5137a().m5142e() && getResources().getConfiguration().orientation == 2) {
            this.f2576p.m335a(false, true);
        }
        if (!this.f2573m.isEnabled()) {
            m5121n();
        }
        m4959k();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    protected void onDestroy() {
        if (this.f2573m != null) {
            this.f2573m.cancelDiscovery();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.bluetooth_scan:
                m5129s();
                return true;
            case R.id.about:
                C0053r arVar = new ar(this);
                arVar.m894a(m981f(), arVar.m867h());
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.f2573m != null) {
            this.f2573m.cancelDiscovery();
        }
        unregisterReceiver(this.f2568H);
        unregisterReceiver(this.f2567G);
    }

    protected void onResume() {
        super.onResume();
        registerReceiver(this.f2567G, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        registerReceiver(this.f2568H, intentFilter);
        this.f2561A.startAnimation(this.f2562B);
        if (this.f2573m == null) {
            return;
        }
        if (this.f2573m.isEnabled()) {
            m5130t();
            m5129s();
            return;
        }
        m5132v();
    }

    protected void onStart() {
        super.onStart();
        registerReceiver(this.f2569I, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
    }

    protected void onStop() {
        super.onStop();
        unregisterReceiver(this.f2569I);
    }
}
