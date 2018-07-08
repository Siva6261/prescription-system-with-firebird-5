package android.support.v4.view;

import android.view.MotionEvent;

class ba implements be {
    ba() {
    }

    public int mo316a(MotionEvent motionEvent) {
        return 1;
    }

    public int mo317a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    public int mo318b(MotionEvent motionEvent) {
        return 0;
    }

    public int mo319b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo320c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo321d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo322e(MotionEvent motionEvent, int i) {
        return 0.0f;
    }
}
