package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class cv implements Parcelable {
    public static final Creator CREATOR = new cw();
    int f2160a;
    int f2161b;
    boolean f2162c;

    cv(Parcel parcel) {
        boolean z = true;
        this.f2160a = parcel.readInt();
        this.f2161b = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f2162c = z;
    }

    public cv(cv cvVar) {
        this.f2160a = cvVar.f2160a;
        this.f2161b = cvVar.f2161b;
        this.f2162c = cvVar.f2162c;
    }

    boolean m4382a() {
        return this.f2160a >= 0;
    }

    void m4383b() {
        this.f2160a = -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2160a);
        parcel.writeInt(this.f2161b);
        parcel.writeInt(this.f2162c ? 1 : 0);
    }
}
