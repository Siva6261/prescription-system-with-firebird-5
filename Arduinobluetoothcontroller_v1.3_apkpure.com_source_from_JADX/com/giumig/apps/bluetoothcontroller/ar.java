package com.giumig.apps.bluetoothcontroller;

import android.app.Dialog;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.C0043k;
import android.support.design.widget.C0053r;
import android.support.design.widget.ab;
import android.support.design.widget.ae;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.giumig.apps.bluetoothserialmonitor.R;

public class ar extends C0053r {
    final /* synthetic */ MainActivity ai;
    private RelativeLayout aj;
    private TextView ak;
    private TextView al;
    private TextView am;
    private TextView an;
    private RelativeLayout ao;
    private ImageView ap;
    private C0043k aq = new as(this);

    public ar(MainActivity mainActivity) {
        this.ai = mainActivity;
    }

    public void mo158a(Dialog dialog, int i) {
        super.mo158a(dialog, i);
        View inflate = View.inflate(m871j(), R.layout.bottom_sheets_main, null);
        dialog.setContentView(inflate);
        ab b = ((ae) ((View) inflate.getParent()).getLayoutParams()).m508b();
        if (b != null && (b instanceof BottomSheetBehavior)) {
            ((BottomSheetBehavior) b).m361a(this.aq);
        }
        this.aj = (RelativeLayout) inflate.findViewById(R.id.google_play_item);
        this.aj.setOnClickListener(new at(this));
        this.ao = (RelativeLayout) inflate.findViewById(R.id.share_item);
        this.ao.setOnClickListener(new au(this));
        this.ap = (ImageView) inflate.findViewById(R.id.share_icon);
        this.ap.setColorFilter(m875l().getColor(R.color.colorAccent));
        this.ak = (TextView) inflate.findViewById(R.id.google_play_rate);
        this.al = (TextView) inflate.findViewById(R.id.shareTextView);
        this.am = (TextView) inflate.findViewById(R.id.build_version_title);
        this.an = (TextView) inflate.findViewById(R.id.build_version_subtitle);
        bl.m5214a(this.ak, "Roboto-Regular.ttf");
        bl.m5214a(this.al, "Roboto-Regular.ttf");
        bl.m5214a(this.am, "Roboto-Regular.ttf");
        bl.m5214a(this.an, "Roboto-Light.ttf");
        try {
            this.an.setText(this.ai.getPackageManager().getPackageInfo(this.ai.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
        }
    }
}
