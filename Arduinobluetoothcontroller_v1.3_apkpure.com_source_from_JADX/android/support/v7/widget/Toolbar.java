package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.C0230q;
import android.support.v4.view.am;
import android.support.v4.view.ar;
import android.support.v4.view.az;
import android.support.v4.view.bv;
import android.support.v7.p005a.C0275b;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0308l;
import android.support.v7.view.C0319i;
import android.support.v7.view.menu.C0269j;
import android.support.v7.view.menu.C0273y;
import android.support.v7.view.menu.C0329i;
import android.support.v7.view.menu.C0332x;
import android.support.v7.view.menu.C0337m;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private boolean f1859A;
    private final ArrayList f1860B;
    private final ArrayList f1861C;
    private final int[] f1862D;
    private gl f1863E;
    private final C0356y f1864F;
    private go f1865G;
    private C0359k f1866H;
    private gj f1867I;
    private C0273y f1868J;
    private C0269j f1869K;
    private boolean f1870L;
    private final Runnable f1871M;
    private final aq f1872N;
    View f1873a;
    private ActionMenuView f1874b;
    private TextView f1875c;
    private TextView f1876d;
    private ImageButton f1877e;
    private ImageView f1878f;
    private Drawable f1879g;
    private CharSequence f1880h;
    private ImageButton f1881i;
    private Context f1882j;
    private int f1883k;
    private int f1884l;
    private int f1885m;
    private int f1886n;
    private int f1887o;
    private int f1888p;
    private int f1889q;
    private int f1890r;
    private int f1891s;
    private final fb f1892t;
    private int f1893u;
    private CharSequence f1894v;
    private CharSequence f1895w;
    private int f1896x;
    private int f1897y;
    private boolean f1898z;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1892t = new fb();
        this.f1893u = 8388627;
        this.f1860B = new ArrayList();
        this.f1861C = new ArrayList();
        this.f1862D = new int[2];
        this.f1864F = new gg(this);
        this.f1871M = new gh(this);
        gf a = gf.m4787a(getContext(), attributeSet, C0308l.Toolbar, i, 0);
        this.f1884l = a.m4803g(C0308l.Toolbar_titleTextAppearance, 0);
        this.f1885m = a.m4803g(C0308l.Toolbar_subtitleTextAppearance, 0);
        this.f1893u = a.m4795c(C0308l.Toolbar_android_gravity, this.f1893u);
        this.f1886n = 48;
        int d = a.m4797d(C0308l.Toolbar_titleMargins, 0);
        this.f1891s = d;
        this.f1890r = d;
        this.f1889q = d;
        this.f1888p = d;
        d = a.m4797d(C0308l.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f1888p = d;
        }
        d = a.m4797d(C0308l.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f1889q = d;
        }
        d = a.m4797d(C0308l.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f1890r = d;
        }
        d = a.m4797d(C0308l.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f1891s = d;
        }
        this.f1887o = a.m4799e(C0308l.Toolbar_maxButtonHeight, -1);
        d = a.m4797d(C0308l.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m4797d(C0308l.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f1892t.m4682b(a.m4799e(C0308l.Toolbar_contentInsetLeft, 0), a.m4799e(C0308l.Toolbar_contentInsetRight, 0));
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f1892t.m4679a(d, d2);
        }
        this.f1879g = a.m4790a(C0308l.Toolbar_collapseIcon);
        this.f1880h = a.m4796c(C0308l.Toolbar_collapseContentDescription);
        CharSequence c = a.m4796c(C0308l.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m4796c(C0308l.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f1882j = getContext();
        setPopupTheme(a.m4803g(C0308l.Toolbar_popupTheme, 0));
        Drawable a2 = a.m4790a(C0308l.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m4796c(C0308l.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m4790a(C0308l.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m4796c(C0308l.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m4802f(C0308l.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m4793b(C0308l.Toolbar_titleTextColor, -1));
        }
        if (a.m4802f(C0308l.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m4793b(C0308l.Toolbar_subtitleTextColor, -1));
        }
        a.m4791a();
        this.f1872N = aq.m4079a();
    }

    private int m3963a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f1893u & 112;
        }
    }

    private int m3964a(View view, int i) {
        gk gkVar = (gk) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m3963a(gkVar.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - gkVar.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < gkVar.topMargin) {
                    i3 = gkVar.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < gkVar.bottomMargin ? Math.max(0, i2 - (gkVar.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m3965a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int m3966a(View view, int i, int[] iArr, int i2) {
        gk gkVar = (gk) view.getLayoutParams();
        int i3 = gkVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m3964a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (gkVar.rightMargin + measuredWidth) + max;
    }

    private int m3967a(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            gk gkVar = (gk) view.getLayoutParams();
            i6 = gkVar.leftMargin - i6;
            i = gkVar.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void m3969a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void m3970a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m4003i();
        } else if (checkLayoutParams(layoutParams)) {
            gk gkVar = (gk) layoutParams;
        } else {
            layoutParams = m3989a(layoutParams);
        }
        layoutParams.f2386b = 1;
        if (!z || this.f1873a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f1861C.add(view);
    }

    private void m3971a(List list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (bv.m2031h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0230q.m2509a(i, bv.m2031h(this));
        list.clear();
        gk gkVar;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                gkVar = (gk) childAt.getLayoutParams();
                if (gkVar.f2386b == 0 && m3972a(childAt) && m3973b(gkVar.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            gkVar = (gk) childAt2.getLayoutParams();
            if (gkVar.f2386b == 0 && m3972a(childAt2) && m3973b(gkVar.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean m3972a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m3973b(int i) {
        int h = bv.m2031h(this);
        int a = C0230q.m2509a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private int m3974b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return am.m1860b(marginLayoutParams) + am.m1859a(marginLayoutParams);
    }

    private int m3975b(View view, int i, int[] iArr, int i2) {
        gk gkVar = (gk) view.getLayoutParams();
        int i3 = gkVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m3964a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (gkVar.leftMargin + measuredWidth);
    }

    private int m3977c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean m3980d(View view) {
        return view.getParent() == this || this.f1861C.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new C0319i(getContext());
    }

    private void m3981l() {
        if (this.f1878f == null) {
            this.f1878f = new ImageView(getContext());
        }
    }

    private void m3982m() {
        m3983n();
        if (this.f1874b.m3586d() == null) {
            C0329i c0329i = (C0329i) this.f1874b.getMenu();
            if (this.f1867I == null) {
                this.f1867I = new gj();
            }
            this.f1874b.setExpandedActionViewsExclusive(true);
            c0329i.m3352a(this.f1867I, this.f1882j);
        }
    }

    private void m3983n() {
        if (this.f1874b == null) {
            this.f1874b = new ActionMenuView(getContext());
            this.f1874b.setPopupTheme(this.f1883k);
            this.f1874b.setOnMenuItemClickListener(this.f1864F);
            this.f1874b.m3578a(this.f1868J, this.f1869K);
            LayoutParams i = m4003i();
            i.a = 8388613 | (this.f1886n & 112);
            this.f1874b.setLayoutParams(i);
            m3970a(this.f1874b, false);
        }
    }

    private void m3984o() {
        if (this.f1877e == null) {
            this.f1877e = new ImageButton(getContext(), null, C0298b.toolbarNavigationButtonStyle);
            LayoutParams i = m4003i();
            i.a = 8388611 | (this.f1886n & 112);
            this.f1877e.setLayoutParams(i);
        }
    }

    private void m3985p() {
        if (this.f1881i == null) {
            this.f1881i = new ImageButton(getContext(), null, C0298b.toolbarNavigationButtonStyle);
            this.f1881i.setImageDrawable(this.f1879g);
            this.f1881i.setContentDescription(this.f1880h);
            LayoutParams i = m4003i();
            i.a = 8388611 | (this.f1886n & 112);
            i.f2386b = 2;
            this.f1881i.setLayoutParams(i);
            this.f1881i.setOnClickListener(new gi(this));
        }
    }

    private void m3986q() {
        removeCallbacks(this.f1871M);
        post(this.f1871M);
    }

    private boolean m3987r() {
        if (!this.f1870L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m3972a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public gk m3988a(AttributeSet attributeSet) {
        return new gk(getContext(), attributeSet);
    }

    protected gk m3989a(LayoutParams layoutParams) {
        return layoutParams instanceof gk ? new gk((gk) layoutParams) : layoutParams instanceof C0275b ? new gk((C0275b) layoutParams) : layoutParams instanceof MarginLayoutParams ? new gk((MarginLayoutParams) layoutParams) : new gk(layoutParams);
    }

    public void m3990a(int i, int i2) {
        this.f1892t.m4679a(i, i2);
    }

    public void m3991a(Context context, int i) {
        this.f1884l = i;
        if (this.f1875c != null) {
            this.f1875c.setTextAppearance(context, i);
        }
    }

    public void m3992a(C0329i c0329i, C0359k c0359k) {
        if (c0329i != null || this.f1874b != null) {
            m3983n();
            C0329i d = this.f1874b.m3586d();
            if (d != c0329i) {
                if (d != null) {
                    d.m3362b(this.f1866H);
                    d.m3362b(this.f1867I);
                }
                if (this.f1867I == null) {
                    this.f1867I = new gj();
                }
                c0359k.m4922d(true);
                if (c0329i != null) {
                    c0329i.m3352a((C0332x) c0359k, this.f1882j);
                    c0329i.m3352a(this.f1867I, this.f1882j);
                } else {
                    c0359k.mo608a(this.f1882j, null);
                    this.f1867I.mo608a(this.f1882j, null);
                    c0359k.mo612b(true);
                    this.f1867I.mo612b(true);
                }
                this.f1874b.setPopupTheme(this.f1883k);
                this.f1874b.setPresenter(c0359k);
                this.f1866H = c0359k;
            }
        }
    }

    public void m3993a(C0273y c0273y, C0269j c0269j) {
        this.f1868J = c0273y;
        this.f1869K = c0269j;
        if (this.f1874b != null) {
            this.f1874b.m3578a(c0273y, c0269j);
        }
    }

    public boolean m3994a() {
        return getVisibility() == 0 && this.f1874b != null && this.f1874b.m3579a();
    }

    public void m3995b(Context context, int i) {
        this.f1885m = i;
        if (this.f1876d != null) {
            this.f1876d.setTextAppearance(context, i);
        }
    }

    public boolean m3996b() {
        return this.f1874b != null && this.f1874b.m3589g();
    }

    public boolean m3997c() {
        return this.f1874b != null && this.f1874b.m3590h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof gk);
    }

    public boolean m3998d() {
        return this.f1874b != null && this.f1874b.m3587e();
    }

    public boolean m3999e() {
        return this.f1874b != null && this.f1874b.m3588f();
    }

    public void m4000f() {
        if (this.f1874b != null) {
            this.f1874b.m3591i();
        }
    }

    public boolean m4001g() {
        return (this.f1867I == null || this.f1867I.f2384b == null) ? false : true;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m4003i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3988a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3989a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.f1892t.m4684d();
    }

    public int getContentInsetLeft() {
        return this.f1892t.m4678a();
    }

    public int getContentInsetRight() {
        return this.f1892t.m4681b();
    }

    public int getContentInsetStart() {
        return this.f1892t.m4683c();
    }

    public Drawable getLogo() {
        return this.f1878f != null ? this.f1878f.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.f1878f != null ? this.f1878f.getContentDescription() : null;
    }

    public Menu getMenu() {
        m3982m();
        return this.f1874b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.f1877e != null ? this.f1877e.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.f1877e != null ? this.f1877e.getDrawable() : null;
    }

    public Drawable getOverflowIcon() {
        m3982m();
        return this.f1874b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f1883k;
    }

    public CharSequence getSubtitle() {
        return this.f1895w;
    }

    public CharSequence getTitle() {
        return this.f1894v;
    }

    public bw getWrapper() {
        if (this.f1865G == null) {
            this.f1865G = new go(this, true);
        }
        return this.f1865G;
    }

    public void m4002h() {
        C0337m c0337m = this.f1867I == null ? null : this.f1867I.f2384b;
        if (c0337m != null) {
            c0337m.collapseActionView();
        }
    }

    protected gk m4003i() {
        return new gk(-2, -2);
    }

    void m4004j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((gk) childAt.getLayoutParams()).f2386b == 2 || childAt == this.f1874b)) {
                removeViewAt(childCount);
                this.f1861C.add(childAt);
            }
        }
    }

    void m4005k() {
        for (int size = this.f1861C.size() - 1; size >= 0; size--) {
            addView((View) this.f1861C.get(size));
        }
        this.f1861C.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1871M);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = az.m1904a(motionEvent);
        if (a == 9) {
            this.f1859A = false;
        }
        if (!this.f1859A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1859A = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1859A = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        Object obj = bv.m2031h(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.f1862D;
        iArr[1] = 0;
        iArr[0] = 0;
        int p = bv.m2039p(this);
        if (!m3972a(this.f1877e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = m3975b(this.f1877e, i8, iArr, p);
            i5 = paddingLeft;
        } else {
            i5 = m3966a(this.f1877e, paddingLeft, iArr, p);
        }
        if (m3972a(this.f1881i)) {
            if (obj != null) {
                i8 = m3975b(this.f1881i, i8, iArr, p);
            } else {
                i5 = m3966a(this.f1881i, i5, iArr, p);
            }
        }
        if (m3972a(this.f1874b)) {
            if (obj != null) {
                i5 = m3966a(this.f1874b, i5, iArr, p);
            } else {
                i8 = m3975b(this.f1874b, i8, iArr, p);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (m3972a(this.f1873a)) {
            if (obj != null) {
                i8 = m3975b(this.f1873a, i8, iArr, p);
            } else {
                i5 = m3966a(this.f1873a, i5, iArr, p);
            }
        }
        if (!m3972a(this.f1878f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = m3975b(this.f1878f, i8, iArr, p);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = m3966a(this.f1878f, i5, iArr, p);
        }
        boolean a = m3972a(this.f1875c);
        boolean a2 = m3972a(this.f1876d);
        i5 = 0;
        if (a) {
            gk gkVar = (gk) this.f1875c.getLayoutParams();
            i5 = 0 + (gkVar.bottomMargin + (gkVar.topMargin + this.f1875c.getMeasuredHeight()));
        }
        if (a2) {
            gkVar = (gk) this.f1876d.getLayoutParams();
            measuredHeight = (gkVar.bottomMargin + (gkVar.topMargin + this.f1876d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            gkVar = (gk) (a ? this.f1875c : this.f1876d).getLayoutParams();
            gk gkVar2 = (gk) (a2 ? this.f1876d : this.f1875c).getLayoutParams();
            Object obj2 = ((!a || this.f1875c.getMeasuredWidth() <= 0) && (!a2 || this.f1876d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f1893u & 112) {
                case 48:
                    paddingTop2 = (gkVar.topMargin + getPaddingTop()) + this.f1890r;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - gkVar2.bottomMargin) - this.f1891s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < gkVar.topMargin + this.f1890r) {
                        i8 = gkVar.topMargin + this.f1890r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        i8 = measuredHeight < gkVar.bottomMargin + this.f1891s ? Math.max(0, paddingTop2 - ((gkVar2.bottomMargin + this.f1891s) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.f1888p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (a) {
                    gkVar = (gk) this.f1875c.getLayoutParams();
                    measuredWidth = i5 - this.f1875c.getMeasuredWidth();
                    i6 = this.f1875c.getMeasuredHeight() + paddingTop2;
                    this.f1875c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + gkVar.bottomMargin;
                    i6 = measuredWidth - this.f1889q;
                } else {
                    i6 = i5;
                }
                if (a2) {
                    gkVar = (gk) this.f1876d.getLayoutParams();
                    measuredWidth = gkVar.topMargin + paddingTop2;
                    measuredHeight = this.f1876d.getMeasuredHeight() + measuredWidth;
                    this.f1876d.layout(i5 - this.f1876d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = gkVar.bottomMargin + measuredHeight;
                    i8 = i5 - this.f1889q;
                } else {
                    i8 = i5;
                }
                i6 = obj2 != null ? Math.min(i6, i8) : i5;
            } else {
                i8 = (obj2 != null ? this.f1888p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (a) {
                    gkVar = (gk) this.f1875c.getLayoutParams();
                    i5 = this.f1875c.getMeasuredWidth() + i7;
                    measuredWidth = this.f1875c.getMeasuredHeight() + paddingTop2;
                    this.f1875c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = gkVar.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f1889q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (a2) {
                    gkVar = (gk) this.f1876d.getLayoutParams();
                    i5 += gkVar.topMargin;
                    paddingTop2 = this.f1876d.getMeasuredWidth() + i7;
                    measuredHeight = this.f1876d.getMeasuredHeight() + i5;
                    this.f1876d.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = gkVar.bottomMargin + measuredHeight;
                    i8 = this.f1889q + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        m3971a(this.f1860B, 3);
        int size = this.f1860B.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m3966a((View) this.f1860B.get(measuredWidth), i5, iArr, p);
        }
        m3971a(this.f1860B, 5);
        i7 = this.f1860B.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = m3975b((View) this.f1860B.get(measuredWidth), i6, iArr, p);
        }
        m3971a(this.f1860B, 1);
        measuredWidth = m3967a(this.f1860B, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.f1860B.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m3966a((View) this.f1860B.get(i5), measuredWidth, iArr, p);
        }
        this.f1860B.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f1862D;
        if (gv.m4891a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m3972a(this.f1877e)) {
            m3969a(this.f1877e, i, 0, i2, 0, this.f1887o);
            i7 = this.f1877e.getMeasuredWidth() + m3974b(this.f1877e);
            max = Math.max(0, this.f1877e.getMeasuredHeight() + m3977c(this.f1877e));
            i6 = gv.m4889a(0, bv.m2033j(this.f1877e));
            i5 = max;
        }
        if (m3972a(this.f1881i)) {
            m3969a(this.f1881i, i, 0, i2, 0, this.f1887o);
            i7 = this.f1881i.getMeasuredWidth() + m3974b(this.f1881i);
            i5 = Math.max(i5, this.f1881i.getMeasuredHeight() + m3977c(this.f1881i));
            i6 = gv.m4889a(i6, bv.m2033j(this.f1881i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (m3972a(this.f1874b)) {
            m3969a(this.f1874b, i, max2, i2, 0, this.f1887o);
            i7 = this.f1874b.getMeasuredWidth() + m3974b(this.f1874b);
            i5 = Math.max(i5, this.f1874b.getMeasuredHeight() + m3977c(this.f1874b));
            i6 = gv.m4889a(i6, bv.m2033j(this.f1874b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (m3972a(this.f1873a)) {
            max2 += m3965a(this.f1873a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1873a.getMeasuredHeight() + m3977c(this.f1873a));
            i6 = gv.m4889a(i6, bv.m2033j(this.f1873a));
        }
        if (m3972a(this.f1878f)) {
            max2 += m3965a(this.f1878f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1878f.getMeasuredHeight() + m3977c(this.f1878f));
            i6 = gv.m4889a(i6, bv.m2033j(this.f1878f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((gk) childAt.getLayoutParams()).f2386b != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (m3972a(childAt)) {
                max2 += m3965a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m3977c(childAt));
                i7 = gv.m4889a(i5, bv.m2033j(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.f1890r + this.f1891s;
        max = this.f1888p + this.f1889q;
        if (m3972a(this.f1875c)) {
            m3965a(this.f1875c, i, max2 + max, i2, i6, iArr);
            contentInsetStart = m3974b(this.f1875c) + this.f1875c.getMeasuredWidth();
            i7 = this.f1875c.getMeasuredHeight() + m3977c(this.f1875c);
            i5 = gv.m4889a(i5, bv.m2033j(this.f1875c));
        }
        if (m3972a(this.f1876d)) {
            contentInsetStart = Math.max(contentInsetStart, m3965a(this.f1876d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f1876d.getMeasuredHeight() + m3977c(this.f1876d);
            i5 = gv.m4889a(i5, bv.m2033j(this.f1876d));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = bv.m1999a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = bv.m1999a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m3987r()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        gm gmVar = (gm) parcelable;
        super.onRestoreInstanceState(gmVar.getSuperState());
        Menu d = this.f1874b != null ? this.f1874b.m3586d() : null;
        if (!(gmVar.f2387a == 0 || this.f1867I == null || d == null)) {
            MenuItem findItem = d.findItem(gmVar.f2387a);
            if (findItem != null) {
                ar.m1874b(findItem);
            }
        }
        if (gmVar.f2388b) {
            m3986q();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        fb fbVar = this.f1892t;
        if (i != 1) {
            z = false;
        }
        fbVar.m4680a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable gmVar = new gm(super.onSaveInstanceState());
        if (!(this.f1867I == null || this.f1867I.f2384b == null)) {
            gmVar.f2387a = this.f1867I.f2384b.getItemId();
        }
        gmVar.f2388b = m3996b();
        return gmVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = az.m1904a(motionEvent);
        if (a == 0) {
            this.f1898z = false;
        }
        if (!this.f1898z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1898z = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1898z = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f1870L = z;
        requestLayout();
    }

    public void setLogo(int i) {
        setLogo(this.f1872N.m4100a(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m3981l();
            if (!m3980d(this.f1878f)) {
                m3970a(this.f1878f, true);
            }
        } else if (this.f1878f != null && m3980d(this.f1878f)) {
            removeView(this.f1878f);
            this.f1861C.remove(this.f1878f);
        }
        if (this.f1878f != null) {
            this.f1878f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m3981l();
        }
        if (this.f1878f != null) {
            this.f1878f.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m3984o();
        }
        if (this.f1877e != null) {
            this.f1877e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f1872N.m4100a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m3984o();
            if (!m3980d(this.f1877e)) {
                m3970a(this.f1877e, true);
            }
        } else if (this.f1877e != null && m3980d(this.f1877e)) {
            removeView(this.f1877e);
            this.f1861C.remove(this.f1877e);
        }
        if (this.f1877e != null) {
            this.f1877e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m3984o();
        this.f1877e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(gl glVar) {
        this.f1863E = glVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        m3982m();
        this.f1874b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f1883k != i) {
            this.f1883k = i;
            if (i == 0) {
                this.f1882j = getContext();
            } else {
                this.f1882j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1876d == null) {
                Context context = getContext();
                this.f1876d = new TextView(context);
                this.f1876d.setSingleLine();
                this.f1876d.setEllipsize(TruncateAt.END);
                if (this.f1885m != 0) {
                    this.f1876d.setTextAppearance(context, this.f1885m);
                }
                if (this.f1897y != 0) {
                    this.f1876d.setTextColor(this.f1897y);
                }
            }
            if (!m3980d(this.f1876d)) {
                m3970a(this.f1876d, true);
            }
        } else if (this.f1876d != null && m3980d(this.f1876d)) {
            removeView(this.f1876d);
            this.f1861C.remove(this.f1876d);
        }
        if (this.f1876d != null) {
            this.f1876d.setText(charSequence);
        }
        this.f1895w = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.f1897y = i;
        if (this.f1876d != null) {
            this.f1876d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1875c == null) {
                Context context = getContext();
                this.f1875c = new TextView(context);
                this.f1875c.setSingleLine();
                this.f1875c.setEllipsize(TruncateAt.END);
                if (this.f1884l != 0) {
                    this.f1875c.setTextAppearance(context, this.f1884l);
                }
                if (this.f1896x != 0) {
                    this.f1875c.setTextColor(this.f1896x);
                }
            }
            if (!m3980d(this.f1875c)) {
                m3970a(this.f1875c, true);
            }
        } else if (this.f1875c != null && m3980d(this.f1875c)) {
            removeView(this.f1875c);
            this.f1861C.remove(this.f1875c);
        }
        if (this.f1875c != null) {
            this.f1875c.setText(charSequence);
        }
        this.f1894v = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.f1896x = i;
        if (this.f1875c != null) {
            this.f1875c.setTextColor(i);
        }
    }
}
