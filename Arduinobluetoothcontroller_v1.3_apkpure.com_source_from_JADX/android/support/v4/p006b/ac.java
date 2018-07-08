package android.support.v4.p006b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ac implements Creator {
    ac() {
    }

    public ab m964a(Parcel parcel) {
        return new ab(parcel, null);
    }

    public ab[] m965a(int i) {
        return new ab[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m964a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m965a(i);
    }
}
