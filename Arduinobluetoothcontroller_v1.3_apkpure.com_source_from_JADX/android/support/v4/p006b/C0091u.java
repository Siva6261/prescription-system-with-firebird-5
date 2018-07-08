package android.support.v4.p006b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0091u implements Creator {
    C0091u() {
    }

    public C0090t m1304a(Parcel parcel) {
        return new C0090t(parcel);
    }

    public C0090t[] m1305a(int i) {
        return new C0090t[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1304a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1305a(i);
    }
}
