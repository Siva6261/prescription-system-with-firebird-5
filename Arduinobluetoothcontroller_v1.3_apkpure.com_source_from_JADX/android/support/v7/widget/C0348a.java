package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.az;
import android.support.v4.view.bv;
import android.support.v4.view.dy;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class C0348a extends ViewGroup {
    protected final C0349b f1676a;
    protected final Context f1677b;
    protected ActionMenuView f1678c;
    protected C0359k f1679d;
    protected int f1680e;
    protected dy f1681f;
    private boolean f1682g;
    private boolean f1683h;

    C0348a(Context context) {
        this(context, null);
    }

    C0348a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0348a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1676a = new C0349b(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0298b.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1677b = context;
        } else {
            this.f1677b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int m3521a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m3524a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int m3525a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public dy mo629a(int i, long j) {
        if (this.f1681f != null) {
            this.f1681f.m2391b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                bv.m2019c((View) this, 0.0f);
            }
            dy a = bv.m2040q(this).m2384a(1.0f);
            a.m2385a(j);
            a.m2386a(this.f1676a.m4112a(a, i));
            return a;
        }
        a = bv.m2040q(this).m2384a(0.0f);
        a.m2385a(j);
        a.m2386a(this.f1676a.m4112a(a, i));
        return a;
    }

    public boolean mo630a() {
        return this.f1679d != null ? this.f1679d.m4923d() : false;
    }

    public int getAnimatedVisibility() {
        return this.f1681f != null ? this.f1676a.f1971a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1680e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0308l.ActionBar, C0298b.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0308l.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1679d != null) {
            this.f1679d.m4909a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = az.m1904a(motionEvent);
        if (a == 9) {
            this.f1683h = false;
        }
        if (!this.f1683h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1683h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1683h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = az.m1904a(motionEvent);
        if (a == 0) {
            this.f1682g = false;
        }
        if (!this.f1682g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1682g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1682g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1680e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1681f != null) {
                this.f1681f.m2391b();
            }
            super.setVisibility(i);
        }
    }
}
