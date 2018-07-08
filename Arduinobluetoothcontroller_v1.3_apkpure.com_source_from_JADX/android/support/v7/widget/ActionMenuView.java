package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0030z;
import android.support.v7.view.menu.C0269j;
import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0325k;
import android.support.v7.view.menu.C0329i;
import android.support.v7.view.menu.C0337m;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends cq implements C0325k, C0030z {
    private C0329i f1723a;
    private Context f1724b;
    private int f1725c;
    private boolean f1726d;
    private C0359k f1727e;
    private C0273y f1728f;
    private C0269j f1729g;
    private boolean f1730h;
    private int f1731i;
    private int f1732j;
    private int f1733k;
    private C0356y f1734l;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1732j = (int) (56.0f * f);
        this.f1733k = (int) (f * 4.0f);
        this.f1724b = context;
        this.f1725c = 0;
    }

    static int m3571a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        C0370w c0370w = (C0370w) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m3306b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0370w.f2453a && z2) {
            z = true;
        }
        c0370w.f2456d = z;
        c0370w.f2454b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void m3574c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1732j;
        size = i3 % this.f1732j;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        Object obj;
        int i6 = this.f1732j + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj2 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1733k, 0, this.f1733k, 0);
                }
                C0370w c0370w = (C0370w) childAt.getLayoutParams();
                c0370w.f2458f = false;
                c0370w.f2455c = 0;
                c0370w.f2454b = 0;
                c0370w.f2456d = false;
                c0370w.leftMargin = 0;
                c0370w.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m3306b();
                c0370w.f2457e = z2;
                int a = m3571a(childAt, i6, c0370w.f2453a ? 1 : i4, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                paddingLeft = c0370w.f2456d ? i9 + 1 : i9;
                obj = c0370w.f2453a ? 1 : obj2;
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj2 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj2 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        Object obj3 = (obj2 == null || paddingLeft != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0370w = (C0370w) getChildAt(i15).getLayoutParams();
                if (!c0370w.f2456d) {
                    size = i4;
                    i4 = i5;
                } else if (c0370w.f2454b < i5) {
                    i4 = c0370w.f2454b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (c0370w.f2454b == i5) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i5;
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                c0370w = (C0370w) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj3 != null && c0370w.f2457e && i4 == 1) {
                        childAt2.setPadding(this.f1733k + i6, 0, this.f1733k, 0);
                    }
                    c0370w.f2454b++;
                    c0370w.f2458f = true;
                    size = i4 - 1;
                } else if (c0370w.f2454b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj2 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0370w) getChildAt(0).getLayoutParams()).f2457e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0370w) getChildAt(childCount - 1).getLayoutParams()).f2457e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj3 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj3;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0370w = (C0370w) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0370w.f2455c = paddingLeft;
                                c0370w.f2458f = true;
                                if (i4 == 0 && !c0370w.f2457e) {
                                    c0370w.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0370w.f2453a) {
                                if (i4 != 0) {
                                    c0370w.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0370w.rightMargin = paddingLeft / 2;
                                }
                                obj = obj3;
                            } else {
                                c0370w.f2455c = paddingLeft;
                                c0370w.f2458f = true;
                                c0370w.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj3 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0370w = (C0370w) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0370w.f2455c = paddingLeft;
                        c0370w.f2458f = true;
                        c0370w.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0370w.f2453a) {
                        if (i4 != 0) {
                            c0370w.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0370w.rightMargin = paddingLeft / 2;
                        }
                        obj = obj3;
                    } else {
                        c0370w.f2455c = paddingLeft;
                        c0370w.f2458f = true;
                        c0370w.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj3;
                }
                i4++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0370w = (C0370w) childAt.getLayoutParams();
                if (c0370w.f2458f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0370w.f2455c + (c0370w.f2454b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    public C0370w m3575a(AttributeSet attributeSet) {
        return new C0370w(getContext(), attributeSet);
    }

    protected C0370w m3576a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m3584b();
        }
        C0370w c0370w = layoutParams instanceof C0370w ? new C0370w((C0370w) layoutParams) : new C0370w(layoutParams);
        if (c0370w.h > 0) {
            return c0370w;
        }
        c0370w.h = 16;
        return c0370w;
    }

    public void mo34a(C0329i c0329i) {
        this.f1723a = c0329i;
    }

    public void m3578a(C0273y c0273y, C0269j c0269j) {
        this.f1728f = c0273y;
        this.f1729g = c0269j;
    }

    public boolean m3579a() {
        return this.f1726d;
    }

    protected boolean m3580a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0324u)) {
            z = 0 | ((C0324u) childAt).mo584d();
        }
        return (i <= 0 || !(childAt2 instanceof C0324u)) ? z : ((C0324u) childAt2).mo583c() | z;
    }

    public boolean mo585a(C0337m c0337m) {
        return this.f1723a.m3357a((MenuItem) c0337m, 0);
    }

    public /* synthetic */ cr mo648b(AttributeSet attributeSet) {
        return m3575a(attributeSet);
    }

    protected /* synthetic */ cr mo649b(LayoutParams layoutParams) {
        return m3576a(layoutParams);
    }

    protected C0370w m3584b() {
        C0370w c0370w = new C0370w(-2, -2);
        c0370w.h = 16;
        return c0370w;
    }

    public C0370w m3585c() {
        C0370w b = m3584b();
        b.f2453a = true;
        return b;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0370w);
    }

    public C0329i m3586d() {
        return this.f1723a;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean m3587e() {
        return this.f1727e != null && this.f1727e.m4923d();
    }

    public boolean m3588f() {
        return this.f1727e != null && this.f1727e.m4924e();
    }

    public boolean m3589g() {
        return this.f1727e != null && this.f1727e.m4927h();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3584b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3575a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3576a(layoutParams);
    }

    public Menu getMenu() {
        if (this.f1723a == null) {
            Context context = getContext();
            this.f1723a = new C0329i(context);
            this.f1723a.mo598a(new C0371x());
            this.f1727e = new C0359k(context);
            this.f1727e.m4921c(true);
            this.f1727e.m3424a(this.f1728f != null ? this.f1728f : new C0369v());
            this.f1723a.m3352a(this.f1727e, this.f1724b);
            this.f1727e.m4913a(this);
        }
        return this.f1723a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1727e.m4920c();
    }

    public int getPopupTheme() {
        return this.f1725c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean m3590h() {
        return this.f1727e != null && this.f1727e.m4928i();
    }

    public void m3591i() {
        if (this.f1727e != null) {
            this.f1727e.m4925f();
        }
    }

    protected /* synthetic */ cr mo654j() {
        return m3584b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1727e != null) {
            this.f1727e.mo612b(false);
            if (this.f1727e.m4927h()) {
                this.f1727e.m4924e();
                this.f1727e.m4923d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3591i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1730h) {
            int i5;
            int i6;
            C0370w c0370w;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = gv.m4891a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0370w = (C0370w) childAt.getLayoutParams();
                    if (c0370w.f2453a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m3580a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0370w.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0370w.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0370w.leftMargin) + c0370w.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m3580a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0370w = (C0370w) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0370w.f2453a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0370w.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0370w.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0370w = (C0370w) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0370w.f2453a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0370w.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0370w.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1730h;
        this.f1730h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1730h) {
            this.f1731i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1730h || this.f1723a == null || size == this.f1731i)) {
            this.f1731i = size;
            this.f1723a.m3363b(true);
        }
        int childCount = getChildCount();
        if (!this.f1730h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0370w c0370w = (C0370w) getChildAt(i3).getLayoutParams();
                c0370w.rightMargin = 0;
                c0370w.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m3574c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1727e.m4922d(z);
    }

    public void setOnMenuItemClickListener(C0356y c0356y) {
        this.f1734l = c0356y;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1727e.m4910a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f1726d = z;
    }

    public void setPopupTheme(int i) {
        if (this.f1725c != i) {
            this.f1725c = i;
            if (i == 0) {
                this.f1724b = getContext();
            } else {
                this.f1724b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0359k c0359k) {
        this.f1727e = c0359k;
        this.f1727e.m4913a(this);
    }
}
