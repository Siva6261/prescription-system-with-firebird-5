package android.support.v4.view;

import android.view.MotionEvent;

class bf {
    public static int m1965a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int m1966a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m1967b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m1968c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m1969d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
