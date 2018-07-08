package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class bq {
    static final bt f981a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f981a = new bs();
        } else {
            f981a = new br();
        }
    }

    public static float m1984a(VelocityTracker velocityTracker, int i) {
        return f981a.mo323a(velocityTracker, i);
    }

    public static float m1985b(VelocityTracker velocityTracker, int i) {
        return f981a.mo324b(velocityTracker, i);
    }
}
