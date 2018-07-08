package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class fn implements Creator {
    fn() {
    }

    public fm m4704a(Parcel parcel) {
        return new fm(parcel);
    }

    public fm[] m4705a(int i) {
        return new fm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4704a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4705a(i);
    }
}
