package android.support.v7.view.menu;

import android.support.v7.view.C0314d;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class C0341q extends FrameLayout implements C0314d {
    final CollapsibleActionView f1640a;

    C0341q(View view) {
        super(view.getContext());
        this.f1640a = (CollapsibleActionView) view;
        addView(view);
    }

    public void mo620a() {
        this.f1640a.onActionViewExpanded();
    }

    public void mo621b() {
        this.f1640a.onActionViewCollapsed();
    }

    View m3488c() {
        return (View) this.f1640a;
    }
}
