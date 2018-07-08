package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.p002f.C0142h;
import android.support.v4.view.az;
import android.support.v4.view.bi;
import android.support.v4.view.bj;
import android.support.v4.view.bo;
import android.support.v4.view.bq;
import android.support.v4.view.bv;
import android.support.v4.view.cu;
import android.support.v4.view.p016a.C0183a;
import android.support.v4.widget.C0258s;
import android.support.v7.p019d.C0310b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup implements bi, bo {
    private static final Interpolator ao = new dt();
    private static final boolean f117j;
    private static final Class[] f118k = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private boolean f119A;
    private boolean f120B;
    private int f121C;
    private boolean f122D;
    private final boolean f123E;
    private final AccessibilityManager f124F;
    private List f125G;
    private boolean f126H;
    private int f127I;
    private C0258s f128J;
    private C0258s f129K;
    private C0258s f130L;
    private C0258s f131M;
    private int f132N;
    private int f133O;
    private VelocityTracker f134P;
    private int f135Q;
    private int f136R;
    private int f137S;
    private int f138T;
    private int f139U;
    private final int f140V;
    private final int f141W;
    final eo f142a;
    private float aa;
    private final ex ab;
    private em ac;
    private List ad;
    private ed ae;
    private boolean af;
    private ez ag;
    private ea ah;
    private final int[] ai;
    private final bj aj;
    private final int[] ak;
    private final int[] al;
    private final int[] am;
    private Runnable an;
    private final gt ap;
    ai f143b;
    br f144c;
    final gr f145d;
    eh f146e;
    eb f147f;
    final ev f148g;
    boolean f149h;
    boolean f150i;
    private final eq f151l;
    private er f152m;
    private boolean f153n;
    private final Runnable f154o;
    private final Rect f155p;
    private dx f156q;
    private ep f157r;
    private final ArrayList f158s;
    private final ArrayList f159t;
    private el f160u;
    private boolean f161v;
    private boolean f162w;
    private boolean f163x;
    private int f164y;
    private boolean f165z;

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        f117j = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f151l = new eq();
        this.f142a = new eo(this);
        this.f145d = new gr();
        this.f154o = new dr(this);
        this.f155p = new Rect();
        this.f158s = new ArrayList();
        this.f159t = new ArrayList();
        this.f164y = 0;
        this.f126H = false;
        this.f127I = 0;
        this.f147f = new bx();
        this.f132N = 0;
        this.f133O = -1;
        this.aa = Float.MIN_VALUE;
        this.ab = new ex(this);
        this.f148g = new ev();
        this.f149h = false;
        this.f150i = false;
        this.ae = new ef();
        this.af = false;
        this.ai = new int[2];
        this.ak = new int[2];
        this.al = new int[2];
        this.am = new int[2];
        this.an = new ds(this);
        this.ap = new du(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.f123E = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f139U = viewConfiguration.getScaledTouchSlop();
        this.f140V = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f141W = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(bv.m2000a(this) == 2);
        this.f147f.m4258a(this.ae);
        m184a();
        m171s();
        if (bv.m2026e(this) == 0) {
            bv.m2020c((View) this, 1);
        }
        this.f124F = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ez(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0310b.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(C0310b.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            m113a(context, string, attributeSet, i, 0);
        }
        this.aj = new bj(this);
        setNestedScrollingEnabled(true);
    }

    private void m100A() {
        this.f127I--;
        if (this.f127I < 1) {
            this.f127I = 0;
            m101B();
        }
    }

    private void m101B() {
        int i = this.f121C;
        this.f121C = 0;
        if (i != 0 && m215i()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0183a.m1625a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void m102C() {
        if (!this.af && this.f161v) {
            bv.m2010a((View) this, this.an);
            this.af = true;
        }
    }

    private boolean m103D() {
        return this.f147f != null && this.f146e.mo666b();
    }

    private void m104E() {
        boolean z = true;
        if (this.f126H) {
            this.f143b.m4033a();
            m221o();
            this.f146e.mo684a(this);
        }
        if (m103D()) {
            this.f143b.m4039b();
        } else {
            this.f143b.m4044e();
        }
        boolean z2 = this.f149h || this.f150i;
        ev evVar = this.f148g;
        boolean z3 = this.f163x && this.f147f != null && ((this.f126H || z2 || this.f146e.f1761a) && (!this.f126H || this.f156q.m4490b()));
        evVar.f2244i = z3;
        ev evVar2 = this.f148g;
        if (!(this.f148g.f2244i && z2 && !this.f126H && m103D())) {
            z = false;
        }
        evVar2.f2245j = z;
    }

    private void m105F() {
        int b;
        int i;
        ey c;
        boolean z = true;
        this.f148g.m4605a(1);
        this.f148g.f2247l = false;
        m194b();
        this.f145d.m4870a();
        m180z();
        m104E();
        ev evVar = this.f148g;
        if (!(this.f148g.f2244i && this.f150i)) {
            z = false;
        }
        evVar.f2246k = z;
        this.f150i = false;
        this.f149h = false;
        this.f148g.f2243h = this.f148g.f2245j;
        this.f148g.f2236a = this.f156q.mo826a();
        m124a(this.ai);
        if (this.f148g.f2244i) {
            b = this.f144c.m4193b();
            for (i = 0; i < b; i++) {
                c = m139c(this.f144c.m4195b(i));
                if (!c.m4646c() && (!c.m4657n() || this.f156q.m4490b())) {
                    this.f145d.m4872a(c, this.f147f.m4256a(this.f148g, c, eb.m4254d(c), c.m4664u()));
                    if (!(!this.f148g.f2246k || !c.m4667x() || c.m4660q() || c.m4646c() || c.m4657n())) {
                        this.f145d.m4871a(m181a(c), c);
                    }
                }
            }
        }
        if (this.f148g.f2245j) {
            m219m();
            z = this.f148g.f2242g;
            this.f148g.f2242g = false;
            this.f146e.mo670c(this.f142a, this.f148g);
            this.f148g.f2242g = z;
            for (i = 0; i < this.f144c.m4193b(); i++) {
                c = m139c(this.f144c.m4195b(i));
                if (!(c.m4646c() || this.f145d.m4880d(c))) {
                    b = eb.m4254d(c);
                    boolean a = c.m4643a(8192);
                    if (!a) {
                        b |= 4096;
                    }
                    ee a2 = this.f147f.m4256a(this.f148g, c, b, c.m4664u());
                    if (a) {
                        m121a(c, a2);
                    } else {
                        this.f145d.m4877b(c, a2);
                    }
                }
            }
            m220n();
        } else {
            m220n();
        }
        m100A();
        m190a(false);
        this.f148g.f2238c = 2;
    }

    private void m106G() {
        m194b();
        m180z();
        this.f148g.m4605a(6);
        this.f143b.m4044e();
        this.f148g.f2236a = this.f156q.mo826a();
        this.f148g.f2241f = 0;
        this.f148g.f2243h = false;
        this.f146e.mo670c(this.f142a, this.f148g);
        this.f148g.f2242g = false;
        this.f152m = null;
        ev evVar = this.f148g;
        boolean z = this.f148g.f2244i && this.f147f != null;
        evVar.f2244i = z;
        this.f148g.f2238c = 4;
        m100A();
        m190a(false);
    }

    private void m107H() {
        this.f148g.m4605a(4);
        m194b();
        m180z();
        this.f148g.f2238c = 1;
        if (this.f148g.f2244i) {
            for (int b = this.f144c.m4193b() - 1; b >= 0; b--) {
                ey c = m139c(this.f144c.m4195b(b));
                if (!c.m4646c()) {
                    long a = m181a(c);
                    ee a2 = this.f147f.m4255a(this.f148g, c);
                    ey a3 = this.f145d.m4869a(a);
                    if (a3 == null || a3.m4646c()) {
                        this.f145d.m4879c(c, a2);
                    } else {
                        boolean a4 = this.f145d.m4874a(a3);
                        boolean a5 = this.f145d.m4874a(c);
                        if (a4 && a3 == c) {
                            this.f145d.m4879c(c, a2);
                        } else {
                            ee b2 = this.f145d.m4875b(a3);
                            this.f145d.m4879c(c, a2);
                            ee c2 = this.f145d.m4878c(c);
                            if (b2 == null) {
                                m112a(a, c, a3);
                            } else {
                                m123a(a3, c, b2, c2, a4, a5);
                            }
                        }
                    }
                }
            }
            this.f145d.m4873a(this.ap);
        }
        this.f146e.m3676b(this.f142a);
        this.f148g.f2240e = this.f148g.f2236a;
        this.f126H = false;
        this.f148g.f2244i = false;
        this.f148g.f2245j = false;
        this.f146e.f1761a = false;
        if (this.f142a.f2215d != null) {
            this.f142a.f2215d.clear();
        }
        m100A();
        m190a(false);
        this.f145d.m4870a();
        if (m159j(this.ai[0], this.ai[1])) {
            m214h(0, 0);
        }
    }

    private void m108I() {
        if (!this.f126H) {
            this.f126H = true;
            int c = this.f144c.m4196c();
            for (int i = 0; i < c; i++) {
                ey c2 = m139c(this.f144c.m4197c(i));
                if (!(c2 == null || c2.m4646c())) {
                    c2.m4645b(512);
                }
            }
            this.f142a.m4560g();
        }
    }

    private void m109J() {
        int b = this.f144c.m4193b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f144c.m4195b(i);
            ey a = m183a(b2);
            if (!(a == null || a.f2263h == null)) {
                View view = a.f2263h.f2256a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private String m110a(Context context, String str) {
        return str.charAt(0) == '.' ? context.getPackageName() + str : !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m111a(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.m201d();
        r2 = r7.f128J;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.m2786a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.m207f();
        r2 = r7.f129K;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.m2786a(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.view.bv.m2023d(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.m204e();
        r2 = r7.f130L;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.m2786a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.m211g();
        r2 = r7.f131M;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.m2786a(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void m112a(long j, ey eyVar, ey eyVar2) {
        int b = this.f144c.m4193b();
        int i = 0;
        while (i < b) {
            ey c = m139c(this.f144c.m4195b(i));
            if (c == eyVar || m181a(c) != j) {
                i++;
            } else if (this.f156q == null || !this.f156q.m4490b()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + c + " \n View Holder 2:" + eyVar);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + c + " \n View Holder 2:" + eyVar);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + eyVar2 + " cannot be found but it is necessary for " + eyVar);
    }

    private void m113a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String a = m110a(context, trim);
                try {
                    Object[] objArr;
                    Constructor constructor;
                    Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(a).asSubclass(eh.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(f118k);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((eh) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private void m120a(dx dxVar, boolean z, boolean z2) {
        if (this.f156q != null) {
            this.f156q.m4488b(this.f151l);
            this.f156q.m4487b(this);
        }
        if (!z || z2) {
            if (this.f147f != null) {
                this.f147f.mo722c();
            }
            if (this.f146e != null) {
                this.f146e.m3687c(this.f142a);
                this.f146e.m3676b(this.f142a);
            }
            this.f142a.m4533a();
        }
        this.f143b.m4033a();
        dx dxVar2 = this.f156q;
        this.f156q = dxVar;
        if (dxVar != null) {
            dxVar.m4481a(this.f151l);
            dxVar.m4480a(this);
        }
        if (this.f146e != null) {
            this.f146e.m3642a(dxVar2, this.f156q);
        }
        this.f142a.m4536a(dxVar2, this.f156q, z);
        this.f148g.f2242g = true;
        m221o();
    }

    private void m121a(ey eyVar, ee eeVar) {
        eyVar.m4637a(0, 8192);
        if (this.f148g.f2246k && eyVar.m4667x() && !eyVar.m4660q() && !eyVar.m4646c()) {
            this.f145d.m4871a(m181a(eyVar), eyVar);
        }
        this.f145d.m4872a(eyVar, eeVar);
    }

    private void m122a(ey eyVar, ee eeVar, ee eeVar2) {
        eyVar.m4642a(false);
        if (this.f147f.mo712b(eyVar, eeVar, eeVar2)) {
            m102C();
        }
    }

    private void m123a(ey eyVar, ey eyVar2, ee eeVar, ee eeVar2, boolean z, boolean z2) {
        eyVar.m4642a(false);
        if (z) {
            m134b(eyVar);
        }
        if (eyVar != eyVar2) {
            if (z2) {
                m134b(eyVar2);
            }
            eyVar.f2262g = eyVar2;
            m134b(eyVar);
            this.f142a.m4554d(eyVar);
            eyVar2.m4642a(false);
            eyVar2.f2263h = eyVar;
        }
        if (this.f147f.mo711a(eyVar, eyVar2, eeVar, eeVar2)) {
            m102C();
        }
    }

    private void m124a(int[] iArr) {
        int b = this.f144c.m4193b();
        if (b == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            int i4;
            ey c = m139c(this.f144c.m4195b(i3));
            if (c.m4646c()) {
                i4 = i;
            } else {
                i4 = c.m4647d();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3++;
            i = i4;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean m128a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f160u = null;
        }
        int size = this.f159t.size();
        int i = 0;
        while (i < size) {
            el elVar = (el) this.f159t.get(i);
            if (!elVar.m4515a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f160u = elVar;
                return true;
            }
        }
        return false;
    }

    private void m134b(ey eyVar) {
        View view = eyVar.f2256a;
        boolean z = view.getParent() == this;
        this.f142a.m4554d(m183a(view));
        if (eyVar.m4661r()) {
            this.f144c.m4190a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f144c.m4200d(view);
        } else {
            this.f144c.m4192a(view, true);
        }
    }

    private void m135b(ey eyVar, ee eeVar, ee eeVar2) {
        m134b(eyVar);
        eyVar.m4642a(false);
        if (this.f147f.mo710a(eyVar, eeVar, eeVar2)) {
            m102C();
        }
    }

    private boolean m138b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f160u != null) {
            if (action == 0) {
                this.f160u = null;
            } else {
                this.f160u.m4516b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f160u = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f159t.size();
            for (int i = 0; i < size; i++) {
                el elVar = (el) this.f159t.get(i);
                if (elVar.m4515a(this, motionEvent)) {
                    this.f160u = elVar;
                    return true;
                }
            }
        }
        return false;
    }

    static ey m139c(View view) {
        return view == null ? null : ((ej) view.getLayoutParams()).f2123a;
    }

    private void m142c(MotionEvent motionEvent) {
        int b = az.m1906b(motionEvent);
        if (az.m1907b(motionEvent, b) == this.f133O) {
            b = b == 0 ? 1 : 0;
            this.f133O = az.m1907b(motionEvent, b);
            int c = (int) (az.m1908c(motionEvent, b) + 0.5f);
            this.f137S = c;
            this.f135Q = c;
            b = (int) (az.m1910d(motionEvent, b) + 0.5f);
            this.f138T = b;
            this.f136R = b;
        }
    }

    private boolean m145c(ey eyVar) {
        return this.f147f == null || this.f147f.mo719a(eyVar, eyVar.m4664u());
    }

    private int m146d(ey eyVar) {
        return (eyVar.m4643a(524) || !eyVar.m4659p()) ? -1 : this.f143b.m4041c(eyVar.f2257b);
    }

    private void m148e(int i) {
        if (this.f146e != null) {
            this.f146e.mo672d(i);
            awakenScrollBars();
        }
    }

    private float getScrollFactor() {
        if (this.aa == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.aa = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.aa;
    }

    private boolean m153h(View view) {
        m194b();
        boolean f = this.f144c.m4202f(view);
        if (f) {
            ey c = m139c(view);
            this.f142a.m4554d(c);
            this.f142a.m4545b(c);
        }
        m190a(!f);
        return f;
    }

    private void m154i(int i, int i2) {
        int i3 = 0;
        if (!(this.f128J == null || this.f128J.m2784a() || i <= 0)) {
            i3 = this.f128J.m2790c();
        }
        if (!(this.f130L == null || this.f130L.m2784a() || i >= 0)) {
            i3 |= this.f130L.m2790c();
        }
        if (!(this.f129K == null || this.f129K.m2784a() || i2 <= 0)) {
            i3 |= this.f129K.m2790c();
        }
        if (!(this.f131M == null || this.f131M.m2784a() || i2 >= 0)) {
            i3 |= this.f131M.m2790c();
        }
        if (i3 != 0) {
            bv.m2023d(this);
        }
    }

    private void m156i(View view) {
        ey c = m139c(view);
        m209f(view);
        if (!(this.f156q == null || c == null)) {
            this.f156q.m4495d(c);
        }
        if (this.f125G != null) {
            for (int size = this.f125G.size() - 1; size >= 0; size--) {
                ((ek) this.f125G.get(size)).m4513b(view);
            }
        }
    }

    private void m158j(View view) {
        ey c = m139c(view);
        m206e(view);
        if (!(this.f156q == null || c == null)) {
            this.f156q.m4494c(c);
        }
        if (this.f125G != null) {
            for (int size = this.f125G.size() - 1; size >= 0; size--) {
                ((ek) this.f125G.get(size)).m4512a(view);
            }
        }
    }

    private boolean m159j(int i, int i2) {
        int b = this.f144c.m4193b();
        if (b == 0) {
            return (i == 0 && i2 == 0) ? false : true;
        } else {
            for (int i3 = 0; i3 < b; i3++) {
                ey c = m139c(this.f144c.m4195b(i3));
                if (!c.m4646c()) {
                    int d = c.m4647d();
                    if (d < i || d > i2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private void m171s() {
        this.f144c = new br(new dv(this));
    }

    private void setScrollState(int i) {
        if (i != this.f132N) {
            this.f132N = i;
            if (i != 2) {
                m176v();
            }
            m202d(i);
        }
    }

    private void m172t() {
        if (!this.f163x) {
            return;
        }
        if (this.f126H) {
            C0142h.m1462a("RV FullInvalidate");
            m217k();
            C0142h.m1461a();
        } else if (!this.f143b.m4043d()) {
        } else {
            if (this.f143b.m4037a(4) && !this.f143b.m4037a(11)) {
                C0142h.m1462a("RV PartialInvalidate");
                m194b();
                this.f143b.m4039b();
                if (!this.f165z) {
                    if (m175u()) {
                        m217k();
                    } else {
                        this.f143b.m4042c();
                    }
                }
                m190a(true);
                C0142h.m1461a();
            } else if (this.f143b.m4043d()) {
                C0142h.m1462a("RV FullInvalidate");
                m217k();
                C0142h.m1461a();
            }
        }
    }

    private boolean m175u() {
        int b = this.f144c.m4193b();
        for (int i = 0; i < b; i++) {
            ey c = m139c(this.f144c.m4195b(i));
            if (c != null && !c.m4646c() && c.m4667x()) {
                return true;
            }
        }
        return false;
    }

    private void m176v() {
        this.ab.m4621b();
        if (this.f146e != null) {
            this.f146e.m3623E();
        }
    }

    private void m177w() {
        int i = 0;
        if (this.f128J != null) {
            i = this.f128J.m2790c();
        }
        if (this.f129K != null) {
            i |= this.f129K.m2790c();
        }
        if (this.f130L != null) {
            i |= this.f130L.m2790c();
        }
        if (this.f131M != null) {
            i |= this.f131M.m2790c();
        }
        if (i != 0) {
            bv.m2023d(this);
        }
    }

    private void m178x() {
        if (this.f134P != null) {
            this.f134P.clear();
        }
        stopNestedScroll();
        m177w();
    }

    private void m179y() {
        m178x();
        setScrollState(0);
    }

    private void m180z() {
        this.f127I++;
    }

    long m181a(ey eyVar) {
        return this.f156q.m4490b() ? eyVar.m4650g() : (long) eyVar.f2257b;
    }

    ey m182a(int i, boolean z) {
        int c = this.f144c.m4196c();
        for (int i2 = 0; i2 < c; i2++) {
            ey c2 = m139c(this.f144c.m4197c(i2));
            if (!(c2 == null || c2.m4660q())) {
                if (z) {
                    if (c2.f2257b == i) {
                        return c2;
                    }
                } else if (c2.m4647d() == i) {
                    return c2;
                }
            }
        }
        return null;
    }

    public ey m183a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return m139c(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void m184a() {
        this.f143b = new ai(new dw(this));
    }

    public void m185a(int i) {
        int b = this.f144c.m4193b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f144c.m4195b(i2).offsetTopAndBottom(i);
        }
    }

    public void m186a(int i, int i2) {
        int i3 = 0;
        if (this.f146e == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f119A) {
            if (!this.f146e.mo673d()) {
                i = 0;
            }
            if (this.f146e.mo675e()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.ab.m4622b(i, i3);
            }
        }
    }

    void m187a(int i, int i2, Object obj) {
        int c = this.f144c.m4196c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View c2 = this.f144c.m4197c(i4);
            ey c3 = m139c(c2);
            if (c3 != null && !c3.m4646c() && c3.f2257b >= i && c3.f2257b < i3) {
                c3.m4645b(2);
                c3.m4641a(obj);
                ((ej) c2.getLayoutParams()).f2125c = true;
            }
        }
        this.f142a.m4549c(i, i2);
    }

    void m188a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f144c.m4196c();
        for (int i4 = 0; i4 < c; i4++) {
            ey c2 = m139c(this.f144c.m4197c(i4));
            if (!(c2 == null || c2.m4646c())) {
                if (c2.f2257b >= i3) {
                    c2.m4639a(-i2, z);
                    this.f148g.f2242g = true;
                } else if (c2.f2257b >= i) {
                    c2.m4638a(i - 1, -i2, z);
                    this.f148g.f2242g = true;
                }
            }
        }
        this.f142a.m4544b(i, i2, z);
        requestLayout();
    }

    void m189a(String str) {
        if (!m216j()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    void m190a(boolean z) {
        if (this.f164y < 1) {
            this.f164y = 1;
        }
        if (!z) {
            this.f165z = false;
        }
        if (this.f164y == 1) {
            if (!(!z || !this.f165z || this.f119A || this.f146e == null || this.f156q == null)) {
                m217k();
            }
            if (!this.f119A) {
                this.f165z = false;
            }
        }
        this.f164y--;
    }

    boolean m191a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        m172t();
        if (this.f156q != null) {
            int b;
            m194b();
            m180z();
            C0142h.m1462a("RV Scroll");
            if (i != 0) {
                a = this.f146e.mo657a(i, this.f142a, this.f148g);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.f146e.mo664b(i2, this.f142a, this.f148g);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            C0142h.m1461a();
            m109J();
            m100A();
            m190a(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.f158s.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.ak)) {
            this.f137S -= this.ak[0];
            this.f138T -= this.ak[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.ak[0], (float) this.ak[1]);
            }
            int[] iArr = this.am;
            iArr[0] = iArr[0] + this.ak[0];
            iArr = this.am;
            iArr[1] = iArr[1] + this.ak[1];
        } else if (bv.m2000a(this) != 2) {
            if (motionEvent != null) {
                m111a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            m154i(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            m214h(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && a == 0) ? false : true;
    }

    boolean m192a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!m216j()) {
            return false;
        }
        int b = accessibilityEvent != null ? C0183a.m1626b(accessibilityEvent) : 0;
        if (b != 0) {
            i = b;
        }
        this.f121C = i | this.f121C;
        return true;
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        if (this.f146e == null || !this.f146e.m3662a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public View m193b(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    void m194b() {
        this.f164y++;
        if (this.f164y == 1 && !this.f119A) {
            this.f165z = false;
        }
    }

    public void m195b(int i) {
        int b = this.f144c.m4193b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f144c.m4195b(i2).offsetLeftAndRight(i);
        }
    }

    public boolean m196b(int i, int i2) {
        if (this.f146e == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f119A) {
            return false;
        } else {
            boolean d = this.f146e.mo673d();
            boolean e = this.f146e.mo675e();
            if (!d || Math.abs(i) < this.f140V) {
                i = 0;
            }
            if (!e || Math.abs(i2) < this.f140V) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            d = d || e;
            dispatchNestedFling((float) i, (float) i2, d);
            if (!d) {
                return false;
            }
            this.ab.m4617a(Math.max(-this.f141W, Math.min(i, this.f141W)), Math.max(-this.f141W, Math.min(i2, this.f141W)));
            return true;
        }
    }

    public void m197c() {
        setScrollState(0);
        m176v();
    }

    public void m198c(int i) {
    }

    void m199c(int i, int i2) {
        if (i < 0) {
            m201d();
            this.f128J.m2787a(-i);
        } else if (i > 0) {
            m204e();
            this.f130L.m2787a(i);
        }
        if (i2 < 0) {
            m207f();
            this.f129K.m2787a(-i2);
        } else if (i2 > 0) {
            m211g();
            this.f131M.m2787a(i2);
        }
        if (i != 0 || i2 != 0) {
            bv.m2023d(this);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof ej) && this.f146e.mo692a((ej) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        return (this.f146e != null && this.f146e.mo673d()) ? this.f146e.mo671d(this.f148g) : 0;
    }

    public int computeHorizontalScrollOffset() {
        return (this.f146e != null && this.f146e.mo673d()) ? this.f146e.mo665b(this.f148g) : 0;
    }

    public int computeHorizontalScrollRange() {
        return (this.f146e != null && this.f146e.mo673d()) ? this.f146e.mo676f(this.f148g) : 0;
    }

    public int computeVerticalScrollExtent() {
        return (this.f146e != null && this.f146e.mo675e()) ? this.f146e.mo674e(this.f148g) : 0;
    }

    public int computeVerticalScrollOffset() {
        return (this.f146e != null && this.f146e.mo675e()) ? this.f146e.mo667c(this.f148g) : 0;
    }

    public int computeVerticalScrollRange() {
        return (this.f146e != null && this.f146e.mo675e()) ? this.f146e.mo677g(this.f148g) : 0;
    }

    public int m200d(View view) {
        ey c = m139c(view);
        return c != null ? c.m4647d() : -1;
    }

    void m201d() {
        if (this.f128J == null) {
            this.f128J = new C0258s(getContext());
            if (this.f153n) {
                this.f128J.m2783a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f128J.m2783a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m202d(int i) {
        if (this.f146e != null) {
            this.f146e.mo697k(i);
        }
        m198c(i);
        if (this.ac != null) {
            this.ac.m4517a(this, i);
        }
        if (this.ad != null) {
            for (int size = this.ad.size() - 1; size >= 0; size--) {
                ((em) this.ad.get(size)).m4517a(this, i);
            }
        }
    }

    void m203d(int i, int i2) {
        setMeasuredDimension(eh.m3607a(i, getPaddingLeft() + getPaddingRight(), bv.m2038o(this)), eh.m3607a(i2, getPaddingTop() + getPaddingBottom(), bv.m2039p(this)));
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.aj.m1975a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.aj.m1974a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.aj.m1978a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.aj.m1977a(i, i2, i3, i4, iArr);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.f158s.size();
        for (i = 0; i < size; i++) {
            ((eg) this.f158s.get(i)).m4511b(canvas, this, this.f148g);
        }
        if (this.f128J == null || this.f128J.m2784a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.f153n ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            i2 = (this.f128J == null || !this.f128J.m2788a(canvas)) ? 0 : 1;
            canvas.restoreToCount(i);
        }
        if (!(this.f129K == null || this.f129K.m2784a())) {
            size = canvas.save();
            if (this.f153n) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i = (this.f129K == null || !this.f129K.m2788a(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f130L == null || this.f130L.m2784a())) {
            size = canvas.save();
            int width = getWidth();
            i = this.f153n ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            i = (this.f130L == null || !this.f130L.m2788a(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f131M == null || this.f131M.m2784a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.f153n) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.f131M != null && this.f131M.m2788a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.f147f == null || this.f158s.size() <= 0 || !this.f147f.mo720b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            bv.m2023d(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    void m204e() {
        if (this.f130L == null) {
            this.f130L = new C0258s(getContext());
            if (this.f153n) {
                this.f130L.m2783a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f130L.m2783a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m205e(int i, int i2) {
        int i3;
        int c = this.f144c.m4196c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            ey c2 = m139c(this.f144c.m4197c(i6));
            if (c2 != null && c2.f2257b >= r3 && c2.f2257b <= r2) {
                if (c2.f2257b == i) {
                    c2.m4639a(i2 - i, false);
                } else {
                    c2.m4639a(i3, false);
                }
                this.f148g.f2242g = true;
            }
        }
        this.f142a.m4535a(i, i2);
        requestLayout();
    }

    public void m206e(View view) {
    }

    void m207f() {
        if (this.f129K == null) {
            this.f129K = new C0258s(getContext());
            if (this.f153n) {
                this.f129K.m2783a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f129K.m2783a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void m208f(int i, int i2) {
        int c = this.f144c.m4196c();
        for (int i3 = 0; i3 < c; i3++) {
            ey c2 = m139c(this.f144c.m4197c(i3));
            if (!(c2 == null || c2.m4646c() || c2.f2257b < i)) {
                c2.m4639a(i2, false);
                this.f148g.f2242g = true;
            }
        }
        this.f142a.m4543b(i, i2);
        requestLayout();
    }

    public void m209f(View view) {
    }

    public View focusSearch(View view, int i) {
        View d = this.f146e.m3695d(view, i);
        if (d != null) {
            return d;
        }
        d = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(d != null || this.f156q == null || this.f146e == null || m216j() || this.f119A)) {
            m194b();
            d = this.f146e.mo659a(view, i, this.f142a, this.f148g);
            m190a(false);
        }
        return d == null ? super.focusSearch(view, i) : d;
    }

    Rect m210g(View view) {
        ej ejVar = (ej) view.getLayoutParams();
        if (!ejVar.f2125c) {
            return ejVar.f2124b;
        }
        Rect rect = ejVar.f2124b;
        rect.set(0, 0, 0, 0);
        int size = this.f158s.size();
        for (int i = 0; i < size; i++) {
            this.f155p.set(0, 0, 0, 0);
            ((eg) this.f158s.get(i)).m4509a(this.f155p, view, this, this.f148g);
            rect.left += this.f155p.left;
            rect.top += this.f155p.top;
            rect.right += this.f155p.right;
            rect.bottom += this.f155p.bottom;
        }
        ejVar.f2125c = false;
        return rect;
    }

    void m211g() {
        if (this.f131M == null) {
            this.f131M = new C0258s(getContext());
            if (this.f153n) {
                this.f131M.m2783a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f131M.m2783a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void m212g(int i, int i2) {
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.f146e != null) {
            return this.f146e.mo658a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f146e != null) {
            return this.f146e.mo680a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.f146e != null) {
            return this.f146e.mo681a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public dx getAdapter() {
        return this.f156q;
    }

    public int getBaseline() {
        return this.f146e != null ? this.f146e.m3730r() : super.getBaseline();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.ah == null ? super.getChildDrawingOrder(i, i2) : this.ah.m4500a(i, i2);
    }

    public ez getCompatAccessibilityDelegate() {
        return this.ag;
    }

    public eb getItemAnimator() {
        return this.f147f;
    }

    public eh getLayoutManager() {
        return this.f146e;
    }

    public int getMaxFlingVelocity() {
        return this.f141W;
    }

    public int getMinFlingVelocity() {
        return this.f140V;
    }

    public en getRecycledViewPool() {
        return this.f142a.m4558f();
    }

    public int getScrollState() {
        return this.f132N;
    }

    void m213h() {
        this.f131M = null;
        this.f129K = null;
        this.f130L = null;
        this.f128J = null;
    }

    void m214h(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        m212g(i, i2);
        if (this.ac != null) {
            this.ac.m4518a(this, i, i2);
        }
        if (this.ad != null) {
            for (scrollY = this.ad.size() - 1; scrollY >= 0; scrollY--) {
                ((em) this.ad.get(scrollY)).m4518a(this, i, i2);
            }
        }
    }

    public boolean hasNestedScrollingParent() {
        return this.aj.m1979b();
    }

    boolean m215i() {
        return this.f124F != null && this.f124F.isEnabled();
    }

    public boolean isAttachedToWindow() {
        return this.f161v;
    }

    public boolean isNestedScrollingEnabled() {
        return this.aj.m1973a();
    }

    public boolean m216j() {
        return this.f127I > 0;
    }

    void m217k() {
        if (this.f156q == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f146e == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f148g.f2247l = false;
            if (this.f148g.f2238c == 1) {
                m105F();
                this.f146e.m3708f(this);
                m106G();
            } else if (!this.f143b.m4045f() && this.f146e.m3734v() == getWidth() && this.f146e.m3735w() == getHeight()) {
                this.f146e.m3708f(this);
            } else {
                this.f146e.m3708f(this);
                m106G();
            }
            m107H();
        }
    }

    void m218l() {
        int c = this.f144c.m4196c();
        for (int i = 0; i < c; i++) {
            ((ej) this.f144c.m4197c(i).getLayoutParams()).f2125c = true;
        }
        this.f142a.m4563j();
    }

    void m219m() {
        int c = this.f144c.m4196c();
        for (int i = 0; i < c; i++) {
            ey c2 = m139c(this.f144c.m4197c(i));
            if (!c2.m4646c()) {
                c2.m4644b();
            }
        }
    }

    void m220n() {
        int c = this.f144c.m4196c();
        for (int i = 0; i < c; i++) {
            ey c2 = m139c(this.f144c.m4197c(i));
            if (!c2.m4646c()) {
                c2.m4636a();
            }
        }
        this.f142a.m4562i();
    }

    void m221o() {
        int c = this.f144c.m4196c();
        for (int i = 0; i < c; i++) {
            ey c2 = m139c(this.f144c.m4197c(i));
            if (!(c2 == null || c2.m4646c())) {
                c2.m4645b(6);
            }
        }
        m218l();
        this.f142a.m4561h();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f127I = 0;
        this.f161v = true;
        this.f163x = false;
        if (this.f146e != null) {
            this.f146e.m3685c(this);
        }
        this.af = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f147f != null) {
            this.f147f.mo722c();
        }
        this.f163x = false;
        m197c();
        this.f161v = false;
        if (this.f146e != null) {
            this.f146e.m3675b(this, this.f142a);
        }
        removeCallbacks(this.an);
        this.f145d.m4876b();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f158s.size();
        for (int i = 0; i < size; i++) {
            ((eg) this.f158s.get(i)).m4507a(canvas, this, this.f148g);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f146e == null || this.f119A || (az.m1911d(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f = this.f146e.mo675e() ? -az.m1912e(motionEvent, 9) : 0.0f;
            float e = this.f146e.mo673d() ? az.m1912e(motionEvent, 10) : 0.0f;
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                m191a((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        boolean z = true;
        if (this.f119A) {
            return false;
        }
        if (m128a(motionEvent)) {
            m179y();
            return true;
        } else if (this.f146e == null) {
            return false;
        } else {
            boolean d = this.f146e.mo673d();
            boolean e = this.f146e.mo675e();
            if (this.f134P == null) {
                this.f134P = VelocityTracker.obtain();
            }
            this.f134P.addMovement(motionEvent);
            int a = az.m1904a(motionEvent);
            int b = az.m1906b(motionEvent);
            int i2;
            switch (a) {
                case 0:
                    if (this.f120B) {
                        this.f120B = false;
                    }
                    this.f133O = az.m1907b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.f137S = i;
                    this.f135Q = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.f138T = i;
                    this.f136R = i;
                    if (this.f132N == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.am;
                    this.am[1] = 0;
                    iArr[0] = 0;
                    i2 = d ? 1 : 0;
                    if (e) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case 1:
                    this.f134P.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    a = az.m1905a(motionEvent, this.f133O);
                    if (a >= 0) {
                        b = (int) (az.m1908c(motionEvent, a) + 0.5f);
                        a = (int) (az.m1910d(motionEvent, a) + 0.5f);
                        if (this.f132N != 1) {
                            b -= this.f135Q;
                            a -= this.f136R;
                            if (!d || Math.abs(b) <= this.f139U) {
                                d = false;
                            } else {
                                this.f137S = ((b < 0 ? -1 : 1) * this.f139U) + this.f135Q;
                                d = true;
                            }
                            if (e && Math.abs(a) > this.f139U) {
                                i2 = this.f136R;
                                int i3 = this.f139U;
                                if (a >= 0) {
                                    i = 1;
                                }
                                this.f138T = i2 + (i * i3);
                                d = true;
                            }
                            if (d) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f133O + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m179y();
                    break;
                case 5:
                    this.f133O = az.m1907b(motionEvent, b);
                    i2 = (int) (az.m1908c(motionEvent, b) + 0.5f);
                    this.f137S = i2;
                    this.f135Q = i2;
                    i2 = (int) (az.m1910d(motionEvent, b) + 0.5f);
                    this.f138T = i2;
                    this.f136R = i2;
                    break;
                case 6:
                    m142c(motionEvent);
                    break;
            }
            if (this.f132N != 1) {
                z = false;
            }
            return z;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0142h.m1462a("RV OnLayout");
        m217k();
        C0142h.m1461a();
        this.f163x = true;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.f146e == null) {
            m203d(i, i2);
        } else if (this.f146e.f1762b) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f146e.m3644a(this.f142a, this.f148g, i, i2);
            if (!z && this.f156q != null) {
                if (this.f148g.f2238c == 1) {
                    m105F();
                }
                this.f146e.m3632a(i, i2);
                this.f148g.f2247l = true;
                m106G();
                this.f146e.m3672b(i, i2);
                if (this.f146e.mo678j()) {
                    this.f146e.m3632a(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f148g.f2247l = true;
                    m106G();
                    this.f146e.m3672b(i, i2);
                }
            }
        } else if (this.f162w) {
            this.f146e.m3644a(this.f142a, this.f148g, i, i2);
        } else {
            if (this.f122D) {
                m194b();
                m104E();
                if (this.f148g.f2245j) {
                    this.f148g.f2243h = true;
                } else {
                    this.f143b.m4044e();
                    this.f148g.f2243h = false;
                }
                this.f122D = false;
                m190a(false);
            }
            if (this.f156q != null) {
                this.f148g.f2236a = this.f156q.mo826a();
            } else {
                this.f148g.f2236a = 0;
            }
            m194b();
            this.f146e.m3644a(this.f142a, this.f148g, i, i2);
            m190a(false);
            this.f148g.f2243h = false;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.f152m = (er) parcelable;
        super.onRestoreInstanceState(this.f152m.getSuperState());
        if (this.f146e != null && this.f152m.f2221a != null) {
            this.f146e.mo660a(this.f152m.f2221a);
        }
    }

    protected Parcelable onSaveInstanceState() {
        er erVar = new er(super.onSaveInstanceState());
        if (this.f152m != null) {
            erVar.m4568a(this.f152m);
        } else if (this.f146e != null) {
            erVar.f2221a = this.f146e.mo668c();
        } else {
            erVar.f2221a = null;
        }
        return erVar;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m213h();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f119A || this.f120B) {
            return false;
        }
        if (m138b(motionEvent)) {
            m179y();
            return true;
        } else if (this.f146e == null) {
            return false;
        } else {
            boolean d = this.f146e.mo673d();
            boolean e = this.f146e.mo675e();
            if (this.f134P == null) {
                this.f134P = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a = az.m1904a(motionEvent);
            int b = az.m1906b(motionEvent);
            if (a == 0) {
                int[] iArr = this.am;
                this.am[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.am[0], (float) this.am[1]);
            switch (a) {
                case 0:
                    this.f133O = az.m1907b(motionEvent, 0);
                    a = (int) (motionEvent.getX() + 0.5f);
                    this.f137S = a;
                    this.f135Q = a;
                    a = (int) (motionEvent.getY() + 0.5f);
                    this.f138T = a;
                    this.f136R = a;
                    a = d ? 1 : 0;
                    if (e) {
                        a |= 2;
                    }
                    startNestedScroll(a);
                    break;
                case 1:
                    this.f134P.addMovement(obtain);
                    this.f134P.computeCurrentVelocity(1000, (float) this.f141W);
                    float f = d ? -bq.m1984a(this.f134P, this.f133O) : 0.0f;
                    float f2 = e ? -bq.m1985b(this.f134P, this.f133O) : 0.0f;
                    if ((f == 0.0f && f2 == 0.0f) || !m196b((int) f, (int) f2)) {
                        setScrollState(0);
                    }
                    m178x();
                    z = true;
                    break;
                case 2:
                    a = az.m1905a(motionEvent, this.f133O);
                    if (a >= 0) {
                        int c = (int) (az.m1908c(motionEvent, a) + 0.5f);
                        int d2 = (int) (az.m1910d(motionEvent, a) + 0.5f);
                        int i = this.f137S - c;
                        a = this.f138T - d2;
                        if (dispatchNestedPreScroll(i, a, this.al, this.ak)) {
                            i -= this.al[0];
                            a -= this.al[1];
                            obtain.offsetLocation((float) this.ak[0], (float) this.ak[1]);
                            int[] iArr2 = this.am;
                            iArr2[0] = iArr2[0] + this.ak[0];
                            iArr2 = this.am;
                            iArr2[1] = iArr2[1] + this.ak[1];
                        }
                        if (this.f132N != 1) {
                            boolean z2;
                            if (!d || Math.abs(i) <= this.f139U) {
                                z2 = false;
                            } else {
                                i = i > 0 ? i - this.f139U : i + this.f139U;
                                z2 = true;
                            }
                            if (e && Math.abs(a) > this.f139U) {
                                a = a > 0 ? a - this.f139U : a + this.f139U;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.f132N == 1) {
                            this.f137S = c - this.ak[0];
                            this.f138T = d2 - this.ak[1];
                            if (!d) {
                                i = 0;
                            }
                            if (!e) {
                                a = 0;
                            }
                            if (m191a(i, a, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f133O + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m179y();
                    break;
                case 5:
                    this.f133O = az.m1907b(motionEvent, b);
                    a = (int) (az.m1908c(motionEvent, b) + 0.5f);
                    this.f137S = a;
                    this.f135Q = a;
                    a = (int) (az.m1910d(motionEvent, b) + 0.5f);
                    this.f138T = a;
                    this.f136R = a;
                    break;
                case 6:
                    m142c(motionEvent);
                    break;
            }
            if (!z) {
                this.f134P.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    public boolean m222p() {
        return !this.f163x || this.f126H || this.f143b.m4043d();
    }

    protected void removeDetachedView(View view, boolean z) {
        ey c = m139c(view);
        if (c != null) {
            if (c.m4661r()) {
                c.m4656m();
            } else if (!c.m4646c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + c);
            }
        }
        m156i(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.f146e.m3659a(this, this.f148g, view, view2) || view2 == null)) {
            this.f155p.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ej) {
                ej ejVar = (ej) layoutParams;
                if (!ejVar.f2125c) {
                    Rect rect = ejVar.f2124b;
                    Rect rect2 = this.f155p;
                    rect2.left -= rect.left;
                    rect2 = this.f155p;
                    rect2.right += rect.right;
                    rect2 = this.f155p;
                    rect2.top -= rect.top;
                    rect2 = this.f155p;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.f155p);
            offsetRectIntoDescendantCoords(view, this.f155p);
            requestChildRectangleOnScreen(view, this.f155p, !this.f163x);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f146e.m3660a(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f159t.size();
        for (int i = 0; i < size; i++) {
            ((el) this.f159t.get(i)).m4514a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.f164y != 0 || this.f119A) {
            this.f165z = true;
        } else {
            super.requestLayout();
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.f146e == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f119A) {
            boolean d = this.f146e.mo673d();
            boolean e = this.f146e.mo675e();
            if (d || e) {
                if (!d) {
                    i = 0;
                }
                if (!e) {
                    i2 = 0;
                }
                m191a(i, i2, null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!m192a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(ez ezVar) {
        this.ag = ezVar;
        bv.m2008a((View) this, this.ag);
    }

    public void setAdapter(dx dxVar) {
        setLayoutFrozen(false);
        m120a(dxVar, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ea eaVar) {
        if (eaVar != this.ah) {
            this.ah = eaVar;
            setChildrenDrawingOrderEnabled(this.ah != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f153n) {
            m213h();
        }
        this.f153n = z;
        super.setClipToPadding(z);
        if (this.f163x) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.f162w = z;
    }

    public void setItemAnimator(eb ebVar) {
        if (this.f147f != null) {
            this.f147f.mo722c();
            this.f147f.m4258a(null);
        }
        this.f147f = ebVar;
        if (this.f147f != null) {
            this.f147f.m4258a(this.ae);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.f142a.m4534a(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f119A) {
            m189a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f119A = true;
                this.f120B = true;
                m197c();
                return;
            }
            this.f119A = false;
            if (!(!this.f165z || this.f146e == null || this.f156q == null)) {
                requestLayout();
            }
            this.f165z = false;
        }
    }

    public void setLayoutManager(eh ehVar) {
        if (ehVar != this.f146e) {
            m197c();
            if (this.f146e != null) {
                if (this.f161v) {
                    this.f146e.m3675b(this, this.f142a);
                }
                this.f146e.m3673b(null);
            }
            this.f142a.m4533a();
            this.f144c.m4187a();
            this.f146e = ehVar;
            if (ehVar != null) {
                if (ehVar.f1767q != null) {
                    throw new IllegalArgumentException("LayoutManager " + ehVar + " is already attached to a RecyclerView: " + ehVar.f1767q);
                }
                this.f146e.m3673b(this);
                if (this.f161v) {
                    this.f146e.m3685c(this);
                }
            }
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.aj.m1972a(z);
    }

    @Deprecated
    public void setOnScrollListener(em emVar) {
        this.ac = emVar;
    }

    public void setRecycledViewPool(en enVar) {
        this.f142a.m4537a(enVar);
    }

    public void setRecyclerListener(ep epVar) {
        this.f157r = epVar;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.f139U = cu.m2315a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.f139U = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ew ewVar) {
        this.f142a.m4538a(ewVar);
    }

    public boolean startNestedScroll(int i) {
        return this.aj.m1976a(i);
    }

    public void stopNestedScroll() {
        this.aj.m1980c();
    }
}
