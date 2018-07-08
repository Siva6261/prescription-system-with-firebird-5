package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class az {
    static final be f969a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f969a = new bd();
        } else if (VERSION.SDK_INT >= 9) {
            f969a = new bc();
        } else if (VERSION.SDK_INT >= 5) {
            f969a = new bb();
        } else {
            f969a = new ba();
        }
    }

    public static int m1904a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m1905a(MotionEvent motionEvent, int i) {
        return f969a.mo317a(motionEvent, i);
    }

    public static int m1906b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m1907b(MotionEvent motionEvent, int i) {
        return f969a.mo319b(motionEvent, i);
    }

    public static float m1908c(MotionEvent motionEvent, int i) {
        return f969a.mo320c(motionEvent, i);
    }

    public static int m1909c(MotionEvent motionEvent) {
        return f969a.mo316a(motionEvent);
    }

    public static float m1910d(MotionEvent motionEvent, int i) {
        return f969a.mo321d(motionEvent, i);
    }

    public static int m1911d(MotionEvent motionEvent) {
        return f969a.mo318b(motionEvent);
    }

    public static float m1912e(MotionEvent motionEvent, int i) {
        return f969a.mo322e(motionEvent, i);
    }
}
