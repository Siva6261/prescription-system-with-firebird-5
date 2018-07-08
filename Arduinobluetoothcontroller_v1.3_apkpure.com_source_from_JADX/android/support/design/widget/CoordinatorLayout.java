package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.design.C0027h;
import android.support.design.C0028i;
import android.support.v4.p008c.C0066a;
import android.support.v4.p010d.p011a.C0106a;
import android.support.v4.view.C0230q;
import android.support.v4.view.az;
import android.support.v4.view.bk;
import android.support.v4.view.bl;
import android.support.v4.view.bv;
import android.support.v4.view.es;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements bk {
    static final String f237a;
    static final Class[] f238b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal f239c = new ThreadLocal();
    static final Comparator f240e;
    static final aj f241f;
    final Comparator f242d;
    private final List f243g;
    private final List f244h;
    private final List f245i;
    private final Rect f246j;
    private final Rect f247k;
    private final Rect f248l;
    private final int[] f249m;
    private Paint f250n;
    private boolean f251o;
    private int[] f252p;
    private View f253q;
    private View f254r;
    private View f255s;
    private af f256t;
    private boolean f257u;
    private es f258v;
    private boolean f259w;
    private Drawable f260x;
    private OnHierarchyChangeListener f261y;
    private final bl f262z;

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f237a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f240e = new ai();
            f241f = new ak();
        } else {
            f240e = null;
            f241f = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f242d = new C0061z(this);
        this.f243g = new ArrayList();
        this.f244h = new ArrayList();
        this.f245i = new ArrayList();
        this.f246j = new Rect();
        this.f247k = new Rect();
        this.f248l = new Rect();
        this.f249m = new int[2];
        this.f262z = new bl(this);
        ch.m705a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.CoordinatorLayout, i, C0027h.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C0028i.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f252p = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f252p.length;
            while (i2 < length) {
                int[] iArr = this.f252p;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f260x = obtainStyledAttributes.getDrawable(C0028i.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        if (f241f != null) {
            f241f.mo72a(this, new aa());
        }
        super.setOnHierarchyChangeListener(new ad());
    }

    private int m387a(int i) {
        if (this.f252p == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f252p.length) {
            return this.f252p[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static ab m388a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f237a)) {
            str = f237a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f239c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f239c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f238b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (ab) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private es m390a(es esVar) {
        boolean z = true;
        if (this.f258v == esVar) {
            return esVar;
        }
        this.f258v = esVar;
        boolean z2 = esVar != null && esVar.mo416b() > 0;
        this.f259w = z2;
        if (this.f259w || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        esVar = m397b(esVar);
        requestLayout();
        return esVar;
    }

    private void m392a(View view, View view2, int i) {
        ae aeVar = (ae) view.getLayoutParams();
        Rect rect = this.f246j;
        Rect rect2 = this.f247k;
        m411a(view2, rect);
        m410a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void m393a(List list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (f240e != null) {
            Collections.sort(list, f240e);
        }
    }

    private static void m394a(List list, Comparator comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }

    private boolean m395a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = az.m1904a(motionEvent);
        List list = this.f244h;
        m393a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            ae aeVar = (ae) view.getLayoutParams();
            ab b = aeVar.m508b();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case 0:
                            z2 = b.mo36a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = b.mo37b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.f253q = view;
                    }
                }
                z = z2;
                boolean e = aeVar.m513e();
                boolean a2 = aeVar.m506a(this, view);
                Object obj3 = (!a2 || e) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        b.mo36a(this, view, motionEvent3);
                        break;
                    case 1:
                        b.mo37b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private static int m396b(int i) {
        return i == 0 ? 8388659 : i;
    }

    private es m397b(es esVar) {
        if (esVar.mo419e()) {
            return esVar;
        }
        es a;
        int childCount = getChildCount();
        int i = 0;
        es esVar2 = esVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (bv.m2043t(childAt)) {
                ab b = ((ae) childAt.getLayoutParams()).m508b();
                if (b != null) {
                    a = b.m225a(this, childAt, esVar2);
                    if (a.mo419e()) {
                        break;
                    }
                    i++;
                    esVar2 = a;
                }
            }
            a = esVar2;
            i++;
            esVar2 = a;
        }
        a = esVar2;
        return a;
    }

    private void m398b(View view, int i, int i2) {
        ae aeVar = (ae) view.getLayoutParams();
        int a = C0230q.m2509a(m399c(aeVar.f311c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int a2 = m387a(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case 1:
                a2 += measuredWidth / 2;
                break;
            case 5:
                a2 += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                a = 0 + (measuredHeight / 2);
                break;
            case 80:
                a = 0 + measuredHeight;
                break;
        }
        a2 = Math.max(getPaddingLeft() + aeVar.leftMargin, Math.min(a2, ((width - getPaddingRight()) - measuredWidth) - aeVar.rightMargin));
        int max = Math.max(getPaddingTop() + aeVar.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - aeVar.bottomMargin));
        view.layout(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private static int m399c(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void m400c(View view, int i) {
        ae aeVar = (ae) view.getLayoutParams();
        Rect rect = this.f246j;
        rect.set(getPaddingLeft() + aeVar.leftMargin, getPaddingTop() + aeVar.topMargin, (getWidth() - getPaddingRight()) - aeVar.rightMargin, (getHeight() - getPaddingBottom()) - aeVar.bottomMargin);
        if (!(this.f258v == null || !bv.m2043t(this) || bv.m2043t(view))) {
            rect.left += this.f258v.mo414a();
            rect.top += this.f258v.mo416b();
            rect.right -= this.f258v.mo417c();
            rect.bottom -= this.f258v.mo418d();
        }
        Rect rect2 = this.f247k;
        C0230q.m2510a(m396b(aeVar.f311c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int m401d(int i) {
        return i == 0 ? 17 : i;
    }

    private void m402e() {
        int i = 0;
        if (this.f253q != null) {
            ab b = ((ae) this.f253q.getLayoutParams()).m508b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.mo37b(this, this.f253q, obtain);
                obtain.recycle();
            }
            this.f253q = null;
        }
        int childCount = getChildCount();
        while (i < childCount) {
            ((ae) getChildAt(i).getLayoutParams()).m514f();
            i++;
        }
    }

    private void m403f() {
        this.f243g.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            m405a(childAt).m509b(this, childAt);
            this.f243g.add(childAt);
        }
        m394a(this.f243g, this.f242d);
    }

    public ae m404a(AttributeSet attributeSet) {
        return new ae(getContext(), attributeSet);
    }

    ae m405a(View view) {
        ae aeVar = (ae) view.getLayoutParams();
        if (!aeVar.f310b) {
            ac acVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                acVar = (ac) cls.getAnnotation(ac.class);
                if (acVar != null) {
                    break;
                }
            }
            ac acVar2 = acVar;
            if (acVar2 != null) {
                try {
                    aeVar.m504a((ab) acVar2.m499a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + acVar2.m499a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            aeVar.f310b = true;
        }
        return aeVar;
    }

    protected ae m406a(LayoutParams layoutParams) {
        return layoutParams instanceof ae ? new ae((ae) layoutParams) : layoutParams instanceof MarginLayoutParams ? new ae((MarginLayoutParams) layoutParams) : new ae(layoutParams);
    }

    void m407a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m425e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f257u) {
            return;
        }
        if (z) {
            m416b();
        } else {
            m420c();
        }
    }

    public void m408a(View view, int i) {
        ae aeVar = (ae) view.getLayoutParams();
        if (aeVar.m512d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (aeVar.f315g != null) {
            m392a(view, aeVar.f315g, i);
        } else if (aeVar.f313e >= 0) {
            m398b(view, aeVar.f313e, i);
        } else {
            m400c(view, i);
        }
    }

    public void m409a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void m410a(View view, int i, Rect rect, Rect rect2) {
        ae aeVar = (ae) view.getLayoutParams();
        int a = C0230q.m2509a(m401d(aeVar.f311c), i);
        int a2 = C0230q.m2509a(m396b(aeVar.f312d), i);
        int i2 = a & 7;
        int i3 = a & 112;
        a = a2 & 7;
        int i4 = a2 & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (a) {
            case 1:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case 5:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i4) {
            case 16:
                a = rect.top + (rect.height() / 2);
                break;
            case 80:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i2) {
            case 1:
                a2 -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                a2 -= measuredWidth;
                break;
        }
        switch (i3) {
            case 16:
                a -= measuredHeight / 2;
                break;
            case 80:
                break;
            default:
                a -= measuredHeight;
                break;
        }
        i2 = getWidth();
        i3 = getHeight();
        a2 = Math.max(getPaddingLeft() + aeVar.leftMargin, Math.min(a2, ((i2 - getPaddingRight()) - measuredWidth) - aeVar.rightMargin));
        int max = Math.max(getPaddingTop() + aeVar.topMargin, Math.min(a, ((i3 - getPaddingBottom()) - measuredHeight) - aeVar.bottomMargin));
        rect2.set(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    void m411a(View view, Rect rect) {
        ct.m756b(this, view, rect);
    }

    void m412a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            m411a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    void m413a(boolean z) {
        int h = bv.m2031h(this);
        int size = this.f243g.size();
        for (int i = 0; i < size; i++) {
            int i2;
            View view = (View) this.f243g.get(i);
            ae aeVar = (ae) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                if (aeVar.f316h == ((View) this.f243g.get(i2))) {
                    m418b(view, h);
                }
            }
            Rect rect = this.f246j;
            Rect rect2 = this.f247k;
            m422c(view, rect);
            m412a(view, true, rect2);
            if (!rect.equals(rect2)) {
                m419b(view, rect2);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.f243g.get(i2);
                    ae aeVar2 = (ae) view2.getLayoutParams();
                    ab b = aeVar2.m508b();
                    if (b != null && b.mo58b(this, view2, view)) {
                        if (z || !aeVar2.m517i()) {
                            boolean c = b.mo59c(this, view2, view);
                            if (z) {
                                aeVar2.m510b(c);
                            }
                        } else {
                            aeVar2.m518j();
                        }
                    }
                }
            }
        }
    }

    public boolean m414a(View view, int i, int i2) {
        Rect rect = this.f246j;
        m411a(view, rect);
        return rect.contains(i, i2);
    }

    public boolean m415a(View view, View view2) {
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rect = this.f246j;
        m412a(view, view.getParent() != this, rect);
        Rect rect2 = this.f247k;
        m412a(view2, view2.getParent() != this, rect2);
        return rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
    }

    void m416b() {
        if (this.f251o) {
            if (this.f256t == null) {
                this.f256t = new af(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f256t);
        }
        this.f257u = true;
    }

    void m417b(View view) {
        int size = this.f243g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f243g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    ae aeVar = (ae) view2.getLayoutParams();
                    ab b = aeVar.m508b();
                    if (b != null && aeVar.m507a(this, view2, view)) {
                        b.m243d(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    void m418b(View view, int i) {
        ae aeVar = (ae) view.getLayoutParams();
        if (aeVar.f315g != null) {
            Rect rect = this.f246j;
            Rect rect2 = this.f247k;
            Rect rect3 = this.f248l;
            m411a(aeVar.f315g, rect);
            m412a(view, false, rect2);
            m410a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if (i2 != 0 || i3 != 0) {
                ab b = aeVar.m508b();
                if (b != null) {
                    b.mo59c(this, view, aeVar.f315g);
                }
            }
        }
    }

    void m419b(View view, Rect rect) {
        ((ae) view.getLayoutParams()).m503a(rect);
    }

    void m420c() {
        if (this.f251o && this.f256t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f256t);
        }
        this.f257u = false;
    }

    public void m421c(View view) {
        int size = this.f243g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f243g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    ae aeVar = (ae) view2.getLayoutParams();
                    ab b = aeVar.m508b();
                    if (b != null && aeVar.m507a(this, view2, view)) {
                        b.mo59c(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    void m422c(View view, Rect rect) {
        rect.set(((ae) view.getLayoutParams()).m511c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof ae) && super.checkLayoutParams(layoutParams);
    }

    protected ae m423d() {
        return new ae(-2, -2);
    }

    public List m424d(View view) {
        ae aeVar = (ae) view.getLayoutParams();
        List list = this.f245i;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && aeVar.m507a(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        ae aeVar = (ae) view.getLayoutParams();
        if (aeVar.f309a != null && aeVar.f309a.m242d(this, view) > 0.0f) {
            if (this.f250n == null) {
                this.f250n = new Paint();
            }
            this.f250n.setColor(aeVar.f309a.m240c(this, view));
            canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f250n);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f260x;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    boolean m425e(View view) {
        ae aeVar = (ae) view.getLayoutParams();
        if (aeVar.f315g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && aeVar.m507a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m423d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m404a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m406a(layoutParams);
    }

    public int getNestedScrollAxes() {
        return this.f262z.m1981a();
    }

    public Drawable getStatusBarBackground() {
        return this.f260x;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m402e();
        if (this.f257u) {
            if (this.f256t == null) {
                this.f256t = new af(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f256t);
        }
        if (this.f258v == null && bv.m2043t(this)) {
            bv.m2042s(this);
        }
        this.f251o = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m402e();
        if (this.f257u && this.f256t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f256t);
        }
        if (this.f255s != null) {
            onStopNestedScroll(this.f255s);
        }
        this.f251o = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f259w && this.f260x != null) {
            int b = this.f258v != null ? this.f258v.mo416b() : 0;
            if (b > 0) {
                this.f260x.setBounds(0, 0, getWidth(), b);
                this.f260x.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int a = az.m1904a(motionEvent);
        if (a == 0) {
            m402e();
        }
        boolean a2 = m395a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (a == 1 || a == 3) {
            m402e();
        }
        return a2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int h = bv.m2031h(this);
        int size = this.f243g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f243g.get(i5);
            ab b = ((ae) view.getLayoutParams()).m508b();
            if (b == null || !b.mo35a(this, view, h)) {
                m408a(view, h);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m403f();
        m407a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int h = bv.m2031h(this);
        Object obj = h == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        Object obj2 = (this.f258v == null || !bv.m2043t(this)) ? null : 1;
        int size3 = this.f243g.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = paddingBottom;
        int i8 = suggestedMinimumWidth;
        while (i5 < size3) {
            int i9;
            View view = (View) this.f243g.get(i5);
            ae aeVar = (ae) view.getLayoutParams();
            int i10 = 0;
            if (aeVar.f313e >= 0 && mode != 0) {
                int a = m387a(aeVar.f313e);
                paddingTop = C0230q.m2509a(m399c(aeVar.f311c), h) & 7;
                if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                    i10 = Math.max(0, (size - paddingRight) - a);
                } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                    i10 = Math.max(0, a - paddingLeft);
                }
            }
            if (obj2 == null || bv.m2043t(view)) {
                i9 = i2;
                suggestedMinimumWidth = i;
            } else {
                paddingTop = this.f258v.mo416b() + this.f258v.mo418d();
                suggestedMinimumWidth = MeasureSpec.makeMeasureSpec(size - (this.f258v.mo414a() + this.f258v.mo417c()), mode);
                i9 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            ab b = aeVar.m508b();
            if (b == null || !b.mo53a(this, view, suggestedMinimumWidth, i10, i9, 0)) {
                m409a(view, suggestedMinimumWidth, i10, i9, 0);
            }
            i10 = Math.max(i8, ((view.getMeasuredWidth() + i3) + aeVar.leftMargin) + aeVar.rightMargin);
            suggestedMinimumWidth = Math.max(i7, ((view.getMeasuredHeight() + i4) + aeVar.topMargin) + aeVar.bottomMargin);
            i5++;
            i6 = bv.m1998a(i6, bv.m2033j(view));
            i7 = suggestedMinimumWidth;
            i8 = i10;
        }
        setMeasuredDimension(bv.m1999a(i8, i, -16777216 & i6), bv.m1999a(i7, i2, i6 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            ae aeVar = (ae) childAt.getLayoutParams();
            if (aeVar.m516h()) {
                ab b = aeVar.m508b();
                a = b != null ? b.mo47a(this, childAt, view, f, f2, z) | z2 : z2;
            } else {
                a = z2;
            }
            i++;
            z2 = a;
        }
        if (z2) {
            m413a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            ae aeVar = (ae) childAt.getLayoutParams();
            if (aeVar.m516h()) {
                ab b = aeVar.m508b();
                a = b != null ? b.mo60a(this, childAt, view, f, f2) | z : z;
            } else {
                a = z;
            }
            i++;
            z = a;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            ae aeVar = (ae) childAt.getLayoutParams();
            if (aeVar.m516h()) {
                ab b = aeVar.m508b();
                if (b != null) {
                    int[] iArr2 = this.f249m;
                    this.f249m[1] = 0;
                    iArr2[0] = 0;
                    b.mo45a(this, childAt, view, i, i2, this.f249m);
                    max = i > 0 ? Math.max(i3, this.f249m[0]) : Math.min(i3, this.f249m[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.f249m[1]) : Math.min(i4, this.f249m[1]);
                    int i6 = 1;
                } else {
                    obj2 = obj;
                    max = i3;
                    max2 = i4;
                }
            } else {
                obj2 = obj;
                max = i3;
                max2 = i4;
            }
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m413a(true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            ae aeVar = (ae) childAt.getLayoutParams();
            if (aeVar.m516h()) {
                ab b = aeVar.m508b();
                if (b != null) {
                    b.mo44a(this, childAt, view, i, i2, i3, i4);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
            } else {
                obj2 = obj;
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m413a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f262z.m1983a(view, view2, i);
        this.f254r = view;
        this.f255s = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            ae aeVar = (ae) childAt.getLayoutParams();
            if (aeVar.m516h()) {
                ab b = aeVar.m508b();
                if (b != null) {
                    b.m237b(this, childAt, view, view2, i);
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof ag) {
            ag agVar = (ag) parcelable;
            super.onRestoreInstanceState(agVar.getSuperState());
            SparseArray sparseArray = agVar.f323a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                ab b = m405a(childAt).m508b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.mo42a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable agVar = new ag(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            ab b = ((ae) childAt.getLayoutParams()).m508b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.mo51b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        agVar.f323a = sparseArray;
        return agVar;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            ae aeVar = (ae) childAt.getLayoutParams();
            ab b = aeVar.m508b();
            if (b != null) {
                boolean a = b.mo48a(this, childAt, view, view2, i);
                z2 = z | a;
                aeVar.m505a(a);
            } else {
                aeVar.m505a(false);
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.f262z.m1982a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ae aeVar = (ae) childAt.getLayoutParams();
            if (aeVar.m516h()) {
                ab b = aeVar.m508b();
                if (b != null) {
                    b.mo43a(this, childAt, view);
                }
                aeVar.m515g();
                aeVar.m518j();
            }
        }
        this.f254r = null;
        this.f255s = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2 = null;
        int a = az.m1904a(motionEvent);
        boolean z2;
        MotionEvent obtain;
        if (this.f253q == null) {
            boolean a2 = m395a(motionEvent, 1);
            if (a2) {
                z2 = a2;
            } else {
                z2 = a2;
                z = false;
                if (this.f253q == null) {
                    z |= super.onTouchEvent(motionEvent);
                } else if (z2) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z || a == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (a == 1 || a == 3) {
                        m402e();
                    }
                    return z;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                m402e();
                return z;
            }
        }
        z2 = false;
        ab b = ((ae) this.f253q.getLayoutParams()).m508b();
        z = b != null ? b.mo37b(this, this.f253q, motionEvent) : false;
        if (this.f253q == null) {
            z |= super.onTouchEvent(motionEvent);
        } else if (z2) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m402e();
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m402e();
        }
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f261y = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f260x != drawable) {
            if (this.f260x != null) {
                this.f260x.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f260x = drawable2;
            if (this.f260x != null) {
                if (this.f260x.isStateful()) {
                    this.f260x.setState(getDrawableState());
                }
                C0106a.m1341b(this.f260x, bv.m2031h(this));
                this.f260x.setVisible(getVisibility() == 0, false);
                this.f260x.setCallback(this);
            }
            bv.m2023d(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0066a.m958a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f260x != null && this.f260x.isVisible() != z) {
            this.f260x.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f260x;
    }
}
