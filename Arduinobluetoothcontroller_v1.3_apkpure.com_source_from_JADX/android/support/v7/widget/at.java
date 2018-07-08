package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.p015h.C0173g;

class at extends C0173g {
    public at(int i) {
        super(i);
    }

    private static int m4106b(int i, Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }

    PorterDuffColorFilter m4107a(int i, Mode mode) {
        return (PorterDuffColorFilter) m1554a((Object) Integer.valueOf(m4106b(i, mode)));
    }

    PorterDuffColorFilter m4108a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter) m1555a(Integer.valueOf(m4106b(i, mode)), porterDuffColorFilter);
    }
}
