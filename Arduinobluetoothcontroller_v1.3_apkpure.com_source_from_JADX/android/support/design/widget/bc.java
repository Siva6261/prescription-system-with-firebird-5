package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.az;
import android.support.v4.view.bq;
import android.support.v4.view.bv;
import android.support.v4.widget.at;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class bc extends cz {
    private Runnable f169a;
    private at f170b;
    private boolean f171c;
    private int f172d = -1;
    private int f173e;
    private int f174f = -1;
    private VelocityTracker f175g;

    public bc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m250c() {
        if (this.f175g == null) {
            this.f175g = VelocityTracker.obtain();
        }
    }

    int mo38a() {
        return mo49b();
    }

    int mo39a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        int b = mo49b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = bf.m609a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        mo46a(a);
        return b - a;
    }

    int mo40a(View view) {
        return view.getHeight();
    }

    void mo41a(CoordinatorLayout coordinatorLayout, View view) {
    }

    final boolean m255a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, float f) {
        if (this.f169a != null) {
            view.removeCallbacks(this.f169a);
            this.f169a = null;
        }
        if (this.f170b == null) {
            this.f170b = at.m2638a(view.getContext());
        }
        this.f170b.m2642a(0, mo49b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f170b.m2651g()) {
            this.f169a = new bd(this, coordinatorLayout, view);
            bv.m2010a(view, this.f169a);
            return true;
        }
        mo41a(coordinatorLayout, view);
        return false;
    }

    public boolean mo36a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f174f < 0) {
            this.f174f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f171c) {
            return true;
        }
        int y;
        switch (az.m1904a(motionEvent)) {
            case 0:
                this.f171c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (mo52c(view) && coordinatorLayout.m414a(view, x, y)) {
                    this.f173e = y;
                    this.f172d = az.m1907b(motionEvent, 0);
                    m250c();
                    break;
                }
            case 1:
            case 3:
                this.f171c = false;
                this.f172d = -1;
                if (this.f175g != null) {
                    this.f175g.recycle();
                    this.f175g = null;
                    break;
                }
                break;
            case 2:
                y = this.f172d;
                if (y != -1) {
                    y = az.m1905a(motionEvent, y);
                    if (y != -1) {
                        y = (int) az.m1910d(motionEvent, y);
                        if (Math.abs(y - this.f173e) > this.f174f) {
                            this.f171c = true;
                            this.f173e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f175g != null) {
            this.f175g.addMovement(motionEvent);
        }
        return this.f171c;
    }

    int a_(CoordinatorLayout coordinatorLayout, View view, int i) {
        return mo39a(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int m257b(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        return mo39a(coordinatorLayout, view, mo38a() - i, i2, i3);
    }

    int mo50b(View view) {
        return -view.getHeight();
    }

    public boolean mo37b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f174f < 0) {
            this.f174f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (az.m1904a(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m414a(view, (int) motionEvent.getX(), y) && mo52c(view)) {
                    this.f173e = y;
                    this.f172d = az.m1907b(motionEvent, 0);
                    m250c();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.f175g != null) {
                    this.f175g.addMovement(motionEvent);
                    this.f175g.computeCurrentVelocity(1000);
                    m255a(coordinatorLayout, view, -mo40a(view), 0, bq.m1985b(this.f175g, this.f172d));
                    break;
                }
                break;
            case 2:
                int a = az.m1905a(motionEvent, this.f172d);
                if (a != -1) {
                    a = (int) az.m1910d(motionEvent, a);
                    int i = this.f173e - a;
                    if (!this.f171c && Math.abs(i) > this.f174f) {
                        this.f171c = true;
                        i = i > 0 ? i - this.f174f : i + this.f174f;
                    }
                    if (this.f171c) {
                        this.f173e = a;
                        m257b(coordinatorLayout, view, i, mo50b(view), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.f171c = false;
        this.f172d = -1;
        if (this.f175g != null) {
            this.f175g.recycle();
            this.f175g = null;
        }
        if (this.f175g != null) {
            this.f175g.addMovement(motionEvent);
        }
        return true;
    }

    boolean mo52c(View view) {
        return false;
    }
}
