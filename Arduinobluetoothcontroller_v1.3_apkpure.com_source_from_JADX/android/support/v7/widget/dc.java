package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.view.az;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public abstract class dc implements OnTouchListener {
    private final float f1574a;
    private final int f1575b;
    private final int f1576c;
    private final View f1577d;
    private Runnable f1578e;
    private Runnable f1579f;
    private boolean f1580g;
    private boolean f1581h;
    private int f1582i;
    private final int[] f1583j = new int[2];

    public dc(View view) {
        this.f1577d = view;
        this.f1574a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1575b = ViewConfiguration.getTapTimeout();
        this.f1576c = (this.f1575b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean m3396a(MotionEvent motionEvent) {
        View view = this.f1577d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (az.m1904a(motionEvent)) {
            case 0:
                this.f1582i = motionEvent.getPointerId(0);
                this.f1581h = false;
                if (this.f1578e == null) {
                    this.f1578e = new dd();
                }
                view.postDelayed(this.f1578e, (long) this.f1575b);
                if (this.f1579f == null) {
                    this.f1579f = new de();
                }
                view.postDelayed(this.f1579f, (long) this.f1576c);
                return false;
            case 1:
            case 3:
                m3402d();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1582i);
                if (findPointerIndex < 0 || m3397a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1574a)) {
                    return false;
                }
                m3402d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private static boolean m3397a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean m3398a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1583j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean m3400b(MotionEvent motionEvent) {
        boolean z = true;
        View view = this.f1577d;
        cx a = mo606a();
        if (a == null || !a.m4162k()) {
            return false;
        }
        View a2 = a.f2021g;
        if (a2 == null || !a2.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m3401b(view, obtainNoHistory);
        m3398a(a2, obtainNoHistory);
        boolean a3 = a2.m4400a(obtainNoHistory, this.f1582i);
        obtainNoHistory.recycle();
        int a4 = az.m1904a(motionEvent);
        boolean z2 = (a4 == 1 || a4 == 3) ? false : true;
        if (!(a3 && z2)) {
            z = false;
        }
        return z;
    }

    private boolean m3401b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1583j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private void m3402d() {
        if (this.f1579f != null) {
            this.f1577d.removeCallbacks(this.f1579f);
        }
        if (this.f1578e != null) {
            this.f1577d.removeCallbacks(this.f1578e);
        }
    }

    private void m3403e() {
        m3402d();
        View view = this.f1577d;
        if (view.isEnabled() && !view.isLongClickable() && mo607b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1580g = true;
            this.f1581h = true;
        }
    }

    public abstract cx mo606a();

    protected boolean mo607b() {
        cx a = mo606a();
        if (!(a == null || a.m4162k())) {
            a.mo707c();
        }
        return true;
    }

    protected boolean mo815c() {
        cx a = mo606a();
        if (a != null && a.m4162k()) {
            a.m4160i();
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean b;
        boolean z = this.f1580g;
        if (z) {
            b = this.f1581h ? m3400b(motionEvent) : m3400b(motionEvent) || !mo815c();
        } else {
            boolean z2 = m3396a(motionEvent) && mo607b();
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1577d.onTouchEvent(obtain);
                obtain.recycle();
            }
            b = z2;
        }
        this.f1580g = b;
        return b || z;
    }
}
