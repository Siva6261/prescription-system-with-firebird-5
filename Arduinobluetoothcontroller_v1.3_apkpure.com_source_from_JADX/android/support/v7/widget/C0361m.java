package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p018b.C0298b;
import android.support.v7.view.menu.C0337m;
import android.support.v7.view.menu.C0346v;
import android.support.v7.view.menu.ad;
import android.view.MenuItem;
import android.view.View;

class C0361m extends C0346v {
    final /* synthetic */ C0359k f2441c;
    private ad f2442d;

    public C0361m(C0359k c0359k, Context context, ad adVar) {
        boolean z = false;
        this.f2441c = c0359k;
        super(context, adVar, null, false, C0298b.actionOverflowMenuStyle);
        this.f2442d = adVar;
        if (!((C0337m) adVar.getItem()).m3474j()) {
            m3505a(c0359k.f2423i == null ? (View) c0359k.f : c0359k.f2423i);
        }
        m3504a(c0359k.f2421g);
        int size = adVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = adVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        m3506a(z);
    }

    public void onDismiss() {
        super.onDismiss();
        this.f2441c.f2439y = null;
        this.f2441c.f2422h = 0;
    }
}
