package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class av implements au {
    av() {
    }

    public Object mo444a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public void mo445a(Object obj, int i, int i2, int i3, int i4) {
        ((Scroller) obj).startScroll(i, i2, i3, i4);
    }

    public void mo446a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public void mo447a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void mo448a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean mo449a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public boolean mo450a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    public int mo451b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public int mo452c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public float mo453d(Object obj) {
        return 0.0f;
    }

    public boolean mo454e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void mo455f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int mo456g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int mo457h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
