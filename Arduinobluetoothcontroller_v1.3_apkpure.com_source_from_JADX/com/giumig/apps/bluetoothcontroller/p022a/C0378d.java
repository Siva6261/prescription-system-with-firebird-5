package com.giumig.apps.bluetoothcontroller.p022a;

import android.bluetooth.BluetoothDevice;
import android.support.v7.widget.dx;
import android.support.v7.widget.ey;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.giumig.apps.bluetoothcontroller.C0403j;
import com.giumig.apps.bluetoothcontroller.MyApplication;
import com.giumig.apps.bluetoothcontroller.bl;
import com.giumig.apps.bluetoothcontroller.p023c.C0383c;
import com.giumig.apps.bluetoothcontroller.p023c.C0384b;
import com.giumig.apps.bluetoothserialmonitor.R;
import java.util.ArrayList;

public class C0378d extends dx {
    private ArrayList f2627a;
    private C0383c f2628b;
    private C0384b f2629c;

    public C0378d(ArrayList arrayList) {
        this.f2627a = arrayList;
    }

    public int mo826a() {
        return this.f2627a.size();
    }

    public /* synthetic */ ey mo827a(ViewGroup viewGroup, int i) {
        return m5183c(viewGroup, i);
    }

    public void m5180a(C0381g c0381g, int i) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) this.f2627a.get(i);
        c0381g.f2635m.setText(bluetoothDevice.getName());
        c0381g.f2636n.setText(MyApplication.m5137a().getString(R.string.device_not_connected));
        if (C0403j.m5337a(bluetoothDevice.getBluetoothClass())) {
            c0381g.f2637o.setImageDrawable(MyApplication.m5137a().getResources().getDrawable(R.drawable.ic_phone_android_black_24dp));
        } else if (C0403j.m5338b(bluetoothDevice.getBluetoothClass())) {
            c0381g.f2637o.setImageDrawable(MyApplication.m5137a().getResources().getDrawable(R.drawable.ic_laptop_black_24dp));
        }
        c0381g.f2634l.setOnClickListener(new C0379e(this, bluetoothDevice));
        c0381g.f2634l.setOnLongClickListener(new C0380f(this, bluetoothDevice));
    }

    public void m5181a(C0384b c0384b) {
        this.f2629c = c0384b;
    }

    public void m5182a(C0383c c0383c) {
        this.f2628b = c0383c;
    }

    public C0381g m5183c(ViewGroup viewGroup, int i) {
        C0381g c0381g = new C0381g(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_paired_device, viewGroup, false));
        c0381g.f2637o.setColorFilter(MyApplication.m5137a().getResources().getColor(R.color.arduinoOrange1));
        bl.m5214a(c0381g.f2635m, "Roboto-Regular.ttf");
        bl.m5214a(c0381g.f2636n, "Roboto-Light.ttf");
        return c0381g;
    }
}
