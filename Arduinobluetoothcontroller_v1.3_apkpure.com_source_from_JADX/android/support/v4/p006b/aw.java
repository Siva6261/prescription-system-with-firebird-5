package android.support.v4.p006b;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class aw implements Parcelable {
    public static final Creator CREATOR = new ax();
    final String f664a;
    final int f665b;
    final boolean f666c;
    final int f667d;
    final int f668e;
    final String f669f;
    final boolean f670g;
    final boolean f671h;
    final Bundle f672i;
    Bundle f673j;
    C0051y f674k;

    public aw(Parcel parcel) {
        boolean z = true;
        this.f664a = parcel.readString();
        this.f665b = parcel.readInt();
        this.f666c = parcel.readInt() != 0;
        this.f667d = parcel.readInt();
        this.f668e = parcel.readInt();
        this.f669f = parcel.readString();
        this.f670g = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f671h = z;
        this.f672i = parcel.readBundle();
        this.f673j = parcel.readBundle();
    }

    public aw(C0051y c0051y) {
        this.f664a = c0051y.getClass().getName();
        this.f665b = c0051y.f505p;
        this.f666c = c0051y.f513x;
        this.f667d = c0051y.f479F;
        this.f668e = c0051y.f480G;
        this.f669f = c0051y.f481H;
        this.f670g = c0051y.f484K;
        this.f671h = c0051y.f483J;
        this.f672i = c0051y.f507r;
    }

    public C0051y m1133a(aj ajVar, C0051y c0051y) {
        if (this.f674k != null) {
            return this.f674k;
        }
        Context g = ajVar.m1000g();
        if (this.f672i != null) {
            this.f672i.setClassLoader(g.getClassLoader());
        }
        this.f674k = C0051y.m810a(g, this.f664a, this.f672i);
        if (this.f673j != null) {
            this.f673j.setClassLoader(g.getClassLoader());
            this.f674k.f503n = this.f673j;
        }
        this.f674k.m830a(this.f665b, c0051y);
        this.f674k.f513x = this.f666c;
        this.f674k.f515z = true;
        this.f674k.f479F = this.f667d;
        this.f674k.f480G = this.f668e;
        this.f674k.f481H = this.f669f;
        this.f674k.f484K = this.f670g;
        this.f674k.f483J = this.f671h;
        this.f674k.f475B = ajVar.f607d;
        if (am.f623a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f674k);
        }
        return this.f674k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f664a);
        parcel.writeInt(this.f665b);
        parcel.writeInt(this.f666c ? 1 : 0);
        parcel.writeInt(this.f667d);
        parcel.writeInt(this.f668e);
        parcel.writeString(this.f669f);
        parcel.writeInt(this.f670g ? 1 : 0);
        if (!this.f671h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f672i);
        parcel.writeBundle(this.f673j);
    }
}
