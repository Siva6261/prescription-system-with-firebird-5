package android.support.v4.p010d.p011a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class C0108r extends Drawable implements Callback, C0107q {
    static final Mode f808a = Mode.SRC_IN;
    C0111s f809b;
    Drawable f810c;
    private int f811d;
    private Mode f812e;
    private boolean f813f;
    private boolean f814g;

    C0108r(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            this.f809b = mo214b();
        }
        mo213a(drawable);
    }

    C0108r(C0111s c0111s, Resources resources) {
        this.f809b = c0111s;
        m1353a(resources);
    }

    private void m1353a(Resources resources) {
        if (this.f809b != null && this.f809b.f816b != null) {
            mo213a(mo234a(this.f809b.f816b, resources));
        }
    }

    private boolean m1354a(int[] iArr) {
        if (!mo215c()) {
            return false;
        }
        ColorStateList colorStateList = this.f809b.f817c;
        Mode mode = this.f809b.f818d;
        if (colorStateList == null || mode == null) {
            this.f813f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f813f && colorForState == this.f811d && mode == this.f812e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f811d = colorForState;
        this.f812e = mode;
        this.f813f = true;
        return true;
    }

    public final Drawable mo209a() {
        return this.f810c;
    }

    protected Drawable mo234a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public void mo210a(int i) {
        mo211a(ColorStateList.valueOf(i));
    }

    public void mo211a(ColorStateList colorStateList) {
        this.f809b.f817c = colorStateList;
        m1354a(getState());
    }

    public void mo212a(Mode mode) {
        this.f809b.f818d = mode;
        m1354a(getState());
    }

    public final void mo213a(Drawable drawable) {
        if (this.f810c != null) {
            this.f810c.setCallback(null);
        }
        this.f810c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.f809b != null) {
                this.f809b.f816b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    C0111s mo214b() {
        return new C0127t(this.f809b, null);
    }

    protected boolean mo215c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f810c.draw(canvas);
    }

    public int getChangingConfigurations() {
        return ((this.f809b != null ? this.f809b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f810c.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (this.f809b == null || !this.f809b.m1367a()) {
            return null;
        }
        this.f809b.f815a = getChangingConfigurations();
        return this.f809b;
    }

    public Drawable getCurrent() {
        return this.f810c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f810c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f810c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f810c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f810c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f810c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f810c.getPadding(rect);
    }

    public int[] getState() {
        return this.f810c.getState();
    }

    public Region getTransparentRegion() {
        return this.f810c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = mo215c() ? this.f809b.f817c : null;
        return (colorStateList != null && colorStateList.isStateful()) || this.f810c.isStateful();
    }

    public Drawable mutate() {
        if (!this.f814g && super.mutate() == this) {
            this.f809b = mo214b();
            if (this.f810c != null) {
                this.f810c.mutate();
            }
            if (this.f809b != null) {
                this.f809b.f816b = this.f810c != null ? this.f810c.getConstantState() : null;
            }
            this.f814g = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f810c != null) {
            this.f810c.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f810c.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f810c.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f810c.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f810c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f810c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f810c.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m1354a(iArr) || this.f810c.setState(iArr);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f810c.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
