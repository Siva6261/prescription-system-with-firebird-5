package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class cz extends ab {
    private da f166a;
    private int f167b = 0;
    private int f168c = 0;

    public cz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean mo46a(int i) {
        if (this.f166a != null) {
            return this.f166a.m766a(i);
        }
        this.f167b = i;
        return false;
    }

    public boolean mo35a(CoordinatorLayout coordinatorLayout, View view, int i) {
        mo54b(coordinatorLayout, view, i);
        if (this.f166a == null) {
            this.f166a = new da(view);
        }
        this.f166a.m765a();
        if (this.f167b != 0) {
            this.f166a.m766a(this.f167b);
            this.f167b = 0;
        }
        if (this.f168c != 0) {
            this.f166a.m768b(this.f168c);
            this.f168c = 0;
        }
        return true;
    }

    public int mo49b() {
        return this.f166a != null ? this.f166a.m767b() : 0;
    }

    protected void mo54b(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.m408a(view, i);
    }
}
