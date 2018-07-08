package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class fv implements Parcelable {
    public static final Creator CREATOR = new fw();
    int f2323a;
    int f2324b;
    int f2325c;
    int[] f2326d;
    int f2327e;
    int[] f2328f;
    List f2329g;
    boolean f2330h;
    boolean f2331i;
    boolean f2332j;

    fv(Parcel parcel) {
        boolean z = true;
        this.f2323a = parcel.readInt();
        this.f2324b = parcel.readInt();
        this.f2325c = parcel.readInt();
        if (this.f2325c > 0) {
            this.f2326d = new int[this.f2325c];
            parcel.readIntArray(this.f2326d);
        }
        this.f2327e = parcel.readInt();
        if (this.f2327e > 0) {
            this.f2328f = new int[this.f2327e];
            parcel.readIntArray(this.f2328f);
        }
        this.f2330h = parcel.readInt() == 1;
        this.f2331i = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f2332j = z;
        this.f2329g = parcel.readArrayList(ft.class.getClassLoader());
    }

    public fv(fv fvVar) {
        this.f2325c = fvVar.f2325c;
        this.f2323a = fvVar.f2323a;
        this.f2324b = fvVar.f2324b;
        this.f2326d = fvVar.f2326d;
        this.f2327e = fvVar.f2327e;
        this.f2328f = fvVar.f2328f;
        this.f2330h = fvVar.f2330h;
        this.f2331i = fvVar.f2331i;
        this.f2332j = fvVar.f2332j;
        this.f2329g = fvVar.f2329g;
    }

    void m4729a() {
        this.f2326d = null;
        this.f2325c = 0;
        this.f2327e = 0;
        this.f2328f = null;
        this.f2329g = null;
    }

    void m4730b() {
        this.f2326d = null;
        this.f2325c = 0;
        this.f2323a = -1;
        this.f2324b = -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.f2323a);
        parcel.writeInt(this.f2324b);
        parcel.writeInt(this.f2325c);
        if (this.f2325c > 0) {
            parcel.writeIntArray(this.f2326d);
        }
        parcel.writeInt(this.f2327e);
        if (this.f2327e > 0) {
            parcel.writeIntArray(this.f2328f);
        }
        parcel.writeInt(this.f2330h ? 1 : 0);
        parcel.writeInt(this.f2331i ? 1 : 0);
        if (!this.f2332j) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeList(this.f2329g);
    }
}
