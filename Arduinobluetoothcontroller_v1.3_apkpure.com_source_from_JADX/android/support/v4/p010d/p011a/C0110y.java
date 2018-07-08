package android.support.v4.p010d.p011a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class C0110y extends C0109w {
    C0110y(Drawable drawable) {
        super(drawable);
    }

    C0110y(C0111s c0111s, Resources resources) {
        super(c0111s, resources);
    }

    C0111s mo214b() {
        return new C0131z(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}
