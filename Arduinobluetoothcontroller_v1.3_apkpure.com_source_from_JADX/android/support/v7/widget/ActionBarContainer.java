package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p018b.C0303g;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
    Drawable f1666a;
    Drawable f1667b;
    Drawable f1668c;
    boolean f1669d;
    boolean f1670e;
    private boolean f1671f;
    private View f1672g;
    private View f1673h;
    private View f1674i;
    private int f1675j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(VERSION.SDK_INT >= 21 ? new C0351d(this) : new C0350c(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0308l.ActionBar);
        this.f1666a = obtainStyledAttributes.getDrawable(C0308l.ActionBar_background);
        this.f1667b = obtainStyledAttributes.getDrawable(C0308l.ActionBar_backgroundStacked);
        this.f1675j = obtainStyledAttributes.getDimensionPixelSize(C0308l.ActionBar_height, -1);
        if (getId() == C0303g.split_action_bar) {
            this.f1669d = true;
            this.f1668c = obtainStyledAttributes.getDrawable(C0308l.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1669d ? this.f1668c == null : this.f1666a == null && this.f1667b == null;
        setWillNotDraw(z);
    }

    private boolean m3519a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m3520b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1666a != null && this.f1666a.isStateful()) {
            this.f1666a.setState(getDrawableState());
        }
        if (this.f1667b != null && this.f1667b.isStateful()) {
            this.f1667b.setState(getDrawableState());
        }
        if (this.f1668c != null && this.f1668c.isStateful()) {
            this.f1668c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1672g;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1666a != null) {
                this.f1666a.jumpToCurrentState();
            }
            if (this.f1667b != null) {
                this.f1667b.jumpToCurrentState();
            }
            if (this.f1668c != null) {
                this.f1668c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1673h = findViewById(C0303g.action_bar);
        this.f1674i = findViewById(C0303g.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1671f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1672g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1669d) {
            int i6;
            if (this.f1666a != null) {
                if (this.f1673h.getVisibility() == 0) {
                    this.f1666a.setBounds(this.f1673h.getLeft(), this.f1673h.getTop(), this.f1673h.getRight(), this.f1673h.getBottom());
                } else if (this.f1674i == null || this.f1674i.getVisibility() != 0) {
                    this.f1666a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1666a.setBounds(this.f1674i.getLeft(), this.f1674i.getTop(), this.f1674i.getRight(), this.f1674i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1670e = z2;
            if (!z2 || this.f1667b == null) {
                i5 = i6;
            } else {
                this.f1667b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1668c != null) {
            this.f1668c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f1673h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1675j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1675j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1673h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1672g != null && this.f1672g.getVisibility() != 8 && mode != 1073741824) {
                int b = !m3519a(this.f1673h) ? m3520b(this.f1673h) : !m3519a(this.f1674i) ? m3520b(this.f1674i) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m3520b(this.f1672g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1666a != null) {
            this.f1666a.setCallback(null);
            unscheduleDrawable(this.f1666a);
        }
        this.f1666a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1673h != null) {
                this.f1666a.setBounds(this.f1673h.getLeft(), this.f1673h.getTop(), this.f1673h.getRight(), this.f1673h.getBottom());
            }
        }
        if (this.f1669d) {
            if (this.f1668c != null) {
                z = false;
            }
        } else if (!(this.f1666a == null && this.f1667b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1668c != null) {
            this.f1668c.setCallback(null);
            unscheduleDrawable(this.f1668c);
        }
        this.f1668c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1669d && this.f1668c != null) {
                this.f1668c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1669d) {
            if (this.f1668c != null) {
                z = false;
            }
        } else if (!(this.f1666a == null && this.f1667b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1667b != null) {
            this.f1667b.setCallback(null);
            unscheduleDrawable(this.f1667b);
        }
        this.f1667b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1670e && this.f1667b != null) {
                this.f1667b.setBounds(this.f1672g.getLeft(), this.f1672g.getTop(), this.f1672g.getRight(), this.f1672g.getBottom());
            }
        }
        if (this.f1669d) {
            if (this.f1668c != null) {
                z = false;
            }
        } else if (!(this.f1666a == null && this.f1667b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(fd fdVar) {
        if (this.f1672g != null) {
            removeView(this.f1672g);
        }
        this.f1672g = fdVar;
        if (fdVar != null) {
            addView(fdVar);
            ViewGroup.LayoutParams layoutParams = fdVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            fdVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1671f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1666a != null) {
            this.f1666a.setVisible(z, false);
        }
        if (this.f1667b != null) {
            this.f1667b.setVisible(z, false);
        }
        if (this.f1668c != null) {
            this.f1668c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1666a && !this.f1669d) || ((drawable == this.f1667b && this.f1670e) || ((drawable == this.f1668c && this.f1669d) || super.verifyDrawable(drawable)));
    }
}
