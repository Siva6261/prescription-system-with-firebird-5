package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.widget.C0258s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int[] f896a = new int[]{16842931};
    private static final dq ai = new dq();
    private static final Comparator f897c = new dc();
    private static final Interpolator f898d = new dd();
    private int f899A = 1;
    private boolean f900B;
    private boolean f901C;
    private int f902D;
    private int f903E;
    private int f904F;
    private float f905G;
    private float f906H;
    private float f907I;
    private float f908J;
    private int f909K = -1;
    private VelocityTracker f910L;
    private int f911M;
    private int f912N;
    private int f913O;
    private int f914P;
    private boolean f915Q;
    private C0258s f916R;
    private C0258s f917S;
    private boolean f918T = true;
    private boolean f919U = false;
    private boolean f920V;
    private int f921W;
    private List aa;
    private dl ab;
    private dl ac;
    private dk ad;
    private dm ae;
    private Method af;
    private int ag;
    private ArrayList ah;
    private final Runnable aj = new de(this);
    private int ak = 0;
    private int f922b;
    private final ArrayList f923e = new ArrayList();
    private final dh f924f = new dh();
    private final Rect f925g = new Rect();
    private bn f926h;
    private int f927i;
    private int f928j = -1;
    private Parcelable f929k = null;
    private ClassLoader f930l = null;
    private Scroller f931m;
    private boolean f932n;
    private dn f933o;
    private int f934p;
    private Drawable f935q;
    private int f936r;
    private int f937s;
    private float f938t = -3.4028235E38f;
    private float f939u = Float.MAX_VALUE;
    private int f940v;
    private int f941w;
    private boolean f942x;
    private boolean f943y;
    private boolean f944z;

    public ViewPager(Context context) {
        super(context);
        m1606a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1606a();
    }

    private int m1579a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f913O || Math.abs(i2) <= this.f911M) {
            i = (int) ((i >= this.f927i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f923e.size() <= 0) {
            return i;
        }
        return Math.max(((dh) this.f923e.get(0)).f998b, Math.min(i, ((dh) this.f923e.get(this.f923e.size() - 1)).f998b));
    }

    private Rect m1580a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void m1582a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f923e.isEmpty()) {
            dh b = m1617b(this.f927i);
            int min = (int) ((b != null ? Math.min(b.f1001e, this.f939u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m1587a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.f931m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.f931m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    private void m1583a(int i, boolean z, int i2, boolean z2) {
        int max;
        dh b = m1617b(i);
        if (b != null) {
            max = (int) (Math.max(this.f938t, Math.min(b.f1001e, this.f939u)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m1609a(max, 0, i2);
            if (z2) {
                m1595e(i);
                return;
            }
            return;
        }
        if (z2) {
            m1595e(i);
        }
        m1587a(false);
        scrollTo(max, 0);
        m1594d(max);
    }

    private void m1585a(dh dhVar, int i, dh dhVar2) {
        float f;
        int i2;
        dh dhVar3;
        int i3;
        int b = this.f926h.mo839b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.f934p) / ((float) clientWidth) : 0.0f;
        if (dhVar2 != null) {
            clientWidth = dhVar2.f998b;
            int i4;
            if (clientWidth < dhVar.f998b) {
                f = (dhVar2.f1001e + dhVar2.f1000d) + f2;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= dhVar.f998b && i2 < this.f923e.size()) {
                    dhVar3 = (dh) this.f923e.get(i2);
                    while (i4 > dhVar3.f998b && i2 < this.f923e.size() - 1) {
                        i2++;
                        dhVar3 = (dh) this.f923e.get(i2);
                    }
                    while (i4 < dhVar3.f998b) {
                        f += this.f926h.m1147b(i4) + f2;
                        i4++;
                    }
                    dhVar3.f1001e = f;
                    f += dhVar3.f1000d + f2;
                    i4++;
                }
            } else if (clientWidth > dhVar.f998b) {
                i2 = this.f923e.size() - 1;
                f = dhVar2.f1001e;
                i4 = clientWidth - 1;
                while (i4 >= dhVar.f998b && i2 >= 0) {
                    dhVar3 = (dh) this.f923e.get(i2);
                    while (i4 < dhVar3.f998b && i2 > 0) {
                        i2--;
                        dhVar3 = (dh) this.f923e.get(i2);
                    }
                    while (i4 > dhVar3.f998b) {
                        f -= this.f926h.m1147b(i4) + f2;
                        i4--;
                    }
                    f -= dhVar3.f1000d + f2;
                    dhVar3.f1001e = f;
                    i4--;
                }
            }
        }
        int size = this.f923e.size();
        float f3 = dhVar.f1001e;
        i2 = dhVar.f998b - 1;
        this.f938t = dhVar.f998b == 0 ? dhVar.f1001e : -3.4028235E38f;
        this.f939u = dhVar.f998b == b + -1 ? (dhVar.f1001e + dhVar.f1000d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            dhVar3 = (dh) this.f923e.get(i3);
            f = f3;
            while (i2 > dhVar3.f998b) {
                f -= this.f926h.m1147b(i2) + f2;
                i2--;
            }
            f3 = f - (dhVar3.f1000d + f2);
            dhVar3.f1001e = f3;
            if (dhVar3.f998b == 0) {
                this.f938t = f3;
            }
            i2--;
        }
        f3 = (dhVar.f1001e + dhVar.f1000d) + f2;
        i2 = dhVar.f998b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            dhVar3 = (dh) this.f923e.get(i3);
            f = f3;
            while (i2 < dhVar3.f998b) {
                f = (this.f926h.m1147b(i2) + f2) + f;
                i2++;
            }
            if (dhVar3.f998b == b - 1) {
                this.f939u = (dhVar3.f1000d + f) - 1.0f;
            }
            dhVar3.f1001e = f;
            f3 = f + (dhVar3.f1000d + f2);
            i2++;
        }
        this.f919U = false;
    }

    private void m1586a(MotionEvent motionEvent) {
        int b = az.m1906b(motionEvent);
        if (az.m1907b(motionEvent, b) == this.f909K) {
            b = b == 0 ? 1 : 0;
            this.f905G = az.m1908c(motionEvent, b);
            this.f909K = az.m1907b(motionEvent, b);
            if (this.f910L != null) {
                this.f910L.clear();
            }
        }
    }

    private void m1587a(boolean z) {
        int scrollX;
        boolean z2 = this.ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f931m.isFinished()) {
                this.f931m.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f931m.getCurrX();
                int currY = this.f931m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m1594d(currX);
                    }
                }
            }
        }
        this.f944z = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f923e.size(); scrollX++) {
            dh dhVar = (dh) this.f923e.get(scrollX);
            if (dhVar.f999c) {
                dhVar.f999c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            bv.m2010a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    private boolean m1588a(float f, float f2) {
        return (f < ((float) this.f903E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f903E)) && f2 < 0.0f);
    }

    private void m1590b(int i, float f, int i2) {
        if (this.ab != null) {
            this.ab.mo836a(i, f, i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                dl dlVar = (dl) this.aa.get(i3);
                if (dlVar != null) {
                    dlVar.mo836a(i, f, i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo836a(i, f, i2);
        }
    }

    private void m1591b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            bv.m2005a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    private boolean m1592b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f905G - f;
        this.f905G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f938t;
        float f5 = ((float) clientWidth) * this.f939u;
        dh dhVar = (dh) this.f923e.get(0);
        dh dhVar2 = (dh) this.f923e.get(this.f923e.size() - 1);
        if (dhVar.f998b != 0) {
            f4 = dhVar.f1001e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (dhVar2.f998b != this.f926h.mo839b() - 1) {
            f2 = dhVar2.f1001e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f916R.m2785a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f917S.m2785a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f905G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m1594d((int) f4);
        return z3;
    }

    private void m1593c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m1594d(int i) {
        if (this.f923e.size() == 0) {
            this.f920V = false;
            m1608a(0, 0.0f, 0);
            if (this.f920V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        dh j = m1601j();
        int clientWidth = getClientWidth();
        int i2 = this.f934p + clientWidth;
        float f = ((float) this.f934p) / ((float) clientWidth);
        int i3 = j.f998b;
        float f2 = ((((float) i) / ((float) clientWidth)) - j.f1001e) / (j.f1000d + f);
        clientWidth = (int) (((float) i2) * f2);
        this.f920V = false;
        m1608a(i3, f2, clientWidth);
        if (this.f920V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void m1595e(int i) {
        if (this.ab != null) {
            this.ab.mo835a(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                dl dlVar = (dl) this.aa.get(i2);
                if (dlVar != null) {
                    dlVar.mo835a(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo835a(i);
        }
    }

    private void m1596f(int i) {
        if (this.ab != null) {
            this.ab.mo837b(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                dl dlVar = (dl) this.aa.get(i2);
                if (dlVar != null) {
                    dlVar.mo837b(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo837b(i);
        }
    }

    private void m1598g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((di) getChildAt(i).getLayoutParams()).f1002a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void m1599h() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ah.add(getChildAt(i));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private boolean m1600i() {
        this.f909K = -1;
        m1602k();
        return this.f916R.m2790c() | this.f917S.m2790c();
    }

    private dh m1601j() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f934p) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        dh dhVar = null;
        while (i2 < this.f923e.size()) {
            int i3;
            dh dhVar2;
            dh dhVar3 = (dh) this.f923e.get(i2);
            dh dhVar4;
            if (obj != null || dhVar3.f998b == i + 1) {
                dhVar4 = dhVar3;
                i3 = i2;
                dhVar2 = dhVar4;
            } else {
                dhVar3 = this.f924f;
                dhVar3.f1001e = (f2 + f3) + f;
                dhVar3.f998b = i + 1;
                dhVar3.f1000d = this.f926h.m1147b(dhVar3.f998b);
                dhVar4 = dhVar3;
                i3 = i2 - 1;
                dhVar2 = dhVar4;
            }
            f2 = dhVar2.f1001e;
            f3 = (dhVar2.f1000d + f2) + f;
            if (obj == null && scrollX < f2) {
                return dhVar;
            }
            if (scrollX < f3 || i3 == this.f923e.size() - 1) {
                return dhVar2;
            }
            f3 = f2;
            i = dhVar2.f998b;
            obj = null;
            f2 = dhVar2.f1000d;
            dhVar = dhVar2;
            i2 = i3 + 1;
        }
        return dhVar;
    }

    private void m1602k() {
        this.f900B = false;
        this.f901C = false;
        if (this.f910L != null) {
            this.f910L.recycle();
            this.f910L = null;
        }
    }

    private void setScrollState(int i) {
        if (this.ak != i) {
            this.ak = i;
            if (this.ae != null) {
                m1591b(i != 0);
            }
            m1596f(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f943y != z) {
            this.f943y = z;
        }
    }

    float m1603a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    dh m1604a(int i, int i2) {
        dh dhVar = new dh();
        dhVar.f998b = i;
        dhVar.f997a = this.f926h.mo188a((ViewGroup) this, i);
        dhVar.f1000d = this.f926h.m1147b(i);
        if (i2 < 0 || i2 >= this.f923e.size()) {
            this.f923e.add(dhVar);
        } else {
            this.f923e.add(i2, dhVar);
        }
        return dhVar;
    }

    dh m1605a(View view) {
        for (int i = 0; i < this.f923e.size(); i++) {
            dh dhVar = (dh) this.f923e.get(i);
            if (this.f926h.mo192a(view, dhVar.f997a)) {
                return dhVar;
            }
        }
        return null;
    }

    void m1606a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f931m = new Scroller(context, f898d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f904F = cu.m2315a(viewConfiguration);
        this.f911M = (int) (400.0f * f);
        this.f912N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f916R = new C0258s(context);
        this.f917S = new C0258s(context);
        this.f913O = (int) (25.0f * f);
        this.f914P = (int) (2.0f * f);
        this.f902D = (int) (16.0f * f);
        bv.m2008a((View) this, new dj(this));
        if (bv.m2026e(this) == 0) {
            bv.m2020c((View) this, 1);
        }
        bv.m2009a((View) this, new df(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1607a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.f927i;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.f927i;
        r0 = r17;
        r2 = r0.m1617b(r2);
        r0 = r18;
        r1 = r17;
        r1.f927i = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.f926h;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.m1599h();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.f944z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.m1599h();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.f926h;
        r0 = r17;
        r2.mo190a(r0);
        r0 = r17;
        r2 = r0.f899A;
        r4 = 0;
        r0 = r17;
        r5 = r0.f927i;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.f926h;
        r11 = r4.mo839b();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.f927i;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.f922b;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.f922b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.f926h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.dh) r2;
        r6 = r2.f998b;
        r0 = r17;
        r7 = r0.f927i;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.f998b;
        r0 = r17;
        r7 = r0.f927i;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.f927i;
        r0 = r17;
        r2 = r0.m1604a(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.dh) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.f927i;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.f1000d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.dh) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.f927i;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.m1585a(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.f926h;
        r0 = r17;
        r4 = r0.f927i;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.f997a;
    L_0x0179:
        r0 = r17;
        r3.mo194b(r0, r4, r2);
        r0 = r17;
        r2 = r0.f926h;
        r0 = r17;
        r2.mo193b(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.di) r2;
        r2.f1007f = r3;
        r6 = r2.f1002a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.f1004c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.m1605a(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.f1000d;
        r2.f1004c = r6;
        r5 = r5.f998b;
        r2.f1006e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.f1000d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.f998b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.f999c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.f923e;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.f926h;
        r2 = r2.f997a;
        r0 = r17;
        r14.mo191a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.dh) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.f998b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.f1000d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.dh) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.m1604a(r8, r2);
        r2 = r2.f1000d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.dh) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.f998b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.f999c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.f923e;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.f926h;
        r2 = r2.f997a;
        r0 = r17;
        r10.mo191a(r0, r8, r2);
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.dh) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.f998b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.f1000d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.dh) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.m1604a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.f1000d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.f923e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.dh) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.m1599h();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.m1618b(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.f998b;
        r0 = r17;
        r3 = r0.f927i;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.m1605a(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.f998b;
        r0 = r17;
        r5 = r0.f927i;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    protected void m1608a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f921W > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                di diVar = (di) childAt.getLayoutParams();
                if (diVar.f1002a) {
                    int max;
                    switch (diVar.f1003b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        m1590b(i, f, i2);
        if (this.ae != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((di) childAt2.getLayoutParams()).f1002a) {
                    this.ae.mo834a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f920V = true;
    }

    void m1609a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.f931m == null || this.f931m.isFinished()) ? false : true;
        if (z) {
            int currX = this.f932n ? this.f931m.getCurrX() : this.f931m.getStartX();
            this.f931m.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m1587a(false);
            m1620c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float a = (((float) i7) * m1603a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        i7 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4 : (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.f926h.m1147b(this.f927i)) + ((float) this.f934p))) + 1.0f) * 100.0f), 600);
        this.f932n = false;
        this.f931m.startScroll(i4, scrollY, i5, i6, i7);
        bv.m2023d(this);
    }

    public void m1610a(int i, boolean z) {
        this.f944z = false;
        m1611a(i, z, false);
    }

    void m1611a(int i, boolean z, boolean z2) {
        m1612a(i, z, z2, 0);
    }

    void m1612a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f926h == null || this.f926h.mo839b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f927i != i || this.f923e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f926h.mo839b()) {
                i = this.f926h.mo839b() - 1;
            }
            int i3 = this.f899A;
            if (i > this.f927i + i3 || i < this.f927i - i3) {
                for (int i4 = 0; i4 < this.f923e.size(); i4++) {
                    ((dh) this.f923e.get(i4)).f999c = true;
                }
            }
            if (this.f927i != i) {
                z3 = true;
            }
            if (this.f918T) {
                this.f927i = i;
                if (z3) {
                    m1595e(i);
                }
                requestLayout();
                return;
            }
            m1607a(i);
            m1583a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void m1613a(dl dlVar) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(dlVar);
    }

    public void m1614a(boolean z, dm dmVar) {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            boolean z2 = dmVar != null;
            int i2 = z2 != (this.ae != null) ? 1 : 0;
            this.ae = dmVar;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = 2;
                }
                this.ag = i;
            } else {
                this.ag = 0;
            }
            if (i2 != 0) {
                m1620c();
            }
        }
    }

    public boolean m1615a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m1621c(17);
            case 22:
                return m1621c(66);
            case 61:
                return VERSION.SDK_INT >= 11 ? C0235v.m2519a(keyEvent) ? m1621c(2) : C0235v.m2520a(keyEvent, 1) ? m1621c(1) : false : false;
            default:
                return false;
        }
    }

    protected boolean m1616a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m1616a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && bv.m2013a(view, -i);
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    dh a = m1605a(childAt);
                    if (a != null && a.f998b == this.f927i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                dh a = m1605a(childAt);
                if (a != null && a.f998b == this.f927i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        di diVar = (di) generateLayoutParams;
        diVar.f1002a |= view instanceof dg;
        if (!this.f942x) {
            super.addView(view, i, generateLayoutParams);
        } else if (diVar == null || !diVar.f1002a) {
            diVar.f1005d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    dh m1617b(int i) {
        for (int i2 = 0; i2 < this.f923e.size(); i2++) {
            dh dhVar = (dh) this.f923e.get(i2);
            if (dhVar.f998b == i) {
                return dhVar;
            }
        }
        return null;
    }

    dh m1618b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m1605a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    void m1619b() {
        int b = this.f926h.mo839b();
        this.f922b = b;
        boolean z = this.f923e.size() < (this.f899A * 2) + 1 && this.f923e.size() < b;
        boolean z2 = false;
        int i = this.f927i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f923e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            dh dhVar = (dh) this.f923e.get(i2);
            int a = this.f926h.m1136a(dhVar.f997a);
            if (a == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a == -2) {
                this.f923e.remove(i2);
                i2--;
                if (!z2) {
                    this.f926h.mo190a((ViewGroup) this);
                    z2 = true;
                }
                this.f926h.mo191a((ViewGroup) this, dhVar.f998b, dhVar.f997a);
                if (this.f927i == dhVar.f998b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f927i, b - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (dhVar.f998b != a) {
                if (dhVar.f998b == this.f927i) {
                    i = a;
                }
                dhVar.f998b = a;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f926h.mo193b((ViewGroup) this);
        }
        Collections.sort(this.f923e, f897c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                di diVar = (di) getChildAt(i2).getLayoutParams();
                if (!diVar.f1002a) {
                    diVar.f1004c = 0.0f;
                }
            }
            m1611a(i, false, true);
            requestLayout();
        }
    }

    void m1620c() {
        m1607a(this.f927i);
    }

    public boolean m1621c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m1622d();
            } else {
                if (i == 66 || i == 2) {
                    d = m1623e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m1580a(this.f925g, findNextFocus).left < m1580a(this.f925g, view).left) ? findNextFocus.requestFocus() : m1622d();
        } else {
            if (i == 66) {
                d = (view == null || m1580a(this.f925g, findNextFocus).left > m1580a(this.f925g, view).left) ? findNextFocus.requestFocus() : m1623e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f926h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f938t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f939u))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof di) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.f932n = true;
        if (this.f931m.isFinished() || !this.f931m.computeScrollOffset()) {
            m1587a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f931m.getCurrX();
        int currY = this.f931m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m1594d(currX)) {
                this.f931m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        bv.m2023d(this);
    }

    boolean m1622d() {
        if (this.f927i <= 0) {
            return false;
        }
        m1610a(this.f927i - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1615a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                dh a = m1605a(childAt);
                if (a != null && a.f998b == this.f927i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = bv.m2000a(this);
        if (a == 0 || (a == 1 && this.f926h != null && this.f926h.mo839b() > 1)) {
            int height;
            int width;
            if (!this.f916R.m2784a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f938t * ((float) width));
                this.f916R.m2783a(height, width);
                i = 0 | this.f916R.m2788a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f917S.m2784a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f939u + 1.0f)) * ((float) height));
                this.f917S.m2783a(width, height);
                i |= this.f917S.m2788a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f916R.m2789b();
            this.f917S.m2789b();
        }
        if (i != 0) {
            bv.m2023d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f935q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean m1623e() {
        if (this.f926h == null || this.f927i >= this.f926h.mo839b() - 1) {
            return false;
        }
        m1610a(this.f927i + 1, true);
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new di();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new di(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public bn getAdapter() {
        return this.f926h;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((di) ((View) this.ah.get(i2)).getLayoutParams()).f1007f;
    }

    public int getCurrentItem() {
        return this.f927i;
    }

    public int getOffscreenPageLimit() {
        return this.f899A;
    }

    public int getPageMargin() {
        return this.f934p;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f918T = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (!(this.f931m == null || this.f931m.isFinished())) {
            this.f931m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f934p > 0 && this.f935q != null && this.f923e.size() > 0 && this.f926h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f934p) / ((float) width);
            dh dhVar = (dh) this.f923e.get(0);
            float f2 = dhVar.f1001e;
            int size = this.f923e.size();
            int i = dhVar.f998b;
            int i2 = ((dh) this.f923e.get(size - 1)).f998b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > dhVar.f998b && i3 < size) {
                    i3++;
                    dhVar = (dh) this.f923e.get(i3);
                }
                if (i4 == dhVar.f998b) {
                    f3 = (dhVar.f1001e + dhVar.f1000d) * ((float) width);
                    f2 = (dhVar.f1001e + dhVar.f1000d) + f;
                } else {
                    float b = this.f926h.m1147b(i4);
                    f3 = (f2 + b) * ((float) width);
                    f2 += b + f;
                }
                if (((float) this.f934p) + f3 > ((float) scrollX)) {
                    this.f935q.setBounds((int) f3, this.f936r, (int) ((((float) this.f934p) + f3) + 0.5f), this.f937s);
                    this.f935q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m1600i();
            return false;
        }
        if (action != 0) {
            if (this.f900B) {
                return true;
            }
            if (this.f901C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f907I = x;
                this.f905G = x;
                x = motionEvent.getY();
                this.f908J = x;
                this.f906H = x;
                this.f909K = az.m1907b(motionEvent, 0);
                this.f901C = false;
                this.f932n = true;
                this.f931m.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.f931m.getFinalX() - this.f931m.getCurrX()) > this.f914P) {
                    this.f931m.abortAnimation();
                    this.f944z = false;
                    m1620c();
                    this.f900B = true;
                    m1593c(true);
                    setScrollState(1);
                    break;
                }
                m1587a(false);
                this.f900B = false;
                break;
            case 2:
                action = this.f909K;
                if (action != -1) {
                    action = az.m1905a(motionEvent, action);
                    float c = az.m1908c(motionEvent, action);
                    float f = c - this.f905G;
                    float abs = Math.abs(f);
                    float d = az.m1910d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f908J);
                    if (f == 0.0f || m1588a(this.f905G, f) || !m1616a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f904F) && 0.5f * abs > abs2) {
                            this.f900B = true;
                            m1593c(true);
                            setScrollState(1);
                            this.f905G = f > 0.0f ? this.f907I + ((float) this.f904F) : this.f907I - ((float) this.f904F);
                            this.f906H = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f904F)) {
                            this.f901C = true;
                        }
                        if (this.f900B && m1592b(c)) {
                            bv.m2023d(this);
                            break;
                        }
                    }
                    this.f905G = c;
                    this.f906H = d;
                    this.f901C = true;
                    return false;
                }
                break;
            case 6:
                m1586a(motionEvent);
                break;
        }
        if (this.f910L == null) {
            this.f910L = VelocityTracker.obtain();
        }
        this.f910L.addMovement(motionEvent);
        return this.f900B;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        di diVar;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                diVar = (di) childAt.getLayoutParams();
                if (diVar.f1002a) {
                    int i9 = diVar.f1003b & 112;
                    switch (diVar.f1003b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                diVar = (di) childAt2.getLayoutParams();
                if (!diVar.f1002a) {
                    dh a = m1605a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f1001e * ((float) max))) + paddingLeft;
                        if (diVar.f1005d) {
                            diVar.f1005d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (diVar.f1004c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f936r = paddingTop;
        this.f937s = i6 - paddingBottom;
        this.f921W = i7;
        if (this.f918T) {
            m1583a(this.f927i, false, 0, false);
        }
        this.f918T = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f903E = Math.min(measuredWidth / 10, this.f902D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            di diVar;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                diVar = (di) childAt.getLayoutParams();
                if (diVar != null && diVar.f1002a) {
                    int i6 = diVar.f1003b & 7;
                    int i7 = diVar.f1003b & 112;
                    i3 = Integer.MIN_VALUE;
                    i4 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (diVar.width != -2) {
                        i7 = 1073741824;
                        i3 = diVar.width != -1 ? diVar.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (diVar.height != -2) {
                        i4 = 1073741824;
                        if (diVar.height != -1) {
                            measuredWidth = diVar.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f940v = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f941w = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f942x = true;
        m1620c();
        this.f942x = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                diVar = (di) childAt2.getLayoutParams();
                if (diVar == null || !diVar.f1002a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (diVar.f1004c * ((float) paddingLeft)), 1073741824), this.f941w);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                dh a = m1605a(childAt);
                if (a != null && a.f998b == this.f927i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0219do) {
            C0219do c0219do = (C0219do) parcelable;
            super.onRestoreInstanceState(c0219do.getSuperState());
            if (this.f926h != null) {
                this.f926h.mo189a(c0219do.f1011b, c0219do.f1012c);
                m1611a(c0219do.f1010a, false, true);
                return;
            }
            this.f928j = c0219do.f1010a;
            this.f929k = c0219do.f1011b;
            this.f930l = c0219do.f1012c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c0219do = new C0219do(super.onSaveInstanceState());
        c0219do.f1010a = this.f927i;
        if (this.f926h != null) {
            c0219do.f1011b = this.f926h.mo187a();
        }
        return c0219do;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m1582a(i, i3, this.f934p, this.f934p);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f915Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f926h == null || this.f926h.mo839b() == 0) {
            return false;
        }
        if (this.f910L == null) {
            this.f910L = VelocityTracker.obtain();
        }
        this.f910L.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f931m.abortAnimation();
                this.f944z = false;
                m1620c();
                x = motionEvent.getX();
                this.f907I = x;
                this.f905G = x;
                x = motionEvent.getY();
                this.f908J = x;
                this.f906H = x;
                this.f909K = az.m1907b(motionEvent, 0);
                break;
            case 1:
                if (this.f900B) {
                    VelocityTracker velocityTracker = this.f910L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f912N);
                    a = (int) bq.m1984a(velocityTracker, this.f909K);
                    this.f944z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    dh j = m1601j();
                    m1612a(m1579a(j.f998b, ((((float) scrollX) / ((float) clientWidth)) - j.f1001e) / j.f1000d, a, (int) (az.m1908c(motionEvent, az.m1905a(motionEvent, this.f909K)) - this.f907I)), true, true, a);
                    z = m1600i();
                    break;
                }
                break;
            case 2:
                if (!this.f900B) {
                    a = az.m1905a(motionEvent, this.f909K);
                    if (a == -1) {
                        z = m1600i();
                        break;
                    }
                    float c = az.m1908c(motionEvent, a);
                    float abs = Math.abs(c - this.f905G);
                    float d = az.m1910d(motionEvent, a);
                    x = Math.abs(d - this.f906H);
                    if (abs > ((float) this.f904F) && abs > x) {
                        this.f900B = true;
                        m1593c(true);
                        this.f905G = c - this.f907I > 0.0f ? this.f907I + ((float) this.f904F) : this.f907I - ((float) this.f904F);
                        this.f906H = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f900B) {
                    z = false | m1592b(az.m1908c(motionEvent, az.m1905a(motionEvent, this.f909K)));
                    break;
                }
                break;
            case 3:
                if (this.f900B) {
                    m1583a(this.f927i, true, 0, false);
                    z = m1600i();
                    break;
                }
                break;
            case 5:
                a = az.m1906b(motionEvent);
                this.f905G = az.m1908c(motionEvent, a);
                this.f909K = az.m1907b(motionEvent, a);
                break;
            case 6:
                m1586a(motionEvent);
                this.f905G = az.m1908c(motionEvent, az.m1905a(motionEvent, this.f909K));
                break;
        }
        if (z) {
            bv.m2023d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f942x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(bn bnVar) {
        if (this.f926h != null) {
            this.f926h.m1140a(null);
            this.f926h.mo190a((ViewGroup) this);
            for (int i = 0; i < this.f923e.size(); i++) {
                dh dhVar = (dh) this.f923e.get(i);
                this.f926h.mo191a((ViewGroup) this, dhVar.f998b, dhVar.f997a);
            }
            this.f926h.mo193b((ViewGroup) this);
            this.f923e.clear();
            m1598g();
            this.f927i = 0;
            scrollTo(0, 0);
        }
        bn bnVar2 = this.f926h;
        this.f926h = bnVar;
        this.f922b = 0;
        if (this.f926h != null) {
            if (this.f933o == null) {
                this.f933o = new dn();
            }
            this.f926h.m1140a(this.f933o);
            this.f944z = false;
            boolean z = this.f918T;
            this.f918T = true;
            this.f922b = this.f926h.mo839b();
            if (this.f928j >= 0) {
                this.f926h.mo189a(this.f929k, this.f930l);
                m1611a(this.f928j, false, true);
                this.f928j = -1;
                this.f929k = null;
                this.f930l = null;
            } else if (z) {
                requestLayout();
            } else {
                m1620c();
            }
        }
        if (this.ad != null && bnVar2 != bnVar) {
            this.ad.m2332a(bnVar2, bnVar);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.af == null) {
                try {
                    this.af = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.af.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f944z = false;
        m1611a(i, !this.f918T, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f899A) {
            this.f899A = i;
            m1620c();
        }
    }

    void setOnAdapterChangeListener(dk dkVar) {
        this.ad = dkVar;
    }

    @Deprecated
    public void setOnPageChangeListener(dl dlVar) {
        this.ab = dlVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.f934p;
        this.f934p = i;
        int width = getWidth();
        m1582a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f935q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f935q;
    }
}
