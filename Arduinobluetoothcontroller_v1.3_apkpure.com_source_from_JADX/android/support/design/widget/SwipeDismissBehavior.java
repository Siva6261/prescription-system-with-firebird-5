package android.support.design.widget;

import android.support.v4.view.az;
import android.support.v4.widget.bk;
import android.support.v4.widget.bn;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SwipeDismissBehavior extends ab {
    private bk f292a;
    private cf f293b;
    private boolean f294c;
    private float f295d = 0.0f;
    private boolean f296e;
    private int f297f = 2;
    private float f298g = 0.5f;
    private float f299h = 0.0f;
    private float f300i = 0.5f;
    private final bn f301j = new ce(this);

    static float m476a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void m479a(ViewGroup viewGroup) {
        if (this.f292a == null) {
            this.f292a = this.f296e ? bk.m2721a(viewGroup, this.f295d, this.f301j) : bk.m2722a(viewGroup, this.f301j);
        }
    }

    private static int m481b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private static float m483c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public void m488a(float f) {
        this.f299h = m483c(0.0f, f, 1.0f);
    }

    public void m489a(int i) {
        this.f297f = i;
    }

    public void m490a(cf cfVar) {
        this.f293b = cfVar;
    }

    public boolean mo36a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        switch (az.m1904a(motionEvent)) {
            case 1:
            case 3:
                if (this.f294c) {
                    this.f294c = false;
                    return false;
                }
                break;
            default:
                this.f294c = !coordinatorLayout.m414a(view, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f294c) {
            return false;
        }
        m479a((ViewGroup) coordinatorLayout);
        return this.f292a.m2742a(motionEvent);
    }

    public boolean mo115a(View view) {
        return true;
    }

    public void m493b(float f) {
        this.f300i = m483c(0.0f, f, 1.0f);
    }

    public boolean mo37b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f292a == null) {
            return false;
        }
        this.f292a.m2747b(motionEvent);
        return true;
    }
}
