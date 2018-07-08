package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class C0044l extends BaseSavedState {
    public static final Creator CREATOR = new C0045m();
    final int f464a;

    public C0044l(Parcel parcel) {
        super(parcel);
        this.f464a = parcel.readInt();
    }

    public C0044l(Parcelable parcelable, int i) {
        super(parcelable);
        this.f464a = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f464a);
    }
}
