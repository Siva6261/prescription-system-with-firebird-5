package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002f.C0138c;
import android.view.View.BaseSavedState;

public class C0038f extends BaseSavedState {
    public static final Creator CREATOR = C0138c.m1459a(new C0039g());
    int f458a;
    float f459b;
    boolean f460c;

    public C0038f(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        this.f458a = parcel.readInt();
        this.f459b = parcel.readFloat();
        this.f460c = parcel.readByte() != (byte) 0;
    }

    public C0038f(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f458a);
        parcel.writeFloat(this.f459b);
        parcel.writeByte((byte) (this.f460c ? 1 : 0));
    }
}
