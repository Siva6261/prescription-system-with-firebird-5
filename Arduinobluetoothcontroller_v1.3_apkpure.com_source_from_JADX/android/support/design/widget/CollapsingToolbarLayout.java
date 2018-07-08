package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.C0025f;
import android.support.design.C0027h;
import android.support.design.C0028i;
import android.support.v4.p008c.C0066a;
import android.support.v4.p010d.p011a.C0106a;
import android.support.v4.view.bv;
import android.support.v4.view.es;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout {
    private boolean f216a;
    private int f217b;
    private Toolbar f218c;
    private View f219d;
    private View f220e;
    private int f221f;
    private int f222g;
    private int f223h;
    private int f224i;
    private final Rect f225j;
    private final C0056u f226k;
    private boolean f227l;
    private boolean f228m;
    private Drawable f229n;
    private Drawable f230o;
    private int f231p;
    private boolean f232q;
    private ci f233r;
    private C0041i f234s;
    private int f235t;
    private es f236u;

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f216a = true;
        this.f225j = new Rect();
        ch.m705a(context);
        this.f226k = new C0056u(this);
        this.f226k.m933a(C0031a.f306e);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.CollapsingToolbarLayout, i, C0027h.Widget_Design_CollapsingToolbar);
        this.f226k.m940c(obtainStyledAttributes.getInt(C0028i.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f226k.m942d(obtainStyledAttributes.getInt(C0028i.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0028i.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f224i = dimensionPixelSize;
        this.f223h = dimensionPixelSize;
        this.f222g = dimensionPixelSize;
        this.f221f = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(C0028i.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f221f = obtainStyledAttributes.getDimensionPixelSize(C0028i.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(C0028i.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f223h = obtainStyledAttributes.getDimensionPixelSize(C0028i.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(C0028i.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f222g = obtainStyledAttributes.getDimensionPixelSize(C0028i.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(C0028i.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f224i = obtainStyledAttributes.getDimensionPixelSize(C0028i.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f227l = obtainStyledAttributes.getBoolean(C0028i.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(C0028i.CollapsingToolbarLayout_title));
        this.f226k.m946f(C0027h.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f226k.m944e(C0027h.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(C0028i.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f226k.m946f(obtainStyledAttributes.getResourceId(C0028i.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(C0028i.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f226k.m944e(obtainStyledAttributes.getResourceId(C0028i.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        setContentScrim(obtainStyledAttributes.getDrawable(C0028i.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(C0028i.CollapsingToolbarLayout_statusBarScrim));
        this.f217b = obtainStyledAttributes.getResourceId(C0028i.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        bv.m2009a((View) this, new C0057v(this));
    }

    private es m372a(es esVar) {
        if (this.f236u != esVar) {
            this.f236u = esVar;
            requestLayout();
        }
        return esVar.mo420f();
    }

    private void m373a(int i) {
        m378b();
        if (this.f233r == null) {
            this.f233r = db.m769a();
            this.f233r.m708a(600);
            this.f233r.m711a(i > this.f231p ? C0031a.f304c : C0031a.f305d);
            this.f233r.m710a(new C0058w(this));
        } else if (this.f233r.m712b()) {
            this.f233r.m715e();
        }
        this.f233r.m709a(this.f231p, i);
        this.f233r.m706a();
    }

    private View m377b(View view) {
        CollapsingToolbarLayout parent = view.getParent();
        View view2 = view;
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        return view2;
    }

    private void m378b() {
        if (this.f216a) {
            this.f218c = null;
            this.f219d = null;
            if (this.f217b != -1) {
                this.f218c = (Toolbar) findViewById(this.f217b);
                if (this.f218c != null) {
                    this.f219d = m377b(this.f218c);
                }
            }
            if (this.f218c == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                toolbar = null;
                this.f218c = toolbar;
            }
            m381c();
            this.f216a = false;
        }
    }

    private static int m379c(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    private void m381c() {
        if (!(this.f227l || this.f220e == null)) {
            ViewParent parent = this.f220e.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f220e);
            }
        }
        if (this.f227l && this.f218c != null) {
            if (this.f220e == null) {
                this.f220e = new View(getContext());
            }
            if (this.f220e.getParent() == null) {
                this.f218c.addView(this.f220e, -1, -1);
            }
        }
    }

    private static da m382d(View view) {
        da daVar = (da) view.getTag(C0025f.view_offset_helper);
        if (daVar != null) {
            return daVar;
        }
        daVar = new da(view);
        view.setTag(C0025f.view_offset_helper, daVar);
        return daVar;
    }

    private void setScrimAlpha(int i) {
        if (i != this.f231p) {
            if (!(this.f229n == null || this.f218c == null)) {
                bv.m2023d(this.f218c);
            }
            this.f231p = i;
            bv.m2023d(this);
        }
    }

    protected C0059x m384a() {
        return new C0059x(super.generateDefaultLayoutParams());
    }

    protected FrameLayout.LayoutParams m385a(LayoutParams layoutParams) {
        return new C0059x(layoutParams);
    }

    public void m386a(boolean z, boolean z2) {
        int i = 255;
        if (this.f232q != z) {
            if (z2) {
                if (!z) {
                    i = 0;
                }
                m373a(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.f232q = z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0059x;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m378b();
        if (this.f218c == null && this.f229n != null && this.f231p > 0) {
            this.f229n.mutate().setAlpha(this.f231p);
            this.f229n.draw(canvas);
        }
        if (this.f227l && this.f228m) {
            this.f226k.m931a(canvas);
        }
        if (this.f230o != null && this.f231p > 0) {
            int b = this.f236u != null ? this.f236u.mo416b() : 0;
            if (b > 0) {
                this.f230o.setBounds(0, -this.f235t, getWidth(), b - this.f235t);
                this.f230o.mutate().setAlpha(this.f231p);
                this.f230o.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        m378b();
        if (view == this.f218c && this.f229n != null && this.f231p > 0) {
            this.f229n.mutate().setAlpha(this.f231p);
            this.f229n.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f230o;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.f229n;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m384a();
    }

    protected /* synthetic */ FrameLayout.LayoutParams m5862generateDefaultLayoutParams() {
        return m384a();
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m385a(layoutParams);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0059x(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.f226k.m939c();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f226k.m941d();
    }

    public Drawable getContentScrim() {
        return this.f229n;
    }

    public int getExpandedTitleGravity() {
        return this.f226k.m935b();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f224i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f223h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f221f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f222g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f226k.m943e();
    }

    final int getScrimTriggerOffset() {
        return bv.m2039p(this) * 2;
    }

    public Drawable getStatusBarScrim() {
        return this.f230o;
    }

    public CharSequence getTitle() {
        return this.f227l ? this.f226k.m947g() : null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.f234s == null) {
                this.f234s = new C0060y();
            }
            ((AppBarLayout) parent).m334a(this.f234s);
        }
        bv.m2042s(this);
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.f234s != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m336b(this.f234s);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f227l && this.f220e != null) {
            boolean z2 = bv.m1996C(this.f220e) && this.f220e.getVisibility() == 0;
            this.f228m = z2;
            if (this.f228m) {
                i5 = (this.f219d == null || this.f219d == this) ? 0 : ((C0059x) this.f219d.getLayoutParams()).bottomMargin;
                ct.m756b(this, this.f220e, this.f225j);
                this.f226k.m937b(this.f225j.left, (i4 - this.f225j.height()) - i5, this.f225j.right, i4 - i5);
                if (bv.m2031h(this) != 1) {
                    i6 = 0;
                }
                this.f226k.m930a(i6 != 0 ? this.f223h : this.f221f, this.f225j.bottom + this.f222g, (i3 - i) - (i6 != 0 ? this.f221f : this.f223h), (i4 - i2) - this.f224i);
                this.f226k.m945f();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            View childAt = getChildAt(i7);
            if (!(this.f236u == null || bv.m2043t(childAt))) {
                int b = this.f236u.mo416b();
                if (childAt.getTop() < b) {
                    bv.m2027e(childAt, b);
                }
            }
            m382d(childAt).m765a();
            i7++;
        }
        if (this.f218c != null) {
            if (this.f227l && TextUtils.isEmpty(this.f226k.m947g())) {
                this.f226k.m934a(this.f218c.getTitle());
            }
            if (this.f219d == null || this.f219d == this) {
                setMinimumHeight(m379c(this.f218c));
            } else {
                setMinimumHeight(m379c(this.f219d));
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m378b();
        super.onMeasure(i, i2);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f229n != null) {
            this.f229n.setBounds(0, 0, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.f226k.m942d(i);
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f226k.m944e(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        this.f226k.m929a(i);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f226k.m932a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f229n != drawable) {
            if (this.f229n != null) {
                this.f229n.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f229n = drawable2;
            if (this.f229n != null) {
                this.f229n.setBounds(0, 0, getWidth(), getHeight());
                this.f229n.setCallback(this);
                this.f229n.setAlpha(this.f231p);
            }
            bv.m2023d(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(C0066a.m958a(getContext(), i));
    }

    public void setExpandedTitleColor(int i) {
        this.f226k.m936b(i);
    }

    public void setExpandedTitleGravity(int i) {
        this.f226k.m940c(i);
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f224i = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f223h = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f221f = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f222g = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f226k.m946f(i);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f226k.m938b(typeface);
    }

    public void setScrimsShown(boolean z) {
        boolean z2 = bv.m1994A(this) && !isInEditMode();
        m386a(z, z2);
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f230o != drawable) {
            if (this.f230o != null) {
                this.f230o.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f230o = drawable2;
            if (this.f230o != null) {
                if (this.f230o.isStateful()) {
                    this.f230o.setState(getDrawableState());
                }
                C0106a.m1341b(this.f230o, bv.m2031h(this));
                this.f230o.setVisible(getVisibility() == 0, false);
                this.f230o.setCallback(this);
                this.f230o.setAlpha(this.f231p);
            }
            bv.m2023d(this);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(C0066a.m958a(getContext(), i));
    }

    public void setTitle(CharSequence charSequence) {
        this.f226k.m934a(charSequence);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f227l) {
            this.f227l = z;
            m381c();
            requestLayout();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.f230o == null || this.f230o.isVisible() == z)) {
            this.f230o.setVisible(z, false);
        }
        if (this.f229n != null && this.f229n.isVisible() != z) {
            this.f229n.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f229n || drawable == this.f230o;
    }
}
