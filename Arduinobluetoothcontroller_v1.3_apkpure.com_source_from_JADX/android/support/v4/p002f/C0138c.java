package android.support.v4.p002f;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public final class C0138c {
    public static Creator m1459a(C0032e c0032e) {
        return VERSION.SDK_INT >= 13 ? C0141g.m1460a(c0032e) : new C0139d(c0032e);
    }
}
