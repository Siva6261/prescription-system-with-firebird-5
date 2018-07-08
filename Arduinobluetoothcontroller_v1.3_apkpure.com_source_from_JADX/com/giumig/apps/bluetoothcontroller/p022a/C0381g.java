package com.giumig.apps.bluetoothcontroller.p022a;

import android.support.v7.widget.ey;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.giumig.apps.bluetoothserialmonitor.R;

public class C0381g extends ey {
    public View f2634l;
    public TextView f2635m;
    public TextView f2636n;
    public ImageView f2637o;

    public C0381g(View view) {
        super(view);
        this.f2634l = view;
        this.f2635m = (TextView) view.findViewById(R.id.pairedDeviceTitle);
        this.f2636n = (TextView) view.findViewById(R.id.pairedDeviceSubtitle);
        this.f2637o = (ImageView) view.findViewById(R.id.deviceIcon);
    }
}
