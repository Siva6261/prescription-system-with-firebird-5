package android.support.v4.p006b;

import android.view.View;

class C0092z extends ah {
    final /* synthetic */ C0051y f797a;

    C0092z(C0051y c0051y) {
        this.f797a = c0051y;
    }

    public View mo167a(int i) {
        if (this.f797a.f491R != null) {
            return this.f797a.f491R.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public boolean mo168a() {
        return this.f797a.f491R != null;
    }
}
