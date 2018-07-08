package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class fw implements Creator {
    fw() {
    }

    public fv m4731a(Parcel parcel) {
        return new fv(parcel);
    }

    public fv[] m4732a(int i) {
        return new fv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4731a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4732a(i);
    }
}
