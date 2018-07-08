package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public abstract class C0277b {
    private Object f1317a;
    private boolean f1318b;

    public abstract MenuInflater mo554a();

    public abstract void mo555a(int i);

    public abstract void mo556a(View view);

    public abstract void mo557a(CharSequence charSequence);

    public void m3125a(Object obj) {
        this.f1317a = obj;
    }

    public void mo558a(boolean z) {
        this.f1318b = z;
    }

    public abstract Menu mo559b();

    public abstract void mo560b(int i);

    public abstract void mo561b(CharSequence charSequence);

    public abstract void mo562c();

    public abstract void mo563d();

    public abstract CharSequence mo564f();

    public abstract CharSequence mo565g();

    public boolean mo566h() {
        return false;
    }

    public abstract View mo567i();

    public Object m3136j() {
        return this.f1317a;
    }

    public boolean m3137k() {
        return this.f1318b;
    }
}
