package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.design.C0027h;
import android.support.design.C0028i;
import android.support.v4.view.bv;
import android.support.v4.view.es;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@ac(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    boolean f189a;
    private int f190b;
    private int f191c;
    private int f192d;
    private float f193e;
    private int f194f;
    private es f195g;
    private final List f196h;

    public class Behavior extends bc {
        private int f176a;
        private boolean f177b;
        private boolean f178c;
        private ci f179d;
        private int f180e = -1;
        private boolean f181f;
        private float f182g;
        private WeakReference f183h;
        private C0037e f184i;

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private View m262a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return childAt;
                }
            }
            return null;
        }

        private int m263b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                C0040h c0040h = (C0040h) childAt.getLayoutParams();
                Interpolator b = c0040h.m782b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (b == null) {
                    return i;
                } else {
                    int height;
                    i2 = c0040h.m781a();
                    if ((i2 & 1) != 0) {
                        height = (c0040h.bottomMargin + (childAt.getHeight() + c0040h.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= bv.m2039p(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (bv.m2043t(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        private void m264b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int a = mo38a();
            if (a != i) {
                if (this.f179d == null) {
                    this.f179d = db.m769a();
                    this.f179d.m711a(C0031a.f306e);
                    this.f179d.m710a(new C0036d(this, coordinatorLayout, appBarLayout));
                } else {
                    this.f179d.m715e();
                }
                this.f179d.m708a(Math.round(((((float) Math.abs(a - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.f179d.m709a(a, i);
                this.f179d.m706a();
            } else if (this.f179d != null && this.f179d.m712b()) {
                this.f179d.m715e();
            }
        }

        private void m265c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = mo38a();
            View a2 = m262a(appBarLayout, a);
            if (a2 != null) {
                C0040h c0040h = (C0040h) a2.getLayoutParams();
                if ((c0040h.m781a() & 17) == 17) {
                    int i = -a2.getTop();
                    int i2 = -a2.getBottom();
                    int p = (c0040h.m781a() & 2) == 2 ? bv.m2039p(a2) + i2 : i2;
                    if (a >= (p + i) / 2) {
                        p = i;
                    }
                    m264b(coordinatorLayout, appBarLayout, bf.m609a(p, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        private void m266d(AppBarLayout appBarLayout) {
            List h = appBarLayout.f196h;
            int size = h.size();
            for (int i = 0; i < size; i++) {
                C0041i c0041i = (C0041i) h.get(i);
                if (c0041i != null) {
                    c0041i.mo159a(appBarLayout, mo49b());
                }
            }
        }

        int mo38a() {
            return mo49b() + this.f176a;
        }

        int m268a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = mo38a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.f176a = 0;
                return 0;
            }
            int a2 = bf.m609a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.m322c() ? m263b(appBarLayout, a2) : a2;
            boolean a3 = mo46a(b);
            a -= a2;
            this.f176a = a2 - b;
            if (!a3 && appBarLayout.m322c()) {
                coordinatorLayout.m421c((View) appBarLayout);
            }
            m266d(appBarLayout);
            return a;
        }

        /* synthetic */ int mo40a(View view) {
            return m294c((AppBarLayout) view);
        }

        void m271a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m265c(coordinatorLayout, appBarLayout);
        }

        public void m272a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof C0038f) {
                C0038f c0038f = (C0038f) parcelable;
                super.mo42a(coordinatorLayout, (View) appBarLayout, c0038f.getSuperState());
                this.f180e = c0038f.f458a;
                this.f182g = c0038f.f459b;
                this.f181f = c0038f.f460c;
                return;
            }
            super.mo42a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f180e = -1;
        }

        public void m273a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f178c) {
                m265c(coordinatorLayout, appBarLayout);
            }
            this.f177b = false;
            this.f178c = false;
            this.f183h = new WeakReference(view);
        }

        public void m274a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                m257b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f177b = true;
                return;
            }
            this.f177b = false;
        }

        public void m275a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            if (i2 != 0 && !this.f177b) {
                int i3;
                int b;
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    b = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    b = 0;
                }
                iArr[1] = m257b(coordinatorLayout, appBarLayout, i2, i3, b);
            }
        }

        boolean m282a(AppBarLayout appBarLayout) {
            if (this.f184i != null) {
                return this.f184i.m776a(appBarLayout);
            }
            if (this.f183h == null) {
                return true;
            }
            View view = (View) this.f183h.get();
            return (view == null || !view.isShown() || bv.m2018b(view, -1)) ? false : true;
        }

        public boolean m283a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.mo35a(coordinatorLayout, appBarLayout, i);
            int e = appBarLayout.getPendingAction();
            if (e != 0) {
                int i2 = (e & 4) != 0 ? 1 : 0;
                if ((e & 2) != 0) {
                    e = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        m264b(coordinatorLayout, appBarLayout, e);
                    } else {
                        a_(coordinatorLayout, appBarLayout, e);
                    }
                } else if ((e & 1) != 0) {
                    if (i2 != 0) {
                        m264b(coordinatorLayout, appBarLayout, 0);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f180e >= 0) {
                View childAt = appBarLayout.getChildAt(this.f180e);
                e = -childAt.getBottom();
                mo46a(this.f181f ? bv.m2039p(childAt) + e : Math.round(((float) childAt.getHeight()) * this.f182g) + e);
            }
            appBarLayout.m326e();
            this.f180e = -1;
            mo46a(bf.m609a(mo49b(), -appBarLayout.getTotalScrollRange(), 0));
            m266d(appBarLayout);
            return a;
        }

        public boolean m284a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = m255a(coordinatorLayout, (View) appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (mo38a() < r1) {
                    m264b(coordinatorLayout, appBarLayout, r1);
                    z2 = true;
                }
            } else {
                r1 = -appBarLayout.getUpNestedPreScrollRange();
                if (mo38a() > r1) {
                    m264b(coordinatorLayout, appBarLayout, r1);
                    z2 = true;
                }
            }
            this.f178c = z2;
            return z2;
        }

        public boolean m285a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.m324d() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f179d != null) {
                this.f179d.m715e();
            }
            this.f183h = null;
            return z;
        }

        public /* bridge */ /* synthetic */ int mo49b() {
            return super.mo49b();
        }

        int m290b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        public Parcelable m292b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable b = super.mo51b(coordinatorLayout, appBarLayout);
            int b2 = mo49b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    C0038f c0038f = new C0038f(b);
                    c0038f.f458a = i;
                    if (bottom == bv.m2039p(childAt)) {
                        z = true;
                    }
                    c0038f.f460c = z;
                    c0038f.f459b = ((float) bottom) / ((float) childAt.getHeight());
                    return c0038f;
                }
            }
            return b;
        }

        int m294c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* synthetic */ boolean mo52c(View view) {
            return m282a((AppBarLayout) view);
        }
    }

    public class ScrollingViewBehavior extends be {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.ScrollingViewBehavior_Params);
            m302b(obtainStyledAttributes.getDimensionPixelSize(C0028i.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int m305a(AppBarLayout appBarLayout) {
            ab b = ((ae) appBarLayout.getLayoutParams()).m508b();
            return b instanceof Behavior ? ((Behavior) b).mo38a() : 0;
        }

        private void m306e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ab b = ((ae) view2.getLayoutParams()).m508b();
            if (b instanceof Behavior) {
                Behavior behavior = (Behavior) b;
                behavior.mo38a();
                view.offsetTopAndBottom(((behavior.f176a + (view2.getBottom() - view.getTop())) + m298a()) - m304c(view2));
            }
        }

        float mo55a(View view) {
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int b = appBarLayout.getDownNestedPreScrollRange();
            int a = m305a(appBarLayout);
            if (b != 0 && totalScrollRange + a <= b) {
                return 0.0f;
            }
            totalScrollRange -= b;
            return totalScrollRange != 0 ? 1.0f + (((float) a) / ((float) totalScrollRange)) : 0.0f;
        }

        View mo56a(List list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        public /* bridge */ /* synthetic */ boolean mo35a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo35a(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean mo53a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo53a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ int mo49b() {
            return super.mo49b();
        }

        int mo57b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.mo57b(view);
        }

        public boolean mo58b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean mo59c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m306e(coordinatorLayout, view, view2);
            return false;
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f190b = -1;
        this.f191c = -1;
        this.f192d = -1;
        this.f194f = 0;
        setOrientation(1);
        ch.m705a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.AppBarLayout, 0, C0027h.Widget_Design_AppBarLayout);
        this.f193e = (float) obtainStyledAttributes.getDimensionPixelSize(C0028i.AppBarLayout_elevation, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0028i.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(C0028i.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(C0028i.AppBarLayout_expanded, false));
        }
        obtainStyledAttributes.recycle();
        db.m770a(this);
        this.f196h = new ArrayList();
        bv.m2024d((View) this, this.f193e);
        bv.m2009a((View) this, new C0035c(this));
    }

    private es m317a(es esVar) {
        es esVar2 = null;
        if (bv.m2043t(this)) {
            esVar2 = esVar;
        }
        if (esVar2 != this.f195g) {
            this.f195g = esVar2;
            m320b();
        }
        return esVar;
    }

    private void m320b() {
        this.f190b = -1;
        this.f191c = -1;
        this.f192d = -1;
    }

    private boolean m322c() {
        return this.f189a;
    }

    private boolean m324d() {
        return getTotalScrollRange() != 0;
    }

    private void m326e() {
        this.f194f = 0;
    }

    private int getDownNestedPreScrollRange() {
        if (this.f191c != -1) {
            return this.f191c;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C0040h c0040h = (C0040h) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0040h.f461a;
            if ((i3 & 5) == 5) {
                i = (c0040h.bottomMargin + c0040h.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + bv.m2039p(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - bv.m2039p(childAt)) : i + measuredHeight;
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2 - getTopInset());
        this.f191c = i;
        return i;
    }

    private int getDownNestedScrollRange() {
        if (this.f192d != -1) {
            return this.f192d;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0040h c0040h = (C0040h) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (c0040h.topMargin + c0040h.bottomMargin);
            i = c0040h.f461a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (bv.m2039p(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.f192d = i;
        return i;
    }

    private int getPendingAction() {
        return this.f194f;
    }

    private int getTopInset() {
        return this.f195g != null ? this.f195g.mo416b() : 0;
    }

    private int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    protected C0040h m331a() {
        return new C0040h(-1, -2);
    }

    public C0040h m332a(AttributeSet attributeSet) {
        return new C0040h(getContext(), attributeSet);
    }

    protected C0040h m333a(LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new C0040h((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0040h((MarginLayoutParams) layoutParams) : new C0040h(layoutParams);
    }

    public void m334a(C0041i c0041i) {
        if (c0041i != null && !this.f196h.contains(c0041i)) {
            this.f196h.add(c0041i);
        }
    }

    public void m335a(boolean z, boolean z2) {
        this.f194f = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    public void m336b(C0041i c0041i) {
        if (c0041i != null) {
            this.f196h.remove(c0041i);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0040h;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m331a();
    }

    protected /* synthetic */ LinearLayout.LayoutParams m5859generateDefaultLayoutParams() {
        return m331a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m332a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m333a(layoutParams);
    }

    public /* synthetic */ LinearLayout.LayoutParams m5860generateLayoutParams(AttributeSet attributeSet) {
        return m332a(attributeSet);
    }

    protected /* synthetic */ LinearLayout.LayoutParams m5861generateLayoutParams(LayoutParams layoutParams) {
        return m333a(layoutParams);
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int p = bv.m2039p(this);
        if (p != 0) {
            return topInset + (p * 2);
        }
        p = getChildCount();
        return p >= 1 ? topInset + (bv.m2039p(getChildAt(p - 1)) * 2) : 0;
    }

    public float getTargetElevation() {
        return this.f193e;
    }

    public final int getTotalScrollRange() {
        if (this.f190b != -1) {
            return this.f190b;
        }
        int p;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0040h c0040h = (C0040h) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0040h.f461a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += c0040h.bottomMargin + (measuredHeight + c0040h.topMargin);
            if ((i3 & 2) != 0) {
                p = i - bv.m2039p(childAt);
                break;
            }
        }
        p = i;
        p = Math.max(0, p - getTopInset());
        this.f190b = p;
        return p;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m320b();
        this.f189a = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((C0040h) getChildAt(i5).getLayoutParams()).m782b() != null) {
                this.f189a = true;
                return;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m320b();
    }

    public void setExpanded(boolean z) {
        m335a(z, bv.m1994A(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setTargetElevation(float f) {
        this.f193e = f;
    }
}
