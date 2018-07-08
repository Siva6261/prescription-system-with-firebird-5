package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class gm extends BaseSavedState {
    public static final Creator CREATOR = new gn();
    int f2387a;
    boolean f2388b;

    public gm(Parcel parcel) {
        super(parcel);
        this.f2387a = parcel.readInt();
        this.f2388b = parcel.readInt() != 0;
    }

    public gm(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2387a);
        parcel.writeInt(this.f2388b ? 1 : 0);
    }
}
