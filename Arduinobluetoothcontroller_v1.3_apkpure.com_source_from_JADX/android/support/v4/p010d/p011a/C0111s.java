package android.support.v4.p010d.p011a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class C0111s extends ConstantState {
    int f815a;
    ConstantState f816b;
    ColorStateList f817c = null;
    Mode f818d = C0108r.f808a;

    C0111s(C0111s c0111s, Resources resources) {
        if (c0111s != null) {
            this.f815a = c0111s.f815a;
            this.f816b = c0111s.f816b;
            this.f817c = c0111s.f817c;
            this.f818d = c0111s.f818d;
        }
    }

    boolean m1367a() {
        return this.f816b != null;
    }

    public int getChangingConfigurations() {
        return (this.f816b != null ? this.f816b.getChangingConfigurations() : 0) | this.f815a;
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public abstract Drawable newDrawable(Resources resources);
}
