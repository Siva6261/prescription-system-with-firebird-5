package android.support.v4.p006b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class av implements Creator {
    av() {
    }

    public au m1131a(Parcel parcel) {
        return new au(parcel);
    }

    public au[] m1132a(int i) {
        return new au[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1131a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1132a(i);
    }
}
