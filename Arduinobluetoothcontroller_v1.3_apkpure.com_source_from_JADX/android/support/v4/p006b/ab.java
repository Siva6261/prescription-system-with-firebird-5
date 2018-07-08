package android.support.v4.p006b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ab implements Parcelable {
    public static final Creator CREATOR = new ac();
    final Bundle f590a;

    ab(Bundle bundle) {
        this.f590a = bundle;
    }

    ab(Parcel parcel, ClassLoader classLoader) {
        this.f590a = parcel.readBundle();
        if (classLoader != null && this.f590a != null) {
            this.f590a.setClassLoader(classLoader);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f590a);
    }
}
