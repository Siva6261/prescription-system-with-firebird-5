package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.az;
import android.support.v4.view.dy;
import android.support.v4.widget.C0265z;
import android.support.v7.p018b.C0298b;
import android.view.MotionEvent;
import android.view.View;

class db extends dk {
    private boolean f2175g;
    private boolean f2176h;
    private boolean f2177i;
    private dy f2178j;
    private C0265z f2179k;

    public db(Context context, boolean z) {
        super(context, null, C0298b.dropDownListViewStyle);
        this.f2176h = z;
        setCacheColorHint(0);
    }

    private void m4395a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void m4396a(View view, int i, float f, float f2) {
        this.f2177i = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f != -1) {
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m4389a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void m4398d() {
        this.f2177i = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f2178j != null) {
            this.f2178j.m2391b();
            this.f2178j = null;
        }
    }

    protected boolean mo726a() {
        return this.f2177i || super.mo726a();
    }

    public boolean m4400a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = az.m1904a(motionEvent);
        switch (a) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m4396a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    m4395a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            m4398d();
        }
        if (z2) {
            if (this.f2179k == null) {
                this.f2179k = new C0265z(this);
            }
            this.f2179k.m2583a(true);
            this.f2179k.onTouch(this, motionEvent);
        } else if (this.f2179k != null) {
            this.f2179k.m2583a(false);
        }
        return z2;
    }

    public boolean hasFocus() {
        return this.f2176h || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f2176h || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f2176h || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f2176h && this.f2175g) || super.isInTouchMode();
    }
}
