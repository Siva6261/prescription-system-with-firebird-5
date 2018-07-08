package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.design.C0028i;
import android.support.v4.view.az;
import android.support.v4.view.bi;
import android.support.v4.view.bq;
import android.support.v4.view.bv;
import android.support.v4.widget.bk;
import android.support.v4.widget.bn;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior extends ab {
    private float f197a;
    private int f198b;
    private int f199c;
    private int f200d;
    private boolean f201e;
    private int f202f = 4;
    private bk f203g;
    private boolean f204h;
    private int f205i;
    private boolean f206j;
    private int f207k;
    private WeakReference f208l;
    private WeakReference f209m;
    private C0043k f210n;
    private VelocityTracker f211o;
    private int f212p;
    private int f213q;
    private boolean f214r;
    private final bn f215s = new C0042j(this);

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.BottomSheetBehavior_Params);
        m357a(obtainStyledAttributes.getDimensionPixelSize(C0028i.BottomSheetBehavior_Params_behavior_peekHeight, 0));
        m362a(obtainStyledAttributes.getBoolean(C0028i.BottomSheetBehavior_Params_behavior_hideable, false));
        obtainStyledAttributes.recycle();
        this.f197a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static BottomSheetBehavior m338a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ae) {
            ab b = ((ae) layoutParams).m508b();
            if (b instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) b;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void m339a() {
        this.f212p = -1;
        if (this.f211o != null) {
            this.f211o.recycle();
            this.f211o = null;
        }
    }

    private boolean m342a(View view, float f) {
        return view.getTop() >= this.f200d && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f200d)) / ((float) this.f198b) > 0.5f;
    }

    private float m343b() {
        this.f211o.computeCurrentVelocity(1000, this.f197a);
        return bq.m1985b(this.f211o, this.f212p);
    }

    private View m344b(View view) {
        if (view instanceof bi) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View b = m344b(viewGroup.getChildAt(i));
                if (b != null) {
                    return b;
                }
            }
        }
        return null;
    }

    private void m345b(int i) {
        if (this.f202f != i) {
            this.f202f = i;
            View view = (View) this.f208l.get();
            if (view != null && this.f210n != null) {
                this.f210n.mo147a(view, i);
            }
        }
    }

    private void m349c(int i) {
        View view = (View) this.f208l.get();
        if (view != null && this.f210n != null) {
            if (i > this.f200d) {
                this.f210n.mo146a(view, ((float) (this.f200d - i)) / ((float) this.f198b));
            } else {
                this.f210n.mo146a(view, ((float) (this.f200d - i)) / ((float) (this.f200d - this.f199c)));
            }
        }
    }

    public final void m357a(int i) {
        this.f198b = Math.max(0, i);
        this.f200d = this.f207k - i;
    }

    public void mo42a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        C0044l c0044l = (C0044l) parcelable;
        super.mo42a(coordinatorLayout, view, c0044l.getSuperState());
        if (c0044l.f464a == 1 || c0044l.f464a == 2) {
            this.f202f = 4;
        } else {
            this.f202f = c0044l.f464a;
        }
    }

    public void mo43a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i = 3;
        if (view.getTop() == this.f199c) {
            m345b(3);
        } else if (view2 == this.f209m.get() && this.f206j) {
            int i2;
            if (this.f205i > 0) {
                i2 = this.f199c;
            } else if (this.f201e && m342a(view, m343b())) {
                i2 = this.f207k;
                i = 5;
            } else if (this.f205i == 0) {
                int top = view.getTop();
                if (Math.abs(top - this.f199c) < Math.abs(top - this.f200d)) {
                    i2 = this.f199c;
                } else {
                    i2 = this.f200d;
                    i = 4;
                }
            } else {
                i2 = this.f200d;
                i = 4;
            }
            if (this.f203g.m2743a(view, view.getLeft(), i2)) {
                m345b(2);
                bv.m2010a(view, new C0046n(this, view, i));
            } else {
                m345b(i);
            }
            this.f206j = false;
        }
    }

    public void mo45a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr) {
        if (view2 == ((View) this.f209m.get())) {
            int top = view.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.f199c) {
                    iArr[1] = top - this.f199c;
                    bv.m2027e(view, -iArr[1]);
                    m345b(3);
                } else {
                    iArr[1] = i2;
                    bv.m2027e(view, -i2);
                    m345b(1);
                }
            } else if (i2 < 0 && !bv.m2018b(view2, -1)) {
                if (i3 <= this.f200d || this.f201e) {
                    iArr[1] = i2;
                    bv.m2027e(view, -i2);
                    m345b(1);
                } else {
                    iArr[1] = top - this.f200d;
                    bv.m2027e(view, -iArr[1]);
                    m345b(4);
                }
            }
            m349c(view.getTop());
            this.f205i = i2;
            this.f206j = true;
        }
    }

    public void m361a(C0043k c0043k) {
        this.f210n = c0043k;
    }

    public void m362a(boolean z) {
        this.f201e = z;
    }

    public boolean mo35a(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (!(this.f202f == 1 || this.f202f == 2)) {
            coordinatorLayout.m408a(view, i);
        }
        this.f207k = coordinatorLayout.getHeight();
        this.f199c = Math.max(0, this.f207k - view.getHeight());
        this.f200d = Math.max(this.f207k - this.f198b, this.f199c);
        if (this.f202f == 3) {
            bv.m2027e(view, this.f199c);
        } else if (this.f201e && this.f202f == 5) {
            bv.m2027e(view, this.f207k);
        } else if (this.f202f == 4) {
            bv.m2027e(view, this.f200d);
        }
        if (this.f203g == null) {
            this.f203g = bk.m2722a((ViewGroup) coordinatorLayout, this.f215s);
        }
        this.f208l = new WeakReference(view);
        this.f209m = new WeakReference(m344b(view));
        return true;
    }

    public boolean mo36a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!view.isShown()) {
            return false;
        }
        int a = az.m1904a(motionEvent);
        if (a == 0) {
            m339a();
        }
        if (this.f211o == null) {
            this.f211o = VelocityTracker.obtain();
        }
        this.f211o.addMovement(motionEvent);
        switch (a) {
            case 0:
                int x = (int) motionEvent.getX();
                this.f213q = (int) motionEvent.getY();
                View view2 = (View) this.f209m.get();
                if (view2 != null && coordinatorLayout.m414a(view2, x, this.f213q)) {
                    this.f212p = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f214r = true;
                }
                boolean z2 = this.f212p == -1 && !coordinatorLayout.m414a(view, x, this.f213q);
                this.f204h = z2;
                break;
            case 1:
            case 3:
                this.f214r = false;
                this.f212p = -1;
                if (this.f204h) {
                    this.f204h = false;
                    return false;
                }
                break;
        }
        if (!this.f204h && this.f203g.m2742a(motionEvent)) {
            return true;
        }
        view2 = (View) this.f209m.get();
        if (a != 2 || view2 == null || this.f204h || this.f202f == 1 || coordinatorLayout.m414a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f213q) - motionEvent.getY()) <= ((float) this.f203g.m2738a())) {
            z = false;
        }
        return z;
    }

    public boolean mo60a(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2) {
        return view2 == this.f209m.get() && (this.f202f != 3 || super.mo60a(coordinatorLayout, view, view2, f, f2));
    }

    public boolean mo48a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
        this.f205i = 0;
        this.f206j = false;
        return (i & 2) != 0;
    }

    public Parcelable mo51b(CoordinatorLayout coordinatorLayout, View view) {
        return new C0044l(super.mo51b(coordinatorLayout, view), this.f202f);
    }

    public boolean mo37b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int a = az.m1904a(motionEvent);
        if (this.f202f == 1 && a == 0) {
            return true;
        }
        this.f203g.m2747b(motionEvent);
        if (a == 0) {
            m339a();
        }
        if (this.f211o == null) {
            this.f211o = VelocityTracker.obtain();
        }
        this.f211o.addMovement(motionEvent);
        if (a != 2 || Math.abs(((float) this.f213q) - motionEvent.getY()) <= ((float) this.f203g.m2738a())) {
            return true;
        }
        this.f203g.m2739a(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return true;
    }
}
