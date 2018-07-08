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

public class ba extends DialogFragment {
    final /* synthetic */ MainActivity f2683a;
    private View f2684b;
    private ImageView f2685c;
    private TextView f2686d;
    private BluetoothDevice f2687e;
    private OnClickListener f2688f = new bb(this);

    public ba(MainActivity mainActivity) {
        this.f2683a = mainActivity;
    }

    private void m5201a() {
        this.f2686d = (TextView) this.f2684b.findViewById(R.id.unpairText);
        bl.m5214a(this.f2686d, "Roboto-Light.ttf");
        this.f2685c = (ImageView) this.f2684b.findViewById(R.id.unpairImage);
        this.f2685c.startAnimation(this.f2683a.f2566F);
        this.f2685c.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        this.f2684b.findViewById(R.id.unpair).setOnClickListener(this.f2688f);
    }

    public void m5202a(BluetoothDevice bluetoothDevice) {
        this.f2687e = bluetoothDevice;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Builder builder = new Builder(getActivity());
        this.f2684b = getActivity().getLayoutInflater().inflate(R.layout.dialog_unpair_device, null);
        builder.setView(this.f2684b);
        m5201a();
        Dialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }
}
