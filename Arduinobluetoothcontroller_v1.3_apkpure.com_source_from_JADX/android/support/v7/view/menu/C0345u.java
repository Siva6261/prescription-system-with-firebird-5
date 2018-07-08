package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.C0229p;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

class C0345u extends C0340p implements VisibilityListener {
    C0229p f1643c;
    final /* synthetic */ C0344t f1644d;

    public C0345u(C0344t c0344t, Context context, ActionProvider actionProvider) {
        this.f1644d = c0344t;
        super(c0344t, context, actionProvider);
    }

    public View mo625a(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }

    public void mo626a(C0229p c0229p) {
        VisibilityListener visibilityListener;
        this.f1643c = c0229p;
        ActionProvider actionProvider = this.a;
        if (c0229p == null) {
            visibilityListener = null;
        }
        actionProvider.setVisibilityListener(visibilityListener);
    }

    public boolean mo627b() {
        return this.a.overridesItemVisibility();
    }

    public boolean mo628c() {
        return this.a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        if (this.f1643c != null) {
            this.f1643c.mo615a(z);
        }
    }
}
