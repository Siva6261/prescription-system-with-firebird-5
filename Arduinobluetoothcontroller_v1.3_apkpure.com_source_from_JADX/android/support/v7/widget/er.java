package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class er extends BaseSavedState {
    public static final Creator CREATOR = new es();
    Parcelable f2221a;

    er(Parcel parcel) {
        super(parcel);
        this.f2221a = parcel.readParcelable(eh.class.getClassLoader());
    }

    er(Parcelable parcelable) {
        super(parcelable);
    }

    private void m4568a(er erVar) {
        this.f2221a = erVar.f2221a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f2221a, 0);
    }
}
