package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002f.C0138c;
import android.util.SparseArray;
import android.view.View.BaseSavedState;

public class ag extends BaseSavedState {
    public static final Creator CREATOR = C0138c.m1459a(new ah());
    SparseArray f323a;

    public ag(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        this.f323a = new SparseArray(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f323a.append(iArr[i], readParcelableArray[i]);
        }
    }

    public ag(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        super.writeToParcel(parcel, i);
        int size = this.f323a != null ? this.f323a.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        while (i2 < size) {
            iArr[i2] = this.f323a.keyAt(i2);
            parcelableArr[i2] = (Parcelable) this.f323a.valueAt(i2);
            i2++;
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
