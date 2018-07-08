package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class C0227n {
    private final Context f1037a;
    private C0228o f1038b;
    private C0229p f1039c;

    public C0227n(Context context) {
        this.f1037a = context;
    }

    public abstract View mo616a();

    public View mo625a(MenuItem menuItem) {
        return mo616a();
    }

    public void m2498a(C0228o c0228o) {
        this.f1038b = c0228o;
    }

    public void mo626a(C0229p c0229p) {
        if (!(this.f1039c == null || c0229p == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1039c = c0229p;
    }

    public void mo617a(SubMenu subMenu) {
    }

    public void m2501a(boolean z) {
        if (this.f1038b != null) {
            this.f1038b.mo810a(z);
        }
    }

    public boolean mo627b() {
        return false;
    }

    public boolean mo628c() {
        return true;
    }

    public boolean mo618d() {
        return false;
    }

    public boolean mo619e() {
        return false;
    }

    public void m2506f() {
        this.f1039c = null;
        this.f1038b = null;
    }
}
