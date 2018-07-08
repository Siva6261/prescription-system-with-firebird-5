package android.support.v4.p006b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class au implements Parcelable {
    public static final Creator CREATOR = new av();
    aw[] f661a;
    int[] f662b;
    C0090t[] f663c;

    public au(Parcel parcel) {
        this.f661a = (aw[]) parcel.createTypedArray(aw.CREATOR);
        this.f662b = parcel.createIntArray();
        this.f663c = (C0090t[]) parcel.createTypedArray(C0090t.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f661a, i);
        parcel.writeIntArray(this.f662b);
        parcel.writeTypedArray(this.f663c, i);
    }
}
