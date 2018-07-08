package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

class ed implements ep {
    dy f1024a;
    boolean f1025b;

    ed(dy dyVar) {
        this.f1024a = dyVar;
    }

    public void mo112a(View view) {
        this.f1025b = false;
        if (this.f1024a.f1018e >= 0) {
            bv.m2005a(view, 2, null);
        }
        if (this.f1024a.f1016c != null) {
            Runnable a = this.f1024a.f1016c;
            this.f1024a.f1016c = null;
            a.run();
        }
        Object tag = view.getTag(2113929216);
        ep epVar = tag instanceof ep ? (ep) tag : null;
        if (epVar != null) {
            epVar.mo112a(view);
        }
    }

    public void mo113b(View view) {
        if (this.f1024a.f1018e >= 0) {
            bv.m2005a(view, this.f1024a.f1018e, null);
            this.f1024a.f1018e = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.f1025b) {
            if (this.f1024a.f1017d != null) {
                Runnable b = this.f1024a.f1017d;
                this.f1024a.f1017d = null;
                b.run();
            }
            Object tag = view.getTag(2113929216);
            ep epVar = tag instanceof ep ? (ep) tag : null;
            if (epVar != null) {
                epVar.mo113b(view);
            }
            this.f1025b = true;
        }
    }

    public void mo114c(View view) {
        Object tag = view.getTag(2113929216);
        ep epVar = tag instanceof ep ? (ep) tag : null;
        if (epVar != null) {
            epVar.mo114c(view);
        }
    }
}
