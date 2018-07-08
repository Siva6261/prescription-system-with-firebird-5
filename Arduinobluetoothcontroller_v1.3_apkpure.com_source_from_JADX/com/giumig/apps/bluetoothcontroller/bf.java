package com.giumig.apps.bluetoothcontroller;

import android.animation.ArgbEvaluator;
import android.support.v4.view.dl;
import android.widget.ImageView;
import com.giumig.apps.bluetoothserialmonitor.R;

class bf implements dl {
    final /* synthetic */ SplashActivity f2695a;

    bf(SplashActivity splashActivity) {
        this.f2695a = splashActivity;
    }

    public void mo835a(int i) {
        ImageView imageView = (ImageView) this.f2695a.f2591A.get(i);
        imageView.getLayoutParams().height = 32;
        imageView.getLayoutParams().width = 32;
        imageView.setColorFilter(MyApplication.m5137a().getResources().getColor(R.color.black));
        imageView.requestLayout();
        for (int i2 = 0; i2 < 3; i2++) {
            if (i2 != i) {
                imageView = (ImageView) this.f2695a.f2591A.get(i2);
                imageView.getLayoutParams().height = 24;
                imageView.getLayoutParams().width = 24;
                imageView.setColorFilter(MyApplication.m5137a().getResources().getColor(R.color.arduinoGray1));
            }
        }
        this.f2695a.f2602v.setVisibility(i == 2 ? 0 : 8);
        switch (i) {
            case 0:
                this.f2695a.f2600t.setBackgroundColor(this.f2695a.f2593m);
                return;
            case 1:
                this.f2695a.f2600t.setBackgroundColor(this.f2695a.f2594n);
                return;
            case 2:
                this.f2695a.f2600t.setBackgroundColor(this.f2695a.f2595o);
                return;
            default:
                return;
        }
    }

    public void mo836a(int i, float f, int i2) {
        ArgbEvaluator e = this.f2695a.f2604x;
        Object obj = this.f2695a.f2605y[i];
        Integer[] d = this.f2695a.f2605y;
        if (i != 2) {
            i++;
        }
        this.f2695a.f2600t.setBackgroundColor(((Integer) e.evaluate(f, obj, d[i])).intValue());
    }

    public void mo837b(int i) {
    }
}
