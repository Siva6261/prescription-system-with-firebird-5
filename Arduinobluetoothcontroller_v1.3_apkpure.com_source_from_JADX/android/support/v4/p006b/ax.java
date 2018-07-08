package android.support.v4.p006b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ax implements Creator {
    ax() {
    }

    public aw m1134a(Parcel parcel) {
        return new aw(parcel);
    }

    public aw[] m1135a(int i) {
        return new aw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1134a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1135a(i);
    }
}
