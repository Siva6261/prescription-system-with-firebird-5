package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0028i;
import android.support.v7.widget.cq;
import android.util.AttributeSet;
import android.view.Gravity;

public class C0029a extends cq {
    protected boolean f105a;
    boolean f106b;
    private Drawable f107c;
    private final Rect f108d;
    private final Rect f109e;
    private int f110f;

    public C0029a(Context context) {
        this(context, null);
    }

    public C0029a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0029a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f108d = new Rect();
        this.f109e = new Rect();
        this.f110f = 119;
        this.f105a = true;
        this.f106b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.ForegroundLinearLayout, i, 0);
        this.f110f = obtainStyledAttributes.getInt(C0028i.ForegroundLinearLayout_android_foregroundGravity, this.f110f);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0028i.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f105a = obtainStyledAttributes.getBoolean(C0028i.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f107c != null) {
            Drawable drawable = this.f107c;
            if (this.f106b) {
                this.f106b = false;
                Rect rect = this.f108d;
                Rect rect2 = this.f109e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f105a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f110f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f107c != null) {
            this.f107c.setHotspot(f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f107c != null && this.f107c.isStateful()) {
            this.f107c.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f107c;
    }

    public int getForegroundGravity() {
        return this.f110f;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f107c != null) {
            this.f107c.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f106b |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f106b = true;
    }

    public void setForeground(Drawable drawable) {
        if (this.f107c != drawable) {
            if (this.f107c != null) {
                this.f107c.setCallback(null);
                unscheduleDrawable(this.f107c);
            }
            this.f107c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f110f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.f110f != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f110f = i2;
            if (this.f110f == 119 && this.f107c != null) {
                this.f107c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f107c;
    }
}
