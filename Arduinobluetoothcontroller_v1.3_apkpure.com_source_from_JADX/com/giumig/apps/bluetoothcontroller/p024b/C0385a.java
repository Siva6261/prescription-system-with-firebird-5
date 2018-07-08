package com.giumig.apps.bluetoothcontroller.p024b;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.p006b.C0051y;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.giumig.apps.bluetoothcontroller.bl;
import com.giumig.apps.bluetoothserialmonitor.R;

public class C0385a extends C0051y {
    private View f2678a;
    private LinearLayout f2679b;
    private ImageView f2680c;
    private TextView f2681d;
    private TextView f2682e;

    private void m5196a() {
        this.f2679b = (LinearLayout) this.f2678a.findViewById(R.id.tutorialLinearContainer);
        this.f2680c = (ImageView) this.f2678a.findViewById(R.id.slideImage);
        this.f2681d = (TextView) this.f2678a.findViewById(R.id.slideTitle);
        this.f2682e = (TextView) this.f2678a.findViewById(R.id.slideSubtitle);
        bl.m5214a(this.f2681d, "Roboto-Regular.ttf");
        bl.m5214a(this.f2682e, "Roboto-Light.ttf");
        int i = m869i().getInt("SLIDE_NUMBER");
        if (i == 0) {
            this.f2680c.setBackgroundResource(R.drawable.slide01);
            this.f2681d.setText(m828a((int) R.string.tutorial_slide1_title));
            this.f2682e.setText(m828a((int) R.string.tutorial_slide1_subtitle));
        } else if (i == 1) {
            this.f2680c.setBackgroundResource(R.drawable.slide02);
            this.f2681d.setText(m828a((int) R.string.tutorial_slide2_title));
            this.f2682e.setText(m828a((int) R.string.tutorial_slide2_subtitle));
        } else {
            this.f2680c.setBackgroundResource(R.drawable.slide03);
            this.f2681d.setText(m828a((int) R.string.tutorial_slide3_title));
            this.f2682e.setText(m828a((int) R.string.tutorial_slide3_subtitle));
        }
    }

    public static C0385a m5197b(int i) {
        C0385a c0385a = new C0385a();
        Bundle bundle = new Bundle(1);
        bundle.putInt("SLIDE_NUMBER", i);
        c0385a.m865g(bundle);
        return c0385a;
    }

    public View mo832a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2678a = (ViewGroup) layoutInflater.inflate(R.layout.fragment_tutorial, viewGroup, false);
        m5196a();
        return this.f2678a;
    }

    public void mo153d(Bundle bundle) {
        int i = 0;
        super.mo153d(bundle);
        int i2 = m875l().getConfiguration().orientation == 2 ? 1 : 0;
        LinearLayout linearLayout = this.f2679b;
        if (i2 == 0) {
            i = 1;
        }
        linearLayout.setOrientation(i);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f2679b != null) {
            this.f2679b.setOrientation(configuration.orientation == 2 ? 0 : 1);
        }
    }
}
