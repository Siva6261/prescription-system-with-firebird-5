package com.giumig.apps.bluetoothcontroller;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bn;
import android.support.v4.view.dl;
import android.support.v7.p005a.C0296u;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.giumig.apps.bluetoothserialmonitor.R;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends C0296u {
    private List f2591A = new ArrayList();
    private OnClickListener f2592B = new bg(this);
    int f2593m = MyApplication.m5137a().getResources().getColor(R.color.tutorial_slide1);
    int f2594n = MyApplication.m5137a().getResources().getColor(R.color.tutorial_slide2);
    int f2595o = MyApplication.m5137a().getResources().getColor(R.color.tutorial_slide3);
    private ImageView f2596p;
    private ImageView f2597q;
    private RelativeLayout f2598r;
    private RelativeLayout f2599s;
    private ViewPager f2600t;
    private bn f2601u;
    private AppCompatButton f2602v;
    private Runnable f2603w = new be(this);
    private ArgbEvaluator f2604x = new ArgbEvaluator();
    private Integer[] f2605y = new Integer[]{Integer.valueOf(this.f2593m), Integer.valueOf(this.f2594n), Integer.valueOf(this.f2595o)};
    private dl f2606z = new bf(this);

    private void m5151k() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void m5152l() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.viewPagerDots);
        for (int i = 0; i < 3; i++) {
            View imageView = new ImageView(this);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_fiber_manual_record_black_24dp));
            LayoutParams layoutParams = new LinearLayout.LayoutParams(24, 24);
            layoutParams.setMargins(8, 0, 8, 0);
            linearLayout.addView(imageView, layoutParams);
            this.f2591A.add(imageView);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_splash);
        this.f2598r = (RelativeLayout) findViewById(R.id.splash);
        this.f2599s = (RelativeLayout) findViewById(R.id.tutorial);
        this.f2602v = (AppCompatButton) findViewById(R.id.tutorialOkButton);
        this.f2602v.setOnClickListener(this.f2592B);
        this.f2600t = (ViewPager) findViewById(R.id.tutorialViewPager);
        this.f2601u = new bh(this, m981f());
        this.f2600t.setAdapter(this.f2601u);
        this.f2600t.m1614a(true, new bc().m5204a(new bd(R.id.slideImage, -0.2f, -101.1986f)).m5204a(new bd(R.id.slideTitle, -0.65f, -101.1986f)).m5204a(new bd(R.id.slideSubtitle, -1.0f, -101.1986f)));
        m5152l();
        this.f2600t.m1613a(this.f2606z);
        this.f2606z.mo835a(0);
        this.f2596p = (ImageView) findViewById(R.id.arduino_logo);
        this.f2596p.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        this.f2597q = (ImageView) findViewById(R.id.controller_logo);
        this.f2597q.setColorFilter(getResources().getColor(R.color.colorPrimary));
        this.f2596p.postDelayed(this.f2603w, 1600);
    }

    protected void onDestroy() {
        if (this.f2596p != null) {
            this.f2596p.removeCallbacks(this.f2603w);
        }
        super.onDestroy();
    }
}
