package android.support.v4.p002f;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class C0139d implements Creator {
    final C0032e f824a;

    public C0139d(C0032e c0032e) {
        this.f824a = c0032e;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f824a.mo70b(parcel, null);
    }

    public Object[] newArray(int i) {
        return this.f824a.mo71b(i);
    }
}
