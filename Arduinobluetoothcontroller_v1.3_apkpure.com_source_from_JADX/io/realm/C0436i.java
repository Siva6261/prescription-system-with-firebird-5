package io.realm;

import io.realm.internal.Table;
import java.util.Arrays;

public final class C0436i extends C0391z {
    private String f2864c;

    C0436i() {
    }

    public String[] m5487a() {
        String[] strArr = new String[((int) this.a.mo901a())];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = this.a.mo903a((long) i);
        }
        return strArr;
    }

    public String m5488b() {
        return ah.m5415a(this.a.mo907b());
    }

    protected Table b_() {
        return this.f2864c != null ? this.b.f2790g.m5420b(this.f2864c) : super.b_();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0436i c0436i = (C0436i) obj;
        String f = this.b.mo889f();
        String f2 = c0436i.b.mo889f();
        if (f != null) {
            if (!f.equals(f2)) {
                return false;
            }
        } else if (f2 != null) {
            return false;
        }
        f = this.a.mo907b().m5561k();
        f2 = c0436i.a.mo907b().m5561k();
        if (f != null) {
            if (!f.equals(f2)) {
                return false;
            }
        } else if (f2 != null) {
            return false;
        }
        if (this.a.mo908c() != c0436i.a.mo908c()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        String f = this.b.mo889f();
        String k = this.a.mo907b().m5561k();
        long c = this.a.mo908c();
        int hashCode = ((f != null ? f.hashCode() : 0) + 527) * 31;
        if (k != null) {
            i = k.hashCode();
        }
        return ((i + hashCode) * 31) + ((int) ((c >>> 32) ^ c));
    }

    public String toString() {
        if (this.a == null || !this.a.mo910d()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder(Table.m5524c(this.a.mo907b().m5561k()) + " = [");
        for (String str : m5487a()) {
            long a = this.a.mo902a(str);
            RealmFieldType b = this.a.mo906b(a);
            stringBuilder.append("{");
            stringBuilder.append(str).append(":");
            switch (C0480j.f2969a[b.ordinal()]) {
                case 1:
                    stringBuilder.append(this.a.mo919l(a) ? "null" : Boolean.valueOf(this.a.mo911d(a)));
                    break;
                case 2:
                    stringBuilder.append(this.a.mo919l(a) ? "null" : Long.valueOf(this.a.mo909c(a)));
                    break;
                case 3:
                    stringBuilder.append(this.a.mo919l(a) ? "null" : Float.valueOf(this.a.mo912e(a)));
                    break;
                case 4:
                    stringBuilder.append(this.a.mo919l(a) ? "null" : Double.valueOf(this.a.mo913f(a)));
                    break;
                case 5:
                    stringBuilder.append(this.a.mo915h(a));
                    break;
                case 6:
                    stringBuilder.append(Arrays.toString(this.a.mo916i(a)));
                    break;
                case 7:
                    stringBuilder.append(this.a.mo919l(a) ? "null" : this.a.mo914g(a));
                    break;
                case 8:
                    stringBuilder.append(this.a.mo917j(a) ? "null" : Table.m5524c(this.a.mo907b().m5554g(a).m5561k()));
                    break;
                case 9:
                    stringBuilder.append(String.format("RealmList<%s>[%s]", new Object[]{Table.m5524c(this.a.mo907b().m5554g(a).m5561k()), Long.valueOf(this.a.mo918k(a).m5498b())}));
                    break;
                default:
                    stringBuilder.append("?");
                    break;
            }
            stringBuilder.append("}, ");
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
