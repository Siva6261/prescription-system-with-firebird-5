package io.realm;

import io.realm.internal.C0428b;
import io.realm.internal.Table;
import java.util.HashMap;
import java.util.Map;

final class ak extends C0428b {
    public final long f2839a;
    public final long f2840b;
    public final long f2841c;
    public final long f2842d;

    ak(String str, Table table) {
        Map hashMap = new HashMap(4);
        this.f2839a = m5437a(str, table, "SwitchProfile", "profileId");
        hashMap.put("profileId", Long.valueOf(this.f2839a));
        this.f2840b = m5437a(str, table, "SwitchProfile", "profileName");
        hashMap.put("profileName", Long.valueOf(this.f2840b));
        this.f2841c = m5437a(str, table, "SwitchProfile", "onCommand");
        hashMap.put("onCommand", Long.valueOf(this.f2841c));
        this.f2842d = m5437a(str, table, "SwitchProfile", "offCommand");
        hashMap.put("offCommand", Long.valueOf(this.f2842d));
        m5439a(hashMap);
    }
}
