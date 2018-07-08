package android.support.v7.widget;

import android.support.v7.view.menu.C0326a;
import android.view.View;
import android.view.View.OnClickListener;

class gp implements OnClickListener {
    final C0326a f2407a = new C0326a(this.f2408b.f2389a.getContext(), 0, 16908332, 0, 0, this.f2408b.f2397i);
    final /* synthetic */ go f2408b;

    gp(go goVar) {
        this.f2408b = goVar;
    }

    public void onClick(View view) {
        if (this.f2408b.f2400l != null && this.f2408b.f2401m) {
            this.f2408b.f2400l.onMenuItemSelected(0, this.f2407a);
        }
    }
}
