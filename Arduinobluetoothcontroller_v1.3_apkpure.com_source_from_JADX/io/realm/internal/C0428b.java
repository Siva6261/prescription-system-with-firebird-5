package io.realm.internal;

import io.realm.exceptions.RealmMigrationNeededException;
import java.util.Collections;
import java.util.Map;

public class C0428b {
    private Map f2838a;

    protected final long m5437a(String str, Table table, String str2, String str3) {
        long a = table.m5536a(str3);
        if (a != -1) {
            return a;
        }
        throw new RealmMigrationNeededException(str, "Field '" + str3 + "' not found for type " + str2);
    }

    public Map m5438a() {
        return this.f2838a;
    }

    protected final void m5439a(Map map) {
        this.f2838a = Collections.unmodifiableMap(map);
    }
}
