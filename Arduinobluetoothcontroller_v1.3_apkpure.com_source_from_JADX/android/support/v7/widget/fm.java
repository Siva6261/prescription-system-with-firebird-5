package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class fm extends BaseSavedState {
    public static final Creator CREATOR = new fn();
    boolean f2308a;

    public fm(Parcel parcel) {
        super(parcel);
        this.f2308a = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    fm(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2308a + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(Boolean.valueOf(this.f2308a));
    }
}
