package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class cw implements Creator {
    cw() {
    }

    public cv m4384a(Parcel parcel) {
        return new cv(parcel);
    }

    public cv[] m4385a(int i) {
        return new cv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4384a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4385a(i);
    }
}
