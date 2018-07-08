package android.support.v4.p006b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class C0090t implements Parcelable {
    public static final Creator CREATOR = new C0091u();
    final int[] f786a;
    final int f787b;
    final int f788c;
    final String f789d;
    final int f790e;
    final int f791f;
    final CharSequence f792g;
    final int f793h;
    final CharSequence f794i;
    final ArrayList f795j;
    final ArrayList f796k;

    public C0090t(Parcel parcel) {
        this.f786a = parcel.createIntArray();
        this.f787b = parcel.readInt();
        this.f788c = parcel.readInt();
        this.f789d = parcel.readString();
        this.f790e = parcel.readInt();
        this.f791f = parcel.readInt();
        this.f792g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f793h = parcel.readInt();
        this.f794i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f795j = parcel.createStringArrayList();
        this.f796k = parcel.createStringArrayList();
    }

    public C0090t(C0084n c0084n) {
        int i = 0;
        for (C0088r c0088r = c0084n.f737c; c0088r != null; c0088r = c0088r.f772a) {
            if (c0088r.f780i != null) {
                i += c0088r.f780i.size();
            }
        }
        this.f786a = new int[(i + (c0084n.f739e * 7))];
        if (c0084n.f746l) {
            i = 0;
            for (C0088r c0088r2 = c0084n.f737c; c0088r2 != null; c0088r2 = c0088r2.f772a) {
                int i2 = i + 1;
                this.f786a[i] = c0088r2.f774c;
                int i3 = i2 + 1;
                this.f786a[i2] = c0088r2.f775d != null ? c0088r2.f775d.f505p : -1;
                int i4 = i3 + 1;
                this.f786a[i3] = c0088r2.f776e;
                i2 = i4 + 1;
                this.f786a[i4] = c0088r2.f777f;
                i4 = i2 + 1;
                this.f786a[i2] = c0088r2.f778g;
                i2 = i4 + 1;
                this.f786a[i4] = c0088r2.f779h;
                if (c0088r2.f780i != null) {
                    int size = c0088r2.f780i.size();
                    i4 = i2 + 1;
                    this.f786a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f786a[i4] = ((C0051y) c0088r2.f780i.get(i2)).f505p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f786a[i2] = 0;
                }
            }
            this.f787b = c0084n.f744j;
            this.f788c = c0084n.f745k;
            this.f789d = c0084n.f748n;
            this.f790e = c0084n.f750p;
            this.f791f = c0084n.f751q;
            this.f792g = c0084n.f752r;
            this.f793h = c0084n.f753s;
            this.f794i = c0084n.f754t;
            this.f795j = c0084n.f755u;
            this.f796k = c0084n.f756v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0084n m1303a(am amVar) {
        C0084n c0084n = new C0084n(amVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f786a.length) {
            C0088r c0088r = new C0088r();
            int i3 = i2 + 1;
            c0088r.f774c = this.f786a[i2];
            if (am.f623a) {
                Log.v("FragmentManager", "Instantiate " + c0084n + " op #" + i + " base fragment #" + this.f786a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f786a[i3];
            if (i2 >= 0) {
                c0088r.f775d = (C0051y) amVar.f629f.get(i2);
            } else {
                c0088r.f775d = null;
            }
            i3 = i4 + 1;
            c0088r.f776e = this.f786a[i4];
            i4 = i3 + 1;
            c0088r.f777f = this.f786a[i3];
            i3 = i4 + 1;
            c0088r.f778g = this.f786a[i4];
            int i5 = i3 + 1;
            c0088r.f779h = this.f786a[i3];
            i4 = i5 + 1;
            int i6 = this.f786a[i5];
            if (i6 > 0) {
                c0088r.f780i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (am.f623a) {
                        Log.v("FragmentManager", "Instantiate " + c0084n + " set remove fragment #" + this.f786a[i4]);
                    }
                    i5 = i4 + 1;
                    c0088r.f780i.add((C0051y) amVar.f629f.get(this.f786a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0084n.m1296a(c0088r);
            i++;
            i2 = i4;
        }
        c0084n.f744j = this.f787b;
        c0084n.f745k = this.f788c;
        c0084n.f748n = this.f789d;
        c0084n.f750p = this.f790e;
        c0084n.f746l = true;
        c0084n.f751q = this.f791f;
        c0084n.f752r = this.f792g;
        c0084n.f753s = this.f793h;
        c0084n.f754t = this.f794i;
        c0084n.f755u = this.f795j;
        c0084n.f756v = this.f796k;
        c0084n.m1295a(1);
        return c0084n;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f786a);
        parcel.writeInt(this.f787b);
        parcel.writeInt(this.f788c);
        parcel.writeString(this.f789d);
        parcel.writeInt(this.f790e);
        parcel.writeInt(this.f791f);
        TextUtils.writeToParcel(this.f792g, parcel, 0);
        parcel.writeInt(this.f793h);
        TextUtils.writeToParcel(this.f794i, parcel, 0);
        parcel.writeStringList(this.f795j);
        parcel.writeStringList(this.f796k);
    }
}
