package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ag implements Creator {
    ag() {
    }

    public af m2601a(Parcel parcel) {
        return new af(parcel);
    }

    public af[] m2602a(int i) {
        return new af[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2601a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2602a(i);
    }
}
