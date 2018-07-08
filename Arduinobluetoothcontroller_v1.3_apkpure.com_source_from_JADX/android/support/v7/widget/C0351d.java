package android.support.v7.widget;

import android.graphics.Outline;

class C0351d extends C0350c {
    public C0351d(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1669d) {
            if (this.a.f1668c != null) {
                this.a.f1668c.getOutline(outline);
            }
        } else if (this.a.f1666a != null) {
            this.a.f1666a.getOutline(outline);
        }
    }
}
