package com.giumig.apps.bluetoothcontroller.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.giumig.apps.bluetoothserialmonitor.R;

public class ControllerButtonControl extends RelativeLayout {
    private ImageView f2709a;
    private ImageView f2710b;
    private C0390d f2711c;
    private int f2712d;
    private int f2713e;
    private int f2714f;
    private int f2715g;

    public ControllerButtonControl(Context context) {
        super(context);
        m5223a();
    }

    public ControllerButtonControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5223a();
    }

    public ControllerButtonControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5223a();
    }

    private void m5223a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.control_button_controller, this, true);
        this.f2709a = (ImageView) inflate.findViewById(R.id.controller_rightsection_button);
        this.f2710b = (ImageView) inflate.findViewById(R.id.controller_rightsection_symbol);
        this.f2709a.setOnTouchListener(new C0389c(this));
    }

    public void setBackgroundColor(int i) {
        this.f2712d = i;
        this.f2709a.setColorFilter(i);
    }

    public void setBackgroundPressedColor(int i) {
        this.f2713e = i;
    }

    public void setForegroundColor(int i) {
        this.f2714f = i;
        this.f2710b.setColorFilter(i);
    }

    public void setForegroundPressedColor(int i) {
        this.f2715g = i;
    }

    public void setSymbol(C0390d c0390d) {
        this.f2711c = c0390d;
        if (c0390d == C0390d.TOP) {
            this.f2710b.setImageDrawable(getResources().getDrawable(R.drawable.ic_change_history_white_24dp));
        } else if (c0390d == C0390d.BOTTOM) {
            this.f2710b.setImageDrawable(getResources().getDrawable(R.drawable.ic_panorama_fish_eye_white_24dp));
        } else if (c0390d == C0390d.RIGHT) {
            this.f2710b.setImageDrawable(getResources().getDrawable(R.drawable.ic_clear_white_24dp));
        } else {
            this.f2710b.setImageDrawable(getResources().getDrawable(R.drawable.ic_crop_din_white_24dp));
        }
    }
}
