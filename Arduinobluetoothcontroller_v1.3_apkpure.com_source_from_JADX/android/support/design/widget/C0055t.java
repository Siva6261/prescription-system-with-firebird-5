package android.support.design.widget;

import android.graphics.Outline;

class C0055t extends C0054s {
    C0055t() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
