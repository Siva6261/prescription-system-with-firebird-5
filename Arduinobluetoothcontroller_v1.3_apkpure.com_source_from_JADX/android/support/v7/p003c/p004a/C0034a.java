package android.support.v7.p003c.p004a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p010d.p011a.C0106a;

public class C0034a extends Drawable implements Callback {
    private Drawable f370a;

    public C0034a(Drawable drawable) {
        m610a(drawable);
    }

    public void m610a(Drawable drawable) {
        if (this.f370a != null) {
            this.f370a.setCallback(null);
        }
        this.f370a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public Drawable m611b() {
        return this.f370a;
    }

    public void draw(Canvas canvas) {
        this.f370a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f370a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f370a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f370a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f370a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f370a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f370a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f370a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f370a.getPadding(rect);
    }

    public int[] getState() {
        return this.f370a.getState();
    }

    public Region getTransparentRegion() {
        return this.f370a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return C0106a.m1342b(this.f370a);
    }

    public boolean isStateful() {
        return this.f370a.isStateful();
    }

    public void jumpToCurrentState() {
        C0106a.m1332a(this.f370a);
    }

    protected void onBoundsChange(Rect rect) {
        this.f370a.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f370a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f370a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        C0106a.m1340a(this.f370a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f370a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f370a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f370a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f370a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        C0106a.m1333a(this.f370a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0106a.m1335a(this.f370a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f370a.setState(iArr);
    }

    public void setTint(int i) {
        C0106a.m1334a(this.f370a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0106a.m1336a(this.f370a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0106a.m1339a(this.f370a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f370a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
