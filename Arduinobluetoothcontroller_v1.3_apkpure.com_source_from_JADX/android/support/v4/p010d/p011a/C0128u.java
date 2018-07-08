package android.support.v4.p010d.p011a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class C0128u extends C0108r {
    C0128u(Drawable drawable) {
        super(drawable);
    }

    C0128u(C0111s c0111s, Resources resources) {
        super(c0111s, resources);
    }

    protected Drawable mo234a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    C0111s mo214b() {
        return new C0129v(this.b, null);
    }
}
