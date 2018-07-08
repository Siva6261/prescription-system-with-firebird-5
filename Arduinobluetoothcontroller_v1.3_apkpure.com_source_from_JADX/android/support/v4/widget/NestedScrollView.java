package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.az;
import android.support.v4.view.bi;
import android.support.v4.view.bj;
import android.support.v4.view.bk;
import android.support.v4.view.bl;
import android.support.v4.view.bo;
import android.support.v4.view.bq;
import android.support.v4.view.bv;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.List;

public class NestedScrollView extends FrameLayout implements bi, bk, bo {
    private static final ad f1042v = new ad();
    private static final int[] f1043w = new int[]{16843130};
    private ae f1044A;
    private long f1045a;
    private final Rect f1046b;
    private at f1047c;
    private C0258s f1048d;
    private C0258s f1049e;
    private int f1050f;
    private boolean f1051g;
    private boolean f1052h;
    private View f1053i;
    private boolean f1054j;
    private VelocityTracker f1055k;
    private boolean f1056l;
    private boolean f1057m;
    private int f1058n;
    private int f1059o;
    private int f1060p;
    private int f1061q;
    private final int[] f1062r;
    private final int[] f1063s;
    private int f1064t;
    private af f1065u;
    private final bl f1066x;
    private final bj f1067y;
    private float f1068z;

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1046b = new Rect();
        this.f1051g = true;
        this.f1052h = false;
        this.f1053i = null;
        this.f1054j = false;
        this.f1057m = true;
        this.f1061q = -1;
        this.f1062r = new int[2];
        this.f1063s = new int[2];
        m2532a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1043w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1066x = new bl(this);
        this.f1067y = new bj(this);
        setNestedScrollingEnabled(true);
        bv.m2008a((View) this, f1042v);
    }

    private View m2531a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    private void m2532a() {
        this.f1047c = at.m2639a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1058n = viewConfiguration.getScaledTouchSlop();
        this.f1059o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1060p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void m2533a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (az.m1907b(motionEvent, action) == this.f1061q) {
            action = action == 0 ? 1 : 0;
            this.f1050f = (int) az.m1910d(motionEvent, action);
            this.f1061q = az.m1907b(motionEvent, action);
            if (this.f1055k != null) {
                this.f1055k.clear();
            }
        }
    }

    private boolean m2534a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2531a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2546e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean m2535a(Rect rect, boolean z) {
        int a = m2550a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2551a(0, a);
            }
        }
        return z2;
    }

    private boolean m2536a(View view) {
        return !m2537a(view, 0, getHeight());
    }

    private boolean m2537a(View view, int i, int i2) {
        view.getDrawingRect(this.f1046b);
        offsetDescendantRectToMyCoords(view, this.f1046b);
        return this.f1046b.bottom + i >= getScrollY() && this.f1046b.top - i <= getScrollY() + i2;
    }

    private static boolean m2538a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2538a((View) parent, view2);
        return z;
    }

    private static int m2539b(int i, int i2, int i3) {
        return (i2 >= i3 || i < 0) ? 0 : i2 + i > i3 ? i3 - i2 : i;
    }

    private void m2540b(View view) {
        view.getDrawingRect(this.f1046b);
        offsetDescendantRectToMyCoords(view, this.f1046b);
        int a = m2550a(this.f1046b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2541b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
    }

    private void m2542c() {
        if (this.f1055k == null) {
            this.f1055k = VelocityTracker.obtain();
        } else {
            this.f1055k.clear();
        }
    }

    private boolean m2543c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void m2544d() {
        if (this.f1055k == null) {
            this.f1055k = VelocityTracker.obtain();
        }
    }

    private void m2545e() {
        if (this.f1055k != null) {
            this.f1055k.recycle();
            this.f1055k = null;
        }
    }

    private void m2546e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1057m) {
            m2551a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void m2547f() {
        this.f1054j = false;
        m2545e();
        stopNestedScroll();
        if (this.f1048d != null) {
            this.f1048d.m2790c();
            this.f1049e.m2790c();
        }
    }

    private void m2548f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m2558d(i);
            }
        }
    }

    private void m2549g() {
        if (bv.m2000a(this) == 2) {
            this.f1048d = null;
            this.f1049e = null;
        } else if (this.f1048d == null) {
            Context context = getContext();
            this.f1048d = new C0258s(context);
            this.f1049e = new C0258s(context);
        }
    }

    private int getScrollRange() {
        return getChildCount() > 0 ? Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())) : 0;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1068z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f1068z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1068z;
    }

    protected int m2550a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            scrollY = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            scrollY = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return scrollY;
    }

    public final void m2551a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1045a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1047c.m2640a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                bv.m2023d(this);
            } else {
                if (!this.f1047c.m2644a()) {
                    this.f1047c.m2652h();
                }
                scrollBy(i, i2);
            }
            this.f1045a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean m2552a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f1046b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f1046b.top + height > childAt.getBottom()) {
                    this.f1046b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1046b.top = getScrollY() - height;
            if (this.f1046b.top < 0) {
                this.f1046b.top = 0;
            }
        }
        this.f1046b.bottom = this.f1046b.top + height;
        return m2534a(i, this.f1046b.top, this.f1046b.bottom);
    }

    boolean m2553a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = bv.m2000a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        a = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < a) {
            z3 = true;
            i13 = a;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f1047c.m2645a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        return z2 || z3;
    }

    public boolean m2554a(KeyEvent keyEvent) {
        int i = 33;
        this.f1046b.setEmpty();
        if (m2541b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    return !keyEvent.isAltPressed() ? m2557c(33) : m2556b(33);
                case 20:
                    return !keyEvent.isAltPressed() ? m2557c(130) : m2556b(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2552a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            boolean z = (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) ? false : true;
            return z;
        }
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void m2555b(int i, int i2) {
        m2551a(i - getScrollX(), i2 - getScrollY());
    }

    public boolean m2556b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f1046b.top = 0;
        this.f1046b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f1046b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f1046b.top = this.f1046b.bottom - height;
            }
        }
        return m2534a(i, this.f1046b.top, this.f1046b.bottom);
    }

    public boolean m2557c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2537a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2546e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1046b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1046b);
            m2546e(m2550a(this.f1046b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2536a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.f1047c.m2651g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f1047c.m2646b();
            int c = this.f1047c.m2647c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = bv.m2000a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m2553a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m2549g();
                    if (c <= 0 && scrollY > 0) {
                        this.f1048d.m2787a((int) this.f1047c.m2650f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f1049e.m2787a((int) this.f1047c.m2650f());
                    }
                }
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > height ? bottom + (scrollY - height) : bottom;
    }

    public void m2558d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f1047c.m2643a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            bv.m2023d(this);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2554a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1067y.m1975a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1067y.m1974a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1067y.m1978a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1067y.m1977a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1048d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f1048d.m2784a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1048d.m2783a(width, getHeight());
                if (this.f1048d.m2788a(canvas)) {
                    bv.m2023d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1049e.m2784a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f1049e.m2783a(width, height);
                if (this.f1049e.m2788a(canvas)) {
                    bv.m2023d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public int getNestedScrollAxes() {
        return this.f1066x.m1981a();
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.f1067y.m1979b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1067y.m1973a();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void onAttachedToWindow() {
        this.f1052h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((az.m1911d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f1054j) {
                    return false;
                }
                float e = az.m1912e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1054j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m2543c((int) motionEvent.getX(), action)) {
                    this.f1054j = false;
                    m2545e();
                    break;
                }
                this.f1050f = action;
                this.f1061q = az.m1907b(motionEvent, 0);
                m2542c();
                this.f1055k.addMovement(motionEvent);
                this.f1047c.m2651g();
                if (!this.f1047c.m2644a()) {
                    z = true;
                }
                this.f1054j = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.f1054j = false;
                this.f1061q = -1;
                m2545e();
                if (this.f1047c.m2645a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    bv.m2023d(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.f1061q;
                if (action != -1) {
                    int a = az.m1905a(motionEvent, action);
                    if (a != -1) {
                        action = (int) az.m1910d(motionEvent, a);
                        if (Math.abs(action - this.f1050f) > this.f1058n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1054j = true;
                            this.f1050f = action;
                            m2544d();
                            this.f1055k.addMovement(motionEvent);
                            this.f1064t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m2533a(motionEvent);
                break;
        }
        return this.f1054j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1051g = false;
        if (this.f1053i != null && m2538a(this.f1053i, (View) this)) {
            m2540b(this.f1053i);
        }
        this.f1053i = null;
        if (!this.f1052h) {
            if (this.f1065u != null) {
                scrollTo(getScrollX(), this.f1065u.f1087a);
                this.f1065u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1052h = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1056l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2548f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1066x.m1983a(view, view2, i);
        startNestedScroll(2);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || m2536a(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        af afVar = (af) parcelable;
        super.onRestoreInstanceState(afVar.getSuperState());
        this.f1065u = afVar;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable afVar = new af(super.onSaveInstanceState());
        afVar.f1087a = getScrollY();
        return afVar;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1044A != null) {
            this.f1044A.mo568a(this, i, i2, i3, i4);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2537a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1046b);
            offsetDescendantRectToMyCoords(findFocus, this.f1046b);
            m2546e(m2550a(this.f1046b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f1066x.m1982a(view);
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2544d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = az.m1904a(motionEvent);
        if (a == 0) {
            this.f1064t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f1064t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f1047c.m2644a();
                    this.f1054j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f1047c.m2644a()) {
                        this.f1047c.m2652h();
                    }
                    this.f1050f = (int) motionEvent.getY();
                    this.f1061q = az.m1907b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.f1054j) {
                    VelocityTracker velocityTracker = this.f1055k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1060p);
                    a = (int) bq.m1985b(velocityTracker, this.f1061q);
                    if (Math.abs(a) > this.f1059o) {
                        m2548f(-a);
                    } else if (this.f1047c.m2645a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        bv.m2023d(this);
                    }
                }
                this.f1061q = -1;
                m2547f();
                break;
            case 2:
                int a2 = az.m1905a(motionEvent, this.f1061q);
                if (a2 != -1) {
                    int i;
                    int d = (int) az.m1910d(motionEvent, a2);
                    a = this.f1050f - d;
                    if (dispatchNestedPreScroll(0, a, this.f1063s, this.f1062r)) {
                        a -= this.f1063s[1];
                        obtain.offsetLocation(0.0f, (float) this.f1062r[1]);
                        this.f1064t += this.f1062r[1];
                    }
                    if (this.f1054j || Math.abs(a) <= this.f1058n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1054j = true;
                        i = a > 0 ? a - this.f1058n : a + this.f1058n;
                    }
                    if (this.f1054j) {
                        this.f1050f = d - this.f1062r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = bv.m2000a(this);
                        Object obj = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : null;
                        if (m2553a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1055k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1062r)) {
                            if (obj != null) {
                                m2549g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f1048d.m2786a(((float) i) / ((float) getHeight()), az.m1908c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f1049e.m2784a()) {
                                        this.f1049e.m2790c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f1049e.m2786a(((float) i) / ((float) getHeight()), 1.0f - (az.m1908c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f1048d.m2784a()) {
                                        this.f1048d.m2790c();
                                    }
                                }
                                if (!(this.f1048d == null || (this.f1048d.m2784a() && this.f1049e.m2784a()))) {
                                    bv.m2023d(this);
                                    break;
                                }
                            }
                        }
                        this.f1050f -= this.f1062r[1];
                        obtain.offsetLocation(0.0f, (float) this.f1062r[1]);
                        this.f1064t += this.f1062r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f1061q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f1054j && getChildCount() > 0 && this.f1047c.m2645a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    bv.m2023d(this);
                }
                this.f1061q = -1;
                m2547f();
                break;
            case 5:
                a = az.m1906b(motionEvent);
                this.f1050f = (int) az.m1910d(motionEvent, a);
                this.f1061q = az.m1907b(motionEvent, a);
                break;
            case 6:
                m2533a(motionEvent);
                this.f1050f = (int) az.m1910d(motionEvent, az.m1905a(motionEvent, this.f1061q));
                break;
        }
        if (this.f1055k != null) {
            this.f1055k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f1051g) {
            this.f1053i = view2;
        } else {
            m2540b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2535a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2545e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f1051g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2539b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2539b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1056l) {
            this.f1056l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1067y.m1972a(z);
    }

    public void setOnScrollChangeListener(ae aeVar) {
        this.f1044A = aeVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1057m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return this.f1067y.m1976a(i);
    }

    public void stopNestedScroll() {
        this.f1067y.m1980c();
    }
}
