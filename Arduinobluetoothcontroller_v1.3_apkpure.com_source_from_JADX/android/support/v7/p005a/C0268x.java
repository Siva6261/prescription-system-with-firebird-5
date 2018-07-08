package android.support.v7.p005a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.support.v7.view.C0319i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

abstract class C0268x extends C0267w {
    final Context f1153a;
    final Window f1154b;
    final Callback f1155c = this.f1154b.getCallback();
    final Callback f1156d;
    final C0047v f1157e;
    C0266a f1158f;
    MenuInflater f1159g;
    boolean f1160h;
    boolean f1161i;
    boolean f1162j;
    boolean f1163k;
    boolean f1164l;
    private CharSequence f1165m;
    private boolean f1166n;

    C0268x(Context context, Window window, C0047v c0047v) {
        this.f1153a = context;
        this.f1154b = window;
        this.f1157e = c0047v;
        if (this.f1155c instanceof C0272y) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1156d = mo504a(this.f1155c);
        this.f1154b.setCallback(this.f1156d);
    }

    public C0266a mo474a() {
        mo502j();
        return this.f1158f;
    }

    abstract C0277b mo480a(C0274c c0274c);

    Callback mo504a(Callback callback) {
        return new C0272y(this, callback);
    }

    abstract void mo482a(int i, Menu menu);

    public final void mo475a(CharSequence charSequence) {
        this.f1165m = charSequence;
        mo495b(charSequence);
    }

    abstract boolean mo489a(int i, KeyEvent keyEvent);

    abstract boolean mo491a(KeyEvent keyEvent);

    public MenuInflater mo476b() {
        if (this.f1159g == null) {
            mo502j();
            this.f1159g = new C0319i(this.f1158f != null ? this.f1158f.mo534c() : this.f1153a);
        }
        return this.f1159g;
    }

    abstract void mo495b(CharSequence charSequence);

    abstract boolean mo496b(int i, Menu menu);

    public void mo477c(Bundle bundle) {
    }

    public void mo478f() {
        this.f1166n = true;
    }

    public boolean mo479h() {
        return false;
    }

    abstract void mo502j();

    final C0266a m2890k() {
        return this.f1158f;
    }

    final Context m2891l() {
        Context context = null;
        C0266a a = mo474a();
        if (a != null) {
            context = a.mo534c();
        }
        return context == null ? this.f1153a : context;
    }

    public boolean mo505m() {
        return false;
    }

    final boolean m2893n() {
        return this.f1166n;
    }

    final Callback m2894o() {
        return this.f1154b.getCallback();
    }

    final CharSequence m2895p() {
        return this.f1155c instanceof Activity ? ((Activity) this.f1155c).getTitle() : this.f1165m;
    }
}
