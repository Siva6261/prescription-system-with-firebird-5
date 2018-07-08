package android.support.v7.p005a;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.view.KeyEvent;

public abstract class C0266a {
    public abstract int mo524a();

    public C0277b mo544a(C0274c c0274c) {
        return null;
    }

    public void mo525a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void mo526a(int i) {
    }

    public void mo527a(Configuration configuration) {
    }

    public abstract void mo528a(CharSequence charSequence);

    public abstract void mo529a(boolean z);

    public boolean mo530a(int i, KeyEvent keyEvent) {
        return false;
    }

    public void mo531b(CharSequence charSequence) {
    }

    public void mo532b(boolean z) {
    }

    public abstract boolean mo533b();

    public Context mo534c() {
        return null;
    }

    public void mo546c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public int mo547d() {
        return 0;
    }

    public void mo535d(boolean z) {
    }

    public void mo536e(boolean z) {
    }

    public boolean mo537e() {
        return false;
    }

    public void mo538f(boolean z) {
    }

    public boolean mo539f() {
        return false;
    }

    boolean mo540g() {
        return false;
    }

    void mo541h() {
    }
}
