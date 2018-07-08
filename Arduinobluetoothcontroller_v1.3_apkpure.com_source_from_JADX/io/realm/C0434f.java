package io.realm;

import io.realm.internal.C0428b;
import io.realm.internal.Table;
import java.util.HashMap;
import java.util.Map;

final class C0434f extends C0428b {
    public final long f2851a;
    public final long f2852b;
    public final long f2853c;
    public final long f2854d;
    public final long f2855e;
    public final long f2856f;
    public final long f2857g;
    public final long f2858h;
    public final long f2859i;
    public final long f2860j;
    public final long f2861k;
    public final long f2862l;
    public final long f2863m;

    C0434f(String str, Table table) {
        Map hashMap = new HashMap(13);
        this.f2851a = m5437a(str, table, "ControllerProfile", "currentlyUsed");
        hashMap.put("currentlyUsed", Long.valueOf(this.f2851a));
        this.f2852b = m5437a(str, table, "ControllerProfile", "profileId");
        hashMap.put("profileId", Long.valueOf(this.f2852b));
        this.f2853c = m5437a(str, table, "ControllerProfile", "profileName");
        hashMap.put("profileName", Long.valueOf(this.f2853c));
        this.f2854d = m5437a(str, table, "ControllerProfile", "leftArrow");
        hashMap.put("leftArrow", Long.valueOf(this.f2854d));
        this.f2855e = m5437a(str, table, "ControllerProfile", "rightArrow");
        hashMap.put("rightArrow", Long.valueOf(this.f2855e));
        this.f2856f = m5437a(str, table, "ControllerProfile", "upArrow");
        hashMap.put("upArrow", Long.valueOf(this.f2856f));
        this.f2857g = m5437a(str, table, "ControllerProfile", "downArrow");
        hashMap.put("downArrow", Long.valueOf(this.f2857g));
        this.f2858h = m5437a(str, table, "ControllerProfile", "selectButton");
        hashMap.put("selectButton", Long.valueOf(this.f2858h));
        this.f2859i = m5437a(str, table, "ControllerProfile", "startButton");
        hashMap.put("startButton", Long.valueOf(this.f2859i));
        this.f2860j = m5437a(str, table, "ControllerProfile", "leftButton");
        hashMap.put("leftButton", Long.valueOf(this.f2860j));
        this.f2861k = m5437a(str, table, "ControllerProfile", "rightButton");
        hashMap.put("rightButton", Long.valueOf(this.f2861k));
        this.f2862l = m5437a(str, table, "ControllerProfile", "upButton");
        hashMap.put("upButton", Long.valueOf(this.f2862l));
        this.f2863m = m5437a(str, table, "ControllerProfile", "downButton");
        hashMap.put("downButton", Long.valueOf(this.f2863m));
        m5439a(hashMap);
    }
}
