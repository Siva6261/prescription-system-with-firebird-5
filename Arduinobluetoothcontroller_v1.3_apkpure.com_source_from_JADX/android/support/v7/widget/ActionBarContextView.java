package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.dy;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0303g;
import android.support.v7.p018b.C0305i;
import android.support.v7.p018b.C0308l;
import android.support.v7.view.C0277b;
import android.support.v7.view.menu.C0329i;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0348a {
    private CharSequence f1684g;
    private CharSequence f1685h;
    private View f1686i;
    private View f1687j;
    private LinearLayout f1688k;
    private TextView f1689l;
    private TextView f1690m;
    private int f1691n;
    private int f1692o;
    private boolean f1693p;
    private int f1694q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        gf a = gf.m4787a(context, attributeSet, C0308l.ActionMode, i, 0);
        setBackgroundDrawable(a.m4790a(C0308l.ActionMode_background));
        this.f1691n = a.m4803g(C0308l.ActionMode_titleTextStyle, 0);
        this.f1692o = a.m4803g(C0308l.ActionMode_subtitleTextStyle, 0);
        this.e = a.m4801f(C0308l.ActionMode_height, 0);
        this.f1694q = a.m4803g(C0308l.ActionMode_closeItemLayout, C0305i.abc_action_mode_close_item_material);
        a.m4791a();
    }

    private void m3528e() {
        int i = 8;
        Object obj = 1;
        if (this.f1688k == null) {
            LayoutInflater.from(getContext()).inflate(C0305i.abc_action_bar_title_item, this);
            this.f1688k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1689l = (TextView) this.f1688k.findViewById(C0303g.action_bar_title);
            this.f1690m = (TextView) this.f1688k.findViewById(C0303g.action_bar_subtitle);
            if (this.f1691n != 0) {
                this.f1689l.setTextAppearance(getContext(), this.f1691n);
            }
            if (this.f1692o != 0) {
                this.f1690m.setTextAppearance(getContext(), this.f1692o);
            }
        }
        this.f1689l.setText(this.f1684g);
        this.f1690m.setText(this.f1685h);
        Object obj2 = !TextUtils.isEmpty(this.f1684g) ? 1 : null;
        if (TextUtils.isEmpty(this.f1685h)) {
            obj = null;
        }
        this.f1690m.setVisibility(obj != null ? 0 : 8);
        LinearLayout linearLayout = this.f1688k;
        if (!(obj2 == null && obj == null)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f1688k.getParent() == null) {
            addView(this.f1688k);
        }
    }

    public /* bridge */ /* synthetic */ dy mo629a(int i, long j) {
        return super.mo629a(i, j);
    }

    public void m3530a(C0277b c0277b) {
        if (this.f1686i == null) {
            this.f1686i = LayoutInflater.from(getContext()).inflate(this.f1694q, this, false);
            addView(this.f1686i);
        } else if (this.f1686i.getParent() == null) {
            addView(this.f1686i);
        }
        this.f1686i.findViewById(C0303g.action_mode_close_button).setOnClickListener(new C0353e(this, c0277b));
        C0329i c0329i = (C0329i) c0277b.mo559b();
        if (this.d != null) {
            this.d.m4925f();
        }
        this.d = new C0359k(getContext());
        this.d.m4921c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c0329i.m3352a(this.d, this.b);
        this.c = (ActionMenuView) this.d.mo807a((ViewGroup) this);
        this.c.setBackgroundDrawable(null);
        addView(this.c, layoutParams);
    }

    public boolean mo630a() {
        return this.d != null ? this.d.m4923d() : false;
    }

    public void m3532b() {
        if (this.f1686i == null) {
            m3533c();
        }
    }

    public void m3533c() {
        removeAllViews();
        this.f1687j = null;
        this.c = null;
    }

    public boolean m3534d() {
        return this.f1693p;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1685h;
    }

    public CharSequence getTitle() {
        return this.f1684g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m4924e();
            this.d.m4926g();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1684g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = gv.m4891a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1686i == null || this.f1686i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1686i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0348a.m3521a(paddingRight, i5, a);
            i5 = C0348a.m3521a(m3525a(this.f1686i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f1688k == null || this.f1687j != null || this.f1688k.getVisibility() == 8)) {
            i5 += m3525a(this.f1688k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1687j != null) {
            int a2 = m3525a(this.f1687j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m3525a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f1686i != null) {
                a = m3524a(this.f1686i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1686i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m3524a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1688k != null && this.f1687j == null) {
                if (this.f1693p) {
                    this.f1688k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1688k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1688k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m3524a(this.f1688k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1687j != null) {
                LayoutParams layoutParams = this.f1687j.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.f1687j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f1687j != null) {
            removeView(this.f1687j);
        }
        this.f1687j = view;
        if (!(view == null || this.f1688k == null)) {
            removeView(this.f1688k);
            this.f1688k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1685h = charSequence;
        m3528e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1684g = charSequence;
        m3528e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1693p) {
            requestLayout();
        }
        this.f1693p = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
