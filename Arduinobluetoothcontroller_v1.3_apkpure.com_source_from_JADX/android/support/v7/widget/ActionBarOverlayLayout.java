package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.bk;
import android.support.v4.view.bl;
import android.support.v4.view.bv;
import android.support.v4.view.dy;
import android.support.v4.view.ep;
import android.support.v4.widget.at;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0303g;
import android.support.v7.view.menu.C0273y;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements bk, bv {
    static final int[] f1695a = new int[]{C0298b.actionBarSize, 16842841};
    private final Runnable f1696A;
    private final bl f1697B;
    private int f1698b;
    private int f1699c;
    private ContentFrameLayout f1700d;
    private ActionBarContainer f1701e;
    private bw f1702f;
    private Drawable f1703g;
    private boolean f1704h;
    private boolean f1705i;
    private boolean f1706j;
    private boolean f1707k;
    private boolean f1708l;
    private int f1709m;
    private int f1710n;
    private final Rect f1711o;
    private final Rect f1712p;
    private final Rect f1713q;
    private final Rect f1714r;
    private final Rect f1715s;
    private final Rect f1716t;
    private C0276i f1717u;
    private final int f1718v;
    private at f1719w;
    private dy f1720x;
    private final ep f1721y;
    private final Runnable f1722z;

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1699c = 0;
        this.f1711o = new Rect();
        this.f1712p = new Rect();
        this.f1713q = new Rect();
        this.f1714r = new Rect();
        this.f1715s = new Rect();
        this.f1716t = new Rect();
        this.f1718v = 600;
        this.f1721y = new C0354f(this);
        this.f1722z = new C0355g(this);
        this.f1696A = new C0357h(this);
        m3546a(context);
        this.f1697B = new bl(this);
    }

    private bw m3545a(View view) {
        if (view instanceof bw) {
            return (bw) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void m3546a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1695a);
        this.f1698b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1703g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1703g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1704h = z;
        this.f1719w = at.m2638a(context);
    }

    private boolean m3548a(float f, float f2) {
        this.f1719w.m2642a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1719w.m2649e() > this.f1701e.getHeight();
    }

    private boolean m3550a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0358j c0358j = (C0358j) view.getLayoutParams();
        if (z && c0358j.leftMargin != rect.left) {
            c0358j.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0358j.topMargin != rect.top) {
            c0358j.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0358j.rightMargin != rect.right) {
            c0358j.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0358j.bottomMargin == rect.bottom) {
            return z5;
        }
        c0358j.bottomMargin = rect.bottom;
        return true;
    }

    private void m3553k() {
        removeCallbacks(this.f1722z);
        removeCallbacks(this.f1696A);
        if (this.f1720x != null) {
            this.f1720x.m2391b();
        }
    }

    private void m3554l() {
        m3553k();
        postDelayed(this.f1722z, 600);
    }

    private void m3555m() {
        m3553k();
        postDelayed(this.f1696A, 600);
    }

    private void m3556n() {
        m3553k();
        this.f1722z.run();
    }

    private void m3557o() {
        m3553k();
        this.f1696A.run();
    }

    public C0358j m3558a(AttributeSet attributeSet) {
        return new C0358j(getContext(), attributeSet);
    }

    public void mo637a(int i) {
        m3563c();
        switch (i) {
            case 2:
                this.f1702f.mo794f();
                return;
            case 5:
                this.f1702f.mo795g();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void mo638a(Menu menu, C0273y c0273y) {
        m3563c();
        this.f1702f.mo781a(menu, c0273y);
    }

    public boolean m3561a() {
        return this.f1705i;
    }

    protected C0358j m3562b() {
        return new C0358j(-1, -1);
    }

    void m3563c() {
        if (this.f1700d == null) {
            this.f1700d = (ContentFrameLayout) findViewById(C0303g.action_bar_activity_content);
            this.f1701e = (ActionBarContainer) findViewById(C0303g.action_bar_container);
            this.f1702f = m3545a(findViewById(C0303g.action_bar));
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0358j;
    }

    public boolean mo639d() {
        m3563c();
        return this.f1702f.mo796h();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1703g != null && !this.f1704h) {
            int bottom = this.f1701e.getVisibility() == 0 ? (int) ((((float) this.f1701e.getBottom()) + bv.m2037n(this.f1701e)) + 0.5f) : 0;
            this.f1703g.setBounds(0, bottom, getWidth(), this.f1703g.getIntrinsicHeight() + bottom);
            this.f1703g.draw(canvas);
        }
    }

    public boolean mo640e() {
        m3563c();
        return this.f1702f.mo797i();
    }

    public boolean mo641f() {
        m3563c();
        return this.f1702f.mo798j();
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m3563c();
        if ((bv.m2041r(this) & 256) != 0) {
            a = m3550a(this.f1701e, rect, true, true, false, true);
            this.f1714r.set(rect);
            gv.m4890a(this, this.f1714r, this.f1711o);
        } else {
            a = m3550a(this.f1701e, rect, true, true, false, true);
            this.f1714r.set(rect);
            gv.m4890a(this, this.f1714r, this.f1711o);
        }
        if (!this.f1712p.equals(this.f1711o)) {
            this.f1712p.set(this.f1711o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean mo642g() {
        m3563c();
        return this.f1702f.mo799k();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3562b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3558a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0358j(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.f1701e != null ? -((int) bv.m2037n(this.f1701e)) : 0;
    }

    public int getNestedScrollAxes() {
        return this.f1697B.m1981a();
    }

    public CharSequence getTitle() {
        m3563c();
        return this.f1702f.mo793e();
    }

    public boolean mo643h() {
        m3563c();
        return this.f1702f.mo800l();
    }

    public void mo644i() {
        m3563c();
        this.f1702f.mo801m();
    }

    public void mo645j() {
        m3563c();
        this.f1702f.mo802n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m3546a(getContext());
        bv.m2042s(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3553k();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0358j c0358j = (C0358j) childAt.getLayoutParams();
                int i6 = c0358j.leftMargin + paddingLeft;
                paddingRight = c0358j.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        m3563c();
        measureChildWithMargins(this.f1701e, i, 0, i2, 0);
        C0358j c0358j = (C0358j) this.f1701e.getLayoutParams();
        int max = Math.max(0, (this.f1701e.getMeasuredWidth() + c0358j.leftMargin) + c0358j.rightMargin);
        int max2 = Math.max(0, c0358j.bottomMargin + (this.f1701e.getMeasuredHeight() + c0358j.topMargin));
        int a = gv.m4889a(0, bv.m2033j(this.f1701e));
        Object obj = (bv.m2041r(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.f1698b;
            if (this.f1706j && this.f1701e.getTabContainer() != null) {
                i3 += this.f1698b;
            }
        } else {
            i3 = this.f1701e.getVisibility() != 8 ? this.f1701e.getMeasuredHeight() : 0;
        }
        this.f1713q.set(this.f1711o);
        this.f1715s.set(this.f1714r);
        Rect rect;
        Rect rect2;
        if (this.f1705i || obj != null) {
            rect = this.f1715s;
            rect.top = i3 + rect.top;
            rect2 = this.f1715s;
            rect2.bottom += 0;
        } else {
            rect = this.f1713q;
            rect.top = i3 + rect.top;
            rect2 = this.f1713q;
            rect2.bottom += 0;
        }
        m3550a(this.f1700d, this.f1713q, true, true, true, true);
        if (!this.f1716t.equals(this.f1715s)) {
            this.f1716t.set(this.f1715s);
            this.f1700d.m3005a(this.f1715s);
        }
        measureChildWithMargins(this.f1700d, i, 0, i2, 0);
        c0358j = (C0358j) this.f1700d.getLayoutParams();
        int max3 = Math.max(max, (this.f1700d.getMeasuredWidth() + c0358j.leftMargin) + c0358j.rightMargin);
        i3 = Math.max(max2, c0358j.bottomMargin + (this.f1700d.getMeasuredHeight() + c0358j.topMargin));
        int a2 = gv.m4889a(a, bv.m2033j(this.f1700d));
        setMeasuredDimension(bv.m1999a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), bv.m1999a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1707k || !z) {
            return false;
        }
        if (m3548a(f, f2)) {
            m3557o();
        } else {
            m3556n();
        }
        this.f1708l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1709m += i2;
        setActionBarHideOffset(this.f1709m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1697B.m1983a(view, view2, i);
        this.f1709m = getActionBarHideOffset();
        m3553k();
        if (this.f1717u != null) {
            this.f1717u.mo551n();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.f1701e.getVisibility() != 0) ? false : this.f1707k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1707k && !this.f1708l) {
            if (this.f1709m <= this.f1701e.getHeight()) {
                m3554l();
            } else {
                m3555m();
            }
        }
        if (this.f1717u != null) {
            this.f1717u.mo552o();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m3563c();
        int i2 = this.f1710n ^ i;
        this.f1710n = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.f1717u != null) {
            C0276i c0276i = this.f1717u;
            if (z3) {
                z = false;
            }
            c0276i.mo548g(z);
            if (z2 || !z3) {
                this.f1717u.mo549l();
            } else {
                this.f1717u.mo550m();
            }
        }
        if ((i2 & 256) != 0 && this.f1717u != null) {
            bv.m2042s(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1699c = i;
        if (this.f1717u != null) {
            this.f1717u.mo545b(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m3553k();
        bv.m2015b(this.f1701e, (float) (-Math.max(0, Math.min(i, this.f1701e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(C0276i c0276i) {
        this.f1717u = c0276i;
        if (getWindowToken() != null) {
            this.f1717u.mo545b(this.f1699c);
            if (this.f1710n != 0) {
                onWindowSystemUiVisibilityChanged(this.f1710n);
                bv.m2042s(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1706j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1707k) {
            this.f1707k = z;
            if (!z) {
                m3553k();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        m3563c();
        this.f1702f.mo777a(i);
    }

    public void setIcon(Drawable drawable) {
        m3563c();
        this.f1702f.mo778a(drawable);
    }

    public void setLogo(int i) {
        m3563c();
        this.f1702f.mo786b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f1705i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1704h = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        m3563c();
        this.f1702f.mo782a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m3563c();
        this.f1702f.mo783a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
