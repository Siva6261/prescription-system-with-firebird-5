package io.realm.internal;

import io.realm.RealmFieldType;

public class C0479v {
    protected final RealmFieldType f2966a;
    protected final String f2967b;
    protected final TableSpec f2968c;

    public C0479v(RealmFieldType realmFieldType, String str) {
        this.f2967b = str;
        this.f2966a = realmFieldType;
        this.f2968c = realmFieldType == RealmFieldType.UNSUPPORTED_TABLE ? new TableSpec() : null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0479v c0479v = (C0479v) obj;
        if (this.f2967b == null) {
            if (c0479v.f2967b != null) {
                return false;
            }
        } else if (!this.f2967b.equals(c0479v.f2967b)) {
            return false;
        }
        if (this.f2968c == null) {
            if (c0479v.f2968c != null) {
                return false;
            }
        } else if (!this.f2968c.equals(c0479v.f2968c)) {
            return false;
        }
        return this.f2966a == c0479v.f2966a;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f2968c == null ? 0 : this.f2968c.hashCode()) + (((this.f2967b == null ? 0 : this.f2967b.hashCode()) + 31) * 31)) * 31;
        if (this.f2966a != null) {
            i = this.f2966a.hashCode();
        }
        return hashCode + i;
    }
}
