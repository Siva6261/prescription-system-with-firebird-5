package com.giumig.apps.bluetoothcontroller;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.giumig.apps.bluetoothserialmonitor.R;

public class av extends DialogFragment {
    final /* synthetic */ MainActivity f2658a;
    private View f2659b;
    private TextView f2660c;
    private ImageView f2661d;
    private TextView f2662e;
    private ImageView f2663f;
    private TextView f2664g;
    private ImageView f2665h;
    private TextView f2666i;
    private ImageView f2667j;
    private TextView f2668k;
    private BluetoothDevice f2669l;
    private OnClickListener f2670m = new aw(this);
    private OnClickListener f2671n = new ax(this);
    private OnClickListener f2672o = new ay(this);
    private OnClickListener f2673p = new az(this);

    public av(MainActivity mainActivity) {
        this.f2658a = mainActivity;
    }

    private void m5194a() {
        this.f2660c = (TextView) this.f2659b.findViewById(R.id.messageText);
        bl.m5214a(this.f2662e, "Roboto-Bold.ttf");
        this.f2662e = (TextView) this.f2659b.findViewById(R.id.switchText);
        bl.m5214a(this.f2662e, "Roboto-Light.ttf");
        this.f2664g = (TextView) this.f2659b.findViewById(R.id.controllerText);
        bl.m5214a(this.f2664g, "Roboto-Light.ttf");
        this.f2666i = (TextView) this.f2659b.findViewById(R.id.dimmerText);
        bl.m5214a(this.f2666i, "Roboto-Light.ttf");
        this.f2668k = (TextView) this.f2659b.findViewById(R.id.terminalText);
        bl.m5214a(this.f2668k, "Roboto-Light.ttf");
        this.f2661d = (ImageView) this.f2659b.findViewById(R.id.switchImage);
        this.f2661d.startAnimation(this.f2658a.f2566F);
        this.f2661d.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        this.f2663f = (ImageView) this.f2659b.findViewById(R.id.controllerImage);
        this.f2663f.startAnimation(this.f2658a.f2566F);
        this.f2663f.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        this.f2665h = (ImageView) this.f2659b.findViewById(R.id.dimmerImage);
        this.f2665h.startAnimation(this.f2658a.f2566F);
        this.f2665h.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        this.f2667j = (ImageView) this.f2659b.findViewById(R.id.terminalImage);
        this.f2667j.startAnimation(this.f2658a.f2566F);
        this.f2667j.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        this.f2659b.findViewById(R.id.switchOnOff).setOnClickListener(this.f2673p);
        this.f2659b.findViewById(R.id.terminal).setOnClickListener(this.f2671n);
        this.f2659b.findViewById(R.id.dimmer).setOnClickListener(this.f2672o);
        this.f2659b.findViewById(R.id.controller).setOnClickListener(this.f2670m);
    }

    public void m5195a(BluetoothDevice bluetoothDevice) {
        this.f2669l = bluetoothDevice;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Builder builder = new Builder(getActivity());
        this.f2659b = getActivity().getLayoutInflater().inflate(R.layout.dialog_connection_mode, null);
        builder.setView(this.f2659b);
        m5194a();
        Dialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }
}
