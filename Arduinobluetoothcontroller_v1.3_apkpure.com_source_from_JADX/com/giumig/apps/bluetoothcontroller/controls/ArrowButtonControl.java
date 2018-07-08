package com.giumig.apps.bluetoothcontroller.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.giumig.apps.bluetoothserialmonitor.R;

public class ArrowButtonControl extends RelativeLayout {
    private ImageView f2702a;
    private ImageView f2703b;
    private C0388b f2704c;
    private int f2705d;
    private int f2706e;
    private int f2707f;
    private int f2708g;

    public ArrowButtonControl(Context context) {
        super(context);
        m5216a();
    }

    public ArrowButtonControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5216a();
    }

    public ArrowButtonControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5216a();
    }

    private void m5216a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.control_arrow_controller, this, true);
        this.f2702a = (ImageView) inflate.findViewById(R.id.controller_leftsection_button);
        this.f2703b = (ImageView) inflate.findViewById(R.id.controller_leftsection_symbol);
        this.f2702a.setOnTouchListener(new C0387a(this));
    }

    public void setBackgroundColor(int i) {
        this.f2705d = i;
        this.f2702a.setColorFilter(i);
    }

    public void setBackgroundPressedColor(int i) {
        this.f2706e = i;
    }

    public void setForegroundColor(int i) {
        this.f2707f = i;
        this.f2703b.setColorFilter(i);
    }

    public void setForegroundPressedColor(int i) {
        this.f2708g = i;
    }

    public void setSymbol(C0388b c0388b) {
        this.f2704c = c0388b;
        if (c0388b == C0388b.TOP) {
            this.f2702a.setImageDrawable(getResources().getDrawable(R.drawable.ic_label_black_48dp_up));
            this.f2703b.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less_white_24dp));
        } else if (c0388b == C0388b.BOTTOM) {
            this.f2702a.setImageDrawable(getResources().getDrawable(R.drawable.ic_label_black_48dp_down));
            this.f2703b.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more_white_24dp));
        } else if (c0388b == C0388b.RIGHT) {
            this.f2702a.setImageDrawable(getResources().getDrawable(R.drawable.ic_label_black_48dp_right));
            this.f2703b.setImageDrawable(getResources().getDrawable(R.drawable.ic_chevron_right_white_24dp));
        } else {
            this.f2702a.setImageDrawable(getResources().getDrawable(R.drawable.ic_label_black_48dp_left));
            this.f2703b.setImageDrawable(getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp));
        }
    }
}
