package android.support.v4.p002f;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class C0140f implements ClassLoaderCreator {
    private final C0032e f825a;

    public C0140f(C0032e c0032e) {
        this.f825a = c0032e;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f825a.mo70b(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f825a.mo70b(parcel, classLoader);
    }

    public Object[] newArray(int i) {
        return this.f825a.mo71b(i);
    }
}
