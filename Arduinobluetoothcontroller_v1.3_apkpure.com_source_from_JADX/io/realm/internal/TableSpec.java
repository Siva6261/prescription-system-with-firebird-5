package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.ArrayList;
import java.util.List;

@Keep
public class TableSpec {
    private List columnInfos = new ArrayList();

    protected void addColumn(int i, String str) {
        addColumn(RealmFieldType.fromNativeValue(i), str);
    }

    public void addColumn(RealmFieldType realmFieldType, String str) {
        if (str.length() > 63) {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        }
        this.columnInfos.add(new C0479v(realmFieldType, str));
    }

    public TableSpec addSubtableColumn(String str) {
        if (str.length() > 63) {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        }
        C0479v c0479v = new C0479v(RealmFieldType.UNSUPPORTED_TABLE, str);
        this.columnInfos.add(c0479v);
        return c0479v.f2968c;
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
        TableSpec tableSpec = (TableSpec) obj;
        return this.columnInfos == null ? tableSpec.columnInfos == null : this.columnInfos.equals(tableSpec.columnInfos);
    }

    public long getColumnCount() {
        return (long) this.columnInfos.size();
    }

    public long getColumnIndex(String str) {
        for (int i = 0; i < this.columnInfos.size(); i++) {
            if (((C0479v) this.columnInfos.get(i)).f2967b.equals(str)) {
                return (long) i;
            }
        }
        return -1;
    }

    public String getColumnName(long j) {
        return ((C0479v) this.columnInfos.get((int) j)).f2967b;
    }

    public RealmFieldType getColumnType(long j) {
        return ((C0479v) this.columnInfos.get((int) j)).f2966a;
    }

    public TableSpec getSubtableSpec(long j) {
        return ((C0479v) this.columnInfos.get((int) j)).f2968c;
    }

    public int hashCode() {
        return (this.columnInfos == null ? 0 : this.columnInfos.hashCode()) + 31;
    }
}
