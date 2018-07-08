package android.support.v4.p006b;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class af extends aj {
    final /* synthetic */ ad f614a;

    public af(ad adVar) {
        this.f614a = adVar;
        super(adVar);
    }

    public View mo167a(int i) {
        return this.f614a.findViewById(i);
    }

    public void mo169a(C0051y c0051y, Intent intent, int i, Bundle bundle) {
        this.f614a.m974a(c0051y, intent, i, bundle);
    }

    public void mo170a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f614a.dump(str, fileDescriptor, printWriter, strArr);
    }

    public boolean mo168a() {
        Window window = this.f614a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public boolean mo171a(C0051y c0051y) {
        return !this.f614a.isFinishing();
    }

    public LayoutInflater mo172b() {
        return this.f614a.getLayoutInflater().cloneInContext(this.f614a);
    }

    public void mo173b(C0051y c0051y) {
        this.f614a.m973a(c0051y);
    }

    public void mo174c() {
        this.f614a.mo571d();
    }

    public boolean mo175d() {
        return this.f614a.getWindow() != null;
    }

    public int mo176e() {
        Window window = this.f614a.getWindow();
        return window == null ? 0 : window.getAttributes().windowAnimations;
    }
}
