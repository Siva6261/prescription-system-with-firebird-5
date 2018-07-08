package com.giumig.apps.bluetoothcontroller.p022a;

import android.support.v7.widget.ey;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.giumig.apps.bluetoothserialmonitor.R;

public class C0377c extends ey {
    public View f2623l;
    public TextView f2624m;
    public TextView f2625n;
    public ImageView f2626o;

    public C0377c(View view) {
        super(view);
        this.f2623l = view;
        this.f2624m = (TextView) view.findViewById(R.id.availableDeviceTitle);
        this.f2625n = (TextView) view.findViewById(R.id.availableDeviceSubtitle);
        this.f2626o = (ImageView) view.findViewById(R.id.deviceIcon);
    }
}
