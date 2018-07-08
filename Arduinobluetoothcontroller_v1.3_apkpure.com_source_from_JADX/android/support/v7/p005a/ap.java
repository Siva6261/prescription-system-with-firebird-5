package android.support.v7.p005a;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.aq;
import android.view.KeyEvent;
import android.view.MotionEvent;

class ap extends ContentFrameLayout {
    final /* synthetic */ ae f1219a;

    public ap(ae aeVar, Context context) {
        this.f1219a = aeVar;
        super(context);
    }

    private boolean m3006a(int i, int i2) {
        return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1219a.mo491a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !m3006a((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f1219a.m2922d(0);
        return true;
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(aq.m4079a().m4100a(getContext(), i));
    }
}
