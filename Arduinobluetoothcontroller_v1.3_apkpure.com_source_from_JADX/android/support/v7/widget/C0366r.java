package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p018b.C0298b;
import android.support.v7.view.menu.C0329i;
import android.support.v7.view.menu.C0346v;
import android.view.View;

class C0366r extends C0346v {
    final /* synthetic */ C0359k f2450c;

    public C0366r(C0359k c0359k, Context context, C0329i c0329i, View view, boolean z) {
        this.f2450c = c0359k;
        super(context, c0329i, view, z, C0298b.actionOverflowMenuStyle);
        m3501a(8388613);
        m3504a(c0359k.f2421g);
    }

    public void onDismiss() {
        super.onDismiss();
        if (this.f2450c.c != null) {
            this.f2450c.c.close();
        }
        this.f2450c.f2438x = null;
    }
}
