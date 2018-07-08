package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002f.C0138c;
import android.view.View.BaseSavedState;

public class C0219do extends BaseSavedState {
    public static final Creator CREATOR = C0138c.m1459a(new dp());
    int f1010a;
    Parcelable f1011b;
    ClassLoader f1012c;

    C0219do(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        if (classLoader == null) {
            classLoader = getClass().getClassLoader();
        }
        this.f1010a = parcel.readInt();
        this.f1011b = parcel.readParcelable(classLoader);
        this.f1012c = classLoader;
    }

    public C0219do(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1010a + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1010a);
        parcel.writeParcelable(this.f1011b, i);
    }
}
