package android.support.v7.widget;

import android.support.v4.view.eq;
import android.view.View;

class gq extends eq {
    final /* synthetic */ int f2409a;
    final /* synthetic */ go f2410b;
    private boolean f2411c = false;

    gq(go goVar, int i) {
        this.f2410b = goVar;
        this.f2409a = i;
    }

    public void mo112a(View view) {
        this.f2410b.f2389a.setVisibility(0);
    }

    public void mo113b(View view) {
        if (!this.f2411c) {
            this.f2410b.f2389a.setVisibility(this.f2409a);
        }
    }

    public void mo114c(View view) {
        this.f2411c = true;
    }
}
