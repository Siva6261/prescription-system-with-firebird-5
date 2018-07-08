package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.p003c.p004a.C0034a;

class dl extends C0034a {
    private boolean f2187a = true;

    public dl(Drawable drawable) {
        super(drawable);
    }

    void m4401a(boolean z) {
        this.f2187a = z;
    }

    public void draw(Canvas canvas) {
        if (this.f2187a) {
            super.draw(canvas);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f2187a) {
            super.setHotspot(f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f2187a) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.f2187a ? super.setState(iArr) : false;
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f2187a ? super.setVisible(z, z2) : false;
    }
}
