package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class ft implements Parcelable {
    public static final Creator CREATOR = new fu();
    int f2319a;
    int f2320b;
    int[] f2321c;
    boolean f2322d;

    public ft(Parcel parcel) {
        boolean z = true;
        this.f2319a = parcel.readInt();
        this.f2320b = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f2322d = z;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.f2321c = new int[readInt];
            parcel.readIntArray(this.f2321c);
        }
    }

    int m4726a(int i) {
        return this.f2321c == null ? 0 : this.f2321c[i];
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FullSpanItem{mPosition=" + this.f2319a + ", mGapDir=" + this.f2320b + ", mHasUnwantedGapAfter=" + this.f2322d + ", mGapPerSpan=" + Arrays.toString(this.f2321c) + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2319a);
        parcel.writeInt(this.f2320b);
        parcel.writeInt(this.f2322d ? 1 : 0);
        if (this.f2321c == null || this.f2321c.length <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.f2321c.length);
        parcel.writeIntArray(this.f2321c);
    }
}
